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
		

//		if (session == null || user == null) {
//			response.sendRedirect("login.jsp"); //セッションがl切れたらlogin.jspにリダイレクト
//			return;
//		}

		// attendanceリストを格納する変数
		List<AttendanceBean> attendanceList = null;

		//リクエストのエンコーディングをセット
		request.setCharacterEncoding("UTF-8");

		String searchButton = request.getParameter("searchButton");
		String date = request.getParameter("date");
		String error = null;

		//ボタン押下時に中身が空でなければ以下の処理が始まる
		if (searchButton == null) {
			searchButton = "";
		}

		try {
			//value="検索"なら以下の処理を行う
			if ("検索".equals(searchButton)) {
				attendanceList = AttendanceDAO.userBySearchAttendance(user.getUserId(), date);
			} else {
				//attendanceDAOクラスのuserByGetAttendanceListメソッド呼び出し、attendanceリスト取得
				attendanceList = AttendanceDAO.userByGetAttendanceList(user);
			}

			if (attendanceList.size() == 0) {
				error = "勤怠情報が登録されていません";

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにattendanceリストをセット
		request.setAttribute("error", error);
		request.setAttribute("attendanceList", attendanceList);

		// attendanceList.jsp 勤怠一覧画面へ転送
		RequestDispatcher rd = request.getRequestDispatcher("attendance-list.jsp");
		rd.forward(request, response);

	}

}
