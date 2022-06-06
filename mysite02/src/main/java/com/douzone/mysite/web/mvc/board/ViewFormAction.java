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

		
		//글 번호 받아오기
		System.out.println(request.getParameter("num") + "이건 넘어옴");
		Long num = Long.parseLong(request.getParameter("num"));
		
		
		//왜 여기서 request객체가 없는지 강사님한테 여쭤볼 것
//		if (request.getAttribute("list") == null) {
//			System.out.println("없누...");
//		}
//		원래 list의 get() 메소드 사용하려했으나 null이 떠서 사용할 수 없음.
		

		
		//글 번호 바탕으로 검색 해주기 객체 반환
		BoardVo vo = new BoardRepository().findByNum(num);
		request.setAttribute("vo", vo);
		
		System.out.println("뷰 잘 넘겨드렸습니다.");
		WebUtil.forward(request, response, "board/view");
	
	}

}
