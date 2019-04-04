package com.dao;

import java.sql.*;

import com.bean.CustomerBean;

public class CustomerDao {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	
	
	/** public static Connection getConnection(){  
        Connection con=null;  
        try{  
           // Class.forName("oracle.jdbc.driver.OracleDriver");  
           // con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","pawar");  
        	Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/santhu","root","");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  **/
	
	public static boolean validate(String uname,String psw){  
		 
		
	try {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
	Class.forName("com.mysql.jdbc.Driver");
	System.out .println("hii ");
	//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","pawar");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/santhu","root","");
	PreparedStatement ps=con.prepareStatement("select * from customer where uname=? and psw=?");  
			ps.setString(1,uname);  
			ps.setString(2,psw);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//rs.getString(1);
				//rs.getString(2);
				//status = rs.next();
				return true;
			
				
				
			}
			
			ps.close();
		con.close();
	}catch(Exception e) {System.out.println(e);}
	
	
	return false;

}
	
	
/**	public boolean insert(CustomerBean cb) {
		
		PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?)");
		ps.setString(1, cname);
		ps.setString(2, cmobile);
		ps.setString(3, mobiletype);
		ps.setString(4, amount);
		
		
		int i = ps.executeUpdate();
		if(i>0) {
		
		
		}
		
		return false;
	} **/
	
	  
	
}
