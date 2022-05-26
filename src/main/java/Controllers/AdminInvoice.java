package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InvoiceDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class AdminInvoice
 */
@WebServlet("/AdminInvoice")
public class AdminInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OpenInvoiceDetail(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "delivery": {
					UpdateInvoiceToDelivery(request, response);
				}
				break;
				
				case "complete": {
					UpdateInvoiceToComplete(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void OpenInvoiceDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String INVOICE_ID = request.getParameter("INVOICE_ID");
			InvoiceDAO DAO = new InvoiceDAO();
			DAO.Invoice Invoice = DAO.getInvoice(INVOICE_ID);
			
			request.setAttribute("INVOICE", Invoice);
			request.getRequestDispatcher("./AdminForm/UpdateInvoice.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void UpdateInvoiceToDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String INVOICE_ID = request.getParameter("INVOICE_ID");
			InvoiceDAO DAO = new InvoiceDAO();
			
			if(DAO.UpdateStatus(INVOICE_ID, 1)) {
				response.sendRedirect("Admin?site=invoice");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void UpdateInvoiceToComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String INVOICE_ID = request.getParameter("INVOICE_ID");
			InvoiceDAO DAO = new InvoiceDAO();
			
			if(DAO.UpdateStatus(INVOICE_ID, 2)) {
				response.sendRedirect("Admin?site=invoice");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
