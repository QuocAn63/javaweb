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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCT");
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
