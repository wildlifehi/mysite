<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	pageContext.setAttribute("newLine", "\n"); %>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board">
			
				<!-- 찾기 기능은 조금 있다가 할 것 -->
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
				
				<!-- 여까지 찾기 기능입니다 -->
				
					<c:import url="/WEB-INF/views/includes/boardtitle.jsp" />

					<c:set var='index' value='0'/>
					<c:set var='count' value='${list.size() }'/>									
					<c:forEach var='list' items='${list }'>	
					<tr>
						<td>${count - index }</td>
						
						<c:choose>
							<c:when test='${ list.depth == 0}'>
								<td style="text-align:left; padding-left:0px">
									<a href="${pageContext.request.contextPath }/board?a=viewform&num=${list.no }">  ${list.no } 번째 글입니다.</a>
								</td>
							</c:when>
							<c:otherwise>
								<td style="text-align:left; padding-left:${list.depth*10}px">
									<img src='${pageContext.servletContext.contextPath }/assets/images/reply.png' />
									<a href="${pageContext.request.contextPath }/board?a=viewform&num=${list.no }">  ${list.no } 번째 글입니다.</a>
								</td>
							</c:otherwise>
						</c:choose>
						
						<c:set var='index' value='${index + 1 }'/>
						<td> ${list.name }</td>
						
						<td>3</td>
						<td>${list.regDate }</td>
						<c:if test='${authUser != null && authUser.name == list.name }'>
							<td><a href="" class="del">삭제</a></td>
						</c:if>
					</tr>
					</c:forEach>
				</table>		
				
				
				
				<!-- pager 추가 -->
				
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li class="selected"><a href="">1</a></li>
						<li>2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>			
				
				<!-- pager 추가 -->
				
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?a=writeform" id="new-book">글쓰기</a>
				</div>				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>