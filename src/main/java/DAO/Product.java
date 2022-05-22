package DAO;

public class Product {
	String PRODUCT_ID;
	String PRODUCT_NAME;
	Double PRODUCT_PRICE;
	String CATEGORY;
	String CATEGORY_NAME;
	String SEASON;
	String COUNTRY;
	String COUNTRY_NAME;
	String PRODUCT_IMAGE;
	int IS_DISABLED;
	
	public Product() {
		super();
	}
	
	public Product(String pRODUCT_ID, String pRODUCT_NAME, Double pRODUCT_PRICE, String cATEGORY, String cATEGORY_NAME, String sEASON,
			String cOUNTRY, String cOUNTRY_NAME, String pRODUCT_IMAGE, int iS_DISABLED) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_PRICE = pRODUCT_PRICE;
		CATEGORY = cATEGORY;
		CATEGORY_NAME = cATEGORY_NAME;
		SEASON = sEASON;
		COUNTRY = cOUNTRY;
		COUNTRY_NAME = cOUNTRY_NAME;
		PRODUCT_IMAGE = pRODUCT_IMAGE;
		IS_DISABLED = iS_DISABLED;
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
	public Double getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(Double pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getSEASON() {
		return SEASON;
	}
	public void setSEASON(String sEASON) {
		SEASON = sEASON;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}

	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}

	public String getCOUNTRY_NAME() {
		return COUNTRY_NAME;
	}

	public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
		COUNTRY_NAME = cOUNTRY_NAME;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getPRODUCT_IMAGE() {
		return PRODUCT_IMAGE;
	}
	public void setPRODUCT_IMAGE(String pRODUCT_IMAGE) {
		PRODUCT_IMAGE = pRODUCT_IMAGE;
	}
	public int getIS_DISABLED() {
		return IS_DISABLED;
	}
	public void setIS_DISABLED(int iS_DISABLED) {
		IS_DISABLED = iS_DISABLED;
	}
	
	
}