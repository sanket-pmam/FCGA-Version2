package FSmokeSuit.FSmokeSuit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends AutomationUtilities {

		public ObjectRepository objectrepository = null;

		public HomePage(WebDriver driver) {
			objectrepository = ObjectRepository.getInstance(driver);
		}
		
		public void SelectAgent(WebDriver driver,LoadManager objLoadManager) throws InterruptedException, IOException 
		{
			//waitforpageload(driver, 2);
			//Thread.sleep(2000);
			buttonClick(driver,objectrepository.getSelectAgent(),5,"Agency Contact");
			
			EsendKeysToTextField(driver,objectrepository.getSearchAgent(), objLoadManager.getAgentName(),"AgentName");
			
		    buttonClick(driver,objectrepository.getbtnContinue(), 10, "Continue Button");
		    AutomationUtilities.LogSummary(LogPath,"Agent Name is selected Sucessfully");
		}
		
		public void CreateNewQuote (WebDriver driver,LoadManager objGlLoadManager,Underwriting objGLunderwriting,String Product) throws InterruptedException, IOException 
		{
			
			if (Product =="GL") {
				if (objGlLoadManager.getChkConvertPolicy().equalsIgnoreCase("Yes")){
				
				buttonClick(driver,objectrepository.getdrpTypeofRecord(),10,"Type of Record");
				buttonClick(driver,objectrepository.getdrpTypeofRecordP(),10,"Type of Record");
				
				objGLunderwriting.AgentSearch (driver,objGlLoadManager,"Both");
				}
			}else {
				
			buttonClick(driver,objectrepository.getbtnNewQuote(),10,"New Quote Button is clicked");
			String sRandomNumber = AutomationUtilities.getRandomString (9);
			
			//buttonClick(driver,objectrepository.getbtnHContinue(), 10, "Continue Button is clicked");
			//Thread.sleep(2000);
			//buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (objGlLoadManager.getProduct().equalsIgnoreCase("GL")){
				
				buttonClick(driver, objectrepository.getbtnrdbGeneralLiability(),10,"GL Radio Button is clicked");
				//System.out.println("Selecting GL Radio Button");
			}
			else {
				//System.out.println("Selecting WC Radio Button");
				//Thread.sleep(5000);
				//buttonClickWithoutWait(driver,objectrepository.getbtnrdbWorkersComp(),"WC Radio Button is clicked");
				buttonClick(driver,objectrepository.getbtnrdbWorkersComp(),10,"WC Radio Button is clicked");
				
				
				sendKeysToTextField(driver,objectrepository.getinpFEIN(),sRandomNumber,"FEIN Number is Entered");
				
			}
			
		    buttonClick(driver,objectrepository.getbtnHContinue(), 10, "Continue Button is clicked");
		    AutomationUtilities.LogSummary(LogPath,"New Quote is going to be created");
			}
		}
		
		public void checkFramePopup(WebDriver driver) throws InterruptedException, IOException{
			
			waitforpageload(driver, 5);
			for(int i=1; i<=1; i++) {
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			//int numberOfTags = iframes.size();
			//System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);

			for (WebElement iframe : iframes) {
				//System.out.println("Inner HTML  >> " + iframe.getAttribute("outerHTML"));
				if (iframe.getAttribute("outerHTML").contains("iframe srcdoc=")) {
					driver.switchTo().frame(iframe);
					buttonClick(driver, objectrepository.getiframeCancelButton(),1,
							"Clicked on Let's Go button on Pop-up");
				}
				driver.switchTo().defaultContent();
			}
			}
			
			
		}
}

