package TechExercise;

public class UserInfo
{
	private String username;
	private String password;
	public boolean valid;
	
	public String getUser()
	{
		return username;
	}
	public void setUser(String user)
	{
		username = user;
	}
	
	public String getPass()
	{
		return password;
	}
	public void setPass(String pass)
	{
		password = pass;
	}
	
	public boolean isValid()
	{
		return valid;
	}
	public void setValid(boolean val)
	{
		valid = val;
	}
}
