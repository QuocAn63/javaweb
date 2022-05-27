<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ action == 'update' }">
	<div class="adding_popup show">
		<div class="adding_container">
			<form action="AdminCategory?action=update&CATEGORY_ID=${ CATEGORY.getCATEGORY_ID() }" method="POST" class="adding_form">
				<div class="title">Sửa danh mục</div>
				<div class="text_area">
					<div class="label">Mã danh mục</div>
					<div class="text_content">${ CATEGORY.getCATEGORY_ID() }</div>
				</div>
				<div class="text_area">
					<div class="label">Tên danh mục</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="CATEGORY_NAME" value="${ CATEGORY.getCATEGORY_NAME() }">
					</div>
				</div>
				<div class="popup_controllers">
					<a href="Admin?site=category" class="button back">Trở về</a>
					<button class="button main">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</c:if>

<c:if test="${ action == 'insert' }">
	<div class="adding_popup show">
		<div class="adding_container">
			<form action="AdminCategory?action=insert" method="POST" class="adding_form">
				<div class="title">Thêm danh mục</div>
				<div class="text_area">
					<div class="label">Mã danh mục</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="CATEGORY_ID">
					</div>
				</div>
				<div class="text_area">
					<div class="label">Tên danh mục</div>
					<div class="input_wrapper">
						<input type="text" class="input_box" name="CATEGORY_NAME">
					</div>
				</div>
				<div class="popup_controllers">
					<a href="Admin?site=category" class="button back" >Trở về</a>
					<button class="button main">Thêm</button>
				</div>
			</form>
		</div>
	</div>
</c:if>