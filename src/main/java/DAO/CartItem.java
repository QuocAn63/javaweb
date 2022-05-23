package DAO;

public class CartItem {
	String PRODUCT_ID;
	String PRODUCT_NAME;
	String PRODUCT_IMAGE;
	double PRODUCT_PRICE;
	int QUANTITY;
	
	public CartItem() {
		super();
	}
	
	public CartItem(String pRODUCT_ID, String pRODUCT_NAME, String pRODUCT_IMAGE, double pRODUCT_PRICE,
			int qUANTITY) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_IMAGE = pRODUCT_IMAGE;
		PRODUCT_PRICE = pRODUCT_PRICE;
		QUANTITY = qUANTITY;
	}
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_IMAGE() {
		return PRODUCT_IMAGE;
	}
	public void setPRODUCT_IMAGE(String pRODUCT_IMAGE) {
		PRODUCT_IMAGE = pRODUCT_IMAGE;
	}
	public double getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(double pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	
	
}