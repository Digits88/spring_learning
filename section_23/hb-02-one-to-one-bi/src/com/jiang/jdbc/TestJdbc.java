package com.jiang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "jiang";
		String passwd = "1";
		
		try {
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, passwd);
			System.out.println("Connection success!");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
