package com.ankit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sorry
 */
public class Sorry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sorry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr=response.getWriter();
		pr.println("<html>");
		pr.println("<head>");
		pr.println("<title>Welcome</title>");
		pr.println("</head>");
		pr.println("<body>");
		pr.println("<form>");
			pr.println("Sorry Login failed!! Bye!!");
		pr.println("</body>");
		pr.println("</form>");
		pr.println("</html>");
		// TODO Auto-generated method stub
	}

}
