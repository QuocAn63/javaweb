package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.User;
import DAO.UserDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String USER_NAME = request.getParameter("USER_NAME");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PHONE_NUMBER = request.getParameter("USER_PHONE_NUMBER");
		String USER_PASSWORD = request.getParameter("USER_PASSWORD");
		String USER_FULL_NAME = request.getParameter("USER_FULL_NAME");
		String USER_RE_PASSWORD = request.getParameter("USER_RE_PASSWORD");
		USER_FULL_NAME = URLDecoder.decode(USER_FULL_NAME, "UTF-8");
		
		if(!USER_PASSWORD.equals(USER_RE_PASSWORD)) {
			request.setAttribute("MESSAGE", "MẬT KHẨU NHẬP LẠI KHÔNG CHÍNH XÁC");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		} else {
			UserDAO DAO = new UserDAO();
			User isAccountExist = DAO.Find(USER_NAME);
			if(isAccountExist == null) {
				boolean result = DAO.Save(new User(USER_NAME, USER_PASSWORD, USER_EMAIL, USER_PHONE_NUMBER, USER_FULL_NAME));
				if(result) {
					response.sendRedirect("Home");
				} else {
					request.setAttribute("MESSAGE", "Đăng ký không thành công");
					request.getRequestDispatcher("Register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("MESSAGE", "TÀI KHOẢN ĐÃ TỒN TẠI");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}	
		}
		
		
	}

}
