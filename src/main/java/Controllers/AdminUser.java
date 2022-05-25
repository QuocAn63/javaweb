package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category;
import DAO.CategoryDAO;
import DAO.Country;
import DAO.CountryDAO;
import DAO.Role;
import DAO.RoleDAO;
import DAO.User;
import DAO.UserDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class AdminUser
 */
@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "new": {
					openAddingForm(request, response);
				}
				break;
				
				case "update": {
					openUpdateForm(request, response);
				}
				break;
				
				case "delete": {
					openDeleteForm(request, response);
				}
				break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "insert": {
					InsertUser(request, response);
				}
				break;
				
				case "update": {
					UpdateUser(request, response);
				}
				break;
				
				case "delete": {
					DeleteUser(request, response);
				}
				break;
				
				case "cancel": {
					CancelDeleteUser(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {
			response.sendRedirect("Login.jsp");
		}
	}
	
	private void openAddingForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleDAO roleDAO = new RoleDAO();
		
		ArrayList<Role> Roles = roleDAO.getAll();
		
		request.setAttribute("ROLES", Roles);
		
		request.getRequestDispatcher("./AdminForm/AddUser.jsp").forward(request, response);
	}
	
	private void openUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER_NAME = request.getParameter("USER_NAME");
		UserDAO userDAO = new UserDAO();
		RoleDAO roleDAO = new RoleDAO();
		
		DAO.User User = userDAO.Find(USER_NAME);
		ArrayList<Role> Roles = roleDAO.getAll();
		
		System.out.println(User.getUSER_NAME());
		
		request.setAttribute("ROLES", Roles);
		request.setAttribute("USER", User);
		request.getRequestDispatcher("./AdminForm/UpdateUser.jsp").forward(request, response);
	}
	
	private void openDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		ArrayList<User> Users = userDAO.getAll(1);
		request.setAttribute("USERS", Users);
		request.getRequestDispatcher("./AdminForm/DeleteUsers.jsp").forward(request, response);
	}

	private void InsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER_NAME = request.getParameter("USER_NAME");
		String USER_PASSWORD = request.getParameter("USER_PASSWORD");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PHONE_NUMBER = request.getParameter("USER_PHONE_NUMBER");
		int USER_ROLE = Integer.parseInt(request.getParameter("USER_ROLE"));
		
		UserDAO userDAO = new UserDAO();
		DAO.User User = new DAO.User(USER_NAME, USER_PASSWORD, USER_EMAIL, USER_PHONE_NUMBER, USER_ROLE);
		
		if(userDAO.Save(User)) {
			response.sendRedirect("Admin?site=user");
		}
	}
	
	private void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER_ID = request.getParameter("USER_ID");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PHONE_NUMBER = request.getParameter("USER_PHONE_NUMBER");
		String USER_FULL_NAME = request.getParameter("USER_FULL_NAME");
		String USER_DOB = request.getParameter("USER_DOB");
		String USER_ADDRESS = request.getParameter("USER_ADDRESS");
		int USER_GENDER = Integer.parseInt(request.getParameter("USER_GENDER"));
		
		UserDAO userDAO = new UserDAO();
		DAO.User User = new DAO.User();
		
		User.setUSER_ID(USER_ID);
		User.setUSER_EMAIL(USER_EMAIL);
		User.setUSER_PHONE_NUMBER(USER_PHONE_NUMBER);
		User.setUSER_FULL_NAME(USER_FULL_NAME);
		User.setUSER_ADDRESS(USER_ADDRESS);
		User.setUSER_DOB(USER_DOB);
		User.setUSER_GENDER(USER_GENDER);
		
		if(userDAO.Update(User)) {
			response.sendRedirect("Admin?site=user");
		}
	}
	
	private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER_ID = request.getParameter("USER_ID");
		
		UserDAO userDAO = new UserDAO();
		
		if(userDAO.Delete(USER_ID)) {
			response.sendRedirect("Admin?site=user");
		}
	}
	
	private void CancelDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String USER_ID = request.getParameter("USER_ID");
		
		UserDAO userDAO = new UserDAO();
		
		if(userDAO.CancelDelete(USER_ID)) {
			response.sendRedirect("AdminUser?action=delete");
		}
	}
	
}
