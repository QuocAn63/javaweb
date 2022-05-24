<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div class="navigation">
		<div class="navigation_container">
			<div class="navigation_item">
				<a href="Home" class="logo_container">
					<div class="main-logo background-area" style="background-image: url(./img/main-logo.webp)"></div>
					<div class="logo-title">natureFruits</div>
				</a>
			</div>
			<div class="navigation_item">
				<div class="navigation_link_container">
					<a href="Home" class="navigation_link">
						Trang chủ
					</a>
					<a href="<%= request.getContextPath() %>/ShopProducts" class="navigation_link">
						Cửa hàng
					</a>
					<c:if test="${ sessionScope.account.USER_ROLE == 1 }">
						<a href="Admin" class="navigation_link">
							Quản lý sản phẩm
						</a>
						<a href="Admin" class="navigation_link">
							Quản lý người dùng
						</a>			
					</c:if>
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
								<a href="GoToUser?site=profile" class="user_controller_item">
									Thông tin tài khoản
								</a>
								<a href="GoToUser?site=invoices" class="user_controller_item">
									Đơn hàng
								</a>
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
						<i class="fa-solid fa-cart-shopping dropdown_clickable">
							<c:if test="${ sessionScope.cart.list.size() > 0}">
								<div class="product_count"><c:out value="${ sessionScope.cart.list.size() }"></c:out></div>
							</c:if>
						</i>
						<div class="user_cart_popup dropdown">
							<form class="cart_controllers_form"></form>
							<div class="items_container">
								<c:forEach items="${ sessionScope.cart.list }" var="item" >
									<div class="cart_item">
										<div class="image background-area" style="background-image: url(./img/banana.webp)"></div>
										<div class="information">
											<div class="name">${ item.PRODUCT.getPRODUCT_NAME() }</div>
											<div class="quantity">x${ item.getQUANTITY() }</div>
											<div class="price">${ item.PRODUCT.getPRODUCT_PRICE() }</div>	
										</div>
										<div class="controller">
											<button type="button" onClick="removeFromCart(${ item.PRODUCT.getPRODUCT_ID() })">&times;</button>
										</div>
									</div>
								</c:forEach>
							</div>
							<c:if test="${ sessionScope.cart != null }">
								<div class="cart_info">
									<div class="item">
										<div class="title">Tổng giá:</div>
										<div class="value"><c:out value="${ sessionScope.cart.getTotal() }"></c:out></div>
									</div>
									<div class="item">
										<div class="title">Phí vận chuyển:</div>
										<div class="value">Miễn phí</div>
									</div>
									<div class="item">
										<div class="title">Thành tiền:</div>
										<div class="value"><c:out value="${ sessionScope.cart.getTotal() }"></c:out></div>
									</div>
								</div>
								<div class="cart_controllers">
									<a href="GoToCartPage" class="button" >
										Xem giỏ hàng
									</a>
									<a href="<%= request.getContextPath() %>/Checkout" class="button">
										Thanh toán
									</a>
								</div>
							</c:if>
							<c:if test="${ sessionScope.cart == null }">
								<div class="cart_empty" style="background-image: url(./img/empty-cart.png)">
									<span>Giỏ hàng trống</span>
								</div>
							</c:if>
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