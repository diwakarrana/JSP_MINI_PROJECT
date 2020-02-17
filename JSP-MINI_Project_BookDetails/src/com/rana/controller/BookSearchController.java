package com.rana.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rana.dto.BookDTO;
import com.rana.service.BookSearchService;



@WebServlet("/controller")
public class BookSearchController extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			List<BookDTO> listDTO = null;
			RequestDispatcher rd = null;
	//read form data
			String category = req.getParameter("category");
			String source = req.getParameter("source");
			
	// use service class
			BookSearchService service = new BookSearchService();
			try {
				 listDTO = service.search(category);
			}
			catch(Exception e){
				//handle error here............................
			rd = req.getRequestDispatcher("/error.jsp");
			}
			
			//keep listDTO in request attribute
			req.setAttribute("bookList", listDTO);
			
			//forward the request to the Destination page(view page) based on
			//the button that is clicked
			
			if(source.equals("html"))
			{
				rd = req.getRequestDispatcher("/html_screen.jsp");
			}
			else {
				rd = req.getRequestDispatcher("/excel_screen.jsp");
			}
			
			rd.forward(req, res);
	}//doGet.......
		
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
