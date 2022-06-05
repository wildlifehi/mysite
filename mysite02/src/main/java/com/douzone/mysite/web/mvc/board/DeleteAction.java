package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//글 번호 받아오기
		System.out.println(request.getParameter("num") + "이건 넘어옴");
		Long num = Long.parseLong(request.getParameter("num"));

		

		//삭제해주기
		new BoardRepository().delete(num);
		System.out.println("삭제작업 잘 처리 됩니다.");
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board");
		
	}

}
