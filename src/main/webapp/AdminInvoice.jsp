<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<%@include file="./AdminHeader.jsp" %>

	<%@include file="./AdminSidebar.jsp" %>
	
	<div id="admin_content_container">
		<div id="admin_shop">
			<div class="admin_shop_main">
				<div class="invoice_status_controller">
					<div class="label">Xem đon hàng: </div>
					<select onChange="insertParam('status', this.value)" name="INVOICE_STATUS">
						<option value="all">Tất cả</option>
						<option value="0">Chờ xử lý</option>
						<option value="1">Đang giao</option>
						<option value="2">Đã giao</option>
					</select>
				</div>
				<table id="admin_shop_table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Người nhận</th>
							<th>Địa chỉ</th>
							<th>Số điện thoại</th>
							<th>Ngày đặt</th>
							<th>Tình trạng</th>
							<th>Thay đổi</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ INVOICES }" var="INVOICE">
							<tr>
								<td><c:out value="${ INVOICE.getINVOICE_ID() }"></c:out></td>
								<td><c:out value="${ INVOICE.getRECEIVER_FULL_NAME() }"></c:out></td>
								<td><c:out value="${ INVOICE.getRECEIVER_ADDRESS() }"></c:out></td>
								<td><c:out value="${ INVOICE.getRECEIVER_PHONE_NUMBER() }"></c:out></td>
								<td><c:out value="${ INVOICE.getINVOICE_CREATED_AT() }"></c:out></td>
								<td>
									<c:choose>
										<c:when test="${ INVOICE.getINVOICE_STATUS() == 1 }">Đang giao</c:when>
										<c:when test="${ INVOICE.getINVOICE_STATUS() == 2 }">Đã giao</c:when>
										<c:otherwise>Chờ xử lý</c:otherwise>
									</c:choose>
								</td>
								<td>
									<div class="column_controllers">
										<a href="AdminInvoice?INVOICE_ID=${ INVOICE.getINVOICE_ID() }" class="button edit">Xem</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>