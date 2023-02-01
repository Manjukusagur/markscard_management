package controller;

import java.io.IOException;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;

import dao.TeacherDao;
import dto.Teacher;

@WebServlet("/teacher")
public class TeacherSignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Teacher teacher=new Teacher();
		teacher.setName(req.getParameter("name"));
		teacher.setEmail(req.getParameter("email"));
		teacher.setMobile(Long.parseLong(req.getParameter("mobile")));
		teacher.setPassword(req.getParameter("password"));
		teacher.setSubject(req.getParameter("subject"));
		teacher.setGender(req.getParameter("gender"));
		
		TeacherDao dao=new TeacherDao();
		try {

			dao.saveTeacher(teacher);
			resp.getWriter().print("<h1> created succefully</h1> ");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		} catch (Exception e) {
			resp.getWriter().print("<h1>email/mobile exist</h1>");
			req.getRequestDispatcher("teacher.html").include(req, resp);
		}
		
	}

}
