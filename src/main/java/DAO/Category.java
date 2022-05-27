package DAO;

public class Category {
	String CATEGORY_ID;
	String CATEGORY_NAME;
	int IS_DISABLED;
	
	public Category() {
		super();
	}
	
	public Category(String cATEGORY_ID) {
		super();
		CATEGORY_ID = cATEGORY_ID;
	}

	public Category(String cATEGORY_ID, String cATEGORY_NAME) {
		super();
		CATEGORY_ID = cATEGORY_ID;
		CATEGORY_NAME = cATEGORY_NAME;
	}

	public Category(String cATEGORY_ID, String cATEGORY_NAME, int iS_DISABLED) {
		super();
		CATEGORY_ID = cATEGORY_ID;
		CATEGORY_NAME = cATEGORY_NAME;
		IS_DISABLED = iS_DISABLED;
	}
	
	public String getCATEGORY_ID() {
		return CATEGORY_ID;
	}
	public void setCATEGORY_ID(String cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	public int getIS_DISABLED() {
		return IS_DISABLED;
	}
	public void setIS_DISABLED(int iS_DISABLED) {
		IS_DISABLED = iS_DISABLED;
	}
	
}