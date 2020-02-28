package FSmokeSuit.FSmokeSuit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Underwriting extends AutomationUtilities {
	
	public ObjectRepository objectrepository = null;

	public Underwriting(WebDriver driver)
	{		
      objectrepository = ObjectRepository.getInstance(driver);
	}
	
	public void UnderwritingSearch (WebDriver driver) throws InterruptedException, IOException {
		
		 Thread.sleep(15000);
		 sendKeysToTextField(driver,objectrepository.gettxtUWSearch(),AutomationUtilities.sBusinessName,"Business Name is searched");
		 buttonClick(driver,objectrepository.getbtnSearch(),10,"Search Record");
		 Thread.sleep(8000);
		 driver.findElement(By.xpath("//a[contains(text(),'"+AutomationUtilities.sBusinessName+"')]")).click();

	}
	
	public void UWChangeStatus (WebDriver driver) throws InterruptedException, IOException {
		
		Thread.sleep(5000);
		buttonClick(driver,objectrepository.getUWCurrentStatus(),10,"UW Current Status");
		buttonClick(driver,objectrepository.getUWAcceptedStatus(),10,"UW Accepted Status");
		buttonClick(driver,objectrepository.getUWbtnReRate(),10,"UW Re Rate button");
		Thread.sleep(5000);
		AutomationUtilities.LogSummary(LogPath, "Alert Message in PopUp : "+ objectrepository.getUWAlertMsgBox().getText());
		Thread.sleep(2000);
		buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
		Thread.sleep(1000);
		buttonClick(driver,objectrepository.getUWbtnExit(),10,"Exit is Clicked");
	}
	
	public void AgentSearch (WebDriver driver) throws InterruptedException, IOException {
		
		Thread.sleep(6000);
		sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.sBusinessName,"Frist Name");
		buttonClick(driver,objectrepository.getbtnSearch(),10,"Search Record");
		Thread.sleep(3000);
		buttonClick(driver,objectrepository.getbtnAction(),10,"Action");
		buttonClick(driver,objectrepository.getbtnEditQuote(),10,"Edit Quote");
		Thread.sleep(15000);

}
	
}
