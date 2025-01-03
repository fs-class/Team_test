package com.wi.DAO;

import java.sql.SQLException;

import com.wi.DTO.Board;

public class BoardDAO extends JDBConnection {

    /**
	 * 데이터 수정
	 * @param board
	 * @return
	 */
	public int update(Board board) {
		// result 결과는 적용된 데이터 개수이다.
		int result = 0;
		
		String sql = " UPDATE board "
				+ " SET title = ?"
				+ " ,writer = ?"
				+ " ,content = ?"
				+ " ,upd_date = now() "
				+ " WHERE no = ? ";
		
		try {
			// 쿼리 실행 객체 생성
			psmt = con.prepareStatement(sql);
			// 1번 ? 에 title(제목) 매핑
			psmt.setString(1, board.getTitle());
			// 2번 ? 에 writer(작성자) 매핑
			psmt.setString(2, board.getWriter());
			// 3번 ? 에 content(내용) 매핑
			psmt.setString(3, board.getContent());
			// 4번 ? 에 no(글번호) 매핑
			psmt.setInt(4, board.getNo());
			// SQL 실행 요청
			// SQL(INSERT, UPDATE, DELETE) 실행 시 적용된 데이터 개수를 int 타입으로 받아온다.
			// 예> 게시글 1개 적용 성공 시 result는 1, 실패 시 0
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("게시글 수정 시 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}
