<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.*, com.rana.dto.BookDTO"%>

    
    
    <% //read request attribute value 
    	List<BookDTO> listDTO = (List<BookDTO>)request.getAttribute("bookList");
  
    	//display database table having records....
    	if(listDTO.size() != 0)
    	{%>
    		<h1 style = 'text-align:center'> BOOKs Report for<%=request.getParameter("category") %></h1>
    		
    	<table border = "1">
  		<tr>
 		   <th>BookID</th>
 		   <th>BookName</th>
 		   <th>Author</th>
 		   <th>price</th>
 		 </tr>
    	<%
    	for(BookDTO dto :listDTO)
    	{%>
    <tr>	
    	<td><%=dto.getBookid()%></td>
    	<td><%=dto.getBookname() %></td>
    	<td><%=dto.getAuthor() %></td>
    	<td><%=dto.getPrice() %></td>
    </tr>
    	<%}%>
    	</table>
    	<% }
    	else{ %>
    	
    		<h1 style = "color:red; text-align: center">No Book Found</h1>
    		
    	<% }%>
    	
    	<script type="text/javascript">
    	function showPrint(){
    		frames.focus();
    		frames.print();
    	}
		</script>
    	
    	<br><br>
    	<a href = "search.html">home</a>
    	
    	<br><br>
    	<a href='javascript:showPrint()'>print</a>
    	
    	
 
    	
    	
    	

    
    
    
    
    