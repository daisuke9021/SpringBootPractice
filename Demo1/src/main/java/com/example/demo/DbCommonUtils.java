package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCommonUtils {

	//ロック用オブジェクト
	private static final Object LOCK_OBJ = new Object();

	//コネクション
	private static Connection CONN = null;

	public static boolean createConnection() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "postgres";

		boolean result = true;

		try {
			CONN = DriverManager.getConnection(url, user, password);
			CONN.setAutoCommit(true);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public static boolean closeConnection() {
		boolean result = true;

		if(CONN != null) {
			try {
				CONN.close();
			} catch (SQLException e) {
				result = false;
				e.printStackTrace();
			}
		} else {
			result = false;
		}

		return result;
	}

	public static Connection getConnection() {
		//コネクションを同時に使えるのは１スレッドまで
		synchronized(LOCK_OBJ) {
			return CONN;
		}
	}

}
