package com.ankit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.businesslogic.BusinessLogic;

public class Giver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Giver() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
		PrintWriter pr=response.getWriter();
		String carName=request.getParameter("carname");
		String src=request.getParameter("src");
		String dest=request.getParameter("dest");
		int dist=Integer.parseInt(request.getParameter("dist"));
		int totseats=Integer.parseInt(request.getParameter("totseats"));
		int costperkm=Integer.parseInt(request.getParameter("costperkm"));
		int i=(Integer)session.getAttribute("pid");
		BusinessLogic bl=new BusinessLogic();
		bl.insertRide(carName, src, dest, dist, totseats, costperkm);
		RequestDispatcher dis=request.getRequestDispatcher("./Success.jsp");
		dis.forward(request, response);
		}
		else
		{
			response.sendRedirect("./MyHtml.html");
		}
		
		
	}
}


