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
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
}






