package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.exceptions.MySQLDataException;


public class DbConnection {
	
	public Connection getConnection() throws Exception{
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/userlogindb";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "root", "root");
			return connection;
		}
		catch (MySQLDataException e){
			throw e;
		}
		catch (Exception e){
			throw e;
		}
	}
}
