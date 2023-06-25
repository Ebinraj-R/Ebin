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

public class Program_2 {

	public static void main(String srgs[]) {

		Properties p = null;
		FileInputStream fis = null;
		Connection mycon = null;
		Statement mystmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			fis = new FileInputStream("C:\\Ecilipse\\jdbc\\src\\com\\tap\\utilities\\mysqlinfo.properties");
			p = new Properties();
			p.load(fis);

			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");

			mycon = DriverManager.getConnection(url, username, password);

			mystmt = mycon.createStatement();

			System.out.println("Before Updation");
			display(mystmt, res);

			// String sql = "UPDATE `customer` SET `salary`= `salary`+ 5000 WHERE
			// `department` = 'DESIGN' ";

//		    String sql = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (8,'EBIN',24,'COIMBATORE',25000,'IT' )"   ;

//		    String sql1 = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (9,'ELENGESHAN',24,'COIMBATORE',45000,'DESIGN' )";
//		    String sql2 = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (10,'VIGNESH',25,'COIMBATORE',52000,'IT' )"  ;
//		    String sql3 = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (11,'ABISH',24,'KANNIYAKUMARI',38000,'MEDICAL' )";
//		    String sql4 = "INSERT INTO `customer`  (`id`,`name`,`age`,`ADDRESS`,`salary`,`department`) VALUES (12,'SURYA',24,'COIMBATORE',55000,'IT' )"  ;
//		    
//		    mystmt.addBatch(sql1);
//		    mystmt.addBatch(sql2);
//		    mystmt.addBatch(sql3);
//		    mystmt.addBatch(sql4);
//		    
//		    mystmt.executeBatch();
//		    System.out.println("After Updation");
//		    
//		    display(mystmt,res);
//					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(res, mystmt, mycon, fis);
		}

	}

	public static void close(ResultSet res, Statement mystmt, Connection mycon, FileInputStream fis) {
		try {
			if (res != null)
				res.close();
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
			// System.out.println(res.getInt("id") + " " + res.getString("name") + " " +
			// res.getInt("age") + " "
			// + res.getString("ADDRESS") + " " + res.getInt("salary") + " " +
			// res.getString("department"));
			System.out.printf("%d  %s  %d  %s  %-10d  %s \n", res.getInt("id"), res.getString("name"),
					res.getInt("age"), res.getString("ADDRESS"), res.getInt("salary"), res.getString("department"));
		}
	}

}
