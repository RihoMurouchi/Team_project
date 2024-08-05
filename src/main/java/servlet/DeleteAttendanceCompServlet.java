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
@WebServlet("/delete-attendance-comp")
public class DeleteAttendanceCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAttendanceCompServlet() {
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
		// deleteAttendanceメソッドの戻り値を格納する変数
		int count = 0;
		String error = null;

		// リクエストパラメータの取得
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			count = AttendanceDAO.deleteAttendance(id);
			if (count == 0) {
				error = "削除済みの勤怠情報です。";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにセット;
		request.setAttribute("count", count);
		request.setAttribute("error", error);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("delete-attendance-comp.jsp");
		rd.forward(request, response);
	}

}
