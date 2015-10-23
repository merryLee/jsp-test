<%@page import="com.cdg.study.entity.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	
	<!-- 검색 -->
	<tr>
		<td colspan='5'>
		<form action="search" method="get">
		<!-- select 이므로 get~ -->
			<select name="searchName">
			  <option value="title">제목</option>
			  <option value="author">작성자</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="검색">
		</form>
		</td>
		
	</tr>
	
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<%
			ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("list");
			for (BoardDTO dto : list) {
				int num = dto.getNum();
				String author = dto.getAuthor();
				String title = dto.getTitle();
				String writeday = dto.getWriteday();
				int readcnt = dto.getReadcnt();
		%>

		<tr>
			<td><%=num%></td>
			<td><%=author%></td>
			<td><a href="retrieve?num=<%=num%>"><%=title%></a></td>
			<!-- URL이 이미 /controller/list 로 되어있기 때문에 retrieve만 줘도 됨 -->
			<td><%=writeday%></td>
			<td><%=readcnt%></td>
		</tr>
		<% } %>
	</table>
	
	<!-- 글쓰기 버튼 -->
	<a href="writeui">글쓰기</a>
</body>
</html>