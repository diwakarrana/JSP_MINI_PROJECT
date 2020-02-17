package com.rana.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rana.BO.BookBO;

public class BookDAOimp implements BookDAO {
	
	private static final String GET_BOOKS_BY_QUERY = "SELECT BOOKID,BOOKNAME,PRICE,AUTHOR FROM BOOK WHERE CATEGORY = ?";
	
	/*private Connection getConnection() throws Exception {
		// this method is helper method in dao to return back one connection from pool
		InitialContext ic = new InitialContext();
		DataSource ds =  (DataSource)ic.lookup("java:/comp/env/DsJndi");
		Connection con = ds.getConnection();
		return con;
	}*/

	@Override
	public List<BookBO> findBooks(String category) throws Exception {
		// get connection from connection pool
		/* Connection con = getConnection(); */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123"); 
		
		//create PreparedStatement object 
		PreparedStatement ps = con.prepareStatement(GET_BOOKS_BY_QUERY);
		
		//set parameter values to query.....
		ps.setString(1,category);
		
		//execute the query
		ResultSet rs = ps.executeQuery();
			
		//copy ResultSet object to object of javabean BO
		List<BookBO> listBO = new ArrayList<BookBO>();
		
		while(rs.next())
		{
			BookBO bo = new BookBO();
			bo.setBookid(rs.getInt(1));
			bo.setBookname(rs.getString(2));
			bo.setPrice(rs.getFloat(3));
			bo.setAuthor(rs.getString(4));
			listBO.add(bo);
		}//end of while......
		 
		return listBO;
	}//method
}//class
