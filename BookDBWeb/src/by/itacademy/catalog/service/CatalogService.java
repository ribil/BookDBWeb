package by.itacademy.catalog.service;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.vo.Catalog;

public interface CatalogService {

	Catalog getCatalog();

	void addBook(Book book);
	
	void removeBook(int bookId);
}
