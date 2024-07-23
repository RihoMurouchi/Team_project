package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {

	/**
	 * @param userId
	 * @param password
	 * @return UserBean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static UserBean checkLogin(int userId, String password) throws ClassNotFoundException, SQLException {
		UserBean user = null;

		String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				user = new UserBean(res.getInt("user_id"), res.getString("name"), res.getString("password"));

			}
		}

		return user;
	}
}
