package com.capgemini.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forword")
public class ForwordServ extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.print("<h1>sejgfy</h1>");
		RequestDispatcher dis = req.getRequestDispatcher("/date");
		dis.forward(req,resp);
				
	}

}
