package com.sella.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sella.Bean.LoginBean;

public class SearchDao {
	public  boolean validate(LoginBean loginBean) throws ClassNotFoundException, SQLException
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
		
		
		}
		
		
		
		return status;
		
		

}
}
