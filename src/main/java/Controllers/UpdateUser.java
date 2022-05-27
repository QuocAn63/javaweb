package Controllers;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.User;
import DAO.UserDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		updateUser(request, response);
	}
	
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		User User = (User) session.getAttribute("account");
		
		String USER_ID = User.getUSER_ID();
		String USER_FULL_NAME = request.getParameter("USER_FULL_NAME");
		USER_FULL_NAME = URLDecoder.decode(USER_FULL_NAME, "UTF-8");
		String USER_PHONE_NUMBER = request.getParameter("USER_PHONE_NUMBER");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_ADDRESS = request.getParameter("USER_ADDRESS");
		String USER_DOB = request.getParameter("USER_DOB");
		int USER_GENDER = Integer.parseInt(request.getParameter("USER_GENDER"));
		
		User.setUSER_ID(USER_ID);
		User.setUSER_FULL_NAME(USER_FULL_NAME);
		User.setUSER_PHONE_NUMBER(USER_PHONE_NUMBER);
		User.setUSER_EMAIL(USER_EMAIL);
		User.setUSER_ADDRESS(USER_ADDRESS);
		User.setUSER_GENDER(USER_GENDER);
		User.setUSER_DOB(USER_DOB);
		
		UserDAO DAO = new UserDAO();
		
		if(DAO.Update(User)) {
			session.setAttribute("account", User);
			session.setAttribute("profileChecker", AccountChecker.profileChecker(request));
			
			response.sendRedirect("GoToUser?site=profile");
		} else {
			response.sendRedirect("GoToUser?site=profile");
		}
	}

}
