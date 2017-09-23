<%@page import="java.io.PrintWriter"%>
<%@page import="by.itacademy.catalog.web.command.impl.LogIn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorization</title>
</head>
<body>
<form method="get" action="/BookDBWeb/MainServlet">
 	
   <p><input type="hidden" name="command" value="log_in" ></p>
   <p><input type="text" name="value1" placeholder="Login"></p>
   <p><input type="password" name="value2" placeholder="Password"></p>
   <p><input type="submit" formmethod="get" value="Log in"></p>
    </form>
   
</body>
</html>