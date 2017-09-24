package by.itacademy.catalog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.entity.User;

public class UserDaoImpl {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost/useradmin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PAS = "root";
	
	private static final String SQL_SELECT_USERS = "select * from users";
	
	public List<User> readUser() {
		List<User> users = null;
	Connection con = null;
	
	try {
		
		Class.forName(DB_DRIVER);
		
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PAS);
		
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(SQL_SELECT_USERS);

		users = new ArrayList<User>();
		
		while (rs.next()) {
			
			User user = new User();

			int id = rs.getInt(1);
			String userName = rs.getString(2);
			String password = rs.getString(3);
			
			user.setUser(userName);
			user.setPassword(password);
			
			users.add(user);

		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return users;
}
}
	
