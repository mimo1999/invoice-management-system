package com.higradius;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.sql.*;

public class SQLReaderTry {
	public static void main(String[] args)
	{

	Connection dbCon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String userName = "root";
	String password = "root";
	
	try {
		dbCon = DriverManager.getConnection(url, userName, password);
		System.out.println("Connected");
		String sql = "INSERT INTO customer_invoice";
        
        BufferedReader lineReader = new BufferedReader(new FileReader("D:\\HighRadius\\Summer_Internship_Backend\\src\\com\\higradius\\Moscow_1705242.csv"));
        String lineText = null;

        int arr[] = {0, 1, 2, 3, 6, 8, 9, 10, 22, 23, 28, 35, 41, 44, 45};
        int dates[] = {13, 14, 15, 16, 18, 19, 20, 21, 24, 25, 30, 32, 33, 36, 39};
        int floats[] = {26,27,40,42,43,46};
        int strings[] = {4, 5, 7, 11, 12, 17, 29, 31, 34, 37, 38};
        lineReader.readLine();
        String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
        String sqll = sql+"("+header+")"+" VALUES (?";
        for(int i=0; i<46; i++)
        {
        	sqll = sqll.concat(",?");
        }
        sqll = sqll.concat(")");
        PreparedStatement statement = dbCon.prepareStatement(sqll);
        
        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
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
            		try
            		{
            			Timestamp sqlTimestamp = Timestamp.valueOf(data[i]);
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
            		statement.setString(i+1, data[i]);
            	}
            try {
            statement.execute();
            }
            catch(SQLException e)
            {
            	e.printStackTrace();
            }
        }
        lineReader.close();
        
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		closeResource(rs);
		closeResource(pstmt);
		
	}
	}
	static void closeResource(Object ob)
	{
		
	}
	static boolean valid_int(String s)
	{
		try 
		{
            Integer.parseInt(s); 
            return true;
        }  
        catch (NumberFormatException e)  
        { 
        	return false;
        } 
	}
	static boolean valid_float(String s)
	{
		try 
		{
			Float.parseFloat(s); 
            return true;
        }  
        catch (NumberFormatException e)  
        { 
        	return false;
        } 
	}
	static boolean valid_date(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
            return true;
        } catch (Exception pe) {
            return false;
        }
	}
}