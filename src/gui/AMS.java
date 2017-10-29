package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AMS extends JFrame{	

	// Please keep these organized
	
	JFrame f;
	JTabbedPane t;
	
	JPanel rotations;
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
	
	
	public static void main (String[] args) {

		AMS AMS = new AMS();
		
	}
	
	public AMS() {
		
		JFrame f = new JFrame("Aquatics Management System");
		f.setLayout(new BorderLayout());
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth());
		int y = ((int) tk.getScreenSize().getHeight());
		f.setSize(x, y);
		
		JTabbedPane t = new JTabbedPane();
		
		// Rotations Tab
			rotations = new JPanel();
			t.addTab("Rotations", rotations);
			
			replace = new JButton();
			replace.setText("Replace");
			rotations.add(replace);
			
			find = new JButton();
			find.setText("Find");
			rotations.add(find);
			
			undo = new JButton();
			undo.setText("Undo");
			rotations.add(undo);
		
		// Daily Tab
			daily = new JPanel();
			t.addTab("Daily", daily);
			
			all = new JButton();
			all.setText("All");
			daily.add(all);
			
			current = new JButton();
			current.setText("Current");
			daily.add(current);	
			
			later = new JButton();
			later.setText("Later");
			daily.add(later);
			
			home = new JButton();
			home.setText("Home");
			daily.add(home);
			
		// Breaks Tab
			breaks = new JPanel();
			t.addTab("Breaks", breaks);
			
			ctrl = new JPanel();
			sched = new JPanel();
			breaks.add(ctrl, BorderLayout.NORTH);
			breaks.add(sched, BorderLayout.SOUTH);
			
			String[] guards = {"Brad", "Hannah", "Jean", "Kevin", "Quinn"};
			sendwho = new JComboBox(guards);
			sendwho.setPreferredSize(new Dimension(140, 22));
			ctrl.add(sendwho);
			
			send = new JButton();
			send.setText("Send");
			ctrl.add(send);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"...", "Break"
				}
			));
			sched.add(table);
			
		// Notification Panel
			notifications = new JPanel();
			notifications.setBackground(Color.gray);
			notifications.setPreferredSize(new Dimension(x/4, y));
			
			notificationLabel = new JLabel();
			notificationLabel.setText("Notifications");
			notificationLabel.setFont(new Font("Garamond", Font.PLAIN, x/50));
			
			notifications.add(notificationLabel, BorderLayout.NORTH);
			
			
		// Add tabs to frame
		f.add(t);
		f.add(notifications, BorderLayout.EAST);
		
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

