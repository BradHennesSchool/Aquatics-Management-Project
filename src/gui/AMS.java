package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private SimpleDateFormat rotFormat = new SimpleDateFormat("h:mm:ss");

	// Component Arrays

	JPanel[] panels = new JPanel[4];
	JButton[] buttons = new JButton[4];
	JLabel[] timeLabels = new JLabel[4];
	JLabel[] rotationLabels = new JLabel[4];
	
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
	JComboBox sendwho = new JComboBox();
	JButton send;
	JComboBox onbreak = new JComboBox();
	JComboBox maindd = new JComboBox();
	JButton onB;
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

		t.addChangeListener
		(
			new ChangeListener() 
			{
				public void stateChanged(ChangeEvent c) 
				{		
					sendwho.removeAllItems();
	            	onbreak.removeAllItems();
	            	maindd.removeAllItems();
	            	
	            	for(String lg: mainGuarddd())
	            		maindd.addItem(lg);
	            	
	            	for(String lg: updateBreaksdd())
	            		sendwho.addItem(lg);
	            	
	            	for(String lg: onBreaksdd())
	            		onbreak.addItem(lg);
				}
			}
		);
		
		// Rotations Tab
		rotations = new JPanel();
		t.addTab("Rotations", rotations);
		
		// Split rotations down the middle
		rotations.setLayout(new GridLayout(1, 2));

		// Panes on the west and east sides of rotations
		west = new JPanel();
		east = new JPanel();

		rotations.add(west, BorderLayout.WEST);
		
		

		information = new JPanel();
		information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
		//information.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		west.add(information);
		maindd = new JComboBox(mainGuarddd());
		maindd.setPreferredSize(new Dimension(140, 22));
		
		information.add(maindd);

		
		// Rotation labels / panels / buttons
		for (int i = 0; i < panels.length; i++) {

			// add panels
			information.add(panels[i]);

			// add components to panels
			panels[i].add(timeLabels[i]);
			panels[i].add(rotationLabels[i]);
			panels[i].add(buttons[i]);
			panels[i].add(rotationLabelsConfirmation[i]);
			panels[i].add(buttonsConfirmation[i]);

			// set text (debugging)
			timeLabels[i].setText(retCurrentTime());
			rotationLabels[i].setText("Rotation " + (i + 1));
			buttons[i].setText("Push");
			buttons[i].addActionListener(this);
			rotationLabelsConfirmation[i].setText("Not pushing");
			buttonsConfirmation[i].setText("Confirm Rotation");
			buttonsConfirmation[i].addActionListener(this);
			
			
			panels[i].setVisible(true);
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
		send.addActionListener(this);
		ctrl.add(send);
		
		onbreak = new JComboBox(onBreaksdd());
		onbreak.setPreferredSize(new Dimension(140, 22));
		ctrl.add(onbreak);
		
		onB = new JButton();
		onB.setText("On Break");
		onB.addActionListener(this);
		ctrl.add(onB);


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
	public void actionPerformed(ActionEvent e) 
	{
		currentTime();
		
		
		 if (e.getSource() instanceof JButton) 
		 {
            JButton clickedButton = (JButton) e.getSource();
            
            System.out.println("Button pressed");
            
            if (clickedButton == send) 
            {
            	String guard = sendwho.getSelectedItem().toString();
            	MainManager.SendGuardToBreak(guard);
            	sendwho.removeAllItems();
            	onbreak.removeAllItems();
            	
            	for(String lg: updateBreaksdd())
            		sendwho.addItem(lg);
            	
            	for(String lg: onBreaksdd())
            		onbreak.addItem(lg);
            }
            
            if (clickedButton == onB) 
            {
            	String guard = onbreak.getSelectedItem().toString();
            	MainManager.ConfirmGuardBackFromBreak(guard);
            	sendwho.removeAllItems();
            	onbreak.removeAllItems();
            	
            	for(String lg: updateBreaksdd())
            		sendwho.addItem(lg);
            	
            	for(String lg: onBreaksdd())
            		onbreak.addItem(lg);
            }
            
            for(int i = 0; i < 4; ++i)
            {
            	if(clickedButton.equals(buttons[i]))
            	{
            		Rotation rot = MainManager.GetRotation("Rotation " + (i + 1));
            		
            		if(!rot.pushing)
            		{
            			rot.pushing = true;
            			String fname = maindd.getSelectedItem().toString().split(" ")[0];
            			String lname = maindd.getSelectedItem().toString().split(" ")[1];
            			Guard lg = MainManager.GetGuard(fname, lname);
            			//lg.setStatus("on rotation");
            			Guard retG = rot.Push(lg);
            			
            			rotationLabelsConfirmation[i].setText(retG.getName() + " returning");
            			
            			timeLabels[i].setText(retCurrentTime());
            			
            			maindd.removeAllItems();
                    	
                    	for(String updatedGuards: mainGuarddd())
                    		maindd.addItem(updatedGuards);
            		}
            	}
            	
            	if(clickedButton.equals(buttonsConfirmation[i]))
            	{
            		Rotation rot = MainManager.GetRotation("Rotation " + (i + 1));
            		
            		if(rot.pushing)
            		{
            			rot.pushing = false;
            			
            			String fname = rotationLabelsConfirmation[i].getText().split(" ")[0];
            			String lname = rotationLabelsConfirmation[i].getText().split(" ")[1];
            			Guard lg = MainManager.GetGuard(fname, lname);
            			
            			MainManager.ConfirmRotationPushed(lg, rot);
            			
            			rotationLabelsConfirmation[i].setText("Not Pushing");
            			
						maindd.removeAllItems();
                    	
                    	for(String updatedGuards: mainGuarddd())
                    		maindd.addItem(updatedGuards);
            		}
            	}
            }
		 }
	}

	// Updates JLabel time
	public void currentTime() {
		time.setText(dateFormat.format(Calendar.getInstance().getTime()));
	}
	
	public String retCurrentTime() {
		return rotFormat.format(Calendar.getInstance().getTime());
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
	
	public String[] onBreaksdd()
	{
		ArrayList<String> Guards = MainManager.getGuard2(false, new String[]{"on break"});
		String[] GuardArray = new String[Guards.size()];
		int i = 0;
		for(String s: Guards)
		{
			GuardArray[i] = s;
			++i;
		}
		
		return GuardArray;
	}
	
	public String[] mainGuarddd()
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
