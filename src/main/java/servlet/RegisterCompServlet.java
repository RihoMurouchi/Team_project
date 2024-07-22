package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AttendanceDAO;
import model.entity.AttendanceBean;
import model.entity.UserBean;

/**
 * Servlet implementation class RegisterCompServlet
 */
@WebServlet("/register-comp")
public class RegisterCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCompServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			session.invalidate();
			response.sendRedirect("login.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
		} else {
			//もしsessionを持っていてもGetで来た場合はとりあえずlogin.jspに戻す。
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// attendanceデータを格納する変数※
		AttendanceBean attendance = new AttendanceBean();

		// ===================  リクエストパラメータの取得①　ここから======================
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//　日付文字列をdate型で受け取る記述 
		String dateString = request.getParameter("date");
		LocalDate date = LocalDate.parse(dateString, formatter);
		attendance.setDate(date.toString());
		System.out.println(dateString);
		// ===================  リクエストパラメータの取得①　ここまで======================

		// リクエストパラメータの取得②
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String over = request.getParameter("over");
		System.out.println();

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("attendance", attendance);
		//sessionからユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		try {
			// AttendanceDAOクラス registerAttendanceメソッドにdate, start, end, overを渡しデータベース登録
			int count = AttendanceDAO.registerAttendance(user.getUserId(), date, start, end, over);
			request.setAttribute("count", count);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("register-comp.jsp");
		rd.forward(request, response);
	}
}