package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	public UserBean checkLogin(int id, String password) throws ClassNotFoundException, SQLException {
		UserBean user = null;
		
		String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				int employeeId = res.getInt("user_id");
				String pass = res.getString("password");
				String name = res.getString("name");
				
				user = new UserBean(employeeId, pass, name);
			}
		}
		
		return user;
	}
}
