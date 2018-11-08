package com.capgemini.firstclass;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServ extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("emp_id"));
		String password = req.getParameter("password");
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//step :1
		java.sql.Driver driver = (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		
		FileReader fr=new FileReader("D:/DBCredential.properties");
		Properties properties=new Properties();
		properties.load(fr);
		
		
		
		//Estb the db conn via driver
		String dburl = "jdbc:mysql://localhost:3306/Avengers?";
		con = DriverManager.getConnection(dburl,properties);
		
		
		String query = "select * from employee_table where e_id=? and e_password=?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,id);
		pstmt.setString(2,password);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
		if(rs.next())
		{
			int id1 = rs.getInt("e_id");
			String name = rs.getString("e_name");
			int sal = rs.getInt("e_sal");
			String mgr = rs.getString("e_mgr");
			String dept = rs.getString("e_dept");
			String desg  = rs.getString("e_designation");
		    String city = rs.getString("e_city");
	        	
		    
		    out.println("<table>"
		    		+ "<tr>"		    		
		    		+ "<th>EmpId :"
		    		+ "<td>"+id+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>Name :"
		    		+ "<td>"+name+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>salary :"
		    		+ "<td>"+sal+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>Desg :"
		    		+ "<td>"+desg+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>mgr :"
		    		+ "<td>"+mgr+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>city :"
		    		+ "<td>"+city+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "<tr>"
		    		+ "<th>Dept :"
		    		+ "<td>"+dept+"</td>"
		    		+ "</th>"
		    		+ "</tr>"
		    		+ "</table>");
		    
		   	
		}
		}else
		{
			out.println("Something went wrong");
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
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
