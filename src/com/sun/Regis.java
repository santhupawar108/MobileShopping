package com.sun;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regis
 */
@WebServlet("/regis")
public class Regis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		String rpsw = request.getParameter("rpsw");
		
		PrintWriter pw = response.getWriter();
		if(psw != rpsw) {
			
			pw.write("password not matching");
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/santhu","root","");
			PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, number);
			ps.setString(3, email);
			ps.setString(4, psw);
			ps.setString(5, rpsw);
			
			int i = ps.executeUpdate();
			if(i>0) {
				pw.println("Sucessfully Register");
				
				
			
				 response.sendRedirect("index.jsp");
			
			}
					
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
