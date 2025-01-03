package com.wi.DAO;

import com.wi.DTO.Board;

public class BoardDAO extends JDBConnection {
    
    /**
     * 게시글 등록
     * @param board
     * @return
     */
    public int insert(Board board) {
        int result = 0;
        
        String sql = " INSERT INTO board(title, writer, content) "
                   + " VALUE( ?, ?, ? ) ";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getWriter());
			psmt.setString(3, board.getContent());
            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("게시글 등록 중 예외 발생!");
        }
        return result;
    }
}