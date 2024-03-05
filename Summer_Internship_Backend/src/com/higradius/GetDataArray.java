package com.higradius;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetDataArray {
	public static ArrayList<pojo> getAll()
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT * FROM customer_invoice";
		String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
		String headers[] = header.split(",");
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setPk_id(rs.getInt("pk_id"));
    				temp.setAcct_doc_header_id(rs.getInt(headers[0]));
    				temp.setCompany_id(rs.getInt(headers[1]));
    				temp.setDocument_number(rs.getInt(headers[2]));
    				temp.setDocument_number_norm(rs.getInt(headers[3]));
    				temp.setBusiness_code(rs.getString(headers[4]));
    				temp.setCreate_year(rs.getString(headers[5]));
    				temp.setDocument_line_number(rs.getInt(headers[6]));
    				temp.setDoctype(rs.getString(headers[7]));
    				temp.setCustomer_number(rs.getInt(headers[8]));
    				temp.setCustomer_number_norm(rs.getInt(headers[9]));
    				temp.setFk_customer_map_id(rs.getInt(headers[10]));
    				temp.setCustomer_name(rs.getString(headers[11]));
    				temp.setDivision(rs.getString(headers[12]));
    				temp.setDocument_create_date(rs.getTimestamp(headers[13]));
    				temp.setDocument_create_date_norm(rs.getTimestamp(headers[14]));
    				temp.setPosting_date(rs.getTimestamp(headers[15]));
    				temp.setPosting_date_norm(rs.getTimestamp(headers[16]));
    				temp.setPosting_id(rs.getString(headers[17]));
    				temp.setDue_date(rs.getTimestamp(headers[18]));
    				temp.setDue_date_norm(rs.getTimestamp(headers[19]));
    				temp.setOrder_date(rs.getTimestamp(headers[20]));
    				temp.setOrder_date_norm(rs.getTimestamp(headers[21]));
    				temp.setInvoice_id(rs.getInt(headers[22]));
    				temp.setInvoice_id_norm(rs.getInt(headers[23]));
    				temp.setBaseline_create_date(rs.getTimestamp(headers[24]));
    				temp.setInvoice_date_norm(rs.getTimestamp(headers[25]));
    				temp.setTotal_open_amount(rs.getFloat(headers[26]));
    				temp.setTotal_open_amount_norm(rs.getFloat(headers[27]));
    				temp.setCust_payment_terms(rs.getInt(headers[28]));
    				temp.setBusiness_area(rs.getString(headers[29]));
    				temp.setShip_date(rs.getTimestamp(headers[30]));
    				temp.setShip_to(rs.getString(headers[31]));
    				temp.setClearing_date(rs.getTimestamp(headers[32]));
    				temp.setClearing_date_norm(rs.getTimestamp(headers[33]));
    				temp.setReason_code(rs.getString(headers[34]));
    				temp.setIsOpen(rs.getInt(headers[35]));
    				temp.setDiscount_due_date_norm(rs.getTimestamp(headers[36]));
    				temp.setDebit_credit_indicator(rs.getString(headers[37]));
    				temp.setPayment_method(rs.getString(headers[38]));
    				temp.setDocument_creation_date(rs.getTimestamp(headers[39]));
    				temp.setInvoice_amount_doc_currency(rs.getFloat(headers[40]));
    				temp.setDocument_id(rs.getInt(headers[41]));
    				temp.setActual_open_amount(rs.getFloat(headers[42]));
    				temp.setPaid_amount(rs.getFloat(headers[43]));
    				temp.setDayspast_due(rs.getInt(headers[44]));
    				temp.setInvoice_age(rs.getInt(headers[45]));
    				temp.setDisputed_amount(rs.getFloat(headers[46]));	
    			}
    			catch(Exception e)
    			{}
    		mem.add(temp);
			}
	}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return mem;
}
	
	public static ArrayList<pojo> getDefaults()
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT customer_name, customer_number, SUM(actual_open_amount) as open_amt FROM customer_invoice WHERE isOpen=1 GROUP BY customer_name";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		System.out.println(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setCustomer_name(rs.getString("customer_name"));
    				temp.setCustomer_number(rs.getInt("customer_number"));
    				temp.setActual_open_amount(rs.getFloat("open_amt"));
    			}
    			catch(Exception e)
    			{
    				
    			}
    		mem.add(temp);
			}
		}
		catch(Exception e) {}
		return mem;
	}
	public static ArrayList<pojo> getQueryResp(String par, String val)
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT customer_name, customer_number, SUM(actual_open_amount) as open_amt FROM customer_invoice WHERE isOpen=1 GROUP BY customer_name HAVING ";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
		if(par.equals("customer_name"))
		{
		query = query + par + " LIKE '" + val + "%'";
		}
		else
		{
			query = query + par + " = " + val;
		}
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		System.out.println(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setCustomer_name(rs.getString("customer_name"));
    				temp.setCustomer_number(rs.getInt("customer_number"));
    				temp.setActual_open_amount(rs.getFloat("open_amt"));
    			}
    			catch(Exception e)
    			{
    				
    			}
    		mem.add(temp);
			}
		}
		catch(Exception e) {}
		return mem;
	}
	
	public static ArrayList<pojo> CustomerSpecific(String val)
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
		String[] headers = header.split(",");
		ResultSet rs = null;
		String query = "SELECT * FROM customer_invoice WHERE customer_name = ";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root"; 
		query = query + "'" + val + "'";
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		System.out.println(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setPk_id(rs.getInt("pk_id"));
    				temp.setAcct_doc_header_id(rs.getInt(headers[0]));
    				temp.setCompany_id(rs.getInt(headers[1]));
    				temp.setDocument_number(rs.getInt(headers[2]));
    				temp.setDocument_number_norm(rs.getInt(headers[3]));
    				temp.setBusiness_code(rs.getString(headers[4]));
    				temp.setCreate_year(rs.getString(headers[5]));
    				temp.setDocument_line_number(rs.getInt(headers[6]));
    				temp.setDoctype(rs.getString(headers[7]));
    				temp.setCustomer_number(rs.getInt(headers[8]));
    				temp.setCustomer_number_norm(rs.getInt(headers[9]));
    				temp.setFk_customer_map_id(rs.getInt(headers[10]));
    				temp.setCustomer_name(rs.getString(headers[11]));
    				temp.setDivision(rs.getString(headers[12]));
    				temp.setDocument_create_date(rs.getTimestamp(headers[13]));
    				temp.setDocument_create_date_norm(rs.getTimestamp(headers[14]));
    				temp.setPosting_date(rs.getTimestamp(headers[15]));
    				temp.setPosting_date_norm(rs.getTimestamp(headers[16]));
    				temp.setPosting_id(rs.getString(headers[17]));
    				temp.setDue_date(rs.getTimestamp(headers[18]));
    				temp.setDue_date_norm(rs.getTimestamp(headers[19]));
    				temp.setOrder_date(rs.getTimestamp(headers[20]));
    				temp.setOrder_date_norm(rs.getTimestamp(headers[21]));
    				temp.setInvoice_id(rs.getInt(headers[22]));
    				temp.setInvoice_id_norm(rs.getInt(headers[23]));
    				temp.setBaseline_create_date(rs.getTimestamp(headers[24]));
    				temp.setInvoice_date_norm(rs.getTimestamp(headers[25]));
    				temp.setTotal_open_amount(rs.getFloat(headers[26]));
    				temp.setTotal_open_amount_norm(rs.getFloat(headers[27]));
    				temp.setCust_payment_terms(rs.getInt(headers[28]));
    				temp.setBusiness_area(rs.getString(headers[29]));
    				temp.setShip_date(rs.getTimestamp(headers[30]));
    				temp.setShip_to(rs.getString(headers[31]));
    				temp.setClearing_date(rs.getTimestamp(headers[32]));
    				temp.setClearing_date_norm(rs.getTimestamp(headers[33]));
    				temp.setReason_code(rs.getString(headers[34]));
    				temp.setIsOpen(rs.getInt(headers[35]));
    				temp.setDiscount_due_date_norm(rs.getTimestamp(headers[36]));
    				temp.setDebit_credit_indicator(rs.getString(headers[37]));
    				temp.setPayment_method(rs.getString(headers[38]));
    				temp.setDocument_creation_date(rs.getTimestamp(headers[39]));
    				temp.setInvoice_amount_doc_currency(rs.getFloat(headers[40]));
    				temp.setDocument_id(rs.getInt(headers[41]));
    				temp.setActual_open_amount(rs.getFloat(headers[42]));
    				temp.setPaid_amount(rs.getFloat(headers[43]));
    				temp.setDayspast_due(rs.getInt(headers[44]));
    				temp.setInvoice_age(rs.getInt(headers[45]));
    				temp.setDisputed_amount(rs.getFloat(headers[46]));	
    			}
    			catch(Exception e){}
    		mem.add(temp);
			}
		}
		catch(Exception e) {}
		return mem;
	}
	public static ArrayList<pojo> BusinessSpecific(String val)
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
		String[] headers = header.split(",");
		ResultSet rs = null;
		String query = "SELECT * FROM customer_invoice WHERE business_code = ";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root"; 
		query = query + "'" + val + "'";
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		System.out.println(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setPk_id(rs.getInt("pk_id"));
    				temp.setAcct_doc_header_id(rs.getInt(headers[0]));
    				temp.setCompany_id(rs.getInt(headers[1]));
    				temp.setDocument_number(rs.getInt(headers[2]));
    				temp.setDocument_number_norm(rs.getInt(headers[3]));
    				temp.setBusiness_code(rs.getString(headers[4]));
    				temp.setCreate_year(rs.getString(headers[5]));
    				temp.setDocument_line_number(rs.getInt(headers[6]));
    				temp.setDoctype(rs.getString(headers[7]));
    				temp.setCustomer_number(rs.getInt(headers[8]));
    				temp.setCustomer_number_norm(rs.getInt(headers[9]));
    				temp.setFk_customer_map_id(rs.getInt(headers[10]));
    				temp.setCustomer_name(rs.getString(headers[11]));
    				temp.setDivision(rs.getString(headers[12]));
    				temp.setDocument_create_date(rs.getTimestamp(headers[13]));
    				temp.setDocument_create_date_norm(rs.getTimestamp(headers[14]));
    				temp.setPosting_date(rs.getTimestamp(headers[15]));
    				temp.setPosting_date_norm(rs.getTimestamp(headers[16]));
    				temp.setPosting_id(rs.getString(headers[17]));
    				temp.setDue_date(rs.getTimestamp(headers[18]));
    				temp.setDue_date_norm(rs.getTimestamp(headers[19]));
    				temp.setOrder_date(rs.getTimestamp(headers[20]));
    				temp.setOrder_date_norm(rs.getTimestamp(headers[21]));
    				temp.setInvoice_id(rs.getInt(headers[22]));
    				temp.setInvoice_id_norm(rs.getInt(headers[23]));
    				temp.setBaseline_create_date(rs.getTimestamp(headers[24]));
    				temp.setInvoice_date_norm(rs.getTimestamp(headers[25]));
    				temp.setTotal_open_amount(rs.getFloat(headers[26]));
    				temp.setTotal_open_amount_norm(rs.getFloat(headers[27]));
    				temp.setCust_payment_terms(rs.getInt(headers[28]));
    				temp.setBusiness_area(rs.getString(headers[29]));
    				temp.setShip_date(rs.getTimestamp(headers[30]));
    				temp.setShip_to(rs.getString(headers[31]));
    				temp.setClearing_date(rs.getTimestamp(headers[32]));
    				temp.setClearing_date_norm(rs.getTimestamp(headers[33]));
    				temp.setReason_code(rs.getString(headers[34]));
    				temp.setIsOpen(rs.getInt(headers[35]));
    				temp.setDiscount_due_date_norm(rs.getTimestamp(headers[36]));
    				temp.setDebit_credit_indicator(rs.getString(headers[37]));
    				temp.setPayment_method(rs.getString(headers[38]));
    				temp.setDocument_creation_date(rs.getTimestamp(headers[39]));
    				temp.setInvoice_amount_doc_currency(rs.getFloat(headers[40]));
    				temp.setDocument_id(rs.getInt(headers[41]));
    				temp.setActual_open_amount(rs.getFloat(headers[42]));
    				temp.setPaid_amount(rs.getFloat(headers[43]));
    				temp.setDayspast_due(rs.getInt(headers[44]));
    				temp.setInvoice_age(rs.getInt(headers[45]));
    				temp.setDisputed_amount(rs.getFloat(headers[46]));	
    			}
    			catch(Exception e){}
    		mem.add(temp);
			}
		}
		catch(Exception e) {}
		return mem;
	}
	public static int[] custSummary(String name)
	{
		int i = 0, j=0;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(isOpen) as counter, SUM(actual_open_amount) as debt FROM customer_invoice WHERE isOpen=1 AND customer_name = '";
		query = query + name + "'";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		rs = statement.executeQuery();
    		rs.next();
    		i = rs.getInt("counter");
    		j = rs.getInt("debt");
    		System.out.println(i);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        int[] arr = new int[] {i, j};
		return arr;
	
}
	public static String modif(String pkparam, String amtparam, String typeparam)
	{
		PreparedStatement statement = null;
		String query = "UPDATE customer_invoice SET";
		if(amtparam.length() != 4 ) {
			query += " actual_open_amount = " + amtparam + ",";
		}
		if(typeparam.length() > 1) {
			query += " doctype = '" + typeparam + "' ";
		}
		query += " WHERE pk_id = " + pkparam;
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
		System.out.print(query);
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            conn.dbCon = DriverManager.getConnection(url, userName, password);
        	System.out.println("Connected");
        	statement = conn.dbCon.prepareStatement(query);
        	statement.executeUpdate();
        	return "Done";
            }
        catch(Exception e)
        {
        	e.printStackTrace();
        	return "Failed";
        }

	
}
	public static ArrayList<pojo> advSearch(String par, String val)
	{
		ArrayList<pojo> mem = new ArrayList<pojo>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT customer_name, customer_number, SUM(actual_open_amount) as open_amt FROM customer_invoice WHERE isOpen=1 GROUP BY customer_name HAVING ";
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userName = "root";
		String password = "root";
		query = query + "open_amt " + par + " " + val;
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn.dbCon = DriverManager.getConnection(url, userName, password);
    		System.out.println("Connected");
    		statement = conn.dbCon.prepareStatement(query);
    		System.out.println(query);
    		rs = statement.executeQuery();
    		while(rs.next())
			{
    			pojo temp = new pojo();
    			try 
    			{	
    				temp.setCustomer_name(rs.getString("customer_name"));
    				temp.setCustomer_number(rs.getInt("customer_number"));
    				temp.setActual_open_amount(rs.getFloat("open_amt"));
    			}
    			catch(Exception e)
    			{
    				
    			}
    		mem.add(temp);
			}
		}
		catch(Exception e) {}
		return mem;
	}
}
