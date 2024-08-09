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

/**
 * Servlet implementation class EditAttendanceConfirmServlet
 */
@WebServlet("/edit-attendance-comp")
public class EditAttendanceCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAttendanceCompServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/edit-attendance-comp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// editAttendanceメソッドの戻り値を格納する変数
		int count = 0;
		String error = null;

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String overTime = request.getParameter("overTime");

		try {
			count = AttendanceDAO.editAttendance(id, date, startTime, endTime, overTime);
			if (count == 0) {
				error = "編集に失敗しました。勤怠情報を再度ご確認ください。";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("count", count);
		request.setAttribute("error", error);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/edit-attendance-comp.jsp");
		rd.forward(request, response);

	}

}
