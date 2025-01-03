package com.wi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {
    // 연결된 드라이버에 SQL을 요청할 객체를 생성하는 클래스
	public Connection con;
	// SQL 실행 요청을 하는 클래스
	public Statement stmt;
	// Statement에서 ? 파라미터 확장 기능을 추가로 제공하는 클래스
	public PreparedStatement psmt;
	// SQL 실행 결과를 받아오는 클래스
	public ResultSet rs;
	
	// 기본 생성자
	public JDBConnection() {
		// JDBC 드라이버 로드
		// MySQL
		try {
			// mysql-connector-j.xxx.jar 드라이버의 클래스를 로드한다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DB에 연결
			// - 연결에 필요한 정보는 URL, id, pw이다.
			// - URL은 jdbc:mysql://도메인:[PORT]/[스키마]?옵션파라미터
			// - 내 PC의 IP주소는 localhost 또는 127.0.0.1
			// - 3036은 MySQL 데이터베이스의 기본 포트
			// - ~/wi는 스키마로 데이터베이스의 논리적 영역으로 구분하는 것을 말한다.
			// - allowPublicKeyRetrieval=true&useSSL=false는 보안 옵션이다.
			String url = "jdbc:mysql://127.0.0.1:3306/wi?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
			String id = "wi";
			String pw = "123456";
			
			// 자바 프로그램에서 JDBC 드라이버를 연결시켜주는 클래스
			// getConnection() 메소드로 DB에 연결 요청하고 생성된 Connection 객체를 반환받는다.
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.err.println("DB 연결 실패");
			e.printStackTrace();
		}
	}

    // public static void main(String[] args) {
    //     JDBConnection jdbc = new JDBConnection();
    // }
}
