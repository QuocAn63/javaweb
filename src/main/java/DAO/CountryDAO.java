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
@WebServlet("/CountryDAO")
public class CountryDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryDAO() {
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
	
	public ArrayList<Country> getAll() {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COUNTRY");
			ResultSet result = stmt.executeQuery();
			ArrayList<Country> list = new ArrayList<Country>();
			
			while(result.next()) {
				Country country = new Country();
				country.setCOUNTRY_ID(result.getString("COUNTRY_ID"));
				country.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				country.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(country);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Country> getAll(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COUNTRY WHERE IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			ArrayList<Country> list = new ArrayList<Country>();
			
			while(result.next()) {
				Country country = new Country();
				country.setCOUNTRY_ID(result.getString("COUNTRY_ID"));
				country.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
				country.setIS_DISABLED(result.getInt("IS_DISABLED"));
				list.add(country);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Country GetCountry(String COUNTRY_ID) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COUNTRY WHERE COUNTRY_ID = ? ");
			stmt.setString(1, COUNTRY_ID);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				return new Country(result.getString("COUNTRY_ID"), result.getString("COUNTRY_NAME"));
			}
			
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean InsertCountry(Country Country) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO COUNTRY(COUNTRY_ID, COUNTRY_NAME) VALUES (?, ?)");
			stmt.setString(1, Country.getCOUNTRY_ID());
			stmt.setString(2, Country.getCOUNTRY_NAME());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateCountry(Country Country) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE COUNTRY SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ?");
			stmt.setString(1, Country.getCOUNTRY_NAME());
			stmt.setString(2, Country.getCOUNTRY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteCountry(Country Country) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE COUNTRY SET IS_DISABLED = 1 WHERE COUNTRY_ID = ?");
			stmt.setString(1, Country.getCOUNTRY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean CancelDeleteCountry(Country Country) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE COUNTRY SET IS_DISABLED = 0 WHERE COUNTRY_ID = ?");
			stmt.setString(1, Country.getCOUNTRY_ID());
			
			int result = stmt.executeUpdate();
			
			return result != 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getCountriesLength(int value) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(COUNTRY_ID) AS LENGTH FROM COUNTRY WHERE IS_DISABLED = ?");
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
