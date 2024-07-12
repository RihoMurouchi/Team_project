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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エンコーディング
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = (request.getParameter("password"));

		//checkLoginメソッドの呼び出し
		String nextPage = null;
		try {
			//セッションの開始
			HttpSession session = request.getSession();
			String errorMessage;
			UserBean user = UserDAO.checkLogin(userId, password);

			//ログイン判定で分岐
			//成功：ログイン成功でセッションにユーザ情報セット
			if (user != null) {
				session.setAttribute("user", user);
				nextPage = "menu.jsp";

			} else {
				//失敗：ログイン失敗でエラーメッセージをリクエストスコープにセット
				errorMessage = "ログイン失敗しました。";
				request.setAttribute("errorMessage", errorMessage);
				nextPage = "login.jsp";
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//転送
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
