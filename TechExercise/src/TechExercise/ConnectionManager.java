package TechExercise;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager
{
	static Connection connection;
	static String url;
	
	public static Connection getConnection()
	{
		try
		{
			String url="jdbc:http://ec2-3-12-129-49.us-east-2.compute.amazonaws.com/" + "DataSource";
			try
			{
				connection = DriverManager.getConnection(url,"newmysqlremoteuser@localjost","password");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return connection;
	}
}
