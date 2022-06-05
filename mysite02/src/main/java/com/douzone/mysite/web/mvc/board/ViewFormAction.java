package com.douzone.mysite.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("여기까지 오긴오냐1");
		//글 번호 받아오기

		System.out.println(request.getParameter("num") + "이건 넘어옴");
		
		Long num = Long.parseLong(request.getParameter("num"));
		
		
		
		if (request.getAttribute("list") == null) {
			System.out.println("없누...");
		}
		
		
		System.out.println("여기까지 오긴오냐2");
		//검색내용 받아다가 내용 가져다주기

		BoardVo vo = new BoardRepository().findByNum(num);
		
		request.setAttribute("vo", vo);
		WebUtil.forward(request, response, "board/view");
		System.out.println("뷰도 잘 넘겨드림.");
		


	}

}
