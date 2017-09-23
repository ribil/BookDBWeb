package by.itacademy.catalog.dao;

import java.util.List;

import by.itacademy.catalog.domain.entity.Book;

public interface BookDao {

	List<Book> readBooks();

	void addBook(Book book);

	void deleteBook(int bookId);
	
}
