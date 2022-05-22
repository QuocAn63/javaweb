package DAO;

public class Country {
	String COUNTRY_ID;
	String COUNTRY_NAME;
	int IS_DISABLED;
	
	public Country() {
		super();
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