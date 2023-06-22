package tutoresPets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/pets")
public class MainServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {		
		resp.getWriter().print("Endpoint Get");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().print("Endpoint Post");
	}
	
	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().print("Endpoint Put");
	}
	
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().print("Endpoint Delete");
	}
	
}
