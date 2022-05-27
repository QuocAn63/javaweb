package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category;
import DAO.CategoryDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class AdminCategory
 */
@WebServlet("/AdminCategory")
public class AdminCategory extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCategory() {
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
				case "insert": {
					EnableInsert(request, response);
				}
				break;
				
				case "edit": {
					EnableEdit(request, response);
				}
				break;
				
				case "delete": {
					OpenDeletedCategory(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		}
	}

	private void OpenDeletedCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO DAO = new CategoryDAO();
		ArrayList<Category> list = DAO.getAll(1);
		
		request.setAttribute("CATEGORIES", list);
		request.getRequestDispatcher("./AdminForm/DeletedCategory.jsp").forward(request, response);
		
	}

	private void EnableInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "insert");
		request.getRequestDispatcher("Admin?site=category").forward(request, response);
	}
	
	private void EnableEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO DAO = new CategoryDAO();
		String CATEGORY_ID = request.getParameter("CATEGORY_ID");
		DAO.Category Category = DAO.GetCategory(CATEGORY_ID);
		
		request.setAttribute("CATEGORY", Category);
		request.setAttribute("action", "update");
		request.getRequestDispatcher("Admin?site=category").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "insert": {
					InsertCategory(request, response);
				}
				break;
				
				case "update": {
					UpdateCategory(request, response);
				}
				break;
				
				case "delete": {
					DeleteCategory(request, response);
				}
				break;
				
				case "cancel": {
					CancelDeleteCategory(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		}
	}
	
	protected void InsertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CATEGORY_ID = request.getParameter("CATEGORY_ID");
		String CATEGORY_NAME = request.getParameter("CATEGORY_NAME");
		
		CategoryDAO DAO = new CategoryDAO();
		DAO.Category Category = new DAO.Category(CATEGORY_ID, CATEGORY_NAME);
	
		if(DAO.InsertCategory(Category)) {
			response.sendRedirect("Admin?site=category");
		}
	}
	
	protected void UpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CATEGORY_ID = request.getParameter("CATEGORY_ID");
		String CATEGORY_NAME = request.getParameter("CATEGORY_NAME");
		
		CategoryDAO DAO = new CategoryDAO();
		DAO.Category Category = new DAO.Category(CATEGORY_ID, CATEGORY_NAME);
	
		if(DAO.UpdateCategory(Category)) {
			response.sendRedirect("Admin?site=category");
		}
	}
	
	protected void DeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CATEGORY_ID = request.getParameter("CATEGORY_ID");
		
		CategoryDAO DAO = new CategoryDAO();
		DAO.Category Category = new DAO.Category(CATEGORY_ID);
	
		if(DAO.DeleteCategory(Category)) {
			response.sendRedirect("Admin?site=category");
		}
	}

	protected void CancelDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CATEGORY_ID = request.getParameter("CATEGORY_ID");
		
		CategoryDAO DAO = new CategoryDAO();
		DAO.Category Category = new DAO.Category(CATEGORY_ID);
	
		if(DAO.CancelDeleteCategory(Category)) {
			response.sendRedirect("AdminCategory?action=delete");
		}
	}
}
