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
		
		// oNo, depth 전부 부모글 기준에서 +1해줄 것이므로 gNo oNo 받아오기
		
		//글 번호 바탕으로 BoardVo 받아와서 그중에서 g.o.d 받아올것이므로 이 값을 ReplyAction으로 보내주기
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		
		
		
		
		
		//reply 용 폼을 구분해주기 위해서 아래 내용으로 보내줄것
		request.setAttribute("reply", "reply");
		
		WebUtil.forward(request, response, "board/write");
		
		//이미 로그인이 되어있다는 전제하에 시작하는 것이기 때문에 아래 로그인 여부확인 기능은 필요없다.
//		if(request.getSession().getAttribute("authUser") != null) {
//					
//			WebUtil.forward(request, response, "board/write");
//
//		} else {
//					//경고문 띄워주고가기.
//			WebUtil.redirect(request, response, request.getContextPath()+"");
//		}

	}

}
