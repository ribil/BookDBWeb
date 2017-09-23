<%@page import="by.itacademy.catalog.service.impl.SimpleCatalogImpl"%>
<%@page import="by.itacademy.catalog.service.CatalogService"%>
<%@page import="by.itacademy.catalog.domain.entity.Book"%>
<%@page import="by.itacademy.catalog.domain.vo.Catalog"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
		<body>
			
			<% 
			CatalogService service2 = new SimpleCatalogImpl(); 
			PrintWriter out2 = response.getWriter();
			Catalog catalog = service2.getCatalog();
			
			
			for (Book book : catalog.getBooks()) {
				out2.println("<div style='border-width: 1px; border-style: double; "
						+ "border-radius: 5px; text-align: center; font-size: 15px; "
						+ "color: #310485; background-color: #D3A5FF; padding-top: 7px; "
						+ "padding-bottom: 7px; font-weight: bold; margin:3px 0 3px 0;'>");
				out.println(book);
				out.println("</div>");
			}
			%>
		</body>
</html>