package com.sella.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sella.Bean.LoginBean;

public class BookingDao {
	public  boolean validate(LoginBean loginBean) throws ClassNotFoundException, SQLException
	{
		boolean status = false;
		int result =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl=("jdbc:mysql://localhost:3306/SellaDb");
		String userId="root";
		String password="1234";
		ResultSet rs= null;
		ArrayList <LoginBean> ar1 = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(dburl,userId,password);)
		{
			//String query="select * from ? ";
			String query="select name,address,hostelname,rcapacity,doj from ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,loginBean.getHostelname());
			rs =preparedStatement.executeQuery();
			while(rs.next()) {
				ar1.add(new LoginBean(rs.getString("name"), rs.getString("email"),rs.getString("address"),rs.getString("hostelname"),rs.getInt("rcapacity"),rs.getString("doj")));
				
			}
			//request.setAttributr("ar", ar);
			

		//	result = preparedStatement.executeUpdate(); 
			status = true;
			
		}catch(SQLException e) {
				//e.printStackTrace();
			}
		return status;

		}
	}



