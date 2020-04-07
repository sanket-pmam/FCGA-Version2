package FSmokeSuit.FSmokeSuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WCIQObjectRepository {

	
	private static WCIQObjectRepository IQobjectrepository = null;
	@SuppressWarnings("unused")
	private WebDriver driver;
	

	
	// ------------------ Industrial Questions Xpath : "0005"/"0035" -----------------
	
	@FindBy (xpath="//input[@id='IQchk534BeddingnbspPlants']")
	public WebElement chkBedding;
	
	@FindBy (xpath="//input[@id='IQradio-3']")
	public WebElement rdIQuestion_A1;
	
	@FindBy (xpath="//input[@id='IQradio-4']")
	public WebElement rdIQuestion_A2;
	
	@FindBy (xpath="//input[@id='IQradio-9']")
	public WebElement rdIQuestion_A3;
	
	@FindBy (xpath="//input[@id='IQradio9']")
	public WebElement rdIQuestion_A4;
	
	@FindBy (xpath="//input[@id='IQradio-11']")
	public WebElement rdIQuestion_A5;
	
	@FindBy (xpath="//input[@id='IQradio-12']")
	public WebElement rdIQuestion_A6;
	
	@FindBy (xpath="//input[@id='IQradio-13']")
	public WebElement rdIQuestion_A7;
	
	@FindBy (xpath="//input[@id='IQradio13']")
	public WebElement rdIQuestion_A8;
	
	@FindBy (xpath="//input[@id='IQradio14']")
	public WebElement rdIQuestion_A9;
	
	@FindBy (xpath="//input[@id='IQradio-16']")
	public WebElement rdIQuestion_A10;
	
	@FindBy (xpath="//input[@id='IQradio-17']")
	public WebElement rdIQuestion_A11;
	
	@FindBy (xpath="//input[@id='IQradio-18']")
	public WebElement rdIQuestion_A12;
	
	@FindBy (xpath="//input[@id='IQradio19']")
	public WebElement rdIQuestion_A13;

	@FindBy (xpath="//input[@id='IQradio20']")
	public WebElement rdIQuestion_A14;
	
	@FindBy (xpath="//input[@id='IQradio-22']")
	public WebElement rdIQuestion_A15;

	// ------------------ Industrial Questions Xpath : "0042" -----------------
	
	@FindBy (xpath="//input[@id='IQradio-1']")
	public WebElement rdIQuestion_B1;	

	@FindBy (xpath="//input[@id='IQradio-2']")
	public WebElement rdIQuestion_B2;
	
	@FindBy (xpath="//input[@id='IQradio-3']")
	public WebElement rdIQuestion_B3;	

	@FindBy (xpath="//input[@id='IQradio-4']")
	public WebElement rdIQuestion_B4;
	
	@FindBy (xpath="//input[@id='IQradio-5']")
	public WebElement rdIQuestion_B5;	

	@FindBy (xpath="//input[@id='IQradio-6']")
	public WebElement rdIQuestion_B6;
	
	@FindBy (xpath="//input[@id='IQradio-7']")
	public WebElement rdIQuestion_B7;	

	@FindBy (xpath="//input[@id='IQradio-8']")
	public WebElement rdIQuestion_B8;
	
	@FindBy (xpath="//input[@id='IQradio-9']")
	public WebElement rdIQuestion_B9;
	
	@FindBy (xpath="//input[@id='IQradio-10']")
	public WebElement rdIQuestion_B10;	

	@FindBy (xpath="//input[@id='IQradio-11']")
	public WebElement rdIQuestion_B11;
	
	@FindBy (xpath="//input[@id='IQradio11']")
	public WebElement rdIQuestion_B12;
	
	@FindBy (xpath="//input[@id='IQradio-13']")
	public WebElement rdIQuestion_B13;
	
	// ------------------ Industrial Questions Xpath : "1924" -----------------
	
	@FindBy (xpath="//textarea[@name='IQquestionIQ0']")
	public WebElement rdIQuestion_C1;
	
	@FindBy (xpath="//input[@id='IQradio-2']")
	public WebElement rdIQuestion_C2;	

	@FindBy (xpath="//input[@id='IQradio2']")
	public WebElement rdIQuestion_C3;

	@FindBy (xpath="//input[@id='IQradio-4']")
	public WebElement rdIQuestion_C4;
	
	@FindBy (xpath="//input[@id='IQradio4']")
	public WebElement rdIQuestion_YC4;
	
	@FindBy (xpath="//input[@id='IQradio5']")
	public WebElement rdIQuestion_YC5;
	
	@FindBy (xpath="//input[@id='IQradio-6']")
	public WebElement rdIQuestion_C5;
	
	@FindBy (xpath="//input[@id='IQradio6']")
	public WebElement rdIQuestion_C6;
	
	@FindBy (xpath="//input[@id='IQradio-8']")
	public WebElement rdIQuestion_C7;
	
	@FindBy (xpath="//input[@id='IQradio-9']")
	public WebElement rdIQuestion_C8;

	@FindBy (xpath="//input[@id='IQradio9']")
	public WebElement rdIQuestion_C9;
	
	@FindBy (xpath="//input[@id='IQradio10']")
	public WebElement rdIQuestion_C10;
	
	@FindBy (xpath="//input[@id='IQradio11']")
	public WebElement rdIQuestion_C11;
	
	@FindBy (xpath="//input[@id='IQradio12']")
	public WebElement rdIQuestion_C12;
	
	@FindBy (xpath="//input[@id='IQradio-14']")
	public WebElement rdIQuestion_C13;
	
	@FindBy (xpath="//input[@id='IQradio-14']")
	public WebElement rdIQuestion_C14;
	
	@FindBy (xpath="//input[@id='IQradio-16']")
	public WebElement rdIQuestion_C15;
	
	@FindBy (xpath="//input[@id='IQradio-21']")
	public WebElement rdIQuestion_C20;
	
	@FindBy (xpath="//input[@id='IQradio22']")
	public WebElement rdIQuestion_C22;
	
	@FindBy (xpath="//input[@id='IQradio-24']")
	public WebElement rdIQuestion_C23;
	
	WCIQObjectRepository(WebDriver driver) {
		PageFactory.initElements(driver, this); // 15, TimeUnit.SECONDS, this) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);
		this.driver = driver;

	}

	public static WCIQObjectRepository getInstance(WebDriver driver) {
		IQobjectrepository = new WCIQObjectRepository(driver);
		return IQobjectrepository;
	}
	
	//industrial question 
	  
	  public WebElement chkBedding() {
		  return chkBedding;
	  }
	  
	  public WebElement rdIQuestion_A1() {
		  return rdIQuestion_A1;
	  }
	  public WebElement rdIQuestion_A2() {
		  return rdIQuestion_A2;
	  }
	  public WebElement rdIQuestion_A3() {
		  return rdIQuestion_A3;
	  }
	  public WebElement rdIQuestion_A4() {
		  return rdIQuestion_A4;
	  }
	  public WebElement rdIQuestion_A5() {
		  return rdIQuestion_A5;
	  }
	  public WebElement rdIQuestion_A6() {
		  return rdIQuestion_A6;
	  }
	  public WebElement rdIQuestion_A7() {
		  return rdIQuestion_A7;
	  }
	  public WebElement rdIQuestion_A8() {
		  return rdIQuestion_A8;
	  }
	  public WebElement rdIQuestion_A9() {
		  return rdIQuestion_A9;
	  }
	  public WebElement rdIQuestion_A10() {
		  return rdIQuestion_A10;
	  }
	  public WebElement rdIQuestion_A11() {
		  return rdIQuestion_A11;
	  }
	  public WebElement rdIQuestion_A12() {
		  return rdIQuestion_A12;
	  }
	  public WebElement rdIQuestion_A13() {
		  return rdIQuestion_A13;
	  }
	  public WebElement rdIQuestion_A14() {
		  return rdIQuestion_A14;
	  }
	  public WebElement rdIQuestion_A15() {
		  return rdIQuestion_A15;
	  }

	  public WebElement rdIQuestion_B1() {
		  return rdIQuestion_B1;
	  }
	  public WebElement rdIQuestion_B2() {
		  return rdIQuestion_B2;
	  }
	  public WebElement rdIQuestion_B3() {
		  return rdIQuestion_B3;
	  }
	  public WebElement rdIQuestion_B4() {
		  return rdIQuestion_B4;
	  }
	  public WebElement rdIQuestion_B5() {
		  return rdIQuestion_B5;
	  }
	  public WebElement rdIQuestion_B6() {
		  return rdIQuestion_B6;
	  }
	  public WebElement rdIQuestion_B7() {
		  return rdIQuestion_B7;
	  }
	  public WebElement rdIQuestion_B8() {
		  return rdIQuestion_B8;
	  }
	  public WebElement rdIQuestion_B9() {
		  return rdIQuestion_B9;
	  }
	  public WebElement rdIQuestion_B10() {
		  return rdIQuestion_B10;
	  }
	  public WebElement rdIQuestion_B11() {
		  return rdIQuestion_B11;
	  }
	  public WebElement rdIQuestion_B12() {
		  return rdIQuestion_B12;
	  }
	  public WebElement rdIQuestion_B13() {
		  return rdIQuestion_B13;
	  }
	  
	  public WebElement rdIQuestion_C1() {
		  return rdIQuestion_C1;
	  }
	  public WebElement rdIQuestion_C2() {
		  return rdIQuestion_C2;
	  }
	  public WebElement rdIQuestion_C3() {
		  return rdIQuestion_C3;
	  }
	  public WebElement rdIQuestion_C4() {
		  return rdIQuestion_C4;
	  }
	  public WebElement rdIQuestion_YC4() {
		  return rdIQuestion_YC4;
	  }
	  public WebElement rdIQuestion_C5() {
		  return rdIQuestion_C5;
	  }
	  public WebElement rdIQuestion_YC5() {
		  return rdIQuestion_YC5;
	  }
	  public WebElement rdIQuestion_C6() {
		  return rdIQuestion_C6;
	  }
	  public WebElement rdIQuestion_C7() {
		  return rdIQuestion_C7;
	  }
	  public WebElement rdIQuestion_C8() {
		  return rdIQuestion_C8;
	  }
	  public WebElement rdIQuestion_C9() {
		  return rdIQuestion_C9;
	  }
	  public WebElement rdIQuestion_C10() {
		  return rdIQuestion_C10;
	  }
	  public WebElement rdIQuestion_C11() {
		  return rdIQuestion_C11;
	  }
	  public WebElement rdIQuestion_C12() {
		  return rdIQuestion_C12;
	  }
	  public WebElement rdIQuestion_C13() {
		  return rdIQuestion_C13;
	  }
	  public WebElement rdIQuestion_C14() {
		  return rdIQuestion_C14;
	  }
	  public WebElement rdIQuestion_C15() {
		return rdIQuestion_C15;
	  }
	  public WebElement rdIQuestion_C20() {
		return rdIQuestion_C20;
	  }
      public WebElement rdIQuestion_C22() {
    	  return rdIQuestion_C22;
	  }
      public WebElement rdIQuestion_C23() {
    	  return rdIQuestion_C23;
	}

}
