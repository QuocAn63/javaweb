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
	
	public void AddToCart(String PRODUCT_ID) {
		CartItem item = new CartItem();
		ProductDAO DAO = new ProductDAO();
		item.setPRODUCT(DAO.getProduct(PRODUCT_ID));
		item.QUANTITY = 1;
		list.add(item);
		CalculateTotal();
	}
	
	public boolean isExisting(String PRODUCT_ID) {		
		for(CartItem cartItem : list) {
			if(cartItem.PRODUCT.getPRODUCT_ID().equals(PRODUCT_ID)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void extraProduct(String PRODUCT_ID) {
		for(CartItem cartItem : list) {
			if(cartItem.PRODUCT.getPRODUCT_ID().equals(PRODUCT_ID)) {
				cartItem.QUANTITY += 1;
			}
		}
	}
	
	public boolean RemoveFromCart(String pRODUCT_ID) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).PRODUCT.getPRODUCT_ID().equals(pRODUCT_ID)) {
				list.remove(i);
			}
		}
		CalculateTotal();
		
		return list.size() != 0;
		
	}
	
	public void EditProductQuantity(String PRODUCT_ID, int QUANTITY) {
		for(CartItem item : list) {
			if(item.PRODUCT.getPRODUCT_ID().equals(PRODUCT_ID)) {
				item.setQUANTITY(QUANTITY);
			}
		}
		CalculateTotal();
	}
	
	public void CalculateTotal() {
		double result = 0;
		for(CartItem product : list) {
			result += product.getTotal();
		}
		
		setTotal(result);
	}

	
	
	@Override
	public String toString() {
		for(CartItem item : list) {
			item.toString();
		}
		return "UserCart [list=" + list + ", Total=" + Total + "]";
	}

	
	
	
}