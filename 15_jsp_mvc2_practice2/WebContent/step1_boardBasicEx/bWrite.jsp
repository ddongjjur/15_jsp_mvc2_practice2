<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bWrite</title>
</head>
<body>

	<form action="bWrite" method="post">
	
		<h2>게시글 쓰기</h2>
		
		<table border="1">
		
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="30"></textarea> </td>
			</tr>
			<tr align="right">
				<td colspan="2">
					<input type="submit" value="작성">
					<input type="button" value="전체 게시글 보기" onclick="location.href='bList'">			
				</td>
			</tr>
		
		</table>
	
	</form>

</body>
</html>