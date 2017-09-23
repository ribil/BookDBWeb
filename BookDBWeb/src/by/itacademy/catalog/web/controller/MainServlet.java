package by.itacademy.catalog.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.vo.Catalog;
import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.ActionType;
import by.itacademy.catalog.web.command.BasicAction;
import by.itacademy.catalog.web.command.CommandChooser;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int requestCount = 0;
	private CatalogService service;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("service method: " + requestCount);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy method: " + requestCount);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init method: " + requestCount);
		service = new SimpleCatalogImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		requestCount++;
		
		response.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");
		System.out.println(command);
		
		ActionType action = ActionType.valueOf(command.toUpperCase());

		BasicAction basicAction = CommandChooser.performAction(action);
		basicAction.executeAction(request, response);
		
		/*PrintWriter out = response.getWriter();

		if (command != null) {
			switch (command) {

			case "view_books":
				Catalog catalog = service.getCatalog();

				for (Book book : catalog.getBooks()) {
					out.println("<div style='border-width: 1px; border-style: double; "
							+ "border-radius: 5px; text-align: center; font-size: 25px; "
							+ "color: #310485; background-color: #D3A5FF; padding-top: 10px; "
							+ "padding-bottom: 10px; font-weight: bold; margin:5px 0 5px 0;'>");
					out.println(book);
					out.println("</div>");
				}
				break;
			case "get_book":
				
				String str1 = request.getParameter("value1");
				int id = Integer.parseInt(str1);
				
				catalog = service.getCatalog();

				for (Book book : catalog.getBooks()) {
					if(book.getId()==id){
						out.println(book);
					//	out.println(id);
					}

				}
 
				break;
			case "add_book":
				catalog = service.getCatalog();
				Book book = new Book(11, "Book222", 333);
				service.addBook(book);
				
				out.println(book);
				break;
				*/
				
		/*	case "delete_book":
				showDeleteForm(out);
				break;*/
				
			//case "total_delete":

				//out.println("book deleted");
				//String bookId = request.getParameter("book_id");
				//service.removeBook(Integer.parseInt(bookId));
				/*catalog = service.getCatalog();

				for (Book book1 : catalog.getBooks()) {
					out.println("<html><head></head><body>"
							
							+ "<div style='border-width: 1px; border-style: double; "
							+ "border-radius: 5px; text-align: center; font-size: 25px; "
							+ "color: #310485; background-color: #D3A5FF; padding-top: 10px; "
							+ "padding-bottom: 10px; font-weight: bold; margin:5px 0 5px 0;'>"
							+ "</body></html>"
							+"<p>book deleted<p>");
					out.println(book1);
					out.println("</div>");*/
			
				//break;
			}
		
	}
	/*
	private void showDeleteForm(PrintWriter out){
		out.print("<html><head></head><body> <form action='MainServlet' method='get'>"
				+ "<input type='text' name='book_id'/>"
				+ "<input type='hidden' name='command' value='total_delete'/>"
				+ "<input type='submit' value='delete'/>"
				+ "</form> </body></html>");
	}*/
	
	/*
	 * 
	 * 
	 * String str1 = request.getParameter("value1"); String str2 =
	 * request.getParameter("value2");
	 * 
	 * int a = Integer.parseInt(str1); int b = Integer.parseInt(str2);
	 * 
	 * int c = a + b;
	 * 
	 * 
	 * 
	 * System.out.println("We get new request: " + requestCount+ " " + str1
	 * + " " + str2);
	 * 
	 * System.out.println("Result for str1("+str1+")" + " + " +
	 * "str2("+str2+"): " + c);
	 * //response.getWriter().append("Served at: ").append(request.
	 * getContextPath()); response.getWriter().
	 * println("<div style='border-width: 1px; border-style: double; " +
	 * "border-radius: 5px; text-align: center; font-size: 25px; " +
	 * "color: #310485; background-color: #D3A5FF; padding-top: 30px; padding-bottom: 30px;"
	 * + "font-weight: bold;'>" + " Result for str1("+str1+")" + " + " +
	 * "str2("+str2+"): " + c + "</div>");
	 */

