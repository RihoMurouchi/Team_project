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

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エンコーディング
		request.setCharacterEncoding("UTF-8");

		//セッションの開始
		HttpSession session = request.getSession();
		//セッションタイムアウトの設定 10秒
//		session.setMaxInactiveInterval(10);

		//リクエストパラメータの取得
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");

		//checkLoginメソッドの呼び出し
		String nextPage = "login.jsp";
		String error = null;
		try {

			UserBean user = UserDAO.checkLogin(userId, password);

			//ログイン判定で分岐
			if (user != null) {
				session.setAttribute("user", user);//成功：ログイン成功でセッションにユーザ情報セット
				nextPage = "menu.jsp";

			} else {
				//失敗：ログイン失敗でエラーメッセージをリクエストスコープにセット
				error = "ログイン失敗しました。";

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			error = "予期せぬエラーが発生しました。";

		}

		// リクエストスコープにattendanceリストをセット
		request.setAttribute("error", error);

		//転送
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
