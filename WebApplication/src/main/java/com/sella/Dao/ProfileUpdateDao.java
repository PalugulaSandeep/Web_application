package com.sella.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sella.Bean.LoginBean;

public class ProfileUpdateDao 
{
	public  boolean validate(LoginBean loginBean) throws Exception
	{
		
		boolean status = false;
		int result =0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl=("jdbc:mysql://localhost:3306/SellaDb");
		String userId="root";
		String password="1234";
		try (Connection connection = DriverManager.getConnection(dburl,userId,password);)
		{
			String query1 ="insert into profileupdate values(?,?,?,?)";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			preparedStatement.setString(1, loginBean.getFname());
			preparedStatement.setString(2, loginBean.getLname());
			preparedStatement.setString(3, loginBean.getMobileno());
			preparedStatement.setString(4, loginBean.getEmail());
		
			result = preparedStatement.executeUpdate(); 
					status=true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}