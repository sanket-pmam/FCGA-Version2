package FSmokeSuit.FSmokeSuit;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Test12
public class AutomationDriver {

	private static WebDriver objWebDriver = null;
	String testcasePath;
	String TCSheetName;
	String TCSnapPath;
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
			File TCR = new File(TCTempletReportPath);
			File TCN = new File(TCReportPath);
			Product = AutomationUtilities.getDataFromPropertiesFile("Product");

			AutomationUtilities.copyFileUsingStream(TCR,TCN);
			AutomationUtilities.LogPath = TCLogPath + "NewLog_" + myFormatObj.format(myDateObj).toString() + ".txt";
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
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		
		if(!AutomationUtilities.OLDTCID.equalsIgnoreCase(AutomationUtilities.testCaseID)) {
			
			AutomationUtilities.AutmSnapfile = new File(
				TCSnapPath + "NewSnap_"+AutomationUtilities.testCaseID+"-"+ myFormatObj.format(myDateObj).toString());
		}
		
		try {
			AutomationUtilities.LogSummary(TCLogPath, "========********************************========");
			AutomationUtilities.LogSummary(TCLogPath, "New Quote is getting Created.");
			System.out.println(
					"TC - "+ objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			AutomationUtilities.LogSummary(TCLogPath,
					"TC - "+ objLoadManager.getTestCaseId() + "-" + objLoadManager.getTCScenarios() + " is getting Executed.");
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + AutomationUtilities.getDataFromPropertiesFile("CHROME_DRIVER_PATH"));
			
			
            ChromeOptions options = new ChromeOptions();
            objWebDriver = new ChromeDriver(options);

			LoginPage objLoginPage = new LoginPage(objWebDriver);
			HomePage objhomepage = new HomePage(objWebDriver);
			GeneralLiability objgeneralliability = new GeneralLiability(objWebDriver);
			WorkersCompensation objworkerscompensation = new WorkersCompensation(objWebDriver);
			Underwriting objunderwriting = new Underwriting(objWebDriver);
			objWebDriver.manage().window().maximize();


			objWebDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objLoginPage.Agentlogin(objWebDriver);
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objhomepage.SelectAgent(objWebDriver,objLoadManager.getAgentName());
			AutomationUtilities.Screenshot(TCSnapPath, TestCaseID);

			objhomepage.checkFramePopup(objWebDriver);
			
			objhomepage.CreateNewQuote(objWebDriver,objLoadManager.getProduct());
			
			
			if (objLoadManager.getProduct().contains("GL")) {

				objgeneralliability.GatekepeerQuestion(objWebDriver);
				objgeneralliability.Risklevel(objLoadManager,objWebDriver);
				objgeneralliability.classPayroll(objLoadManager, objWebDriver);

				if (objLoadManager.getAI().equalsIgnoreCase("Yes")
						|| objLoadManager.getWaivers().equalsIgnoreCase("Yes")) {
					objgeneralliability.AI(objWebDriver);
				} else {
					System.out.println("Additional Insured and Wavier is selected as No.");
					AutomationUtilities.LogSummary(TCLogPath, "Additional Insured and Wavier is selected as No.");
				}

				if (objLoadManager.getInlandMarine().equalsIgnoreCase("Yes")) {
					objgeneralliability.IM(objLoadManager, objWebDriver);
				}

				objgeneralliability.ClassSpecificQues(objWebDriver,testcasePath, "No");
				objgeneralliability.Quote(objLoadManager,objLoginPage,objunderwriting,objhomepage,objWebDriver);
				objgeneralliability.WriteGLQuoteDetails (testcasePath,TCSheetName,objLoadManager);
				objgeneralliability.Application(objLoadManager, objWebDriver);
				objgeneralliability.PolicyIssue(objLoadManager, objWebDriver);

			} else {

				objworkerscompensation.BusinessSummary(objLoadManager, objWebDriver);
				
				AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.sBusinessName, objLoadManager,
						"Insured Name");
				
				objworkerscompensation.GeneralQuestions(objLoadManager, objWebDriver);
				objworkerscompensation.Losses(objLoadManager, objWebDriver);
				objworkerscompensation.Application(objLoadManager, objWebDriver, AutomationUtilities.sBusinessName,objLoginPage,objunderwriting,objhomepage);
				objworkerscompensation.PolicyIssue(objLoadManager, objWebDriver);
				
			}
			
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, AutomationUtilities.PolicyNo, objLoadManager,"Policy No.");
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, "Pass", objLoadManager,"Status F/P");
			
			EndTime = myFormatObj.format(myDateObj).toString();
			AutomationUtilities.ReportGeneration(TCReportPath,TCRPSHEETNAME,objLoadManager,objLoadManager.getTestCaseId(),Product,objLoadManager.getTCScenarios(),AutomationUtilities.sBusinessName,AutomationUtilities.QuoteNo,AutomationUtilities.PolicyNo,"Pass",StartTime,EndTime);
			
			objWebDriver.close();
     		objWebDriver.quit();
     		objWebDriver = null;
			

		} catch (Throwable t) {
			
				t.printStackTrace();
				
				objWebDriver.close();
	     		objWebDriver.quit();
	     		objWebDriver = null;

		} finally {
			if (objWebDriver != null) {
				
				AutomationUtilities.AutmSnapfile = new File(
						TCErrSnapPath + "ErrSnap_"+AutomationUtilities.testCaseID+"-"+ myFormatObj.format(myDateObj).toString());
		
			AutomationUtilities.Screenshot(TCErrSnapPath, TestCaseID);
			AutomationUtilities.ExcelUpdate(testcasePath, TCSheetName, "Fail", objLoadManager,"Status F/P");
			
			EndTime = myFormatObj.format(myDateObj).toString();
			AutomationUtilities.ReportGeneration(TCReportPath,TCRPSHEETNAME,objLoadManager,objLoadManager.getTestCaseId(),Product,objLoadManager.getTCScenarios(),AutomationUtilities.sBusinessName,AutomationUtilities.QuoteNo,AutomationUtilities.PolicyNo,"Fail",StartTime,EndTime);
			
				objWebDriver.close();
    			objWebDriver.quit();
    			objWebDriver = null;
			}
		}
	}
}
