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

public class Program_1 {

	public static void main(String[] args) {

		
        ResultSet res = null;
		Statement mystmt = null;
		Connection mycon = null;
		FileInputStream fis = null;
		Properties p =null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			 fis = new FileInputStream("C:\\Ecilipse\\jdbc\\src\\com\\tap\\utilities\\mysqlinfo.properties ");
			 p = new Properties();
			p.load(fis);
			

			String url = p.getProperty("url");
			 String username = p.getProperty("username");
			String password = p.getProperty("password");

			mycon = DriverManager.getConnection(url, username, password);

			mystmt = mycon.createStatement();

			display(mystmt, res);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		finally {
			close(res, mystmt, mycon);

		}

	}

	public static void display(Statement mystmt, ResultSet res) throws SQLException {

		res = mystmt.executeQuery("SELECT * FROM `customer`");

		while (res.next()) {
			System.out.println(res.getInt("id") + "   " + res.getString("name") + "    " + res.getInt("age") + "   "
					+ res.getString("ADDRESS") + "    " + res.getInt("salary") + "    " + res.getString("department"));
			// System.out.printf("%d %s %s %-10d
			// \n",res.getInt("id"),res.getString("name"),res.getString("email"),res.getInt("salary"));
		}

	}

	public static void close(ResultSet res, Statement mystmt, Connection mycon) {
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (mystmt != null) {
				mystmt.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (mycon != null) {
				mycon.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
