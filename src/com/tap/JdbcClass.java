package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcClass {

	public static void main(String[] args) {

		
		
		String path = "C:\\Ecilipse\\jdbc\\src\\com\\tap\\utilities\\mysqlinfo.properties";

		Connection mycon = null;
		Statement mystmt = null;
		ResultSet res = null;
		FileInputStream fis = null;
		Properties p =null;
		
	
		
		try {
			
			 fis	 = new FileInputStream(path);
			 p = new Properties();
			 p.load(fis); 
			 
			String url =	p.getProperty("url");
			String username = 	p.getProperty("username");
			String password =	p.getProperty("password");
			
			 
		    Class.forName("com.mysql.cj.jdbc.Driver");
			mycon = DriverManager.getConnection(url, username, password);
			mystmt = mycon.createStatement();
			
			
			display(mystmt,res);
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		mycon = null;
		mystmt = null;
		res=null;
		
		close(mycon, mystmt, res);

	}



	public static void close(Connection mycon, Statement mystmt, ResultSet res) {
		try {
			if (mycon != null) {
				mycon.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (mystmt != null) {
				mystmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(res!=null) {
			res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void display(Statement mystmt,ResultSet res) {
		try {
			
			res = mystmt.executeQuery("SELECT  * FROM customer");
			while (res.next()) {
		System.out.println(res.getInt("id") + "   " + res.getString("name") + "    " + res.getInt("age") + "   "+res.getString("ADDRESS")
						+"    "+ res.getInt("salary")+"    "+res.getString("department")); 
		//		System.out.printf("%d  %s  %s  %-10d  \n",res.getInt("id"),res.getString("name"),res.getString("email"),res.getInt("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
