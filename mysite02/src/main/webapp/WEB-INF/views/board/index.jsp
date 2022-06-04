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
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<c:import url="/WEB-INF/views/includes/boardtitle.jsp" />
					
					<!-- 여기는 forEach 문으로 정리해줄것 -->
					<c:forEach var='wow' items='${list }'>	
						<td>${wow.no }</td>
					</c:forEach>
					<c:forEach begin='1' end='3' step='1' var='i'>
					<tr>
						<td>${i }</td>
						<td style="text-align:left; padding-left:0px">
							<a href="${pageContext.request.contextPath }/board?a=view">${i } 번째 글입니다.</a>
						</td>
						<td>안대혁</td>
						<% // 글쓴이 이름은, userNo으로 조회해와야할 것. %>
						<td>3</td>
						<td>2015-10-11 12:04:20</td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
					</c:forEach>
				</table>		
				
					

					<!-- 아래 코드를 참조해서 foreach문으로 교정
					<c:set var='index' value='0'/>
					<c:set var='count' value='${list.size() }'/>
					<c:forEach var='list' items='${list }'>
						<li>
							<table>
								<tr>
									<td>[${count - index }]</td>
									<c:set var='index' value='${index+1 }'/>
									<td>${list.name }</td>
									<td>${list.regDate }</td>
									<td><a href="${pageContext.request.contextPath }/guestbook?a=deleteform&no=${list.no}">삭제</a></td>
								</tr>
								<tr>
									<td colspan=4>
										${fn:replace(list.message,newLine, "<br/>") }
									</td>
								</tr>
							</table>
							<br>
						</li>
					</c:forEach>
					-->
				
				
				<!-- pager 추가 -->
				
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>			
				
				<!-- pager 추가 -->
				
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?a=write" id="new-book">글쓰기</a>
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