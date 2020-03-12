package FSmokeSuit.FSmokeSuit;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class AutomationUtilities {     
	
   public static String LogPath;
   public static String fileContents="";
   public static int logcount = 1;
   public static File AutmSnapfile;
   public static String testCaseID;
   public static String tcSnapPath;
   public static String QuoteNo;
   public static String PolicyNo;
   public static WebDriverWait wait=null;
   public static Robot rbt;
   public static String sBusinessName;
   public static String QuoteDate;
   public static String CountyCode;
   public static String FWCIPremium;
   public static String FWCIMGAPolicyFee;
   public static String CBPremium;
   public static String CBMGAPolicyFee;
   public static String CBProducerFee;
   public static String FWCIProducerFee;
   public static String OLDTCID;
   
   
	static Function<WebDriver, Boolean> documentWait = new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
			return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState=='complete'")
					? (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0")
					: false;
		}
	};
	
   public static void waitforpageload(WebDriver driver, int iTimeOut) {
		System.out.println("Wait for Page load......");
		String Label = "";
		try {
			Label = driver.getTitle();
			Wait<WebDriver> waitforload = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(iTimeOut))
					.pollingEvery(Duration.ofSeconds(iTimeOut)).ignoring(NoSuchElementException.class);
			waitforload.until(documentWait);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception ex) {
			System.out.println("Error: " + Label + " " + ex.getMessage());
		}
	}
   
   public static void DownLoadPDF(WebDriver driver, String label) throws InterruptedException, AWTException, IOException {
	   System.out.println("Download PDF...");
	   Thread.sleep(5000);
	  
	   int xCoord = 500;
	   int yCoord = 500;
	   
	   	Robot rbt = new Robot();
	   	
	   	rbt.mouseMove(xCoord, yCoord);
//		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		rbt.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		rbt.delay(3000);
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
		
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		
		
		rbt.delay(5000);

		//Press Home button
		rbt.keyPress(KeyEvent.VK_HOME);
		rbt.keyRelease(KeyEvent.VK_HOME);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\Test Report\\PDFFile\\");
		clipboard.setContents(stringSelection, null);
		
		rbt.delay(5000);
		//Copying path by pressing control + v
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		rbt.delay(5000);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		
		 AutomationUtilities.LogSummary(LogPath,"Current Label : "+label+" is completely working.");
		
   }
 
	public void selectDropdownlitag(WebDriver driver, WebElement element, String text, String sLabel) throws IOException, InterruptedException {
		
		String searchText = text;
		System.out.println("Search Text..." +searchText);
		element.click(); 
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.tagName("li"));
		for (WebElement option : options) {
			if (option.getText().equals(searchText)) {
				System.out.println("Search Text is true" + searchText);
				option.click();
				break;
			}
		}
	}
   public void selectDropdownByText(WebElement element, String text,String sLabel) throws IOException {
		
	   try {		
			System.out.println("Drop Down Fucntion has been called");
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}
		catch(Exception e) {
			AutomationUtilities.LogSummary("fail", "Dropdown element "+sLabel+" could not be selected");
			
			e.printStackTrace();
		}
		
	}

   
   
   public static void checkCheckBox(WebDriver driver, WebElement element, int iTimeOutSeconds,
			String label) throws IOException {
		try {
			System.out.println("Checkbox Function has been called");
			System.out.println("Driver" + driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			AutomationUtilities.LogSummary("pass", label + " is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail :- " + label + "Element cannot be clicked due to" + e.getMessage());
			AutomationUtilities.LogSummary("fail", label + " cannot be clicked due to" + e.getMessage());
		}

	}

   
	public void javascriptExecutorClick(WebDriver driver, WebElement element, String label) throws IOException {

		try {

			Actions actionsTwo = new Actions(driver);
			JavascriptExecutor jseTwo = (JavascriptExecutor) driver;
			actionsTwo.moveToElement(element).click();
			jseTwo.executeScript("arguments[0].click()", element);
			
		} catch (Exception e) {
			
			AutomationUtilities.LogSummary(LogPath," : "+label+" is not working due to" + e.getMessage());
			System.out.println(label+" is not working due to" + e.getMessage());
		}
	}

   
   public static void drawBorder(WebDriver driver,WebElement element ) throws InterruptedException {		
		
	   if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='6.5px solid rgb(0, 230, 0)'", element);	        
		}
	    }
   

   public static void buttonClick(WebDriver driver,WebElement element, int waitAfterClick, String label) throws InterruptedException, IOException {
			drawBorder(driver,element);
			element.click(); 
			waitforpageload(driver, waitAfterClick);
			AutomationUtilities.LogSummary(LogPath," Current Label : "+label+" is completely working.");
			
		}	
	
	public static boolean waitTillClickable(WebDriver driver, WebElement element, int iTimeOut,
			String label) {
		System.out.println("waitTillClickable function has been called for "+iTimeOut +"seconds");
		System.out.println("Driver...:" + driver);
		wait = new WebDriverWait(driver, iTimeOut);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static String getDataFromPropertiesFile(String propertyName) {
		File file = new File("./config.properties");
		
		FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return prop.getProperty(propertyName);
   }
   
     public static void sendKeysToTextField(WebDriver driver,WebElement element, String text, String label) throws InterruptedException, IOException {
	    
    	drawBorder(driver,element);
	    element.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
	    Thread.sleep(2000);
	    element.sendKeys(Keys.TAB);
	    AutomationUtilities.LogSummary(LogPath,"Current Label : "+label+" is completely working.");
	    System.out.println("Current Label : "+label+" is completely working.");
    }

    public static void EsendKeysToTextField(WebDriver driver,WebElement element, String text, String label) throws InterruptedException, IOException {
	   
        drawBorder(driver,element);
	    element.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
	    element.sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	    AutomationUtilities.LogSummary(LogPath,"Current Label : "+label+" is completely working.");
	    System.out.println("Current Label : "+label+" is completely working.");
    }


    static String getRandomString(int n) 
    { 
     String AlphaNumericString = "0123456789";
     StringBuilder sb = new StringBuilder(n); 

     for (int i = 0; i < n; i++) { 
    	 
         int index 
             = (int)(AlphaNumericString.length() 
                     * Math.random()); 
         sb.append(AlphaNumericString 
                       .charAt(index)); 
        } 

     return sb.toString(); 
    } 

    public static void Screenshot(String SnapPath,String TCID) throws AWTException, IOException, InterruptedException 
     { 
	     Thread.sleep(1000);
	     Robot r = new Robot(); 
         LocalDateTime myDateObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		 
	     if (!AutmSnapfile.exists()){
	            if (AutmSnapfile.mkdir()) {
	                System.out.println("Folder/Directory is created successfully");
	            } else {
	                System.out.println("Directory/Folder creation failed!!!");
	            }
	      } 

	     SnapPath = AutmSnapfile.getAbsolutePath()+"\\NewSnap_"+TCID+myFormatObj.format(myDateObj).toString() + ".jpg";
         Rectangle capture = new Rectangle((Toolkit.getDefaultToolkit().getScreenSize())); 
         BufferedImage Image = r.createScreenCapture(capture); 
         ImageIO.write(Image, "jpg", new File(SnapPath)); 
         AutomationUtilities.LogSummary(LogPath,"Screenshot saved successfully");
         System.out.println("Screenshot saved"); 
     } 
 
    public static void LogSummary(String Path, String content) throws IOException {

	File file = new File(Path);
	fileContents = fileContents+"\n"+logcount+": "+content;
	
    if (file.createNewFile()){
      System.out.println("File is created!");
    }

    FileWriter writer = new FileWriter(file);
    writer.write(fileContents);
    writer.close();
    logcount++;
    }

    public static void ReadClassSpecificQuestion (String testcasePath,String tcSheetName,String Data,String logpath,String ColName ) {
	
	File file =    new File(testcasePath);

    try {
       
        FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(tcSheetName);
	    XSSFRow headerRow = sheet.getRow(0);			      
        Row rowObj=sheet.getRow(0);		        
	    String result = "";
	    String Output="";
	    int resultCol = -1;
	    for (Cell cell : headerRow){
	        result = cell.getStringCellValue();
	        if (result.equals(ColName)){
	            resultCol = cell.getColumnIndex();
	            break;
	         }
	    }
	    if (resultCol == -1){
	        System.out.println("Searched Collumn is not found in sheet");
	    } 
      	        	
	    while(result.equalsIgnoreCase("Primary Underwriting Question (Expected)")){
	    	
	    	for(int rowNum=1;rowNum<=sheet.getLastRowNum();rowNum++) {
	        	rowObj=sheet.getRow(rowNum); 
	        	Cell cellObj=rowObj.getCell(resultCol);
	        	
	        	if(cellObj.getStringCellValue().equalsIgnoreCase(Data)) {
	        		
	        		Output ="Class Specific Question have been Matched Sucessfully";
	        		break;
	        		
	            } else { 
	            	
	    	       Output ="Class Specific Question have not been Matched Sucessfully";
	         }
            	
	       }
	    	
	      AutomationUtilities.LogSummary(logpath,Output);
	      result="xxx";
	      
	      wb.close();
	      fis.close();
        }
      }
    catch (IOException e) {
        System.out.println("Test data file not found");
        } 
     }


   public static void ExcelUpdate (String testcasePath,String tcSheetName,String Data, LoadManager objLoadManager, String ColName ) {
	
	File file = new File(testcasePath);

    try {
       
        FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(tcSheetName);
	    XSSFRow headerRow = sheet.getRow(0);
	    String result = "";
	    int resultCol = -1;
	    for (Cell cell : headerRow){
	        result = cell.getStringCellValue();
	        if (result.equals(ColName)){
	            resultCol = cell.getColumnIndex();
	            break;
	         }
	    }
	    if (resultCol == -1){
	        System.out.println("Searched Collumn is not found in sheet");
	        //return;
	    }   

	    for(int count = 1;count<=sheet.getLastRowNum();count++){
	    	 
	    	if(count == Integer.valueOf(objLoadManager.getTestCaseId())) {
	    	
	    	 XSSFRow row = sheet.getRow(count);
	         XSSFCell xssfCell = row.getCell(resultCol);
	         xssfCell.setCellValue(Data);
	        
	    	}
	    }
	    
	    fis.close();
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    wb.close();
	    outputStream.close();
	    wb=null;
	    fis=null;
	    outputStream=null;
    }
    catch (IOException e) {
        System.out.println("Test data file not found");
       } 
    }

    public static void ReportExcelUpdate (String testcasePath,String tcSheetName,String testcaseid2,String Data, LoadManager objLoadManager, String ColName ) {
	
	File file = new File(testcasePath);

    try {
       
        FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(tcSheetName);
	    XSSFRow headerRow = sheet.getRow(0);
	    String result = "";
	    int resultCol = -1;
	    for (Cell cell : headerRow){
	        result = cell.getStringCellValue();
	        if (result.equals(ColName)){
	            resultCol = cell.getColumnIndex();
	            break;
	         }
	    }
	    if (resultCol == -1){
	        System.out.println("Searched Collumn is not found in sheet");
	        //return;
	    }   

	    for(int count = 1;count<=sheet.getLastRowNum();count++){
	    	 
	    	if(count == Integer.valueOf(testcaseid2)){
	    		
	    		XSSFRow row = sheet.getRow(count);
		        XSSFCell xssfCell = row.getCell(resultCol);
		        xssfCell.setCellValue(Data);
		        
	    	} else if(count == Integer.valueOf(objLoadManager.getTestCaseId())) {
	    	
	    	 XSSFRow row = sheet.getRow(count);
	         XSSFCell xssfCell = row.getCell(resultCol);
	         xssfCell.setCellValue(Data);
	        
	    	}
	    }
	    
	    fis.close();
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    wb.close();
	    outputStream.close();
	    wb=null;
	    fis=null;
	    outputStream=null;
      }
    catch (IOException e) {
        System.out.println("Test data file not found");
      } 
   }

    public static void ExcelUpdateClassSpecificQuestion (String testcasePath,String tcSheetName,String Data,int i,String ColName ) {
	
	File file = new File(testcasePath);

    try {
       
        FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(tcSheetName);
	    XSSFRow headerRow = sheet.getRow(0);
	    String result = "";
	    int resultCol = -1;
	    for (Cell cell : headerRow){
	        result = cell.getStringCellValue();
	        if (result.equals(ColName)){
	            resultCol = cell.getColumnIndex();
	            break;
	         }
	    }
	    if (resultCol == -1){
	        System.out.println("Searched Collumn is not found in sheet");
	        //return;
	    }   

	    for(int count = 1;count<=sheet.getLastRowNum();count++){
	    	 
	    	if(count == i) {
	    	
	    	 XSSFRow row = sheet.getRow(count);
	         XSSFCell xssfCell = row.getCell(resultCol);
	         xssfCell.setCellValue(Data);
	        
	    	}
	    }
	    
	    fis.close();
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    wb.close();
	    outputStream.close();
	    wb=null;
	    fis=null;
	    outputStream=null;
      }
    catch (IOException e) {
        System.out.println("Test data file not found");
      } 
   }


   public static String Traverse(WebDriver driver,String pdfName) throws AWTException, InterruptedException, UnsupportedFlavorException, IOException {
	
	String pdfFilePath="X";
	  
	 String parentWindow= driver.getWindowHandle();
	 Set<String> allWindows = driver.getWindowHandles();
	 for(String curWindow : allWindows){
	     driver.switchTo().window(curWindow);
	     
	     if(driver.getCurrentUrl().toString().toLowerCase().contains("pdf")) {
        	 break;
        	 } 	   
	   }
     
	 DownLoadPDF(driver,pdfName);
	 Thread.sleep(3000);
	 driver.close();
	 driver.switchTo().window(parentWindow);
     return pdfFilePath;
     
    }

   public static void ClickPaymentOptions(WebDriver driver,ObjectRepository objectrepository, String PaymentOption) throws InterruptedException, IOException {
	
	   if(PaymentOption.equalsIgnoreCase("PayAsYouGo0Down")){
		   buttonClick(driver, objectrepository.getchkPaymentOpt_PayAsYouGo0Down(),10,"Click on Payment Option PayAsYouGo 0 % Down");
	   }else if(PaymentOption.equalsIgnoreCase("25Down3Installments")) {
		   buttonClick(driver, objectrepository.getchkPaymentOpt_25Down3Installments(),10,"Click on Payment Option 25 % Down / 3 Installments");
	   } else if(PaymentOption.equalsIgnoreCase("PayAsYouGo10Down")){
		   buttonClick(driver, objectrepository.getchkPaymentOpt_PayAsYouGo10Down(),10,"Click on Payment Option PayAsYouGo 10 % Down");
	   }else if(PaymentOption.equalsIgnoreCase("Fullpay")) {
		   buttonClick(driver, objectrepository.getchkPaymentOpt_Fullpay(),10,"Click on Payment Option Full Pay");
	   } else if(PaymentOption.equalsIgnoreCase("PremiumFinance")){
		   buttonClick(driver, objectrepository.getchkPaymentOpt_PremiumFinance(),10,"Click on Payment Option Premium Finance");
	   }else if(PaymentOption.equalsIgnoreCase("12Equal")) {
		   buttonClick(driver, objectrepository.getchkPaymentOpt_12Equal(),10,"Click on Payment Option 12 Equal");
	   } else if(PaymentOption.equalsIgnoreCase("15Down9Installments")){
		   buttonClick(driver, objectrepository.getchkPaymentOpt_15Down9Installments(),10,"Click on Payment Option 15 % Down / 9 Installments");
	   }else if(PaymentOption.equalsIgnoreCase("25Down9Installments")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_25Down9Installments(),10,"Click on Payment Option 25 % Down / 9 Installments");
	   } else if(PaymentOption.equalsIgnoreCase("4paybimonthly")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_4paybimonthly(),10,"Click on Payment Option 4PayBi-Monthly");
	   } else if(PaymentOption.equalsIgnoreCase("PayAsYouGo15Down")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_PayAsYouGo15Down(),10,"Click on Payment Option PayAsYouGo15Down");
	   } else if (PaymentOption.equalsIgnoreCase("4paymonthly")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_4paymonthly(),10,"Click on Payment Option 4PayMonthly");
	   }else if (PaymentOption.equalsIgnoreCase("FrankCrumpaygo")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_FrankCrumpaygo(),10,"Click on Payment Option FrankCrumpaygo");
	   } else if(PaymentOption.equalsIgnoreCase("10pay")) {
		   buttonClick(driver,objectrepository.getchkPaymentOpt_10pay(),10,"Click on Payment Option 10Pay");
	   }
	   	
    }
   
    public static void ReportGeneration(String ReportPath, String TCSheetName, LoadManager objLoadManager, String testcaseid2, String product, String tcScenarios,String insuredname, String quoteNo2, String policyNo2, String status,String starttime,String endtime) {
	
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,testcaseid2, testcaseid2, objLoadManager,
			"TC ID");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", product, objLoadManager,
			"Product");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", tcScenarios, objLoadManager,
			"Test Scenario");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", insuredname, objLoadManager,
			"Insured Name");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", quoteNo2, objLoadManager,
			"Quote No");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", policyNo2, objLoadManager,
			"Policy No");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", status, objLoadManager,
			"Status");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", starttime, objLoadManager,
			"Start Time");
	AutomationUtilities.ReportExcelUpdate(ReportPath, TCSheetName,"0", endtime, objLoadManager,
			"End Time");
	
    }
    
    static void copyFileUsingStream(File source, File dest)  {
	    InputStream is = null;
	    OutputStream os = null;
	    File F1 = dest;
	    try {
	    	if(dest.exists())
	    		return;
	        is = new FileInputStream(source);
	        os = new FileOutputStream(F1);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    }catch(Exception ex) {
	    	System.out.println("Unable to copy file:"+ex.getMessage());
	    }	
	    finally {
	    	try {
	    		is.close();
	    		os.close();
	    	}catch(Exception ex) {}
	    }
	}

}
