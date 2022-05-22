<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/base.css" />
<link rel="stylesheet" href="./css/Shop.css" />
<link rel="stylesheet" href="./css/Pagination.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/dbf2cd060c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="./Header.jsp" %>
	
	<div class="slick_slider_container shop_slider" style="background-image: url(./img/shop-slider.webp)" >
		<div class="content">
			<div class="main_title">Cửa hàng</div>
			<div class="description">Chúng tôi luôn bổ sung và cập nhật danh mục sản phẩm của mình để cung cấp cho khách hàng những loại thực phẩm tốt cho sức khoẻ</div>
		</div>
	</div>
	
	<div id="shop">
		<div class="shop_container">
			<div class="grid wide">
				<div class="row">
					<div class="col c-3">
						<div id="category_menu">
							<div class="hero_title">Phân loại sản phẩm</div>
							<div class="menu_item">
								<div class="title">Theo phân loại</div>
								<div class="menu_list">
									<div class="list_item" onClick="insertParam('category', 'all')" data-cate="all">Tất cả</div>
									<c:forEach items="${categories}" var="item">
										<div class="list_item" onClick="insertParam('category', '${item.CATEGORY_ID}')" data-cate="${item.CATEGORY_ID}">${item.CATEGORY_NAME}</div>
									</c:forEach>
								</div>
							</div>
							<div class="menu_item">
								<div class="title">Theo giá</div>
								<div class="price_bar_container">
									<input type="range" name="price-range" min="0" max="999000" step="10000" value=500000 class="price_bar">
									<div class="range_show">Tối đa: <span class="range_value">0</span></div>
									<div class="apply_price_range_button" onClick="insertParam('max', priceRangeBar.value)">Áp dụng</div>
								</div>
							</div>
							<div class="menu_item">
								<div class="title">Theo mùa</div>
								<div class="menu_list">
									<div class="radio_wrapper">
										<input type="radio" class="list_item" name="season" value="all" checked onClick="insertParam('season', 'all')">Tất cả</input>
									</div>
									<div class="radio_wrapper">
										<input type="radio" class="list_item" name="season" value="spring" onClick="insertParam('season', 'spring')">Mùa Xuân</input>
									</div>
									<div class="radio_wrapper">
										<input type="radio" class="list_item" name="season" value="summer" onClick="insertParam('season', 'summer')">Mùa Hạ</input>
									</div>
									<div class="radio_wrapper">
										<input type="radio" class="list_item" name="season" value="autumn" onClick="insertParam('season', 'autumn')">Mùa Thu</input>
									</div>
									<div class="radio_wrapper">
										<input type="radio" class="list_item" name="season" value="winter" onClick="insertParam('season', 'winter')">Mùa Đông</input>
									</div>
								</div>
							</div>
							<div class="menu_item">
								<div class="title">Theo quốc gia</div>
								<div class="menu_list">
									<c:forEach items="${countries}" var="item">
										<div class="checkbox_wrapper">
											<input type="checkbox" class="list_item">${item.COUNTRY_NAME}</input>									
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div class="col c-9">
						<div class="filter_container">
							<div class="label">Giá: </div>
							<select id="price_filter" name="sortby" onChange="insertParam('sortby', this.value)">
								<option value="default">Mặc định</option>
								<option value="asc">Giá thấp đến cao</option>
								<option value="desc">Giá cao đến thấp</option>
							</select>
						</div>
						<div class="products_container">
							<div class="row">
								<c:forEach items="${products}" var="item">
									<div class="col c-3">
											<div class="product">
												<a href="<%= request.getContextPath() %>/Product?PRODUCT_ID=${item.PRODUCT_ID}">
													<div class="image" style="background-image: url(./img/product.webp)"></div>
													<div class="informations">
														<div class="title">${item.PRODUCT_NAME}</div>
														<div class="price">${item.PRODUCT_PRICE}</div>
													</div>
												</a>
											</div>
										</div>
								</c:forEach>
							</div>
						</div>
						
						<%@include file="./Pagination.jsp" %>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./Footer.jsp" %>
	
	<script>	
		const priceRangeBar = document.querySelector("input[name='price-range']");
		const rangeValueElement = document.querySelector(".range_value");
		const seasonInput = document.querySelectorAll("input[name='season']");
		const categoryItems = document.querySelectorAll(".shop_container #category_menu .menu_item .menu_list > .list_item");
		const pageNumbers = document.querySelectorAll(".page_number_item");
		const priceFilter = document.querySelector("#price_filter");
		
		window.onload = e => {
			rangeValueElement.innerHTML = searchParams.get("max") || priceRangeBar.value;
			priceRangeBar.value = searchParams.get("max");
			categoryItems.forEach(Item => {
				if(Item.dataset.cate === searchParams.get("category") || (Item.dataset.cate === "all" && searchParams.get("category") == undefined)) {
					Item.classList.add("current");
				}
			})
			pageNumbers.forEach(number => {
				if(number.dataset.page === searchParams.get("page") || (number.dataset.page === "1" && searchParams.get("page") == undefined)) {
					number.classList.add("current");
				}
 			})
 			
 			if(searchParams.get("sortby") == undefined) {
 				priceFilter.value = "default";
 			} else {
 				priceFilter.value = searchParams.get("sortby");
 			}
		}
		
		priceRangeBar.oninput = e => {
			rangeValueElement.innerHTML = e.target.value;
		}
		
		
		seasonInput.forEach(input => {
			if(input.value === searchParams.get("season")) {
				input.checked = true
			}
		})

		function insertParam(key, value) {
		    key = encodeURIComponent(key);
		    value = encodeURIComponent(value);

		    // kvp looks like ['key1=value1', 'key2=value2', ...]
		    var kvp = document.location.search.substr(1).split('&');
		    let i=0;

		    for(; i<kvp.length; i++){
		        if (kvp[i].startsWith(key + '=')) {
		            let pair = kvp[i].split('=');
		            pair[1] = value;
		            kvp[i] = pair.join('=');
		            break;
		        }
		    }

		    if(i >= kvp.length){
		        kvp[kvp.length] = [key,value].join('=');
		    }

		    // can return this or...
		    let params = kvp.join('&');

		    // reload page with new params
		    document.location.search = params;
		}
	</script>
</body>
</html>