package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//글 번호 바탕으로 BoardVo 받아와서 그중에서 g.o.d 받아올것
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		
		//reply 용 폼을 구분해주기 위해서 아래 내용으로 보내줄것
		request.setAttribute("reply", "reply");
		
		WebUtil.forward(request, response, "board/write");
	}

}
