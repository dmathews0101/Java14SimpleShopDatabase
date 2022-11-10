package com.isimtl.javaii.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.isimtl.javaii.model.Book;
import com.isimtl.javaii.model.ShopFactory;

public class BookDAO extends ShopDAO{
	
	public List<Book> getAllBooks() throws Exception
	{
		
		//way to get all books from db and create instance
		
		List<Book> books = new ArrayList<>();
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM books";
		
		ResultSet rs = stmt.executeQuery(query);
		
		Book book;
		
		while(rs.next())
		{//row by row
			book = new Book();
			ShopFactory.buildBook(rs,book);
			books.add(book);
		}
		
		
		
		for(Book currentBook:books)
		{
			ShopFactory.buildCategory(connection,currentBook.getCategory());

		}
		
		connection.close();

		return books;
		
	}
	
	public static void main(String[] args) throws Exception
	{
		BookDAO bookDAO = new BookDAO();

		List<Book> books = bookDAO.getAllBooks();
		
		for(Book book:books)
		{
			System.out.println(book);
		}
		
		//or
		//books.parallelStream().forEach(book -> System.out.println(book));
		
	}

}
