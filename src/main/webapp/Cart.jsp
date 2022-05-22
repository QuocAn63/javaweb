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
<link rel="stylesheet" href="./css/Cart.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title" style="text-align: center">Giỏ hàng</div>
		</div>
	</div>
	
	<div id="cart">
		<div class="grid wide">
			<div class="row">
				<div class="col c-12">
					<table id="cart_table">
						<thead>
							<tr>
								<th>#</th>
								<th>Sản phẩm</th>
								<th>Giá</th>
								<th>Số lượng</th>
								<th>Số tiền</th>
								<th>Xoá</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>
									<div class="product_col">
										<div class="product_col_image" style="background-image: url(./img/product.webp)"></div>
										<div class="product_col_name">XOÀI TƯƠI</div>
									</div>	
								</td>
								<td>
									40
								</td>
								<td>
									2
								</td>
								<td>
									80
								</td>
								<td style="width: 80px">
									<button class="cart_delete_item_button">&times;</button>
								</td>
							</tr>
							<tr>
								<td colspan="5">Tổng cộng:</td>
								<td>80</td>
							</tr>
						</tbody>
					</table>
					
					<div class="cart_controller">
						<a href="<%= request.getContextPath() %>/Checkout" class="button">Thanh toán</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./Footer.jsp" %>
</body>
</html>