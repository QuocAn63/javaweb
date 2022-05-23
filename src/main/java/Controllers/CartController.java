package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import DAO.User;
import DAO.UserCart;
/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
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
		
		String ACTION = request.getParameter("ACTION");
		
		switch (ACTION) {
		case "ADDTOCART": {
			addToCart(request);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ACTION);
		}
	}
	
	protected void addToCart(HttpServletRequest request) {
		String PRODUCT_ID = request.getParameter("PRODUCT_ID");
		String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
		String PRODUCT_IMAGE = request.getParameter("PRODUCT_IMAGE");
		double PRODUCT_PRICE = Double.parseDouble(request.getParameter("PRODUCT_PRICE"));
		
		HttpSession session = request.getSession();
		
		UserCart userCart = null;
		Object cartObject = session.getAttribute("cart");
		
		if(cartObject != null) {
			userCart = (UserCart) cartObject;
		} else {
			userCart = new UserCart();
			session.setAttribute("cart", userCart);
		}
		
		userCart.AddToCart(PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, 1);
	}

}
