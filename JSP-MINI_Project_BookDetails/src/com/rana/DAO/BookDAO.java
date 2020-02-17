package com.rana.DAO;
import com.rana.BO.BookBO;
import java.util.List;

public interface BookDAO {
	
	List<BookBO> findBooks(String category) throws Exception;
}