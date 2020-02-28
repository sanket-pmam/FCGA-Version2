package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeneralLiability extends AutomationUtilities {
	
	@SuppressWarnings("unused")
	private static final OutputType<Object> Jpg = null;
	public static WebDriver driver=null;		
	public static ObjectRepository objectrepository = null;
	String QClassSpecACount= null;
	String QClassSpecValue= null;
	
//------------------------	
	String ElementNamexpath = "//td[@style= 'display:none'][@class='border-white']";
	String QuestionNamexpath = "//tr[@class='visibleTr']";
//-------------------------
	
	public GeneralLiability(WebDriver driver) {
		PageFactory.initElements(driver, this);
		objectrepository = ObjectRepository.getInstance(driver);
		driver.manage().timeouts().implicitlyWait(130,TimeUnit.SECONDS);
	}
		
	public static int LastQCount(WebDriver driver, String XPath) {
		
		List<WebElement> elementName = driver.findElements(By.xpath(XPath));
        int lastQ = elementName.size();
        return lastQ ;
     }
	
	public void GatekepeerQuestion(WebDriver driver) throws InterruptedException, IOException, AWTException {
		
    for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
    	
    	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // No button 
    }
    	
       buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
       Thread.sleep(2000);
       
       AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
       System.out.println("GateKeeper Validation Message "+ objectrepository.GKAlertMsgBox().getText());
       AutomationUtilities.LogSummary(LogPath,"GateKeeper Validation Message :"+ objectrepository.GKAlertMsgBox().getText());
       
       Thread.sleep(1000);
       buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");

    for (int j =1; j<=LastQCount(driver,ElementNamexpath);j++) {
    	if(j==LastQCount(driver,ElementNamexpath)-1)	{
       	 
    	driver.findElement(By.xpath("//label[@for='radio"+(j-1)+"']")).click(); // Yes button 
       }
       else {
    	driver.findElement(By.xpath("//label[@for='radio-"+j+"']")).click(); // No button 
       }
    }
    
    buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    
    System.out.println("Gatekeeper Question have been completed Sucessfully");
    AutomationUtilities.LogSummary(LogPath,"Gatekeeper Question have been completed Sucessfully");
	
  }
	

	public void Risklevel(LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException {
		

		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = new Date();
		    
			EsendKeysToTextField(driver,objectrepository.gettxtEffectiveDate(),dateFormat.format(date),"Effective Date");
			System.out.println("Effective Date of the Quote is :"+dateFormat.format(date));
			
			buttonClick(driver,objectrepository.getdpdstate(),10,"Click on State");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getState(),"State Name");
			
			buttonClick(driver,objectrepository.getdpdCounty(),10,"Click on County");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getCounty(),"County Name");
			
			AutomationUtilities.sBusinessName = "FCGA AUTM -"+ AutomationUtilities.getRandomString (9);
			sendKeysToTextField(driver,objectrepository.gettxtBusinessName(),AutomationUtilities.sBusinessName,"Business Name");
			System.out.println("Insured Name / Business Name is : "+AutomationUtilities.sBusinessName);
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(sBusinessName.isEmpty()) {
				
				String sIFristName = "FCGA AUTM";
				sendKeysToTextField(driver,objectrepository.gettxtIndividualFirstName(),sIFristName,"Frist Name");
				
				String sILastName = AutomationUtilities.getRandomString (9);
				sendKeysToTextField(driver,objectrepository.gettxtIndividualFirstName(),sILastName,"Last Name");
			}
			
			String sDescription = "FCGA-"+ AutomationUtilities.getRandomString (9);
			sendKeysToTextField(driver,objectrepository.gettxtDescriptionOfBusiness(),sDescription,"Business Description");
			sendKeysToTextField(driver,objectrepository.gettxtYearsInBusiness(),objGlLoadManager.getExperience(),"Years In Business");
  
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(objectrepository.gettxtYearsInTrade().isEnabled()) {
				sendKeysToTextField(driver,objectrepository.gettxtYearsInTrade(),objGlLoadManager.getExperience(),"Years In Trade");
			}
			
			sendKeysToTextField(driver,objectrepository.gettxtClaims(),objGlLoadManager.getClaims(),"No of Claims");
			
            if(objGlLoadManager.getPriorInsurance().equalsIgnoreCase("Yes")) {
            	buttonClick(driver,objectrepository.getrbpriorinsuranceYes(),10,"Prior Insurance as Yes");
            } else {
            	buttonClick(driver,objectrepository.getrbpriorinsuranceNo(),10,"Prior Insurance as No");
            }
			
            buttonClick(driver,objectrepository.getdpdliabilitylimit(),10,"Click on Liability Limit");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getLiabilityLimit(),"Liability Limit");
			
			buttonClick(driver,objectrepository.getdpdDeductiblelimit(),10,"Click on Deductible Limit");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getDeductible(),"Deductible");
			
			 if(objGlLoadManager.getAI().equalsIgnoreCase("Yes")) {
				    buttonClick(driver,objectrepository.getrbAdditionalInsuredsYes(),10,"Additional Insurance as Yes");
	            } else {
	            	buttonClick(driver,objectrepository.getrbAdditionalInsuredsNo(),10,"Additional Insurance as No");
	            }
			 
			 
			 if(objGlLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
				   buttonClick(driver,objectrepository.getrbWaiversYes(),10,"Waivers as Yes");
	            } else {
	            	buttonClick(driver,objectrepository.getrbWaiversNo(),10,"Waivers as No");
	            }
			 
			 sendKeysToTextField(driver,objectrepository.gettxtNoofLocation(),objGlLoadManager.getLocationAgregate(),"No of Location");
			 sendKeysToTextField(driver,objectrepository.gettxtNoofProject(),objGlLoadManager.getProjectAgregate(),"No of Project");
			 
			 if(objGlLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
				   buttonClick(driver,objectrepository.getrbInlandMarineYes(),10,"Inland Marine as Yes");
	            } else {
	            	buttonClick(driver,objectrepository.getrbInlandMarineNo(),10,"Inland Marine as No");
	            }
			 
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");   
			 
			 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 System.out.println("Risk Level have been completed Sucessfully");
			 AutomationUtilities.LogSummary(LogPath,"Risk Level have been completed Sucessfully");
		
	}
		public void classPayroll(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			String[] ClassCode = objGlLoadManager.getClassCode().split("/");
			int classcodecount = ClassCode.length;
			if(classcodecount > 1) {
			int Eprecentage = 100/classcodecount;
			for(int i=0;i<classcodecount;i++) {
				
				buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),ClassCode[i],"Class Codes");
				buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				
				if(i == classcodecount-1) {
					
					Eprecentage = 100 - (Eprecentage*i);  
				}
				driver.findElement(By.xpath("//td[@data-fieldid ='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td//input[@class='dynamicAdd form-control'][@name='percentage']")).sendKeys(Integer.toString(Eprecentage));
				AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			}
			}
			else {
				
				buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getClassCode(),"Class Codes");
				buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				
		       
			}
			
			sendKeysToTextField(driver,objectrepository.gettxtExpectedGrossAmount(),objGlLoadManager.getExpectedGrossReceipts(),"Expected Gross Amount");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(!objGlLoadManager.getSubClassCode().isEmpty()) {
			
			sendKeysToTextField(driver,objectrepository.getInSubcontractorCost(),objGlLoadManager.getSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(driver,objectrepository.getSubcontractorCostopdes(),"OK-Approved", "Sub Contractor Description");
			
			buttonClick(driver,objectrepository.getSubClasscodes(),10," Click Sub Class Code");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getSubClassCode(),"Sub Class Codes");
			
			buttonClick(driver,objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
			sendKeysToTextField(driver,objectrepository.getSubClasscodePercentage(),"100","Percentage");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			}

			sendKeysToTextField(driver,objectrepository.getUnSubcontractorCost(),objGlLoadManager.getSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(driver,objectrepository.gettxtActivePartner(),objGlLoadManager.getActiveOwner(),"Active Owner");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(!(classcodecount > 1)) {
				
			    sendKeysToTextField(driver,objectrepository.getClasscodePercentage(),"200","Enter Percentage");
			    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			    
			    buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			
			if(objectrepository.getbtnClose().isEnabled()) {
				
				System.out.println("Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");
				AutomationUtilities.LogSummary(LogPath,"Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");	
				Thread.sleep(6000);
				
				buttonClick(driver,objectrepository.getbtnClose(),10,"Click on Button Close");
				sendKeysToTextField(driver,objectrepository.getClasscodePercentage(),"100","Percentage");
				AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			  }
			}
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			System.out.println("Class & Payroll have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Class & Payroll have been completed Sucessfully");				
		}
		
		public void AI(WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("window.scrollBy(0,1000)");
			
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
			System.out.println("Aditional Insured have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Aditional Insured have been completed Sucessfully");
		}
		
		public void IM(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
	        	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // no button
	        }
	        
	        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        buttonClick(driver,objectrepository.getdpdinstallationfloater(),10,"Click on Installation Floater Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getInstallationFloater(),"Installation Floater have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdContractorHandtools(),10,"Click on Contractor's Hand Tools Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Contractor's Hand Tools have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdleasedequipment(),10,"Click on Leased Equipment Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Click on Leased Equipment Drop down");
	        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
	        System.out.println("Inland Marine have been completed Sucessfully");
	        AutomationUtilities.LogSummary(LogPath,"Inland Marine have been completed Sucessfully");
	        
		}
		

	public void ClassSpecificQues (WebDriver driver,String testcasePath,String QAns) throws Exception {
        
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  if (QAns.equalsIgnoreCase("No")) {
			  
			    String xpath = "//tr[@class='visibleTr']";

	        	for (int i =1; i<=LastQCount(driver,xpath);i++) {
	       
	        		QClassSpecACount = driver.findElement(By.xpath("//tr[@class='visibleTr']["+i+"]")).getAttribute("id").toString();
	        		
	        		
	        		QClassSpecValue = driver.findElement(By.xpath("//tr[@id='"+QClassSpecACount+"']/td[5]")).getText().toString();
	        		
	        		System.out.println("Class Specific Question "+i+" :"+QClassSpecValue);
	        		AutomationUtilities.LogSummary(LogPath,"Class Specific Question "+i+" :"+QClassSpecValue);
	        		
	        		String [] Qvalue = QClassSpecValue.split(":");
	        		Qvalue[1] = Qvalue[1].replaceFirst(" ","");
	        		
	        		AutomationUtilities.ExcelUpdateClassSpecificQuestion(testcasePath, "TD_CSQ", Qvalue[0], i ,"Actual Class Code");
	        		AutomationUtilities.ExcelUpdateClassSpecificQuestion(testcasePath, "TD_CSQ", Qvalue[1], i ,"Primary Underwriting Question (Actual)");
	        		
	        		AutomationUtilities.ReadClassSpecificQuestion (testcasePath,"TD_CSQ",Qvalue[1],LogPath,"Primary Underwriting Question (Expected)" );
	        		
	        		driver.findElement(By.xpath("//tr[@class='visibleTr']//td[contains(text(),'Question')]//parent :: tr// following-sibling :: td//input[contains(@name,'question"+QClassSpecACount+"')]//parent :: div//label[starts-with(@for,'radio-')]")).click(); // no button
	        	}
		  }	
        
        AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
        buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
        
        System.out.println("Class Specific have been completed Sucessfully");
        AutomationUtilities.LogSummary(LogPath,"Class Specific have been completed Sucessfully");
	}

	public void Quote (LoadManager objGlLoadManager,LoginPage objGLloginpage,Underwriting objGLunderwriting,HomePage objhomepage, WebDriver driver) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		
     Thread.sleep(20000);
     
     if(objGlLoadManager.getTCScenarios().equalsIgnoreCase("Referral Flow")) {
    	
    	 sendKeysToTextField(driver,objectrepository.gettxtRefferal(),"OK-Approved for Refferal","Refferal Reason");
    	 buttonClick(driver,objectrepository.getBtnDoneRefferal(),10,"Click on Refferal (Done button)");
    	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objGLloginpage.AgentSignOut (driver);
    	 objGLloginpage.UWlogin(driver);
    	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objGLunderwriting.UnderwritingSearch(driver);
    	 objGLunderwriting.UWChangeStatus(driver);
    	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 
    	 objGLloginpage.UWSignOut(driver);
    	 objGLloginpage.Agentlogin(driver);
    	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objhomepage.SelectAgent(driver,objGlLoadManager.getAgentName()); 
		 AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
			
    	 objGLunderwriting.AgentSearch(driver);
    	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     }
		
     Thread.sleep(15000);
     
     System.out.println("Quote Date: "+ objectrepository.getlbl_QuoteDate().getText());
     AutomationUtilities.LogSummary(LogPath,"Quote Date : "+ objectrepository.getlbl_QuoteDate().getText());
     AutomationUtilities.QuoteDate = objectrepository.getlbl_QuoteDate().getText();
     
     System.out.println("Term: "+ objectrepository.getlbl_Term().getText());
     AutomationUtilities.LogSummary(LogPath,"Term: "+ objectrepository.getlbl_Term().getText());
     
     System.out.println("County Name: "+ objectrepository.getlbl_CountyTerritory().getText());
     AutomationUtilities.LogSummary(LogPath,"County Name: "+ objectrepository.getlbl_CountyTerritory().getText());
     String[] CountyCode =objectrepository.getlbl_CountyTerritory().getText().split("/");
     AutomationUtilities.CountyCode =CountyCode[1];
     
     System.out.println("Insured Name: "+ objectrepository.getlbl_InsuredName().getText());
     AutomationUtilities.LogSummary(LogPath,"Insured Name: "+ objectrepository.getlbl_InsuredName().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
			sendKeysToTextField(driver,objectrepository.gettxt_ProducerFee(),"100","Enter Producer Fee");
			buttonClick(driver,objectrepository.getbtn_SaveProducerFee(),10,"Click on Button Save");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			Thread.sleep(6000);
			buttonClick(driver,objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
			AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     }
     
     buttonClick(driver,objectrepository.getlnk_DownloadFWCIQuote(),30,"Click on FWCI Quote Link");
     AutomationUtilities.Traverse(driver,"FWCI Quote Doc");
     System.out.println("Download FWCI Quote Document is clicked sucessfully");
     AutomationUtilities.LogSummary(LogPath,"Download FWCI Quote Document is clicked sucessfully");
     
     buttonClick(driver,objectrepository.getlnk_DownloadCBQuote(),10,"Click on CB Quote Link");
     AutomationUtilities.Traverse(driver,"CB Quote Doc");
     System.out.println("Download CB Quote Document is clicked sucessfully");
     AutomationUtilities.LogSummary(LogPath,"Download CB Quote Document is clicked successfully");
     
     System.out.println("FWCI Premium: "+ objectrepository.getlbl_FWCIPremium().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI Premium: "+ objectrepository.getlbl_FWCIPremium().getText());
     AutomationUtilities.FWCIPremium = objectrepository.getlbl_FWCIPremium().getText();
     
     System.out.println("FWCI MGA Policy Fee: "+ objectrepository.getlbl_FWCIMGAPolicyFee().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI MGA Policy Fee: "+ objectrepository.getlbl_FWCIMGAPolicyFee().getText());
     AutomationUtilities.FWCIMGAPolicyFee = objectrepository.getlbl_FWCIMGAPolicyFee().getText();
     
     System.out.println("CB Premium: "+ objectrepository.getlbl_CBPremium().getText());
     AutomationUtilities.LogSummary(LogPath,"CB Premium: "+ objectrepository.getlbl_CBPremium().getText());
     AutomationUtilities.CBPremium = objectrepository.getlbl_CBPremium().getText();
     
     System.out.println("CB MGA Policy Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.LogSummary(LogPath,"CB MGA Policy Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.CBMGAPolicyFee = objectrepository.getlbl_CBMGAPolicyFee().getText();
     
     if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
     System.out.println("FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
     AutomationUtilities.LogSummary(LogPath,"FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
     AutomationUtilities.FWCIProducerFee = objectrepository.getlbl_FWCIProducerFee().getText();
     
     System.out.println("CB Producer Fee: "+ objectrepository.getlbl_CBProducerFee().getText());
     AutomationUtilities.LogSummary(LogPath,"CB Producer Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
     AutomationUtilities.CBProducerFee = objectrepository.getlbl_CBProducerFee().getText();
     
	  }
     
     if(objGlLoadManager.getTypeofCompany().equalsIgnoreCase("FWCI")) {
    	 
    	 buttonClick(driver,objectrepository.getrdo_FWCIbutton(),10,"Click on FWCI Insurance Company");
         System.out.println("Click on FWCI Insurance Company");
         AutomationUtilities.LogSummary(LogPath,"Click on FWCI Insurance Company");
         
     }else {
    	 
         buttonClick(driver,objectrepository.getrdo_CBbutton(),10,"Click on CB Insurance Company");
         System.out.println("Click on CB Insurance Company");
         AutomationUtilities.LogSummary(LogPath,"Click on CB Insurance Company");
         
     }
     
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     buttonClick(driver,objectrepository.getbtn_ICSavebutton(),10,"Click on Save Insurance Company");
     
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     Thread.sleep(3000);
     
	 buttonClick(driver,objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
	 AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	 
	 AutomationUtilities.QuoteNo = objectrepository.getlbl_QuoteNo().getText();
	 System.out.println("Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     AutomationUtilities.LogSummary(LogPath,"Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
	 buttonClick(driver,objectrepository.getbtn_Appbutton(),10,"Click on Application Button");
     System.out.println("Click on Application Button");
     AutomationUtilities.LogSummary(LogPath,"Click on Application Button");
     AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     System.out.println("Quote Page have been completed Sucessfully");
     AutomationUtilities.LogSummary(LogPath,"Quote Page have been completed Sucessfully");
     
	}

	public void Application (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException, UnsupportedFlavorException {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = new Date();
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, 35);
	    
		EsendKeysToTextField(driver,objectrepository.gettxtApplicationDate(),dateFormat.format(date),"Effective Date");
		System.out.println("Application Date of the Quote is :"+dateFormat.format(date));
	    AutomationUtilities.LogSummary(LogPath,"Application Date of the Quote is :"+dateFormat.format(date));
	     
	    buttonClick(driver,objectrepository.getdpdBusinessType(),10,"Business Type Name dropdown is clicked");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getBusinessType(),"Business Type Name is entered");
		
		String sInspectionName = "Inspector -"+ AutomationUtilities.getRandomString (9);
		sendKeysToTextField(driver,objectrepository.gettxtcontactforinspection(),sInspectionName,"Enter contact for inspection");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    
		sendKeysToTextField(driver,objectrepository.gettxtFristAddressline(),objGlLoadManager.getFristAddressline(),"Enter 1st line of Address"); 
        sendKeysToTextField(driver,objectrepository.gettxtSecAddressline(),objGlLoadManager.getSecAddressline(),"Enter 2nd line of Address");
		sendKeysToTextField(driver,objectrepository.gettxtLocationCity(),objGlLoadManager.getLocationCity(),"Enter City Name");
		sendKeysToTextField(driver,objectrepository.gettxtLocationZipCode(),objGlLoadManager.getLocationZipCode(),"Enter Zip Code");
		
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		if(objectrepository.getUseasis().isDisplayed()) {
			
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
			}
		
		sendKeysToTextField(driver,objectrepository.gettxtBusinessPhone(),objGlLoadManager.getBusinessPhone(),"Enter Business Phone Number");
		sendKeysToTextField(driver,objectrepository.gettxtBusinessEmail(),objGlLoadManager.getBusinessEmail(),"Enter Business Emails");

		String FEIN = AutomationUtilities.getRandomString (9);
		sendKeysToTextField(driver,objectrepository.gettxtBusinessFEINSSN(),FEIN,"Enter Business FEIN");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		 
		buttonClick(driver,objectrepository.getchkSameAddress(),10,"Click on Same Address check box");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
		sendKeysToTextField(driver,objectrepository.gettxtExpirationDate(),dateFormat.format(cal.getTime()),"Enter Business Expiration Date");  
		sendKeysToTextField(driver,objectrepository.gettxtInsuranceCarrier(),objGlLoadManager.getTypeofCompany(),"Enter Insurance Carrier");
		
		if(!objGlLoadManager.getLocationAgregate().equalsIgnoreCase("0")) {
			
			for(int i =1;i<=Integer.valueOf(objGlLoadManager.getLocationAgregate());i++) {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2504_"+i+"']")).sendKeys("CG2504_"+i);
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2504_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2504_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2504_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
		}
		
        if(!objGlLoadManager.getProjectAgregate().equalsIgnoreCase("0")) {
			
			for(int i =1;i<=Integer.valueOf(objGlLoadManager.getProjectAgregate());i++) {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2503_"+i+"']")).sendKeys("CG2503_"+i);
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2503_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2503_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2503_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
		}		
		
		sendKeysToTextField(driver,objectrepository.gettxtGeneralRemarks(),"OK - Approved","Enter Insurance Carrier");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		  
		sendKeysToTextField(driver,objectrepository.gettxtIndustrial(),"100","Enter Industrial Percentage");
		sendKeysToTextField(driver,objectrepository.gettxtNewConstruction(),"100","Enter New Construction Percentage");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(driver,objectrepository.getrdoPerformContractYes(),10,"Click on Perform Contract as Yes");
		sendKeysToTextField(driver,objectrepository.gettxtWorkSubcontracted(),"OK - Approved","Enter New Construction Percentage");
		buttonClick(driver,objectrepository.getrdoRequireCertificatesGLYes(),10,"Click on Perform Contract as Yes");
		buttonClick(driver,objectrepository.getrdoRequireCertificatesWCYes(),10,"Click on Perform Contract as Yes");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(driver,objectrepository.getrdoAgree(),10,"Click on Agree radio button");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(driver,objectrepository.getbtnPrintSubmit(),10,"Click on Print & Submit Application");
		Thread.sleep(15000);
		
		AutomationUtilities.Traverse(driver,"Download Application Document");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    buttonClick(driver,objectrepository.getGLMakePayment(),10,"Click on Make Payment");
		
	    System.out.println("Application Page have been completed Sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Application Page have been completed Sucessfully");
	
	}
	
	public void PolicyIssue (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
		
		Thread.sleep(10000);
		
		/*************NEW CODE START**************/
		WebElement element = objectrepository.getchkIssue_Line1();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('chkIssue_1').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_2').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		executor.executeScript("document.getElementById('chkIssue_3').click();", element);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		/*************NEW CODE ENDS**************/
		
		System.out.println("PaymentOption is:>>>>>" +objGlLoadManager.getPaymentOption());
		AutomationUtilities.ClickPaymentOptions(driver,objectrepository,objGlLoadManager.getPaymentOption());
		
		buttonClick(driver,objectrepository.getdpddepositpaymentmethod(),10,"Click on Deposit Payment Method");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getDepositPaymentMethod(),"Deposit Payment Method");
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Check")) {
			
			buttonClick(driver,objectrepository.getclkCheckPayment(),10,"Click on Check Issue Policy");
		
		}else if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Online")) {
			
			buttonClick(driver,objectrepository.getclkOnlinePayment(),10,"Click on Online Issue Policy");
			
		}else {
			
			buttonClick(driver,objectrepository.getclkPremiumFinancePayment(),10,"Click on Premium Finance Issue Policy");
		}
		
		Thread.sleep(25000);
		AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		buttonClick(driver,objectrepository.getlnkDownloadEvidence(),10,"Clickon EOI Document");
		
		AutomationUtilities.Traverse(driver,"EOI Document");
	    AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		
		AutomationUtilities.PolicyNo =objectrepository.gettxtPolicyNumber().getText() ;
		AutomationUtilities.LogSummary(LogPath,"GL Policy Number :"+AutomationUtilities.PolicyNo);
		AutomationUtilities.LogSummary(LogPath,"Policy Issuance is completed successfully");
	}
	
	public void WriteGLQuoteDetails (String testcasePath, String TCSheetName,LoadManager objGlLoadManager) {
		
	AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.sBusinessName, objGlLoadManager,
			"Insured Name");
	AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.QuoteDate, objGlLoadManager,
			"Quote Date");
	AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.QuoteNo, objGlLoadManager,
			"Quote No.");
	AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.CountyCode, objGlLoadManager,
			"County Code");
	
	 if(objGlLoadManager.getTypeofCompany().equalsIgnoreCase("FWCI")) {
	
	      AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.FWCIPremium, objGlLoadManager,
			"FWCI Premium");
	      AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.FWCIMGAPolicyFee, objGlLoadManager,
					"FWCI MGA Policy Fee");
	 } else {
		 
		 AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.CBPremium, objGlLoadManager,
					"CB Premium");
		 AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.CBMGAPolicyFee, objGlLoadManager,
					"CB MGA Policy Fee");
	 }
	 
	 if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
		 
		 if(objGlLoadManager.getTypeofCompany().equalsIgnoreCase("FWCI")) {
			 AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.FWCIProducerFee, objGlLoadManager,
						"FWCI Producer Fee");
		 }else {
			 AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.CBProducerFee, objGlLoadManager,
						"CB Producer Fee");
		 }
	 }
}	 
}