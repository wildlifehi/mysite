package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//해당 글 번호 받아오기 및 파라미터 받아오기
		System.out.println(request.getParameter("num") + "이건 넘어옴");
		Long num = Long.parseLong(request.getParameter("num"));
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		
		new BoardRepository().update(num, title, contents);
		
		System.out.println("수정 마치면 글목록으로 복귀.");
		WebUtil.redirect(request, response, request.getContextPath() + "/board");

	}

}
