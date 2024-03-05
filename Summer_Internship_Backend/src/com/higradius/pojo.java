package com.higradius;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pojo {
	private
	Integer pk_id;
	Integer acct_doc_header_id;
	Integer company_id;
	Integer document_number;
	Integer document_number_norm;
	String business_code;
	String create_year;
	Integer document_line_number;
	String doctype;
	Integer customer_number;
	Integer customer_number_norm;
	Integer fk_customer_map_id;
	String customer_name;
	String division;
	Timestamp document_create_date;
	Timestamp document_create_date_norm;
	Timestamp posting_date;
	Timestamp posting_date_norm;
	String posting_id;
	Timestamp due_date;
	Timestamp due_date_norm;
	Timestamp order_date;
	Timestamp order_date_norm;
	Integer invoice_id;
	Integer invoice_id_norm;
	Timestamp baseline_create_date;
	Timestamp invoice_date_norm;
	Float total_open_amount;
	Float total_open_amount_norm;
	Integer cust_payment_terms;
	String business_area;
	Timestamp ship_date;
	String ship_to;
	Timestamp clearing_date;
	Timestamp clearing_date_norm;
	String reason_code;
	Integer isOpen;
	Timestamp discount_due_date_norm;
	String debit_credit_indicator;
	String payment_method;
	Timestamp document_creation_date;
	Float invoice_amount_doc_currency;
	Integer document_id;
	Float actual_open_amount;
	Float paid_amount;
	Integer dayspast_due;
	Integer invoice_age;
	Float disputed_amount;
	public Integer getAcct_doc_header_id() {
		return acct_doc_header_id;
	}
	
	public Integer getDocument_number_norm() {
		return document_number_norm;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setDocument_number_norm(Integer document_number_norm) {
		this.document_number_norm = document_number_norm;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getCreate_year() {
		return create_year;
	}
	public void setCreate_year(String create_year) {
		this.create_year = create_year;
	}
	public Integer getDocument_line_number() {
		return document_line_number;
	}
	public void setDocument_line_number(Integer document_line_number) {
		this.document_line_number = document_line_number;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public Integer getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(Integer customer_number) {
		this.customer_number = customer_number;
	}
	public Integer getCustomer_number_norm() {
		return customer_number_norm;
	}
	public void setCustomer_number_norm(Integer customer_number_norm) {
		this.customer_number_norm = customer_number_norm;
	}
	public Integer getFk_customer_map_id() {
		return fk_customer_map_id;
	}
	public void setFk_customer_map_id(Integer fk_customer_map_id) {
		this.fk_customer_map_id = fk_customer_map_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public Timestamp getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(Timestamp document_create_date) {
		this.document_create_date = document_create_date;
	}
	public Timestamp getDocument_create_date_norm() {
		return document_create_date_norm;
	}
	public void setDocument_create_date_norm(Timestamp document_create_date_norm) {
		this.document_create_date_norm = document_create_date_norm;
	}
	public Timestamp getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Timestamp posting_date) {
		this.posting_date = posting_date;
	}
	public Timestamp getPosting_date_norm() {
		return posting_date_norm;
	}
	public void setPosting_date_norm(Timestamp posting_date_norm) {
		this.posting_date_norm = posting_date_norm;
	}
	public String getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		this.posting_id = posting_id;
	}
	public Timestamp getDue_date() {
		return due_date;
	}
	public void setDue_date(Timestamp due_date) {
		this.due_date = due_date;
	}
	public Timestamp getDue_date_norm() {
		return due_date_norm;
	}
	public void setDue_date_norm(Timestamp due_date_norm) {
		this.due_date_norm = due_date_norm;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public Timestamp getOrder_date_norm() {
		return order_date_norm;
	}
	public void setOrder_date_norm(Timestamp order_date_norm) {
		this.order_date_norm = order_date_norm;
	}
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Integer getInvoice_id_norm() {
		return invoice_id_norm;
	}
	public void setInvoice_id_norm(Integer invoice_id_norm) {
		this.invoice_id_norm = invoice_id_norm;
	}
	public Timestamp getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(Timestamp baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
	public Timestamp getInvoice_date_norm() {
		return invoice_date_norm;
	}
	public void setInvoice_date_norm(Timestamp invoice_date_norm) {
		this.invoice_date_norm = invoice_date_norm;
	}
	public Float getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Float total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public Float getTotal_open_amount_norm() {
		return total_open_amount_norm;
	}
	public void setTotal_open_amount_norm(Float total_open_amount_norm) {
		this.total_open_amount_norm = total_open_amount_norm;
	}
	public Integer getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(Integer cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public String getBusiness_area() {
		return business_area;
	}
	public void setBusiness_area(String business_area) {
		this.business_area = business_area;
	}
	public Timestamp getShip_date() {
		return ship_date;
	}
	public void setShip_date(Timestamp ship_date) {
		this.ship_date = ship_date;
	}
	public String getShip_to() {
		return ship_to;
	}
	public void setShip_to(String ship_to) {
		this.ship_to = ship_to;
	}
	public Timestamp getClearing_date() {
		return clearing_date;
	}
	public void setClearing_date(Timestamp clearing_date) {
		this.clearing_date = clearing_date;
	}
	public Timestamp getClearing_date_norm() {
		return clearing_date_norm;
	}
	public void setClearing_date_norm(Timestamp clearing_date_norm) {
		this.clearing_date_norm = clearing_date_norm;
	}
	public String getReason_code() {
		return reason_code;
	}
	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	public Timestamp getDiscount_due_date_norm() {
		return discount_due_date_norm;
	}
	public void setDiscount_due_date_norm(Timestamp discount_due_date_norm) {
		this.discount_due_date_norm = discount_due_date_norm;
	}
	public String getDebit_credit_indicator() {
		return debit_credit_indicator;
	}
	public void setDebit_credit_indicator(String debit_credit_indicator) {
		this.debit_credit_indicator = debit_credit_indicator;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Timestamp getDocument_creation_date() {
		return document_creation_date;
	}
	public void setDocument_creation_date(Timestamp document_creation_date) {
		this.document_creation_date = document_creation_date;
	}
	public Float getInvoice_amount_doc_currency() {
		return invoice_amount_doc_currency;
	}
	public void setInvoice_amount_doc_currency(Float invoice_amount_doc_currency) {
		this.invoice_amount_doc_currency = invoice_amount_doc_currency;
	}
	public Integer getDocument_id() {
		return document_id;
	}
	public void setDocument_id(Integer document_id) {
		this.document_id = document_id;
	}
	public Float getActual_open_amount() {
		return actual_open_amount;
	}
	public void setActual_open_amount(Float actual_open_amount) {
		this.actual_open_amount = actual_open_amount;
	}
	public Float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(Float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Integer getDayspast_due() {
		return dayspast_due;
	}
	public void setDayspast_due(Integer dayspast_due) {
		this.dayspast_due = dayspast_due;
	}
	public Integer getInvoice_age() {
		return invoice_age;
	}
	public void setInvoice_age(Integer invoice_age) {
		this.invoice_age = invoice_age;
	}
	public Float getDisputed_amount() {
		return disputed_amount;
	}
	public void setDisputed_amount(Float disputed_amount) {
		this.disputed_amount = disputed_amount;
	}
	public void setAcct_doc_header_id(Integer acct_doc_header_id) {
		this.acct_doc_header_id = acct_doc_header_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
	}

	public
	ArrayList<pojo> getter(String indexes, String values)
	{
		ArrayList<pojo> members = new ArrayList<pojo>();
		String[] ind = indexes.split(",");
		String[] vals = indexes.split(",");
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT * FROM customer_invoice WHERE ";
        String header = "acct_doc_header_id,company_id,document_number,document_number_norm,business_code,create_year,document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id,customer_name,division,document_create_date,document_create_date_norm,posting_date,posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id,invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm,cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code,isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency,document_id,actual_open_amount,paid_amount,dayspast_due,invoice_age,disputed_amount";
		int arr[] = {0, 1, 2, 3, 6, 8, 9, 10, 22, 23, 28, 35, 41, 44, 45};
        int dates[] = {13, 14, 15, 16, 18, 19, 20, 21, 24, 25, 30, 32, 33, 36, 39};
        int floats[] = {26,27,40,42,43,46};
        int[] intArray = new int[ind.length];
        int i=0;
        for(String s:ind)
        {
        	int indes = Arrays.asList(header).indexOf(s);
        	int temp;
        	if(Arrays.asList(arr).contains(indes))
        	{
        		temp = 1;
        	}
        	else if(Arrays.asList(dates).contains(indes))
        	{
        		temp = 2;
        	}
        	else if(Arrays.asList(floats).contains(indes))
        	{
        		temp = 3;
        	}
        	else
        	{
        		temp=4;
        	}
        	intArray[i] = temp;
        	i+=1;
        }
        if(ind.length==1)
        {
			query = query + ind[0] + "= ?";
        }
        else
        {
			query = query + ind[0] + "= ?";
			for(int j = 1; j<ind.length; j++)
			{
				query = query + " AND " + ind[j]+" = ? ";
			}
        }
        try {
		statement = conn.dbCon.prepareStatement(query);
		for(int j=1; j<ind.length+1; j++)
		{
			if(intArray[i-1]==1)
			{
				int temp = Integer.parseInt(vals[i-1]);
				statement.setInt(i, temp);
			}
			else if(intArray[i-1]==2)
			{
				int temp = Integer.parseInt(vals[i-1]);
				statement.setInt(i, temp);
			}
			else if(intArray[i-1]==3)
			{
				float temp = Float.parseFloat(vals[i-1]);
				statement.setFloat(i, temp);
			}
			else
			{
				statement.setString(i, vals[i-1]);
			}
		}
		try
		{
			rs = statement.executeQuery();
			while(rs.next())
			{
			pojo temp = new pojo(); 
			temp.acct_doc_header_id = new Integer(rs.getInt("acct_doc_header_id"));
			temp.company_id = new Integer(rs.getInt("company_id"));
			temp.document_number = new Integer(rs.getInt("document_number"));
			temp.document_number_norm = new Integer(rs.getInt("document_number_norm"));
			temp.business_code = rs.getString("business_code");
			temp.create_year = rs.getString("create_year");
			temp.document_line_number = new Integer(rs.getInt("document_line_number"));
			temp.doctype = rs.getString("doctype");
			members.add(temp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	conn.closeResource(statement);
        	conn.closeResource(rs);
        }
		return members;
	}

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
}
