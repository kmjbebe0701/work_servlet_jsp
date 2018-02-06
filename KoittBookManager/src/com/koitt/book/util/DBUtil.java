package com.koitt.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	private static DBUtil instance;
	
private DBUtil() {}
	
	// 3. 외부에서 DBUtil 객체를 사용하기 위한 메소드 (캡슐화)
	public static DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}
	// End of 싱글턴 패턴 만들기
	
	// 데이터베이스 커넥션 객체 가져오는 메소드
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306";
		String dbName = "bookmgr";
		
		// 1. 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. 데이터베이스 연결
		Connection conn = DriverManager.getConnection(url + "/" + dbName, "root", "koitt");
		
		return conn;
	}
	
	// Connection 객체 연결 해제
	public void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	// Statement(PreparedStatement 포함) 객체 연결 해제
	public void close(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}
	
	// ResultSet 객체 연결 해제
	public void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
	
	// Rollback 메소드
	public void rollback(Connection conn) throws SQLException {
		if (conn != null) {
			conn.rollback();
		}
	}
}
