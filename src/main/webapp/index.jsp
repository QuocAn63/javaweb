<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>natureFruits</title>
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/main.css" />
<script type="text/javascript" src="./js/Cart.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container" style="background-image: url(./img/main-theme.webp)" >
		<div class="content">
			<div class="title">Sản phẩm hữu cơ</div>
			<div class="main_title">Xoài</div>
			<div class="description">Chúng tôi tin rằng ăn uống lành mạnh, không khí trong lành và tính cách nhẹ nhàng là khởi đầu tốt nhất để có được sức khỏe chân chính.</div>
		</div>
	</div>
	
	<div class="banner_container">
		<div class="grid wide" >
			<div class="row" style="flex-wrap: nowrap">
				<div class="col c-6">
					<div class="banner background-area" style="background-image: url(./img/banner1.webp)"></div>
				</div>
				<div class="col c-6">
					<div class="banner background-area" style="background-image: url(./img/banner2.webp)"></div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="products_section" style="background-image: url(./img/sub-theme.webp)">
		<div class="grid wide">
			<div class="row">
				<div class="col c-12">
					<div class="products_list_container">
						<div class="hero_title">Sản phẩm nổi bật</div>
						<div class="row">
							<c:forEach items="${ Products }" var="product">
								<div class="col c-3">
									<div class="product">
										<div class="image" style="background-image: url(./img/product.webp)"></div>
										<div class="informations">
											<div class="title">${ product.getPRODUCT_NAME() }</div>
											<div class="price">${ product.getPRODUCT_PRICE() }</div>
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
	
	<div class="slick_slider_container" style="background-image: url(./img/main-theme-2.webp)" >
		<div class="content">
			<div class="title">Sản phẩm hữu cơ</div>
			<div class="main_title">Cam</div>
			<div class="description">Cam là loại quả rất giàu chất dinh dưỡng. Người ta tính ra trong mỗi 100 gr quả cam có chứa 87,6 g nước, 1.104 microgram carotene, 30 mg vitamin C, 10,9 g chất tinh bột, 93 mg kali, 26 mg canxi. Ngoài ra, với trọng lượng cam tương tự còn có chứa 9 mg magnesium, 0,3 g chất xơ, 4,5 mg natri, 7 mg chromium, 20 mg phốt pho, 0,32 mg sắt và giá trị năng lượng là 48 Kcal.</div>
		</div>
	</div>
	
	<%@include file="./Footer.jsp" %>
</body>
</html>