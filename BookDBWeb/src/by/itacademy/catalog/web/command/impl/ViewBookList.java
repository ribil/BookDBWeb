package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.vo.Catalog;
import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.BasicAction;

public class ViewBookList implements BasicAction {


	private CatalogService service = new SimpleCatalogImpl(); 
	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Catalog catalog = service.getCatalog();
		
		
		for (Book book : catalog.getBooks()) {
			out.println("<div style='border-width: 1px; border-style: double; "
					+ "border-radius: 5px; text-align: center; font-size: 15px; "
					+ "color: #310485; background-color: #D3A5FF; padding-top: 7px; "
					+ "padding-bottom: 7px; font-weight: bold; margin:3px 0 3px 0;'>");
			out.println(book);
			out.println("</div>");
		}
		return null;
	}

}
