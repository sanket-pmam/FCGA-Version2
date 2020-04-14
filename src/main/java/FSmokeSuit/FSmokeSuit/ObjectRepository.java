package FSmokeSuit.FSmokeSuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ObjectRepository {
	
	private static ObjectRepository objectrepository = null;
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@class ='loading']") 
	private WebElement LoadingWait;
	
	@FindBy(xpath = "//input[@id='txtBranchId']") 
	private WebElement inpUserNameLogin;

	@FindBy(xpath = "//input[@id='txtPassword']")
	private WebElement inpPasswordLogin;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	private WebElement btnLogin; 
	
	@FindBy(xpath = "//a[@id='lnkSignOut']")
	private WebElement btnSignOut; 
	
	@FindBy(xpath = "//label[@id='lblUserName']")
	private WebElement lblUserName;
	
	@FindBy(xpath = "//span[@class='selection']")
	private WebElement dd_SelectAgent; 
	
	
	@FindBy(xpath = "//button[@id='btnContinue']")
	private WebElement btnContinue; 
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement inpSearch; 
	
	@FindBy(xpath = "//a[@id='lnkNewQuote']")
	private WebElement btnNewQuote;
	
	@FindBy(xpath = "//label[@for='rdbGeneralLiability']")
	private WebElement btnrdbGeneralLiability;
	
//	@FindBy(xpath = "//input[@id='rdbWorkersComp'and @value='w']")
	@FindBy(xpath = "//label[@for='rdbWorkersComp']")
	private WebElement btnrdbWorkersComp;
	
	@FindBy(xpath = "//input[@id='txtFEIN']")
	private WebElement inpFEIN;
	
	@FindBy(xpath = "//button[@id='BtnSave']")
	private WebElement btnHContinue;
	
	@FindBy (xpath="//input[starts-with(@value,'SAVE')]")
	public WebElement btnsaveandcontinue;

	@FindBy (xpath="//span[@id='select2-ddlState-container']")
	public WebElement dpdstate;

	@FindBy (xpath="//input[@role='textbox']")
	public WebElement txtUniquetextbox;

	@FindBy (xpath="//input[@id='txtEffectiveDate']")
	public WebElement txtEffectiveDate;
				
	@FindBy (xpath="//div[starts-with(@id,'AlertMsgBox')]/div/div/div[2]")
	public WebElement GKAlertMsgBox;
	
	@FindBy (xpath="//span[@id='select2-ddlCounty-container']")
	public WebElement dpdCounty;

	@FindBy (xpath="//input[@id='txtNameOfInsured']")
	public WebElement txtBusinessName;

	@FindBy (xpath="//input[@id='txtIndividualFirstName']")
	public WebElement txtIndividualFirstName;

	@FindBy (xpath="//input[@id='txtIndividualLastName']")
	public WebElement txtIndividualLastName;

	@FindBy (xpath="//textarea[@id='txtDescriptionOfBusiness']")
	public WebElement txtDescriptionOfBusiness;

	@FindBy (xpath="//input[@id='txtYearsInBusiness']")
	public WebElement txtYearsInBusiness;  
					
	@FindBy (xpath="//input[@id='txtYearsInTrade']")
	public WebElement txtYearsInTrade;

	@FindBy (xpath="//input[@id='txtClaims']")
	public WebElement txtClaims;
					
	@FindBy (xpath="//label[@for='rbLapseDayYes']")
	public WebElement rbpriorinsuranceYes;

	@FindBy (xpath="//label[@for='rbLapseDayNo']")
	public WebElement rbpriorinsuranceNo;
					
	@FindBy (xpath="//span[@id='select2-ddlLiabilityLimit-container']")
	public WebElement dpdliabilitylimit;

	@FindBy (xpath="//span[@id='select2-ddlDeductible-container']")
	public WebElement dpdDeductiblelimit;
					
	@FindBy (xpath="//label[@for='rbAdditionalInsuredsYes']")
	public WebElement rbAdditionalInsuredsYes;

	@FindBy (xpath="//label[@for='rbAdditionalInsuredsNo']")
	public WebElement rbAdditionalInsuredsNo;

	@FindBy (xpath="//label[@for='rbWaiversYes']")
	public WebElement rbWaiversYes;

	@FindBy (xpath="//label[@for='rbWaiversNo']")
	public WebElement rbWaiversNo;

	@FindBy (xpath="//label[@for='rbInlandMarineYes']")
	public WebElement rbInlandMarineYes;

	@FindBy (xpath="//label[@for='rbInlandMarineNo']")
	public WebElement rbInlandMarineNo;

	@FindBy (xpath="//input[@id='txtNoofLocation']")
	public WebElement txtNoofLocation;

	@FindBy (xpath="//input[@id='txtNoofProject']")
	public WebElement txtNoofProject;

	@FindBy (xpath="//span[@id='select2-ddlClassification-container']")
	public WebElement dpdclasscode;
					
	@FindBy (xpath="//button[@id='btnAddClassification']")
	public WebElement btnAddClassCode;
	
	@FindBy (xpath="//input[@class='dynamicAdd form-control'][@name='percentage'][@maxlength='3']")
	public WebElement ClasscodePercentage;
					
	@FindBy (xpath="//input[@id='expectedGrossReceipts']")
	public WebElement txtExpectedGrossAmount;

	@FindBy (xpath="//input[@id='insuredSubcontractorsCost']")
	public WebElement InSubcontractorCost;

	@FindBy (xpath="//input[@id='insuredSubcontractorsOperations']")
	public WebElement SubcontractorCostopdes;

	@FindBy (xpath="//input[@id='uninsuredSubcontractorsCost']")
	public WebElement UnSubcontractorCost;

	@FindBy (xpath="//Span[@id='select2-ddlClassCodes-container']")
	public WebElement SubClasscodes;

	@FindBy (xpath="//button[@id='btnAddClassCode']")
	public WebElement btnAddSubClassCode;

	@FindBy (xpath="//input[@class='dynamicAddClassCode form-control'][@name='percentage']")
	public WebElement SubClasscodePercentage;

	@FindBy (xpath="//input[@id='fullPartners']")
	public WebElement txtActivePartner;

	@FindBy (xpath="//span[@id='select2-ddACVLimitFloater-container']")
	public WebElement dpdinstallationfloater;
					
	@FindBy (xpath="//span[@id='select2-ddACVLimitHandTools-container']")
	public WebElement dpdContractorHandtools;

	@FindBy (xpath="//span[@id='select2-ddACVLimitLeasedEquipment-container']")
	public WebElement dpdleasedequipment;
	
	@FindBy (xpath="//input[@value='CLOSE']")
	public WebElement btnClose;
	
	@FindBy (xpath="//div[@class ='modal-body text-danger']/ul/li")
	public WebElement ErrorMessage;
	
	@FindBy (xpath="//input[@id='btnAdd']")
	public WebElement btn_ScheduleEquip;
	
	@FindBy (xpath="//label[@id='aDeleteRow']")
	public WebElement btn_RemoveScheduleEquip;
	
	@FindBy (xpath="//input[@class='form-control EquipmentTB ']")
	public WebElement txt_ScheduleEquipDesc;
	
	@FindBy (xpath="//input[@name='txtACVLimit']")
	public WebElement txt_ScheduleEquipAcount;
//--------	
	@FindBy(xpath = "//label[@id='lblQuoteDate']")
	private WebElement lbl_QuoteDate;

	@FindBy(xpath = "//label[@id='lblTerm']")
	private WebElement lbl_Term;
	
	@FindBy(xpath = "//label[@id='lblCountyTerritory']")
	private WebElement lbl_CountyTerritory;

	@FindBy(xpath = "//label[@id='lblInsuredName']")
	private WebElement lbl_InsuredName;

	@FindBy(xpath = "//input[@id='txtProducerFee']")
	private WebElement txt_ProducerFee;
	
	@FindBy(xpath = "//span[@id='lblFWCIPremium']")
	private WebElement lbl_FWCIPremium;
	
	@FindBy(xpath = "//span[@id='lblCBPremium']")
	private WebElement lbl_CBPremium;
	
	@FindBy(xpath = "//span[@id='lblFWCIMGAPolicyFee']")
	private WebElement lbl_FWCIMGAPolicyFee;
	
	@FindBy(xpath = "//span[@id='lblCBMGAPolicyFee']")
	private WebElement lbl_CBMGAPolicyFee;

	@FindBy(xpath = "//span[@id='lblFWCIProducerFee']")
	private WebElement lbl_FWCIProducerFee;
	
	@FindBy(xpath = "//span[@id='lblCBProducerFee']")
	private WebElement lbl_CBProducerFee;
	
	@FindBy(xpath = "//span[@id='lblFWCITotalPremium']")
	private WebElement lbl_FWCITotalPremium;

	@FindBy(xpath = "//span[@id='lblCBTotalPremium']")
	private WebElement lbl_CBTotalPremium;
	
	@FindBy(xpath = "//label[@for='rdoFWCI']")
	private WebElement rdo_FWCIbutton;

	@FindBy(xpath = "//label[@for='rdoClearBlue']")
	private WebElement rdo_CBbutton;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement btn_ICSavebutton;

	@FindBy(xpath = "//input[@value='APPLICATION & ISSUE']")
	private WebElement btn_Appbutton;
	
	@FindBy(xpath = "//input[@id='btnSaveProducerFee']")
	private WebElement btn_SaveProducerFee;
	
	@FindBy(xpath = "//input[@value='CLOSE']")
	private WebElement btn_CloseProducerFee;
	
	@FindBy(xpath = "//input[@id='lnkDownloadFWCIQuote']")
	private WebElement lnk_DownloadFWCIQuote;
	
	@FindBy(xpath = "//input[@id='lnkDownloadCBQuote']")
	private WebElement lnk_DownloadCBQuote;

	@FindBy(xpath = "//label[@id='lblQuoteNo']")
	private WebElement lbl_QuoteNo;

	@FindBy(xpath = "//input[@id='txtApplicationDate']")
	private WebElement txtApplicationDate;
	
	@FindBy(xpath = "//span[@id='select2-ddlBusinessType-container']")
	private WebElement dpdBusinessType;
	
	@FindBy(xpath = "//input[@id='txtInspectionContact']")
	private WebElement txtInspectionContact;
	
	@FindBy(xpath = "//input[@id='txtLocationAddress1']")
	private WebElement txtFristAddressline;
	
	@FindBy(xpath = "//input[@id='txtLocationAddress2']")
	private WebElement txtSecAddressline;
	
	@FindBy(xpath = "//input[@id='txtLocationCity']")
	private WebElement txtLocationCity;
	
	@FindBy(xpath = "//input[@id='txtLocationZipCode']")
	private WebElement txtLocationZipCode;
	
	@FindBy(xpath = "//input[@id='txtBusinessPhone']")
	private WebElement txtBusinessPhone;
	
	@FindBy(xpath = "//input[@id='txtBusinessEmail']")
	private WebElement txtBusinessEmail;
	
	@FindBy(xpath = "//input[@id='txtBusinessFEINSSN']")
	private WebElement txtBusinessFEINSSN;
	
	@FindBy(xpath = "//label[@for='chkSameAddress']")
	private WebElement chkSameAddress;
	
	@FindBy(xpath = "//input[@id='txtExpirationDate']")
	private WebElement txtExpirationDate;
	
	@FindBy(xpath = "//input[@id='txtInsuranceCarrier']")
	private WebElement txtInsuranceCarrier;
	
	@FindBy(xpath = "//textarea[@id='txtGeneralRemarks']")
	private WebElement txtGeneralRemarks;
	
	@FindBy(xpath = "//input[@id ='txtLicenseType']")
	private WebElement txtLicenseType;
	
	@FindBy(xpath = "//input[@id ='txtLicenseNumber']")
	private WebElement txtLicenseNumber;
	
	@FindBy(xpath = "//label[@for='rdoAgree']")
	private WebElement rdoAgree;
	
	@FindBy(xpath = "//input[@id='btnPrintSubmit']")
	private WebElement btnPrintSubmit;
	
	@FindBy(xpath = "//input[@id='btnPaymentIssue']")
	private WebElement btnPaymentIssue;
	
	@FindBy(xpath = "//a[contains(text(),'Use as is')]")
	private WebElement Useasis;

	//----
	@FindBy(xpath = "//input[@id='txtIndustrial']")
	private WebElement txtIndustrial;
	
	@FindBy(xpath = "//input[@id ='txtCommercial']")
	private WebElement txtCommercial;
	
	@FindBy(xpath = "//input[@id ='txtResidential']")
	private WebElement txtResidential;
	
	@FindBy(xpath = "//input[@id ='txtRoomAdditions']")
	private WebElement txtRoomAdditionsPercent;
	
	@FindBy(xpath = "//input[@id ='txtRemodeling']")
	private WebElement txtRemodeling;
	
	@FindBy(xpath = "//input[@id='txtRepaireOrService']")
	private WebElement txtRepaireOrService;
	
	@FindBy(xpath = "//input[@id='txtNewConstruction']")
	private WebElement txtNewConstruction;
	
	@FindBy(xpath = "//label[@for='rdoPerformContractYes']")
	private WebElement rdoPerformContractYes;
	
	@FindBy(xpath = "//input[@id='txtWorkSubcontracted']")
	private WebElement txtWorkSubcontracted;
	
	@FindBy(xpath = "//label[@for='rdoRequireCertificatesGLYes']")
	private WebElement rdoRequireCertificatesGLYes;
	
	@FindBy(xpath = "//label[@for='rdoRequireCertificatesWCYes']")
	private WebElement rdoRequireCertificatesWCYes;
	
	//--------- schedule mod ----------
	
	@FindBy(xpath = "//input[@id='txtMakeEq1']")
	private WebElement txtSMMake;
	
	@FindBy(xpath = "//input[@id='txtModelEq1']")
	private WebElement txtSMModel;
	
	@FindBy(xpath = "//input[@id='txtSerialEq1']")
	private WebElement txtSMSerialNo;
	
	@FindBy(xpath = "//label[@for='chkLossPayeeEq1']")
	private WebElement chkSMLossPayee;

	@FindBy(xpath = "//input[@id='txtNameEq1']")
	private WebElement txtSMName;
	
	@FindBy(xpath = "//input[@id='txtAdd1Eq1']")
	private WebElement txtSMAddr;
	
	@FindBy(xpath = "//input[@id='txtCityEq1']")
	private WebElement txtSMCity;
	
	@FindBy(xpath = "//input[@id='txtZipEq1']")
	private WebElement txtSMZip;
	
   //----------------------------------
	
	@FindBy (xpath="//input[@value='MAKE PAYMENT & ISSUE']")
	private WebElement GLMakePayment;
	
	// --------- AI ------------
	
	@FindBy (xpath="//div[@id='FCG1001']/label")
	private WebElement rdFCG1001;
	
	@FindBy (xpath="//input[@id='txtindividualCG2010']")
	private WebElement rdCG2010;
	
	@FindBy (xpath="//input[@id='txtindividualCG2037']")
	private WebElement rdCG2037;
	
	@FindBy (xpath="//input[@id='txtindividualFCG993']")
	private WebElement rdCG1019;
	
	@FindBy (xpath="//input[@id='txtindividualCG2404']")
	private WebElement rdCG2404;

	@FindBy (xpath="//input[@id='txtQuestnVal_CG2012']")
	private WebElement rdCG2012;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2029']")
	private WebElement rdCG2029;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2028']")
	private WebElement rdCG2028;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2024']")
	private WebElement rdCG2024;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2005']")
	private WebElement rdCG2005;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2011']")
	private WebElement rdCG2011;
	
	@FindBy (xpath="//input[@id='txtQuestnVal_CG2026']")
	private WebElement rdCG2026;
	
	@FindBy (xpath="//div[@id='CG2007']/label")
	private WebElement rdCG2007;
	
	//---------------------
	@FindBy(xpath = "//button[@data-resin-target='download']")
	private static WebElement Applicationdownload;
	
	@FindBy(xpath = "//label[@for='chkIssue_1']")
	private WebElement chkIssue_Line1;
	
	@FindBy(xpath = "//input[@id='chkIssue_2']") 
	private WebElement chkIssue_Line2;
	
	@FindBy(xpath = "//input[@id='chkIssue_3']") 
	private WebElement chkIssue_Line3;
	
	@FindBy(xpath = "//*[text()='10 Pay']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_10pay;

	@FindBy(xpath = "//*[text()='4 Pay Bi-Monthly']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_4paybimonthly;
	
	@FindBy(xpath = "//*[text()='4 Pay Monthly']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_4paymonthly;
	
	@FindBy(xpath = "//*[text()='Full Pay']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_Fullpay;

	@FindBy(xpath = "//*[text()='Premium Finance']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_PremiumFinance;
	
	@FindBy(xpath = "//*[text()='FrankCrum Pay Go']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_FrankCrumpaygo;
	
    @FindBy(xpath = "//*[text()='PayAsYouGo 0% Down']//preceding-sibling::td//label")
    private WebElement chkPaymentOpt_PayAsYouGo0Down;

   @FindBy(xpath = "//*[text()='25% Down / 3 Installments']//preceding-sibling::td//label")
   private WebElement chkPaymentOpt_25Down3Installments;

   @FindBy(xpath = "//*[text()='PayAsYouGo 10% Down']//preceding-sibling::td//label")
   private WebElement chkPaymentOpt_PayAsYouGo10Down;

   @FindBy(xpath = "//*[text()='12 Equal']//preceding-sibling::td//label")
   private WebElement chkPaymentOpt_12Equal;

   @FindBy(xpath = "//*[text()='15% Down / 9 Installments']//preceding-sibling::td//label")
   private WebElement chkPaymentOpt_15Down9Installments;
	
   @FindBy(xpath = "//*[text()='25% Down / 9 Installments']//preceding-sibling::td//label")
   private WebElement chkPaymentOpt_25Down9Installments;
	
	@FindBy(xpath = "//*[text()='PayAsYouGo 15% Down']//preceding-sibling::td//label")
	private WebElement chkPaymentOpt_PayAsYouGo15Down;
	
	@FindBy(xpath = "//span[@id='select2-ddlDeposit-container']")
	private WebElement dpddepositpaymentmethod;
	 
	@FindBy(xpath = "//label[@id='lblNumber']")
	private WebElement txtPolicyNumber;
	
	@FindBy(xpath = "//a[contains(text(),'PRINT EVIDENCE OF INSURANCE')]")
	private WebElement lnkDownloadEvidence;
	
	@FindBy(xpath = "//input[@value='SEND CHECK AND ISSUE POLICY']")
	private WebElement clkCheckPayment;

	@FindBy(xpath = "//input[@value='ISSUE POLICY']")
	private WebElement clkPremiumFinancePayment;

	@FindBy(xpath = "//input[@value='MAKE ONLINE PAYMENT & ISSUE POLICY']")
	private WebElement clkOnlinePayment;

	//------- Worker Compensation --------
	
	@FindBy(xpath = "//label[@id='lblPolicyNumber']")
	private WebElement WCtxtPolicyNumber;
	
	@FindBy(xpath = "//div[@id='divMakeIssuePolicy']//input[@value='REQUEST ISSUANCE & MAKE PAYMENT']")
	private WebElement WCclkPremiumFinancePayment;
	
	@FindBy(xpath = "//div[@id='divSendCheck']//input[@value='REQUEST ISSUANCE & MAKE PAYMENT']")
	private WebElement WCclkCheckPayment;
	
	@FindBy (xpath="//span[@id='select2-ddlState1-container']")
	public WebElement WCState;
	
	@FindBy (xpath="//input[@id='txtClassCodes1']")
	public WebElement txtWCClassCodes;
	
	@FindBy (xpath="//input[@id='btnAddEligibility']")
	public WebElement btnWCAddClassCode;
	
	@FindBy (xpath="//input[@id='btnContinue']")
	public WebElement btnWCContinue;
	
	@FindBy (xpath="//input[@id='txtBussInsuredName']")
	public WebElement txtWCBussInsuredName;
	
	@FindBy (xpath="//span[@id='select2-ddlLegalEntity-container']")
	public WebElement dpdWCLegalEntity;
	
	@FindBy (xpath="//input[@id='txtDBAName']")
	public WebElement txtWCDBAName;
	
	@FindBy (xpath="//label[@id='txtDBAName-error']")
	public WebElement txtWCDBANameerror;
	
	@FindBy (xpath="//input[@id='txtAddress1']")
	public WebElement txtWCAddress1;
	
	@FindBy (xpath="//input[@id='txtAddress2']")
	public WebElement txtWCAddress2;
	
	@FindBy (xpath="//input[@id='txtAddinsuredName1']")
	public WebElement txtWCAddinsuredName1;
	 
	@FindBy (xpath="//input[@id='txtFEINNo1']")
	public WebElement txtWCFEINNo1;
	
	@FindBy (xpath="//input[@id='txtCity']")
	public WebElement txtWCCity;
	
	@FindBy (xpath="//input[@id='txtZipCode']")
	public WebElement txtWCZipCode;
	
	@FindBy (xpath="//input[@id ='txtDateBussinessStart']")
	public WebElement txtWCDateBussinessStart;
	
	@FindBy (xpath="//input[@id ='txtEffectiveDate']")
	public WebElement txtWCEffectiveDate;
	
	@FindBy (xpath="//input[@id='rdoCurrExpModYes']")
	public WebElement lblWCrdoCurrExpModYes;
	
	@FindBy (xpath="//label[@for ='rdoCurrExpModNo']")
	public WebElement lblWCrdoCurrExpModNo;
	
	@FindBy (xpath="//input[@id ='txtExpMod']")
	public WebElement txtWCExpMod;
	
	@FindBy (xpath="//input[@id ='txtFirstName1']")
	public WebElement txtWCFirstName;
	
	@FindBy (xpath="//input[@id ='txtLastName1']")
	public WebElement txtWCLastName;
	
	@FindBy (xpath="//input[@id ='txtPerOwner1']")
	public WebElement txtWCPerOwner;
	
	@FindBy (xpath="//input[@id='radio1']")
	public WebElement txtWCIncluderd;
	
	@FindBy (xpath="//input[@id='radios1']")
	public WebElement txtWCExcluderd;
	
	@FindBy (xpath="//textarea[@id ='txtDescriptionOfOprations']")
	public WebElement txtWCdesc;
	
	@FindBy (xpath="//span[@id='select2-ddlEmpLiabLimit-container']")
	public WebElement dpdWCEmployerLimit;
	
	@FindBy (xpath="//input[@id='txtFTEmployee1']")
	public WebElement txtWCFTEmployee;
			
	@FindBy (xpath="//input[@id='txtPTEmployee1']")
	public WebElement txtWCPTEmployee;
	
	@FindBy (xpath="//input[@id='txtGrossannualPayroll1']")
	public WebElement txtWCGrossannualPayroll;
	
	@FindBy (xpath="//input[@id='BtnNext']")
	public WebElement BtnWCNext;
	
	@FindBy (xpath="//form[@id='frmBussiSumm']")
	public WebElement clkBusinessSummaryPage;
	
	@FindBy (xpath="//input[@id='txtAOCode1']")
	public WebElement WCtxtInOwnClassCode;
	
	@FindBy (xpath="//input[@id='txtAOFTEmp1']")
	public WebElement txtOWWCFTEmployee;
	
	@FindBy (xpath="//input[@id='txtAOGross1']")
	public WebElement txtOWWCGross;
	
	@FindBy (xpath="//label[@id='LblPage']")
	public WebElement txtWCPageLabel;
	
	@FindBy (xpath="//input[@value='CLOSE']")
	public WebElement txtClosebtn;
	
	@FindBy (xpath="//span[@id='select2-ddlState-container']")
	public WebElement dpdAddressState;
	//	General Questions
	
	
	@FindBy (xpath="//input[@id='radio-1']")
	public WebElement rdQuestion_1;
	
	@FindBy (xpath="//input[@id='radio-2']")
	public WebElement rdQuestion_2;
	
	@FindBy (xpath="//input[@id='radio-3']")
	public WebElement rdQuestion_3;
	
	@FindBy (xpath="//input[@id='radio4']")
	public WebElement rdQuestion_4;
	
	@FindBy (xpath="//input[@id='radio-6']")
	public WebElement rdQuestion_5;
	
	@FindBy (xpath="//input[@id='radio-7']")
	public WebElement rdQuestion_6;
	
	@FindBy (xpath="//input[@id='radio-9']")
	public WebElement rdQuestion_7;
	
	@FindBy (xpath="//input[@id='radio-11']")
	public WebElement rdQuestion_8;
	
	@FindBy (xpath="//input[@id='radio-13']")
	public WebElement rdQuestion_9;
	
	@FindBy (xpath="//input[@id='radio-15']")
	public WebElement rdQuestion_10;
	
	@FindBy (xpath="//input[@id='radio-17']")
	public WebElement rdQuestion_11;
	
	@FindBy (xpath="//input[@id='radio-19']")
	public WebElement rdQuestion_12;
	
	@FindBy (xpath="//input[@id='radio-21']")
	public WebElement rdQuestion_13;
	
	@FindBy (xpath="//input[@id='IQchk534BeddingnbspPlants']")
	public WebElement chkBedding;
	
	//Industrial Questions
	
	@FindBy (xpath="//input[@id='IQradio-3']")
	public WebElement rdIQuestion_1;
	
	@FindBy (xpath="//input[@id='IQradio-4']")
	public WebElement rdIQuestion_2;
	
	@FindBy (xpath="//input[@id='IQradio-9']")
	public WebElement rdIQuestion_3;
	
	@FindBy (xpath="//input[@id='IQradio9']")
	public WebElement rdIQuestion_4;
	
	@FindBy (xpath="//input[@id='IQradio-11']")
	public WebElement rdIQuestion_5;
	
	@FindBy (xpath="//input[@id='IQradio-12']")
	public WebElement rdIQuestion_6;
	
	@FindBy (xpath="//input[@id='IQradio-13']")
	public WebElement rdIQuestion_7;
	
	@FindBy (xpath="//input[@id='IQradio13']")
	public WebElement rdIQuestion_8;
	
	@FindBy (xpath="//input[@id='IQradio14']")
	public WebElement rdIQuestion_9;
	
	@FindBy (xpath="//input[@id='IQradio-16']")
	public WebElement rdIQuestion_10;
	
	@FindBy (xpath="//input[@id='IQradio-17']")
	public WebElement rdIQuestion_11;
	
	@FindBy (xpath="//input[@id='IQradio-18']")
	public WebElement rdIQuestion_12;
	
	@FindBy (xpath="//input[@id='IQradio19']")
	public WebElement rdIQuestion_13;

	@FindBy (xpath="//input[@id='IQradio20']")
	public WebElement rdIQuestion_14;
	
	@FindBy (xpath="//input[@id='IQradio-22']")
	public WebElement rdIQuestion_15;
	
//	Losses Page elemnet
	
	@FindBy (xpath="//span[@id='select2-ddlHadCoverage2020-container']")
	public WebElement gethadCoverage;
	
	@FindBy (xpath="//input[@id='radioN2020']")
	public WebElement rdAnyLosses;
	
	@FindBy (xpath="//input[@id='BtnSubmit']")
	public WebElement btnSubmit;
	
	@FindBy (xpath="//input[@id='carrier0']")
	public WebElement gettxtLossCarrier;
	
	@FindBy (xpath="//span[@id='select2-ddlInsuredName-container']")
	public WebElement selWCNameInsured;
	
	@FindBy (xpath="//ul[@id='select2-ddlInsuredName-results']")
	public WebElement WCNameInsuredresult;
	
	@FindBy (xpath="//span[@id='select2-ddlRelationship-container']")
	public WebElement WCApplicationRelationsip;
	
	@FindBy (xpath="//input[@id='txtLocationAddress1']")
	public WebElement WAppliactionCAddress1;
	
	@FindBy (xpath="//input[@id='txtLocationCity']")
	public WebElement WCAppliactionCity;
	
	@FindBy (xpath="//span[@id='select2-ddlLocationState-container']")
	public WebElement WCAppliactionState;
	
	@FindBy (xpath="//input[@id='txtLocationZip']")
	public WebElement WCAppliactionZipcode;
	
	@FindBy (xpath="//input[@id='btnAddLocation']")
	public WebElement WCAppliactionAddLoact;
	
	
	@FindBy (xpath="//li[contains(text(), 'FCGA AUTM-361785710DB')]")
	public WebElement WCNameInsuredList1;
	
	@FindBy (xpath="//ul[@id='select2-ddlInsuredName-results']")
	public WebElement WCNameInsuredtxt;
	
	@FindBy (xpath="//li[contains(text(),'Sid Mishra')]")
	public WebElement 	WCNameInsuredtxt2;
	
	//span[@id='select2-ddlMainInsuredMailingAddr-container']
	@FindBy (xpath="//span[@id='select2-ddlMainInsuredMailingAddr-container']")
	public WebElement WCconatactMailingAddress;
	
	@FindBy (xpath="//input[@id='txtMainInsuredContactName']")
	public WebElement WCconatactName;
	
	@FindBy (xpath="//input[@id='txtMainInsuredPhone']")
	public WebElement WCcontactPhone;
	
	@FindBy (xpath="//input[@id='txtMainInsuredEmail']")
	public WebElement WCcontactEmail;
	
	@FindBy (xpath="//input[@id='txtMainInsuredAddress1']")
	public WebElement WCcontactAddress1;
	
	@FindBy (xpath="//label[@for='rdoAgree']")
	public WebElement WCAgreebtn;
	
	@FindBy (xpath="//input[@value='Make Payment & Issue']")
	public WebElement WCMakePayment;
	
	@FindBy (xpath="//input[@id='btnDownloadQuote']")
	public WebElement btnWCDownloadQuote;
	
	@FindBy (xpath="//input[@id='btnDownloadRatingWorksheet']")
	public WebElement btnWCDownloadRatingWorksheet;
	
	@FindBy (xpath="//input[@id='btnDownloadApplication']")
	public WebElement btnWCDownloadApplication;
	
	@FindBy (xpath="//a[@id='lnkCondensedRatingWorksheet']")
	public WebElement lnkWCCondensedRatingWorksheet;
	
	@FindBy (xpath="//div[@id='QuoteModal']/div/div/div/p[1]")
	public WebElement WCReferralText;
	
	@FindBy (xpath="//button[@id='BtnBack']")
	public WebElement WCBacktoRecord;
	
	@FindBy (xpath="//input[@id='txtsearch']")
	public WebElement txtUWSearch;
	
	@FindBy (xpath="//input[@id='txtSearch']")
	public WebElement txtAgentSearch;
	
	@FindBy (xpath="//input[@id='btnSearch']")
	public WebElement btnSearch;
	
	@FindBy (xpath="//button[@id='btnAction']")
	public WebElement btnAction;
	
	@FindBy (xpath="//a[contains(text(),'Edit Quote')]")
	public WebElement btnEditQuote;
	
	@FindBy (xpath="//a[contains(text(),'Messages')]")
	public WebElement btnMessages;
	
	@FindBy (xpath="//textarea[@id='txtRefferal']")
	public WebElement txtRefferal;
	
	@FindBy (xpath="//button[@id='BtnDone']")
	public WebElement BtnDoneRefferal;
	
	@FindBy (xpath="//select[@id='ddlCurrentStatus']")
	public WebElement UWCurrentStatus;
	
	@FindBy (xpath="//select[@id='ddlCurrentStatus']/option[1]")
	public WebElement UWInProgressStatus;

	@FindBy (xpath="//select[@id='ddlCurrentStatus']/option[2]")
	public WebElement UWSubmittedStatus;
	
	@FindBy (xpath="//select[@id='ddlCurrentStatus']/option[3]")
	public WebElement UWAcceptedStatus;

	@FindBy (xpath="//select[@id='ddlCurrentStatus']/option[4]")
	public WebElement UWDeclinedStatus;
	
	@FindBy (xpath="//input[@id='btnReRate']")
	public WebElement UWbtnReRate;
	
	@FindBy (xpath="//div[@id ='dvQuoteDoc']//input[@id='btnExit_Common']")
	public WebElement UWbtnExit;
	
	@FindBy (xpath="//div[starts-with(@id,'AlertMsgBox')]/div/div/div[2]")
	public WebElement UWAlertMsgBox;
	
	@FindBy (xpath="//button[@id='GLEditQuote']")
	public WebElement UWGLEditQuote;

	@FindBy (xpath="//label[@id='LblPage']")
	public WebElement UWLblPage;
	
	@FindBy (xpath="//a[@data-step='end']")
	public WebElement iframeCancelButton;
	
	@FindBy (xpath="//ul[@id='ulReferralReason']/li")
	public WebElement UWReferralReason;
	
	@FindBy (xpath="//input[@id='BtnCSPSave']")
	public WebElement UWBtnSave;
	
	@FindBy (xpath="//div[@id='pgBody']/h1")
	public WebElement UWAdditionalInsured;
	
	@FindBy (xpath="//div[@id='pgBody']/div[1]/div/h1")
	public WebElement UWClassPayroll;
	
	@FindBy (xpath="//input[@id='txtIRPM']")
	public WebElement txtUWIRPM;
	
	@FindBy (xpath="//input[@id='txtIRPM1']")
	public WebElement txtUWIRPM1;
	
	@FindBy (xpath="//input[@id='txtIRPMCTR']")
	public WebElement txtUWIRPMCTR;
	
	@FindBy (xpath="//label[@for='chkConsentToRate']")
	public WebElement chkConsentToRate;
	
	@FindBy (xpath="//button[@id='BtnClose']")
	public WebElement txtAppClosebtn;
	
	//------notes and messages--------
	
	@FindBy (xpath="//button[@id='btnenvlop']")
	public WebElement UWNotes;
	
	@FindBy (xpath="//textarea[@id='txtQuoteNote']")
	public WebElement txtNotes;
	
	@FindBy (xpath="//input[@id='BtnPostNote']")
	public WebElement UWPostNote;
	
	@FindBy (xpath="//button[@id='btnsticynote']")
	public WebElement UWMessages;
	
	@FindBy (xpath="//textarea[@id='txtQuoteQuestion']")
	public WebElement txtMessages;
	
	@FindBy (xpath="//button [@id='btntxtfile']")
	public WebElement UWdocs;
	
	@FindBy (xpath="//a[@id='QDoccollapseThree']")
	public WebElement UWotherdocs;
	
	@FindBy (xpath="//form[@id='demo-upload']")
	public WebElement UWdocsupload;
	
	@FindBy (xpath="//input[@id='BtnAskProducer']")
	public WebElement UWAskProducer;
	
	@FindBy (xpath="//a[@id='lnknmNotes']/span/i")
	public WebElement GLMessages;
	
	@FindBy (xpath="//textarea[@id='txtNMNote']")
	public WebElement GLtxtNote;
	
	@FindBy (xpath="//button[@id='btnNMSave']")
	public WebElement GLSend;
	
	@FindBy (xpath="//span[@data-id='chat_window_1']")
	public WebElement GLClose;
	
	//------------------
	
	ObjectRepository(WebDriver driver) {
		PageFactory.initElements(driver, this); // 15, TimeUnit.SECONDS, this) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);
		this.driver = driver;

	}

	public static ObjectRepository getInstance(WebDriver driver) {
		objectrepository = new ObjectRepository(driver);
		return objectrepository;
	}
	
	
	public WebElement getLoadingWait() {
		return LoadingWait;
	}

	
	//----------------notes and messages-------------
	
	public WebElement getUWNotes() {
		return UWNotes;
	}
	
	public WebElement gettxtNotes() {
		return txtNotes;
	}
	
	public WebElement getUWPostNote() {
		return UWPostNote;
	}
	
	public WebElement getUWMessages() {
		return UWMessages;
	}
	
	public WebElement getUWdocs() {
		return UWdocs;
	}
	
	public WebElement getUWotherdocs() {
		return UWotherdocs;
	}
	
	public WebElement getUWdocsupload() {
		return UWdocsupload;
	}
	
	public WebElement gettxtMessages() {
		return txtMessages;
	}
	
	public WebElement getUWAskProducer() {
		return UWAskProducer;
	}
	
	public WebElement getGLMessages() {
		return GLMessages;
	}
	
	public WebElement getGLtxtNote() {
		return GLtxtNote;
	}
	
	public WebElement getGLSend() {
		return GLSend;
	}
	
	public WebElement getGLClose() {
		return GLClose;
	}
	
	// ------ WC Changes --------
	
	public WebElement gettxtWCCity() {
		return txtWCCity;
	}
	public WebElement getdpdAddressState() {
		return dpdAddressState;
	}
	public WebElement gettxtOWWCGross() {
	return txtOWWCGross;
	}
	
	public WebElement gettxtWCPageLabel() {
		return txtWCPageLabel;
	}
	public WebElement gettxtWCClosebtn() {
		return txtClosebtn;
	}
	public WebElement gettxtOWWCFTEmployee() {
		return txtOWWCFTEmployee;
	}
	public WebElement getWCtxtInOwnClassCode() {
		return WCtxtInOwnClassCode;
	}
	public WebElement getWCtxtPolicyNumber() {
		return WCtxtPolicyNumber;
	}
	
	public WebElement getWCclkPremiumFinancePayment () {
		return WCclkPremiumFinancePayment;
	}
	
	public WebElement getWCclkCheckPayment() {
		return WCclkCheckPayment;
	}
	
	public WebElement getWCState() {
		return WCState;
	}
	
	public WebElement gettxtWCClassCodes() {
		return txtWCClassCodes;
	}
	
	public WebElement getbtnWCAddClassCode() {
		return btnWCAddClassCode;
	}
	
	public WebElement getbtnWCContinue() {
		return btnWCContinue;
	}
	
	public WebElement gettxtWCBussInsuredName() {
		return txtWCBussInsuredName;
	}
	public WebElement getdpdWCLegalEntity() {
		return dpdWCLegalEntity;
	}
	
	public WebElement gettxtWCDBAName(){
		return txtWCDBAName;
	}
	
	public WebElement gettxtWCDBANameerror() {
		return txtWCDBANameerror;
	}
	
	public WebElement gettxtWCAddress1() {
		return txtWCAddress1;
	}
	
	public WebElement gettxtWCAddress2() {
		return txtWCAddress2;
	}
	
	public WebElement gettxtWCAddinsuredName1() {
		return txtWCAddinsuredName1;
	}
	
	public WebElement gettxtWCFEINNo1() {
		return txtWCFEINNo1;
	}
	
	public WebElement gettxtWCZipCode() {
		return txtWCZipCode;
	}
	
	public WebElement gettxtWCDateBussinessStart() {
		return txtWCDateBussinessStart;
	}
	
	public WebElement getdpdWCEmployerLimit() {
		return dpdWCEmployerLimit;
	}
	
	public WebElement gettxtWCEffectiveDate() {
		return txtWCEffectiveDate;
	}
	
	public WebElement getlblWCrdoCurrExpModNo() {
		return lblWCrdoCurrExpModNo;
	}
	public WebElement getlblWCrdoCurrExpModYes() {
		return lblWCrdoCurrExpModYes;
	}
	
	public WebElement gettxtWCExpMod() {
		return txtWCExpMod;
	}
	
	public WebElement gettxtWCFirstName() {
		return txtWCFirstName;
	}
	
	public WebElement gettxtWCLastName() {
		return txtWCLastName;
	}
	
	public WebElement gettxtWCPerOwner() {
		return txtWCPerOwner;
	}
	
	public WebElement gettxtWCIncluderd() {
		return txtWCIncluderd;
	}
	
	public WebElement gettxtWCExcluderd() {
		return txtWCExcluderd;
	}
	
	public WebElement gettxtWCdesc() {
		return txtWCdesc;
	}
	
	public WebElement gettxtWCFTEmployee() {
		return txtWCFTEmployee;
	}
	public WebElement gettxtWCPTEmployee() {
		return txtWCPTEmployee;
	}
	
	public WebElement gettxtWCGrossannualPayroll() {
		return txtWCGrossannualPayroll;
	}
	
	public WebElement getBtnWCNext() {
		return BtnWCNext;
	}
	//----- GL Changes -----------
	
	public WebElement GKAlertMsgBox() {
		return GKAlertMsgBox;
	}
	
	public WebElement getGLMakePayment() {
		  return GLMakePayment;
	  }
	
	public static WebElement getApplicationdownload() {
		return Applicationdownload;
	}
	public WebElement getlnkDownloadEvidence() {
		return lnkDownloadEvidence;
	}
	public WebElement gettxtPolicyNumber() {
		return txtPolicyNumber;
	}
	public WebElement gettxtIndustrial() {
		return txtIndustrial;
	}
	
	public WebElement gettxtCommercial() {
		return txtCommercial;
	}
	
	public WebElement gettxtResidential() {
		return txtResidential;
	}
	
	public WebElement gettxtRoomAdditionsPercent() {
		return txtRoomAdditionsPercent;
	}
	
	public WebElement gettxtRemodeling() {
		return txtRemodeling;
	}

	public WebElement gettxtRepairorService() {
		return txtRepaireOrService;
		
	}
	
	public WebElement gettxtNewConstruction() {
		return txtNewConstruction;
	}
	
	public WebElement getrdoPerformContractYes() {
		return rdoPerformContractYes;
	}
	
	public WebElement gettxtWorkSubcontracted() {
		return txtWorkSubcontracted;
	}
	
	public WebElement getrdoRequireCertificatesGLYes() {
		return rdoRequireCertificatesGLYes;
	}
	
	public WebElement getrdoRequireCertificatesWCYes() {
		return rdoRequireCertificatesWCYes;
	}
	public WebElement gettxtSMMake() {
	    return txtSMMake;
	} 
	public WebElement gettxtSMModel() {
	    return txtSMModel;
	}   
	public WebElement gettxtSMSerialNo() {
	   return txtSMSerialNo;
	}  
	public WebElement getchkSMLossPayee() {
	   return chkSMLossPayee;
	}  
	public WebElement gettxtSMName() { 
	   return txtSMName;
	}  
	public WebElement gettxtSMAddr() {
	   return txtSMAddr;
	}  
	public WebElement gettxtSMCity() {
	   return txtSMCity;
	}  
	public WebElement gettxtSMZip() {
	   return txtSMZip;
	}  
	public WebElement getUseasis() {
		return Useasis;
	}
	public WebElement gettxtInspectionContact() {
		return txtInspectionContact;
	}
	public WebElement getlnk_DownloadFWCIQuote() {
		return lnk_DownloadFWCIQuote;
	}
	
	public WebElement getlnk_DownloadCBQuote() {
		return lnk_DownloadCBQuote;
	}
	
	public WebElement getlbl_QuoteNo() {
		return lbl_QuoteNo;
	}
	
	public WebElement getlbl_QuoteDate() {
		return lbl_QuoteDate;
	}
	
	public WebElement getlbl_Term() {
		return lbl_Term;
	}
	
	public WebElement getlbl_CountyTerritory() {
		return lbl_CountyTerritory;
	}

	public WebElement getlbl_InsuredName() {
		return lbl_InsuredName;
	}
	
	public WebElement gettxt_ProducerFee() {
		return txt_ProducerFee;
	}
	
	public WebElement getbtn_SaveProducerFee() {
		return btn_SaveProducerFee;
	}
	public WebElement getlbl_FWCIPremium() {
		return lbl_FWCIPremium;
	}
	
	public WebElement getlbl_CBPremium() {
		return lbl_CBPremium;
	}
	
	public WebElement getlbl_FWCIMGAPolicyFee() {
		return lbl_FWCIMGAPolicyFee;
	}
	
	public WebElement getlbl_CBMGAPolicyFee() {
		return lbl_CBMGAPolicyFee;
	}
	
	public WebElement getlbl_FWCIProducerFee() {
		return lbl_FWCIProducerFee;
	}
	
	public WebElement getlbl_CBProducerFee() {
		return lbl_CBProducerFee;
	}
	public WebElement getbtn_CloseProducerFee() {
		return btn_CloseProducerFee;
	}
	
	public WebElement getlbl_FWCITotalPremium() {
		return lbl_FWCITotalPremium;
	}
	
	public WebElement getlbl_CBTotalPremium() {
		return lbl_CBTotalPremium;
	}
	
	public WebElement getrdo_FWCIbutton() {
		return rdo_FWCIbutton;
	}
	
	public WebElement getrdo_CBbutton() {
		return rdo_CBbutton;
	}

	public WebElement getbtn_ICSavebutton() {
		return btn_ICSavebutton;
	}

	public WebElement getbtn_Appbutton() {
		return btn_Appbutton;
	}
	
	public WebElement getErrorMessage() {
		return ErrorMessage;
	}
	
	public WebElement getbtnClose() {
		return btnClose;
	}
	
	public WebElement getInpUserNameLogin() {
		return inpUserNameLogin;
	}

	public WebElement getInpPasswordLogin() {
		return inpPasswordLogin;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
    }

	public WebElement getBtnLogOff() {
		return btnSignOut;
	}

	public WebElement getUWUserName() {
		return lblUserName;
	}
	
	public WebElement getSelectAgent() {
		return dd_SelectAgent;
	}
	
	public WebElement getSearchAgent() {
		return inpSearch;
	}	
	
	public WebElement getbtnContinue() {
		return btnContinue;
	}
	public WebElement getbtnNewQuote() {
		return btnNewQuote;
	}
	
	public WebElement getbtnrdbGeneralLiability () {
		return btnrdbGeneralLiability;
	}
	public WebElement getbtnrdbWorkersComp () {
		return btnrdbWorkersComp;
	}
	public WebElement getinpFEIN () {
		return inpFEIN;
	}
	public WebElement getbtnHContinue() {
		return btnHContinue;
	}
	public WebElement getbtnsaveandcontinue() {
		return btnsaveandcontinue;
	}

    public WebElement getdpdstate() {
		return dpdstate;
	}

    public WebElement gettxtUniquetextbox() {
		return txtUniquetextbox;
	}

    public WebElement gettxtEffectiveDate() {
		return txtEffectiveDate;
	}

    public WebElement getdpdCounty() {
		return dpdCounty;
	}

    public WebElement gettxtBusinessName() {
		return txtBusinessName;
	}

    public WebElement gettxtIndividualFirstName() {
		return txtIndividualFirstName;
	}

    public WebElement gettxtIndividualLastName() {
		return txtIndividualLastName;
	}

   public WebElement gettxtDescriptionOfBusiness() {
		return txtDescriptionOfBusiness;
	}

   public WebElement gettxtYearsInBusiness() {
		return txtYearsInBusiness;
	}

   public WebElement gettxtYearsInTrade() {
		return txtYearsInTrade;
	}

   public WebElement gettxtClaims() {
		return txtClaims;
	}

   public WebElement getrbpriorinsuranceYes() {
		return rbpriorinsuranceYes;
	}

   public WebElement getrbpriorinsuranceNo() {
		return rbpriorinsuranceYes;
	}

   public WebElement getdpdliabilitylimit() {
		return dpdliabilitylimit;
	}

   public WebElement getdpdDeductiblelimit() {
		return dpdDeductiblelimit;
	}

   public WebElement getrbAdditionalInsuredsYes() {
 		return rbAdditionalInsuredsYes;
	}

   public WebElement getrbAdditionalInsuredsNo() {
		return rbAdditionalInsuredsNo;
	}

   public WebElement getrbWaiversYes() {
		return rbWaiversYes;
	}

   public WebElement getrbWaiversNo() {
		return rbWaiversNo;
	}

  public WebElement getrbInlandMarineYes() {
		return rbInlandMarineYes;
	}

  public WebElement getrbInlandMarineNo() {
		return rbInlandMarineNo;
	}

  public WebElement gettxtNoofLocation() {
		return txtNoofLocation;
	}

  public WebElement gettxtNoofProject() {
		return txtNoofProject;
	}

  public WebElement getdpdclasscode() {
		return dpdclasscode;
	}

  public WebElement getbtnAddClassCode() {
		return btnAddClassCode;
	}

  public WebElement getClasscodePercentage() {
		return ClasscodePercentage;
	}

  public WebElement gettxtExpectedGrossAmount() {
		return txtExpectedGrossAmount;
	}

  public WebElement getInSubcontractorCost() {
		return InSubcontractorCost;
	}

  public WebElement getSubcontractorCostopdes() {
		return SubcontractorCostopdes;
	}

  public WebElement getUnSubcontractorCost() {
		return UnSubcontractorCost;
	}

  public WebElement getSubClasscodes() {
		return SubClasscodes;
	}

  public WebElement getbtnAddSubClassCode() {
		return btnAddSubClassCode;
	}

  public WebElement getSubClasscodePercentage() {
		return SubClasscodePercentage;
	}

  public WebElement gettxtActivePartner() {
		return txtActivePartner;
	}

  public WebElement getdpdinstallationfloater() {
		return dpdinstallationfloater;
	}

  public WebElement getdpdContractorHandtools() {
		return dpdContractorHandtools;
	}

  public WebElement getdpdleasedequipment() {
		return dpdleasedequipment;
	}
  
  public WebElement getbtnScheduleEquip() {
		return btn_ScheduleEquip;
	}
  
  public WebElement getbtnRemoveScheduleEquip() {
		return btn_RemoveScheduleEquip;
	}
  
  public WebElement gettxtScheduleEquipDesc() {
		return txt_ScheduleEquipDesc;
	}
  
  public WebElement gettxtScheduleEquipAcount() {
		return txt_ScheduleEquipAcount;
	}
  public WebElement gettxtApplicationDate() {
	  return txtApplicationDate;
  }
	
  public WebElement gettxtcontactforinspection() {
	  return txtInspectionContact;
  }
  
  public WebElement getdpdBusinessType() {
	  return dpdBusinessType;
  }
  public WebElement gettxtFristAddressline() {
	  return txtFristAddressline;
  }
	
  public WebElement gettxtSecAddressline() {
	  return txtSecAddressline;
  }
 
  public WebElement gettxtLocationCity() {
	  return txtLocationCity;
  }
 
  public WebElement gettxtLocationZipCode() {
	  return txtLocationZipCode;
  }
 
  public WebElement gettxtBusinessPhone() {
	  return txtBusinessPhone;
  }
 
  public WebElement gettxtBusinessEmail() {
	  return txtBusinessEmail;
  }	
 
  public WebElement gettxtBusinessFEINSSN() {
	  return txtBusinessFEINSSN;
  }
	
  public WebElement getchkSameAddress() {
	  return chkSameAddress;
  }
	
  public WebElement gettxtExpirationDate() {
	  return txtExpirationDate;
  }
	
  public WebElement gettxtInsuranceCarrier() {
	  return txtInsuranceCarrier;
  }
	
  public WebElement gettxtGeneralRemarks() {
	  return txtGeneralRemarks;
  }

  public WebElement gettxtLicenseType() {
	  return txtLicenseType;
  }
  
  public WebElement gettxtLicenseNumber() {
	  return txtLicenseNumber;
  }
  
  public WebElement getrdoAgree() {
	  return rdoAgree;
  }
	
  public WebElement getbtnPrintSubmit() {
	  return btnPrintSubmit;
  }
  
  public WebElement getbtnPaymentIssue() {
  return btnPaymentIssue;
  }
  
  public WebElement getchkIssue_Line1() {
	  return chkIssue_Line1;
  }
  
  public WebElement getchkIssue_Line2() {
	  return chkIssue_Line2;
  }
  
  public WebElement getchkIssue_Line3() {
	  return chkIssue_Line3;
  }

  public WebElement getchkPaymentOpt_10pay() {
	  return chkPaymentOpt_10pay;
  }
  
  public WebElement getchkPaymentOpt_PayAsYouGo0Down() {
	  return chkPaymentOpt_PayAsYouGo0Down;
  }
  
  public WebElement getchkPaymentOpt_25Down3Installments() {
	  return chkPaymentOpt_25Down3Installments;
  }
  
  public WebElement getchkPaymentOpt_PayAsYouGo10Down() {
	  return chkPaymentOpt_PayAsYouGo10Down;
  }
  
  public WebElement getchkPaymentOpt_12Equal() {
	  return chkPaymentOpt_12Equal;
  }
  
  public WebElement getchkPaymentOpt_15Down9Installments() {
	  return chkPaymentOpt_15Down9Installments;
  }
  
  public WebElement getchkPaymentOpt_25Down9Installments() {
	  return chkPaymentOpt_25Down9Installments;
  }
  
  public WebElement getchkPaymentOpt_PayAsYouGo15Down() {
	  return chkPaymentOpt_PayAsYouGo15Down;
  }
  
  public WebElement getchkPaymentOpt_4paybimonthly() {
	  return chkPaymentOpt_4paybimonthly;
  }
  
  public WebElement getchkPaymentOpt_4paymonthly() {
	  return chkPaymentOpt_4paymonthly;
  }
  
  public WebElement getchkPaymentOpt_Fullpay() {
	  return chkPaymentOpt_Fullpay;
  }
  
  public WebElement getchkPaymentOpt_PremiumFinance() {
	  return chkPaymentOpt_PremiumFinance;
  }
  
  public WebElement getchkPaymentOpt_FrankCrumpaygo() {
	  return chkPaymentOpt_FrankCrumpaygo;
  }
  
  public WebElement getdpddepositpaymentmethod () {
	  return dpddepositpaymentmethod;
  }
  
  public WebElement getclkCheckPayment() {
	  return clkCheckPayment;
  }
  
  public WebElement getclkPremiumFinancePayment() {
	  return clkPremiumFinancePayment;
  }
  
  public WebElement getclkOnlinePayment() {
	  return clkOnlinePayment;
  }
  
  public WebElement clickOnBusinessSummaryPage() {
	  return clkBusinessSummaryPage;
  }
  
  //General Questions
  public WebElement rdQuestion_1() {
	  return rdQuestion_1;
  }
  public WebElement rdQuestion_2() {
	  return rdQuestion_2;
  }
  public WebElement rdQuestion_3() {
	  return rdQuestion_3;
  }
  public WebElement rdQuestion_4() {
	  return rdQuestion_4;
  }
  public WebElement rdQuestion_5() {
	  return rdQuestion_5;
  }
  public WebElement rdQuestion_6() {
	  return rdQuestion_6;
  }
  public WebElement rdQuestion_7() {
	  return rdQuestion_7;
  }
  public WebElement rdQuestion_8() {
	  return rdQuestion_8;
  }
  public WebElement rdQuestion_9() {
	  return rdQuestion_9;
  }
  public WebElement rdQuestion_10() {
	  return rdQuestion_10;
  }
  public WebElement rdQuestion_11() {
	  return rdQuestion_11;
  }
  public WebElement rdQuestion_12() {
	  return rdQuestion_12;
  }
  public WebElement rdQuestion_13() {
	  return rdQuestion_13;
  }
  
  
//industrial question
  
  public WebElement chkBedding() {
	  return chkBedding;
  }
  
  
  //---------------"0005"-----------------
  public WebElement rdIQuestion_1() {
	  return rdIQuestion_1;
  }
  public WebElement rdIQuestion_2() {
	  return rdIQuestion_2;
  }
  public WebElement rdIQuestion_3() {
	  return rdIQuestion_3;
  }
  public WebElement rdIQuestion_4() {
	  return rdIQuestion_4;
  }
  public WebElement rdIQuestion_5() {
	  return rdIQuestion_5;
  }
  public WebElement rdIQuestion_6() {
	  return rdIQuestion_6;
  }
  public WebElement rdIQuestion_7() {
	  return rdIQuestion_7;
  }
  public WebElement rdIQuestion_8() {
	  return rdIQuestion_8;
  }
  public WebElement rdIQuestion_9() {
	  return rdIQuestion_9;
  }
  public WebElement rdIQuestion_10() {
	  return rdIQuestion_10;
  }
  public WebElement rdIQuestion_11() {
	  return rdIQuestion_11;
  }
  public WebElement rdIQuestion_12() {
	  return rdIQuestion_12;
  }
  public WebElement rdIQuestion_13() {
	  return rdIQuestion_13;
  }
  public WebElement rdIQuestion_14() {
	  return rdIQuestion_14;
  }
  public WebElement rdIQuestion_15() {
	  return rdIQuestion_15;
  }
  
  
  //Lossess
  public WebElement gethadCoverage() {
	  return gethadCoverage;
  }
  public WebElement rdAnyLosses() {
	  return rdAnyLosses;
  }
  public WebElement btnSubmit() {
	  return btnSubmit;
  }
  public WebElement gettxtLossCarrier() {
	  return gettxtLossCarrier;
  }
  
  public WebElement getselWCNameInsured() {
	  return selWCNameInsured;
  }
  
  public WebElement getWCNameInsuredresult() {
	  return WCNameInsuredresult;
  }
  
  
  public WebElement getWCApplicationRelationsip() {
	  return WCApplicationRelationsip;
  }
  public WebElement getWAppliactionCAddress1() {
	  return WAppliactionCAddress1;
  }
  
  public WebElement getWAppliactionCity() {
	  return WCAppliactionCity;
  }
  public WebElement getWAppliactionState() {
	  return WCAppliactionState;
  }
  public WebElement getWCAppliactionZipcode() {
	  return WCAppliactionZipcode;
  }
  
  public WebElement getWAppliactionAddLoact() {
	  return WCAppliactionAddLoact;
  }
  
  public WebElement getWCNameInsuredList1() {
	  return WCNameInsuredList1;
  }
  public WebElement getWCNameInsuredtxt() {
	  return WCNameInsuredtxt;
  }
  
  public WebElement getWCNameInsuredtxt2() {
	  return WCNameInsuredtxt2;
  }
  
  public WebElement getWCconatactName() {
	  return WCconatactName;
  }
  public WebElement getWCconatactMailingAddress() {
	  return WCconatactMailingAddress;
  }
  
  public WebElement getWCcontactPhone() {
	  return WCcontactPhone;
  }
  
  public WebElement getWCcontactEmail() {
	  return WCcontactEmail;
  }
  
  public WebElement getWCcontactAddress1() {
	  return WCcontactAddress1;
  }
  public WebElement getWCAgreebtn() {
	  return WCAgreebtn;
  }
  public WebElement getWCMakePayment() {
	  return WCMakePayment;
  }
  public WebElement getlnkWCCondensedRatingWorksheet() {
	  return lnkWCCondensedRatingWorksheet;
  }
  public WebElement getbtnWCDownloadQuote() {
	  return btnWCDownloadQuote;
  }
  public WebElement getbtnWCDownloadRatingWorksheet() {
	  return btnWCDownloadRatingWorksheet;
  }
  public WebElement getbtnWCDownloadApplication() {
	  return btnWCDownloadApplication;
  }
  
  public WebElement gettxtAppClosebtn() {
		 return txtAppClosebtn;
	 }

 //-----------------Referral -------------------------
  
  public WebElement gettxtRefferal() {
      return txtRefferal;
  }   
  
  public WebElement getBtnDoneRefferal() {
       return BtnDoneRefferal;
  }
  public WebElement gettxtAgentSearch() {
	  return txtAgentSearch;
  }
  
  public WebElement getWCReferralText() {
	  return WCReferralText;
  }
  
  public WebElement getWCBacktoRecord() {
	  return WCReferralText;
  }
  
  
//------------------Underwriting ------------------------

  public WebElement gettxtUWSearch() {
	  return txtUWSearch;
  }
  public WebElement getbtnSearch() {
      return btnSearch;
  }    
  public WebElement getbtnAction() {
	  return btnAction;
  }
  
  public WebElement getbtnEditQuote() {
	  return btnEditQuote;
  }
  public WebElement getbtnMessages() {
	  return btnMessages;
  }
  public WebElement getUWCurrentStatus() {
	  return UWCurrentStatus;
  }
  public WebElement getUWInProgressStatus() {
	  return UWInProgressStatus;
  }
  public WebElement getUWSubmittedStatus() {
	  return UWSubmittedStatus;
  }
  public WebElement getUWAcceptedStatus() {
	  return UWAcceptedStatus;
  }
  public WebElement getUWDeclinedStatus() {
	  return UWDeclinedStatus;
  }
  public WebElement getUWbtnReRate() {
	  return UWbtnReRate;
  }
  public WebElement getUWbtnExit() {
	  return UWbtnExit;
  }
  public WebElement getUWAlertMsgBox() {
	  return UWAlertMsgBox;
  }  
  public WebElement getUWGLEditQuote() {
	  return UWGLEditQuote;
  }
  public WebElement getUWLblPage() {
	  return UWLblPage;
  }
  public WebElement getUWReferralReason() {
	  return UWReferralReason;
  }
  public WebElement getUWBtnSave() {
	  return UWBtnSave;
  }
  public WebElement getUWAdditionalInsured() {
	  return UWAdditionalInsured;
  }
  public WebElement getUWClassPayroll() {
	  return UWClassPayroll;
  }
  public WebElement gettxtUWIRPM() {
		 return txtUWIRPM;
	 }
  public WebElement gettxtUWIRPM1() {
		 return txtUWIRPM1;
	 }
  public WebElement getchkConsentToRate() {
		 return chkConsentToRate;
	 }
  public WebElement gettxtUWIRPMCTR() {
		 return txtUWIRPMCTR;
	 }
  public WebElement getiframeCancelButton() {
	  return iframeCancelButton;
  }

  //------------------AI GL -------------------------------------
  
  public WebElement getrdFCG1001() {
	  return rdFCG1001;
  }
  public WebElement getrdCG2010() {
	  return rdCG2010;
  } 
  public WebElement getrdCG2037() {
	  return rdCG2037;
  }
  public WebElement getrdCG1019() {
	  return rdCG1019;
  }
  public WebElement getrdCG2404() {
	  return rdCG2404;
  } 
  public WebElement getrdCG2012() {
	  return rdCG2012;
  }
  public WebElement getrdCG2029() {
	  return rdCG2029;
  }
  public WebElement getrdCG2028() {
	  return rdCG2028;
  } 
  public WebElement getrdCG2024() {
	  return rdCG2024;
  }
  public WebElement getrdCG2005() {
	  return rdCG2005;
  }
  public WebElement getrdCG2011() {
	  return rdCG2011;
  } 
  public WebElement getrdCG2007() {
	  return rdCG2007;
  }

public WebElement getrdCG2026() {
	return rdCG2026;
}

}
