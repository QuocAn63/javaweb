<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/Shop.css" />
<link rel="stylesheet" href="./css/Checkout.css" />
<link rel="stylesheet" href="./css/UserProfile.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
<title>natureFruits - Thông tin người dùng</title>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title" style="text-align: center">Thông tin người dùng</div>
		</div>
	</div>
	
	<div id="user_profile">
		<form action="UpdateUser" method="POST" id="user_profile_form">
			<div class="user_profile_container">
				<div class="input_area">
					<div class="label">Tên tài khoản</div>
					<div class="input_user_name">
						<c:out value='${ sessionScope.account.getUSER_NAME() }' ></c:out>
					</div>
				</div>
				<div class="input_area">
					<div class="label">Họ và tên</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_FULL_NAME" value="<c:out value='${ sessionScope.account.getUSER_FULL_NAME() }' ></c:out>" />
					</div>
				</div>
				<div class="input_area">
					<div class="label">Địa chỉ Email</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_EMAIL" value="<c:out value='${ sessionScope.account.getUSER_EMAIL() }' ></c:out>" />
					</div>
				</div>
				<div class="input_area">
					<div class="label">Số điện thoại</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_PHONE_NUMBER" value="<c:out value='${ sessionScope.account.getUSER_PHONE_NUMBER() }' ></c:out>" />
					</div>
				</div>
				<div class="input_area">
					<div class="label">Địa chỉ</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="USER_ADDRESS" value="<c:out value='${ sessionScope.account.getUSER_ADDRESS() }' ></c:out>" />
					</div>
				</div>
				<div class="input_area">
					<div class="label">Giới tính</div>
					<div class="select_wrapper">
						<div class="radio_itemp_wrapper">
							<input type="radio" class="radio" name="USER_GENDER" value="0" <c:if test='${ sessionScope.account.getUSER_GENDER() == 0 }' >checked</c:if> />Nam					
						</div>
						<div class="radio_itemp_wrapper">
							<input type="radio" class="radio" name="USER_GENDER" value="1" <c:if test='${ sessionScope.account.getUSER_GENDER() == 1 }' >checked</c:if> />Nữ				
						</div>
					</div>
				</div>
				<div class="input_area">
					<div class="label">Ngày sinh</div>
					<div class="input_date_wrapper">
						<input type="date" name="USER_DOB" value="<c:out value='${ sessionScope.account.getUSER_DOB() }'></c:out>" />
					</div>
				</div>
				<div class="form_controller">
					<button class="edit_user_form_button">Lưu</button>
				</div>
			</div>
		</form>
	</div>
	
	<%@include file="./Footer.jsp" %>
</body>
</html>