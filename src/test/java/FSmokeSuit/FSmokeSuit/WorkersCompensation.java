package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WorkersCompensation extends AutomationUtilities {

	public static WebDriver driver = null;
	public static ObjectRepository objectrepository = null;
	public static String sBusinessName;
	public static String ClassCode;
	public WorkersCompensation(WebDriver driver) {

		objectrepository = ObjectRepository.getInstance(driver);
	}

	public void BusinessSummary(LoadManager objWCLoadManager, WebDriver driver)
			throws InterruptedException, IOException, AWTException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -15);

		String States [] = objWCLoadManager.getWCState().split("/");
		String ClassCodeDesc [] = objWCLoadManager.getWCClassCodeDesc().split("/");
		int StatesCount =States.length;
		int ClassCodeDescCount = ClassCodeDesc.length;
		int iteration =0;
		if(iteration > 1 ||ClassCodeDescCount > 1 ) {
			
			if(StatesCount > 1) {
				
			  for(int i=1;i<=StatesCount;i++) {
				
				driver.findElement(By.xpath("//span[@id='select2-ddlState"+i+"-container']")).click();
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),States[i-1], "State Name");
				
			   if(!(i==StatesCount)) {
				buttonClick(driver,objectrepository.getbtnWCAddClassCode(), 10, "Click on Add State");
			   }
			}  
		}else {
			
		   buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
		   EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name");
		}
			if (ClassCodeDescCount > 1 ) {
				for(int i=1;i<=ClassCodeDescCount;i++) {
					
					driver.findElement(By.xpath("//input[@id='txtClassCodes"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),ClassCodeDesc[i-1]);
					driver.findElement(By.xpath("//input[@id='txtClassCodes"+i+"']")).sendKeys(Keys.TAB);
					buttonClick(driver,objectrepository.getbtnWCContinue(), 5, "Click on Continue");
				}
			} else {
				sendKeysToTextField(driver,objectrepository.gettxtWCClassCodes(), objWCLoadManager.getWCClassCodeDesc(), "Class Code");
				buttonClick(driver,objectrepository.getbtnWCContinue(), 5, "Click on Continue");
			}
			
			iteration = iteration++;
		}else {
			buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCState(), "State Name");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			sendKeysToTextField(driver,objectrepository.gettxtWCClassCodes(), objWCLoadManager.getWCClassCodeDesc(), "Class Code");
			buttonClick(driver,objectrepository.getbtnWCContinue(), 5, "Click on Continue");
		}
		
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID,driver);
		AutomationUtilities.sClassCode = objWCLoadManager.getWCClassCode();
		AutomationUtilities.sClassCodeDesc = objWCLoadManager.getWCClassCodeDesc();
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

		if(objWCLoadManager.getWCBusinessName().equalsIgnoreCase("")) {
		    AutomationUtilities.sBusinessName = "FCGA AUTM-"+AutomationUtilities.SpecialChar + AutomationUtilities.getRandomString(9);
		}else {
			AutomationUtilities.sBusinessName =	objWCLoadManager.getWCBusinessName();
		}
		System.out.println("Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);
		AutomationUtilities.LogSummary(LogPath, "Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);
		sendKeysToTextField(driver,objectrepository.gettxtWCBussInsuredName(), AutomationUtilities.sBusinessName, "Business Name");


		buttonClick(driver,objectrepository.getdpdWCLegalEntity(), 10, "Click on Legal Entity");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCLegalEntity(), "Legal Entity");
		
		if(objWCLoadManager.getWCDBAName().equalsIgnoreCase("")) {
		    AutomationUtilities.sDBAName = AutomationUtilities.sBusinessName + "DBA";
		}else {
			AutomationUtilities.sDBAName =	objWCLoadManager.getWCDBAName();
		}
        sendKeysToTextField(driver,objectrepository.gettxtWCDBAName(), AutomationUtilities.sDBAName, "Agent Entered DBA Name as Same as Business Name");

		sendKeysToTextField(driver,objectrepository.gettxtWCAddress1(), objWCLoadManager.getWCAddress1(),"Address1");
		sendKeysToTextField(driver,objectrepository.gettxtWCAddress2(), objWCLoadManager.getWCAddress2(),"Address2");
		sendKeysToTextField(driver,objectrepository.gettxtWCCity(), objWCLoadManager.getWCCity(),"City");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 if(CheckElementPresent(objectrepository.getUseasis()) == true ) {
				AutomationUtilities.SmartyStreet = "No";
				buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
			}else {
				AutomationUtilities.SmartyStreet = "Yes";
			}
        
		buttonClick(driver,objectrepository.getdpdAddressState(), 10, "Click on State");
		sendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCAddressState(),"AddressState");
		sendKeysToTextField(driver,objectrepository.gettxtWCZipCode(), objWCLoadManager.getWCZipCode(),"Zipcode");
		
		AutomationUtilities.sAddress = objWCLoadManager.getWCAddress1()+","+objWCLoadManager.getWCAddress2()+","+objWCLoadManager.getWCCity()+","+objWCLoadManager.getWCAddressState()+","+objWCLoadManager.getWCZipCode();
		
		
		sendKeysToTextField(driver,objectrepository.gettxtWCDateBussinessStart(), dateFormat.format(cal.getTime()),"Bussiness Start Date is entered");
		buttonClick(driver,objectrepository.gettxtWCAddress2(), 10, "Click on Address 2");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

        if(!objWCLoadManager.getWCAditionalInsured().equalsIgnoreCase("")) {
			
			String[] WCAdditionalInsured = objWCLoadManager.getWCAditionalInsured().split("/");
			int AICount = WCAdditionalInsured.length;

			if(AICount > 1) {

			for(int i=1;i<=AICount;i++) {
				
				String AddFEIN = AutomationUtilities.getRandomString(9);
				driver.findElement(By.xpath("//input[@id='txtAddinsuredName"+i+"'")).sendKeys(Keys.chord(Keys.CONTROL, "a"),WCAdditionalInsured[i-1]);
				driver.findElement(By.xpath("//input[@id='txtFEINNo"+i+"'")).sendKeys(AddFEIN);
				
				if(i<AICount) {
					buttonClick(driver,objectrepository.getbtnWCAIButton(),10,"Additional Insured");
				}
			  }
			}else {
        	
				String AddFEIN = AutomationUtilities.getRandomString(9);
        	    sendKeysToTextField(driver,objectrepository.gettxtWCAddinsuredName1(), objWCLoadManager.getWCAditionalInsured(),"Additional Insured Name");
        	    sendKeysToTextField(driver,objectrepository.gettxtWCFEINNo1(),AddFEIN,"Additional FEIN");
		   }
        }
        
		buttonClick(driver,objectrepository.getdpdWCEmployerLimit(), 10, "Click on EmployerLimit");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objWCLoadManager.getWCEmployerLimit(),"Employer Limit");
		sendKeysToTextField(driver,objectrepository.gettxtWCEffectiveDate(), dateFormat.format(date),"Effective date is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if (objWCLoadManager.getWCExpMod() != null) {
			
			WebElement element = objectrepository.getlblWCrdoCurrExpModYes();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.getElementById('rdoCurrExpModYes').click();", element);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			sendKeysToTextField(driver,objectrepository.gettxtWCExpMod(), objWCLoadManager.getWCExpMod(), "Current Experience Mod is entered");

		} else {

			buttonClick(driver,objectrepository.getlblWCrdoCurrExpModNo(), 10, "Current Experience Mod is selected as No");
		}

		if(objWCLoadManager.getOwnerPermission().equalsIgnoreCase("Yes")) {
			
			if(Integer.valueOf(objWCLoadManager.getOwnerCount()) > 1) {
				
				String FristName[] = objWCLoadManager.getWCFirstName().split("/");
				String LastName[] = objWCLoadManager.getWCLastName().split("/");
				String OwnerPerct[] = objWCLoadManager.getWCPerOwner().split("/");
				int OwnerCount = Integer.valueOf(objWCLoadManager.getOwnerCount());
				
				for(int i=1;i<=OwnerCount;i++) {
					
					driver.findElement(By.xpath("//input[@id ='txtFirstName"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),FristName[i-1]+AutomationUtilities.SpecialChar);
					driver.findElement(By.xpath("//input[@id ='txtLastName"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),LastName[i-1]+AutomationUtilities.SpecialChar);
					driver.findElement(By.xpath("//input[@id ='txtPerOwner"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),OwnerPerct[i-1]+AutomationUtilities.SpecialChar);
				  
					if(i < OwnerCount) {
						buttonClick(driver,objectrepository.getbtnWCOWButton(),10,"Owner/Officer");
					}
					if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
						
						driver.findElement(By.xpath("//input[@id='radio"+i+"']")).click();

					} else {
						
						driver.findElement(By.xpath("//input[@id='radios"+i+"']")).click();
					}
					
				}
				
			}else {
				
				sendKeysToTextField(driver,objectrepository.gettxtWCFirstName(), objWCLoadManager.getWCFirstName()+AutomationUtilities.SpecialChar,"Owner/Officer First Name is been entered");
				sendKeysToTextField(driver,objectrepository.gettxtWCLastName(), objWCLoadManager.getWCLastName()+AutomationUtilities.SpecialChar,"Owner/Officer Last Name is been entered");
				sendKeysToTextField(driver,objectrepository.gettxtWCPerOwner(), objWCLoadManager.getWCPerOwner()+AutomationUtilities.SpecialChar,"Owner/Officer percentage is been entered");
				//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

				if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
					
					buttonClick(driver,objectrepository.gettxtWCIncluderd(),10,"Include radio button is clicked");
				
				} else {
					
					buttonClick(driver,objectrepository.gettxtWCExcluderd(), 10, "Exclude radio button is clicked");
				}
			}
		}
		
		sendKeysToTextField(driver,objectrepository.gettxtWCdesc(), objWCLoadManager.getWCBusinessDescription(), "Description is been entered");
		
		if (ClassCodeDescCount > 1 ) {
			
			String WCFTEmployee[] = objWCLoadManager.getWCFTEmployee().split("/");
			String WCPTEmployee[] = objWCLoadManager.getWCPTEmployee().split("/");
			String WCGrossannualPayroll[] = objWCLoadManager.getWCGrossannualPayroll().split("/");
			String WCClassCode [] = objWCLoadManager.getWCClassCode().split("/");
			String Payroll = WCGrossannualPayroll[0];
			ClassCode = WCClassCode[0];
			
			for(int i=1;i<=ClassCodeDescCount;i++) {
				
				driver.findElement(By.xpath("//input[@id='txtFTEmployee"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),WCFTEmployee[i-1]);
				driver.findElement(By.xpath("//input[@id='txtPTEmployee"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),WCPTEmployee[i-1]);
				driver.findElement(By.xpath("//input[@id='txtGrossannualPayroll"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),WCGrossannualPayroll[i-1]);
				
			  if (Integer.valueOf(Payroll) < Integer.valueOf(WCGrossannualPayroll[i-1])) {
				  
				  Payroll = WCGrossannualPayroll[i-1];
				  ClassCode = WCClassCode[i-1];
			  }
				
			}
		}else {
				
		  sendKeysToTextField(driver,objectrepository.gettxtWCFTEmployee(), objWCLoadManager.getWCFTEmployee(),"Full time Employee is been entered");
		  sendKeysToTextField(driver,objectrepository.gettxtWCPTEmployee(), objWCLoadManager.getWCPTEmployee(),"Part time Employee is been entered");
		  sendKeysToTextField(driver,objectrepository.gettxtWCGrossannualPayroll(), objWCLoadManager.getWCGrossannualPayroll(),"Gross Annual Payroll is been entered");
		  ClassCode = objWCLoadManager.getWCClassCode();
		  //AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
			
		}
		if (objWCLoadManager.getWCInclude().equalsIgnoreCase("Yes")) {
			
		sendKeysToTextField(driver,objectrepository.getWCtxtInOwnClassCode(), objWCLoadManager.getWCClassCode(), "Include Owner Class code is been entered");
		buttonClick(driver,objectrepository.gettxtOWWCFTEmployee(), 10, "Owner WC FT Employee button is clicked");
		sendKeysToTextField(driver,objectrepository.gettxtOWWCFTEmployee(), objWCLoadManager.getWCFTEmployee(), "Owner FT Employee is been entered");
		sendKeysToTextField(driver,objectrepository.gettxtOWWCGross(), objWCLoadManager.getWCOwnGrossannualPayroll(), "Owner FT Employee is been entered");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		}
		
		if(!objWCLoadManager.getWCInsuredSubContractor().isBlank()) {
			
			sendKeysToTextField(driver,objectrepository.getWCtxtInsuredSubcontract(), objWCLoadManager.getWCInsuredSubContractor(), "Include Owner Class code is been entered");
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			sendKeysToTextField(driver,objectrepository.getWCtxttypeofworkSubcontract(), objWCLoadManager.getWCTypeofWork()+AutomationUtilities.SpecialChar, "Type of Work is been entered");
			
			if(objWCLoadManager.getWCworkperformed().equalsIgnoreCase("Yes")) {
				
				buttonClick(driver,objectrepository.getWCrdWCworkperformedYes(), 10,"Worked Performed");
			
			}else {
			 
			   buttonClick(driver,objectrepository.getWCrdWCworkperformedNo(), 10, "Worked Performed");		
			}
		   
            if(objWCLoadManager.getWCproofofWCCov().equalsIgnoreCase("Yes")) {
				
				buttonClick(driver,objectrepository.getWCrdoWCCoverageYes(), 10,"WC Coverage");
			
			}else {
			 
			   buttonClick(driver,objectrepository.getWCrdoWCCoverageNo(), 10, "WC Coverage");		
			}
		
		} else if (!objWCLoadManager.getWCUnInsuredSubcontractor().isBlank()) {
			
			sendKeysToTextField(driver,objectrepository.getWCtxtUnInsuredSubcontract(), objWCLoadManager.getWCUnInsuredSubcontractor(), "Include Owner Class code is been entered");
		}
		
		WCClassCode = driver.findElement(By.xpath("//input[@id='txtCode1']")).getAttribute("data-classcode").toString();
		
		buttonClick(driver,objectrepository.getBtnWCNext(), 05, "Next button is saved sucessfully.");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if(CheckElementPresent(objectrepository.getUseasis()) == true ) {
		//if(objectrepository.getUseasis().isDisplayed()) {
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
			}
		
		if(CheckElementPresent(objectrepository.getWCDeclineReason()) == true ) {
			    
			    AutomationUtilities.DeclineReason = objectrepository.getWCDeclineReason().getText();
				buttonClick(driver,objectrepository.getbtnDecContinue(),10,"Click on Decline Continue Button");
				}
		
		/*Thread.sleep(5000);
		System.out.println("System is showing validation message for DBA -- " + objectrepository.gettxtWCDBANameerror().getText());

		AutomationUtilities.LogSummary(LogPath,"System is showing validation message for DBA -- " + objectrepository.gettxtWCDBANameerror().getText());
		sendKeysToTextField(driver,objectrepository.gettxtWCDBAName(), AutomationUtilities.sBusinessName + "DB","Agent Entered DBA Name as different as Business Name");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		buttonClick(driver,objectrepository.getBtnWCNext(), 10, "Next button is saved successfully.");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		Thread.sleep(2000);
		
		System.out.println("Page Label Name is :"+ objectrepository.gettxtWCPageLabel().getText());
		Thread.sleep(1000);
		
		if(objectrepository.gettxtWCPageLabel().getText().equalsIgnoreCase("Business Summary")) {
			buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved successfully.");
		}else {
			System.out.println("Close button is not Present");
			
		}*/
		
		System.out.println("Business Summary have been completed Successfully");
		AutomationUtilities.LogSummary(LogPath, "Business Summary have been completed Successfully");
	}

	public void GeneralQuestions(LoadManager objWCLoadManager,WCIndustrialQ industrialq ,WebDriver driver) throws IOException, InterruptedException, AWTException {
		
		waitforpageload(driver, 15);
		String ReferalReason = driver.findElement(By.xpath("//input[@id='hdnReferralObject']")).getAttribute("value").toString();
		if(ReferalReason.isEmpty()) {
			AutomationUtilities.LogSummary(LogPath, "No Referral Reason Found");
			System.out.println("No Referral Reason Found");
			AutomationUtilities.ClassCodeSTP = "Yes";
		}else {
		    AutomationUtilities.LogSummary(LogPath, "Referral Reason: "+ReferalReason);
		    System.out.println("Referral Reason Found, Referral Reason: "+ ReferalReason);
		    AutomationUtilities.ClassCodeSTP = "No";
		}
		
		String WCXpath = "//tr[@class='visiblerow' and @data-level='Primary']";   
		List<WebElement> elementName = driver.findElements(By.xpath(WCXpath));
        int lastQ = elementName.size();
		for (int i =1; i<=lastQ;i++) {
			//String testcasePath = "";
			String IQCount = driver.findElement(By.xpath("//tr[@class='visiblerow' and @data-level='Primary']["+i+"]")).getAttribute("id").toString();
			String IQValue = driver.findElement(By.xpath("//tr[@class='visiblerow' and @data-level='Primary']//td[contains(@id,'lblDescribe_"+IQCount+"')]")).getText().toString();
			AutomationUtilities.LogSummary(LogPath,"Industry Questions"+i+" for ClassCode " +WCClassCode+" :"+IQValue);
			//AutomationUtilities.ReadWriteIndustryQuestion (testcasePath,"TD_IQ",i,AutomationUtilities.tcCount,IQValue,LogPath,"IndustryQuestion (Expected)" );

		}
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
	
		//System.out.println("Class Code is "+ objWCLoadManager.getClassCode());
		//industrialq.CheckWCIndustrialQ (objWCLoadManager.getWCClassCodeGroup(),driver);
		//industrialq.CheckWCIndustrialQ ("0005",driver);
		
		/*List<WebElement> elementName = driver.findElements(By.xpath("//tr[contains(@data-fieldid,'IQ')and @data-level='Primary']"));
        int IndustialQ = elementName.size();
        System.out.println("Industrial Question Count is : "+IndustialQ);
        AutomationUtilities.LogSummary(LogPath, "Industrial Question Count is : "+IndustialQ);
        AutomationUtilities.IndustialQ =String.valueOf(IndustialQ);
        AutomationUtilities.Screenshot(tcSnapPath, testCaseID,driver);
         AutomationUtilities.Screenshot(tcSnapPath, testCaseID,driver);
        
		checkCheckBox(driver, objectrepository.chkBedding(), 2, "Bedding Plants");
		AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
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
		javascriptExecutorClick(driver, objectrepository.rdIQuestion_15(), "Question-15");*/

		//buttonClick(driver,objectrepository.getBtnWCNext(), 10, "Next button is saved successfully.");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		//System.out.println("General & Industrial Questions have been completed Successfully");
		AutomationUtilities.LogSummary(LogPath, "General & Industrial Questions have been completed Successfully");
	}

	public void Losses(LoadManager objWCLoadManager, WebDriver driver) throws IOException, InterruptedException, AWTException {

		waitforpageload(driver, 5);
		
		selectDropdownlitag(driver, objectrepository.gethadCoverage(), objWCLoadManager.getWChadCoverage(), "Had a coverage Yes/No");
		
		if(objWCLoadManager.getWChadCoverage().equalsIgnoreCase("Yes")) {
			
			sendKeysToTextField(driver,objectrepository.gettxtLossCarrier(), objWCLoadManager.getWCCarierName(), "Loss Page Carrier");
		}
		
		if(objWCLoadManager.getWCAnyLosses().equalsIgnoreCase("Yes")){
			
			javascriptExecutorClick(driver, objectrepository.rdAnyLossesYes(), "Any Losses Yes/No");
			sendKeysToTextField(driver,objectrepository.gettxtWCclaims(), objWCLoadManager.getWCClaims(), "Claim No.");
			sendKeysToTextField(driver,objectrepository.gettxtWCincurred(), objWCLoadManager.getWCTotalIncurred(), "Total Incurred");
			
		}else {
			
			javascriptExecutorClick(driver, objectrepository.rdAnyLossesNo(), "Any Losses Yes/No");
		}
		
		sendKeysToTextField(driver,objectrepository.gettxtWCNotes(), objWCLoadManager.getWCNotes(), "Notes");
		AutomationUtilities.AgentMessages(driver,objectrepository, objWCLoadManager.getWCMessages());
        
		
		buttonClick(driver,objectrepository.btnSubmit(), 10, "Submit Losses");

		//System.out.println("Losses Page has been completed");
		AutomationUtilities.LogSummary(LogPath, "Losses Page has been completed");
	}

	public void Application(LoadManager objWCLoadManager, WebDriver driver, String sBusinessNameValue,String recordtype, LoginPage objWCloginpage,Underwriting objWCunderwriting,HomePage objhomepage,WCIndustrialQ industrialq, String testcasePath) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {

		waitforpageload(driver, 15);
 
		int count = 1;
		int icount =1;
		buttonClick(driver,objectrepository.getselWCNameInsured(), 10, "WC Name Insured");
		int InsuredNameCount = driver.findElements(By.xpath("//li[contains(@id,'select2-ddlInsuredName-result')]")).size();
		ArrayList<String> WCNameInsured = new ArrayList<String>();
		
		for (int i=0;i<InsuredNameCount;i++) {
			
			WCNameInsured.add(driver.findElement(By.xpath("//li[contains(@id,'select2-ddlInsuredName-result')]["+count+"]")).getText());
			count = count+1;
		}
		
		buttonClick(driver,objectrepository.getselWCNameInsured(), 10, "WC Name Insured");
		AutomationUtilities.LogSummary(LogPath,"Total Insured Name are : "+WCNameInsured);
		
		if(!AutomationUtilities.sDBAName.equalsIgnoreCase("")) {
			icount =2;
		}
		
		for (int i= icount;i<InsuredNameCount;i++) {
			
			Thread.sleep(3000);
			buttonClick(driver,objectrepository.getselWCNameInsured(), 10, "WC Name Insured");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),WCNameInsured.get(i)+AutomationUtilities.SpecialChar,"Insured Name");
			
			selectDropdownlitag(driver, objectrepository.getWCApplicationRelationsip(), "Primary", "Relaionship");
			sendKeysToTextField(driver,objectrepository.getWCApplicationFullTimeE(), objWCLoadManager.getWCFTEmployee(),"WC Application Address");
			sendKeysToTextField(driver,objectrepository.getWCApplicationPartTimeE(), objWCLoadManager.getWCPTEmployee(),"WC Application Address");
			
			sendKeysToTextField(driver,objectrepository.getWAppliactionCAddress1(), objWCLoadManager.getWCAddress1()+AutomationUtilities.SpecialChar,"WC Application Address");
			sendKeysToTextField(driver,objectrepository.getWAppliactionCAddress2(), objWCLoadManager.getWCAddress2()+AutomationUtilities.SpecialChar,"WC Application Address");
			sendKeysToTextField(driver,objectrepository.getWAppliactionCity(), objWCLoadManager.getWCCity(), "WC Application City");
			
			buttonClick(driver,objectrepository.getWAppliactionState(), 10, "WC Application State drop down");
			String States [] = objWCLoadManager.getWCState().split("/");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), States[0], "State Name");
			sendKeysToTextField(driver,objectrepository.getWCAppliactionZipcode(), objWCLoadManager.getWCZipCode(),"WC Application Zipcode");
			
			buttonClick(driver,objectrepository.getWAppliactionAddLoact(), 10, "Add Location button");
		}
		//Main insured Contact information
		sendKeysToTextField(driver,objectrepository.getWCconatactName(), AutomationUtilities.sBusinessName, "Contact infromation Name");
		sendKeysToTextField(driver,objectrepository.getWCcontactPhone(), objWCLoadManager.getWCcontactPhone(), "Contact infromation Phone Number");
		sendKeysToTextField(driver,objectrepository.getWCcontactEmail(), objWCLoadManager.getWCcontactEmail(), "Contact infromation Email");
		
		buttonClick(driver,objectrepository.getWCconatactMailingAddress(), 10, "Add Location button");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objWCLoadManager.getWCCity(),"Contact Address");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		buttonClick(driver,objectrepository.getWCAgreebtn(),20,"Click on Agree Button");
		//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
		if(objWCLoadManager.getTCScenarios().equalsIgnoreCase("Referral Flow")) {
			
			buttonClick(driver,objectrepository.getWCMakePayment(),10,"Click on Make Payment");
			waitforpageload(driver, 30);
			AutomationUtilities.LogSummary(LogPath, "Read Referral Text : "+objectrepository.getWCReferralText().getText());
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			Thread.sleep(6000);
			buttonClick(driver,objectrepository.getWCBacktoRecord(),10,"Back to Record");
			objhomepage.checkFramePopup(driver);
			objWCloginpage.AgentSignOut (driver);
			objWCloginpage.UWlogin(driver);
	    	//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
	    	objWCunderwriting.UnderwritingSearch(driver);
	    	
	    	 if(objWCLoadManager.getUWPermission().equalsIgnoreCase("Yes")) {
	    		 objWCunderwriting.UWWCEditQuote(driver,objWCLoadManager,industrialq,testcasePath);
	    	 }
	    	 
	    	objWCunderwriting.UWChangeStatus(driver,objWCLoadManager);
	    	//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    	 
	    	 
	    	 objWCloginpage.UWSignOut(driver);
	    	 objWCloginpage.Agentlogin(driver);
	    	 //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    	 
	    	 objhomepage.SelectAgent(driver,objWCLoadManager); 
			 //AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
				
	    	 objhomepage.checkFramePopup(driver);
	    	 objWCunderwriting.AgentSearch(driver,objWCLoadManager,recordtype);
	    	 //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		}
		
		/*if(objWCLoadManager.getWCUWModifyState().isEmpty()) {
			AutomationUtilities.PhysicalState = objWCLoadManager.getState();
		}else {
		    AutomationUtilities.PhysicalState = objWCLoadManager.getWCUWModifyState();
		}*/
		
		if((CheckElementPresent(objectrepository.getWCFWCICarrier()) == true) && (CheckElementPresent(objectrepository.getWCBICarrier()) == true)) {
			
		//FWCI --	
			buttonClick(driver,objectrepository.getbtnWCFWCIDownloadQuote(),20,"Quote Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver,"FWCI Quote Document");
			buttonClick(driver,objectrepository.getbtnWCFWCIDownloadRatingWorksheet(),50,"Rating Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver,"FWCI Rating Document");
			
		// BI --
			
			buttonClick(driver,objectrepository.getbtnWCBIDownloadQuote(),20,"Quote Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver,"BI Quote Document");
			buttonClick(driver,objectrepository.getbtnWCBIDownloadRatingWorksheet(),50,"Rating Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver," BI Rating Document");
			
		}else if (CheckElementPresent(objectrepository.getWCFWCICarrier()) == true){
			
			buttonClick(driver,objectrepository.getbtnWCFWCIDownloadQuote(),20,"Quote Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver,"FWCI Quote Document");
			buttonClick(driver,objectrepository.getbtnWCFWCIDownloadRatingWorksheet(),50,"Rating Document");
			Thread.sleep(3000);
			AutomationUtilities.Traverse(driver,"FWCI Rating Document");
			
		}
		if(objWCLoadManager.getWCCarierName().equalsIgnoreCase("FWCI")) {
			buttonClick(driver,objectrepository.getbtnWCFWCICarrier(),20,"FWCI Carrier Selected");
		}else {
			buttonClick(driver,objectrepository.getbtnWCBICarrier(),20,"BI Carrier Selected");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    buttonClick(driver,objectrepository.getbtnWCDownloadApplication(),10,"Application Document");
	    Thread.sleep(1000);
	    AutomationUtilities.Traverse(driver,"Application Document");
		
		Thread.sleep(2000);
		buttonClick(driver,objectrepository.getWCMakePayment(),10,"Click on Make Payment");
		waitforpageload(driver, 65);
		System.out.println("Application Screen have been completed Sucessfully");
		AutomationUtilities.LogSummary(LogPath,"Application Screen have been completed Sucessfully");	
		
	}
	
     public void PolicyIssue (LoadManager objWCLoadManager,WebDriver driver) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
		
    	 waitforpageload(driver, 15);
		
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
		
		Thread.sleep(2000);
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
     }	
		
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
     public void ThankYouPage (LoadManager objWCLoadManager,WebDriver driver) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		waitforpageload(driver, 30);
		Thread.sleep(5000);
		
		if(objWCLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Online")) {
			AutomationUtilities.OnlineTraverse (driver,objectrepository,objWCLoadManager.getCreditCardNumber(),objWCLoadManager.getCVVNumber(),objWCLoadManager.getWCcontactEmail(),"Invoice");
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    buttonClick(driver,objectrepository.getbtnWCDownloadBinder(),10,"Binder Document");
	    AutomationUtilities.Traverse(driver,"Binder Document");
		
		
		AutomationUtilities.PolicyNo =objectrepository.getWCtxtPolicyNumber().getText() ;
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		AutomationUtilities.LogSummary(LogPath,"WC Policy Number :"+AutomationUtilities.PolicyNo);
		AutomationUtilities.LogSummary(LogPath,"Policy Issuance is completed successfully");
	}


}
