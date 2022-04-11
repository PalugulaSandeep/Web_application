package com.sella.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sella.Bean.LoginBean;
public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl=("jdbc:mysql://localhost:3306/SellaDb");
		String userId="root";
		String password="1234";
		try (Connection connection = DriverManager
				.getConnection(dburl,userId,password);){

			String query ="select username,password from register  where username = ? and password = ? ";


			PreparedStatement preparedStatement = connection
					.prepareStatement(query);{
						preparedStatement.setString(1, loginBean.getUsername());
						preparedStatement.setString(2, loginBean.getPassword());


						ResultSet rs = preparedStatement.executeQuery();
						status = rs.next();
						System.out.println("status:" +status);
					}
		}			catch(SQLException e) {
			e.printStackTrace();
		}
		return status;


	}
}



