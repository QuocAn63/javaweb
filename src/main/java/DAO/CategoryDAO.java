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
 * Servlet implementation class CategoryDAO
 */
@WebServlet("/CategoryDAO")
public class CategoryDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDAO() {
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
	
	public ArrayList<Category> getAll() {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CATEGORY");
			ResultSet result = stmt.executeQuery();
			ArrayList<Category> list = new ArrayList<Category>();
			
			while(result.next()) {
				Category category = new Category();
				category.setCATEGORY_ID(result.getString("CATEGORY_ID"));
				category.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				category.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(category);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Category> getAll(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CATEGORY WHERE IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			ArrayList<Category> list = new ArrayList<Category>();
			
			while(result.next()) {
				Category category = new Category();
				category.setCATEGORY_ID(result.getString("CATEGORY_ID"));
				category.setCATEGORY_NAME(result.getString("CATEGORY_NAME"));
				category.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(category);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Category GetCategory(String CATEGORY_ID) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CATEGORY WHERE CATEGORY_ID = ? ");
			stmt.setString(1, CATEGORY_ID);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				return new Category(result.getString("CATEGORY_ID"), result.getString("CATEGORY_NAME"));
			}
			
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean InsertCategory(Category Category) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY_NAME) VALUES (?, ?)");
			stmt.setString(1, Category.getCATEGORY_ID());
			stmt.setString(2, Category.getCATEGORY_NAME());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateCategory(Category Category) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE CATEGORY SET CATEGORY_NAME = ? WHERE CATEGORY_ID = ?");
			stmt.setString(1, Category.getCATEGORY_NAME());
			stmt.setString(2, Category.getCATEGORY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteCategory(Category Category) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE CATEGORY SET IS_DISABLED = 1 WHERE CATEGORY_ID = ?");
			stmt.setString(1, Category.getCATEGORY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean CancelDeleteCategory(Category Category) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE CATEGORY SET IS_DISABLED = 0 WHERE CATEGORY_ID = ?");
			stmt.setString(1, Category.getCATEGORY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getCategoriesLength(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(CATEGORY_ID) AS LENGTH FROM CATEGORY WHERE IS_DISABLED = ?");
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
}
