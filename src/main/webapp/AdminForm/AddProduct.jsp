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
						<div class="hero_title">Thêm sản phẩm</div>
						<form action="AdminProduct" method="POST" enctype='multipart/form-data'>
							<div class="row">
								<div class="col c-6">
									<div class="form_container">
										<div class="text_area">
											<div class="label">Tên sản phẩm</div>
											<div class="input_wrapper">
												<input class="input_box" type="text" name="PRODUCT_NAME">
											</div>
										</div>
										<div class="text_area">
											<div class="label">Giá</div>
											<div class="input_wrapper">
												<input class="input_box" type="number" name="PRODUCT_PRICE">
											</div>
										</div>
										<div class="text_area select_container">
											<div class="select_text_area">
												<div class="label">Mùa</div>
												<div class="select-wrapper">
													<select name="SEASON">
														<option value="all">Tất cả</option>
														<option value="all">Xuân</option>
														<option value="all">Hạ</option>
														<option value="all">Thu</option>
														<option value="all">Đông</option>
													</select>
												</div>
											</div>
											<div class="select_text_area">
												<div class="label">Danh mục</div>
												<div class="select-wrapper">
													<select name="CATEGORY">
														<c:forEach items="${ CATEGORIES }" var="CATEGORY">
															<option value="${CATEGORY.getCATEGORY_ID()}">${ CATEGORY.getCATEGORY_NAME() }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="select_text_area">
												<div class="label">Xuất xứ</div>
												<div class="select-wrapper">
													<select name="COUNTRY">
														<c:forEach items="${ COUNTRIES }" var="COUNTRY">
															<option value="${ COUNTRY.getCOUNTRY_ID() }">${ COUNTRY.getCOUNTRY_NAME() }</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="text_area">
											<div class="label">Mô tả</div>
											<textarea class="product_description" name="PRODUCT_DESCRIPTION"></textarea>
										</div>
									</div>
								</div>
								<div class="col c-6">
									<div class="image_preview_side">
										<div class="label">Ảnh sản phẩm</div>
										<div class="image_holder">
											<div class="image"></div>
										</div>
										<div class="image_controller">
											<input type="file" multiple id="file_input" name="PRODUCT_IMAGE"> 
											<button type="button" class="button" onClick="document.querySelector('#file_input').click()">Chọn ảnh</button>
										</div>
									</div>
								</div>
								<div class="col c-12">
									<div class="form_controller">
										<button class="button">Thêm</button>
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