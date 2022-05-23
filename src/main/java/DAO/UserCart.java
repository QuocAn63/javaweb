package DAO;

import java.util.ArrayList;

public class UserCart {
	ArrayList<CartItem> list = new ArrayList<CartItem>();
	double Total;
	
	public ArrayList<CartItem> getList() {
		return list;
	}
	
	public void setList(ArrayList<CartItem> list) {
		this.list = list;
	}
	
	public double getTotal() {
		return Total;
	}
	
	public void setTotal(double total) {
		Total = total;
	}
	
	public void AddToCart(String PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_IMAGE, double PRODUCT_PRICE, int QUANTITY) {
		CartItem item = new CartItem();
		if(QUANTITY > 0) {
			item.setPRODUCT_ID(PRODUCT_ID);
			item.setPRODUCT_NAME(PRODUCT_NAME);
			item.setPRODUCT_IMAGE(PRODUCT_IMAGE);
			item.setPRODUCT_PRICE(PRODUCT_PRICE);
			item.setQUANTITY(QUANTITY);
			list.add(item);
		}
	}
	
	public void CalculateTotal() {
		double result = 0;
		for(CartItem product : list) {
			result += product.getPRODUCT_PRICE()*product.getQUANTITY();
		}
		
		setTotal(result);
	}
}