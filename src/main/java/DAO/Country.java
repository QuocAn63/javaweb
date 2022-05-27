package DAO;

public class Country {
	String COUNTRY_ID;
	String COUNTRY_NAME;
	int IS_DISABLED;
	
	public Country() {
		super();
	}
	
	public Country(String cOUNTRY_ID) {
		super();
		COUNTRY_ID = cOUNTRY_ID;
	}

	public Country(String cOUNTRY_ID, String cOUNTRY_NAME) {
		super();
		COUNTRY_ID = cOUNTRY_ID;
		COUNTRY_NAME = cOUNTRY_NAME;
	}

	public Country(String COUNTRY_ID, String COUNTRY_NAME, int iS_DISABLED) {
		super();
		this.COUNTRY_ID = COUNTRY_ID;
		this.COUNTRY_NAME = COUNTRY_NAME;
		IS_DISABLED = iS_DISABLED;
	}
	
	public String getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(String COUNTRY_ID) {
		this.COUNTRY_ID = COUNTRY_ID;
	}
	public String getCOUNTRY_NAME() {
		return COUNTRY_NAME;
	}
	public void setCOUNTRY_NAME(String COUNTRY_NAME) {
		this.COUNTRY_NAME = COUNTRY_NAME;
	}
	public int getIS_DISABLED() {
		return IS_DISABLED;
	}
	public void setIS_DISABLED(int iS_DISABLED) {
		IS_DISABLED = iS_DISABLED;
	}
	
}