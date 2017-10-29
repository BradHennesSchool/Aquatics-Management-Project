package gui;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class AMS extends JPanel{	

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
	JButton send;
	
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
			
			send = new JButton();
			send.setText("Send");
			breaks.add(send);
		
		// Add tabs to frame
		f.add(t);
		
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

