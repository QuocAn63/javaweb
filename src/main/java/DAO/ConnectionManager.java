package DAO;
import java.sql.*;
public class ConnectionManager {
	public static final String  db_url = "jdbc:mysql://localhost:3306/db_shopfruits";
	public static final String username = "root";
	public static final String password = "";
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(db_url, username, password);
	}
	
}
