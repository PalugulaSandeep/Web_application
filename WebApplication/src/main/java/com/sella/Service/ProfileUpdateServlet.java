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
import com.sella.Dao.ProfileUpdateDao;


/**
 * Servlet implementation class ProfileUpdateServlet
 */
public class ProfileUpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ProfileUpdateServlet() {
        super();
    }

    public void init() {
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		    ProfileUpdateDao profileupdatedao = new ProfileUpdateDao();
		    LoginBean loginBean = new LoginBean();
		    
		    String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        String mobileno=request.getParameter("mobileno");
	        String email = request.getParameter("email");
			/*
			 * System.out.println(firstname); System.out.println(lastname);
			 * System.out.println(mobileno); System.out.println(email);
			 */	      
	        
	        loginBean.setFname(firstname);
	        loginBean.setLname(lastname);
	        loginBean.setEmail(email);
	        loginBean.setMobileno(mobileno);
	        
	        try {
	            if (profileupdatedao.validate(loginBean)) {
	            	request.setAttribute("profileStatus", "Profile Update Successfull");
	            	//changes
	            	request.setAttribute("firstname", firstname);
	            	
	            	
	                //response.sendRedirect("profileupdate.jsp");
	            } else {
	            	//out.println("Wrong details:");
	            	request.setAttribute("profileStatus", "Profile Update Unsuccessfull");
//	            	HttpSession session = request.getSession();
	            }
	            request.getRequestDispatcher("profileupdatesucess.jsp").forward(request, response);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	        
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}
