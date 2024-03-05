package com.higradius;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.sql.*;
class conn
{
	static Connection dbCon = null;
	static void closeResource(ResultSet ob)
	{
		try
		{
			ob.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	static void closeResource(PreparedStatement ob)
	{
		try
		{
			ob.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
public class Sql_samp {
	public static void main(String[] args)
	{

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String userName = "root";
	String password = "root";
	
	try {
		conn.dbCon = DriverManager.getConnection(url, userName, password);
		System.out.println("Connected");
		read_csv();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	static void read_csv()
	{
		int batch=0;
		String lineText = null;
		PreparedStatement statement = null;
		pojo a = new pojo();
		
		int arr[] = {0, 1, 2, 3, 6, 8, 9, 10, 22, 23, 28, 35, 41, 44, 45};
        int dates[] = {13, 14, 15, 16, 18, 19, 20, 21, 24, 25, 30, 32, 33, 36, 39};
        int floats[] = {26,27,40,42,43,46};
        int strings[] = {4, 5, 7, 11, 12, 17, 29, 31, 34, 37, 38};
        String sql = "INSERT INTO customer_invoice";
        String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
        String sqllr = sql+"("+header+")"+" VALUES (?";
        for(int i=0; i<46; i++)
        {
        	sqllr = sqllr.concat(",?");
        }
        sqllr = sqllr.concat(")");
        List<String> dateFormats = Arrays.asList("yyyy-MM-dd", "dd/MM/yyyy");
		try { 
		BufferedReader lineReader = new BufferedReader(new FileReader("D:\\HighRadius\\Summer_Internship_Backend\\src\\com\\higradius\\Data Uploading.csv"));
		lineReader.readLine();
		
		System.out.println("CSV accessed");
		String empty_db = "DELETE FROM customer_invoice";
		Statement stmt = conn.dbCon.createStatement();
		stmt.execute(empty_db);
		String Reset_incrementer = "ALTER TABLE customer_invoice AUTO_INCREMENT = 1";
		stmt.execute(Reset_incrementer);
		
        try {
        	statement = conn.dbCon.prepareStatement(sqllr);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
        while ((lineText = lineReader.readLine()) != null) {
        	String[] data = lineText.split(",");
        	try{
                for(int i: arr)
                {
                		try {
                			int temp = Integer.parseInt(data[i]);
                			statement.setInt(i+1, temp);
                		}
                		catch(Exception e)
                		{
                			statement.setNull(i+1, Types.INTEGER);
                		}
                }
                for(int i: dates)
                	{
                	java.util.Date date = null;
                		for(String format: dateFormats)
                		{
                			try {
                    			date = new SimpleDateFormat(format).parse(data[i]);
                    			break;
                			}
                			catch(Exception e)
                			{}
                		}
                		try
                		{
                			String formattedDate = new SimpleDateFormat("ddMMyyyy").format(date);
                			Timestamp sqlTimestamp = new Timestamp(new SimpleDateFormat("ddMMyyyy").parse(formattedDate).getTime());
                			statement.setTimestamp(i+1, sqlTimestamp);
                		}
                		catch(Exception e)
                		{
                			statement.setNull(i+1, Types.DATE);
                		}
                	}
                for(int i: floats)
                	{
                		try
                		{
                			float temp = Float.parseFloat(data[i]);
                			statement.setFloat(i+1, temp);
                		}
                		catch(Exception e)
                		{
                			statement.setNull(i+1, Types.FLOAT);
                		}
                	}
                for(int i:strings)
                	{
                		if(data[i].length()>0)
                		{
                		statement.setString(i+1, data[i]);
                		}
                		else
                		{
                			statement.setString(i+1, null);
                		}
                	}
               statement.addBatch();
               if(++batch%50==0)
                {
                	statement.executeBatch();
                }
        	}
            catch(Exception e)
            {
                e.printStackTrace();
            }	
		}
        statement.executeBatch();
        System.out.println("Completed");
        lineReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
    		conn.closeResource(statement);
    	}
	}
}