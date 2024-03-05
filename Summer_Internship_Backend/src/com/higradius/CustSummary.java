package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CustSummary
 */
@WebServlet("/CustSummary")
public class CustSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] paramValue = request.getParameterValues("customer_name");
		int[] num = GetDataArray.custSummary(paramValue[0]);
		 Gson gson = new Gson();
		 Map<String, Integer> number = new HashMap<>();
		 number.put("TotalOpenAR", num[0]);
		 number.put("TotalOpenAmt", num[1]);
		 String data = gson.toJson(number);
		 PrintWriter out = response.getWriter();
		 response.setHeader("Hello", "http://localhost:8080/1705242/CustSummary");
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(data);
		 out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
