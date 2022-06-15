<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="navigation">
	<ul>
		<li><a href="<%=request.getContextPath() %>">주성빈</a></li>
		<li><a href="<%=request.getContextPath() %>/guestbook">방명록</a></li>
		<li><a href="<%=request.getContextPath() %>/board">게시판</a></li>
		<li><a href="<%=request.getContextPath() %>/gallery">갤러리</a></li>
	</ul>
</div>
