package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import model.*;
import Aqua.*;


public class AMS extends JFrame implements ActionListener {

	
	public static void main(String[] args) 
	{
		ArrayList<Rotation> Rotations = new ArrayList<Rotation>();
		ArrayList<Guard> Guards = new ArrayList<Guard>();
		Position[] Pos = new Position[1];
		
		Pos[0] = new Position("Pos name");
		
		Rotations.add(new Rotation("Name", 18, Pos));
		
		GuardManager MainManager = new GuardManager(Guards, Rotations);
		
		AMS ui = new AMS(MainManager);
	}
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy | h:mm:ss a");

	// Component Arrays

	JPanel[] panels = new JPanel[9];
	JButton[] buttons = new JButton[9];
	JLabel[] timeLabels = new JLabel[9];
	JLabel[] rotationLabels = new JLabel[9];
	
	JPanel[] confirmationPanels = new JPanel[4];
	JLabel[] timeLabelsConfirmation = new JLabel[4];
	JLabel[] rotationLabelsConfirmation = new JLabel[4];
	JButton[] buttonsConfirmation = new JButton[4];
	JTextArea[] textBox = new JTextArea[4];

	// Components: Please keep these organized
	JFrame f;
	JTabbedPane t;

	JPanel timePanel;
	JLabel time;

	JPanel rotations;
	JPanel west;
	JPanel east;
	JPanel edit;
	JPanel information;
	JPanel confirmation;
	JButton replace;
	JButton find;
	JButton undo;

	JPanel daily;
	JButton all;
	JButton current;
	JButton later;
	JButton home;

	JPanel breaks;
	JPanel ctrl;
	JPanel sched;
	JComboBox sendwho;
	JButton send;
	JTable table;

	JPanel notifications;
	JLabel notificationLabel;
	GuardManager MainManager;

	public AMS(GuardManager main) {
		
		MainManager = main;

		// Create elements in component arrays
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			buttons[i] = new JButton();
			timeLabels[i] = new JLabel();
			rotationLabels[i] = new JLabel();
		}
		
		for (int i = 0; i < confirmationPanels.length; i++) {
			confirmationPanels[i] = new JPanel();
			timeLabelsConfirmation[i] = new JLabel();
			rotationLabelsConfirmation[i] = new JLabel();
			buttonsConfirmation[i] = new JButton();
			textBox[i] = new JTextArea();
		}

		// Create frame
		JFrame f = new JFrame("Aquatics Lifeguard Management System");
		f.setLayout(new BorderLayout());

		// Get screen resolution
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth()) / 2;
		int y = ((int) tk.getScreenSize().getHeight()) / 2;
		f.setSize(x, y);

		// Panel for time/date
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f.add(timePanel, BorderLayout.NORTH);

		// Update time and date
		time = new JLabel();
		timePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		timePanel.add(time);
		currentTime();
		new Timer(100, this).start();

		// Tab interface
		JTabbedPane t = new JTabbedPane();

		// Rotations Tab
		rotations = new JPanel();
		t.addTab("Rotations", rotations);
		
		// Split rotations down the middle
		rotations.setLayout(new GridLayout(1, 2));

		// Panes on the west and east sides of rotations
		west = new JPanel();
		east = new JPanel();

		rotations.add(west, BorderLayout.WEST);
		rotations.add(east, BorderLayout.EAST);
		

		// Edit panel for Find/Replace/Undo
		edit = new JPanel();
		//edit.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		west.add(edit, BorderLayout.NORTH);

		// Find/Replace/Undo buttons
		replace = new JButton();
		find = new JButton();
		undo = new JButton();

		replace.setText("Replace");
		find.setText("Find");
		undo.setText("Undo");

		edit.add(find);
		edit.add(replace);
		edit.add(undo);

		information = new JPanel();
		information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
		//information.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		west.add(information);

		// Rotation labels / panels / buttons
		for (int i = 0; i < panels.length; i++) {

			// add panels
			information.add(panels[i]);

			// add components to panels
			panels[i].add(timeLabels[i]);
			panels[i].add(rotationLabels[i]);
			panels[i].add(buttons[i]);

			// set text (debugging)
			timeLabels[i].setText("Time " + i);
			rotationLabels[i].setText("Rotations " + i);
			buttons[i].setText("Buttons " + i);

			panels[i].setVisible(true);

		}
		
		// Confirmation panel for pushing rotations
		confirmation = new JPanel();
		confirmation.setLayout(new BoxLayout(confirmation, BoxLayout.Y_AXIS));
		//confirmation.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		east.add(confirmation);
		
		// Confirmation labels / panels / text boxes / buttons
		
		for (int i = 0; i < confirmationPanels.length; i++) {
			
			// add panels
			confirmation.add(confirmationPanels[i]);
			
			// add components to panels
			confirmationPanels[i].add(timeLabelsConfirmation[i]);
			confirmationPanels[i].add(rotationLabelsConfirmation[i]);
			confirmationPanels[i].add(buttonsConfirmation[i]);
			confirmationPanels[i].add(textBox[i]);
			
			// set text (debugging)
			timeLabelsConfirmation[i].setText("Time " + i);
			rotationLabelsConfirmation[i].setText("Rotations " + i);
			buttonsConfirmation[i].setText("Buttons " + i);
			textBox[i].setText("Text Box " + i);
		}
		

		// Daily Tab
		daily = new JPanel();
		t.addTab("Daily", daily);

		
		
		//Table   
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	      } catch(ClassNotFoundException e) {
	         System.out.println("Class not found "+ e);
	      }
	      try {
	    	
	         Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/","root", "1111");
	         
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM Algae.ScheduleWork");
	         
	         DefaultTableModel uitable = new DefaultTableModel(new String[]{"Name", "Day", "In", "Out"}, 0);
       
	         while (rs.next()) {
	            String name = rs.getString("G_name");
	            String day = rs.getString("Sch_day");
	            String in = rs.getString("Sch_in_time");
	            String out = rs.getString("Sch_out_time");
	            
	            uitable.addRow(new Object[]{name, day, in, out});

	            JTable jtbl = new JTable(uitable);
	            JScrollPane tbl = new JScrollPane(jtbl);
	            daily.add(tbl);

	         }
	      } catch(SQLException e) {
	         System.out.println("SQL exception occured" + e);
	      }

		// Breaks Tab
		breaks = new JPanel();
		t.addTab("Breaks", breaks);

		ctrl = new JPanel();
		sched = new JPanel();
		breaks.add(ctrl, BorderLayout.NORTH);
		breaks.add(sched, BorderLayout.SOUTH);

		
		sendwho = new JComboBox(updateBreaksdd());
		sendwho.setPreferredSize(new Dimension(140, 22));
		
		ctrl.add(sendwho);

		send = new JButton();
		send.setText("Send");
		ctrl.add(send);


		// Notification Panel
		notifications = new JPanel();
		notifications.setBackground(Color.gray);
		notifications.setPreferredSize(new Dimension(x / 4, y));

		notificationLabel = new JLabel();
		notificationLabel.setText("Notifications");
		notificationLabel.setFont(new Font("Garamond", Font.PLAIN, x / 50));

		notifications.add(notificationLabel, BorderLayout.NORTH);

		// Add tabbed interface and notification panel to f
		f.add(t);
		f.add(notifications, BorderLayout.EAST);

		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		currentTime();
		
		 if (e.getSource() instanceof JButton) {
	            JButton clickedButton = (JButton) e.getSource();
	            
	            System.out.println("Button pressed");
	            
	            if (clickedButton == send) 
	            {
	            	System.out.println(sendwho.getSelectedItem());
	            }
		 }
	}

	// Updates JLabel time
	public void currentTime() {
		time.setText(dateFormat.format(Calendar.getInstance().getTime()));
	}
	
	public String[] updateBreaksdd()
	{
		ArrayList<String> Guards = MainManager.getGuard2(false, new String[]{"ready"});
		String[] GuardArray = new String[Guards.size()];
		int i = 0;
		for(String s: Guards)
		{
			GuardArray[i] = s;
			++i;
		}
		
		return GuardArray;
	}
}
