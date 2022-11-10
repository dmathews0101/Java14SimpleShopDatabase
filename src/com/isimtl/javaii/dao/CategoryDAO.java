package com.isimtl.javaii.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.isimtl.javaii.model.Book;
import com.isimtl.javaii.model.Category;
import com.isimtl.javaii.model.ShopFactory;

public class CategoryDAO extends ShopDAO {
	
	public List<Category> getAllCategories() throws Exception
	{
		List<Book> categories = new ArrayList<>();
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM categories";
		
		ResultSet rs = stmt.executeQuery(query);
		
		
		Category category;
		
		while(rs.next())
		{
			category = new Category();
			ShopFactory.buildCategory(rs,category);
			categories.add(category);
		}
		
		//before ret close con
		connection.close();
		
		return categories;
		
		
	}

}
