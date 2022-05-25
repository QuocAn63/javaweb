package Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Category;
import DAO.CategoryDAO;
import DAO.Country;
import DAO.CountryDAO;
import DAO.Invoice;
import DAO.InvoiceDAO;
import DAO.ProductDAO;
import DAO.User;
import DAO.UserDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class Admin
 */
@MultipartConfig
@WebServlet("/Admin")
public class Admin extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(AccountChecker.isLogin(request)) {
			String site = request.getParameter("site");
			
			if(site != null) {
				switch (site) {
				case "shop": {
					AdminShop(request, response);
				}
				break;
				
				case "category": {
					AdminCategory(request, response);
				}
				break;
				
				case "country": {
					AdminCountry(request, response);
				}
				break;
				
				case "invoice": {
					AdminInvoice(request, response);
				}
				break;
				
				case "user": {
					AdminUser(request, response);
				}
				break;
				
				default:
					AdminShop(request, response);
				}	
			} else {
				AdminShop(request, response);
			}
			
		} else {
			response.sendRedirect("Login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void AdminShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO DAO = new ProductDAO();
		ArrayList<DAO.Product> list = DAO.getAll();
		
		request.setAttribute("PRODUCTS", list);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
	}
	
	private void AdminCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO DAO = new CategoryDAO();
		ArrayList<Category> list = DAO.getAll();
		
		request.setAttribute("CATEGORIES", list);
		request.getRequestDispatcher("AdminCategory.jsp").forward(request, response);
	}
	
	private void AdminCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountryDAO DAO = new CountryDAO();
		ArrayList<Country> list = DAO.getAll();
		
		request.setAttribute("COUNTRIES", list);
		request.getRequestDispatcher("AdminCountry.jsp").forward(request, response);
	}

	private void AdminInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDAO DAO = new InvoiceDAO();
		ArrayList<Invoice> list = DAO.getAll();
		
		request.setAttribute("INVOICES", list);
		request.getRequestDispatcher("AdminInvoice.jsp").forward(request, response);
	}
	
	private void AdminUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO DAO = new UserDAO();
		ArrayList<User> list = DAO.getAll();
		
		request.setAttribute("USERS", list);
		request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
	}
}
