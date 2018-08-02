package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDemo
 */
@WebServlet("/EmployeeDemo")
public class EmployeeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		int sal = Integer.parseInt(request.getParameter("salary"));
		String grade = request.getParameter("grade");
		double bonus = 0;
		double tax = sal * 0.25;
		if (sal >= 100000 && grade.equals("A")) {
			bonus = (sal * 0.05);
		} else if (sal >= 50000 && sal < 100000 && grade.equals("B")) {
			bonus = (sal * 0.07);
		} else if (sal < 50000 && grade.equals("C")) {
			bonus = (sal * 0.2);
		}
		double net = sal + bonus - tax;
		pw.println("<table border=1>");
		pw.println("<tr><th>Employee Name:</th>" + "<td>" + name);
		pw.println("<tr><th>Basic Salary :Rs.</th>" + "<td>" + sal);
		pw.println("<tr><th>Bonus        :Rs.</th>" + "<td>" + bonus);
		pw.println("<tr><th>Tax          :Rs.</th>" + "<td>" + tax);
		pw.println("<tr><th>Net Salary   :Rs.</th>" + "<td>" + net);
		pw.println("<tr></table>");

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
