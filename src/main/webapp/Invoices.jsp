<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/Shop.css" />
<link rel="stylesheet" href="./css/Checkout.css" />
<link rel="stylesheet" href="./css/UserInvoices.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/InvoicesPage.js" defer></script>
<title>natureFruits - Thông tin người dùng</title>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title" style="text-align: center">Hoá đơn</div>
		</div>
	</div>
	
	<div id="user_invoices">
		<div class="grid wide">
			<div class="row">
				<div class="col c-12">
					<div class="user_invoices_container">
						<div class="invoice_side_filter">
							<a href="GoToUser?site=invoices&type=all" class="item_link" data-type="all">Tất cả</a>
							<a href="GoToUser?site=invoices&type=0" class="item_link" data-type="0">Chờ xử lý</a>
							<a href="GoToUser?site=invoices&type=1" class="item_link" data-type="1">Đang giao</a>
							<a href="GoToUser?site=invoices&type=2" class="item_link" data-type="2">Đã giao</a>
						</div>
						<div class="invoices_container">
							<c:forEach items="${ Invoices }" var="invoice">
								<div class="invoice_item">
									<div class="invoice_header">
										<div class="invoice_date"><c:out value="${ invoice.getINVOICE_CREATED_AT() }"></c:out> <span class="order_id">( Mã đơn hàng: <c:out value="${ invoice.getINVOICE_ID() }"></c:out> )</span> </div>
										<div class="invoice_status"><c:out value="${ invoice.getINVOICE_STATUS_NAME() }"></c:out></div>
									</div>
									<div class="invoice_body">
										<div class="invoice_products_container">
											<c:forEach items="${ invoice.list }" var="product">
												<div class="invoice_product">
													<div class="image_holder">
														<div class="image" style="background-image: url(${ product.PRODUCT.getPRODUCT_IMAGE()})"></div>
													</div>
													<div class="informations">
														<div class="name"><c:out value="${ product.PRODUCT.getPRODUCT_NAME() }"></c:out></div>
														<div class="quantity">x<c:out value="${ product.getQUANTITY() }"></c:out> </div>
													</div>
													<div class="price">
														<fmt:formatNumber value="${ product.getTotal() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/>
													</div>
												</div>
											</c:forEach>
										</div>	
									</div>
									<div class="invoice_footer">
										<div class="receiver_informations">
											<div class="item">
												<div class="label">Tên người nhận hàng: </div>
												<div class="content"><c:out value="${ invoice.getRECEIVER_FULL_NAME() }"></c:out></div>
											</div>
											<div class="item">
												<div class="label">Số điện thoại: </div>
												<div class="content"><c:out value="${ invoice.getRECEIVER_PHONE_NUMBER() }"></c:out></div>
											</div>
											<div class="item">
												<div class="label">Địa chỉ nhận hàng: </div>
												<div class="content"><c:out value="${ invoice.getRECEIVER_ADDRESS() }"></c:out></div>
											</div>
										</div>
										<div class="invoice_grand_total">
											<div class="label">Tổng hoá đơn: </div>
											<div class="content"><fmt:formatNumber value="${ invoice.getINVOICE_GRAND_TOTAL() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/></div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./Footer.jsp" %>
</body>
</html>