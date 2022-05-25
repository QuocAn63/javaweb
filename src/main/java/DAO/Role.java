package DAO;

public class Role {
	String ROLE_ID;
	String ROLE_NAME;
	
	public Role() {
		super();
	}

	public Role(String rOLE_ID, String rOLE_NAME) {
		super();
		ROLE_ID = rOLE_ID;
		ROLE_NAME = rOLE_NAME;
	}

	public String getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public String getROLE_NAME() {
		return ROLE_NAME;
	}

	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}
	
	
}
