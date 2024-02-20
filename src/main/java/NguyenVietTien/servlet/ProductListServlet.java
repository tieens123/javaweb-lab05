package NguyenVietTien.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import NguyenVietTien.beans.Product;
import NguyenVietTien.conn.ConnectionUtils;
import NguyenVietTien.utils.productUtils;
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		public  ProductListServlet() {
			// TODO Auto-generated constructor stub
			super();
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Connection conn = null;
			String errorString = null;
			List<Product> list = null;
			try {
				conn = ConnectionUtils.getMSSQLConnection();
				
				try {
					list = productUtils.queryProduct(conn);
					
				}catch (SQLException e) {
					e.printStackTrace();
					errorString = e.getMessage();		
				}
				request.setAttribute("errorString", errorString);
				request.setAttribute("productList", list);
				
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productList.jsp");
				request.setAttribute("errorString", errorString);
				dispatcher.forward(request, response);
			}catch(ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
				errorString = e1.getMessage();
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productList.jsp");
				request.setAttribute("errorString", errorString);
				dispatcher.forward(request, response);
			}
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
			doGet(request, reponse);
		}
	}
