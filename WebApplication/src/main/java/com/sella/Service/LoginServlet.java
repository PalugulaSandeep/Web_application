package com.sella.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.sella.Bean.LoginBean;
import com.sella.Dao.LoginDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private LoginDao logindao;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	logindao= new LoginDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pn = response.getWriter();
		  String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        LoginBean loginBean = new LoginBean();
	        loginBean.setUsername(username);
	        loginBean.setPassword(password);

	        try {
	            if (logindao.validate(loginBean)) {
	                response.sendRedirect("loginsucess.jsp");
	            } else {
	            	 //	pn.println("Wrong details:");
	            	 HttpSession session = request.getSession();
	                response.sendRedirect("Loginfailed.jsp");
	              //  HttpSession session = request.getSession();
	                //session.setAttribute("user", username);
	                //response.sendRedirect("login.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }catch(IOException e) {
	        	e.printStackTrace();
	        }
	        //CHANGES
	        catch(IllegalStateException e) {
	        	e.printStackTrace();
	        }
	        //end
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
