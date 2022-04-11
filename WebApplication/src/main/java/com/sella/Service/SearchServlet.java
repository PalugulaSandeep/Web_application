package com.sella.Service;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sella.Bean.LoginBean;
//import com.sella.Dao.DatabaseConnection;
import com.sella.Dao.ProfileUpdateDao;
import com.sella.Dao.SearchDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBean loginBean = new LoginBean();
	SearchDao searchDao = new SearchDao();
	

	public SearchServlet() {
		super();
	}
	public void init() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

	    String location = request.getParameter("location");
	  // if(location.equals("perungudi")||location.equals("PERUNGUDI")) {
		   	   if(location.equalsIgnoreCase("perungudi")) {

	    	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
	    		String dburl=("jdbc:mysql://localhost:3306/SellaDb");
	    		String userId="root";
	    		String password="1234";
	    		ResultSet rs = null;
	    		ArrayList <LoginBean> ar = new ArrayList<>();
	    		
	    		try (Connection connection = DriverManager.getConnection(dburl,userId,password);)
	    		{
	    			// System.out.println("checking");
	    			String query ="select hostelname from locationtable where location= ?";
	    			
	    			
	    			PreparedStatement preparedStatement = connection.prepareStatement(query);
	    			

	    			preparedStatement.setString(1,location);
	    			rs =preparedStatement.executeQuery();
	    		//System.out.println("checking");
	    			while(rs.next()) {
	    		  
	    			ar.add(new LoginBean(rs.getString("hostelname")));
	    			}
	    			
	    		} catch (SQLException e) {
					
					e.printStackTrace();
				}
	    			request.setAttribute("ar",ar);
	    			request.getRequestDispatcher("SearchSuccess.jsp").forward(request, response);
	   }
	   //changes
	   else {
			request.getRequestDispatcher("failuresearch.jsp").forward(request, response);

	   }
	    		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
