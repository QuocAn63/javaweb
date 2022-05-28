package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Product;
import DAO.ProductDAO;
import DAO.Category;
import DAO.CategoryDAO;
import DAO.Country;
import DAO.CountryDAO;
import DAO.Filters;
/**
 * Servlet implementation class ShopProducts
 */
@WebServlet("/ShopProducts")
public class ShopProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopProducts() {
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
		
		Filters Filters = new Filters();
		
		String categoryFilter = request.getParameter("category");
		String priceFilter = request.getParameter("max");
		String seasonFilter = request.getParameter("season");
		String sortbyFilter = request.getParameter("sortby");
		String page = request.getParameter("page");
		String keyword = request.getParameter("q");
		
		if(categoryFilter != null) {
			Filters.setCATEGORY(categoryFilter);
		}
		
		if(priceFilter != null) {
			Filters.setMAX(priceFilter);
		}
		
		if(seasonFilter != null) {
			Filters.setSEASON(seasonFilter);
		}
		if(sortbyFilter != null) {
			Filters.setSORTBY(sortbyFilter);
		}
		if(keyword != null) {
			Filters.setQ(keyword);
		}
		if(page != null) {
			Filters.setPAGE(Integer.parseInt(page));
		} else {
			Filters.setPAGE(1);
		}
		
		ProductDAO proDAO = new ProductDAO();
		CategoryDAO catDAO = new CategoryDAO();
		CountryDAO conDAO = new CountryDAO();
		
		ArrayList<Product> list = proDAO.getAll(Filters);
		ArrayList<Category> catList = catDAO.getAll(0);
		ArrayList<Country> conList = conDAO.getAll();
		int TotalPage = proDAO.getTotalPage(Filters);
				
		request.setAttribute("products", list);
		request.setAttribute("categories", catList);
		request.setAttribute("countries", conList);
		request.setAttribute("filters", categoryFilter);
		request.setAttribute("TotalPage", TotalPage);
		request.getRequestDispatcher("Shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
