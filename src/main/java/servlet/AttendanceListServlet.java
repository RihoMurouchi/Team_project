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

		//userBySearchAttendanceメソッドの List<AttendanceBean>型 の戻り値を格納する変数を用意、初期値は null。
		List<AttendanceBean> searchList = null;

		//検索ボタン押下時にuserBySearchAttendanceの処理を行う
		//リクエストスコープにSearchlistをセット
		//attendance-list.jspにリダイレクト

		//リクエストのエンコーディングをセット
		request.setCharacterEncoding("UTF-8");

		String searchButton = request.getParameter("searchButton");
		String date = request.getParameter("date");
		String from = "search";
		String error = "エラー！対象の勤務日がありません";
		
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

		//ボタン押下時に中身が空でなければ以下の処理が始まる
		if (searchButton != null) {
			//value="検索"なら以下の処理を行う
			if ("検索".equals(searchButton)) {
				System.out.println(searchButton);
				try {
					searchList = AttendanceDAO.userBySearchAttendance(date);
					request.setAttribute("from", from);
					System.out.println(from);
					// リクエストスコープにsearchListをセット
					request.setAttribute("searchList", searchList);
					System.out.println(searchList);
					// attendanceList.jspのattendance一覧画面へリダイレクト
					response.sendRedirect("attendance-list.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
					return;
				} catch (ClassNotFoundException | SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				request.setAttribute("searchList", searchList);
				response.sendRedirect("attendance-list.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
				return;
				//対象日付がない場合はエラーメッセージ
			} else {
				request.setAttribute("error", error);
				response.sendRedirect("attendance-list.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
				return;
			}

		}

		
	}

}
