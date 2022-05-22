<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/Shop.css" />
<link rel="stylesheet" href="./css/Checkout.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title" style="text-align: center">Thanh toán</div>
		</div>
	</div>
	
	<div id="checkout">
		<div class="grid wide">
			<div class="row">
				<div class="col c-6">
					<div id="invoice_user_detail">
						<div class="hero_title">Thông tin cá nhân</div>
						<div class="horizontal"></div>
						<div class="detail_container">
							<div class="input_area">
								<div class="label">Họ và tên</div>
								<div class="input_wrapper">
									<input type="text" class="input_box" value="${ sessionScope.account.USER_FULL_NAME }">
								</div>
							</div>
							<div class="input_area">
								<div class="label">Địa chỉ Email</div>
								<div class="input_wrapper">
									<input type="text" class="input_box" value="${ sessionScope.account.USER_EMAIL }">
								</div>
							</div>
							<div class="input_area">
								<div class="label">Số điện thoại</div>
								<div class="input_wrapper">
									<input type="text" class="input_box" value="${ sessionScope.account.USER_PHONE_NUMBER }">
								</div>
							</div>
							<div class="input_area">
								<div class="label">Địa chỉ</div>
								<div class="input_wrapper">
									<input type="text" class="input_box" value="${ sessionScope.account.USER_ADDRESS }">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col c-6">
					<div id="invoice_detail">
						<div class="hero_title">Chi tiết hoá đơn</div>
						<div class="horizontal"></div>
						<div class="detail_container">
							<div class="detail_item">
								<div class="detail_title main_title">Sản phẩm</div>
								<div class="detail_value main_title">Tổng tiền</div>
							</div>
							<div class="detail_item">
								<div class="detail_title">
									<div class="order_product">
										<div class="name">Fresh Banana</div>
										<div class="quantity">x 1</div>
									</div>
								</div>
								<div class="detail_value">40</div>
							</div>
							<div class="detail_item">
								<div class="detail_title">
									<div class="order_product">
										<div class="name">Fresh Banana</div>
										<div class="quantity">x 1</div>
									</div>
								</div>
								<div class="detail_value">40</div>
							</div>
						</div>
						
						<div class="horizontal"></div>
						<div class="detail_container">
							<div class="detail_item">
								<div class="detail_title main_title">Tổng hoá đơn</div>
								<div class="detail_value main_title">40</div>
							</div>
							<div class="detail_item">
								<div class="detail_title main_title">Phí vận chuyển</div>
								<div class="detail_value main_title">Miễn phí</div>
							</div>
							<div class="detail_item">
								<div class="detail_title main_title">Thành tiền</div>
								<div class="detail_value main_title main_value">40</div>
							</div>
						</div>
						<div class="order_controller">
							<button class="button">Thanh toán</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./Footer.jsp" %>
</body>
</html>