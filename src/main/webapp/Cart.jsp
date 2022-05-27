<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="./js/Cart.js" defer></script>
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
							<c:forEach items="${ Cart.list }" var="item" varStatus="loop">
								<tr>
									<td>${loop.index + 1}</td>
									<td>
										<div class="product_col">
											<div class="product_col_image" style="background-image: url(${ item.PRODUCT.getPRODUCT_IMAGE()})"></div>
											<div class="product_col_name"><c:out value="${ item.PRODUCT.getPRODUCT_NAME() }"></c:out></div>
										</div>	
									</td>
									<td>
										<fmt:formatNumber value="${ item.PRODUCT.getPRODUCT_PRICE() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/>
									</td>
									<td>
										<div class="product_quantitiy_controller">
											<button class="quantity_button" onClick="handleChangeProductQuantity(<c:out value="${ item.PRODUCT.getPRODUCT_ID() }"></c:out>, Number.parseInt(document.querySelector('.cart_product_quantity_input').value) - 1)">&minus;</button>
											<input type="number" class="cart_product_quantity_input" value="<c:out value="${ item.getQUANTITY() }"></c:out>" onChange="handleChangeProductQuantity(<c:out value="${ item.PRODUCT.getPRODUCT_ID() }"></c:out>, this.value)" >
											<button class="quantity_button" onClick="handleChangeProductQuantity(<c:out value="${ item.PRODUCT.getPRODUCT_ID() }"></c:out>, Number.parseInt(document.querySelector('.cart_product_quantity_input').value) + 1)">&plus;</button>
										</div>
									</td>
									<td>
										<fmt:formatNumber value="${ item.PRODUCT.getPRODUCT_PRICE()*item.getQUANTITY() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/>
									</td>
									<td style="width: 80px">
										<button class="cart_delete_item_button" onClick="removeFromCart(${ item.PRODUCT.getPRODUCT_ID() })">&times;</button>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="6" style="border-left: 0; border-right: 0"></td>
							</tr>
							<tr>
								<td colspan="4">Tổng cộng:</td>
								<td colspan="2"><fmt:formatNumber value="${ Cart.getTotal() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/></td>
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