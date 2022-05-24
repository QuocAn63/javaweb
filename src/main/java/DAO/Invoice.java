package DAO;

import java.util.ArrayList;

public class Invoice {
	ArrayList<InvoiceItem> list = new ArrayList<InvoiceItem>();
	String INVOICE_ID;
	String USER_ID;
	String RECEIVER_FULL_NAME;
	String RECEIVER_ADDRESS;
	String RECEIVER_PHONE_NUMBER;
	String INVOICE_CREATED_AT;
	int INVOICE_STATUS;
	String INVOICE_STATUS_NAME;
	double INVOICE_GRAND_TOTAL;
	
	public Invoice() {
		super();
	}
	
	public Invoice(ArrayList<InvoiceItem> list, String uSER_ID, String rECEIVER_FULL_NAME,
			String rECEIVER_ADDRESS, String rECEIVER_PHONE_NUMBER, double iNVOICE_GRAND_TOTAL) {
		super();
		this.list = list;
		USER_ID = uSER_ID;
		RECEIVER_FULL_NAME = rECEIVER_FULL_NAME;
		RECEIVER_ADDRESS = rECEIVER_ADDRESS;
		RECEIVER_PHONE_NUMBER = rECEIVER_PHONE_NUMBER;
		INVOICE_GRAND_TOTAL = iNVOICE_GRAND_TOTAL;
	}
	
	public Invoice(ArrayList<InvoiceItem> list, String iNVOICE_ID, String uSER_ID, String rECEIVER_FULL_NAME,
			String rECEIVER_ADDRESS, String rECEIVER_PHONE_NUMBER, String iNVOICE_CREATED_AT, double iNVOICE_GRAND_TOTAL, int iNVOICE_STATUS) {
		super();
		this.list = list;
		INVOICE_ID = iNVOICE_ID;
		USER_ID = uSER_ID;
		RECEIVER_FULL_NAME = rECEIVER_FULL_NAME;
		RECEIVER_ADDRESS = rECEIVER_ADDRESS;
		RECEIVER_PHONE_NUMBER = rECEIVER_PHONE_NUMBER;
		INVOICE_CREATED_AT = iNVOICE_CREATED_AT;
		INVOICE_GRAND_TOTAL = iNVOICE_GRAND_TOTAL;
		INVOICE_STATUS = iNVOICE_STATUS;
	}

	public ArrayList<InvoiceItem> getList() {
		return list;
	}
	
	public void setList(ArrayList<InvoiceItem> list) {
		this.list = list;
	}
	
	public String getINVOICE_ID() {
		return INVOICE_ID;
	}
	
	public void setINVOICE_ID(String iNVOICE_ID) {
		INVOICE_ID = iNVOICE_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}
	
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	public String getRECEIVER_FULL_NAME() {
		return RECEIVER_FULL_NAME;
	}
	public void setRECEIVER_FULL_NAME(String rECEIVER_FULL_NAME) {
		RECEIVER_FULL_NAME = rECEIVER_FULL_NAME;
	}
	
	public String getRECEIVER_ADDRESS() {
		return RECEIVER_ADDRESS;
	}
	
	public void setRECEIVER_ADDRESS(String rECEIVER_ADDRESS) {
		RECEIVER_ADDRESS = rECEIVER_ADDRESS;
	}
	
	public String getRECEIVER_PHONE_NUMBER() {
		return RECEIVER_PHONE_NUMBER;
	}
	
	public void setRECEIVER_PHONE_NUMBER(String rECEIVER_PHONE_NUMBER) {
		RECEIVER_PHONE_NUMBER = rECEIVER_PHONE_NUMBER;
	}
	
	public String getINVOICE_CREATED_AT() {
		return INVOICE_CREATED_AT;
	}

	public void setINVOICE_CREATED_AT(String iNVOICE_CREATED_AT) {
		INVOICE_CREATED_AT = iNVOICE_CREATED_AT;
	}

	public double getINVOICE_GRAND_TOTAL() {
		return INVOICE_GRAND_TOTAL;
	}
	
	public void setINVOICE_GRAND_TOTAL(double iNVOICE_GRAND_TOTAL) {
		INVOICE_GRAND_TOTAL = iNVOICE_GRAND_TOTAL;
	}

	public int getINVOICE_STATUS() {
		return INVOICE_STATUS;
	}

	public void setINVOICE_STATUS(int iNVOICE_STATUS) {
		INVOICE_STATUS = iNVOICE_STATUS;
		
		setINVOICE_STATUS_NAME(iNVOICE_STATUS);
	}

	public String getINVOICE_STATUS_NAME() {
		return INVOICE_STATUS_NAME;
	}

	public void setINVOICE_STATUS_NAME(int INVOICE_STATUS) {
		switch (INVOICE_STATUS) {
			case 0: {
				INVOICE_STATUS_NAME = "Chờ xử lý";
			}
			break;
			
			case 1: {
				INVOICE_STATUS_NAME = "Đang giao";
			}
			break;
			
			case 2: {
				INVOICE_STATUS_NAME = "Đã giao";
			}
			break;
		}
	}
	
	
}
