package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import dao.StudentDao;
import dao.TeacherDao;
import dto.Student;


@WebServlet("/student")

public class StudentSignup extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		Student student=new Student();
		student.setMobile(Long.parseLong(req.getParameter("mobile")));
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setPassword(req.getParameter("password"));
		student.setClass(req.getParameter("Class"));
	
		Date date3=Date.valueOf(req.getParameter("date"));
		
		student.setDOB(date3);
		LocalDate date=date3.toLocalDate();
		LocalDate date2=LocalDate.now();
		student.setAge(Period.between(date, date2).getYears());
		
		StudentDao dao=new StudentDao();
		try {

			dao.saveStudent(student);
			resp.getWriter().print("<h1> created succefully</h1> ");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		} catch (Exception e) {
			resp.getWriter().print("<h1>email/mobile exist</h1>");
			req.getRequestDispatcher("student.html").include(req, resp);
		}
		
		

	
	}

}
