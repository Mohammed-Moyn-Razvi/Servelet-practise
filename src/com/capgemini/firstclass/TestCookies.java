package com.capgemini.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie")
public class TestCookies extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
	
    	Cookie ref1 = new Cookie("us", "root");
    	ref1.setMaxAge(60*60*7);//persistent
		resp.addCookie(ref1);
		
		Cookie ref2 = new Cookie("use", "root");
		ref2.setMaxAge(60*60);
		resp.addCookie(ref2);
		
		Cookie ref3 = new Cookie("user", "root");
		ref3.setMaxAge(60*60);
		resp.addCookie(ref3);
		
		out.println("Persistent Cookie Created");
		
		
			}
	
}
