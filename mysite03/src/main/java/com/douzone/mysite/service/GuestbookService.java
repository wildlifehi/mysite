package com.douzone.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.GuestbookRepository;
import com.douzone.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	//방명록 메세지 받아오기
	public List<GuestbookVo> getMessageList() {
		return guestbookRepository.findAll();
	}
	
	
	//방명록 메세지 지우기
	public Boolean deleteMessage(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		return guestbookRepository.delete(vo);
	}
	
	//방명록 메세지 더하기
	public Boolean addMessage(GuestbookVo vo) {
		return guestbookRepository.insert(vo);
	}
}