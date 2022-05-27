<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ action == 'update' }">
	<div class="adding_popup show">
		<div class="adding_container">
			<form action="AdminCountry?action=update&COUNTRY_ID=${ COUNTRY.getCOUNTRY_ID() }" method="POST" class="adding_form">
				<div class="title">Sửa quốc gia</div>
				<div class="text_area">
					<div class="label">Mã quốc gia</div>
					<div class="text_content">${ COUNTRY.getCOUNTRY_ID() }</div>
				</div>
				<div class="text_area">
					<div class="label">Tên quốc gia</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="COUNTRY_NAME" value="${ COUNTRY.getCOUNTRY_NAME() }">
					</div>
				</div>
				<div class="popup_controllers">
					<a href="Admin?site=country" class="button back">Trở về</a>
					<button class="button main">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</c:if>

<c:if test="${ action == 'insert' }">
	<div class="adding_popup show">
		<div class="adding_container">
			<form action="AdminCountry?action=insert" method="POST" class="adding_form">
				<div class="title">Thêm quốc gia</div>
				<div class="text_area">
					<div class="label">Mã quốc gia</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="COUNTRY_ID">
					</div>
				</div>
				<div class="text_area">
					<div class="label">Tên quốc gia</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="COUNTRY_NAME">
					</div>
				</div>
				<div class="popup_controllers">
					<a href="Admin?site=country" class="button back" >Trở về</a>
					<button class="button main">Thêm</button>
				</div>
			</form>
		</div>
	</div>
</c:if>