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
	<%@include file="../AdminHeader.jsp" %>

	
	<div id="admin_form">
		<div class="grid wide">
			<div class="row">
				<div class="col c-12">
					<div id="admin_product_adding_form">
						<div class="hero_title">Chỉnh sửa thông tin</div>
						<form action="AdminUser?action=update&USER_ID=${ USER.getUSER_ID() }" method="POST">
							<div class="row">
								<div class="col c-12">
									<div class="form_container">
										<div class="text_area">
											<div class="label">Họ và tên</div>
											<div class="input_wrapper">
												<input class="input_box" type="text" name="USER_FULL_NAME" value="${ USER.getUSER_FULL_NAME() }">
											</div>
										</div>
										<div class="text_area">
											<div class="label">Địa chỉ Email</div>
											<div class="input_wrapper">
												<input class="input_box" type="email" name="USER_EMAIL" value="${ USER.getUSER_EMAIL() }" >
											</div>
										</div>
										<div class="text_area">
											<div class="label">Số điện thoại</div>
											<div class="input_wrapper">
												<input class="input_box" type="number" name="USER_PHONE_NUMBER" value="${ USER.getUSER_PHONE_NUMBER() }" >
											</div>
										</div>
										<div class="text_area">
											<div class="label">Địa chỉ</div>
											<textarea class="product_description" name="USER_ADDRESS"><c:out value='${ USER.getUSER_ADDRESS() }' ></c:out></textarea>
										</div>
										<div class="text_area select_text_area">
											<div class="label">Vai trò</div>
											<div class="select-wrapper">
												<select name="USER_ROLE">
													<c:forEach items="${ ROLES }" var="ROLE">
														<option value="${ROLE.getROLE_ID() }">${ROLE.getROLE_NAME()}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="text_area select_text_area">
											<div class="label">Tình trạng</div>
											<div class="select-wrapper">
												<select name="IS_DISABLED">
													<option value="0">Hoạt động</option>
													<option value="1">Ngưng hoạt động</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col c-12">
									<div class="form_controller">
										<button class="button">Sửa</button>
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