package com.car.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionClass {
	private static Connection con;
	private static ConnectionClass ins=new ConnectionClass();
	private ConnectionClass()
	{
		try{
			FileReader fr = new FileReader("D:/sopra_java/workspace/ServletsCarPoolJDBC/CarPoolServlets/src/db.properties");
			Properties p=new Properties();
			p.load(fr);
			Class.forName(p.getProperty("url"));
			con=(Connection)DriverManager.getConnection(p.getProperty("con"), p.getProperty("uname"),p.getProperty("pwd"));
			}
			catch(IOException e0)
			{
				e0.printStackTrace();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			catch(ClassNotFoundException e2)
			{
				e2.printStackTrace();
			}
	}
	
	public static Connection connReturn()
	{
		
		return con;

	}
}
