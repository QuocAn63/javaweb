package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Country;
import DAO.CountryDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class AdminCountry
 */
@WebServlet("/AdminCountry")
public class AdminCountry extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCountry() {
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
					OpenDeletedCountry(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "insert": {
					InsertCountry(request, response);
				}
				break;
				
				case "update": {
					UpdateCountry(request, response);
				}
				break;
				
				case "delete": {
					DeleteCountry(request, response);
				}
				break;
				
				case "cancel": {
					CancelDeleteCountry(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		}
	}

	
	private void OpenDeletedCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountryDAO DAO = new CountryDAO();
		ArrayList<Country> list = DAO.getAll(1);
		
		request.setAttribute("COUNTRIES", list);
		request.getRequestDispatcher("./AdminForm/DeletedCountry.jsp").forward(request, response);
		
	}

	private void EnableInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "insert");
		request.getRequestDispatcher("Admin?site=country").forward(request, response);
	}
	
	private void EnableEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountryDAO DAO = new CountryDAO();
		String COUNTRY_ID = request.getParameter("COUNTRY_ID");
		DAO.Country Country = DAO.GetCountry(COUNTRY_ID);
		
		request.setAttribute("COUNTRY", Country);
		request.setAttribute("action", "update");
		request.getRequestDispatcher("Admin?site=country").forward(request, response);
	}
	
	protected void InsertCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String COUNTRY_ID = request.getParameter("COUNTRY_ID");
		String COUNTRY_NAME = request.getParameter("COUNTRY_NAME");
		
		CountryDAO DAO = new CountryDAO();
		DAO.Country Country = new DAO.Country(COUNTRY_ID, COUNTRY_NAME);
	
		if(DAO.InsertCountry(Country)) {
			response.sendRedirect("Admin?site=country");
		}
	}
	
	protected void UpdateCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String COUNTRY_ID = request.getParameter("COUNTRY_ID");
		String COUNTRY_NAME = request.getParameter("COUNTRY_NAME");
		
		CountryDAO DAO = new CountryDAO();
		DAO.Country Country = new DAO.Country(COUNTRY_ID, COUNTRY_NAME);
	
		if(DAO.UpdateCountry(Country)) {
			response.sendRedirect("Admin?site=country");
		}
	}
	
	protected void DeleteCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String COUNTRY_ID = request.getParameter("COUNTRY_ID");
		
		CountryDAO DAO = new CountryDAO();
		DAO.Country Country = new DAO.Country(COUNTRY_ID);
	
		if(DAO.DeleteCountry(Country)) {
			response.sendRedirect("Admin?site=category");
		}
	}

	protected void CancelDeleteCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CATEGORY_ID = request.getParameter("COUNTRY_ID");
		
		CountryDAO DAO = new CountryDAO();
		DAO.Country Country = new DAO.Country(CATEGORY_ID);
	
		if(DAO.CancelDeleteCountry(Country)) {
			response.sendRedirect("AdminCountry?action=delete");
		}
	}
}
