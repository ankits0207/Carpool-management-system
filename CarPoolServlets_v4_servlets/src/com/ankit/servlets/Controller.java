package com.ankit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.businesslogic.BusinessLogic;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	BusinessLogic bl=new BusinessLogic();
	int uid=Integer.parseInt(request.getParameter("username"));
	String pwd=request.getParameter("pwd");
		if(bl.search(uid,pwd))
		{	HttpSession session=request.getSession();
			session.setAttribute("pid", uid);
			RequestDispatcher dis=request.getRequestDispatcher("./Welcome");
			dis.forward(request, response);
		}
		else
		{
			RequestDispatcher dis=request.getRequestDispatcher("./Sorry");
			dis.forward(request, response);
		}
	}
	
}
