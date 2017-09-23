package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.BasicAction;

public class AddBookAction implements BasicAction {
	
	private CatalogService service = new SimpleCatalogImpl(); 

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Book book = new Book();
		String title = request.getParameter("title");
		int pages = Integer.parseInt(request.getParameter("pages"));
		book.setTitle(title);
		book.setPages(pages);
		service.addBook(book);
		
		PrintWriter out = response.getWriter();

		out.print("<html><head></head><body><p><a href='MainServlet?command=view_book_list'>"
				+ "View all!</a></p></body></html>");
		
	
		
		return null;
	}

}
