package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.http.HttpRequest;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.apache.taglibs.standard.tag.common.core.SetSupport;

import DAO.User;
import DAO.UserCart;
import Interface.AccountChecker;
/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet implements AccountChecker {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		
		String currentURL = request.getHeader("referer");
		
		if(AccountChecker.isLogin(request)) {
			String ACTION = request.getParameter("ACTION");
			
			switch (ACTION) {
				case "ADDTOCART": {
					addToCart(request);
				}
				break;
				
				case "DELETEFROMCART": {
					deleteFromCart(request);
				}
				break;
				
				case "EDITCART": {
					editProductQuantity(request);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + ACTION);
			}
			
			
			response.sendRedirect(currentURL);
		} else {
			request.setAttribute("previousURL", currentURL);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
	
	protected void addToCart(HttpServletRequest request) throws ServletException, IOException {
		String PRODUCT_ID = request.getParameter("PRODUCT_ID");
		
		HttpSession session = request.getSession();
		
		UserCart newUserCart = null;
		
		Object CartObject = session.getAttribute("cart");
		
		if(CartObject == null) {
			newUserCart = new UserCart();
		} else {
			newUserCart = (UserCart) CartObject;
		}
		
		if(newUserCart.isExisting(PRODUCT_ID)) {
			newUserCart.extraProduct(PRODUCT_ID);
		} else {
			newUserCart.AddToCart(PRODUCT_ID);
		}
		session.setAttribute("cart", newUserCart);
	}

	protected void deleteFromCart(HttpServletRequest request) throws ServletException, IOException {
		String PRODUCT_ID = request.getParameter("PRODUCT_ID");
		
		HttpSession session = request.getSession();
		
		UserCart newUserCart = (UserCart) session.getAttribute("cart");
		
		if(newUserCart.RemoveFromCart(PRODUCT_ID)) {
			session.setAttribute("cart", newUserCart);			
		} else {
			session.removeAttribute("cart");
		}
	}
	
	protected void editProductQuantity(HttpServletRequest request) throws ServletException, IOException {
		String PRODUCT_ID = request.getParameter("PRODUCT_ID");
		int QUANTITY = Integer.parseInt(request.getParameter("QUANTITY"));
		
		HttpSession session = request.getSession();
		
		UserCart newUserCart = (UserCart) session.getAttribute("cart");
		
		newUserCart.EditProductQuantity(PRODUCT_ID, QUANTITY);
		
		session.setAttribute("cart", newUserCart);
	}
}
