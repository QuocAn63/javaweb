package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAO {
	
	public ArrayList<Invoice> getAll() {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM INVOICE ORDER BY INVOICE_CREATED_AT DESC ");
			
			ResultSet result = stmt.executeQuery();
			
			ArrayList<Invoice> list = new ArrayList<Invoice>();
			
			while(result.next()) {
				Invoice invoice = new Invoice();
				
				String INVOICE_ID = result.getString("INVOICE_ID");

				invoice.setINVOICE_ID(INVOICE_ID);
				invoice.setUSER_ID(result.getString("USER_ID"));
				invoice.setRECEIVER_FULL_NAME(result.getString("RECEIVER_FULL_NAME"));
				invoice.setRECEIVER_ADDRESS(result.getString("RECEIVER_ADDRESS"));
				invoice.setRECEIVER_PHONE_NUMBER(result.getString("RECEIVER_PHONE_NUMBER"));
				invoice.setINVOICE_GRAND_TOTAL(result.getDouble("INVOICE_GRAND_TOTAL"));
				invoice.setINVOICE_CREATED_AT(result.getString("INVOICE_CREATED_AT"));
				invoice.setINVOICE_STATUS(result.getInt("INVOICE_STATUS"));
				invoice.setList(getAllProductsWithInvoiceID(INVOICE_ID));
				
				list.add(invoice);
			}
			
			return list;
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Invoice> getAllWithID(String USER_ID, InvoicesFilter FILTER) {
		String subQuery = FILTER.getQuery();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM INVOICE WHERE USER_ID = ? " + subQuery + " ORDER BY INVOICE_CREATED_AT DESC ");
			
			stmt.setString(1, USER_ID);
			
			ResultSet result = stmt.executeQuery();
			
			ArrayList<Invoice> list = new ArrayList<Invoice>();
			
			while(result.next()) {
				Invoice invoice = new Invoice();
				
				String INVOICE_ID = result.getString("INVOICE_ID");

				invoice.setINVOICE_ID(INVOICE_ID);
				invoice.setUSER_ID(result.getString("USER_ID"));
				invoice.setRECEIVER_FULL_NAME(result.getString("RECEIVER_FULL_NAME"));
				invoice.setRECEIVER_ADDRESS(result.getString("RECEIVER_ADDRESS"));
				invoice.setRECEIVER_PHONE_NUMBER(result.getString("RECEIVER_PHONE_NUMBER"));
				invoice.setINVOICE_GRAND_TOTAL(result.getDouble("INVOICE_GRAND_TOTAL"));
				invoice.setINVOICE_CREATED_AT(result.getString("INVOICE_CREATED_AT"));
				invoice.setINVOICE_STATUS(result.getInt("INVOICE_STATUS"));
				invoice.setList(getAllProductsWithInvoiceID(INVOICE_ID));
				
				list.add(invoice);
			}
			
			return list;
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<InvoiceItem> getAllProductsWithInvoiceID(String INVOICE_ID) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT INVOICE_ID, INVOICE_ITEM_ID, PRODUCT.PRODUCT_ID, QUANTITY, PRODUCT_PRICE, PRODUCT_NAME, CATEGORY, SEASON, COUNTRY, PRODUCT_IMAGE, PRODUCT.IS_DISABLED, CATEGORY_NAME, COUNTRY_NAME FROM INVOICE_ITEM JOIN PRODUCT ON INVOICE_ITEM.PRODUCT_ID = PRODUCT.PRODUCT_ID JOIN CATEGORY ON PRODUCT.CATEGORY = CATEGORY_ID JOIN COUNTRY ON PRODUCT.COUNTRY = COUNTRY_ID WHERE INVOICE_ID = ?");
			
			stmt.setString(1, INVOICE_ID);
			
			ResultSet result = stmt.executeQuery();
			
			ArrayList<InvoiceItem> list = new ArrayList<InvoiceItem>();
			
			while(result.next()) {
				InvoiceItem product = new InvoiceItem();
				
				product.PRODUCT.setPRODUCT_ID(result.getString("PRODUCT_ID"));
				product.PRODUCT.setPRODUCT_NAME(result.getString("PRODUCT_NAME"));
				product.PRODUCT.setPRODUCT_PRICE(result.getDouble("PRODUCT_PRICE"));
				product.PRODUCT.setCATEGORY(result.getString("CATEGORY"));
				product.PRODUCT.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				product.PRODUCT.setSEASON(result.getString("SEASON"));
				product.PRODUCT.setCOUNTRY(result.getString("COUNTRY"));
				product.PRODUCT.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				product.PRODUCT.setPRODUCT_IMAGE(result.getString("PRODUCT_IMAGE"));
				product.PRODUCT.setIS_DISABLED(result.getInt("IS_DISABLED"));
				product.setINVOICE_ID(result.getString("INVOICE_ID"));
				product.setQUANTITY(result.getInt("QUANTITY"));
				 
				list.add(product);
			}
			
			return list;
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean CreateInvoice(Invoice Invoice) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO INVOICE(USER_ID, RECEIVER_FULL_NAME, RECEIVER_ADDRESS, RECEIVER_PHONE_NUMBER, INVOICE_GRAND_TOTAL) VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, Invoice.getUSER_ID());
			stmt.setString(2, Invoice.getRECEIVER_FULL_NAME());
			stmt.setString(3, Invoice.getRECEIVER_ADDRESS());
			stmt.setString(4, Invoice.getRECEIVER_PHONE_NUMBER());
			stmt.setDouble(5, Invoice.getINVOICE_GRAND_TOTAL());
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			
			return AddProductsToInvoice(Invoice.getList());
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean AddProductsToInvoice(ArrayList<InvoiceItem> Products) {
		String INVOICE_ID = getLastedInvoiceID();
		String query = "INSERT INTO INVOICE_ITEM(INVOICE_ID, PRODUCT_ID, QUANTITY) VALUES ";
		ArrayList<String> valuesQueryArray = new ArrayList<String>();
		
		for(InvoiceItem Product : Products) {
			valuesQueryArray.add("(" + INVOICE_ID + ", " + Product.PRODUCT.getPRODUCT_ID() + ", " + Product.getQUANTITY() +")");
		}
		
		query += String.join(" , ", valuesQueryArray);
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			
			System.out.println(query);
			
			int result = stmt.executeUpdate();

			return result != 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String getLastedInvoiceID() {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT INVOICE_ID FROM INVOICE ORDER BY INVOICE_ID DESC LIMIT 1");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				return result.getString("INVOICE_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
