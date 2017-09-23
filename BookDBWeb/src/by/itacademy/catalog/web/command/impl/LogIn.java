package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.dao.impl.UserDaoImpl;
import by.itacademy.catalog.domain.entity.User;
import by.itacademy.catalog.web.command.BasicAction;

public class LogIn implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserDaoImpl userDao = new UserDaoImpl();

		PrintWriter out = response.getWriter();
		String str1 = request.getParameter("value1");
		String str2 = request.getParameter("value2");
		RequestDispatcher view = null;

		List<User> users = userDao.readUser();

		Boolean logInGood = false;
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUser().equals(str1) && users.get(i).getPassword().equals(str2)) {
				out.println("Rise and shine, " + users.get(i).getUser());
				logInGood = true;
			} 
		
		}
		
		if (logInGood == false){
			view = request.getRequestDispatcher("/error.jsp");
		}
		
		//if (str1.equals("user") && str2.equals("user")) {
			// view = request.getRequestDispatcher("/user.jsp");

		//	out.println("Database request");
/*
			List<User> users = userDao.readUser();

			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals("bob")) {
					out.println(users.get(i).getUser());
				}
			}
*/
			// out.println(userDao.readUser());

		//} else if (str1.equals("admin") && str2.equals("admin")) {
		//	view = request.getRequestDispatcher("/admin.jsp");
		/*} else {
			view = request.getRequestDispatcher("/error.jsp");
		}
*/
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return null;
	
	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {

	// }

}
