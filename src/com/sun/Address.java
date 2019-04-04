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
 * Servlet implementation class Address
 */
@WebServlet("/address")
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address() {
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
		String address1 = request.getParameter("address-line1");
		String address2 = request.getParameter("address-line2");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String postal = request.getParameter("postal-code");
		String country = request.getParameter("country");
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/santhu","root","");
			PreparedStatement ps = con.prepareStatement("insert into address values(?,?,?,?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, address1);
			ps.setString(3, address2);
			ps.setString(4, city);
			ps.setString(5, region);
			ps.setString(6, postal);
			ps.setString(7, country);
			
			int i = ps.executeUpdate();
			if(i>0) {
				pw.println("Address saved");
				
				
			
				 response.sendRedirect("order.jsp");
			
			}

			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		doGet(request, response);
	}

}
