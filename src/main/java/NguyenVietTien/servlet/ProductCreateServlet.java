package NguyenVietTien.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productCreate")

public class ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProductCreateServlet() {
		super();
	}
//hiển thị trang thêm sp
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
			dispatcher.forward(request, response);
	}
	
	//khi người dùng nhấn vào submit
	//phương thức post se được gọi
	@Override
	protected void doPost(Http)
	
}
