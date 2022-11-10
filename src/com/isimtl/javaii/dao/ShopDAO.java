package com.isimtl.javaii.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ShopDAO {
	
	protected Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver"); //load driver
		
		
		//estable connec
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","admin");
	}

}
