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
import model.entity.AttendanceBean;

/**
 * Servlet implementation class DeleteAttendanceCompServlet
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/delete-attendance-confirm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		// attendanceデータを格納する変数
		AttendanceBean attendance = null;
		String error = "削除済みの勤怠情報です。";

		try {
			//getAttendanceOneメソッド呼び出し、attendanceデータ取得
			attendance = AttendanceDAO.getAttendanceOne(id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにattendanceリストをセット;
		request.setAttribute("error", error);
		request.setAttribute("attendance", attendance);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/delete-attendance-confirm.jsp");
		rd.forward(request, response);
	}

}
