<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<div id="header">
	<div class="navigation">
		<div class="navigation_container">
			<div class="navigation_item">
				<a href="<%= request.getContextPath() %>" class="logo_container">
					<div class="main-logo background-area" style="background-image: url(./img/main-logo.webp)"></div>
					<div class="logo-title">natureFruits</div>
				</a>
			</div>
			<div class="navigation_item">
				<div class="navigation_link_container">
					<a href="<%= request.getContextPath() %>" class="navigation_link">
						Trang chủ
					</a>
					<a href="<%= request.getContextPath() %>/ShopProducts" class="navigation_link">
						Cửa hàng
					</a>
				</div>
			</div>
			<div class="navigation_item">
				<div class="navigation_controllers">
					<div class="search dropdown_button">
						<i class="fa-solid fa-magnifying-glass dropdown_clickable"></i>
						<div class="search-bar dropdown">
							<input type="text" id="search_input" placeholder="Tìm kiếm sản phẩm">
							<button type="button" id="search_button" >Tìm</button>
						</div>
					</div>
					<div class="account dropdown_button">
						<div class="dropdown_clickable">
							<c:if test="${ sessionScope.account != null }">
								<span class="user_controller_item user_name" style="margin-right: 6px">${ sessionScope.account.USER_FULL_NAME }</span>
							</c:if>
							<i class="fa-solid fa-gear"></i>
						</div>
						<div class="user_controller_container dropdown">
							<c:if test="${ sessionScope.account != null }">
								<c:if test="${ sessionScope.account.USER_ROLE == 1 }">
									<div class="user_controller_item">
										Quản lý sản phẩm
									</div>
								</c:if>
								<div class="user_controller_item">
									Đơn hàng
								</div>
								<a href="<%= request.getContextPath() %>/Logout" class="user_controller_item">
									Đăng xuất
								</a>
							</c:if>
							<c:if test="${ sessionScope.account == null }">
								<a href="<%= request.getContextPath() %>/Login.jsp" class="user_controller_item user_controller_item_link">
									Đăng nhập
								</a>
								<a href="<%= request.getContextPath() %>/Register.jsp" class="user_controller_item user_controller_item_link">
									Đăng ký
								</a>
							</c:if>
						</div>
					</div>
					<div class="cart dropdown_button">
						<i class="fa-solid fa-cart-shopping dropdown_clickable"></i>
						<div class="user_cart_popup dropdown">
							<div class="items_container">
								<div class="cart_item">
									<div class="image background-area" style="background-image: url(./img/banana.webp)"></div>
									<div class="information">
										<div class="name">Chuối</div>
										<div class="quantity">x1</div>
										<div class="price">40</div>	
									</div>
									<div class="controller">
										<button type="button">&times;</button>
									</div>
								</div>
								<div class="cart_item">
									<div class="image background-area" style="background-image: url(./img/banana.webp)"></div>
									<div class="information">
										<div class="name">Chuối</div>
										<div class="quantity">x1</div>
										<div class="price">40</div>	
									</div>
									<div class="controller">
										<button type="button">&times;</button>
									</div>
								</div>
							</div>
							<div class="cart_info">
								<div class="item">
									<div class="title">Tổng giá:</div>
									<div class="value">80</div>
								</div>
								<div class="item">
									<div class="title">Phí vận chuyển:</div>
									<div class="value">Miễn phí</div>
								</div>
								<div class="item">
									<div class="title">Thành tiền:</div>
									<div class="value">80</div>
								</div>
							</div>
							<div class="cart_controllers">
								<a href="<%= request.getContextPath() %>/Cart" class="button" >
									Xem giỏ hàng
								</a>
								<a href="<%= request.getContextPath() %>/Checkout" class="button">
									Thanh toán
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	const dropDownButton = document.querySelectorAll(".navigation_controllers .dropdown_button .dropdown_clickable")
	const searchButton = document.querySelector("#search_button")
	const searchParams = new URLSearchParams(window.location.search);
	
	searchButton.onclick = e => {
		const q = document.querySelector("#search_input").value;
		if(window.location === "/demo/ShopProducts") {
			insertParam("q", q);
		} else {
			window.location.href = "/demo/ShopProducts?q=" + q;
		}
	}
	
	dropDownButton.forEach(button => {
		button.onclick = (e) => {
			let dropDown;
			if(e.target.closest(".dropdown_button")) {
				dropDown = e.target.closest(".dropdown_button").querySelector(".dropdown")
			} else {
				dropDown = e.target.querySelector(".dropdown")
			}
			
			dropDown.classList.toggle("show")
		}
	})
</script>