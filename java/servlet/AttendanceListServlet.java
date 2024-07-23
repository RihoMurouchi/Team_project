package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class AttendanceList
 */
@WebServlet("/attendance-list")
public class AttendanceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceListServlet() {
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
		// セッションからユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		//以下の記述は必要か？
		if (session == null || user == null) {//セッションがl切れたら
			response.sendRedirect("login.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
			return;
		}
		// attendanceリストを格納する変数
		List<AttendanceBean> attendanceList = null;

		//attendanceDAOクラスのuserByGetAttendanceListメソッド呼び出し、attendanceリスト取得
		try {
			attendanceList = AttendanceDAO.userByGetAttendanceList(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// リクエストスコープにattendanceリストをセット
		request.setAttribute("attendanceList", attendanceList);

		// attendanceList.jspのattendance一覧画面へ転送
		RequestDispatcher rd = request.getRequestDispatcher("attendance-list.jsp");
		rd.forward(request, response);
	}

}
