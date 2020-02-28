package FSmokeSuit.FSmokeSuit;

import java.io.IOException;
import org.openqa.selenium.WebDriver;


public class HomePage extends AutomationUtilities {

		public ObjectRepository objectrepository = null;

		public HomePage(WebDriver driver) {
			objectrepository = ObjectRepository.getInstance(driver);
		}
		
		public void SelectAgent(WebDriver driver,String sAgentName) throws InterruptedException, IOException 
		{
			
			Thread.sleep(2000);
			buttonClick(driver,objectrepository.getSelectAgent(),50,"Agency Contact");
			
			EsendKeysToTextField(driver,objectrepository.getSearchAgent(), sAgentName,"AgentName");
			
		    buttonClick(driver,objectrepository.getbtnContinue(), 30, "Continue Button");
		    AutomationUtilities.LogSummary(LogPath,"Agent Name is selected Sucessfully");
		}
		
		public void CreateNewQuote (WebDriver driver,String sProductName) throws InterruptedException, IOException 
		{
			
			Thread.sleep(20000);
		
			buttonClick(driver,objectrepository.getbtnNewQuote(),10,"New Quote Button is clicked");
			String sRandomNumber = AutomationUtilities.getRandomString (9);
			
			buttonClick(driver,objectrepository.getbtnHContinue(), 10, "Continue Button is clicked");
			Thread.sleep(2000);
			buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
			
			Thread.sleep(2000);
			if (sProductName.equalsIgnoreCase("GL")){
				
				buttonClick(driver, objectrepository.getbtnrdbGeneralLiability(),30,"GL Radio Button is clicked");
				System.out.println("Selecting GL Radio Button");
			}
			else {
				System.out.println("Selecting WC Radio Button");
				//Thread.sleep(5000);
				//buttonClickWithoutWait(driver,objectrepository.getbtnrdbWorkersComp(),"WC Radio Button is clicked");
				buttonClick(driver,objectrepository.getbtnrdbWorkersComp(),30,"WC Radio Button is clicked");
				
				
				sendKeysToTextField(driver,objectrepository.getinpFEIN(),sRandomNumber,"FEIN Number is Entered");
				
			}
		    buttonClick(driver,objectrepository.getbtnHContinue(), 10, "Continue Button is clicked");
		    AutomationUtilities.LogSummary(LogPath,"New Quote is going to be created");
		}
}

