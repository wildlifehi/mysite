package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//1. 전달해줄 글제목, 글내용 받기
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		//2.글 번호 바탕으로 BoardVo 받아와서 그중에서 g.o.d 받아오기
		Long num = Long.parseLong(request.getParameter("num"));
		BoardVo vo = new BoardRepository().findByNum(num);
		
		Long gNo = vo.getgNo();
		Long oNo = vo.getoNo();
		Long depth = vo.getDepth();
		
		//3. session 객체로부터 userNo 받아와서 보내주기
		HttpSession session = request.getSession();
		Long userNo = (Long)session.getAttribute("userNo");
	
		new BoardRepository().reply(title, contents, gNo, oNo, depth, userNo);
		WebUtil.redirect(request, response, request.getContextPath() + "/board");
	}

}
