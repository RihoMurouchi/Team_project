package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAttendanceCompServlet
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

		String button = request.getParameter("button");

		//				System.out.println(button);

		//遷移先格納用変数
		String nextUrl = null;

		if (button != null) {
			if ("勤怠一覧".equals(button)) {
				nextUrl = "attendance-list";//一覧サーブレットへ
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
	}

}
