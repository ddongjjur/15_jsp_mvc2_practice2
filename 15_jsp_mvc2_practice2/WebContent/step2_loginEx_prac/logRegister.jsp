<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logRegister</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="jquery/jquery-3.6.1.min.js"></script>
<script>
	function execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	
	            var fullRoadAddr = data.roadAddress; 
	            var extraRoadAddr = ''; 
	
	            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            if (data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            if (extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	            if (fullRoadAddr !== ''){
	                fullRoadAddr += extraRoadAddr;
	            }
	
	            document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
	            document.getElementById('roadAddress').value = fullRoadAddr;
	            document.getElementById('jibunAddress').value = data.jibunAddress;
	          
	        }
	    }).open();
	}
</script>
<script type="text/javascript">

	var checkId = false;
	var checkPwd = false;

	function checkData() {
		
		if (!checkId) {
			alert("아이디 중복확인을 해주세요.");
			$("#memberId").focus();
		}
		
		if (!checkPwd) {
			alert("비밀번호를 확인해주세요.");
			$("#checkPasswd").focus();
		}
		
		var birthDt = $("#birthY").val() + "_" + $("#birthM").val() + $("#birthD").val();
		$("[name='birthDt']").val(birthDt);
	}

	$(function() {
		
		$("[name='checkDuple']").click(function() {
			
			$.ajax({
				url: "loginCheckId",
				type: "get",
				data: {"memberId" : $("#memberId").val()},
				success: function(result) {
					if (result == "isDuple") {
						alert("중복된 아이디입니다.");
					}
					else {
						alert("사용 가능한 아이디입니다.");
						checkId = true;
					}
				}
			});
			
		});
		
		$("#checkPasswd").blur(function() {
			
			var passwd1 = $("#passwd").val()
			var passwd2 = $("#checkPasswd").val()
			
			if (passwd1 != passwd2) {
				$("#pwdState").html("<span style='color:red;'>패스워드 불일치</span>")
			}
			else {
				$("#pwdState").html("<span style='color:red;'>패스워드 불일치</span>")
				checkPwd = true;
			}
			
		});
		
	});

</script>
</head>
<body>

	<div align="center">
		<form action="loginRegister" method="post" enctype="multipart/form-data" onsubmit="return checkData()">
			<h3>회원가입</h3>
		
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" id="memberId" name="memberId" placeholder="아이디를 입력하세요." required="required">
						<input type="button" name="checkDuple" value="중복확인">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="passwd" name="passwd" placeholder="비밀번호를 입력하세요." required="required"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" id="checkPasswd" name="checkPasswd" placeholder="비밀번호를 확인하세요." required="required">
						<span id="pwdState"></span>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memberNm" placeholder="이름을 입력하세요." required="required"></td>
				</tr>
				<tr>
					<th>프로필 이미지</th>
					<td>
						<input type="file" name="imgNm" required="required">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						남<input type="radio" name="sex" value="M" checked="checked">&emsp;&emsp;
						여<input type="radio" name="sex" value="F">
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<select id="birthY">
							<c:forEach var="i" begin="0" end="2023">
								<option>${2023 - i }</option>
							</c:forEach>
						</select>년
						<select id="birthM">
							<c:forEach var="i" begin="1" end="12">
								<c:choose>
									<c:when test="${i < 10 }">
										<option>0${i }</option>
									</c:when>
									<c:otherwise>
										<option>${i }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>월
						<select id="birthD">
							<c:forEach var="i" begin="1" end="31">
								<c:choose>
									<c:when test="${i < 10 }">
										<option>0${i }</option>
									</c:when>
									<c:otherwise>
										<option>${i }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>일
						<input type="hidden" name="birthDt">
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="hp" placeholder="-를 포함해서 입력하세요." required="required"><br>
						SMS 소식을 수신합니다.
						<input type="checkbox" name="smsstsYn" value="Y" checked="checked">
					</td>	
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email" placeholder="이메일을 입력하세요." required="required"><br>
						E-mail을 수신합니다.
						<input type="checkbox" name="emailstsYn" value="Y" checked="checked">
					</td>	
				</tr>
				<tr>
					<th>주소</th>
					<td>
						우편번호 : <input type="text" id="zipcode" name="zipcode" required>
						<input type="button" value="검색" onclick="execDaumPostcode();"> <br><br>
						도로명 주소 : <input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소를 입력하세요."><br>
						지번 주소 : <input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소를 입력하세요."><br>
						나머지 주소 : <input type="text" id="namujiAddress" name="namujiAddress" placeholder="나머지주소를 입력하세요.">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="가입">
				</tr>
			</table>
		</form>
	</div>

</body>
</html>