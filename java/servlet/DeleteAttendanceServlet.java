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
import model.entity.AttendanceBean;
import model.entity.UserBean;

/**
 * Servlet implementation class DeleteAttendanceCompServlet
 */
@WebServlet("/delete-attendance")
public class DeleteAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAttendanceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		HttpSession session = request.getSession();
//		if (session == null || session.getAttribute("user") == null) {
//			response.sendRedirect("login.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
//			return;
//		}
//			
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		//セッションからユーザー情報を取得
		UserBean user = (UserBean) session.getAttribute("user");

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		// attendanceデータを格納する変数
		AttendanceBean attendance = null;

		try {
			//getAttendanceOneメソッド呼び出し、attendanceデータ取得
			attendance = AttendanceDAO.getAttendanceOne(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("attendance", attendance);
		request.setAttribute("user", user);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("delete-attendance-confirm.jsp");
		rd.forward(request, response);
	}

}
