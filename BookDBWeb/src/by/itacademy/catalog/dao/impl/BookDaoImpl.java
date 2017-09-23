package by.itacademy.catalog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import by.itacademy.catalog.dao.BookDao;
import by.itacademy.catalog.domain.entity.Book;

public class BookDaoImpl implements BookDao {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String DB_URL = "jdbc:mysql://localhost/bookcatalog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PAS = "root";

	private static final String SQL_INSERT_BOOK = "INSERT INTO book (title, pages) VALUES (?, ?)";
	
	private static final String SQL_SELECT_BOOKS = "select * from book";
	
	private static final String SQL_DELETE_BOOKS = "DELETE FROM book WHERE id=?";

	
	@Override
	public List<Book> readBooks() {
		
		List<Book> books = null;
		Connection con = null;
		
		try {
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PAS);
			
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			books = new ArrayList<Book>();

			while (rs.next()) {
				Book book = new Book();

				int id = rs.getInt(1);
				String title = rs.getString(2);
				int pages = rs.getInt(3);

				book.setId(id);
				book.setTitle(title);
				book.setPages(pages);

				books.add(book);
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
		return books;
	}
	
	@Override
	public void addBook(Book book) {

		Connection cn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(DB_DRIVER);

			cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PAS);

			try {
				ps = cn.prepareStatement(SQL_INSERT_BOOK);

				ps.setString(1, book.getTitle());
				ps.setInt(2, book.getPages());
				ps.executeUpdate();
			} catch (SQLException e) {

				try {
					throw new Exception("Problem with adding new book", e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} finally {
				closeStatement(ps);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			try {
				throw new Exception("Problem with DB Connection", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	protected void closeStatement(Statement st){
		
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
	}

	@Override
	public void deleteBook(int bookId) {
		Connection con = null;
		
		try{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PAS);
			PreparedStatement ps = con.prepareStatement(SQL_DELETE_BOOKS);
			ps.setInt(1, bookId);
			ps.executeUpdate();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	

}
