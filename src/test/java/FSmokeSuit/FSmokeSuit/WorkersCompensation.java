package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WorkersCompensation extends AutomationUtilities {

	public static WebDriver driver = null;
	public static ObjectRepository objectrepository = null;
	public static String sBusinessName;

	public WorkersCompensation(WebDriver driver) {

		objectrepository = ObjectRepository.getInstance(driver);
	}

	public void BusinessSummary(LoadManager objWCLoadManager, WebDriver driver)
			throws InterruptedException, IOException, AWTException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -15);

		buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name");
        
		Thread.sleep(3000);
		sendKeysToTextField(driver,objectrepository.gettxtWCClassCodes(), objWCLoadManager.getWCClassCode(), "Class Code");
		buttonClick(driver,objectrepository.getbtnWCContinue(), 10, "Click on Continue");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		AutomationUtilities.sBusinessName = "FCGA AUTM-" + AutomationUtilities.getRandomString(9);
		sendKeysToTextField(driver,objectrepository.gettxtWCBussInsuredName(), AutomationUtilities.sBusinessName, "Business Name");
		System.out.println("Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);
		AutomationUtilities.LogSummary(LogPath, "Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);

		buttonClick(driver,objectrepository.getdpdWCLegalEntity(), 10, "Click on Legal Entity");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCLegalEntity(), "Legal Entity");

		sendKeysToTextField(driver,objectrepository.gettxtWCDBAName(), AutomationUtilities.sBusinessName, "Agent Entered DBA Name as Same as Business Name");

		sendKeysToTextField(driver,objectrepository.gettxtWCAddress1(), objWCLoadManager.getWCAddress1(),"Address1");
		sendKeysToTextField(driver,objectrepository.gettxtWCCity(), objWCLoadManager.getWCCity(),"City");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
        if(objectrepository.getUseasis().isDisplayed()) {
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
			}
        
		buttonClick(driver,objectrepository.getdpdAddressState(), 10, "Click on State");
		sendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCAddressState(),"AddressState");
		sendKeysToTextField(driver,objectrepository.gettxtWCZipCode(), objWCLoadManager.getWCZipCode(),"Zipcode");
		sendKeysToTextField(driver,objectrepository.gettxtWCDateBussinessStart(), dateFormat.format(cal.getTime()),"Bussiness Start Date is entered");
		buttonClick(driver,objectrepository.gettxtWCAddress2(), 10, "Click on Address 2");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

        if(objWCLoadManager.getTCScenarios().equalsIgnoreCase("Referral Flow")) {
		
        	String AddFEIN = AutomationUtilities.getRandomString(9);
        	sendKeysToTextField(driver,objectrepository.gettxtWCAddinsuredName1(), objWCLoadManager.getWCAditionalInsured(),"Additional Insured Name");
        	sendKeysToTextField(driver,objectrepository.gettxtWCFEINNo1(),AddFEIN,"Additional FEIN");
		 }
		
		buttonClick(driver,objectrepository.getdpdWCEmployerLimit(), 10, "Click on EmployerLimit");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCEmployerLimit(),"Employer Limit");
		sendKeysToTextField(driver,objectrepository.gettxtWCEffectiveDate(), dateFormat.format(date),"Effective date is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if (objWCLoadManager.getWCExpMod() != null) {
			System.out.println("Clcking Current Experience Mod radio button");
			WebElement element = objectrepository.getlblWCrdoCurrExpModYes();

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.getElementById('rdoCurrExpModYes').click();", element);
			System.out.println("Radio button has been selected");
			Thread.sleep(2000);

			sendKeysToTextField(driver,objectrepository.gettxtWCExpMod(), objWCLoadManager.getWCExpMod(), "Current Experience Mod is entered");

		} else {

			buttonClick(driver,objectrepository.getlblWCrdoCurrExpModNo(), 10, "Current Experience Mod is selected as No");
		}

		sendKeysToTextField(driver,objectrepository.gettxtWCFirstName(), objWCLoadManager.getWCFirstName(),"Owner/Officer First Name is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtWCLastName(), objWCLoadManager.getWCLastName(),"Owner/Officer Last Name is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtWCPerOwner(), objWCLoadManager.getWCPerOwner(),"Owner/Officer percentage is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
			buttonClick(driver,objectrepository.gettxtWCIncluderd(),10,"Include radio button is clicked");
		} else {
			buttonClick(driver,objectrepository.gettxtWCExcluderd(), 10, "Exclude radio button is clicked");
		}

		sendKeysToTextField(driver,objectrepository.gettxtWCdesc(), "XYZ", "Description is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtWCFTEmployee(), objWCLoadManager.getWCFTEmployee(),"Full time Employee is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtWCPTEmployee(), objWCLoadManager.getWCPTEmployee(),"Part time Employee is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtWCGrossannualPayroll(), objWCLoadManager.getWCGrossannualPayroll(),"Gross Annual Payroll is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
			
		sendKeysToTextField(driver,objectrepository.getWCtxtInOwnClassCode(), objWCLoadManager.getWCClassCode(), "Include Owner Class code is been entered");
		buttonClick(driver,objectrepository.gettxtOWWCFTEmployee(), 10, "Owner WC FT Employee button is clicked");
		sendKeysToTextField(driver,objectrepository.gettxtOWWCFTEmployee(), objWCLoadManager.getWCFTEmployee(), "Owner FT Employee is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtOWWCGross(), objWCLoadManager.getWCOwnGrossannualPayroll(), "Owner FT Employee is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		}
		
		buttonClick(driver,objectrepository.getBtnWCNext(), 10, "Next button is saved sucessfully.");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if(objectrepository.getUseasis().isDisplayed()) {
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
			}
		
		System.out.println("System is showing validation message for DBA -- " + objectrepository.gettxtWCDBANameerror().getText());
		AutomationUtilities.LogSummary(LogPath,"System is showing validation message for DBA -- " + objectrepository.gettxtWCDBANameerror().getText());
		sendKeysToTextField(driver,objectrepository.gettxtWCDBAName(), AutomationUtilities.sBusinessName + "DB","Agent Entered DBA Name as different as Business Name");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		buttonClick(driver,objectrepository.getBtnWCNext(), 10, "Next button is saved sucessfully.");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		Thread.sleep(3000);
		
		System.out.println("Page Label Name is :"+ objectrepository.gettxtWCPageLabel().getText());
		Thread.sleep(1000);
		
		if(objectrepository.gettxtWCPageLabel().getText().equalsIgnoreCase("Business Summary")) {
			buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
		}else {
			System.out.println("Close button is not Present");
			
		}
		System.out.println("Business Summary have been completed Sucessfully");
		AutomationUtilities.LogSummary(LogPath, "Business Summary have been completed Sucessfully");
	}

	public void GeneralQuestions(LoadManager objWCLoadManager, WebDriver driver) throws IOException, InterruptedException, AWTException {
		
		Thread.sleep(5000);
		javascriptExecutorClick(driver, objectrepository.rdQuestion_1(), "Question-1");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_2(), "Question-2");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_3(), "Question-3");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_4(), "Question-4");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_5(), "Question-5");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_6(), "Question-6");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_7(), "Question-7");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_8(), "Question-8");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_9(), "Question-9");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_10(), "Question-10");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_11(), "Question-11");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_12(), "Question-12");
		javascriptExecutorClick(driver, objectrepository.rdQuestion_13(), "Question-13");

		checkCheckBox(driver, objectrepository.chkBedding(), 2, "Bedding Plants");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_1(), "Question-1");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_2(), "Question-2");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_3(), "Question-3");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_4(), "Question-4");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_5(), "Question-5");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_6(), "Question-6");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_7(), "Question-7");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_8(), "Question-8");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_9(), "Question-9");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_10(), "Question-10");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_11(), "Question-11");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_12(), "Question-12");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_13(), "Question-13");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_14(), "Question-14");
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_15(), "Question-15");

		buttonClick(driver,objectrepository.getBtnWCNext(), 10, "Next button is saved sucessfully.");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		System.out.println("General & Industrial Questions have been completed Sucessfully");
		AutomationUtilities.LogSummary(LogPath, "General & Industrial Questions have been completed Sucessfully");
	}

	public void Losses(LoadManager objWCLoadManager, WebDriver driver) throws IOException, InterruptedException, AWTException {

		Thread.sleep(5000);
		
		selectDropdownlitag(driver, objectrepository.gethadCoverage(), "Yes", "Had a coverage Yes/No");
		javascriptExecutorClick(driver, objectrepository.rdAnyLosses(), "Any Losses Yes/No");

		sendKeysToTextField(driver,objectrepository.gettxtLossCarrier(), "Test", "Loss Page Carrier");
		buttonClick(driver,objectrepository.btnSubmit(), 10, "Submit Losses");

		System.out.println("Losses Page has been completed");
		AutomationUtilities.LogSummary(LogPath, "Losses Page has been completed");
	}

	public void Application(LoadManager objWCLoadManager, WebDriver driver, String sBusinessNameValue,LoginPage objWCloginpage,Underwriting objWCunderwriting,HomePage objhomepage) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {

		Thread.sleep(10000);

		WebElement selWCNameInsured_element = objectrepository.getselWCNameInsured();
		selWCNameInsured_element.click();

		WebElement WCNameInsuredtxt_element = objectrepository.getWCNameInsuredtxt();
		WCNameInsuredtxt_element.click();

		Thread.sleep(3000);

		selectDropdownlitag(driver, objectrepository.getWCApplicationRelationsip(), "Primary", "Relaionship");
		sendKeysToTextField(driver,objectrepository.getWAppliactionCAddress1(), objWCLoadManager.getWCAddress1(),"WC Application Address");
		sendKeysToTextField(driver,objectrepository.getWAppliactionCity(), objWCLoadManager.getWCCity(), "WC Application City");
		buttonClick(driver,objectrepository.getWAppliactionState(), 10, "WC Application State drop down");
		Thread.sleep(2000);
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name");
		sendKeysToTextField(driver,objectrepository.getWCAppliactionZipcode(), objWCLoadManager.getWCZipCode(),"WC Application Zipcode");
		buttonClick(driver,objectrepository.getWAppliactionAddLoact(), 10, "Add Location button");
		System.out.println("First Address has been added successfully....!");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		
		//Adding Second Address
		Thread.sleep(3000);
		selectDropdownlitag(driver, objectrepository.getselWCNameInsured(),  objWCLoadManager.getWCFirstName() +" "+ objWCLoadManager.getWCLastName(), "Name Insured");
		selectDropdownlitag(driver, objectrepository.getWCApplicationRelationsip(), "Primary", "Relaionship");
		sendKeysToTextField(driver,objectrepository.getWAppliactionCAddress1(), objWCLoadManager.getWCAddress1(),"WC Application Address");
		sendKeysToTextField(driver,objectrepository.getWAppliactionCity(), objWCLoadManager.getWCCity(), "WC Application City"); 
		buttonClick(driver,objectrepository.getWAppliactionState(), 10, "WC Application State drop down");
		Thread.sleep(2000);
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name"); 
		sendKeysToTextField(driver,objectrepository.getWCAppliactionZipcode(), objWCLoadManager.getWCZipCode(),"WC Application Zipcode"); 
		buttonClick(driver,objectrepository.getWAppliactionAddLoact(), 10, "Add Location button");
		System.out.println("Second Address has been added successfully....!");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		//Main insured Contact information
		sendKeysToTextField(driver,objectrepository.getWCconatactName(), objWCLoadManager.getWCFirstName(), "Contact infromation Name");
		sendKeysToTextField(driver,objectrepository.getWCcontactPhone(), objWCLoadManager.getWCcontactPhone(), "Contact infromation Phone Number");
		sendKeysToTextField(driver,objectrepository.getWCcontactEmail(), objWCLoadManager.getWCcontactEmail(), "Contact infromation Email");
		buttonClick(driver,objectrepository.getWCconatactMailingAddress(), 10, "Add Location button");
		Thread.sleep(2000);
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objWCLoadManager.getWCAddress1(),"Contact Address");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		Thread.sleep(2000);
		buttonClick(driver,objectrepository.getWCAgreebtn(),10,"Click on Agree Button");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if(objWCLoadManager.getTCScenarios().equalsIgnoreCase("Referral Flow")) {
			
			buttonClick(driver,objectrepository.getWCMakePayment(),10,"Click on Make Payment");
			AutomationUtilities.LogSummary(LogPath, "Read Referral Text : "+objectrepository.getWCReferralText().getText());
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(driver,objectrepository.getWCBacktoRecord(),10,"Back to Record");
			objWCloginpage.AgentSignOut (driver);
			objWCloginpage.UWlogin(driver);
	    	//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
	    	objWCunderwriting.UnderwritingSearch(driver);
	    	objWCunderwriting.UWChangeStatus(driver,objWCLoadManager);
	    	//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    	 
	    	 
	    	 objWCloginpage.UWSignOut(driver);
	    	 objWCloginpage.Agentlogin(driver);
	    	 //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    	 
	    	 objhomepage.SelectAgent(driver,objWCLoadManager.getAgentName()); 
			// AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
				
	    	 objWCunderwriting.AgentSearch(driver);
	    	// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		}
		
		buttonClick(driver,objectrepository.getbtnWCDownloadQuote(),10,"Quote Document");
		AutomationUtilities.Traverse(driver,"Quote Document");
	    System.out.println("Download WC Quote Document is clicked sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Download WC Quote Document is clicked successfully");
	     
		
		buttonClick(driver,objectrepository.getbtnWCDownloadRatingWorksheet(),10,"Rating Document");
		Thread.sleep(500);
		buttonClick(driver,objectrepository.getlnkWCCondensedRatingWorksheet(),10,"Condensed Rating Worksheet");
		Thread.sleep(1000);
		AutomationUtilities.Traverse(driver,"Rating Document");
	    System.out.println("Download WC Rating Document is clicked sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Download WC Rating Document is clicked successfully");
		
	    
	    buttonClick(driver,objectrepository.getbtnWCDownloadApplication(),10,"Application Document");
	    AutomationUtilities.Traverse(driver,"Application Document");
	    System.out.println("Download WC Application Document is clicked sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Download WC Application Document is clicked successfully");
		
		
		buttonClick(driver,objectrepository.getWCMakePayment(),10,"Click on Make Payment");
		
		System.out.println("Application Screen have been completed Sucessfully");
		AutomationUtilities.LogSummary(LogPath,"Application Screen have been completed Sucessfully");	
		
	}
	
     public void PolicyIssue (LoadManager objWCLoadManager,WebDriver driver) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
		
		Thread.sleep(10000);
		
		/*************NEW CODE START**************/
		WebElement element = objectrepository.getchkIssue_Line1();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('chkIssue_1').click();", element);
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_2').click();", element);
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_3').click();", element);
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_4').click();", element);
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		/*************NEW CODE ENDS**************/
		
		System.out.println("PaymentOption is:>>>>>" +objWCLoadManager.getPaymentOption());
		AutomationUtilities.ClickPaymentOptions(driver,objectrepository,objWCLoadManager.getPaymentOption());
		
		buttonClick(driver,objectrepository.getdpddepositpaymentmethod(),10,"Click on Deposit Payment Method");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objWCLoadManager.getDepositPaymentMethod(),"Deposit Payment Method");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objWCLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Check")) {
			
			buttonClick(driver,objectrepository.getWCclkCheckPayment(),10,"Click on Check Issue Policy");
		
		}else if(objWCLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Online")) {
			
			buttonClick(driver,objectrepository.getWCclkCheckPayment(),10,"Click on Online Issue Policy");
			
		}else {
			
			buttonClick(driver,objectrepository.getWCclkPremiumFinancePayment(),10,"Click on Premium Finance Issue Policy");
		}
		
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		AutomationUtilities.PolicyNo =objectrepository.getWCtxtPolicyNumber().getText() ;
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		AutomationUtilities.LogSummary(LogPath,"WC Policy Number :"+AutomationUtilities.PolicyNo);
		AutomationUtilities.LogSummary(LogPath,"Policy Issuance is completed successfully");
	}


}
