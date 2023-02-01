package controller;

import java.io.IOException;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/role")
public class SelectRole extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	String role=req.getParameter("role");
	if(role==null)
	{
		resp.getWriter().print("<h1>Atleast Select one Role </h1>");
		req.getRequestDispatcher("signup.html").include(req, resp);
	
	}
	else
	{
		if(role.equals("teacher"))
		{
			resp.sendRedirect("teacher.html");
		}
		else {
			resp.sendRedirect("student.html");
		}
	}
	}
	
	

}
