package com.capgemini.firstclass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class DeleteServ extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String username = req.getParameter("emp_id");
		int id = Integer.parseInt(username);
		RequestDispatcher dis = req.getRequestDispatcher("/head.html");
		dis.include(req, resp);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//step :1
		java.sql.Driver driver = (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		
		
		//Estb the db conn via driver
		String dburl = "jdbc:mysql://localhost:3306/Avengers?user=root&password=1234";
		con = DriverManager.getConnection(dburl);
		
		
		String query = "delete from employee_table where e_id = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,id);
		int c = pstmt.executeUpdate();
		if(c>0)
		{
			out.print("deleted Successfully");
		}
		else
		{
			out.println("Something went Wrong");
		}
		
		}catch(Exception e)
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




















