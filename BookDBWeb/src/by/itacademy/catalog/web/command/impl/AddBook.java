package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.web.command.BasicAction;

public class AddBook implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.print("<html><head></head><body> <form action='MainServlet' method='get'>"
				+ "<input type='text' name='title' placeholder='title'/>"
				+ "<input type='text' name='pages' placeholder='pages'/>"
				+ "<input type='hidden' name='command' value='add_book_action'/>"
				+ "<input type='submit' value='add'/>" + "</form> </body></html>");

		return null;
	}

}
