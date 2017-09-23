package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.BasicAction;

public class DeleteBookAction implements BasicAction {

	private CatalogService service = new SimpleCatalogImpl(); 
	
	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.println("book deleted");
		String bookId = request.getParameter("book_id");
		service.removeBook(Integer.parseInt(bookId));
		
		return null;
	}

	
}
