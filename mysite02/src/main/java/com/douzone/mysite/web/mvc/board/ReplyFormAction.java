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
		
		//a=reply&num=${vo.no } 가지고 넘어왔다. << 게시글 번호
		// >> 이거 우선 num로 변환해서 넘겨주기 해당 넘버로부터 select 조회해서 gNo 얻어 낼것.
		// 그리고 해당 gNo로부터 oNo 최대값 붙여줄 것, 
		// 연이어 해당 oNo로부터 depth값 추가해줄 것이기때문에.
		
		
		//글 번호 넘겨주기 
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
