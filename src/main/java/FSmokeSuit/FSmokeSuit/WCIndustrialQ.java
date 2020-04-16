package FSmokeSuit.FSmokeSuit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WCIndustrialQ extends AutomationUtilities{

	
	public static WebDriver driver = null;
	public static WCIQObjectRepository IQobjectrepository = null;
	
	public WCIndustrialQ(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		IQobjectrepository = WCIQObjectRepository.getInstance(driver);
		driver.manage().timeouts().implicitlyWait(130,TimeUnit.SECONDS);
	}

	
	public void CheckWCIndustrialQ (String ClassCode, WebDriver driver) throws IOException, InterruptedException {
		
		
		List<WebElement> elementName = driver.findElements(By.xpath("//tr[contains(@data-fieldid,'IQ')and @data-level='Primary']"));
        int IndustialQ = elementName.size();
        System.out.println("Industrial Question Count is : "+IndustialQ);
        AutomationUtilities.LogSummary(LogPath, "Industrial Question Count is : "+IndustialQ);
        AutomationUtilities.IndustialQ =String.valueOf(IndustialQ);
        
        
		switch (ClassCode){
			
			case"0005":
				
				checkCheckBox(driver, IQobjectrepository.chkBedding(), 2, "Bedding Plants");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A1(), "Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A2(), "Question-2");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A3(), "Question-3");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A4(), "Question-4");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A5(), "Question-5");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A6(), "Question-6");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A7(), "Question-7");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A8(), "Question-8");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A9(), "Question-9");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A10(), "Question-10");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A11(), "Question-11");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A12(), "Question-12");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A13(), "Question-13");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A14(), "Question-14");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A15(), "Question-15");
					
				break;
				
            case"0013":
				
				checkCheckBox(driver, IQobjectrepository.chkBedding(), 2, "Bedding Plants");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A1(), "Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A2(), "Question-2");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A3(), "Question-3");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A4(), "Question-4");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A5(), "Question-5");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A6(), "Question-6");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A7(), "Question-7");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A8(), "Question-8");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A9(), "Question-9");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A10(), "Question-10");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A11(), "Question-11");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A12(), "Question-12");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A13(), "Question-13");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A14(), "Question-14");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A15(), "Question-15");
					
				break;
					
			case "0035":
				
				checkCheckBox(driver, IQobjectrepository.chkBedding(), 2, "Bedding Plants");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A1(), "Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A2(), "Question-2");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A3(), "Question-3");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A4(), "Question-4");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A5(), "Question-5");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A6(), "Question-6");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A7(), "Question-7");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A8(), "Question-8");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A9(), "Question-9");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A10(), "Question-10");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A11(), "Question-11");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A12(), "Question-12");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A13(), "Question-13");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A14(), "Question-14");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_A15(), "Question-15");
				
				break;
				
			case "0042":
				
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B1(), "Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B2(), "Question-2");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B3(), "Question-3");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B4(), "Question-4");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B5(), "Question-5");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B6(), "Question-6");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B7(), "Question-7");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B8(), "Question-8");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B9(), "Question-9");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B10(), "Question-10");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B11(), "Question-11");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B12(), "Question-12");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_B13(), "Question-13");
				
				break;
				
			case "1924":
				
				sendKeysToTextField(driver, IQobjectrepository.rdIQuestion_C1(),"XYZ: Working","Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C2(), "Question-2");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C5(), "Question-3");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C7(), "Question-4");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C8(), "Question-5");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C9(), "Question-6");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C10(), "Question-7");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C11(), "Question-8");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C12(), "Question-9");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C13(), "Question-10");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C15(), "Question-11");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C20(), "Question-12");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C22(), "Question-13");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C23(), "Question-14");
				
				break;
				
			case "2003":
				
				sendKeysToTextField(driver, IQobjectrepository.rdIQuestion_C1(),"XYZ: Working","Question-1");
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C2(), "Question-2");//IQradio-2
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C3(), "Question-3");//IQradio2
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C4(), "Question-4");//IQradio-4
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_YC4(), "Question-5");//IQradio4
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_YC5(), "Question-6");//IQradio5
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C6(), "Question-7");//IQradio6
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C2(), "Question-8");//IQradio-8
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C3(), "Question-9");//IQradio12
				javascriptExecutorClick(driver, IQobjectrepository.rdIQuestion_C4(), "Question-10");//IQradio-14
			
				break;
				
			default:
				
				AutomationUtilities.LogSummary(LogPath,"Scripting yet to be done for Class Code : "+ClassCode);
				break;
		}
		
	}
	
	
}
