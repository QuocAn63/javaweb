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
			<div class="admin_shop_controller">
				<a href="AdminCountry?action=insert" class="button">Thêm xuất xứ</a>
				<a href="AdminCountry?action=delete" class="button delete">Quốc gia đã xoá <c:if test="${ DELETED_LENGTH != 0 }">(${ DELETED_LENGTH })</c:if></a>
			</div>
			<div class="admin_shop_main">
				<form id="country_form"></form>
				<table id="admin_shop_table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên xuất xứ</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ COUNTRIES }" var="COUNTRY">
							<tr>
								<td><c:out value="${ COUNTRY.getCOUNTRY_ID() }"></c:out></td>
								<td><c:out value="${ COUNTRY.getCOUNTRY_NAME() }"></c:out></td>
								<td>
									<div class="column_controllers">
										<a href="AdminCountry?action=edit&COUNTRY_ID=${ COUNTRY.getCOUNTRY_ID() }" class="button edit">Sửa</a>
										<div class="button delete" onClick="handleDeleteCountry('${ COUNTRY.getCOUNTRY_ID() }')">Xoá</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="./AddCountryPopup.jsp" ></jsp:include >
</body>
</html>