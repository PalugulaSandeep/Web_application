package com.sella.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.sella.Bean.LoginBean;
import com.sella.Service.RegisterServlet;

import jakarta.servlet.RequestDispatcher;
public class RegisterDao {
	static String username;
   static 	String password;

	public int registerEmployee(LoginBean employee) throws ClassNotFoundException, SQLException {
		int result =0;
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
	Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl=("jdbc:mysql://localhost:3306/SellaDb");
		String userId="root";
		String password="1234";

		try (Connection connection = DriverManager
				.getConnection(dburl,userId,password);) {

			String query ="insert into register values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(1, employee.getUsername());
		preparedStatement.setString(2, employee.getPassword());
		//System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate(); 
		}
		catch (SQLIntegrityConstraintViolationException e){
			result=0;
		}
		return result;
		}
	}



