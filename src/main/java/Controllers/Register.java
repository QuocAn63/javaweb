package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Encoder;

import org.apache.tomcat.util.security.MD5Encoder;

import DAO.User;
import DAO.UserDAO;
import Interface.AccountChecker;
import Interface.EncryptPass;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet implements EncryptPass, AccountChecker {
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
		if(AccountChecker.isLogin(request)) {
			response.sendRedirect("Home");
		} else {
			response.sendRedirect("Register.jsp");
		}
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
			request.setAttribute("MESSAGE", "M???T KH???U NH???P L???I KH??NG CH??NH X??C");
			request.getRequestDispatcher("Register").forward(request, response);
		} else {
			UserDAO DAO = new UserDAO();
			User isAccountExist = DAO.Find(USER_NAME);
			
			if(isAccountExist == null) {
				try {
					boolean result = DAO.Save(new User(USER_NAME, EncryptPass.md5(USER_PASSWORD), USER_EMAIL, USER_PHONE_NUMBER, USER_FULL_NAME));
					if(result) {
						response.sendRedirect("Login");
					} else {
						request.setAttribute("MESSAGE", "????ng k?? kh??ng th??nh c??ng");
						request.getRequestDispatcher("Register.jsp").forward(request, response);
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("MESSAGE", "T??I KHO???N ???? T???N T???I");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}	
		}
		
		
	}

}
