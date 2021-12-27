package interfaces;

import java.lang.*;
import entity.*;

public interface ISecurityRepo
{
	Security getSecurity(String userId,String answer);
	void insertSecurity(Security u);
	void updateAnswer(Security u);
	void deleteSecurity(String userId);
}