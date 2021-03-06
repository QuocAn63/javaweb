<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/Login.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
</head>
<body>
	<div id="login" style="background-image: url(./img/footer.webp)">
		<div class="login_container">
			<div class="hero_title">Đăng ký</div> 
			<form action="Register" method="POST" id="login_form">
				<div class="text_area">
					<div class="label">Họ và tên</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_FULL_NAME"></input>
					</div>
				</div>
				<div class="text_area">
					<div class="label">Địa chỉ Email</div>
					<div class="input_wrapper">
						<input type="email" class="input_box" name="USER_EMAIL"></input>
					</div>
				</div>
				<div class="text_area">
					<div class="label">Số điện thoại</div>
					<div class="input_wrapper">
						<input type="number" class="input_box" name="USER_PHONE_NUMBER"></input>
					</div>
				</div>
				<div class="text_area">
					<div class="label">Tên tài khoản</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_NAME"></input>
					</div>
				</div>
				<div class="text_area">
					<div class="label">Mật khẩu</div>
					<div class="input_wrapper">
						<input type="password" class="input_box" name="USER_PASSWORD"></input>
					</div>
				</div>
				<div class="text_area">
					<div class="label">Nhập lại mật khẩu</div>
					<div class="input_wrapper">
						<input type="password" class="input_box" name="USER_RE_PASSWORD"></input>
					</div>
				</div>
				<div class="form_controllers">
					<a href="Home" class="button back">Trở lại</a>
					<button class="button">Đăng ký</button>
				</div>
				
				<c:if test="${ MESSAGE != null }">
		
					<div class="error_show">
						<p>${MESSAGE}</p>
					</div>	
				</c:if>
				
				<div class="sub_link">
					Đã có tài khoản ? <a href="Login.jsp">Đăng nhập</a>
				</div>
		</form>
		</div>
	</div>
</body>
</html>