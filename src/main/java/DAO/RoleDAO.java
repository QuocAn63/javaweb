package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDAO {
	
	 public ArrayList<Role> getAll() {
		 try {
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ROLE");
				ResultSet result = stmt.executeQuery();
				ArrayList<Role> list = new ArrayList<Role>();
				
				while(result.next()) {
					Role role = new Role();
					role.setROLE_ID(result.getString("ROLE_ID"));
					role.setROLE_NAME(result.getString("ROLE_NAME"));
					list.add(role);
				}
				
				stmt.close();
				conn.close();
				
				return list;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
	 }
}
