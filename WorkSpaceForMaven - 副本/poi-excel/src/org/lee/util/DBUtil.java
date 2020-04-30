package org.lee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static String driver;
	static String username;
	static String pwd;
	static String url;

	static {

		try {
			ClassLoader classLoader = DBUtil.class.getClassLoader();

			InputStream is = classLoader.getResourceAsStream("config/props/db.properties");

			// System.out.println(is.available());

			Properties props = new Properties();
			props.load(is);

			url = props.getProperty("url");
			username = props.getProperty("user");
			pwd = props.getProperty("password");
			driver = props.getProperty("driver");

			Class.forName(driver);
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = (Connection) DriverManager.getConnection(url, username, pwd);
		if (conn == null) {
			System.out.println("Failed to connect database...");
		} else {
			System.out.println("database connected successful...");
		}
		return conn;

	}

	public static void release(ResultSet rs, PreparedStatement sta, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Resource release successful...");
	}

	public static void release(PreparedStatement sta, Connection conn) {
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Resource release successful...");
	}

}