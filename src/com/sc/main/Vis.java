package com.sc.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;


import javax.swing.JPanel;

import com.sc.db.DISPLAY;


public class Vis extends JPanel {
	public static Graph graph;
	private int paddingWidth = 5;
	private int paddingHeight = 100;
	public static Point maxWidthAndMaxHeight = new Point();
	
	
	
	public Vis() {
		super();
		graph = new Graph();
		Graph.usableWidth = ((int) ((maxWidthAndMaxHeight.x - ((graph.getNumberOfBars()+1) * paddingWidth))) - 50  );
		Graph.usableHeight = ((int) (maxWidthAndMaxHeight.y - (paddingHeight * 2)));
		
		
	}

	@Override
	public void paintComponent(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		int x = paddingWidth;
		for(Bar b: graph.getBars()){
			g.setColor(Color.BLUE);
			g.fillRect(x, (maxWidthAndMaxHeight.y - paddingHeight) - b.getHeight(), b.getWidth(), b.getHeight());
			g.setColor(Color.black);
			g.drawString(b.getCategory(), x, (maxWidthAndMaxHeight.y - paddingHeight) + 15);
			g.drawString(""+b.getValue(), x, (maxWidthAndMaxHeight.y - paddingHeight) - b.getHeight() - 15);
			x += paddingWidth + b.getWidth();
		}

		//render visualization
		g.setColor(Color.BLACK);
		
		//System.out.println("Graph: " + graph.toString());
	}

}
