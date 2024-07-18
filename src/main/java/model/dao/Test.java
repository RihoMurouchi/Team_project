package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.entity.AttendanceBean;
import model.entity.UserBean;

public class Test {

	public static void main(String[] args) {

//		List<AttendanceBean> attendanceList = null;
//
//		try {
//			attendanceList = AttendanceDAO.userByGetAttendanceList(UserDAO.checkLogin(180, "pass3"));
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		for (AttendanceBean alist : attendanceList) {
//			System.out.println(alist);
//		}
//
//		AttendanceBean attendance = null;
//
//		try {
//			attendance = AttendanceDAO.getAttendanceOne(3);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		AttendanceBean attendance = new AttendanceBean();
		
		attendance.setDate("2024-07-01");

		System.out.println(attendance.getDate());
		//		attendanceList.forEach(i -> System.out.println(i));

		//
		//		//=========== UserId, passwordを基にログインを承認、ユーザー情報を取得 ===============
		//
		////		AttendanceDAO.login​(180, "pass3");
		//
		//		//=========== UserId, passwordを基にユーザー情報を取得 ===============
		//
				UserBean user = new UserBean(180,"佐々木隆成","pass3");
		
				try {
					UserDAO.checkLogin(180, "pass3");
					//			System.out.println(ab.getUser());//ユーザー情報を取得
				} catch (ClassNotFoundException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
		
				//============ userIdを基にログインしているユーザーの勤怠情報一覧を表示 ====================
		
				System.out.println("========= userIdを基にログインしているユーザーの勤怠情報一覧を表示 ==========");
				System.out.println();
		
				try {
		
					List<AttendanceBean> attendanceList = null;
					try {
						attendanceList = AttendanceDAO.userByGetAttendanceList(user);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					attendanceList.forEach(i -> System.out.println(i));
		
				} catch (ClassNotFoundException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
		//
		//		System.out.println();
		//		//============ 日付を基にログインしているユーザーの勤怠情報を表示 ====================		
		//
		//		System.out.println("========= 日付を基にログインしているユーザーの勤怠情報を表示 ==========");
		//		System.out.println();
		//
		//		//		System.out.println(ab.getUser().getUserId());
		//
		//		//		System.out.println(ab.getUser());
		//
		//		try {
		//			List<AttendanceBean> searchList = AttendanceDAO.userBySearchAttendance("2024-07-03", ab.getUser());
		//			//			for(AttendanceBean list : searchList) {
		//			//				System.out.println(list);
		//			//			}
		//			searchList.forEach(i -> System.out.println(i));
		//
		//		} catch (ClassNotFoundException e) {
		//			// TODO 自動生成された catch ブロック
		//			e.printStackTrace();
		//		}
		//		
		//		
		//		//============== 編集画面で受け取ったパラメータをAttendanceBeanにセットしそれらを基に、ユーザーの勤怠情報を更新 ============
		//
		//		ab.setDate("2024-07-01");
		//		ab.setStartTime(null);
		//		ab.setEndTime(null);
		//		ab.setOverTime(null);
		//		ab.getUser().getUserId();
		//		
		//		try {
		//			AttendanceDAO.editAttendance(ab);
		//		} catch (ClassNotFoundException e) {
		//			// TODO 自動生成された catch ブロック
		//			e.printStackTrace();
		//		}
	}

}
