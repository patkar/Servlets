package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class passengerServlet
 */
@WebServlet("/passengerServlet")
public class passengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public passengerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String destination=request.getParameter("destination");
		DBHelper db=new DBHelper();
		ArrayList passengersList=db.getAllPassengers(destination);
		String str1="<table border=1>"+
					"<tr>"+
					"<th>First Name</th>"+
					"<th>Last Name</th>"+
					"<th>Source</th>"+
					"<th>Destination</th>"+
					"<th>Gender</th>"+
					"</tr>";
		
		pw.println(str1);
		
		for(int i=0;i<passengersList.size();i++)
		{
			PassengerVO pvo=(PassengerVO)passengersList.get(i);
			String str2="<tr>"+
						"<td>"+pvo.getFirstname()+"</td>"+
						"<td>"+pvo.getLastname()+"</td>"+
						"<td>"+pvo.getSource()+"</td>"+
						"<td>"+pvo.getDestination()+"</td>"+
						"<td>"+pvo.getGender()+"</td>"+
						"</tr>";
			pw.print(str2);
		}
		pw.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
