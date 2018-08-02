package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo
 */
@WebServlet("/CookiesDemo")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie allCookie[]=request.getCookies();
		PrintWriter pw=response.getWriter();
		if(allCookie==null)
		{
			Cookie c=new Cookie("location","bangalore");
			c.setMaxAge(24*60*60);
			response.addCookie(c);
			pw.println("<body bgcolor=\"yellow\">");
			pw.println("cookie stored for 1 day");
			pw.println("Welcome to my store for the first time");
			pw.println("for sure u will like my online site");
			pw.println("for 1st time users we have strong offers</body>");
		}
		else
		{
			for(int i=0;i<allCookie.length;i++)
			{
				Cookie cc=allCookie[i];
				System.out.println(cc.getName()+" and "+cc.getValue());
				String name=cc.getName();
				String val=cc.getValue();
				if(name.equals("location")&& val.equals("bangalore"))
				{
					pw.println("<body bgcolor=\"pink\">");
					pw.println("Welcome back to my store");
					pw.println("Since u liked my store");
					pw.println("for regular customers like u, we give first order for free</body>");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
