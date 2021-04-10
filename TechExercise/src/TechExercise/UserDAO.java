package TechExercise;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO
{
	static Connection connection = null;
	static ResultSet rs = null;
	
	public static UserInfo login(UserInfo info)
	{
		Statement st = null;
		
		String username = info.getUser();
		String password = info.getPass();
		
		String searchQ =
				"select * from users where username='"
				+username
				+ "' AND password='"
				+"";
		
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Query: " + searchQ);
		
		
		try
		{
			connection = ConnectionManager.getConnection();
			st = connection.createStatement();
			rs=st.executeQuery(searchQ);
			boolean m = rs.next();
			
			if(!m)
			{
				System.out.println("You are not a user, please register");
				info.setValid(false);
			}
			else if(m)
			{
				String uname = rs.getString("username");
				
				System.out.println("Welcome " + uname + "!");
				info.setUser(username);
				info.setValid(true);
			}
		}
		catch(Exception e)
		{
			System.out.println("FAIL");
		}
		
		return info;
	}
}
