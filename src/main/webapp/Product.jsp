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
<link rel="stylesheet" href="./css/ProductPage.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/Cart.js" defer></script>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title" style="text-align: center">Chi tiết sản phẩm</div>
		</div>
	</div>
	<c:set var="PRODUCT" value='${requestScope["PRODUCT"]}' />
		<div id="product_detail">
			<div class="product_detail_container">
				<div class="grid wide">
					<div class="row">
						<div class="col c-5">
							<div class="image_holder">
								<div class="image" style="background-image: url(${PRODUCT.PRODUCT_IMAGE})"></div>
							</div>
						</div>
						<div class="col c-7">
							<div class="product_detail">
								<div class="product_detail_header">
									<div class="product_name"><c:out value="${PRODUCT.PRODUCT_NAME}"/></div>
									<div class="product_category_container">
										<div class="item">
											<div class="title">Danh mục:</div>
											<div class="value"><c:out value="${PRODUCT.CATEGORY_NAME}"/></div>
										</div>
										<div class="item">
											<div class="title">Xuất xứ:</div>
											<div class="value"><c:out value="${PRODUCT.COUNTRY_NAME}"/></div>
										</div>
									</div>
									<div class="product_price"><c:out value="${PRODUCT.PRODUCT_PRICE}"/></div>
								</div>
								<div class="product_detail_body">
									<div class="product_description">
										Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
									</div>
									<div class="product_controller">
										<form class="add_to_cart_form"></form>
										<button class="button add_to_cart_button" onClick="addToCart(${PRODUCT.PRODUCT_ID}, '${PRODUCT.PRODUCT_NAME}', '${PRODUCT.PRODUCT_IMAGE}', ${PRODUCT.PRODUCT_PRICE})">Thêm vào giỏ hàng</button>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
	
	<%@include file="./Footer.jsp" %>
</body>
</html>