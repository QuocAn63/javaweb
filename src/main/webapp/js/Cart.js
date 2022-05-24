/**
 * 
 */

const addToCart = (PRODUCT_ID) => {
    const form = document.querySelector(".cart_controllers_form");
    form.action = `CartController?ACTION=ADDTOCART&PRODUCT_ID=${PRODUCT_ID}`;
    form.method = "POST";
    form.submit();
}

const removeFromCart = (PRODUCT_ID) => {
	const form = document.querySelector(".cart_controllers_form");
    form.action = `CartController?ACTION=DELETEFROMCART&PRODUCT_ID=${PRODUCT_ID}`;
    form.method = "POST";
    form.submit();
}

const handleChangeProductQuantity = (PRODUCT_ID, QUANTITY) => {
	QUANTITY = QUANTITY >= 1 ? QUANTITY : 1;
	const form = document.querySelector(".cart_controllers_form");
	form.action = `CartController?ACTION=EDITCART&PRODUCT_ID=${PRODUCT_ID}&QUANTITY=${QUANTITY}`;
	form.method = "POST";
	form.submit();
}

console.log("Hello from cart")  

