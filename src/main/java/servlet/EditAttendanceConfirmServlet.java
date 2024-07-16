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
@WebServlet("/edit-attendance-confirm")
public class EditAttendanceConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAttendanceConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// editAttendanceメソッドの戻り値を格納する変数
		int count = 0;

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String overTime = request.getParameter("overTime");

		//		System.out.println(attendance);

		try {
			count = AttendanceDAO.editAttendance(id, date, startTime, endTime, overTime);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("count", count);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("edit-attendance-comp.jsp");
		rd.forward(request, response);

	}

}
