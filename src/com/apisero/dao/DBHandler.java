package com.apisero.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler{
	
	public static  Connection establishConnection() throws ClassNotFoundException, SQLException, IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("db.properties") ;
		prop.load(fis);
		Class.forName(prop.getProperty("DRIVER_CLASS"));
		Connection con=DriverManager.getConnection(prop.getProperty("DB_URL")
				,prop.getProperty("DB_USERNAME")
				,prop.getProperty("DB_PASSWORD"));
		return con;
	}
}
