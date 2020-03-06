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
	
	public void UWChangeStatus (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
		Thread.sleep(5000);
		
		if(objUWGLLoadManager.getUWRateType().equalsIgnoreCase("IRPM")) {
			
			sendKeysToTextField(driver,objectrepository.gettxtUWIRPM(),objUWGLLoadManager.getUWModifiedRates(),"IRPM");
			
		}else if(objUWGLLoadManager.getUWRateType().equalsIgnoreCase("CTR")){
			
			buttonClick(driver,objectrepository.getchkConsentToRate(),10,"CTR");
			sendKeysToTextField(driver,objectrepository.gettxtUWIRPMCTR(),objUWGLLoadManager.getUWModifiedRates(),"CTR");
		} else {
			
			sendKeysToTextField(driver,objectrepository.gettxtUWIRPM1(),objUWGLLoadManager.getUWModifiedRates(),"Debit/Credit");
			
		}
		
		buttonClick(driver,objectrepository.getUWCurrentStatus(),10,"UW Current Status");
		buttonClick(driver,objectrepository.getUWAcceptedStatus(),10,"UW Accepted Status");
		buttonClick(driver,objectrepository.getUWbtnReRate(),10,"UW Re Rate button");
		Thread.sleep(5000);
		AutomationUtilities.LogSummary(LogPath, "Alert Message in PopUp : "+ objectrepository.getUWAlertMsgBox().getText());
		Thread.sleep(2000);
		if(objectrepository.getUWAlertMsgBox().getText().equalsIgnoreCase("IRPM updated successfully.")) {
			buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
			Thread.sleep(1000);
			buttonClick(driver,objectrepository.getUWbtnExit(),10,"Exit is Clicked");
		}else {
			System.out.println("Message is incorrect");
		}
		
		
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
	
	public void UWGLEditQuote (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
		Thread.sleep(5000);
		
		buttonClick(driver,objectrepository.getUWGLEditQuote(),10,"Underwriting Edit Quote");
		Thread.sleep(5000);
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
		Thread.sleep(2000);
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
		Thread.sleep(8000);
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWClassPayroll().getText());
		System.out.println(objectrepository.getUWClassPayroll().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
		Thread.sleep(2000);
		
		if (objUWGLLoadManager.getAI().equalsIgnoreCase("Yes")
				|| objUWGLLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
			
			AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWAdditionalInsured().getText());
			System.out.println(objectrepository.getUWAdditionalInsured().getText());
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
			Thread.sleep(1000);
			
		} else {
			
			System.out.println("Additional Insured and Wavier is selected as No.");
			AutomationUtilities.LogSummary(LogPath, "Additional Insured and Wavier is selected as No.");
		}
		
		
		if (objUWGLLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
			
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
		Thread.sleep(1000);
		
		}
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getUWBtnSave(),20,"Click on Save and Continue");
		Thread.sleep(1000);
	
		AutomationUtilities.LogSummary(LogPath, "Referral Reason is : " +objectrepository.getUWReferralReason().getText());
		System.out.println(objectrepository.getUWReferralReason().getText());
		
	}
	
}
