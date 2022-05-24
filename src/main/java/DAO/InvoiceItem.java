package DAO;

public class InvoiceItem {
	Product PRODUCT = new Product();
	String INVOICE_ID;
	int QUANTITY;
	
	public InvoiceItem() {
		super();
	}
	
	public InvoiceItem(Product pRODUCT, int qUANTITY) {
		super();
		PRODUCT = pRODUCT;
		QUANTITY = qUANTITY;
	}
	
	public InvoiceItem(Product pRODUCT, String iNVOICE_ID, int qUANTITY) {
		super();
		PRODUCT = pRODUCT;
		INVOICE_ID = iNVOICE_ID;
		QUANTITY = qUANTITY;
	}

	public String getINVOICE_ID() {
		return INVOICE_ID;
	}

	public void setINVOICE_ID(String iNVOICE_ID) {
		INVOICE_ID = iNVOICE_ID;
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
