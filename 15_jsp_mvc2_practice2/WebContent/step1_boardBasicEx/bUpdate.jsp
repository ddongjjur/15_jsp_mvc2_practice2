<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bUpdate</title>
</head>
<body>

	<form action="bUpdate" method="post">
	
		<h2>게시글 수정</h2>
		
		<table border="1">
		
			<tr>
				<th>작성자</th>
				<td>${boardBasicDTO.writer }</td>
			</tr>
		
			<tr>
				<th>작성일</th>
				<td>${boardBasicDTO.enrollDt }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${boardBasicDTO.subject }"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="30"></textarea></td>
			</tr>
			<tr align="right">
				<td colspan="2">
					<input type="hidden" value="${boardBasicDTO.num }" name="num">
					<input type="submit" value="수정">
					<input type="button" value="리스트로 돌아가기" onclick="location.href='bList'">
				</td>
			</tr>
		
		</table>
	
	</form>

</body>
</html>