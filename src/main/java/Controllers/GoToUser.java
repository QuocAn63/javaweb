package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Invoice;
import DAO.InvoiceDAO;
import DAO.InvoiceItem;
import DAO.InvoicesFilter;
import DAO.User;
import Interface.AccountChecker;

/**
 * Servlet implementation class GoToUser
 */
@WebServlet("/GoToUser")
public class GoToUser extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(AccountChecker.isLogin(request)) {
			String site = request.getParameter("site");
			
			switch (site) {
				case "profile": {
					GoToUserProfile(request, response);
				}
				break;
				
				case "invoices": {
					GoToUserInvoices(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + site);
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
	
	protected void GoToUserProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("User.jsp");
	}
	
	protected void GoToUserInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		String TYPE = request.getParameter("type");
		
		InvoicesFilter Filter = new InvoicesFilter();
		
		if(TYPE != null) {
			Filter.setTYPE(TYPE);
		}
		
		User User = (User) session.getAttribute("account");
		String USER_ID = User.getUSER_ID();
		InvoiceDAO DAO = new InvoiceDAO();
		
		ArrayList<Invoice> UserInvoices = DAO.getAllWithID(USER_ID, Filter);
		
		request.setAttribute("Invoices", UserInvoices);
		
		request.getRequestDispatcher("Invoices.jsp").forward(request, response);
	}

}
