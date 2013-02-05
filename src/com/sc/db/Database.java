package com.sc.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sc.main.Vis;

public class Database {
	public static DISPLAY display;
	private final String projectname = "Barcharts";

	public Database(){
		display = DISPLAY.MAJORS;
	}
	public void query(){
		ResultSet r = null;
		try {
			// Test Connection
			String path = new File("").getAbsolutePath();
			path += "/" + projectname +".app/Contents/db";
			Connection conn = DriverManager.getConnection("jdbc:derby:"+path);
			System.out.println("Database Connected");
			Statement s = conn.createStatement();
			switch (display) {
			case MAJORS:
				r = s.executeQuery("Select distinct(major), count(major) From graduate group by major");
				break;
			case HOME:
				r = s.executeQuery("Select distinct(home_area), count(home_area) From graduate group by home_area");
				break;
			case GPA:
				r = s.executeQuery("Select distinct(major), avg(gpa) From graduate group by major");
				break;
			case CREDITS_ATTEMPTED:
				r = s.executeQuery("Select distinct(grad_year), avg(credits_attempted) From graduate group by grad_year");
				break;
			case CREDITS_PASSED:
				r = s.executeQuery("Select distinct(grad_year), avg(credits_passed) From graduate group by grad_year");
				break;
			case GRAD_YEAR:
				r = s.executeQuery("Select distinct(grad_year), count(grad_year) From graduate group by grad_year");
				break;
			default:
				break;
			}
			ArrayList<String> categories = new ArrayList<String>();
			ArrayList<Float> values = new ArrayList<Float>();
			while(r.next()){
				categories.add(r.getString(1));
				values.add(r.getFloat(2));
			}
			Vis.graph.setData(categories, values);
		}catch(SQLException e){
			System.out.println("ERROR:::Database didn't connect");
		}

	}

}
