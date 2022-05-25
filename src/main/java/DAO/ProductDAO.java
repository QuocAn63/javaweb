package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDAO
 */
@WebServlet("/ProductDAO")
public class ProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public boolean Insert(DAO.Product Product) {
    	try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESCRIPTION, CATEGORY, SEASON, COUNTRY, PRODUCT_IMAGE) VALUES(?, ?, ?, ?, ? ,? , ?)");

			stmt.setString(1, Product.getPRODUCT_NAME());
			stmt.setDouble(2, Product.getPRODUCT_PRICE());
			stmt.setString(3, Product.getPRODUCT_DESCRIPTION());
			stmt.setString(4, Product.getCATEGORY());
			stmt.setString(5, Product.getSEASON());
			stmt.setString(6, Product.getCOUNTRY());
			stmt.setString(7, Product.getPRODUCT_IMAGE());
			
			int result = stmt.executeUpdate();
			stmt.close();
			conn.close();
			
			return result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean Update(DAO.Product Product) {
    	try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE PRODUCT SET PRODUCT_NAME = ?, PRODUCT_PRICE = ?, PRODUCT_DESCRIPTION = ?, CATEGORY = ?, SEASON = ?, COUNTRY = ?, PRODUCT_IMAGE = ? WHERE PRODUCT_ID = ? ");
			
			stmt.setString(1, Product.getPRODUCT_NAME());
			stmt.setDouble(2, Product.getPRODUCT_PRICE());
			stmt.setString(3, Product.getPRODUCT_DESCRIPTION());
			stmt.setString(4, Product.getCATEGORY());
			stmt.setString(5, Product.getSEASON());
			stmt.setString(6, Product.getCOUNTRY());
			stmt.setString(7, Product.getPRODUCT_IMAGE());
			stmt.setString(8, Product.getPRODUCT_ID());
			int result = stmt.executeUpdate();
			
			return result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean Delete(String PRODUCT_ID) {
    	try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE PRODUCT SET IS_DISABLED = ? WHERE PRODUCT_ID = ? ");
			
			stmt.setInt(1, 1);
			stmt.setString(2, PRODUCT_ID);
			int result = stmt.executeUpdate();
			
			return result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean CancelDelete(String PRODUCT_ID) {
    	try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE PRODUCT SET IS_DISABLED = ? WHERE PRODUCT_ID = ? ");
			
			stmt.setInt(1, 0);
			stmt.setString(2, PRODUCT_ID);
			int result = stmt.executeUpdate();
			
			return result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
	
	public Product getProduct(String PRODUCT_ID) {
		Product product = new Product();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCT JOIN CATEGORY ON PRODUCT.CATEGORY = CATEGORY.CATEGORY_ID JOIN COUNTRY ON PRODUCT.COUNTRY = COUNTRY.COUNTRY_ID WHERE PRODUCT_ID = ?");
			stmt.setString(1, PRODUCT_ID);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				product.setPRODUCT_ID(result.getString("PRODUCT_ID"));
				product.setPRODUCT_NAME(result.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(result.getDouble("PRODUCT_PRICE"));
				product.setCATEGORY(result.getString("CATEGORY"));
				product.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				product.setSEASON(result.getString("SEASON"));
				product.setCOUNTRY(result.getString("COUNTRY"));
				product.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				product.setPRODUCT_IMAGE(result.getString("PRODUCT_IMAGE"));
				product.setPRODUCT_DESCRIPTION(result.getString("PRODUCT_DESCRIPTION"));
				product.setIS_DISABLED(result.getInt("IS_DISABLED"));
				return product;
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> getAll() {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT *, PRODUCT.IS_DISABLED FROM PRODUCT JOIN CATEGORY ON CATEGORY.CATEGORY_ID = PRODUCT.CATEGORY JOIN COUNTRY ON COUNTRY.COUNTRY_ID = PRODUCT.COUNTRY");
			ResultSet result = stmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			
			while(result.next()) {
				Product product = new Product();
				product.setPRODUCT_ID(result.getString("PRODUCT_ID"));
				product.setPRODUCT_NAME(result.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(result.getDouble("PRODUCT_PRICE"));
				product.setCATEGORY(result.getString("CATEGORY"));
				product.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				product.setSEASON(result.getString("SEASON"));
				product.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				product.setCOUNTRY(result.getString("COUNTRY"));
				product.setPRODUCT_DESCRIPTION(result.getString("PRODUCT_DESCRIPTION"));
				product.setPRODUCT_IMAGE(result.getString("PRODUCT_IMAGE"));
				product.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(product);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> getAll(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT *, PRODUCT.IS_DISABLED FROM PRODUCT JOIN CATEGORY ON CATEGORY.CATEGORY_ID = PRODUCT.CATEGORY JOIN COUNTRY ON COUNTRY.COUNTRY_ID = PRODUCT.COUNTRY WHERE PRODUCT.IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			
			while(result.next()) {
				Product product = new Product();
				product.setPRODUCT_ID(result.getString("PRODUCT_ID"));
				product.setPRODUCT_NAME(result.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(result.getDouble("PRODUCT_PRICE"));
				product.setCATEGORY(result.getString("CATEGORY"));
				product.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				product.setSEASON(result.getString("SEASON"));
				product.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				product.setCOUNTRY(result.getString("COUNTRY"));
				product.setPRODUCT_DESCRIPTION(result.getString("PRODUCT_DESCRIPTION"));
				product.setPRODUCT_IMAGE(result.getString("PRODUCT_IMAGE"));
				product.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(product);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> getAll(Filters Filters) {
		
		String subQuery = Filters.getLimitQuery();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCT " + subQuery);
			System.out.println("SELECT * FROM PRODUCT JOIN CATEGORY ON PRODUCT.CATEGORY = CATEGORY.CATEGORY_ID JOIN COUNTRY ON PRODUCT.COUNTRY = COUNTRY.COUNTRY_ID " + subQuery);
			ResultSet result = stmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			
			while(result.next()) {
				Product product = new Product();
				product.setPRODUCT_ID(result.getString("PRODUCT_ID"));
				product.setPRODUCT_NAME(result.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(result.getDouble("PRODUCT_PRICE"));
				product.setCATEGORY(result.getString("CATEGORY"));
				product.setSEASON(result.getString("SEASON"));
				product.setCOUNTRY(result.getString("COUNTRY"));
				product.setPRODUCT_IMAGE(result.getString("PRODUCT_IMAGE"));
				product.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(product);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getProductsLength(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(PRODUCT_ID) AS LENGTH FROM PRODUCT WHERE IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				return result.getInt("LENGTH");
			}
			
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalPage(Filters Filters) {
		String countQuery = Filters.getQuery();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement countStmt = conn.prepareStatement("SELECT COUNT(PRODUCT_ID) AS TOTAL FROM PRODUCT " + countQuery);
			ResultSet result = countStmt.executeQuery();
			while(result.next()) {
				int Total = (int) Math.ceil(Integer.parseInt(result.getString("TOTAL"))*1.0/Filters.getLIMIT());
				return Total;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
