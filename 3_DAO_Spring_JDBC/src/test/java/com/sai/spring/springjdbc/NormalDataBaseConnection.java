package com.sai.spring.springjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NormalDataBaseConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// JDBC code

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springjdbc";
		String username = "root";
		String password = "root";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			int experiance = rs.getInt(3);

			// Business Login

			if (experiance >= 15) {

				System.out.println("Employee " + name + " with Experiance " + experiance + " ==> Got 30 % hike !!\n");
			}

			else if (experiance >= 10) {
				System.out.println("Employee " + name + " with Experiance " + experiance + " ==> Got 20 % hike !!\n");
			}

			else if (experiance >= 5) {
				System.out.println("Employee " + name + " with Experiance " + experiance + " ==> Got 15 % hike !!\n");
			}

			else {
				System.out.println("Employee " + name + " with Experiance " + experiance + " ==> Got 10 % hike !!\n");
			}

		}
		con.close();
	}
	
}
