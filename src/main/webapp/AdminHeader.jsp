<div id="admin_header">
	<div class="grid wide">
		<div class="row">
			<div class="col c-12">
				<div class="admin_header_container">
					<div class="admin_header_item left_header">
						<a href="Home" class="admin_main_logo">
							<img alt="Admin Logo" src="./img/main-logo.webp">
						</a>
					</div>
					<div class="admin_header_item left_header">
						<div class="account_nav">
							<div class="account_name">${ sessionScope.account.getUSER_FULL_NAME() }</div>
							<a href="Logout" class="account_icon_link">
								<i class="fa-solid fa-arrow-right-from-bracket"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>