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

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("content");

		
		System.out.println("여기까지는 잘 도착");
		// 글쓰기나 수정이나 gNo, oNo, depth 다루어야 할 것.
		// 글쓰기 자체는 새 글이니까 oNo, depth 는 0 으로 기본값 주고, 수정은 받아서 반영.
		// gNo 는 gNo max값에다가 하나 더 추가하는 식으로 줘야할 것.
		BoardVo vo = new BoardVo();
		
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setUserNo((Long) request.getSession().getAttribute("userNo"));
		
		new BoardRepository().insert(vo);
		WebUtil.redirect(request, response, request.getContextPath() + "/board");

	}

}
