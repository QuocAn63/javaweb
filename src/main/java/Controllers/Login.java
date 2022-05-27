package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.User;
import DAO.UserDAO;
import Interface.AccountChecker;
import Interface.EncryptPass;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet implements EncryptPass {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AccountChecker.isLogin(request)) {
			response.sendRedirect("Home");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8");
			
			String USER_NAME = request.getParameter("USER_NAME");
			String USER_PASSWORD = request.getParameter("USER_PASSWORD");
			
			User User = new User();
			UserDAO DAO = new UserDAO();
			
			User = DAO.Login(USER_NAME, EncryptPass.md5(USER_PASSWORD));	
			
			if(User == null) {
				request.setAttribute("MESSAGE", "Sai tên tài khoản hoặc mật khẩu");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				if(User.getIS_DISABLED() != 1) {
					HttpSession session = request.getSession();
					session.setAttribute("account", User);
					session.setAttribute("profileChecker", AccountChecker.profileChecker(request));
					
					response.sendRedirect("Home");				
				} else {
					request.setAttribute("MESSAGE", "Tài khoản đã bị khoá");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
				
			}
		} catch (Exception e) {
			
		}
	}
}
