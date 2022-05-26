package DAO;

public class InvoicesFilter {
	String TYPE;
	
	public InvoicesFilter() {
		super();
	}

	public InvoicesFilter(String tYPE) {
		super();
		TYPE = tYPE;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		if(!tYPE.equals("all")) {
			TYPE = tYPE;			
		}
	}
	
	public boolean isEmpty() {
		return (TYPE == null);
	}
	
	public String getQuery() {
		String query = " AND ";
		if(!isEmpty()) {
			query += " INVOICE_STATUS = " + TYPE;
		} else {
			return "";
		}
		
		return query;
	}
	
	public String getSingleQuery() {
		if(!isEmpty()) {
			return " WHERE INVOICE_STATUS = " + TYPE;
		} else {
			return "";
		}
	}
}
