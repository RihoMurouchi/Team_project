package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AttendanceDAO;
import model.entity.AttendanceBean;

/**
 * Servlet implementation class EditAttendance
 */
@WebServlet("/edit-attendance")
public class EditAttendanceInputConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAttendanceInputConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// =============== 入力フォームの表示と、テキストエリア内に初期値として勤怠情報を表示するための処理 ===============
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		// attendanceデータを格納する変数
		AttendanceBean attendance = null;

		String error = null;

		try {
			//getAttendanceOneメソッド呼び出し、attendanceデータ取得
			attendance = AttendanceDAO.getAttendanceOne(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("error", error);
		request.setAttribute("attendance", attendance);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("edit-attendance.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// =============== 確認画面へ勤怠情報を表示するための処理 ===============
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// attendanceデータを格納するオブジェクトを作成
		AttendanceBean attendance = new AttendanceBean();

		// リクエストパラメータの取得し格納
		attendance.setId(Integer.parseInt(request.getParameter("id")));
		attendance.setDate(request.getParameter("date"));
		attendance.setStartTime(request.getParameter("startTime"));
		attendance.setEndTime(request.getParameter("endTime"));
		attendance.setOverTime(request.getParameter("overTime"));

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("attendance", attendance);

		// edit-attendance-confirm.jspへ転送
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/edit-attendance-confirm.jsp");
		rd.forward(request, response);

	}

}
