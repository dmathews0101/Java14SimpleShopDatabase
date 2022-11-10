package com.isimtl.javaii.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopFactory {
	
	//`book_id`, `title`, `author`, `price`, `category_id`

	
	public static void buildBook(ResultSet rs, Book book) throws SQLException
	{
		Category category;
		
		if(rs.next())
		{
			book.setId(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));

			category = new Category();
			
			category.setId(rs.getInt("category_id"));
			book.setCategory(category);

		}
		
	}

	public static void buildCategory(Connection connection, Category category) throws SQLException
	{
		/*
		
		if(connection.next())
		{
			category.setId(connection.getInt("category_id"));
			category.setName(connection.getString("category_name"));

			category = new Category();
			
			category.setId(connection.getInt("category_id"));
			book.setCategory(category);

		}
		
		if(null==category.getName())
		{
			Statement stmt = connection.createStatement();
			
			String query = "SELECT category_name FROM categories WHERE category_id= "+category.getId();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				category.setName(rs.getString("category_name"));				
			}
		}
		*/
		if (null == category.getName())
		{
			Statement stmt = connection.createStatement();
			
			String query = "SELECT category_name FROM categories WHERE category_id = "+ category.getId();
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
			{
				category.setName(rs.getString("category_name"));
			}
		}
		
	}

}
