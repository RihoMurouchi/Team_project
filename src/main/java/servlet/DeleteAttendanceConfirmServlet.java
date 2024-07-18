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
 * Servlet implementation class DeletAttendanceServlet
 */
@WebServlet("/delete-attendance-confirm")
public class DeleteAttendanceConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAttendanceConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
//		request.setCharacterEncoding("UTF-8");
//
//		//セッションからユーザー情報を取得
//		HttpSession session = request.getSession();
//		UserBean user = (UserBean) session.getAttribute("user");
//
//		// リクエストパラメータの取得
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		// attendanceデータを格納する変数
//		AttendanceBean attendance = null;
//
//		try {
//			//getAttendanceOneメソッド呼び出し、attendanceデータ取得
//			attendance = AttendanceDAO.getAttendanceOne(id);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		// リクエストスコープにattendanceリストをセット;
//		request.setAttribute("attendance", attendance);
//		request.setAttribute("user", user);
//
//		// 転送
//		RequestDispatcher rd = request.getRequestDispatcher("delete-attendance-confirm.jsp");
//		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// deleteAttendanceメソッドの戻り値を格納する変数
		int count = 0;

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			count = AttendanceDAO.deleteAttendance(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// リクエストスコープにcountをセット;
		request.setAttribute("count", count);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("delete-attendance-comp.jsp");
		rd.forward(request, response);
	}

}
