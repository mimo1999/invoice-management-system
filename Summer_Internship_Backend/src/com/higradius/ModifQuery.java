package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifQuery
 */
@WebServlet("/ModifQuery")
public class ModifQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Enumeration<String> parameterNames = request.getParameterNames();
            String paramName = parameterNames.nextElement();
            String[] pkValue = request.getParameterValues("pk_id");
            String[] amtValue = request.getParameterValues("actual_open_amount");
            String[] typeValue = request.getParameterValues("doctype");
            String rep = GetDataArray.modif(pkValue[0], amtValue[0], typeValue[0]);
   		 	PrintWriter out = response.getWriter();
   		 	out.print(rep);
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
