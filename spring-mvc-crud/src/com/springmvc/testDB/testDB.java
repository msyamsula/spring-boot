package com.springmvc.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class testDB
 */
@WebServlet("/testDB")
public class testDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testDB() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set username, password, and uri db
		String user = "syamsul", password = "syamsul", uri = "jdbc:mysql://localhost:3306/hibernate?useSSL=false&amp&serverTimezone=UTC";
		
		// set driver
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		// test connection to db
		try {
			// boiler plate
			PrintWriter out = response.getWriter();
			out.println("connecting to db: " + uri);
			Class.forName(driver);
			
			// test connection
			Connection conn = DriverManager.getConnection(uri, user, password);
			out.println("success");
			
			// close connection
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
