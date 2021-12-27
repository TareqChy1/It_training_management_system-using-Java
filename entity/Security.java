package entity;

import java.lang.*;

public class Security
{
	private String userId;
	private String answer;
	
	public Security(){}
	public Security(String userId, String answer)
	{
		this.userId = userId;
		this.answer = answer;

	}
	
	public void setUserId(String userId){this.userId = userId;}
	public void setAnswer(String answer){this.answer = answer;}
	
	public String getUserId(){return userId;}
	public String getAnswer(){return answer;}
}