package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AttendanceDAO;
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

		//sessionからユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String overTime = request.getParameter("overTime");

		try {
			// AttendanceDAOクラス registerAttendanceメソッドにdate, start, end, overを渡しデータベース登録
			int count = AttendanceDAO.registerAttendance(user.getUserId(), date, startTime, endTime, overTime);
			request.setAttribute("count", count);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("error", "勤怠の登録に失敗しました。");
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("register-comp.jsp");
		rd.forward(request, response);
	}
}