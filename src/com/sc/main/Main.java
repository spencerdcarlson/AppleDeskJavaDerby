package com.sc.main;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.sc.db.DISPLAY;
import com.sc.db.Database;



public class Main extends JFrame implements ActionListener {

	private Vis mainPanel;
	private static final String M = "MAJORS";
	private static final String H = "HOME";
	private static final String G = "GPA";
	private static final String A = "CREDITS ATTEMPTED";
	private static final String P = "CREDITS PASSED";
	private static final String Y = "GRAD YEAR";
	private Database db;
	private Point widthAndHeight = new Point(800,600);


	public Main() {
		setPreferredSize(new Dimension(widthAndHeight.x,widthAndHeight.y));
		Vis.maxWidthAndMaxHeight = widthAndHeight;
		
		JMenuBar mb = setupMenu();
		setJMenuBar(mb);

		mainPanel = new Vis();
		setContentPane(mainPanel);
		db = new Database();
		db.query();
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Graduation Data Set");
		pack();
		setVisible(true);
	}
	
	private JMenuBar setupMenu() {
		//instantiate menubar, menus, and menu options
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem majors = new JMenuItem("Majors");
		JMenuItem home = new JMenuItem("Home");
		JMenuItem gpa = new JMenuItem("GPA");
		JMenuItem attempted = new JMenuItem("Credits Attempted");
		JMenuItem passed = new JMenuItem("Credits Passed");
		JMenuItem year = new JMenuItem("Graduation Year");

		
		//no hook them all together

		fileMenu.add(majors);
		fileMenu.add(home);
		fileMenu.add(gpa);
		fileMenu.add(attempted);
		fileMenu.add(passed);
		fileMenu.add(year);
		menuBar.add(fileMenu);

		//setup action listeners
		majors.setActionCommand(M);
		majors.addActionListener(this);
		home.setActionCommand(H);
		home.addActionListener(this);
		gpa.setActionCommand(G);
		gpa.addActionListener(this);
		attempted.setActionCommand(A);
		attempted.addActionListener(this);
		passed.setActionCommand(P);
		passed.addActionListener(this);
		year.setActionCommand(Y);
		year.addActionListener(this);
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals(M)) {
			// Majors
			Database.display = DISPLAY.MAJORS;
			
		}
		if (command.equals(H)) {
			// Home
			Database.display = DISPLAY.HOME;
		}
		if (command.equals(G)) {
			// GPA
			Database.display = DISPLAY.GPA;
			
		}
		if (command.equals(A)) {
			// Attempted
			Database.display = DISPLAY.CREDITS_ATTEMPTED;
			
		}
		if (command.equals(P)) {
			// Passed
			Database.display = DISPLAY.CREDITS_PASSED;
			
		}
		if (command.equals(Y)) {
			// Year
			Database.display = DISPLAY.GRAD_YEAR;
		}
		//System.out.println("Action Event Command: " + command);
		db.query();
		mainPanel.repaint();
	}
	
	public static void main(String[] args) {
		//this makes the GUI adopt the look-n-feel of the windowing system (Windows/X/Mac)
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}
}
