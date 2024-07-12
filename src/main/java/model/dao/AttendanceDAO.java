package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.AttendanceBean;
import model.entity.UserBean;

public class AttendanceDAO {

	public static List<AttendanceBean> userByGetAttendanceList(UserBean userBean) throws ClassNotFoundException {
		String sql = "SELECT id, name, date, start_time, end_time, over_time  FROM attendances inner join user on attendances.user_id = user.user_id where attendances.user_id = ?";

		List<AttendanceBean> attendanceList = new ArrayList<AttendanceBean>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, userBean.getUserId());

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				AttendanceBean ab = new AttendanceBean();
				ab.setUser(userBean);
				ab.setId(res.getInt("id"));
				ab.setDate(res.getString("date"));
				ab.getUser().setName(res.getString("name"));
				ab.setStartTime(res.getTime("start_time"));
				ab.setEndTime(res.getTime("end_time"));
				ab.setOverTime(res.getTime("over_time"));
				attendanceList.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attendanceList;
	}

	/*	入力された情報がデータベースに登録されているかチェック*/
	public void registerAttendance(AttendanceBean attendance) throws ClassNotFoundException {
		String sql = "INSERT INTO attendances (user_id, date,start_time, end_time, over_time) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, attendance.getUserId());
			pstmt.setString(2, attendance.getDate());
			pstmt.setTime(3, attendance.getStartTime());
			pstmt.setTime(4, attendance.getEndTime());
			pstmt.setTime(5, attendance.getOverTime());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<AttendanceBean> userBySearchAttendance(String date, UserBean userBean)
			throws ClassNotFoundException {

		List<AttendanceBean> searchList = new ArrayList<>();
		String sql = "select id, name, date, start_time, end_time, over_time from attendances inner join user on attendances.user_id = user.user_id";
		if (date != null) {
			sql += " WHERE date = ? AND attendances.user_id = ?";
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			if (date != null) {
				pstmt.setString(1, date);
				pstmt.setInt(2, userBean.getUserId());
				//System.out.println(userBean.getUserId());

			}

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				AttendanceBean ab = new AttendanceBean();
				ab.setUser(userBean);
				ab.setId(res.getInt("id"));
				ab.setDate(res.getString("date"));
				ab.getUser().setName(res.getString("name"));
				ab.setStartTime(res.getTime("start_time"));
				ab.setEndTime(res.getTime("end_time"));
				ab.setOverTime(res.getTime("over_time"));
				searchList.add(ab);
			}
			return searchList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;

	}

	//=================== 編集画面で受け取ったパラメータをAttendanceBeanにセットしそれらを基に、ユーザーの勤怠情報を更新 ========================================
	public static void editAttendance(AttendanceBean attendance) throws ClassNotFoundException {
		String sql = "UPDATE attendances SET date = ?, start_time = ?, end_time = ?, over_time = ? where AND date = ? user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, attendance.getDate());
			pstmt.setTime(2, attendance.getStartTime());
			pstmt.setTime(3, attendance.getEndTime());
			pstmt.setTime(4, attendance.getOverTime());
			pstmt.setString(5, attendance.getDate());
			pstmt.setInt(6, attendance.getUser().getUserId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//=================== UserId, passwordを基にログインを承認、ユーザー情報を保持 ========================================
	public static boolean login​(int UserId, String password) {
		AttendanceBean ab = new AttendanceBean();
		UserBean user = null;
		//		System.out.println(UserId);
		try {
			user = UserDAO.checkLogin(UserId, password);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (user != null) {
			ab.setUser(user);
			//			System.out.println(user);
			//			System.out.println(ab);
			return true;
		} else {
			return false;
		}
	}

}
