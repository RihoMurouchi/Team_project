//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class LoginFilter
// */
//@WebFilter("/Attendance/*")
//public class LoginFilter extends HttpFilter implements Filter {
//
//	/**
//	 * @see HttpFilter#HttpFilter()
//	 */
//	public LoginFilter() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// HttpServletに変換
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//
//		// セッションから情報取得
//		HttpSession session = req.getSession();

//
//		// 未ログインの場合、ログイン画面にリダイレクト
//		if (session == null || session.getAttribute("user") == null) {
//			res.sendRedirect("login.jsp"); // ユーザーがログインしていない場合、login.jspにリダイレクト
//		} else {
//			//もしsessionを持っていてもGetで来た場合はとりあえずlogin.jspに戻す。
//			res.sendRedirect("login.jsp");
//		}
//		// pass the request along the filter chain
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
