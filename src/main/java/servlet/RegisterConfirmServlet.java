package servlet;

import java.io.IOException;

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

		// リクエストパラメータの取得
		attendance.setDate(request.getParameter("date"));
		attendance.setStartTime(request.getParameter("startTime"));
		attendance.setEndTime(request.getParameter("endTime"));
		attendance.setOverTime(request.getParameter("overTime"));
		
		System.out.println(attendance);

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("attendance", attendance);

		// register-cfm.jspへ転送
		RequestDispatcher rd = request.getRequestDispatcher("register-cfm.jsp");
		rd.forward(request, response);

	}
}
