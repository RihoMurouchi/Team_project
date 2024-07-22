package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.AttendanceBean;

/**
 * Servlet implementation class RegisterComfirmServlet
 */
@WebServlet("/register-confirm")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// attendanceデータを格納する変数
		AttendanceBean attendance = new AttendanceBean();

		// =================== 日付文字列をdate型で受け取る記述 ここから======================
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// リクエストパラメータの取得(date)
		String dateString = request.getParameter("date");
		if (dateString != null && !dateString.isEmpty()) {
			try {
				LocalDate date = LocalDate.parse(dateString, formatter);
				attendance.setDate(date.toString());
			} catch (DateTimeParseException e) {
				e.printStackTrace();
			}
		}
		// =================== 日付文字列をdate型で受け取る記述 ここまで======================

		// リクエストパラメータの取得

		attendance.setStartTime(request.getParameter("start"));
		attendance.setEndTime(request.getParameter("end"));
		attendance.setOverTime(request.getParameter("over"));

		// 受け取った値(attendance)をリクエストスコープにセット;
		request.setAttribute("attendance", attendance);

		// register-confim.jspへ転送
		RequestDispatcher rd = request.getRequestDispatcher("register-confirm.jsp");
		rd.forward(request, response);

	}
}
