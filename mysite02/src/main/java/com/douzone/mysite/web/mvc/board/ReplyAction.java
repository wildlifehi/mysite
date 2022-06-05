package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.WebUtil;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 넘겨온 글 번호받기 ( 이를 바탕으로 해당 글의 gNo를 조회후 연이어 gNo로 최대값 잡기 
		
		//1-1) 댓글이니 gNo는 일단 0이 아니니까 gNo 값은 계승하고.
		//1-2) o_no가 0 이면 1, 아니면 최대값  몰라몰라 일단 내일 글번호에서 추출한 g.o.d로 어떻게 댓글추가할지 고민~!
		
		Long num = Long.parseLong(request.getParameter("num"));
		System.out.println("가져왔나~??"+num);
		
		//2. 전달할 내용 주기.
		String title = request.getParameter("title");
		String contents = request.getParameter("content");

		
		System.out.println("여기까지는 잘 도착 이건 아직 아무작업하지않습니다.");
		
	
		//3. session 객체로부터 userNo 받아와서 보내주기
		HttpSession session = request.getSession();
		Long userNo = (Long)session.getAttribute("userNo");
		// session.setAttribute("userNo", authUser.getNo()); 로그인때 받은 유저 번호 있다.
	
		

		//new BoardRepository().reply(num, title, contents, userNo);
		WebUtil.redirect(request, response, request.getContextPath() + "/board");
	}

}
