package com.sella.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sella.Bean.LoginBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class MyBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBean loginBean = new LoginBean();


	public MyBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		String name = request.getParameter("name");
		String hostelname = request.getParameter("hostelname");

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl=("jdbc:mysql://localhost:3306/SellaDb");
			String userId="root";
			String password="1234";
			ResultSet rs = null;
			ArrayList <LoginBean> ar = new ArrayList<>();

			Connection connection = DriverManager.getConnection(dburl,userId,password);
 
			if(true) {
				String query = null;
			if(hostelname.equalsIgnoreCase("arhostel")) {
				//query ="select * from arhostel where name = '"+name+"'";
				query="select  name , address, doj,rcapacity from arhostel where name= '"+name+"'";
				}
			else if(hostelname.equalsIgnoreCase("brhostel")) {
				//query ="select * from brhostel where name = '"+name+"'";
				query="select  name , address, doj,rcapacity from brhostel where name= '"+name+"'";

			}else {
				request.getRequestDispatcher("FailureMyBooking.jsp").forward(request, response);

			}
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				rs =preparedStatement.executeQuery();
				
				while(rs.next()) {

					ar.add(new LoginBean(rs.getString("name"),rs.getString("address"),rs.getString("doj"),rs.getInt("rcapacity")));
				}
				System.out.println(ar);
				
				request.setAttribute("ar",ar);
				request.getRequestDispatcher("MyBookingSuccess.jsp").forward(request, response);


	}//else
			//	request.getRequestDispatcher("FailureMyBooking.jsp").forward(request, response);


		
		}catch (IOException e) {
			//e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
