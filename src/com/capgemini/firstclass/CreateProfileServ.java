package com.capgemini.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProfileServ extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int eid =  Integer.parseInt(req.getParameter("e_id"));
		String ename = req.getParameter("e_name");
		int sal = Integer.parseInt(req.getParameter("e_sal"));
		String mgr = req.getParameter("e_mgr");
		String dept = req.getParameter("e_dept");
		String desg = req.getParameter("e_desg");
		String pass = req.getParameter("e_password");
		String loc = req.getParameter("e_loc");
		
		try
		{
			java.sql.Driver driver = (java.sql.Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/Avengers?user=root&password=1234";
			con = DriverManager.getConnection(url);
			
			String query = "insert into employee_table values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,eid);
			pstmt.setString(2,ename);
			pstmt.setInt(3,sal);
			pstmt.setString(4,mgr);
			pstmt.setString(5,dept);
			pstmt.setString(6, desg);
			pstmt.setString(7,loc);
			pstmt.setString(8,pass);
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				out.println("Data Inserted");
				System.out.println("data inserted");
				
			}
			else
			{
				out.println("Failed");
				System.out.println("failed");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		
	}

}
