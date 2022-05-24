package DAO;

public class CartItem {
	Product PRODUCT;
	int QUANTITY;
	
	public CartItem() {
		super();
	}
	
	public Product getPRODUCT() {
		return PRODUCT;
	}



	public void setPRODUCT(Product pRODUCT) {
		PRODUCT = pRODUCT;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}
	
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	
	public double getTotal() {
		return PRODUCT.getPRODUCT_PRICE()*QUANTITY;
	}
}