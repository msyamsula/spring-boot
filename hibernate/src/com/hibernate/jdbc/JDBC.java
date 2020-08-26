package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {

	public static void main(String[] args) {
		
		String basicUri = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String additionalUri = "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; // for time zone error
		String uri = basicUri+additionalUri;
		String user = "syamsul", password = "syamsul";
		
		try {
			System.out.println("Connecting to database");
			Connection conn = DriverManager.getConnection(uri, user, password); // connect to database
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
