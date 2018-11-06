package com.capgemini.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServ extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out  = resp.getWriter();
		resp.setContentType("text/html");
		System.out.println("this is server side");
		out.print("this is dynamic page");
		
		
		
		
		
		
		
		
	}
}
