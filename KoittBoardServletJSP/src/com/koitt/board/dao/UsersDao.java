package com.koitt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.board.util.DBUtil;
import com.koitt.board.vo.Users;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class UsersDao {
	
	public List<Users> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT * FROM users ORDER BY NO DESC";	// 최근 가입순으로 정렬
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<Users> list = new ArrayList<Users>();
		while (rs.next()) {
			Users users = new Users();
			
			users.setEmail(rs.getString("email"));
			users.setName(rs.getString("name"));
			users.setNo(rs.getInt("no"));
			users.setPassword(rs.getString("password"));
			
			list.add(users);
		}
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
	
	public void insert(Users users) throws ClassNotFoundException, SQLException, MySQLIntegrityConstraintViolationException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO users (email, password, name) ");
		sql.append("VALUES (?, ?, ?)");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, users.getEmail());
		pstmt.setString(2, users.getPassword());
		pstmt.setString(3, users.getName());
		pstmt.executeUpdate();
		
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
	}
	
	public Users select(String email) throws ClassNotFoundException, SQLException {
		// 1. Connection 객체 가져옴
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성
		String sql = "SELECT * FROM users WHERE email = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 커서가 BOF(Begin of File)을 가리키고 있으므로 next 호출하여 다음 행으로 이동
		rs.next();
		
		// 6. users 객체 생성하여 ResultSet으로부터 값을 가져오기
		Users users = new Users();
		users.setEmail(rs.getString("email"));
		users.setName(rs.getString("name"));
		users.setNo(rs.getInt("no"));
		
		// 사용자 정보를 표시할 때 민감한 정보는 command로 보내지 않는다.
		//users.setPassword(rs.getString("password"));
		
		// 7. 객체 닫기
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 8. Command로 객체 전달
		return users;
	}
	
	/*
	 *  실제 테이블에 저장된 원본비밀번호를 외부에 노출시키지 않도록 하기위해
	 *  따로 SQL문을 작성하여 실행한다. (SQL문을 이용하여 비밀번호 비교)
	 */
	public boolean matches(String email, String password) throws ClassNotFoundException, SQLException {
		// 1. Connection 객체 가져옴
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성
		String sql = "SELECT no FROM users WHERE email = ? AND password = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 커서가 BOF(Begin of File)을 가리키고 있으므로 next 호출하여 다음 행으로 이동
		boolean isMatches = rs.next();
		
		// 7. 객체 닫기
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return isMatches;
	}
}







