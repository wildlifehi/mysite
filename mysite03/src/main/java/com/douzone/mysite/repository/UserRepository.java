package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(UserVo vo) {
		return sqlSession.insert("user.insert", vo) == 1;
	}

	public UserVo findByEmailAndPassword(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}	

	public UserVo findByNo(Long userNo) {
		return sqlSession.selectOne("user.findByNo", userNo);
	}

	public boolean update(UserVo vo) {
		return sqlSession.update("user.update", vo) == 1;
	}

	//아래는 이제 주입을 위에 dataSource. 이렇게 받았기에 필요가 없어졌다.
	
//	@Autowired
//	private DataSource dataSource;
	
//	private Connection getConnection() throws SQLException {
//		Connection conn = null;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mysql://192.168.10.44:3306/webdb?characterEncoding=utf8";
//			conn = DriverManager.getConnection(url, "webdb", "webdb");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패:" + e);
//		} 
//		
//		return conn;
//	}
}
