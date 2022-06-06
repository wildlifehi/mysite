package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//해당 글 번호 받아오기
		Long num = Long.parseLong(request.getParameter("num"));
		
		//글 번호 바탕으로 검색 해주기 객체 반환
		BoardVo vo = new BoardRepository().findByNum(num);
		request.setAttribute("vo", vo);
		
		System.out.println("수정폼으로 잘 넘겨드렸습니다.");
		WebUtil.forward(request, response, "board/modify");

	}

}
