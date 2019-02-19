package com.ankit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Welcome() {
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
		pr.println("<html>");
		pr.println("<head>");
		pr.println("<title>Welcome</title>");
		pr.println("</head>");
		pr.println("<body>");
		pr.println("<form>");
			pr.println("<a href=\"./Giver.jsp\">1.Giver</a><br>");
			pr.println("<a href=\"./Requester.jsp\">2.Requester</a><br>");
			pr.println("<a href=\"./Logout\">3.Logout</a><br>");
		pr.println("</body>");
		pr.println("</form>");
		pr.println("</html>");
		}
		else
		{
			response.sendRedirect("./MyHtml.html");
		}
	}
	

}
