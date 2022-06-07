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
	
	
	///////////////////////// SELECT ////////////////////////////
	public List<BoardVo> findAll() {
		List<BoardVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			//3. sql문 작성 및 Connection 객체로부터 (prepared)Statement 객체 얻어오기
			String sql =
					"   select board.no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no, name" +
					"     from board, user" +
					"	 where board.user_no = user.no"+
					" order by g_no desc, o_no";

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
				String name = rs.getString(10);
				
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
				vo.setName(name);
				
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
				e.printStackTrace();
			}
		}
		
		System.out.println("리스트 작성 완료!");
		return list;
	}


	///////////////////////// ViEW로 넘겨주기 ////////////////////////////
	public BoardVo findByNum(Long num) {
		BoardVo vo = new BoardVo();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql =
					"   select board.no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no, name" +
					"     from board, user" +
					"	 where board.no = ?"+
					" order by g_no desc, o_no";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, num);
			
			
			rs = pstmt.executeQuery();
				
			
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
				String name = rs.getString(10);
				
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setHit(hit);
				vo.setRegDate(regDate);
				vo.setgNo(gNo);
				vo.setoNo(oNo);
				vo.setDepth(depth);
				vo.setUserNo(userNo);
				vo.setName(name);
				
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			
			
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
				e.printStackTrace();
			}
		}
		
		System.out.println("검색완료!");
		return vo;
	}
	
	
	///////////////////////// INSERT ////////////////////////////
	public boolean insert(BoardVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
		
			
			String sql ="	insert into board " +
						"  	values(null, ?, ?, 0, now(), " +
						"	(select if(g_no is null, 1, max(g_no) + 1 ) from board as a) ,1 ,0, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getUserNo());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("새 글 작성(삽입)이 잘 되었습니다.");
		return result;
		
	}
	
	///////////////////////// REPLY ////////////////////////////
	public boolean reply(String title, String contents, Long gNo, Long oNo, Long depth, Long userNo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
		
			
			String sql ="	insert into board " +
						"  	values(null, ?, ?, 0, now(), ?, " +
						"	if( ? !=0 , ?, (select max(o_no) from board as a where g_no = ?) + 1) , ?+1, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setLong(3, gNo);
			pstmt.setLong(4, depth);
			pstmt.setLong(5, oNo);
			pstmt.setLong(6, gNo);
			pstmt.setLong(7, depth);
			pstmt.setLong(8, userNo);
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" 댓글 작성(삽입)이 잘 되었습니다.");
		return result;	
	
	}
	
	///////////////////////// DELETE ////////////////////////////
	public boolean delete(Long num) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
		
			String sql ="delete from board where no= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, num);

			int count = pstmt.executeUpdate();
			result = count == 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("글 삭제가 완료되었습니다.");
		return result;

	}
	
	public boolean update(Long num, String title, String contents) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
		
			
			String sql = "update board set title = ?, contents = ? where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setLong(3, num);
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("글수정(업뎃)이 완료되었습니다.");
		return result;
		
	}

	
	
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. jdbc driver 로드
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. jdbc 프로토콜로, 192.168.0.76 ip 의 3306 포트로 들어가 mysql 로 접속해 webdb라는 테이블 호출
			// 접속시 아이디 "webdb" 비밀번호 "webdb"
			
			String url = "jdbc:mysql://192.168.10.44:3306/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}

}
