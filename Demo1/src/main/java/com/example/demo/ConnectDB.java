package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConnectDB {

	@Autowired
	@Qualifier("DBConnection")
	private Connection conn;

	public void connectDB() {
		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM ACCOUNT";

		try {
			//PostgreSQLへ接続
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			//実行結果取り出し
			while(rset.next()) {
				System.out.println(rset.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
