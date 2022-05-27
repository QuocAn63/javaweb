<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang quản trị</title>
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/AdminHeader.css" />
<link rel="stylesheet" href="./css/AdminSidebar.css" />
<link rel="stylesheet" href="./css/AdminMain.css" />
<link rel="stylesheet" href="./css/AdminShop.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/Admin.js" defer></script>
</head>
<body>
	<%@include file="../AdminHeader.jsp" %>

	
	<div id="admin_form">
		<div class="grid wide">
			<div class="row">
				<div class="col c-12">
					<div id="admin_product_adding_form">
						<div class="hero_title">Thông tin người nhận</div>
						<c:if test="${ INVOICE.getINVOICE_STATUS() == 0 }">
							<form action="AdminInvoice?action=delivery&INVOICE_ID=${ INVOICE.getINVOICE_ID() }" method="POST">
						</c:if>
						<c:if test="${ INVOICE.getINVOICE_STATUS() == 1 }">
							<form action="AdminInvoice?action=complete&INVOICE_ID=${ INVOICE.getINVOICE_ID() }" method="POST">
						</c:if>
							<div class="row">
								<div class="col c-6">
									<div class="form_container">
										<div class="text_area">
											<div class="label">Tên người nhận</div>
											<div class="text_content">${ INVOICE.getRECEIVER_FULL_NAME() }</div>
										</div>
										<div class="text_area">
											<div class="label">Số điện thoại</div>
											<div class="text_content">${ INVOICE.getRECEIVER_PHONE_NUMBER() }</div>
										</div>
										<div class="text_area">
											<div class="label">Địa chỉ</div>
											<div class="text_content">${ INVOICE.getRECEIVER_ADDRESS() }</div>
										</div>
									</div>
								</div>
								<div class="col c-6">
									<div class="form_container">
										<div class="hero_title">Hoá đơn <c:if test="${ INVOICE.getINVOICE_STATUS() == 2 }">( Đã giao )</c:if></div>
										<table id="admin_invoice_detail_table">
											<thead>
												<tr>
													<th>Sản phẩm</th>
													<th>Giá</th>
													<th>Số lượng</th>
													<th>Thành tiền</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${ INVOICE.getList() }" var="INVOICE_ITEM">
													<tr>
														<td style="text-align: left">${ INVOICE_ITEM.PRODUCT.getPRODUCT_NAME() }</td>
														<td><fmt:formatNumber value="${ INVOICE_ITEM.PRODUCT.getPRODUCT_PRICE() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/></td>
														<td>${ INVOICE_ITEM.getQUANTITY() }</td>
														<td><fmt:formatNumber value="${ INVOICE_ITEM.getTotal() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/></td>
													</tr>	
												</c:forEach>
												<tr class="invoice_detail_grand_total">
													<td colspan="3" style="text-align: right">Tổng hoá đơn</td>
													<td style="color: var(--button-color)"><fmt:formatNumber value="${ INVOICE.getINVOICE_GRAND_TOTAL() }" type="currency" currencySymbol="đ " maxFractionDigits="0"/></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="col c-12">
									<div class="form_controller">
										<a href="Admin?site=invoice" class="button back">Trở về</a>
										<c:if test="${ INVOICE.getINVOICE_STATUS() != 2 }">
											<button class="button"><c:if test="${ INVOICE.getINVOICE_STATUS() == 0 }">Tiến hành giao</c:if><c:if test="${ INVOICE.getINVOICE_STATUS() == 1 }">Hoàn tất giao</c:if></button>
										</c:if>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>