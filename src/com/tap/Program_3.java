package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Program_3 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		Properties p = null;
		Connection mycon = null;
		Statement mystmt = null;
		ResultSet res = null;
		ResultSet res1 = null;
		PreparedStatement pstmt = null;
		int count = 0;
		String choice;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			fis = new FileInputStream("C:\\Ecilipse\\jdbc\\src\\com\\tap\\utilities\\mysqlinfo.properties");
			p = new Properties();
			p.load(fis);

			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");

			mycon = DriverManager.getConnection(url, username, password);

			System.out.println("Before Updation");
			mystmt = mycon.createStatement();
			display(mystmt, res);

			res1 = mystmt.executeQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1;");
			if (res1.next()) {
				count = res1.getInt("id");
			}

			String sql = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (?,?,?,?,?,?)";

			Scanner scan = new Scanner(System.in);

			do {
				
				System.out.println();
					
				System.out.println("Enter the below details...");
				
				System.out.println();
				
				System.out.println("NAME : ");
				String name = scan.next();
				System.out.println("AGE : ");
				int age = scan.nextInt();
				System.out.println("ADDRESS : ");
				String ADDRESS = scan.next();
				System.out.println("SALARY : ");
				int salary = scan.nextInt();
				System.out.println("DEPARTMENT : ");
				String department = scan.next();

				pstmt = mycon.prepareStatement(sql);

				pstmt.setInt(1, ++count);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, ADDRESS);
				pstmt.setInt(5, salary);
				pstmt.setString(6, department);

				pstmt.addBatch();

				System.out.println("Do you want to add next person details ?_ _ _(yes/no) ");
				choice = scan.next();

			} while (choice.equalsIgnoreCase("yes"));

			pstmt.executeBatch();

			System.out.println("After Updation");
			display(mystmt, res);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(res, pstmt, mystmt, mycon, fis);
		}

	}

	public static void close(ResultSet res, PreparedStatement pstmt, Statement mystmt, Connection mycon,
			FileInputStream fis) {
		
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (pstmt != null) {
				pstmt.close();
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
			if (mycon != null) {
				mycon.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (fis != null) {
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void display(Statement mystmt, ResultSet res) throws SQLException {

		res = mystmt.executeQuery("SELECT * FROM `customer`");

		while (res.next()) {

			System.out.printf("%-2d  %-14s  %-5d  %-15s  %-10d  %-2s \n", res.getInt("id"), res.getString("name"),
					res.getInt("age"), res.getString("ADDRESS"), res.getInt("salary"), res.getString("department"));
		}
	}

}
