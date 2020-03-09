package FSmokeSuit.FSmokeSuit;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AutomationUtilities 
{
	public ObjectRepository objectrepository = null;

	public LoginPage(WebDriver driver)
	{		
      objectrepository = ObjectRepository.getInstance(driver);
	}

public void Agentlogin(WebDriver driver) throws InterruptedException, IOException 
{
	
	driver.get(AutomationUtilities.getDataFromPropertiesFile("AGENTURL"));
	
	waitforpageload(driver, 5);
	
	AutomationUtilities.LogSummary(LogPath, "URL: " + AutomationUtilities.getDataFromPropertiesFile("AGENTURL"));
	String sUserName = AutomationUtilities.getDataFromPropertiesFile("USER_NAME");
	String sPassword = AutomationUtilities.getDataFromPropertiesFile("PASSWORD");
	AutomationUtilities.LogSummary(LogPath, "Agent UserName: " + sUserName +" / Agent Password:" + sPassword);
	
	if (objectrepository.getInpUserNameLogin().isDisplayed()) {	
sendKeysToTextField(driver, objectrepository.getInpUserNameLogin(), sUserName,
		"Username");
sendKeysToTextField(driver, objectrepository.getInpPasswordLogin(), sPassword,
		"Password");
buttonClick(driver,objectrepository.getBtnLogin(), 10, "Login");

AutomationUtilities.LogSummary(LogPath,"Agent Log In is done Sucessfully");

}
}

public void AgentSignOut(WebDriver driver) throws InterruptedException, IOException {
	
	waitforpageload(driver, 5);
	buttonClick(driver,objectrepository.getBtnLogOff(), 10, "Sign Out");
	Thread.sleep(4000);
	AutomationUtilities.LogSummary(LogPath,"Agent SignOut is done Sucessfully");	
	
}

public void UWlogin(WebDriver driver) throws InterruptedException, IOException 
{
	
	driver.get(AutomationUtilities.getDataFromPropertiesFile("UWURL"));
	AutomationUtilities.LogSummary(LogPath, "URL: " + AutomationUtilities.getDataFromPropertiesFile("UWURL"));
	String sUserName = AutomationUtilities.getDataFromPropertiesFile("UWUSER_NAME");
	String sPassword = AutomationUtilities.getDataFromPropertiesFile("UWPASSWORD");
	AutomationUtilities.LogSummary(LogPath, "UW UserName: " + sUserName +" / UW Password:" + sPassword);
	
	if (objectrepository.getInpUserNameLogin().isDisplayed()) {	
sendKeysToTextField(driver, objectrepository.getInpUserNameLogin(), sUserName,
		"Username");
sendKeysToTextField(driver, objectrepository.getInpPasswordLogin(), sPassword,
		"Password");
buttonClick(driver,objectrepository.getBtnLogin(), 10, "Login");

AutomationUtilities.LogSummary(LogPath,"UW Log In is done Sucessfully");

}
}

public void UWSignOut(WebDriver driver) throws InterruptedException, IOException {
	
	Thread.sleep(3000);
	buttonClick(driver,objectrepository.getUWUserName(), 10, "UW UserName");
	buttonClick(driver,objectrepository.getBtnLogOff(), 10, "Sign Out");
	Thread.sleep(4000);
	AutomationUtilities.LogSummary(LogPath,"UW SignOut is done Sucessfully");	
	
}
}
