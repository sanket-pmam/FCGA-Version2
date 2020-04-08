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
		
		 waitforpageload(driver, 15);
		 sendKeysToTextField(driver,objectrepository.gettxtUWSearch(),AutomationUtilities.sBusinessName,"Business Name is searched");
		 buttonClick(driver,objectrepository.getbtnSearch(),10,"Search Record");
		 waitforpageload(driver, 15);
		 driver.findElement(By.xpath("//a[contains(text(),'"+AutomationUtilities.sBusinessName+"')]")).click();

	}
	
	public void UWChangeStatus (WebDriver driver) throws InterruptedException, IOException {
		
		waitforpageload(driver, 15);
		buttonClick(driver,objectrepository.getUWCurrentStatus(),10,"UW Current Status");
		buttonClick(driver,objectrepository.getUWAcceptedStatus(),10,"UW Accepted Status");
		buttonClick(driver,objectrepository.getUWbtnReRate(),40,"UW Re Rate button");
		AutomationUtilities.LogSummary(LogPath, "Alert Message in PopUp : "+ objectrepository.getUWAlertMsgBox().getText());
		Thread.sleep(2000);
		buttonClick(driver,objectrepository.gettxtWCClosebtn(), 20, "Close button is saved sucessfully.");
		UWNotes(driver, "NotesMessage");
		UWMessages(driver, "NotesMessage");
		buttonClick(driver,objectrepository.getUWbtnExit(),10,"Exit is Clicked");
	}
	
	public void AgentSearch (WebDriver driver) throws InterruptedException, IOException {
		
		waitforpageload(driver, 10);
		sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.sBusinessName,"Frist Name");
		buttonClick(driver,objectrepository.getbtnSearch(),40,"Search Record");
		AutomationUtilities.ActionMessages(driver,objectrepository,"hi wORLD");
		buttonClick(driver,objectrepository.getbtnAction(),10,"Action");
		buttonClick(driver,objectrepository.getbtnEditQuote(),10,"Edit Quote");
		waitforpageload(driver, 30);

}
	
public void UWGLEditQuote (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
	    waitforpageload(driver, 30);
		
		buttonClick(driver,objectrepository.getUWGLEditQuote(),20,"Underwriting Edit Quote");

		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
	
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),15,"Click on Save and Continue");

		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWClassPayroll().getText());
		System.out.println(objectrepository.getUWClassPayroll().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
	
		
		if (objUWGLLoadManager.getAI().equalsIgnoreCase("Yes")
				|| objUWGLLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
			
			AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWAdditionalInsured().getText());
			System.out.println(objectrepository.getUWAdditionalInsured().getText());
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),15,"Click on Save and Continue");

			
		} else {
			
			System.out.println("Additional Insured and Wavier is selected as No.");
			AutomationUtilities.LogSummary(LogPath, "Additional Insured and Wavier is selected as No.");
		}
		
		
		if (objUWGLLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
			
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
		Thread.sleep(1000);
		
		}
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getUWBtnSave(),10,"Click on Save and Continue");
		Thread.sleep(1000);
	
		AutomationUtilities.LogSummary(LogPath, "Referral Reason is : " +objectrepository.getUWReferralReason().getText());
		System.out.println(objectrepository.getUWReferralReason().getText());
		
        if(objUWGLLoadManager.getUWRateType().equalsIgnoreCase("IRPM")) {
			
			sendKeysToTextField(driver,objectrepository.gettxtUWIRPM(),objUWGLLoadManager.getUWModifiedRates(),"IRPM");
			
		}else if(objUWGLLoadManager.getUWRateType().equalsIgnoreCase("CTR")){
			
			buttonClick(driver,objectrepository.getchkConsentToRate(),10,"CTR");
			sendKeysToTextField(driver,objectrepository.gettxtUWIRPMCTR(),objUWGLLoadManager.getUWModifiedRates(),"CTR");
		} else {
			
			AutomationUtilities.LogSummary(LogPath, "IRPM Value is not getting Changed");
			System.out.println("IRPM Value is not getting Changed");
		}
		
	}
   
public void UWNotes(WebDriver driver, String NotesMessage) throws InterruptedException, IOException 
{
	buttonClick(driver,objectrepository.getUWNotes(),10,"Notes");
	sendKeysToTextField(driver,objectrepository.gettxtNotes(),NotesMessage,"Notes messages");
	buttonClick(driver,objectrepository.getUWPostNote(),10,"Notes");
}

public void UWMessages(WebDriver driver, String NotesMessage) throws InterruptedException, IOException 
{
	buttonClick(driver,objectrepository.getUWMessages(),10,"Messages");
	sendKeysToTextField(driver,objectrepository.gettxtMessages(),NotesMessage,"test messages");
	buttonClick(driver,objectrepository.getUWAskProducer(),10,"Messages");
}


	
}
