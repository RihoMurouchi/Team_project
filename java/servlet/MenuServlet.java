package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
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
		//		HttpSession session = request.getSession();
		//		if (session == null || session.getAttribute("user") == null) {
		//			response.sendRedirect("login.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
		//			return;
		//		}
		//エンコーディング
		request.setCharacterEncoding("UTF-8");

		String button = request.getParameter("button");

		//		System.out.println(button);

		//遷移先格納用変数
		String nextUrl = null;

		if (button != null) {
			if ("勤怠一覧".equals(button)) {
				nextUrl = "attendance-list";//一覧サーブレットへ
			} else if ("登録画面".equals(button)) {
				nextUrl = "attendance-";//登録サーブレットへ
			} else if ("ログアウト".equals(button)) {
				nextUrl = "attendance-";//ログアウトサーブレットへ
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
	}

}
