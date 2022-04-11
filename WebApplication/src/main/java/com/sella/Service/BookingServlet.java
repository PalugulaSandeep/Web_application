package com.sella.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sella.Bean.LoginBean;
import com.sella.Dao.BookingDao;
import com.sella.Dao.ProfileUpdateDao;

public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDao bookingdao = new BookingDao();
	LoginBean loginBean = new LoginBean();



	public BookingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int result=0;
		ResultSet rs = null;
		ArrayList <LoginBean> ar = new ArrayList<>();

		String name = request.getParameter("name");
		String email=request.getParameter("email");  //changes done here....
		String address = request.getParameter("address");
		String hostelname = request.getParameter("hostelname");
		String  capacity= request.getParameter("rcapacity");
		int rcapacity =Integer.parseInt(capacity);// conversion from string to number
		String doj = request.getParameter("doj");


		loginBean.setName(name);
		loginBean.setEmail(email);//changes
		loginBean.setAddress(address);
		loginBean.setHostelname(hostelname);
		loginBean.setRcapacity(rcapacity);
		loginBean.setDoj(doj);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl=("jdbc:mysql://localhost:3306/SellaDb");
			String userId="root";
			String password="1234";
			Connection connection = DriverManager.getConnection(dburl,userId,password);
			String query1=null;
			if(hostelname.contains("arhostel")){
				query1 ="insert into arhostel values(?,?,?,?,?,?)";//
			}else if(hostelname.contains("brhostel")){
				query1 ="insert into brhostel values(?,?,?,?,?,?)";//
			}

			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			preparedStatement.setString(1, loginBean.getName());
			preparedStatement.setString(2, loginBean.getEmail());//changes done here...
			preparedStatement.setString(3, loginBean.getAddress());
			preparedStatement.setString(4, loginBean.getHostelname());
			preparedStatement.setInt(5, loginBean.getRcapacity());
			preparedStatement.setString(6, loginBean.getDoj());


			result = preparedStatement.executeUpdate(); 
			//request.setAttribute("hostelname", hostelname);
			//request.getRequestDispatcher("BookingServlet1").forward(request, response);
			//changes

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl1=("jdbc:mysql://localhost:3306/SellaDb");
				String userId1="root";
				String password1="1234";
				Connection connection1 = DriverManager.getConnection(dburl1,userId1,password1);
				String query2=null;


				if(hostelname.contains("arhostel")) {
					query2="select name,email,address,hostelname,rcapacity,doj from arhostel where name='"+loginBean.getName()+"'";
					//query2="select * from arhostel where name='"+loginBean.getName()+"'";
					//query2="select * from arhostel " ;
					PreparedStatement preparedStatement2= connection.prepareStatement(query2);
					rs =preparedStatement2.executeQuery();
					

					while(rs.next()) {

						ar.add(new LoginBean(rs.getString("name"),rs.getString("email"),rs.getString("address"),rs.getString("hostelname"),rs.getInt("rcapacity"),rs.getString("doj")));
						
					}
					//changes
					request.setAttribute("ar",ar);
					request.getRequestDispatcher("bookingsuccess.jsp").forward(request, response);


				}else {
					query2="select name,email,address,hostelname,rcapacity,doj from brhostel where name='"+loginBean.getName()+"'";

					//query2="select * from brhostel where name='"+loginBean.getName()+"'";
					PreparedStatement preparedStatement2= connection.prepareStatement(query2);
					rs =preparedStatement2.executeQuery();
					while(rs.next()) {

						ar.add(new LoginBean(rs.getString("name"),rs.getString("email"),rs.getString("address"),rs.getString("hostelname"),rs.getInt("rcapacity"),rs.getString("doj")));
						
					}

					request.setAttribute("ar",ar);
					request.getRequestDispatcher("bookingsuccess.jsp").forward(request, response);


				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	//	request.setAttribute("ar",ar);
		//request.getRequestDispatcher("bookingsuccess.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
