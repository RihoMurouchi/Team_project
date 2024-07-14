package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.entity.AttendanceBean;
import model.entity.UserBean;

public class AttendanceDAO {

	/**
	 * @param userBean
	 * @return List<AttendanceBean>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<AttendanceBean> userByGetAttendanceList(UserBean userBean)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT *  FROM attendances inner join user on attendances.user_id = user.user_id where attendances.user_id = ?";

		List<AttendanceBean> attendanceList = new ArrayList<AttendanceBean>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, userBean.getUserId());

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				AttendanceBean ab = new AttendanceBean(res.getInt("id"), res.getInt("user_id"), res.getString("date"),
						res.getTime("start_time"), res.getTime("end_time"), res.getTime("over_time"));
				attendanceList.add(ab);
			}
		}
		return attendanceList;
	}

	/*	入力された情報がデータベースに登録されているかチェック*/
	public void registerAttendance(AttendanceBean attendance) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO attendances (user_id, date,start_time, end_time, over_time) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, attendance.getUserId());
			pstmt.setString(2, attendance.getDate());
			pstmt.setTime(3, attendance.getStartTime());
			pstmt.setTime(4, attendance.getEndTime());
			pstmt.setTime(5, attendance.getOverTime());
			pstmt.executeUpdate();
		}
	}

	/**
	 * @param date
	 * @param userBean
	 * @return List<AttendanceBean>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<AttendanceBean> userBySearchAttendance(String date, UserBean userBean)
			throws ClassNotFoundException, SQLException {

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
		}

		return searchList;

	}

	/**
	 * @param id
	 * @return AttendanceBean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static AttendanceBean getAttendanceOne(int id) throws ClassNotFoundException, SQLException {
		// attendance情報を格納する変数
		AttendanceBean attendance = null;

		// SQL文（プレースホルダー1つ）
		String sql = "SELECT id, user_id, date, start_time, end_time, over_time FROM attendances WHERE id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数idの値をセット
			pstmt.setInt(1, id);

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表からtweetテーブルの値を取得
			if (res.next()) {

				// DBから取得した値を初期値として、AttendanceBeanのインスタンス生成
				attendance = new AttendanceBean(res.getInt("id"), res.getInt("user_id"), res.getString("date"),
						res.getTime("start_time"), res.getTime("end_time"), res.getTime("over_time"));
			}
		}
		return attendance;
	}

	/**
	 * 編集画面で受け取ったパラメータを基に、ユーザーの勤怠情報を更新
	 * @param attendance
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int editAttendance(int id, String date, Time startTime, Time endTime, Time overTime)
			throws ClassNotFoundException, SQLException {
		int count = 0;// 更新件数を格納する変数

		// SQL文（プレースホルダー2つ）
		String sql = "UPDATE attendances SET date = ?, start_time = ?, end_time = ?, over_time = ? where Id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// 1つ目のプレースホルダーに引数dateの値をセット
			pstmt.setString(1, date);
			// 2つ目のプレースホルダーに引数startTimeの値をセット
			pstmt.setTime(2, startTime);
			// 3つ目のプレースホルダーに引数endTimeの値をセット
			pstmt.setTime(3, endTime);
			// 4つ目のプレースホルダーに引数overTimeの値をセット
			pstmt.setTime(4, overTime);
			// 5つ目のプレースホルダーに引数idの値をセット
			pstmt.setInt(5, id);

			// SQL実行し、更新件数をcountに代入
			count = pstmt.executeUpdate();

		}
		return count;
	}

	/**
	 * @param id
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int deleteAttendance(int id) throws ClassNotFoundException, SQLException {
		int count = 0; // 削除件数を格納する変数

		// SQL文（プレースホルダー1つ）
		String sql = "DELETE FROM attendances WHERE id = ?";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 1つ目のプレースホルダーに引数idの値をセット
			pstmt.setInt(1, id);

			// SQL実行し、削除件数をcountに代入
			count = pstmt.executeUpdate();
		}
		return count;
	}

}
