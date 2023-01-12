<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bList</title>
</head>
<body>

	<h2>게시글 보기</h2>
	
	<table border="1">
	
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:set var="idx" value="1" />		
		<c:forEach var="boardBasicDTO" items="${boardBasicDTO }">
			<tr>
				
				<td>${idx }</td>
				<td><a href="bDetail?num=${boardBasicDTO.num }">${boardBasicDTO.subject }</a></td>
				<td>${boardBasicDTO.writer }</td>
				<td>${boardBasicDTO.enrollDt }</td>
				<td>${boardBasicDTO.readCnt }</td>
						
			</tr>
			<c:set var="idx" value="${idx = idx + 1 }" />
		</c:forEach>
		
		
		<tr align="right">
			<td colspan="5"><input type="button" value="글쓰러 가기" onclick="location.href='bWrite'"></td>
		</tr>
	
	</table>

</body>
</html>