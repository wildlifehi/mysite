package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.mysite.vo.BoardVo;

public class BoardRepository {
	public List<BoardVo> findAll() {
		List<BoardVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			//3. sql문 작성 및 Connection 객체로부터 (prepared)Statement 객체 얻어오기
			String sql =
					"   select no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no" +
					"     from board" +
					" order by reg_date desc";

			pstmt = conn.prepareStatement(sql);
			
			//4. (매핑작업 후) 쿼리 결과 얻어오기, select문에서는 매핑작업이 없다.
			rs = pstmt.executeQuery();
				
			//5. 처리결과 받아오기
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				Long hit = rs.getLong(4);
				String regDate = rs.getString(5);
				Long gNo = rs.getLong(6);
				Long oNo = rs.getLong(7);
				Long depth = rs.getLong(8);
				Long userNo = rs.getLong(9);
				
				//꺼내용 내용 BoardVo 객체에 넣어주기
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setHit(hit);
				vo.setRegDate(regDate);
				vo.setgNo(gNo);
				vo.setoNo(oNo);
				vo.setDepth(depth);
				vo.setUserNo(userNo);
				
				//잘 가지고 나왔누?
				System.out.println(vo.toString());
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			
			//5. 자원 반납하기 !! 매우 중요.
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}



	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. jdbc driver 로드
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. jdbc 프로토콜로, 192.168.0.76 ip 의 3306 포트로 들어가 mysql 로 접속해 webdb라는 테이블 호출
			// 접속시 아이디 "webdb" 비밀번호 "webdb"
			
			String url = "jdbc:mysql://192.168.0.76:3306/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}	
}
