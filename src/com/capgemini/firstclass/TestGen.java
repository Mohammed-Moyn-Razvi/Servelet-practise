package com.capgemini.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestGen extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1>"+new Date()+"</h1>");
		
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		out.println(config.getInitParameter("password"));
		out.print(context.getInitParameter("email"));
		
		
	}

}
