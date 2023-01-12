<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDetail</title>
</head>
<body>

	<h2>게시글 보기</h2>
	
	<table border="1">
	
		<tr>
			<th>조회수</th>
			<td>${boardBasicDTO.readCnt }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardBasicDTO.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardBasicDTO.enrollDt }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${boardBasicDTO.email }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardBasicDTO.subject }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardBasicDTO.content }</td>
		</tr>
		<tr align="right">
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='bUpdate?num=${boardBasicDTO.num}'">
				<input type="button" value="삭제" onclick="location.href='bDelete?num=${boardBasicDTO.num}'">
				<input type="button" value="목록" onclick="location.href='bList'">
			</td>
		</tr>
	
	</table>

</body>
</html>