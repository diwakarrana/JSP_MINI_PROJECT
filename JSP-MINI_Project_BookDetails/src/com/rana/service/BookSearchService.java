package com.rana.service;

import java.util.ArrayList;
import java.util.List;

import com.rana.BO.BookBO;
import com.rana.DAO.BookDAO;
import com.rana.DAO.BookDAOimp;
import com.rana.dto.BookDTO;
public class BookSearchService {
	
	public List<BookDTO> search(String category) throws Exception{
		//creating object of dao class
		BookDAO dao = new BookDAOimp();
		//calling findBooks function on object of BookDAOimp that is dao
		List<BookBO> listBO = dao.findBooks(category);
		
		//convert listBO to listDTO
		List<BookDTO> listDTO = new ArrayList<BookDTO>();
		
		for(BookBO bo : listBO)
		{
			//copy each bo oject to dto object....
			BookDTO dto = new BookDTO();
			dto.setBookid(bo.getBookid());
			dto.setBookname(bo.getBookname());
			dto.setPrice(bo.getPrice());
			dto.setAuthor(bo.getAuthor());
			
			listDTO.add(dto);//adding dto object to listDTO
		}//for
			
		return listDTO;
}//method

}//end of class
