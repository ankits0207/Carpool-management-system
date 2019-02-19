package com.ankit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.businesslogic.BusinessLogic;


public class regemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regemp() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session!=null)
		{
		PrintWriter pr=response.getWriter();
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		String pwd=request.getParameter("pwd");
		BusinessLogic bl=new BusinessLogic();
		int i=bl.insertPersonRegister(name,phno,pwd);
		if(i!=0)
		{
			pr.println("<html>");
			pr.println("<head>");
			pr.println("<title>Welcome</title>");
			pr.println("</head>");
			pr.println("<body>");
			pr.println("<form>");
				pr.println("Your pid is "+i);
				pr.println("<br>");
				pr.println("<a href=\"MyHtml.html\">REGISTERED SUCCESSFULLY!!GO BACK</a>");
			pr.println("</body>");
			pr.println("</form>");
			pr.println("</html>");
		}
		else
		pr.println("PERSON ADDITION FAILED");
		}
		else
		{
			response.sendRedirect("./MyHtml.html");
		}
	}
	
	}


