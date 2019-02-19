package com.car.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	static Connection con;
	public Connection connReturn()
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@ITEM-70282.dhcp.noid.in.sopra:1521:SopraTest", "SCOTT", "tiger");
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
		return con;

	}
}
