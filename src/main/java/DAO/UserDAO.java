package DAO;
import java.sql.*;
import java.util.*;

public class UserDAO {	
	public boolean Save(User user) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("INSERT INTO USER(USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_EMAIL, USER_ROLE) VALUES(?,?,?,?,?)");
			stmt.setString(1, user.getUSER_NAME());
			stmt.setString(2, user.getUSER_PASSWORD());
			stmt.setString(3, user.getUSER_PHONE_NUMBER());
			stmt.setString(4, user.getUSER_EMAIL());
			stmt.setInt(5, user.getUSER_ROLE());
			
			int result = stmt.executeUpdate();
			conn.close();
			stmt.close();
			
			if(result != 0)
				return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Delete(String USER_ID) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("UPDATE USER SET IS_DISABLED = 1 WHERE USER_ID=?");
			stmt.setString(1, USER_ID);
			int result = stmt.executeUpdate();
			conn.close();
			stmt.close();
			if(result != 0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean CancelDelete(String USER_ID) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("UPDATE USER SET IS_DISABLED = 0 WHERE USER_ID=?");
			stmt.setString(1, USER_ID);
			int result = stmt.executeUpdate();
			conn.close();
			stmt.close();
			if(result != 0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Update(User user) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("UPDATE USER SET USER_FULL_NAME = ?, USER_PHONE_NUMBER = ?, USER_ADDRESS = ?, USER_EMAIL = ?, USER_GENDER = ?, USER_DOB = ?, USER_ROLE = ? WHERE USER_ID = ? ");
			stmt.setString(1, user.getUSER_FULL_NAME());
			stmt.setString(2, user.getUSER_PHONE_NUMBER());
			stmt.setString(3, user.getUSER_ADDRESS());
			stmt.setString(4, user.getUSER_EMAIL());
			stmt.setInt(5, user.getUSER_GENDER());
			stmt.setString(6, user.getUSER_DOB());
			stmt.setInt(7, user.getUSER_ROLE());
			stmt.setString(8, user.getUSER_ID());
			
			int result = stmt.executeUpdate();

			return result != 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User Find(String USER_NAME) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("SELECT * FROM USER WHERE USER_NAME=?");
			stmt.setString(1, USER_NAME);
			ResultSet result = stmt.executeQuery();
			User user = null;
			if(result.next()) {
				user = new User();
				user.setUSER_ID(result.getString("USER_ID"));
				user.setUSER_EMAIL(result.getString("USER_EMAIL"));
				user.setUSER_NAME(result.getString("USER_NAME"));
				user.setUSER_PASSWORD(result.getString("USER_PASSWORD"));
				user.setUSER_PHONE_NUMBER(result.getString("USER_PHONE_NUMBER"));
				user.setUSER_FULL_NAME(result.getString("USER_FULL_NAME"));
				user.setUSER_DOB(result.getString("USER_DOB"));
				user.setUSER_ADDRESS(result.getString("USER_ADDRESS"));
				user.setUSER_GENDER(result.getInt("USER_GENDER"));
				user.setIS_DISABLED(result.getInt("IS_DISABLED"));
				user.setUSER_ROLE(result.getInt("USER_ROLE"));
				
			}		
			
			return user;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> getAll(){
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User");
			ResultSet result = stmt.executeQuery();
			ArrayList<User> list = new ArrayList<User>();
			
			while(result.next()) {
				User user = new User();
				user.setUSER_ID(result.getString("USER_ID"));
				user.setUSER_EMAIL(result.getString("USER_EMAIL"));
				user.setUSER_NAME(result.getString("USER_NAME"));
				user.setUSER_PASSWORD(result.getString("USER_PASSWORD"));
				user.setUSER_PHONE_NUMBER(result.getString("USER_PHONE_NUMBER"));
				user.setUSER_FULL_NAME(result.getString("USER_FULL_NAME"));
				user.setUSER_DOB(result.getString("USER_DOB"));
				user.setUSER_ADDRESS(result.getString("USER_ADDRESS"));
				user.setUSER_GENDER(result.getInt("USER_GENDER"));
				user.setIS_DISABLED(result.getInt("IS_DISABLED"));
				user.setUSER_ROLE(result.getInt("USER_ROLE"));
				list.add(user);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> getAll(int value){
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			ArrayList<User> list = new ArrayList<User>();
			
			while(result.next()) {
				User user = new User();
				user.setUSER_ID(result.getString("USER_ID"));
				user.setUSER_EMAIL(result.getString("USER_EMAIL"));
				user.setUSER_NAME(result.getString("USER_NAME"));
				user.setUSER_PASSWORD(result.getString("USER_PASSWORD"));
				user.setUSER_PHONE_NUMBER(result.getString("USER_PHONE_NUMBER"));
				user.setUSER_FULL_NAME(result.getString("USER_FULL_NAME"));
				user.setUSER_DOB(result.getString("USER_DOB"));
				user.setUSER_ADDRESS(result.getString("USER_ADDRESS"));
				user.setUSER_GENDER(result.getInt("USER_GENDER"));
				user.setIS_DISABLED(result.getInt("IS_DISABLED"));
				user.setUSER_ROLE(result.getInt("USER_ROLE"));
				list.add(user);
			}
			
			stmt.close();
			conn.close();
			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getUsersLength(int value) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("SELECT COUNT(USER_ID) AS LENGTH FROM USER WHERE IS_DISABLED = ?");
			stmt.setInt(1, value);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				return result.getInt("LENGTH");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public User Login(String USER_NAME, String USER_PASSWORD) {
		try {			
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement  stmt = conn.prepareStatement("SELECT * FROM USER WHERE USER_NAME=? AND USER_PASSWORD=?");
			stmt.setString(1, USER_NAME);
			stmt.setString(2, USER_PASSWORD);		
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				return new User(result.getString("USER_ID"),
						result.getString("USER_NAME"),
						result.getString("USER_PASSWORD"),
						result.getString("USER_EMAIL"),
						result.getString("USER_PHONE_NUMBER"),
						result.getString("USER_FULL_NAME"),
						result.getInt("USER_GENDER"),
						result.getString("USER_DOB"),
						result.getString("USER_ADDRESS"),
						result.getInt("USER_ROLE"),
						result.getInt("IS_DISABLED")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
