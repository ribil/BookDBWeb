package by.itacademy.catalog.service.impl;

import by.itacademy.catalog.dao.BookDao;
import by.itacademy.catalog.dao.impl.BookDaoImpl;
import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.vo.Catalog;
import by.itacademy.catalog.service.CatalogService;

public class SimpleCatalogImpl implements CatalogService{
	
	private BookDao dao;
	{
		dao = new BookDaoImpl();
	}

	@Override
	public Catalog getCatalog() {
		Catalog catalog = new Catalog();
		
		catalog.setBooks(dao.readBooks());
		catalog.setTitle("New Catalog");
		return catalog;
	}

	@Override
	public void addBook(Book book) {
		dao.addBook(book);
		
	}

	@Override
	public void removeBook(int bookId) {
		dao.deleteBook(bookId);
		
	}

}
