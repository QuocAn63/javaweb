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
import DAO.ProductDAO;
import Interface.AccountChecker;

/**
 * Servlet implementation class AdminProduct
 */
@MultipartConfig
@WebServlet("/AdminProduct")
public class AdminProduct extends HttpServlet implements AccountChecker{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(AccountChecker.isLogin(request)) {
			String action = request.getParameter("action");
			
			switch (action) {
				case "new": {
					openAddingForm(request, response);
				}
				break;
				
				case "update": {
					openUpdateForm(request, response);
				}
				break;
				
				case "delete": {
					openDeleteForm(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
		} else {
			response.sendRedirect("Login.jsp");
		}
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
					InsertProduct(request, response);
				}
				break;
				
				case "update": {
					UpdateProduct(request, response);
				}
				break;
				
				case "delete": {
					DeleteProduct(request, response);
				}
				break;
				
				case "cancel": {
					CancelDeleteProduct(request, response);
				}
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void openAddingForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO catDAO = new CategoryDAO();
		CountryDAO conDAO = new CountryDAO();
		
		ArrayList<Category> Category = catDAO.getAll();
		ArrayList<Country> Country = conDAO.getAll();
		
		request.setAttribute("CATEGORIES", Category);
		request.setAttribute("COUNTRIES", Country);
		
		request.getRequestDispatcher("./AdminForm/AddProduct.jsp").forward(request, response);
	}
	
	protected void openUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PRODUCT_ID = request.getParameter("PRODUCT_ID");

		ProductDAO prodDAO = new ProductDAO();
		CategoryDAO catDAO = new CategoryDAO();
		CountryDAO conDAO = new CountryDAO();
		
		DAO.Product Product = prodDAO.getProduct(PRODUCT_ID);
		ArrayList<Category> Category = catDAO.getAll();
		ArrayList<Country> Country = conDAO.getAll();
		
		request.setAttribute("type", "update");
		request.setAttribute("PRODUCT", Product);
		request.setAttribute("CATEGORIES", Category);
		request.setAttribute("COUNTRIES", Country);
		
		request.getRequestDispatcher("./AdminForm/UpdateProduct.jsp").forward(request, response);
	}
	
	protected void openDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductDAO prodDAO = new ProductDAO();
			ArrayList<DAO.Product> list = prodDAO.getAll(1);
			
			request.setAttribute("PRODUCTS", list);
			request.getRequestDispatcher("./AdminForm/DeletedProducts.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void InsertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
			double PRODUCT_PRICE = Double.parseDouble(request.getParameter("PRODUCT_PRICE"));
			String CATEGORY = request.getParameter("CATEGORY");
			String COUNTRY = request.getParameter("COUNTRY");
			String SEASON = request.getParameter("SEASON");
			String PRODUCT_DESCRIPTION = request.getParameter("PRODUCT_DESCRIPTION");
			Part part = request.getPart("PRODUCT_IMAGE");
			
			String realPath = request.getServletContext().getRealPath("/uploads");
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			
			part.write(realPath + "/" + filename);
			
			ProductDAO DAO = new ProductDAO();
			DAO.Insert(new DAO.Product(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESCRIPTION, CATEGORY, SEASON, COUNTRY, "uploads/" + filename));
			
			response.sendRedirect("Admin?site=shop");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String PRODUCT_ID = request.getParameter("PRODUCT_ID");
			String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
			double PRODUCT_PRICE = Double.parseDouble(request.getParameter("PRODUCT_PRICE"));
			String CATEGORY = request.getParameter("CATEGORY");
			String COUNTRY = request.getParameter("COUNTRY");
			String SEASON = request.getParameter("SEASON");
			String PRODUCT_DESCRIPTION = request.getParameter("PRODUCT_DESCRIPTION");
			Part part = request.getPart("PRODUCT_IMAGE");
			
			String realPath = request.getServletContext().getRealPath("/uploads");
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			
			part.write(realPath + "/" + filename);
			
			ProductDAO DAO = new ProductDAO();
			DAO.Product Product = new DAO.Product();
			Product.setPRODUCT_ID(PRODUCT_ID);
			Product.setCATEGORY(CATEGORY);
			Product.setCOUNTRY(COUNTRY);
			Product.setPRODUCT_DESCRIPTION(PRODUCT_DESCRIPTION);
			Product.setPRODUCT_NAME(PRODUCT_NAME);
			Product.setPRODUCT_PRICE(PRODUCT_PRICE);
			Product.setPRODUCT_IMAGE("uploads/" + filename);
			Product.setSEASON(SEASON);
			
			DAO.Update(Product);
		
			response.sendRedirect("Admin?site=shop");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String PRODUCT_ID = request.getParameter("PRODUCT_ID");
			
			ProductDAO DAO = new ProductDAO();
			
			if(DAO.Delete(PRODUCT_ID)) {
				response.sendRedirect("Admin?site=shop");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void CancelDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String PRODUCT_ID = request.getParameter("PRODUCT_ID");
			
			ProductDAO DAO = new ProductDAO();
			
			if(DAO.CancelDelete(PRODUCT_ID)) {
				response.sendRedirect("AdminProduct?action=delete");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
