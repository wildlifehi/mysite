package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//여기에 세션 authUser 값 없으면 로그인페이지로 넘겨주기.
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("authUser") != null) {
			
			WebUtil.forward(request, response, "board/write");

		} else {
			//경고문 띄워주고가기.
			WebUtil.redirect(request, response, request.getContextPath()+"");
		}
	

	}

}
