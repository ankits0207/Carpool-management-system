package com.ankit.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.businesslogic.BusinessLogic;
import com.car.daoImpl.RideDaoImpl;


public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Cancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
		int rid=Integer.parseInt(request.getParameter("rid"));
		int pid=(Integer)session.getAttribute("pid");
		BusinessLogic bl=new BusinessLogic();
		RideDaoImpl ride=new RideDaoImpl();
		
		
		int chk=bl.delTrans(rid,pid);
		if(chk==1)
		{	
			if(ride.updateRideC(rid))
			{
				RequestDispatcher dis=request.getRequestDispatcher("./Success.jsp");
				dis.forward(request, response);
			}
			
		}
		else
		{
			RequestDispatcher dis=request.getRequestDispatcher("./Failure.jsp");
			dis.forward(request, response);
		}
		}
		else
		{
			response.sendRedirect("./MyHtml.html");
		}
	}

}
