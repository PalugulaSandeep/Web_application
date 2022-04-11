package com.sella.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.sella.Bean.LoginBean;
import com.sella.Dao.RegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao registerdao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() {
		registerdao=new RegisterDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LoginBean employee = new LoginBean();
		

		String username=request.getParameter("uname");
		String password=request.getParameter("upass");
		
		employee.setUsername(username);
		employee.setPassword(password);


		try {
			int res=registerdao.registerEmployee(employee);
			if(res>0){
				response.sendRedirect("Registersuccess.jsp");
			}
			else {
				out.println("user alredy exists:");
				out.println("<div align='center'>");
				out.println("<html><body bgcolor='lightpink'><h3>user name already exist</h3></body></html>");
				out.println("<h1>please enter valid user name</h1>");
				out.println("<a href=\"signup.html\">OK\r\n");
				
				
			}
		}
		
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
			
		//response.sendRedirect("Registersuccess.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
