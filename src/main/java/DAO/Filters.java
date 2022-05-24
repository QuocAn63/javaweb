package DAO;

import java.util.ArrayList;

public class Filters {
	String CATEGORY;
	String MAX;
	String SEASON;
	String SORTBY;
	String q;
	int LIMIT = 20;
	int PAGE = 1;
	
	public Filters() {
		super();
	}

	public Filters(String cATEGORY, String mAX, String sEASON) {
		super();
		CATEGORY = cATEGORY;
		MAX = mAX;
		SEASON = sEASON;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		if(!cATEGORY.equals("all")) {
			CATEGORY = cATEGORY;	
		}
	}

	public String getMAX() {
		return MAX;
	}

	public void setMAX(String mAX) {
		MAX = mAX;
	}

	public String getSEASON() {
		return SEASON;
	}

	public void setSEASON(String sEASON) {
		if(!sEASON.equals("all")) {
			SEASON = sEASON;	
		}
	}
	
	public String getSORTBY() {
		return SORTBY;
	}

	public void setSORTBY(String sORTBY) {
		if(!sORTBY.equals("default")) {
			SORTBY = sORTBY;
		}
	}
	
	public int getLIMIT() {
		return LIMIT;
	}

	public void setLIMIT(int lIMIT) {
		LIMIT = lIMIT;
	}

	public int getPAGE() {
		return PAGE;
	}

	public void setPAGE(int pAGE) {
		PAGE = pAGE;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public boolean isEmpty() {
		return (CATEGORY == null && MAX == null && SEASON == null && q == null);
	}
	
	public String getQuery() {
		String query = "WHERE ";
		ArrayList<String> list = new ArrayList<String>();
		
		if(this.isEmpty()) {
			if(SORTBY != null) {
				return " ORDER BY PRODUCT_PRICE " + this.SORTBY;
			}
			
			return "";
		}
		
		if(q != null) {
			list.add("PRODUCT_NAME LIKE '%" + this.q + "%'");
		}
		
		if(CATEGORY != null) {
			list.add("CATEGORY = '" + this.CATEGORY + "'");
		}
		
		if(MAX != null) {
			list.add("PRODUCT_PRICE BETWEEN 0 AND " + this.MAX);
		}
		
		if(SEASON != null) {
			list.add("SEASON = '" + this.SEASON + "' || SEASON = 'all' ");
		}
		
		query += String.join(" AND ", list);
		
		if(SORTBY != null) {
			query += " ORDER BY PRODUCT_PRICE " + this.SORTBY;
		}
		
		return query;
	}
	
	public String getLimitQuery() {
		String query = this.getQuery();
		
		int Offset = (PAGE - 1)*LIMIT;
		query += " LIMIT " + Offset + " , " + LIMIT + " ";
		
		return query;
	}
}
