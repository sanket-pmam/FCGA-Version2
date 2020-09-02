package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AutomationDriver {

	private static WebDriver objWebDriver = null;
	String testcasePath;
	String TCSheetName;
	String TCSnapPath;
	int OldtcCount;
	String TCErrSnapPath;
	String TCTempletReportPath;
	String TCRPSHEETNAME;
	String TCLogPath;
	String TCReportPath;
	String TestCaseID="0";
	String Product;
	String StartTime;
	String EndTime;
	
	@DataProvider(name = "SmokeData")
	public Object[][] createTestData() throws IOException {

		Object[][] dataSet = null;

		try {
			
			//CRMDataMatch.Match();
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
			StartTime = myFormatObj.format(myDateObj).toString();
			
			testcasePath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TESTCASE_PATH");
			TCSheetName = AutomationUtilities.getDataFromPropertiesFile("TCSHEETNAME");
			TCSnapPath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TCSNAPPATH");
			TCErrSnapPath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TCERRSNAPPATH");
			TCLogPath = System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("TCLOGPATH");
			TCTempletReportPath = System.getProperty("user.dir") +AutomationUtilities.getDataFromPropertiesFile("REPORT_PATH");
			TCReportPath = System.getProperty("user.dir") +AutomationUtilities.getDataFromPropertiesFile("NEWREPORT_PATH")+ "Report_" + myFormatObj.format(myDateObj).toString() +".xlsx";
			TCRPSHEETNAME = AutomationUtilities.getDataFromPropertiesFile("RPSHEETNAME");
			AutomationUtilities.SpecialChar = AutomationUtilities.getDataFromPropertiesFile("SpecialChar");
			
			File TCR = new File(TCTempletReportPath);
			File TCN = new File(TCReportPath);
			Product = AutomationUtilities.getDataFromPropertiesFile("Product");

			AutomationUtilities.copyFileUsingStream(TCR,TCN);
			AutomationUtilities.LogPath = TCLogPath +"NewLog_"+Product+"-"+ myFormatObj.format(myDateObj).toString() + ".txt";
			TCLogPath = AutomationUtilities.LogPath;

			ArrayList<LoadManager> TestCasesNo;
			AutomationUtilities.LogSummary(TCLogPath, "Please Enter Product Name to start SmokeTest : (WC/GL)");
			TCSheetName = TCSheetName + "_" + Product;
			AutomationUtilities.LogSummary(TCLogPath, "Sheet Name : " + TCSheetName);
			AutomationUtilities.LogSummary(TCLogPath, "Product:" + Product);
					
		  if (TCSheetName.contains("GL")) {
				TestCasesNo = ExcelUtil.excelGetAllData_GL(testcasePath, TCSheetName, 1, 0);
			} else {
				TestCasesNo = ExcelUtil.excelGetAllData_WC(testcasePath, TCSheetName, 1, 0);
			}
			int arraySize = TestCasesNo.size();
			dataSet = new Object[arraySize][];
			for (int count = 0; count < arraySize; count++) {
				dataSet[count] = new Object[1];
				if (TestCasesNo.get(count) != null) {
					dataSet[count][0] = TestCasesNo.get(count);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return dataSet;
	}

	String UserName;
	String Password;

	@Test(dataProvider = "SmokeData")
	public void AutomationDriverExecution(LoadManager objLoadManager) throws AWTException, IOException, InterruptedException {

		AutomationUtilities.OLDTCID = TestCaseID;
		TestCaseID = objLoadManager.getTestCaseId();
		AutomationUtilities.testCaseID = TestCaseID;
		AutomationUtilities.tcSnapPath = TCSnapPath;
	    AutomationUtilities.tcCount = OldtcCount;
	    
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		
		if(!AutomationUtilities.OLDTCID.equalsIgnoreCase(AutomationUtilities.testCaseID)) {
			
			AutomationUtilities.AutmSnapfile = new File(
				TCSnapPath + "NewSnap_"+Product+"_TC_"+AutomationUtilities.testCaseID+"-"+ myFormatObj.format(myDateObj).toString());
		    
			AutomationUtilities.AutmPDFpath = System.getProperty("user.dir") + "\\Test Report\\PDFFile\\"+Product+"_TC-0"+AutomationUtilities.testCaseID+"_"+ myFormatObj.format(myDateObj);
			AutomationUtilities.AutmPDFfile = new File(AutomationUtilities.AutmPDFpath.toString());

		}
		
		try {
			AutomationUtilities.LogSummary(TCLogPath, "========********************************========");
			AutomationUtilities.LogSummary(TCLogPath, "New Quote is getting Created.");
			System.out.println(
					"TC - "+ objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			AutomationUtilities.LogSummary(TCLogPath,
					"TC - "+ objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			
			AutomationUtilities.tcCount = AutomationUtilities.tcCount + 1;
			OldtcCount = AutomationUtilities.tcCount;
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("CHROME_DRIVER_PATH"));
			
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
		    logPrefs.enable(LogType.BROWSER, Level.ALL);
		    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		    
            ChromeOptions options = new ChromeOptions();
            objWebDriver = new ChromeDriver(options);

			LoginPage objLoginPage = new LoginPage(objWebDriver);
			HomePage objhomepage = new HomePage(objWebDriver);
			GeneralLiability objgeneralliability = new GeneralLiability(objWebDriver);
			WorkersCompensation objworkerscompensation = new WorkersCompensation(objWebDriver);
			WCIndustrialQ industrialq = new WCIndustrialQ(objWebDriver);
			Underwriting objunderwriting = new Underwriting(objWebDriver);
			objWebDriver.manage().window().maximize();

			objWebDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			objLoginPage.Agentlogin(objWebDriver);
			objhomepage.SelectAgent(objWebDriver,objLoadManager);

			objhomepage.checkFramePopup(objWebDriver);
			objhomepage.CreateNewQuote(objWebDriver,objLoadManager,objunderwriting,Product);
			
			if (objLoadManager.getProduct().contains("GL")) {

				objgeneralliability.GatekepeerQuestion(objLoadManager,objWebDriver);
				objgeneralliability.Risklevel(objLoadManager,objWebDriver);
				objgeneralliability.classPayroll(objLoadManager, objWebDriver);

				if (objLoadManager.getAI().equalsIgnoreCase("Yes")
						|| objLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
					objgeneralliability.AI(objLoadManager,objWebDriver);
				} else {
					System.out.println("Additional Insured and Wavier is selected as No.");
					AutomationUtilities.LogSummary(TCLogPath, "Additional Insured and Wavier is selected as No.");
				}

				if (objLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
					objgeneralliability.IM(objLoadManager, objWebDriver);
				}

				objgeneralliability.ClassSpecificQues(objWebDriver,testcasePath, "No");
				objgeneralliability.Quote(objLoadManager,objLoginPage,objunderwriting,objhomepage,"Quote",objWebDriver);
				objgeneralliability.WriteGLQuoteDetails (testcasePath,TCSheetName,objLoadManager);
				objgeneralliability.Application(objLoadManager, objWebDriver);
				objgeneralliability.PolicyIssue(objLoadManager, objWebDriver);
				objgeneralliability.ThankYouPage(objLoadManager, objWebDriver);
				objgeneralliability.GLPolicySummary(objLoadManager,objunderwriting,"Policy",objWebDriver);

			} else {

				objworkerscompensation.BusinessSummary(objLoadManager, objWebDriver);
				
				AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.sBusinessName, objLoadManager,
						"Insured Name");
				objworkerscompensation.GeneralQuestions(objLoadManager,industrialq, objWebDriver);
				//objworkerscompensation.Losses(objLoadManager, objWebDriver);
				//objworkerscompensation.Application(objLoadManager, objWebDriver, AutomationUtilities.sBusinessName,"Quote",objLoginPage,objunderwriting,objhomepage,industrialq,testcasePath);
				//objworkerscompensation.PolicyIssue(objLoadManager, objWebDriver);
				//objworkerscompensation.ThankYouPage(objLoadManager, objWebDriver);
			}
			
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.PolicyNo, objLoadManager,"Policy No.");
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, "Pass", objLoadManager,"Status F/P");
			
			EndTime = myFormatObj.format(myDateObj).toString();
			AutomationUtilities.ReportGeneration(TCReportPath,TCRPSHEETNAME,objLoadManager,objLoadManager.getTestCaseId(),Product,
				objLoadManager.getTCScenarios(),AutomationUtilities.sClassCode,AutomationUtilities.sClassCodeDesc,AutomationUtilities.sBusinessName,
				AutomationUtilities.IndustialQ,AutomationUtilities.ClassCodeSTP,AutomationUtilities.sReferralReason,AutomationUtilities.sAddress,AutomationUtilities.SmartyStreet,  
				AutomationUtilities.QuoteNo,AutomationUtilities.QuoteInsuranceName,AutomationUtilities.INSStatus,AutomationUtilities.PolicyNo,AutomationUtilities.XSPolicyNo,AutomationUtilities.GLInsuranceCompany,AutomationUtilities.XSInsuranceCompany,"Pass",
				StartTime,EndTime);
			
			StartTime = EndTime;
			
			objWebDriver.close();
     		objWebDriver.quit();
     		objWebDriver = null;
			

		} catch (Throwable t) {
			
			StringWriter errors = new StringWriter();
			t.printStackTrace(new PrintWriter(errors));
			t.printStackTrace();
				
				AutomationUtilities.AutmSnapfile = new File(
						TCErrSnapPath + "ErrSnap_"+Product+"_TC_"+AutomationUtilities.testCaseID+"-"+ myFormatObj.format(myDateObj).toString());
				
				AutomationUtilities.LogSummary(AutomationUtilities.LogPath,"************ Execptions in Console ***************");
				AutomationUtilities.LogSummary(AutomationUtilities.LogPath, "Exeception is : "+ errors.toString());
				
				LogEntries logEntries = objWebDriver.manage().logs().get(LogType.BROWSER);
				 //LogEntries logEntries1 = objWebDriver.manage().logs().get(LogType.CLIENT);
				// LogEntries logEntries2 = objWebDriver.manage().logs().get(LogType.DRIVER);
				 //LogEntries logEntries3 = objWebDriver.manage().logs().get(LogType.SERVER);
				 //LogEntries logEntries4 = objWebDriver.manage().logs().get(LogType.PERFORMANCE);
			      
				 if(!logEntries.toString().isEmpty()) {
				 
					 AutomationUtilities.LogSummary(AutomationUtilities.LogPath,"************ Browser Console Data ***************");
					 
					 for (LogEntry entry : logEntries) {
						 String LogMessage = new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + " " + entry.toString();
						 AutomationUtilities.LogSummary(AutomationUtilities.LogPath,LogMessage);   
						 //System.out.println(LogMessage);
			           } 
				 }  
			AutomationUtilities.Screenshot(TCErrSnapPath, TestCaseID, objWebDriver);
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, "Fail", objLoadManager,"Status F/P");
			
			EndTime = myFormatObj.format(myDateObj).toString();
			AutomationUtilities.ReportGeneration(TCReportPath,TCRPSHEETNAME,objLoadManager,objLoadManager.getTestCaseId(),Product,
					objLoadManager.getTCScenarios(),AutomationUtilities.sClassCode,AutomationUtilities.sClassCodeDesc,AutomationUtilities.sBusinessName,
					AutomationUtilities.IndustialQ,AutomationUtilities.ClassCodeSTP,AutomationUtilities.sReferralReason,AutomationUtilities.sAddress,AutomationUtilities.SmartyStreet,  
					AutomationUtilities.QuoteNo,AutomationUtilities.QuoteInsuranceName,AutomationUtilities.INSStatus,AutomationUtilities.PolicyNo,AutomationUtilities.XSPolicyNo,
					AutomationUtilities.GLInsuranceCompany,AutomationUtilities.XSInsuranceCompany,"Fail",StartTime,EndTime);
			
			StartTime = EndTime;
				
			    objWebDriver.close();
	     		objWebDriver.quit();
	     		objWebDriver = null;

		} finally {
			if (objWebDriver != null) {

				objWebDriver.close();
    			objWebDriver.quit();
    			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
    			objWebDriver = null;
			}
		}
	}
}
