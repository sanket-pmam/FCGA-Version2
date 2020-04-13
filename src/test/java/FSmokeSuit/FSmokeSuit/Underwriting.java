package FSmokeSuit.FSmokeSuit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
	
	public void UWChangeStatus (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
		waitforpageload(driver, 15);
		
		AutomationUtilities.sReferralReason = objectrepository.getUWReferralReason().getText();
		AutomationUtilities.LogSummary(LogPath, "Referral Reason is : " +objectrepository.getUWReferralReason().getText());
		//System.out.println(objectrepository.getUWReferralReason().getText());
			
		buttonClick(driver,objectrepository.getUWCurrentStatus(),10,"UW Current Status");
		
		if(objUWGLLoadManager.getUWQuoteStatus().equalsIgnoreCase("Accepted")) {
			buttonClick(driver,objectrepository.getUWAcceptedStatus(),10,"UW Accepted Status");
		}else if(objUWGLLoadManager.getUWQuoteStatus().equalsIgnoreCase("Submitted")) {
			buttonClick(driver,objectrepository.getUWSubmittedStatus(),10,"UW Submitted Status");
		}else if(objUWGLLoadManager.getUWQuoteStatus().equalsIgnoreCase("Declined")) {
			buttonClick(driver,objectrepository.getUWDeclinedStatus(),10,"UW Declined Status");
		}else if(objUWGLLoadManager.getUWQuoteStatus().equalsIgnoreCase("In Progress")) {
			buttonClick(driver,objectrepository.getUWInProgressStatus(),10,"UW In Progress Status");
		}
		
		buttonClick(driver,objectrepository.getUWbtnReRate(),60,"UW Re Rate button");
		Thread.sleep(3000);
		AutomationUtilities.LogSummary(LogPath, "Alert Message in PopUp : "+ objectrepository.getUWAlertMsgBox().getText());
		buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
		
		UWNotes(driver, objUWGLLoadManager.getUWNotes());
		UWMessages(driver, objUWGLLoadManager.getUWMessages());
		
//------- UW Document --------------		
		buttonClick(driver,objectrepository.getUWdocs(),10,"Documents");
		//buttonClick(driver,objectrepository.getUWotherdocs(),10,"Other Documents");
		//buttonClick(driver,objectrepository.getUWdocsupload(),10,"Documents");
		buttonClick(driver,objectrepository.getUWbtnExit(),10,"Exit is Clicked");
	
	}
	
	public void AgentSearch (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
		waitforpageload(driver, 5);
		sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.sBusinessName,"Frist Name");
		buttonClick(driver,objectrepository.getbtnSearch(),20,"Search Record");
		AutomationUtilities.ActionMessages(driver,objectrepository,"Thanks");
		buttonClick(driver,objectrepository.getbtnAction(),10,"Action");
		buttonClick(driver,objectrepository.getbtnEditQuote(),10,"Edit Quote");
		waitforpageload(driver, 30);

}
	
public void UWGLEditQuote (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
	    waitforpageload(driver, 30);
		
		buttonClick(driver,objectrepository.getUWGLEditQuote(),20,"Underwriting Edit Quote");

	// ------- GateKeeper --------
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		//System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
	
  // -----	Risk level --------
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		//System.out.println(objectrepository.getUWLblPage().getText());
		
		
		if(objUWGLLoadManager.getUWModifyRiskLPerm().equalsIgnoreCase("Yes")) {
			
			if(!objUWGLLoadManager.getUWModifyState().isBlank()) {
			   buttonClick(driver,objectrepository.getdpdstate(),10,"Click on State");
		       EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyState(),"State Name");
			}
			
			if(!objUWGLLoadManager.getUWModifyCounty().isBlank()) {
			   buttonClick(driver,objectrepository.getdpdCounty(),10,"Click on County");
			   EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyCounty(),"County Name");
			}
			
			if(!objUWGLLoadManager.getUWModifyBName().isBlank()) {
				
				sendKeysToTextField(driver,objectrepository.gettxtBusinessName(),AutomationUtilities.sBusinessName,"Business Name");
				
			}else if(!objUWGLLoadManager.getUWModifyFName().isBlank()){
				
				sendKeysToTextField(driver,objectrepository.gettxtIndividualFirstName(),objUWGLLoadManager.getUWModifyFName(),"Frist Name");
				sendKeysToTextField(driver,objectrepository.gettxtIndividualLastName(),objUWGLLoadManager.getUWModifyLName(),"Last Name");
				
			}else  {		
		     
				AutomationUtilities.LogSummary(LogPath, "No Change in Business Name ");
		  }
		
		if(!objUWGLLoadManager.getUWModifyLL().isBlank()) {
			
			 buttonClick(driver,objectrepository.getdpdliabilitylimit(),10,"Click on Liability Limit");
			 EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyLL(),"Liability Limit");
				
		}
           
		if(!objUWGLLoadManager.getUWModifyDeductible().isBlank()) {
			
			buttonClick(driver,objectrepository.getdpdDeductiblelimit(),10,"Click on Deductible Limit");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyDeductible(),"Deductible");
		
		  }
		}
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),15,"Click on Save and Continue");
		
	//------------- Class and Payroll ----------	
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWClassPayroll().getText());
		//System.out.println(objectrepository.getUWClassPayroll().getText());
		
	 if (objUWGLLoadManager.getUWModifyClassPay().equalsIgnoreCase("Yes")) {
		 
		 UWclassPayroll(objUWGLLoadManager,driver);
	 }
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
	
	//------------- Additional Insured ----------
		
		if (objUWGLLoadManager.getAI().equalsIgnoreCase("Yes")
				|| objUWGLLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
			
			AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWAdditionalInsured().getText());
			//System.out.println(objectrepository.getUWAdditionalInsured().getText());
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),15,"Click on Save and Continue");

			
		} else {
			
			//System.out.println("Additional Insured and Wavier is selected as No.");
			AutomationUtilities.LogSummary(LogPath, "Additional Insured and Wavier is selected as No.");
		}
		
	//------------- Inland Marine ----------
		
		if (objUWGLLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
			
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		//System.out.println(objectrepository.getUWLblPage().getText());
		
		buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		}
		
	//------------------ Class Specific Question ----------
		
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		//System.out.println(objectrepository.getUWLblPage().getText());
		
		if(objUWGLLoadManager.getUWModifyClassSpecificQ().equalsIgnoreCase("Yes")) {
				  
			    String xpath = "//tr[@class='visibleTr']";
			    ArrayList<String> UWQuestionArray = new ArrayList<String>();
			    String testcasePath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TESTCASE_PATH");
			    
	        	for (int i =1; i<= GeneralLiability.LastQCount(driver,xpath);i++) {
	       
	        		String UWQClassSpecACount = driver.findElement(By.xpath("//tr[@class='visibleTr']["+i+"]")).getAttribute("id").toString();
	        		
	        		String UWQClassSpecValue = driver.findElement(By.xpath("//tr[@id='"+UWQClassSpecACount+"']/td[5]")).getText().toString();
	        		
	        		//System.out.println("Class Specific Question "+i+" :"+QClassSpecValue);
	        		AutomationUtilities.LogSummary(LogPath,"Class Specific Question "+i+" :"+UWQClassSpecValue);
	        		String [] Qvalue = UWQClassSpecValue.split(":");
	        		Qvalue[1] = Qvalue[1].replaceFirst(" ","");
	        		UWQuestionArray.add(Qvalue[1]);
	        
	        		AutomationUtilities.CheckDuplicateQuestions(UWQuestionArray,Qvalue[1]);
	        		AutomationUtilities.ReadWriteClassSpecificQuestion (testcasePath,"TD_CSQ",i,AutomationUtilities.tcCount,Qvalue[1],LogPath,"Primary Underwriting Question (Expected)" );
	        		driver.findElement(By.xpath("//tr[@class='visibleTr']//td[contains(text(),'Question')]//parent :: tr// following-sibling :: td//input[contains(@name,'question"+UWQClassSpecACount+"')]//parent :: div//label[starts-with(@for,'radio-')]")).click(); // no button
	        	}
		  }
		
		buttonClick(driver,objectrepository.getUWBtnSave(),10,"Click on Save and Continue");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
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


public void UWclassPayroll(LoadManager objUWGLLoadManager, WebDriver driver) throws InterruptedException, IOException {
	
	AutomationUtilities.sClassCode = objUWGLLoadManager.getUWModifyMainClasscode();
	AutomationUtilities.sSubClassCode = objUWGLLoadManager.getSubClassCode();
	String[] ClassCode = objUWGLLoadManager.getClassCode().split("/");
	String[] UWClassCode = objUWGLLoadManager.getUWModifyMainClasscode().split("/");
	String[] SubClassCode = objUWGLLoadManager.getSubClassCode().split("/");
	String[] UWSubClassCode = objUWGLLoadManager.getUWModifySubClasscode().split("/");
	int classcodecount = UWClassCode.length;
	int subclasscodecount = UWSubClassCode.length;
	if(classcodecount > 1) {
	int Eprecentage = 100/classcodecount;
	for(int i=0;i<classcodecount;i++) {
		
		if(!ClassCode[i].isEmpty()) {
		driver.findElement(By.xpath("//td[@data-fieldid='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td/a[@id='aDeleteRow']")).click();
		}
		
		buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),UWClassCode[i],"Class Codes");
		buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
		AutomationUtilities.sClassCodeDesc = AutomationUtilities.sClassCodeDesc + driver.findElement(By.xpath("//td[@data-fieldid='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
        System.out.println("Class Code Desc : "+ AutomationUtilities.sClassCodeDesc);
		
        if(i == classcodecount-1) {
			
			Eprecentage = 100 - (Eprecentage*i);  
		}
		driver.findElement(By.xpath("//td[@data-fieldid ='"+UWClassCode[i]+"']//parent :: tr// following-sibling :: td//input[@class='dynamicAdd form-control'][@name='percentage']")).sendKeys(Integer.toString(Eprecentage));
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	}
	}
	else {
		
		driver.findElement(By.xpath("//td[@data-fieldid='"+objUWGLLoadManager.getClassCode()+"']//parent :: tr// following-sibling :: td/a[@id='aDeleteRow']")).click();
		
		buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyMainClasscode(),"Class Codes");
		buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
		AutomationUtilities.sClassCodeDesc = driver.findElement(By.xpath("//td[@data-fieldid='"+objUWGLLoadManager.getUWModifyMainClasscode()+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
		sendKeysToTextField(driver,objectrepository.getClasscodePercentage(),"100","Percentage");
       
	}
	
	if(!objUWGLLoadManager.getUWModifyExpectedGross().isBlank()) {
	sendKeysToTextField(driver,objectrepository.gettxtExpectedGrossAmount(),objUWGLLoadManager.getUWModifyExpectedGross(),"Expected Gross Amount");
	//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	}
	
	if(!objUWGLLoadManager.getUWModifySubClasscode().isEmpty()) {
		
		AutomationUtilities.sClassCode = objUWGLLoadManager.getUWModifyMainClasscode()+","+objUWGLLoadManager.getUWModifySubClasscode();
		if(!objUWGLLoadManager.getUWModifySubContractorGross().isBlank()) {
			sendKeysToTextField(driver,objectrepository.getInSubcontractorCost(),objUWGLLoadManager.getUWModifySubContractorGross(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(driver,objectrepository.getSubcontractorCostopdes(),"OK-Approved", "Sub Contractor Description");
			}
		if(subclasscodecount > 1) {
			
			int Eprecentage = 100/subclasscodecount;
			for(int i=0;i<subclasscodecount;i++) {

				if(!SubClassCode[i].isEmpty()) {
				driver.findElement(By.xpath("//td[@data-fieldid='"+SubClassCode [i]+"']//parent :: tr// following-sibling :: td/a[@id='aDeleteRow']")).click();
				}
				buttonClick(driver,objectrepository.getSubClasscodes(),10," Click Sub Class Code");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),UWSubClassCode [i],"Sub Class Codes");
				
                if(i == subclasscodecount-1) {
					
					Eprecentage = 100 - (Eprecentage*i);  
				}
                
				buttonClick(driver,objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
				sendKeysToTextField(driver,objectrepository.getSubClasscodePercentage(),Integer.toString(Eprecentage),"Percentage");
			  }
			}
		else {
	
	      driver.findElement(By.xpath("//td[@data-fieldid='"+objUWGLLoadManager.getSubClassCode()+"']//parent :: tr// following-sibling :: td/a[@id='aDeleteRow']")).click();
	
	      buttonClick(driver,objectrepository.getSubClasscodes(),10," Click Sub Class Code");
	      EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifySubClasscode(),"Sub Class Codes");
	
	      buttonClick(driver,objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
	      driver.findElement(By.xpath("//td[@data-fieldid='"+objUWGLLoadManager.getUWModifySubClasscode()+"']//parent :: tr// following-sibling :: td//input[@class='dynamicAddClassCode form-control'][@name='percentage']")).sendKeys("100");
	      //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	     AutomationUtilities.sClassCodeDesc = AutomationUtilities.sClassCodeDesc +"/"+ driver.findElement(By.xpath("//td[@data-fieldid='"+objUWGLLoadManager.getUWModifySubClasscode()+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
		}
	} else if(!objUWGLLoadManager.getUWModifyUnSubContractorGross().isBlank()) {

	sendKeysToTextField(driver,objectrepository.getUnSubcontractorCost(),objUWGLLoadManager.getUWModifyUnSubContractorGross(),"Expected Sub Class Code Gross Amount");
	
	} 
	
	if(!objUWGLLoadManager.getUWModifyActiveOwner().isEmpty()) {
	sendKeysToTextField(driver,objectrepository.gettxtActivePartner(),objUWGLLoadManager.getUWModifyActiveOwner(),"Active Owner");
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
