/**
 * 
 */

const addToCartButton = document.querySelectorAll(".add_to_cart_button");

const addToCart = (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE) => {
    const form = document.querySelector(".add_to_cart_form");
    form.action = `CartController?ACTION=ADDTOCART&PRODUCT_ID=${PRODUCT_ID}&PRODUCT_NAME=${PRODUCT_NAME}&PRODUCT_IMAGE=${PRODUCT_IMAGE}&PRODUCT_PRICE=${PRODUCT_PRICE}`;
    form.method = "POST";
    form.submit();
}