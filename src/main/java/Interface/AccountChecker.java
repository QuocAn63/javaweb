package Interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

public interface AccountChecker {
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object userObject = session.getAttribute("account");

		return userObject != null;
	}
	
	public static boolean isCartEmpty(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object cartObject = session.getAttribute("cart");
		
		return cartObject == null;
	}
}

