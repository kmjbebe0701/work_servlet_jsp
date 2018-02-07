package com.koitt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.board.util.DBUtil;
import com.koitt.board.vo.Board;

public class BoardDao {
	
	public List<Board> selectAll() throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (글 번호 내림차순 정렬, 최신글 우선)
		String sql = "SELECT * FROM board ORDER BY no DESC";
		
		// 3. PreparedStatement 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ResultSet 객체를 이용하여 게시물 값들을 가져온 뒤 Board 객체에 저장
		List<Board> list = new ArrayList<Board>();
		while (rs.next()) {
			Board board = new Board();
			
			board.setContent(rs.getString("content"));
			board.setNo(rs.getInt("no"));
			board.setRegdate(rs.getDate("regdate"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			
			// 글 하나에 해당하는 Board 객체를 리스트에 저장
			list.add(board);
		}
		
		// 6. 객체 해제
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
	
	// no에 해당하는 글 하나 가져오는 기능
	public Board select(Integer no) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (글 번호 내림차순 정렬, 최신글 우선)
		String sql = "SELECT * FROM board WHERE no = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ResultSet 객체를 이용하여 게시물 값들을 가져온 뒤 Board 객체에 저장
		/*
		 *  처음에 Cursor가 BOF(Begin Of File)을 가르키고 있기 때문에 next() 메소드를
		 *  한번 호출해야 우리가 원하는 no에 해당하는 글을 가져올 수 있다.
		 */
		rs.next();
		Board board = new Board();
		board.setContent(rs.getString("content"));
		board.setNo(rs.getInt("no"));
		board.setRegdate(rs.getDate("regdate"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		
		// 6. 객체 해제
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 7. 데이터베이스로부터 가져온 글 정보를 저장한 board 객체 리턴
		return board;
	}
	
	// 글 작성
	public void insert(Board board) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (글 번호 내림차순 정렬, 최신글 우선)
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO board (title, content, writer, regdate) ");
		sql.append("VALUES (?, ?, ?, CURDATE())");	// CURDATE(): MySQL에서 제공하는 함수
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		
		// 4. SQL문 실행
		pstmt.executeUpdate();
		
		// 5. 생략
		
		// 6. 객체 해제
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 7. 생략
	}
	
	// 글 삭제
	public void delete(Integer no) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성
		String sql = "DELETE FROM board WHERE no = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		// 4. SQL문 실행
		pstmt.executeUpdate();
		
		// 5. 생략
		
		// 6. 객체 해제
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 7. 생략
	}
	
	// 글 수정 (파라미터 board 객체에 저장된 no값은 수정하고자하는 글 번호)
	public void update(Board board) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성
		String sql = "UPDATE board SET title = ?, content = ? WHERE no = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getNo());
		
		// 4. SQL문 실행
		pstmt.executeUpdate();
		
		// 5. 생략
		
		// 6. 객체 해제
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 7. 생략
	}
}






