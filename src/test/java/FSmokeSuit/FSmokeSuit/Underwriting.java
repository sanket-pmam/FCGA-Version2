package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Underwriting extends AutomationUtilities {
	
	public ObjectRepository objectrepository = null;
	public static String ClassCode;

	public Underwriting(WebDriver driver)
	{		
      objectrepository = ObjectRepository.getInstance(driver);
	}
	
	public void UnderwritingSearch (WebDriver driver) throws InterruptedException, IOException {
		
		 waitforpageload(driver, 15);
		 sendKeysToTextField(driver,objectrepository.gettxtUWSearch(),AutomationUtilities.sBusinessName,"Business Name is searched");
		 buttonClick(driver,objectrepository.getbtnSearch(),10,"Search Record");
		 waitforpageload(driver, 25);
		 driver.findElement(By.xpath("//a[contains(text(),'"+AutomationUtilities.sBusinessName+"')]")).click();
		 waitforpageload(driver, 15);
	}
	
	public void UWChangeStatus (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
		waitforpageload(driver, 15);
		
		AutomationUtilities.sReferralReason = objectrepository.getUWReferralReason().getText();
		AutomationUtilities.LogSummary(LogPath, "Referral Reason is : " +objectrepository.getUWReferralReason().getText());
		System.out.println(objUWGLLoadManager.getUWQuoteStatus());
			
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

		if(objUWGLLoadManager.getProduct().equalsIgnoreCase("GL") && objUWGLLoadManager.getUWQuoteStatus().equalsIgnoreCase("Declined")) {
			
			String DeclineXpath ="//label[@name ='lblDeclineReasonCheck']";
			for (int i =0; i<GeneralLiability.LastQCount(driver,DeclineXpath)-1;i++) {
				
				driver.findElement(By.xpath("//label[@id='lblDeclineReasonCheck"+i+"1']")).click();
			}
			buttonClick(driver,objectrepository.getUWbtnDeclineContinue(),60,"UW Decline button");
		  }

		Thread.sleep(5000);
		AutomationUtilities.LogSummary(LogPath, "Alert Message in PopUp : "+ objectrepository.getUWAlertMsgBox().getText());
		buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");
		Thread.sleep(2000);
		UWNotes(driver, objUWGLLoadManager.getUWNotes());
		UWMessages(driver, objUWGLLoadManager.getUWMessages());
		
//------- UW Document --------------		
		buttonClick(driver,objectrepository.getUWdocs(),10,"Documents");
		//buttonClick(driver,objectrepository.getUWotherdocs(),10,"Other Documents");
		//buttonClick(driver,objectrepository.getUWdocsupload(),10,"Documents");
		buttonClick(driver,objectrepository.getUWbtnExit(),10,"Exit is Clicked");
	
	}
	
public void AgentSearch (WebDriver driver,LoadManager objUWGLLoadManager, String recordtype) throws InterruptedException, IOException {
		
		waitforpageload(driver, 5);
		
		if (recordtype == "Policy") {
			
			sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.PolicyNo,"Frist Name");
			buttonClick(driver,objectrepository.getbtnSearch(),20,"Search Record");
			buttonClick(driver,objectrepository.getPolicySummaryLink(),20,"Policy Summary");
			AutomationUtilities.GLInsuranceCompany = objectrepository.getInsuranceCompanyName().getText();
			
			if(!AutomationUtilities.XSPolicyNo.isBlank()) {
				
				sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.XSPolicyNo,"Frist Name");
				buttonClick(driver,objectrepository.getbtnSearch(),20,"Search Record");
				buttonClick(driver,objectrepository.getPolicySummaryLink(),20,"Policy Summary");
				AutomationUtilities.XSInsuranceCompany = objectrepository.getInsuranceCompanyName().getText();
				
			}
			
		}else if (recordtype == "Quote") {
			
			sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.sBusinessName,"Frist Name");
			buttonClick(driver,objectrepository.getbtnSearch(),20,"Search Record");
		    AutomationUtilities.ActionMessages(driver,objectrepository,objUWGLLoadManager.getActionMessages());
		    buttonClick(driver,objectrepository.getbtnAction(),10,"Action");
		    buttonClick(driver,objectrepository.getbtnEditQuote(),10,"Edit Quote");
		    
		}else if(objUWGLLoadManager.getChkConvertPolicy().equalsIgnoreCase("Yes")){
			sendKeysToTextField(driver,objectrepository.gettxtAgentSearch(),AutomationUtilities.sBusinessName,"Frist Name");
			buttonClick(driver,objectrepository.getbtnSearch(),20,"Search Record");
		    AutomationUtilities.ActionMessages(driver,objectrepository,objUWGLLoadManager.getActionMessages());
		    buttonClick(driver,objectrepository.getbtnAction(),10,"Action");
			buttonClick(driver,objectrepository.getbtnConvertPolicy(),10,"Convert Policy");
		}
		waitforpageload(driver, 30);

}
	
public void UWGLEditQuote (WebDriver driver,LoadManager objUWGLLoadManager) throws InterruptedException, IOException {
		
	    waitforpageload(driver, 70);
		//Thread.sleep(3000);
		
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
		
		if(objUWGLLoadManager.getUWModifyIM().equalsIgnoreCase("Yes")) {
			
			   buttonClick(driver,objectrepository.getrbInlandMarineYes(),10,"Inland Marine as Yes");
        
		} else {
			
         	buttonClick(driver,objectrepository.getrbInlandMarineNo(),10,"Inland Marine as No");
          }
		if(objUWGLLoadManager.getUWModifyAI().equalsIgnoreCase("Yes")) {
		    buttonClick(driver,objectrepository.getrbAdditionalInsuredsYes(),10,"Additional Insurance as Yes");
        } else {
        	buttonClick(driver,objectrepository.getrbAdditionalInsuredsNo(),10,"Additional Insurance as No");
        }
	 
	 
	 if(objUWGLLoadManager.getUWModifyWS().equalsIgnoreCase("Yes")) {
		   buttonClick(driver,objectrepository.getrbWaiversYes(),10,"Waivers as Yes");
        } else {
        	buttonClick(driver,objectrepository.getrbWaiversNo(),10,"Waivers as No");
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
	    Thread.sleep(4000);
	    
	//------------- Additional Insured ----------
		
		if (objUWGLLoadManager.getUWModifyAI().equalsIgnoreCase("Yes")
				|| objUWGLLoadManager.getUWModifyWS().equalsIgnoreCase("Yes")) {
			
			AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWAdditionalInsured().getText());
			//System.out.println(objectrepository.getUWAdditionalInsured().getText());
			
			if (objUWGLLoadManager.getUWModifyAI().equalsIgnoreCase("No")) {
				if(objUWGLLoadManager.getUWModifyWS().equalsIgnoreCase("Yes")) {
					
					if(!objUWGLLoadManager.getAICG2404().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2404(),objUWGLLoadManager.getUWAICG2404(),"Waiver of Surbogation");
					   }
				   }
				}
				
				if (objUWGLLoadManager.getUWModifyAI().equalsIgnoreCase("Yes")) {
					
					if(objUWGLLoadManager.getUWAIFCG1001().equalsIgnoreCase("Yes")) {
						
						if(!(objUWGLLoadManager.getUWAIFCG1001().equalsIgnoreCase(objUWGLLoadManager.getAIFCG1001()))) {
						
							buttonClick(driver,objectrepository.getrdFCG1001(),10,"Click on FCG1001");
					   }
					}
					if(!objUWGLLoadManager.getUWAICG2010().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2010(),objUWGLLoadManager.getUWAICG2010(),"Enter on CG2010");
					}
					if(!objUWGLLoadManager.getUWAICG2037().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2037(),objUWGLLoadManager.getUWAICG2037(),"Enter on CG2037");
					}
					if(!objUWGLLoadManager.getUWAICG1019().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG1019(),objUWGLLoadManager.getUWAICG1019(),"Enter on CG1019");
					}
					
					if(objUWGLLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
						
						if(!objUWGLLoadManager.getUWAICG2404().equalsIgnoreCase("0")) {
							sendKeysToTextField(driver,objectrepository.getrdCG2404(),objUWGLLoadManager.getUWAICG2404(),"Waiver of Surbogation");
						}
					}
					
					if(!objUWGLLoadManager.getUWAICG2012().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2012(),objUWGLLoadManager.getUWAICG2012(),"Enter on CG2012");
					}
					if(!objUWGLLoadManager.getUWAICG2029().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2029(),objUWGLLoadManager.getUWAICG2029(),"Enter on CG2029");
					}
					if(!objUWGLLoadManager.getUWAICG2028().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2028(),objUWGLLoadManager.getUWAICG2028(),"Enter on CG2028");
					}
					if(!objUWGLLoadManager.getUWAICG2024().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2024(),objUWGLLoadManager.getUWAICG2024(),"Enter on CG2024");
					}
					if(!objUWGLLoadManager.getUWAICG2005().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2005(),objUWGLLoadManager.getUWAICG2005(),"Enter on CG2005");
					}
					if(!objUWGLLoadManager.getUWAICG2011().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2011(),objUWGLLoadManager.getUWAICG2011(),"Enter on CG2011");
					}
					if(!objUWGLLoadManager.getUWAICG2026().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2026(),objUWGLLoadManager.getUWAICG2026(),"Enter on CG2026");
					}
					if(objUWGLLoadManager.getUWAICG2007().equalsIgnoreCase("Yes")) {
						if(!(objUWGLLoadManager.getUWAICG2007().equalsIgnoreCase(objUWGLLoadManager.getUWAICG2007()))) {
							
						   buttonClick(driver,objectrepository.getrdCG2007(),10,"Enter on CG2007");
					   }
					}
				} else {
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,1000)");
					js.executeScript("window.scrollBy(0,1000)");
				}
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),15,"Click on Save and Continue");

			
		} else {
			
			//System.out.println("Additional Insured and Wavier is selected as No.");
			AutomationUtilities.LogSummary(LogPath, "Additional Insured and Wavier is selected as No.");
		}
		
	//------------- Inland Marine ----------
		
		if (objUWGLLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
			
		AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
		//System.out.println(objectrepository.getUWLblPage().getText());
		
		if(objUWGLLoadManager.getUWModifyIM().equalsIgnoreCase("Yes")) {
			
			String ElementNamexpath = "//td[@style= 'display:none'][@class='border-white']";
	        for (int i =1; i<= GeneralLiability.LastQCount(driver,ElementNamexpath);i++) {
	        	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // no button
	        }
	        
	        //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        buttonClick(driver,objectrepository.getdpdinstallationfloater(),10,"Click on Installation Floater Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyInstallationFloater(),"Installation Floater have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdContractorHandtools(),10,"Click on Contractor's Hand Tools Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyContractorsHandTools(),"Contractor's Hand Tools have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdleasedequipment(),10,"Click on Leased Equipment Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objUWGLLoadManager.getUWModifyRentedorLeasedEquipment(),"Click on Leased Equipment Drop down");
	       // AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        
	        if (objUWGLLoadManager.getUWModifyScheduleEquipment().equalsIgnoreCase("Yes") ) {
	        	
	        	String SEDesc [] = objUWGLLoadManager.getScheduleEquipmentDescription().split("/");
	        	String SEAmount [] = objUWGLLoadManager.getScheduleEquipmentDescription().split("/");
	        	int SEDescCount = SEDesc.length;
	        	if(SEDescCount > 1) {
	        	for (int i =1; i<=SEDescCount;i++) {
	        		
	        		buttonClick(driver,objectrepository.getbtnRemoveScheduleEquip(),20," Remove Schedule Equipment");
	        		buttonClick(driver,objectrepository.getbtnScheduleEquip(),20,"Schedule Equipment");
	        		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        		driver.findElement(By.xpath("//td[contains(text(),"+i+")]//parent :: tr// following-sibling :: td//input[@class='form-control EquipmentTB ']")).sendKeys(SEDesc[i]);
	        		driver.findElement(By.xpath("//td[contains(text(),"+i+")]//parent :: tr// following-sibling :: td//input[@name='txtACVLimit']")).sendKeys(SEAmount[i]);
	        	  }
	        	}else {
	        		
	        		buttonClick(driver,objectrepository.getbtnRemoveScheduleEquip(),20," Remove Schedule Equipment");
		        	buttonClick(driver,objectrepository.getbtnScheduleEquip(),20," Add Schedule Equipment");
		        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        	sendKeysToTextField(driver,objectrepository.gettxtScheduleEquipDesc(),objUWGLLoadManager.getUWModifyScheduleEquipmentDescription(),"Schedule Equipment Description");
		        	sendKeysToTextField(driver,objectrepository.gettxtScheduleEquipAcount(),objUWGLLoadManager.getUWModifyScheduleEquipmentAmount(),"Schedule Equipment Amount" );
		        }
	        }
		}
		
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
        
        if(objUWGLLoadManager.getIncludeExcess().equalsIgnoreCase("No")) {
        	
        	buttonClick(driver,objectrepository.getchkAllowExcess(),10,"Allow Excess");
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
	
	if(!objUWGLLoadManager.getUWModifyAdministrativeEmployee().isBlank()) {
		
        if(objUWGLLoadManager.getUWModifyAdministrativeEmployee().length() == 3) {
				
     	    int i=0;
     	    String AdminEmp [] = objUWGLLoadManager.getUWModifyAdministrativeEmployee().split("/");
			sendKeysToTextField(driver,objectrepository.gettxtFTAdminEmp(),AdminEmp[i],"Administrative Employee");
			sendKeysToTextField(driver,objectrepository.gettxtPTAdminEmp(),AdminEmp[i+1],"Administrative Employee");

	        }else if(objUWGLLoadManager.getUWModifyAdministrativeEmployee().length() == 1) {
				
				sendKeysToTextField(driver,objectrepository.gettxtFTAdminEmp(),objUWGLLoadManager.getUWModifyAdministrativeEmployee(),"Administrative Employee");	

			}
        
		sendKeysToTextField(driver,objectrepository.gettotAdmPayroll(),objUWGLLoadManager.getUWModifyAdministrativeEmployeeGrossAtm(),"Administrative Amount");
		
		}
		
		if(!objUWGLLoadManager.getUWModifySalesEmployee().isBlank()) {
        
         if(objUWGLLoadManager.getUWModifySalesEmployee().length() == 3) {
     	   
     	   int i=0;
     	   String SalesEmp[] = objUWGLLoadManager.getUWModifySalesEmployee().split("/");
            sendKeysToTextField(driver,objectrepository.gettxtFTSalesEmp(),SalesEmp[i],"Sales Employee");
            sendKeysToTextField(driver,objectrepository.gettxtPTSalesEmp(),SalesEmp[i+1],"Sales Employee");
            
         }else if(objUWGLLoadManager.getUWModifySalesEmployee().length() == 1) {
				
				sendKeysToTextField(driver,objectrepository.gettxtFTSalesEmp(),objUWGLLoadManager.getUWModifySalesEmployee(),"Sales Employee");	
				
			}
         
         sendKeysToTextField(driver,objectrepository.gettotSalesPayroll(),objUWGLLoadManager.getUWModifySalesEmployeeGrossAtm(),"Sales Amount");
         
		}
		
		if(!objUWGLLoadManager.getUWModifyActiveOwner().isBlank()) {
            
			if(objUWGLLoadManager.getUWModifyActiveOwner().length() == 3) {
				
				int i =0;
				String ActiveOwner[] = objUWGLLoadManager.getUWModifyActiveOwner().split("/");
				sendKeysToTextField(driver,objectrepository.gettxtFTActivePartner(),ActiveOwner[i],"Active Owner");
				sendKeysToTextField(driver,objectrepository.gettxtPTActivePartner(),ActiveOwner[i+1],"Active Owner");
				
			}else if(objUWGLLoadManager.getUWModifyActiveOwner().length() == 1) {
				
				sendKeysToTextField(driver,objectrepository.gettxtFTActivePartner(),objUWGLLoadManager.getUWModifyActiveOwner(),"Active Owner");	
				
			}
		}
			
     if(!objUWGLLoadManager.getUWModifyOtherEmployees().isBlank()) {
     	
     	if(objUWGLLoadManager.getUWModifyOtherEmployees().length() == 3) {
				
         	int i =0;
         	String OtherEmp[] = objUWGLLoadManager.getUWModifyOtherEmployees().split("/");
				sendKeysToTextField(driver,objectrepository.gettxtFTOtherEmp(),OtherEmp[i],"Other Employee");
				sendKeysToTextField(driver,objectrepository.gettxtPTOtherEmp(),OtherEmp[i+1],"Other Employee");
				
			}else if(objUWGLLoadManager.getUWModifyOtherEmployees().length() == 1) {
				
				sendKeysToTextField(driver,objectrepository.gettxtFTOtherEmp(),objUWGLLoadManager.getUWModifyOtherEmployees(),"Other Employee");	
				
			}
         
     	  sendKeysToTextField(driver,objectrepository.gettotOtherPayroll(),objUWGLLoadManager.getUWModifyOtherEmployeesGrossAtm(),"Sales Amount");
     	
		}
}

   
public void UWWCEditQuote (WebDriver driver,LoadManager objUWWCLoadManager, WCIndustrialQ industrialq,String testcasePath) throws IOException, InterruptedException, AWTException {
	
	 waitforpageload(driver, 70);
		//Thread.sleep(3000);
		
		buttonClick(driver,objectrepository.getUWWCEditQuote(),20,"Underwriting Edit Quote");

	//----------- Business Summary -------------
	AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
	//System.out.println(objectrepository.getUWLblPage().getText());
	
	UWBusinessSummary(objUWWCLoadManager,driver);
	
	Thread.sleep(3000);
	buttonClick(driver,objectrepository.getBtnWCNext(), 05, "Next button is saved sucessfully.");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	
	//----------- Questions ------------------
	
	AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
	//System.out.println(objectrepository.getUWLblPage().getText());
	
	if( !objUWWCLoadManager.getWCClassCode().equalsIgnoreCase(objUWWCLoadManager.getWCUWModifyClassCode())){
		
		industrialq.CheckWCIndustrialQ (ClassCode,driver);
	}
	
	Thread.sleep(3000);
	buttonClick(driver,objectrepository.getBtnWCNext(), 05, "Next button is saved sucessfully.");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	
	//----------- Losses ------------------
	
	AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
	//System.out.println(objectrepository.getUWLblPage().getText());
	
	selectDropdownlitag(driver, objectrepository.gethadCoverage(), objUWWCLoadManager.getWCUWModifyhadCoverage(), "Had a coverage Yes/No");
	
	if(objUWWCLoadManager.getWCUWModifyhadCoverage().equalsIgnoreCase("Yes")) {
		
		sendKeysToTextField(driver,objectrepository.gettxtLossCarrier(), objUWWCLoadManager.getWCUWModifyCarierName(), "Loss Page Carrier");
	}
	
	if(objUWWCLoadManager.getWCUWModifyAnyLosses().equalsIgnoreCase("Yes")){
		
		javascriptExecutorClick(driver, objectrepository.rdAnyLossesYes(), "Any Losses Yes/No");
		sendKeysToTextField(driver,objectrepository.gettxtWCclaims(), objUWWCLoadManager.getWCUWModifyClaims(), "Claim No.");
		sendKeysToTextField(driver,objectrepository.gettxtWCincurred(), objUWWCLoadManager.getWCUWModifyTotalIncurred(), "Total Incurred");
		
	}else {
		
		javascriptExecutorClick(driver, objectrepository.rdAnyLossesNo(), "Any Losses Yes/No");
	}
	
	Thread.sleep(3000);	
	buttonClick(driver,objectrepository.btnSubmit(), 10, "Submit Losses");
	
	//------------ Application -------------
	
	AutomationUtilities.LogSummary(LogPath, "Check Page Name: "+ objectrepository.getUWLblPage().getText());
	//System.out.println(objectrepository.getUWLblPage().getText());
	
	
	Thread.sleep(3000);
	
	buttonClick(driver,objectrepository.getUWWCBtnSave(),10,"Click on Save and Continue");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(3000);
	
    if(objUWWCLoadManager.getUWRateType().equalsIgnoreCase("IRPM")) {
		
    	String States [] = objUWWCLoadManager.getWCState().split("/");
		int StatesCount =States.length;
		
		if(StatesCount > 1) {
		for (int i=1; i<=StatesCount; i++) {
			
			String State = ReadStateAbbreviations (testcasePath,"State Abbr",States[i],"US State"); 
			driver.findElement(By.xpath("//tr[@data-val='"+State+"']//input[@id='txtIRPM0']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), objUWWCLoadManager.getUWModifiedRates());
			   
		  }
		}else {
		
			sendKeysToTextField(driver,objectrepository.gettxtUWWCIRPM(),objUWWCLoadManager.getUWModifiedRates(),"IRPM");
		}
	
	}else if(objUWWCLoadManager.getUWRateType().equalsIgnoreCase("CTR")){
		
		buttonClick(driver,objectrepository.getchkConsentToRate(),10,"CTR");
		sendKeysToTextField(driver,objectrepository.gettxtUWIRPMCTR(),objUWWCLoadManager.getUWModifiedRates(),"CTR");
	} else {
		
		AutomationUtilities.LogSummary(LogPath, "IRPM Value is not getting Changed");
		System.out.println("IRPM Value is not getting Changed");
	}

}


public void UWBusinessSummary(LoadManager objUWWCLoadManager, WebDriver driver)
		throws InterruptedException, IOException, AWTException {

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -15);

	
	String States [] = objUWWCLoadManager.getWCUWModifyState().split("/");
	String ClassCodeDesc [] = objUWWCLoadManager.getWCUWModifyClassCodeDesc().split("/");
	int StatesCount =States.length;
	int ClassCodeDescCount = ClassCodeDesc.length;
	int iteration =0;
	if(iteration > 1 ||ClassCodeDescCount > 1 ) {
		
		if(StatesCount > 1) {
		  for(int i=1;i<=StatesCount;i++) {
			
			buttonClick(driver,objectrepository.getbtnWCClear(), 30, "Click on WC Clear");
			buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),States[i], "State Name");
		   }
	}else {
		
		buttonClick(driver,objectrepository.getbtnWCClear(), 30, "Click on WC Clear");	
	    buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
	    EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objUWWCLoadManager.getWCUWModifyState(), "State Name");
	}
		if (ClassCodeDescCount > 1 ) {
			for(int i=1;i<ClassCodeDescCount;i++) {
				
				driver.findElement(By.xpath("//input[@id='txtClassCodes"+i+"']")).sendKeys(ClassCodeDesc[i]);
			}
		} else {
			sendKeysToTextField(driver,objectrepository.gettxtWCClassCodes(), objUWWCLoadManager.getWCUWModifyClassCodeDesc(), "Class Code");
		  }
		buttonClick(driver,objectrepository.getbtnWCContinue(), 10, "Click on Continue");
		iteration = iteration++;
		
		if(!(iteration == ClassCodeDescCount) ||!(iteration==StatesCount)) {
			buttonClick(driver,objectrepository.getbtnWCAddClassCode(),10,"Add Class Code and State");
		}
	}else {
		buttonClick(driver,objectrepository.getWCState(), 10, "Click on State");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objUWWCLoadManager.getWCUWModifyState(), "State Name");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		sendKeysToTextField(driver,objectrepository.gettxtWCClassCodes(), objUWWCLoadManager.getWCUWModifyClassCodeDesc(), "Class Code");
		buttonClick(driver,objectrepository.getbtnWCContinue(), 10, "Click on Continue");
	}

	AutomationUtilities.sClassCode = objUWWCLoadManager.getWCUWModifyClassCode();
	AutomationUtilities.sClassCodeDesc = objUWWCLoadManager.getWCUWModifyClassCodeDesc();
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

	if(!objUWWCLoadManager.getWCUWModifyBusinessName().equalsIgnoreCase("")) {
	  
		AutomationUtilities.sBusinessName =	objUWWCLoadManager.getWCUWModifyBusinessName();
		sendKeysToTextField(driver,objectrepository.gettxtWCBussInsuredName(), AutomationUtilities.sBusinessName, "Business Name");
		System.out.println("Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);
		AutomationUtilities.LogSummary(LogPath, "Insured Name / Business Name is : " + AutomationUtilities.sBusinessName);

	}

	if (!objUWWCLoadManager.getWCUWModifyLegalEntity().equalsIgnoreCase("")) {
		
	    buttonClick(driver,objectrepository.getdpdWCLegalEntity(), 10, "Click on Legal Entity");
	    EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objUWWCLoadManager.getWCUWModifyLegalEntity(), "Legal Entity");
        
	}
	
	if(!objUWWCLoadManager.getWCUWModifyDBAName().equalsIgnoreCase("")) {
	
		sendKeysToTextField(driver,objectrepository.gettxtWCDBAName(), objUWWCLoadManager.getWCUWModifyDBAName(), "Agent Entered DBA Name as Same as Business Name");
	}
	
	if(!objUWWCLoadManager.getWCUWModifyAddress1().equalsIgnoreCase("")) {
	
		sendKeysToTextField(driver,objectrepository.gettxtWCAddress1(), objUWWCLoadManager.getWCUWModifyAddress1(),"Address1");
	}
	
	if(!objUWWCLoadManager.getWCUWModifyAddress2().equalsIgnoreCase("")) {
		
	    sendKeysToTextField(driver,objectrepository.gettxtWCAddress2(), objUWWCLoadManager.getWCUWModifyAddress2(),"Address2");
	}
	
	if(!objUWWCLoadManager.getWCUWModifyCity().equalsIgnoreCase("")) {
	   
		sendKeysToTextField(driver,objectrepository.gettxtWCCity(), objUWWCLoadManager.getWCUWModifyCity(),"City");
	    //AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	}
	/*driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 if(CheckElementPresent(objectrepository.getUseasis()) == true ) {
			AutomationUtilities.SmartyStreet = "No";
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
		}else {
			AutomationUtilities.SmartyStreet = "Yes";
		}*/
    
	 if(!objUWWCLoadManager.getWCUWModifyAddressState().equalsIgnoreCase("")) {
	    
		 buttonClick(driver,objectrepository.getdpdAddressState(), 10, "Click on State");
	     sendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objUWWCLoadManager.getWCUWModifyAddressState(),"AddressState");
	 }
	
	 if(!objUWWCLoadManager.getWCUWModifyZipCode().equalsIgnoreCase("")) {
	   
		 sendKeysToTextField(driver,objectrepository.gettxtWCZipCode(), objUWWCLoadManager.getWCUWModifyZipCode(),"Zipcode");
	 }
	
	//sendKeysToTextField(driver,objectrepository.gettxtWCDateBussinessStart(), dateFormat.format(cal.getTime()),"Bussiness Start Date is entered");
	buttonClick(driver,objectrepository.gettxtWCAddress2(), 10, "Click on Address 2");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

    if(!objUWWCLoadManager.getWCUWModifyAditionalInsured().equalsIgnoreCase("")) {
		
		String[] WCAdditionalInsured = objUWWCLoadManager.getWCUWModifyAditionalInsured().split("/");
		int AICount = WCAdditionalInsured.length;

		if(AICount > 1) {

		for(int i=1;i<=AICount;i++) {
			
			String AddFEIN = AutomationUtilities.getRandomString(9);
			driver.findElement(By.xpath("//input[@id='txtAddinsuredName"+i+"'")).sendKeys(WCAdditionalInsured[i-1]);
			driver.findElement(By.xpath("//input[@id='txtFEINNo"+i+"'")).sendKeys(AddFEIN);
			
			if(i<AICount) {
				buttonClick(driver,objectrepository.getbtnWCAIButton(),10,"Additional Insured");
			}
		  }
		}else {
    	
			String AddFEIN = AutomationUtilities.getRandomString(9);
    	    sendKeysToTextField(driver,objectrepository.gettxtWCAddinsuredName1(), objUWWCLoadManager.getWCUWModifyAditionalInsured(),"Additional Insured Name");
    	    sendKeysToTextField(driver,objectrepository.gettxtWCFEINNo1(),AddFEIN,"Additional FEIN");
	   }
    }
    
	if(!objUWWCLoadManager.getWCUWModifyEmployerLimit().equalsIgnoreCase("")) {
    
    buttonClick(driver,objectrepository.getdpdWCEmployerLimit(), 10, "Click on EmployerLimit");
	EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(), objUWWCLoadManager.getWCUWModifyEmployerLimit(),"Employer Limit");
	sendKeysToTextField(driver,objectrepository.gettxtWCEffectiveDate(), dateFormat.format(date),"Effective date is been entered");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	
	}
	
	if (objUWWCLoadManager.getWCUWModifyExpMod() != null) {
		
		WebElement element = objectrepository.getlblWCrdoCurrExpModYes();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('rdoCurrExpModYes').click();", element);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		sendKeysToTextField(driver,objectrepository.gettxtWCExpMod(), objUWWCLoadManager.getWCExpMod(), "Current Experience Mod is entered");

	} else {

		buttonClick(driver,objectrepository.getlblWCrdoCurrExpModNo(), 10, "Current Experience Mod is selected as No");
	}

	if(objUWWCLoadManager.getUWModifyOwnerPermission().equalsIgnoreCase("Yes")) {
		
		if(Integer.valueOf(objUWWCLoadManager.getUWModifyOwnerCount()) > 1) {
			
			String FristName[] = objUWWCLoadManager.getWCUWModifyFirstName().split("/");
			String LastName[] = objUWWCLoadManager.getWCUWModifyLastName().split("/");
			String OwnerPerct[] = objUWWCLoadManager.getWCUWModifyPerOwner().split("/");
			int OwnerCount = Integer.valueOf(objUWWCLoadManager.getUWModifyOwnerCount());
			
			
			for(int i=1;i<=OwnerCount;i++) {
				
				driver.findElement(By.xpath("//input[@id ='txtFirstName"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),FristName[i-1]);
				driver.findElement(By.xpath("//input[@id ='txtLastName"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),LastName[i-1]);
				driver.findElement(By.xpath("//input[@id ='txtPerOwner"+i+"']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),OwnerPerct[i-1]);
			  
				if(i < OwnerCount && Integer.valueOf(objUWWCLoadManager.getOwnerCount()) < Integer.valueOf(objUWWCLoadManager.getUWModifyOwnerCount())) {
					buttonClick(driver,objectrepository.getbtnWCOWButton(),10,"Owner/Officer");
				}
				
				if (!objUWWCLoadManager.getWCUWModifyInclude().equalsIgnoreCase(objUWWCLoadManager.getWCInclude())) {
					
				   if (objUWWCLoadManager.getWCUWModifyInclude().equalsIgnoreCase("Yes")) {
					
					   driver.findElement(By.xpath("//input[@id='radio"+i+"']")).click();

				    } else {
					
					    driver.findElement(By.xpath("//input[@id='radios"+i+"']")).click();
				    }
				}
			}
			
		}else {
			
			sendKeysToTextField(driver,objectrepository.gettxtWCFirstName(), objUWWCLoadManager.getWCUWModifyFirstName(),"Owner/Officer First Name is been entered");
			sendKeysToTextField(driver,objectrepository.gettxtWCLastName(), objUWWCLoadManager.getWCUWModifyLastName(),"Owner/Officer Last Name is been entered");
			sendKeysToTextField(driver,objectrepository.gettxtWCPerOwner(), objUWWCLoadManager.getWCUWModifyPerOwner(),"Owner/Officer percentage is been entered");
			//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);

			if (objUWWCLoadManager.getWCUWModifyInclude().equalsIgnoreCase("Yes")) {
				
				buttonClick(driver,objectrepository.gettxtWCIncluderd(),10,"Include radio button is clicked");
			
			} else {
				
				buttonClick(driver,objectrepository.gettxtWCExcluderd(), 10, "Exclude radio button is clicked");
			}
		}
	}
	
	if(!objUWWCLoadManager.getWCUWModifyBusinessDescription().equalsIgnoreCase("")) {
		
		sendKeysToTextField(driver,objectrepository.gettxtWCdesc(), objUWWCLoadManager.getWCUWModifyBusinessDescription(), "Description is been entered");
	}
	
	
	if (ClassCodeDescCount > 1 ) {
		
		String WCFTEmployee[] = objUWWCLoadManager.getWCUWModifyFTEmployee().split("/");
		String WCPTEmployee[] = objUWWCLoadManager.getWCUWModifyPTEmployee().split("/");
		String WCGrossannualPayroll[] = objUWWCLoadManager.getWCUWModifyGrossannualPayroll().split("/");
		String WCClassCode [] = objUWWCLoadManager.getWCClassCode().split("/");
		String Payroll = WCGrossannualPayroll[0];
		ClassCode = WCClassCode[0];
		
		for(int i=1;i<ClassCodeDescCount;i++) {
			
			driver.findElement(By.xpath("//input[@id='txtFTEmployee"+i+"']")).sendKeys(WCFTEmployee[i-1]);
			driver.findElement(By.xpath("//input[@id='txtPTEmployee"+i+"']")).sendKeys(WCPTEmployee[i-1]);
			driver.findElement(By.xpath("//input[@id='txtGrossannualPayroll"+i+"']")).sendKeys(WCGrossannualPayroll[i-1]);
			
			if (Integer.valueOf(Payroll) < Integer.valueOf(WCGrossannualPayroll[i])) {
				  
				  Payroll = WCGrossannualPayroll[i];
				  ClassCode = WCClassCode[i];
			  }	
		}
	}else {
			
	sendKeysToTextField(driver,objectrepository.gettxtWCFTEmployee(), objUWWCLoadManager.getWCUWModifyFTEmployee(),"Full time Employee is been entered");
	sendKeysToTextField(driver,objectrepository.gettxtWCPTEmployee(), objUWWCLoadManager.getWCUWModifyPTEmployee(),"Part time Employee is been entered");
	sendKeysToTextField(driver,objectrepository.gettxtWCGrossannualPayroll(), objUWWCLoadManager.getWCUWModifyGrossannualPayroll(),"Gross Annual Payroll is been entered");
	ClassCode = objUWWCLoadManager.getWCClassCode();
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
	}
	if (objUWWCLoadManager.getWCUWModifyInclude().equalsIgnoreCase("Yes")) {
		
	sendKeysToTextField(driver,objectrepository.getWCtxtInOwnClassCode(), objUWWCLoadManager.getWCUWModifyClassCode(), "Include Owner Class code is been entered");
	buttonClick(driver,objectrepository.gettxtOWWCFTEmployee(), 10, "Owner WC FT Employee button is clicked");
	sendKeysToTextField(driver,objectrepository.gettxtOWWCFTEmployee(), objUWWCLoadManager.getWCUWModifyFTEmployee(), "Owner FT Employee is been entered");
	sendKeysToTextField(driver,objectrepository.gettxtOWWCGross(), objUWWCLoadManager.getWCUWModifyOwnGrossannualPayroll(), "Owner FT Employee is been entered");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	}
	
	if(!objUWWCLoadManager.getWCUWModifyInsuredSubContractor().isBlank()) {
		
		sendKeysToTextField(driver,objectrepository.getWCtxtInsuredSubcontract(), objUWWCLoadManager.getWCUWModifyInsuredSubContractor(), "Include Owner Class code is been entered");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		sendKeysToTextField(driver,objectrepository.getWCtxttypeofworkSubcontract(), objUWWCLoadManager.getWCUWModifyTypeofWork(), "Type of Work is been entered");
		
		if(objUWWCLoadManager.getWCUWModifyworkperformed().equalsIgnoreCase("Yes")) {
			
			buttonClick(driver,objectrepository.getWCrdWCworkperformedYes(), 10,"Worked Performed");
		
		}else {
		 
		   buttonClick(driver,objectrepository.getWCrdWCworkperformedNo(), 10, "Worked Performed");		
		}
	   
        if(objUWWCLoadManager.getWCUWModifyproofofWCcoverage().equalsIgnoreCase("Yes")) {
			
			buttonClick(driver,objectrepository.getWCrdoWCCoverageYes(), 10,"WC Coverage");
		
		}else {
		 
		   buttonClick(driver,objectrepository.getWCrdoWCCoverageNo(), 10, "WC Coverage");		
		}
	
	} else if (!objUWWCLoadManager.getWCUWModifyUninsuredSubcontractor().isBlank()) {
		
		sendKeysToTextField(driver,objectrepository.getWCtxtUnInsuredSubcontract(), objUWWCLoadManager.getWCUWModifyUninsuredSubcontractor(), "Include Owner Class code is been entered");
	}
	
	//Thread.sleep(3000);
	//buttonClick(driver,objectrepository.getBtnWCNext(), 05, "Next button is saved sucessfully.");
	//AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
	
	/*if(CheckElementPresent(objectrepository.getUseasis()) == true ) {
		buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
		}*/

	//System.out.println("Business Summary have been completed Successfully");
	//AutomationUtilities.LogSummary(LogPath, "Business Summary have been completed Successfully");
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
