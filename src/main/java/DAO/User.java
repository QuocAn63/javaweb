package DAO;

public class User {
	String USER_ID;
	String USER_NAME;
	String USER_PASSWORD;
	String USER_EMAIL;
	String USER_PHONE_NUMBER;
	String USER_ADDRESS;
	String USER_FULL_NAME;
	int USER_GENDER;
	String USER_DOB;
	int USER_ROLE;
	int IS_DISABLED;
	
	public User() {
		super();
	}
	
	public User(String uSER_ID, String uSER_NAME, String uSER_PASSWORD, String uSER_EMAIL, String uSER_PHONE_NUMBER,
			String uSER_FULL_NAME, int uSER_GENDER, String uSER_DOB, String uSER_ADDRESS, int uSER_ROLE, int iS_DISABLED) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_EMAIL = uSER_EMAIL;
		USER_PHONE_NUMBER = uSER_PHONE_NUMBER;
		USER_FULL_NAME = uSER_FULL_NAME;
		USER_GENDER = uSER_GENDER;
		USER_DOB = uSER_DOB;
		USER_ADDRESS = uSER_ADDRESS;
		USER_ROLE = uSER_ROLE;
		IS_DISABLED = iS_DISABLED;
	}
	
	public User(String uSER_NAME, String uSER_PASSWORD, String uSER_EMAIL, String uSER_PHONE_NUMBER, String uSER_FULL_NAME) {
		super();
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_EMAIL = uSER_EMAIL;
		USER_PHONE_NUMBER = uSER_PHONE_NUMBER;
		USER_FULL_NAME = uSER_FULL_NAME;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}
	
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	public String getUSER_NAME() {
		return USER_NAME;
	}
	
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	
	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}

	public void setUSER_ADDRESS(String uSER_ADDRESS) {
		USER_ADDRESS = uSER_ADDRESS;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	
	public String getUSER_PHONE_NUMBER() {
		return USER_PHONE_NUMBER;
	}
	
	public void setUSER_PHONE_NUMBER(String uSER_PHONE_NUMBER) {
		USER_PHONE_NUMBER = uSER_PHONE_NUMBER;
	}
	
	public String getUSER_FULL_NAME() {
		return USER_FULL_NAME;
	}
	
	public void setUSER_FULL_NAME(String uSER_FULL_NAME) {
		USER_FULL_NAME = uSER_FULL_NAME;
	}
	
	public int getUSER_GENDER() {
		return USER_GENDER;
	}
	
	public void setUSER_GENDER(int uSER_GENDER) {
		USER_GENDER = uSER_GENDER;
	}
	
	public String getUSER_DOB() {
		return USER_DOB;
	}
	
	public void setUSER_DOB(String uSER_DOB) {
		USER_DOB = uSER_DOB;
	}
	
	public int getUSER_ROLE() {
		return USER_ROLE;
	}
	
	public void setUSER_ROLE(int uUSER_ROLE) {
		USER_ROLE = uUSER_ROLE;
	}
	
	public int getIS_DISABLED() {
		return IS_DISABLED;
	}
	
	public void setIS_DISABLED(int iS_DISABLED) {
		IS_DISABLED = iS_DISABLED;
	}
}