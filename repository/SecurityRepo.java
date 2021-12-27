package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class SecurityRepo implements ISecurityRepo
{
	DatabaseConnection dbc;
	
	public SecurityRepo()
	{
		dbc = new DatabaseConnection();
	}
	public Security getSecurity(String userId,String answer)
	{
		Security security = null;
		String query = "SELECT userId, answer FROM security WHERE userId='"+userId+"' AND answer='"+answer+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				security = new Security();
				security.setUserId(dbc.result.getString("userId"));
				security.setAnswer(dbc.result.getString("answer"));
				
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return security;
	}
	public void insertSecurity(Security u)
	{
		String query = "INSERT INTO security VALUES ('"+u.getUserId()+"','"+u.getAnswer()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateAnswer(Security u)
	{
		String query = "UPDATE security SET answer = '"+u.getAnswer()+"' WHERE userId='"+u.getUserId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
		
	}
	
	public void deleteSecurity(String userId)
	{
		String query = "DELETE from security  WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}