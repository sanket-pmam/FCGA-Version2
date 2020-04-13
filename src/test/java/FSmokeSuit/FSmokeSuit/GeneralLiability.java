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
	ArrayList<String> QuestionArray = new ArrayList<String>();
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
		
		/*for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
    	
    	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // No button 
    }
    	
       buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
       Thread.sleep(2000);
       
       AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
       System.out.println("GateKeeper Validation Message "+ objectrepository.GKAlertMsgBox().getText());
       AutomationUtilities.LogSummary(LogPath,"GateKeeper Validation Message :"+ objectrepository.GKAlertMsgBox().getText());
       
       Thread.sleep(1000);
       buttonClick(driver,objectrepository.gettxtWCClosebtn(), 10, "Close button is saved sucessfully.");*/

    for (int j =1; j<=LastQCount(driver,ElementNamexpath);j++) {
    	if(j==LastQCount(driver,ElementNamexpath)-1)	{
       	 
    	driver.findElement(By.xpath("//label[@for='radio"+(j-1)+"']")).click(); // Yes button 
       }
       else {
    	driver.findElement(By.xpath("//label[@for='radio-"+j+"']")).click(); // No button 
       }
    }
    
    buttonClick(driver,objectrepository.getbtnsaveandcontinue(),5,"Click on Save and Continue");
    //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    
    System.out.println("Gatekeeper Question have been completed Sucessfully");
    AutomationUtilities.LogSummary(LogPath,"Gatekeeper Question have been completed Sucessfully");
	
  }
	

	public void Risklevel(LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException {
		
		    String sIFristName, sILastName;
		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = new Date();
		    
			EsendKeysToTextField(driver,objectrepository.gettxtEffectiveDate(),dateFormat.format(date),"Effective Date");
			System.out.println("Effective Date of the Quote is :"+dateFormat.format(date));
			
			buttonClick(driver,objectrepository.getdpdstate(),10,"Click on State");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getState(),"State Name");
			
			buttonClick(driver,objectrepository.getdpdCounty(),10,"Click on County");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getCounty(),"County Name");
			
			if(objGlLoadManager.getBusinessName().equalsIgnoreCase("")) {
				
				sendKeysToTextField(driver,objectrepository.gettxtIndividualFirstName(),objGlLoadManager.getGLFristName(),"Frist Name");
				sendKeysToTextField(driver,objectrepository.gettxtIndividualLastName(),objGlLoadManager.getLastName(),"Last Name");
				AutomationUtilities.sBusinessName = AutomationUtilities.sBusinessName + objGlLoadManager.getGLFristName() + objGlLoadManager.getLastName();
						
				if(objGlLoadManager.getGLFristName().equalsIgnoreCase("")) {
					
					AutomationUtilities.sBusinessName = "FCGA AUTM-" + AutomationUtilities.getRandomString(9);
					sendKeysToTextField(driver,objectrepository.gettxtBusinessName(),AutomationUtilities.sBusinessName,"Business Name");
					
					if(sBusinessName.isEmpty()) {
						
					sIFristName = "FCGA AUTM";
					sendKeysToTextField(driver,objectrepository.gettxtIndividualFirstName(),sIFristName,"Frist Name");
					
					sILastName = "A"+AutomationUtilities.getRandomString (9);
					sendKeysToTextField(driver,objectrepository.gettxtIndividualLastName(),sILastName,"Last Name");
					
					AutomationUtilities.sBusinessName = AutomationUtilities.sBusinessName + sIFristName + sILastName;
				  } 
				}
			    
			}else {
				AutomationUtilities.sBusinessName =	objGlLoadManager.getBusinessName();
				sendKeysToTextField(driver,objectrepository.gettxtBusinessName(),AutomationUtilities.sBusinessName,"Business Name");
			}
		
			System.out.println("Insured Name / Business Name is : "+AutomationUtilities.sBusinessName);
			AutomationUtilities.LogSummary(LogPath,"Insured Name / Business Name is : "+AutomationUtilities.sBusinessName);
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			sendKeysToTextField(driver,objectrepository.gettxtDescriptionOfBusiness(),objGlLoadManager.getDescriptionOfBusiness(),"Business Description");
			sendKeysToTextField(driver,objectrepository.gettxtYearsInBusiness(),objGlLoadManager.getYearsInBusiness(),"Years In Business");
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
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
			 
			// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");   
			 
			// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			 
			 System.out.println("Risk Level have been completed Sucessfully");
			 AutomationUtilities.LogSummary(LogPath,"Risk Level have been completed Sucessfully");
		
	}
		public void classPayroll(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			AutomationUtilities.sClassCode = objGlLoadManager.getClassCode();
			AutomationUtilities.sSubClassCode = objGlLoadManager.getSubClassCode();
			String[] ClassCode = objGlLoadManager.getClassCode().split("/");
			String[] SubClassCode = objGlLoadManager.getSubClassCode().split("/");
			int classcodecount = ClassCode.length;
			int subclasscodecount = SubClassCode.length;
			if(classcodecount > 1) {
			int Eprecentage = 100/classcodecount;
			for(int i=0;i<classcodecount;i++) {
				
				buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),ClassCode[i],"Class Codes");
				buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				AutomationUtilities.sClassCodeDesc = AutomationUtilities.sClassCodeDesc + driver.findElement(By.xpath("//td[@data-fieldid='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
                System.out.println("Class Code Desc : "+ AutomationUtilities.sClassCodeDesc);
				if(i == classcodecount-1) {
					
					Eprecentage = 100 - (Eprecentage*i);  
				}
				driver.findElement(By.xpath("//td[@data-fieldid ='"+ClassCode[i]+"']//parent :: tr// following-sibling :: td//input[@class='dynamicAdd form-control'][@name='percentage']")).sendKeys(Integer.toString(Eprecentage));
				//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			}
			}
			else {
				
				buttonClick(driver,objectrepository.getdpdclasscode(),10,"Click on Class Code Drop down");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getClassCode(),"Class Codes");
				buttonClick(driver,objectrepository.getbtnAddClassCode(),10,"Click on Add Button");
				AutomationUtilities.sClassCodeDesc = driver.findElement(By.xpath("//td[@data-fieldid='"+objGlLoadManager.getClassCode()+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
				sendKeysToTextField(driver,objectrepository.getClasscodePercentage(),"100","Percentage");
		       
			}
			
			sendKeysToTextField(driver,objectrepository.gettxtExpectedGrossAmount(),objGlLoadManager.getExpectedGrossReceipts(),"Expected Gross Amount");
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			if(!objGlLoadManager.getSubClassCode().isEmpty()) {
			
			AutomationUtilities.sClassCode = objGlLoadManager.getClassCode()+","+objGlLoadManager.getSubClassCode();
			sendKeysToTextField(driver,objectrepository.getInSubcontractorCost(),objGlLoadManager.getSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			sendKeysToTextField(driver,objectrepository.getSubcontractorCostopdes(),objGlLoadManager.getSubcontractorDesc(), "Sub Contractor Description");
			
			if(subclasscodecount > 1) {
				
			int Eprecentage = 100/subclasscodecount;
			for(int i=0;i<subclasscodecount;i++) {

				buttonClick(driver,objectrepository.getSubClasscodes(),10," Click Sub Class Code");
				EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),SubClassCode [i],"Sub Class Codes");
				
                if(i == subclasscodecount-1) {
					
					Eprecentage = 100 - (Eprecentage*i);  
				}
                
				buttonClick(driver,objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
				sendKeysToTextField(driver,objectrepository.getSubClasscodePercentage(),Integer.toString(Eprecentage),"Percentage");
			  }
			}
			else {

			buttonClick(driver,objectrepository.getSubClasscodes(),10," Click Sub Class Code");
			EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getSubClassCode(),"Sub Class Codes");
			
			buttonClick(driver,objectrepository.getbtnAddSubClassCode(),10,"Click Add Button");
			sendKeysToTextField(driver,objectrepository.getSubClasscodePercentage(),"100","Percentage");
             }

			AutomationUtilities.sClassCodeDesc = AutomationUtilities.sClassCodeDesc +"/"+ driver.findElement(By.xpath("//td[@data-fieldid='"+objGlLoadManager.getSubClassCode()+"']//parent :: tr// following-sibling :: td//b")).getText().toString();
			
			}
			else {

			sendKeysToTextField(driver,objectrepository.getUnSubcontractorCost(),objGlLoadManager.getUnSubContractorGrossReciepts(),"Expected Sub Class Code Gross Amount");
			}
			
			sendKeysToTextField(driver,objectrepository.gettxtActivePartner(),objGlLoadManager.getActiveOwner(),"Active Owner");
			
			
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
			/*if(!(classcodecount > 1)) {
				
			    sendKeysToTextField(driver,objectrepository.getClasscodePercentage(),"200","Enter Percentage");
			    //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			    
			    buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			
			if(objectrepository.getbtnClose().isEnabled()) {
				
				System.out.println("Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");
				AutomationUtilities.LogSummary(LogPath,"Error Message generated is : "+ objectrepository.getErrorMessage().getText().toString()+".");	
				Thread.sleep(6000);
				
				buttonClick(driver,objectrepository.getbtnClose(),10,"Click on Button Close");*/
				//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			  //}
			//}
			
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save & Continue Button");
			System.out.println("Class & Payroll have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Class & Payroll have been completed Sucessfully");				
		}
		
		public void AI(LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			waitforpageload(driver, 5);
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			//Thread.sleep(3000);
			
			AutomationUtilities.GLMessages(driver,objectrepository, objGlLoadManager.getAgentMessages());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Thread.sleep(2000);
			if (objGlLoadManager.getAI().equalsIgnoreCase("No")) {
			if(objGlLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
				
				if(!objGlLoadManager.getAICG2404().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2404(),objGlLoadManager.getAICG2404(),"Waiver of Surbogation");
				   }
			   }
			}
			
			if (objGlLoadManager.getAI().equalsIgnoreCase("Yes")) {
				
				if(objGlLoadManager.getAIFCG1001().equalsIgnoreCase("Yes")) {
					buttonClick(driver,objectrepository.getrdFCG1001(),10,"Click on FCG1001");
				}
				if(!objGlLoadManager.getAICG2010().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2010(),objGlLoadManager.getAICG2010(),"Enter on CG2010");
				}
				if(!objGlLoadManager.getAICG2037().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2037(),objGlLoadManager.getAICG2037(),"Enter on CG2037");
				}
				if(!objGlLoadManager.getAICG1019().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG1019(),objGlLoadManager.getAICG1019(),"Enter on CG1019");
				}
				
				if(objGlLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
					
					if(!objGlLoadManager.getAICG2404().equalsIgnoreCase("0")) {
						sendKeysToTextField(driver,objectrepository.getrdCG2404(),objGlLoadManager.getAICG2404(),"Waiver of Surbogation");
					}
				}
				
				if(!objGlLoadManager.getAICG2012().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2012(),objGlLoadManager.getAICG2012(),"Enter on CG2012");
				}
				if(!objGlLoadManager.getAICG2029().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2029(),objGlLoadManager.getAICG2029(),"Enter on CG2029");
				}
				if(!objGlLoadManager.getAICG2028().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2028(),objGlLoadManager.getAICG2028(),"Enter on CG2028");
				}
				if(!objGlLoadManager.getAICG2024().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2024(),objGlLoadManager.getAICG2024(),"Enter on CG2024");
				}
				if(!objGlLoadManager.getAICG2005().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2005(),objGlLoadManager.getAICG2005(),"Enter on CG2005");
				}
				if(!objGlLoadManager.getAICG2011().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2011(),objGlLoadManager.getAICG2011(),"Enter on CG2011");
				}
				if(!objGlLoadManager.getAICG2026().equalsIgnoreCase("0")) {
					sendKeysToTextField(driver,objectrepository.getrdCG2026(),objGlLoadManager.getAICG2026(),"Enter on CG2026");
				}
				if(!objGlLoadManager.getAICG2007().equalsIgnoreCase("Yes")) {
					buttonClick(driver,objectrepository.getrdCG2007(),10,"Enter on CG2007");
				}
			} else {
				
				js.executeScript("window.scrollBy(0,1000)");
				js.executeScript("window.scrollBy(0,1000)");
			}
			
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
			System.out.println("Aditional Insured have been completed Sucessfully");
			AutomationUtilities.LogSummary(LogPath,"Aditional Insured have been completed Sucessfully");
		}
		
		public void IM(LoadManager objGlLoadManager, WebDriver driver) throws InterruptedException, IOException, AWTException {
			
			waitforpageload(driver, 10);
	        for (int i =1; i<=LastQCount(driver,ElementNamexpath);i++) {
	        	driver.findElement(By.xpath("//label[@for='radio-"+i+"']")).click(); // no button
	        }
	        
	        //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        buttonClick(driver,objectrepository.getdpdinstallationfloater(),10,"Click on Installation Floater Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getInstallationFloater(),"Installation Floater have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdContractorHandtools(),10,"Click on Contractor's Hand Tools Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Contractor's Hand Tools have been entered");
	        
	        buttonClick(driver,objectrepository.getdpdleasedequipment(),10,"Click on Leased Equipment Drop down");
	        EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getContractorsHandTools(),"Click on Leased Equipment Drop down");
	       // AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	        
	        if (objGlLoadManager.getScheduleEquipment().equalsIgnoreCase("Yes") ) {
	        	
	        	buttonClick(driver,objectrepository.getbtnScheduleEquip(),20,"Schedule Equipment");
	        	sendKeysToTextField(driver,objectrepository.gettxtScheduleEquipDesc(),objGlLoadManager.getScheduleEquipmentDescription(),"Schedule Equipment Description");
	        	sendKeysToTextField(driver,objectrepository.gettxtScheduleEquipAcount(),objGlLoadManager.getScheduleEquipmentAmount(),"Schedule Equipment Amount" );
	        }
	        	
	        buttonClick(driver,objectrepository.getbtnsaveandcontinue(),10,"Click on Save and Continue");
			
	        System.out.println("Inland Marine have been completed Sucessfully");
	        AutomationUtilities.LogSummary(LogPath,"Inland Marine have been completed Sucessfully");
	        
		}
		

	public void ClassSpecificQues (WebDriver driver,String testcasePath,String QAns) throws Exception {
        
		waitforpageload(driver, 10);
		
		  if (QAns.equalsIgnoreCase("No")) {
			  
			    String xpath = "//tr[@class='visibleTr']";
			    
	        	for (int i =1; i<=LastQCount(driver,xpath);i++) {
	       
	        		QClassSpecACount = driver.findElement(By.xpath("//tr[@class='visibleTr']["+i+"]")).getAttribute("id").toString();
	        		
	        		QClassSpecValue = driver.findElement(By.xpath("//tr[@id='"+QClassSpecACount+"']/td[5]")).getText().toString();
	        		
	        		//System.out.println("Class Specific Question "+i+" :"+QClassSpecValue);
	        		AutomationUtilities.LogSummary(LogPath,"Class Specific Question "+i+" :"+QClassSpecValue);
	        		String [] Qvalue = QClassSpecValue.split(":");
	        		Qvalue[1] = Qvalue[1].replaceFirst(" ","");
	        		QuestionArray.add(Qvalue[1]);
	        
	        		AutomationUtilities.CheckDuplicateQuestions(QuestionArray,Qvalue[1]);
	        		AutomationUtilities.ReadWriteClassSpecificQuestion (testcasePath,"TD_CSQ",i,AutomationUtilities.tcCount,Qvalue[1],LogPath,"Primary Underwriting Question (Expected)" );
	        		driver.findElement(By.xpath("//tr[@class='visibleTr']//td[contains(text(),'Question')]//parent :: tr// following-sibling :: td//input[contains(@name,'question"+QClassSpecACount+"')]//parent :: div//label[starts-with(@for,'radio-')]")).click(); // no button
	        	}
		  }	
        
        //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
        buttonClick(driver,objectrepository.getbtnsaveandcontinue(),20,"Click on Save and Continue");
        
        System.out.println("Class Specific have been completed Sucessfully");
        AutomationUtilities.LogSummary(LogPath,"Class Specific have been completed Sucessfully");
	}

	public void Quote (LoadManager objGlLoadManager,LoginPage objGLloginpage,Underwriting objGLunderwriting,HomePage objhomepage, WebDriver driver) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		
	waitforpageload(driver, 15);
     
     if(objGlLoadManager.getTCScenarios().equalsIgnoreCase("Referral Flow")) {
    	
    	 
    	 sendKeysToTextField(driver,objectrepository.gettxtRefferal(),objGlLoadManager.getUWReferralRemark(),"Refferal Reason");
    	 buttonClick(driver,objectrepository.getBtnDoneRefferal(),10,"Click on Refferal (Done button)");
    	// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objhomepage.checkFramePopup(driver);
    	 objGLloginpage.AgentSignOut (driver);
    	 objGLloginpage.UWlogin(driver);
    	 //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objGLunderwriting.UnderwritingSearch(driver);
    	 
    	 if(objGlLoadManager.getUWModifyPerm().equalsIgnoreCase("Yes")) {
    		 objGLunderwriting.UWGLEditQuote(driver,objGlLoadManager);
    	 }
    	 
    	 objGLunderwriting.UWChangeStatus(driver,objGlLoadManager);
    	// AutomationUtilities.Screenshot(tcSnapPath,testCaseID)
    	 
    	 objGLloginpage.UWSignOut(driver);
    	 objGLloginpage.Agentlogin(driver);
    	// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 
    	 objhomepage.SelectAgent(driver,objGlLoadManager.getAgentName()); 
		// AutomationUtilities.Screenshot(tcSnapPath, testCaseID);
		
    	 objhomepage.checkFramePopup(driver);
    	 objGLunderwriting.AgentSearch(driver,objGlLoadManager);
    	// AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
    	 waitforpageload(driver, 115);
     }
		
     //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
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
     //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
     if(objGlLoadManager.getUWModifyState().isBlank()) {
          if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
    	   sendKeysToTextField(driver,objectrepository.gettxt_ProducerFee(),objGlLoadManager.getProducerFee(),"Enter Producer Fee");
			buttonClick(driver,objectrepository.getbtn_SaveProducerFee(),70,"Click on Button Save");
            Thread.sleep(4000);
			buttonClick(driver,objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID)
         }
     } else if(objGlLoadManager.getUWModifyState().equalsIgnoreCase("Texas")) {
  	        
    	    sendKeysToTextField(driver,objectrepository.gettxt_ProducerFee(),objGlLoadManager.getProducerFee(),"Enter Producer Fee");
			buttonClick(driver,objectrepository.getbtn_SaveProducerFee(),70,"Click on Button Save");
            Thread.sleep(4000);
			buttonClick(driver,objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
			//AutomationUtilities.Screenshot(tcSnapPath,testCaseID)
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
     
     if(objGlLoadManager.getUWModifyState().isBlank()) {
        if(objGlLoadManager.getState().equalsIgnoreCase("Texas")) {
    	 
           System.out.println("FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
           AutomationUtilities.LogSummary(LogPath,"FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
           AutomationUtilities.FWCIProducerFee = objectrepository.getlbl_FWCIProducerFee().getText();
     
           System.out.println("CB Producer Fee: "+ objectrepository.getlbl_CBProducerFee().getText());
           AutomationUtilities.LogSummary(LogPath,"CB Producer Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
           AutomationUtilities.CBProducerFee = objectrepository.getlbl_CBProducerFee().getText();
     
	      }
     }else if(objGlLoadManager.getUWModifyState().equalsIgnoreCase("Texas")) {
    	 
    	 System.out.println("FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
         AutomationUtilities.LogSummary(LogPath,"FWCI Producer Fee: "+ objectrepository.getlbl_FWCIProducerFee().getText());
         AutomationUtilities.FWCIProducerFee = objectrepository.getlbl_FWCIProducerFee().getText();
   
         System.out.println("CB Producer Fee: "+ objectrepository.getlbl_CBProducerFee().getText());
         AutomationUtilities.LogSummary(LogPath,"CB Producer Fee: "+ objectrepository.getlbl_CBMGAPolicyFee().getText());
         AutomationUtilities.CBProducerFee = objectrepository.getlbl_CBProducerFee().getText();
   
     }
     
     if(objGlLoadManager.getTypeofCompany().equalsIgnoreCase("FWCI")) {
    	 
    	 buttonClick(driver,objectrepository.getrdo_FWCIbutton(),10,"Click on FWCI Insurance Company");
         //System.out.println("Click on FWCI Insurance Company");
         //AutomationUtilities.LogSummary(LogPath,"Click on FWCI Insurance Company");
         
     }else {
    	 
         buttonClick(driver,objectrepository.getrdo_CBbutton(),10,"Click on CB Insurance Company");
         //System.out.println("Click on CB Insurance Company");
         //AutomationUtilities.LogSummary(LogPath,"Click on CB Insurance Company");
         
     }
     
     //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     buttonClick(driver,objectrepository.getbtn_ICSavebutton(),20,"Click on Save Insurance Company");
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 buttonClick(driver,objectrepository.getbtn_CloseProducerFee(),10,"Click on Button Close");
	 driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 
	 AutomationUtilities.QuoteNo = objectrepository.getlbl_QuoteNo().getText();
	 //System.out.println("Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     AutomationUtilities.LogSummary(LogPath,"Quote No: "+ objectrepository.getlbl_QuoteNo().getText());
     //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
	 buttonClick(driver,objectrepository.getbtn_Appbutton(),10,"Click on Application Button");
     //System.out.println("Click on Application Button");
     //AutomationUtilities.LogSummary(LogPath,"Click on Application Button");
     //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
     
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
		
		sendKeysToTextField(driver,objectrepository.gettxtcontactforinspection(),objGlLoadManager.getInspectorName(),"Enter contact for inspection");
	    //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	    
		sendKeysToTextField(driver,objectrepository.gettxtFristAddressline(),objGlLoadManager.getFristAddressline(),"Enter 1st line of Address"); 
        sendKeysToTextField(driver,objectrepository.gettxtSecAddressline(),objGlLoadManager.getSecAddressline(),"Enter 2nd line of Address");
		
        if(objGlLoadManager.getUWModifyCity().isBlank() && objGlLoadManager.getUWModifyZip().isBlank()) {
        
        	sendKeysToTextField(driver,objectrepository.gettxtLocationCity(),objGlLoadManager.getLocationCity(),"Enter City Name");
		    sendKeysToTextField(driver,objectrepository.gettxtLocationZipCode(),objGlLoadManager.getLocationZipCode(),"Enter Zip Code");
		    AutomationUtilities.sAddress = objGlLoadManager.getFristAddressline()+","+objGlLoadManager.getSecAddressline()+","+objGlLoadManager.getLocationCity()+","+objGlLoadManager.getLocationZipCode();
			
        }else {
        	sendKeysToTextField(driver,objectrepository.gettxtLocationCity(),objGlLoadManager.getUWModifyCity(),"Enter City Name");
		    sendKeysToTextField(driver,objectrepository.gettxtLocationZipCode(),objGlLoadManager.getUWModifyZip(),"Enter Zip Code");
		    AutomationUtilities.sAddress = objGlLoadManager.getFristAddressline()+","+objGlLoadManager.getSecAddressline()+","+objGlLoadManager.getUWModifyCity()+","+objGlLoadManager.getUWModifyZip();
			
        }
		
        //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
        if(CheckElementPresent(objectrepository.getUseasis()) == true ) {
			AutomationUtilities.SmartyStreet = "No";
			buttonClick(driver,objectrepository.getUseasis(),10,"Click on Use as is");
		}else {
			AutomationUtilities.SmartyStreet = "Yes";
		}
		
		sendKeysToTextField(driver,objectrepository.gettxtBusinessPhone(),objGlLoadManager.getBusinessPhone(),"Enter Business Phone Number");
		sendKeysToTextField(driver,objectrepository.gettxtBusinessEmail(),objGlLoadManager.getBusinessEmail(),"Enter Business Emails");

		String FEIN = AutomationUtilities.getRandomString (9);
		sendKeysToTextField(driver,objectrepository.gettxtBusinessFEINSSN(),FEIN,"Enter Business FEIN");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		 
		buttonClick(driver,objectrepository.getchkSameAddress(),10,"Click on Same Address check box");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
			
		sendKeysToTextField(driver,objectrepository.gettxtExpirationDate(),dateFormat.format(cal.getTime()),"Enter Business Expiration Date");  
		sendKeysToTextField(driver,objectrepository.gettxtInsuranceCarrier(),objGlLoadManager.getTypeofCompany(),"Enter Insurance Carrier");
		
		if(!objGlLoadManager.getLocationAgregate().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getLocationAgregate())> 1) {
				
				for(int i =1;i<=Integer.valueOf(objGlLoadManager.getLocationAgregate());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2504_"+i+"']")).sendKeys("CG2504_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2504_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2504_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2504_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2504_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			} else {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2504']")).sendKeys("CG2504");
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2504']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2504']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2504']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2504']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
			
		}
		
        if(!objGlLoadManager.getProjectAgregate().equalsIgnoreCase("0")) {
			
        	if(Integer.valueOf(objGlLoadManager.getProjectAgregate())> 1) {
        		
        		for(int i =1;i<=Integer.valueOf(objGlLoadManager.getProjectAgregate());i++) {
    				
    				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2503_"+i+"']")).sendKeys("CG2503_"+i);
    				driver.findElement(By.xpath("//input[@id='txtAddress1CG2503_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
    				driver.findElement(By.xpath("//input[@id='txtAddress2CG2503_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
    				driver.findElement(By.xpath("//input[@id='txtCityCG2503_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
    				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2503_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
    			}
        	} else {
        		
        		driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2503']")).sendKeys("CG2503");
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2503']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2503']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2503']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2503']")).sendKeys(objGlLoadManager.getLocationZipCode());
			
        	}
			
		}		
        

		if(!objGlLoadManager.getAICG2010().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2010())> 1) {
				
				for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2010());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2010_"+i+"']")).sendKeys("CG2010_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2010_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2010_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2010_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2010_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			} else {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2010']")).sendKeys("CG2010");
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2010']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2010']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2010']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2010']")).sendKeys(objGlLoadManager.getLocationZipCode());

			}
            
		}
		if(!objGlLoadManager.getAICG2037().equalsIgnoreCase("0")) {
              
			if(Integer.valueOf(objGlLoadManager.getAICG2037())> 1) {
				
				for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2037());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2037_"+i+"']")).sendKeys("CG2037_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2037_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2037_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2037_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2037_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			}else {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2037']")).sendKeys("CG2037");
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2037']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2037']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2037']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2037']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
			
		}
		if(!objGlLoadManager.getAICG1019().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG1019())> 1) {
				
				for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG1019());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameFCG1019_"+i+"']")).sendKeys("CG1019_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1FCG1019_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2FCG1019_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityFCG1019_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeFCG1019_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			} else {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameFCG1019']")).sendKeys("CG1019");
				driver.findElement(By.xpath("//input[@id='txtAddress1FCG1019']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2FCG1019']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityFCG1019']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeFCG1019']")).sendKeys(objGlLoadManager.getLocationZipCode());
	
			}
           
		}
			
	    if(!objGlLoadManager.getAICG2404().equalsIgnoreCase("0")) {

	    	if(Integer.valueOf(objGlLoadManager.getAICG2404())> 1) {
				
	    	for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2404());i++) {
				
				driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2404_"+i+"']")).sendKeys("CG2404_"+i);
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2404_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2404_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2404_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2404_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
		  } else {
			
			    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2404']")).sendKeys("CG2404");
				driver.findElement(By.xpath("//input[@id='txtAddress1CG2404']")).sendKeys(objGlLoadManager.getFristAddressline());
				driver.findElement(By.xpath("//input[@id='txtAddress2CG2404']")).sendKeys(objGlLoadManager.getSecAddressline());
				driver.findElement(By.xpath("//input[@id='txtCityCG2404']")).sendKeys(objGlLoadManager.getLocationCity());
				driver.findElement(By.xpath("//input[@id='txtZipCodeCG2404']")).sendKeys(objGlLoadManager.getLocationZipCode());
			}
	    }
		if(!objGlLoadManager.getAICG2012().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2012())> 1) {
				
		    	for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2012());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2012_"+i+"']")).sendKeys("CG2012_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2012_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2012_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2012_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2012_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2012']")).sendKeys("CG2012");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2012']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2012']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2012']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2012']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2029().equalsIgnoreCase("0")) {
              
			if(Integer.valueOf(objGlLoadManager.getAICG2029())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2029());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2029_"+i+"']")).sendKeys("CG2029_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2029_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2029_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2029_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2029_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2029']")).sendKeys("CG2029");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2029']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2029']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2029']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2029']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2028().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2028())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2028());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2028_"+i+"']")).sendKeys("CG2028_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2028_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2028_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2028_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2028_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2028']")).sendKeys("CG2028");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2028']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2028']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2028']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2028']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2024().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2024())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2024());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2024_"+i+"']")).sendKeys("CG2024_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2024_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2024_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2024_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2024_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2024']")).sendKeys("CG2024");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2024']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2024']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2024']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2024']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2005().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2005())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2005());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2005_"+i+"']")).sendKeys("CG2005_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2005_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2005_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2005_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2005_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2005']")).sendKeys("CG2005");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2005']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2005']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2005']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2005']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2011().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2011())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2011());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2011_"+i+"']")).sendKeys("CG2011_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2011_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2011_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2011_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2011_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2011']")).sendKeys("CG2011");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2011']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2011']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2011']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2011']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}
		if(!objGlLoadManager.getAICG2026().equalsIgnoreCase("0")) {
			
			if(Integer.valueOf(objGlLoadManager.getAICG2026())> 1) {
				
		    	  for(int i =1;i<=Integer.valueOf(objGlLoadManager.getAICG2026());i++) {
					
					driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2026_"+i+"']")).sendKeys("CG2011_"+i);
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2026_"+i+"']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2026_"+i+"']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2026_"+i+"']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2026_"+i+"']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
			  } else {
				
				    driver.findElement(By.xpath("//input[@id='txtCompanyNameCG2026']")).sendKeys("CG2011");
					driver.findElement(By.xpath("//input[@id='txtAddress1CG2026']")).sendKeys(objGlLoadManager.getFristAddressline());
					driver.findElement(By.xpath("//input[@id='txtAddress2CG2026']")).sendKeys(objGlLoadManager.getSecAddressline());
					driver.findElement(By.xpath("//input[@id='txtCityCG2026']")).sendKeys(objGlLoadManager.getLocationCity());
					driver.findElement(By.xpath("//input[@id='txtZipCodeCG2026']")).sendKeys(objGlLoadManager.getLocationZipCode());
				}
		}

        
		sendKeysToTextField(driver,objectrepository.gettxtGeneralRemarks(),objGlLoadManager.getAgentNotes(),"Enter Notes and Remarks");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		  
		
		sendKeysToTextField(driver,objectrepository.gettxtLicenseType(),objGlLoadManager.getLicenseType(),"License Type");
		sendKeysToTextField(driver,objectrepository.gettxtLicenseNumber(),objGlLoadManager.getLicenseNumber(),"License Number");
		
		int ICRTotalPercent = Integer.valueOf(objGlLoadManager.getIndustrialPercent())+Integer.valueOf(objGlLoadManager.getCommercialPercent())+Integer.valueOf(objGlLoadManager.getResidentialPercent());
		
		try{
		    if(ICRTotalPercent == 100) {
		      sendKeysToTextField(driver,objectrepository.gettxtIndustrial(),objGlLoadManager.getIndustrialPercent(),"Enter Industrial Percentage");
		      sendKeysToTextField(driver,objectrepository.gettxtCommercial(),objGlLoadManager.getCommercialPercent(),"Enter Commercial Percentage");
		      sendKeysToTextField(driver,objectrepository.gettxtResidential(),objGlLoadManager.getResidentialPercent(),"Enter Resedential Percentage");
		    }
		  }
		  catch(Throwable t) {
			   t.printStackTrace();
			   }
		
		int NRRRTotalPercent = Integer.valueOf(objGlLoadManager.getNewConstPercent())+Integer.valueOf(objGlLoadManager.getRoomAdditionsPercent())+Integer.valueOf(objGlLoadManager.getRemodelingPercent())+Integer.valueOf(objGlLoadManager.getRepairorServicePercent());
	    
		try {
		   if(NRRRTotalPercent == 100) {
			   sendKeysToTextField(driver,objectrepository.gettxtNewConstruction(),objGlLoadManager.getNewConstPercent(),"Enter New Construction Percentage");
			   sendKeysToTextField(driver,objectrepository.gettxtRoomAdditionsPercent(),objGlLoadManager.getRoomAdditionsPercent(),"Enter Commercial Percentage");
			   sendKeysToTextField(driver,objectrepository.gettxtRemodeling(),objGlLoadManager.getRemodelingPercent(),"Enter Resedential Percentage");
			   sendKeysToTextField(driver,objectrepository.gettxtRepairorService(),objGlLoadManager.getRepairorServicePercent(),"Enter Resedential Percentage"); 
		     }
		   }
		  catch(Throwable t) {
			   t.printStackTrace();
			   }
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		buttonClick(driver,objectrepository.getrdoPerformContractYes(),10,"Click on Perform Contract as Yes");
		sendKeysToTextField(driver,objectrepository.gettxtWorkSubcontracted(),"OK - Approved","Enter New Construction Percentage");
		buttonClick(driver,objectrepository.getrdoRequireCertificatesGLYes(),10,"Click on Perform Contract as Yes");
		buttonClick(driver,objectrepository.getrdoRequireCertificatesWCYes(),10,"Click on Perform Contract as Yes");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if (objGlLoadManager.getScheduleEquipment().equalsIgnoreCase("Yes") ) {
			
			sendKeysToTextField(driver,objectrepository.gettxtSMMake(),objGlLoadManager.getSEMake(),"Schedule Equipment Make");
			sendKeysToTextField(driver,objectrepository.gettxtSMModel(),objGlLoadManager.getSEModel(),"Schedule Equipment Model");
			sendKeysToTextField(driver,objectrepository.gettxtSMSerialNo(),objGlLoadManager.getSESerialNo(),"Schedule Equipment Make");
		
			if(objGlLoadManager.getSELossPayee().equalsIgnoreCase("Yes")) {
				
				buttonClick(driver,objectrepository.getchkSMLossPayee(),10,"Click on Schedule Equipment Loss Payee");
				sendKeysToTextField(driver,objectrepository.gettxtSMName(),objGlLoadManager.getSEName(),"Schedule Equipment Name");
				sendKeysToTextField(driver,objectrepository.gettxtSMAddr(),objGlLoadManager.getSEAddr(),"Schedule Equipment Address");
				sendKeysToTextField(driver,objectrepository.gettxtSMCity(),objGlLoadManager.getSECity(),"Schedule Equipment City");
				sendKeysToTextField(driver,objectrepository.gettxtSMZip(),objGlLoadManager.getSEZip(),"Schedule Equipment Zip Code");
				
			}
		}
		
		buttonClick(driver,objectrepository.getrdoAgree(),10,"Click on Agree radio button");
		buttonClick(driver,objectrepository.getbtnPrintSubmit(),50,"Click on Print & Submit Application");
		
		waitforpageload(driver, 85);
		Thread.sleep(5000);
		AutomationUtilities.Traverse(driver,"Download Application Document");
	    //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
	   
		buttonClick(driver,objectrepository.getGLMakePayment(),10,"Click on Make Payment");
		
	    System.out.println("Application Page have been completed Sucessfully");
	    AutomationUtilities.LogSummary(LogPath,"Application Page have been completed Sucessfully");
	
	}
	
	public void PolicyIssue (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
		
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
		/*************NEW CODE ENDS**************/
		
		System.out.println("PaymentOption is:>>>>>" +objGlLoadManager.getPaymentOption());
		AutomationUtilities.ClickPaymentOptions(driver,objectrepository,objGlLoadManager.getPaymentOption());
		
		buttonClick(driver,objectrepository.getdpddepositpaymentmethod(),10,"Click on Deposit Payment Method");
		EsendKeysToTextField(driver,objectrepository.gettxtUniquetextbox(),objGlLoadManager.getDepositPaymentMethod(),"Deposit Payment Method");
		//AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Check")) {
			
			buttonClick(driver,objectrepository.getclkCheckPayment(),10,"Click on Check Issue Policy");
		
		}else if(objGlLoadManager.getDepositPaymentMethod().equalsIgnoreCase("Online")) {
			
			buttonClick(driver,objectrepository.getclkOnlinePayment(),10,"Click on Online Issue Policy");
			
		}else {
			
			buttonClick(driver,objectrepository.getclkPremiumFinancePayment(),10,"Click on Premium Finance Issue Policy");
		}
		
		waitforpageload(driver, 85);
		AutomationUtilities.LogSummary(LogPath,"Policy Payment is completed successfully");
	}
		
	public void ThankYouPage (LoadManager objGlLoadManager,WebDriver driver) throws InterruptedException, IOException, AWTException, UnsupportedFlavorException {
		
		waitforpageload(driver, 20);
		Thread.sleep(10000);

		buttonClick(driver,objectrepository.getlnkDownloadEvidence(),10,"Clickon EOI Document");
		AutomationUtilities.Traverse(driver,"EOI Document");
	    //AutomationUtilities.Screenshot(tcSnapPath,testCaseID);
		
		
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