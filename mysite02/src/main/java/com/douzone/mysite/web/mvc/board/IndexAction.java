package com.douzone.mysite.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> list = new BoardRepository().findAll();
		
		System.out.println(list.get(0).toString() + " 잘 드감요");
		
		request.setAttribute("list", list);
		request.setAttribute("test", "test값");
		WebUtil.forward(request, response, "board/index");
		System.out.println("객체 잘 받아서 넘겼습니다.");
	}

}