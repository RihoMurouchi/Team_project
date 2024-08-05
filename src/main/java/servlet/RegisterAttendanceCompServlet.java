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
public class RegisterAttendanceCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterAttendanceCompServlet() {
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
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// registerAttendanceメソッドの戻り値を格納する変数
		int count = 0;
		String error = null;

		//sessionからユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String overTime = request.getParameter("overTime");

		try {
			// AttendanceDAOクラス registerAttendanceメソッドにdate, start, end, overを渡しデータベース登録
			count = AttendanceDAO.registerAttendance(user.getUserId(), date, startTime, endTime, overTime);
			if (count == 0) {
				error = "勤怠の登録に失敗しました。";
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";
		}

		// リクエストスコープにセット;
		request.setAttribute("count", count);
		request.setAttribute("error", error);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/register-comp.jsp");
		rd.forward(request, response);
	}
}