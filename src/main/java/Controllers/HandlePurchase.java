package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartItem;
import DAO.Invoice;
import DAO.InvoiceDAO;
import DAO.InvoiceItem;
import DAO.Product;
import DAO.User;
import DAO.UserCart;
import Interface.AccountChecker;

/**
 * Servlet implementation class HandlePurchase
 */
@WebServlet("/HandlePurchase")
public class HandlePurchase extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandlePurchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(AccountChecker.isLogin(request)) {
			HttpSession session = request.getSession();
			
			User User = (User) session.getAttribute("account");
			UserCart UserCart = (UserCart) session.getAttribute("cart");
			InvoiceDAO DAO = new InvoiceDAO();
			Invoice Invoice = new Invoice();
			ArrayList<CartItem> list = UserCart.getList();
			ArrayList<InvoiceItem> productList = new ArrayList<InvoiceItem>();
			
			String USER_ID = User.getUSER_ID();
			String RECEIVER_FULL_NAME = request.getParameter("RECEIVER_FULL_NAME");
			String RECEIVER_ADDRESS = request.getParameter("RECEIVER_ADDRESS");
			String RECEIVER_PHONE_NUMBER = request.getParameter("RECEIVER_PHONE_NUMBER");
			double INVOICE_GRAND_TOTAL = UserCart.getTotal();
			
			Invoice.setUSER_ID(USER_ID);
			Invoice.setRECEIVER_FULL_NAME(RECEIVER_FULL_NAME);
			Invoice.setRECEIVER_ADDRESS(RECEIVER_ADDRESS);
			Invoice.setRECEIVER_PHONE_NUMBER(RECEIVER_PHONE_NUMBER);
			Invoice.setINVOICE_GRAND_TOTAL(INVOICE_GRAND_TOTAL);
			
			for(CartItem product : list) {
				productList.add(new InvoiceItem(product.getPRODUCT(), product.getQUANTITY()));
			}
			
			Invoice.setList(productList);
			
			if(DAO.CreateInvoice(Invoice)) {
				session.removeAttribute("cart");
				request.getRequestDispatcher("Home").forward(request, response);
			} else {
				response.sendRedirect("Checkout");
			}
		}
	}

}
