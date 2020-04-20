package FSmokeSuit.FSmokeSuit;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	private static HashMap<Integer, String> mapColumnList=new HashMap<Integer, String>();
	@SuppressWarnings("deprecation")
	public static ArrayList<LoadManager> excelGetAllData_GL(String excelFilePath,String strSheetName,int startRowNum,int startColumnNum) throws Exception {
		
		ArrayList<LoadManager> testCaseData=new ArrayList<LoadManager>();		
		System.out.println("Start Excel Memory Load: "+new Date());
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		System.out.println("End Excel Memory Load: "+new Date());
		
		Sheet firstSheet = workbook.getSheet(strSheetName);		
        int totalRows= firstSheet.getLastRowNum();		      
        Row rowObj=firstSheet.getRow(0);		        
        int totalCols=rowObj.getLastCellNum();
      	        	
        for(int rowNum=startRowNum;rowNum<=totalRows;rowNum++) {
        	
        	LoadManager dataObj=new LoadManager();
        	rowObj=firstSheet.getRow(rowNum);     	
        	
        	for(int colNum=startColumnNum;colNum<totalCols;colNum++) {
        		
        		Cell cellObj=rowObj.getCell(colNum);
                if(cellObj==null) {		                	
                	continue;
                }     
                else { 
                	
                	switch(colNum) {
                	case 0:  dataObj.setTestCaseId(cellObj.getNumericCellValue());  break;
                	case 1:	 dataObj.setProduct(cellObj.getStringCellValue()); break;
                	case 2:  dataObj.setTCScenarios(cellObj.getStringCellValue()); break;
                	case 3:  dataObj.setAgentName(cellObj.getStringCellValue()); break; 
                	case 4:  dataObj.setExecutionStatus(cellObj.getStringCellValue()); break;           	
                	
                	//---------------------------------------------------------------
                	
                	case 5:   dataObj.setBusinessName(cellObj.getStringCellValue()); break;
                	case 6:   dataObj.setFristName(cellObj.getStringCellValue()); break;
                	case 7:   dataObj.setLastName(cellObj.getStringCellValue()); break;
                	case 8:   dataObj.setState(cellObj.getStringCellValue()); break;
                	case 9:   dataObj.setCounty(cellObj.getStringCellValue()); break;
                	case 10:  dataObj.setDescriptionOfBusiness(cellObj.getStringCellValue()); break;
                	case 11:  dataObj.setYearsInBusiness(cellObj.getStringCellValue()); break;
                	case 12:  dataObj.setClassCode(cellObj.getStringCellValue()); break;
                	case 13:  dataObj.setSubClassCode(cellObj.getStringCellValue()); break;
                	case 14:  dataObj.setSubcontractorDesc(cellObj.getStringCellValue()); break;
                	case 15:  dataObj.setExperience(cellObj.getNumericCellValue()); break;
                	case 16:  dataObj.setClaims(cellObj.getNumericCellValue()); break;
                	case 17:  dataObj.setPriorInsurance(cellObj.getStringCellValue()); break;
                	case 18:  dataObj.setLiabilityLimit(cellObj.getStringCellValue()); break;
                	case 19:  dataObj.setDeductible(cellObj.getStringCellValue()); break;
                	case 20:  dataObj.setAI(cellObj.getStringCellValue()); break;
                	case 21:  dataObj.setWaivers(cellObj.getStringCellValue()); break; 
                	case 22:  dataObj.setInlandMarine(cellObj.getStringCellValue()); break;  
                	case 23:  dataObj.setLocationAgregate(cellObj.getStringCellValue()); break;   
                	case 24:  dataObj.setProjectAgregate(cellObj.getStringCellValue()); break;
                	case 25:  dataObj.setExpectedGrossReceipts(cellObj.getNumericCellValue()); break;
                	case 26:  dataObj.setSubContractorGrossReciepts(cellObj.getNumericCellValue()); break;
                	case 27:  dataObj.setUnSubContractorGrossReciepts(cellObj.getStringCellValue()); break;
                	case 28:  dataObj.setInstallationFloater(cellObj.getStringCellValue()); break;
                	case 29:  dataObj.setContractorsHandTools(cellObj.getStringCellValue()); break;
                	case 30:  dataObj.setRentedorLeasedEquipment(cellObj.getStringCellValue()); break;
                	case 31:  dataObj.setScheduleEquipment(cellObj.getStringCellValue()); break;
                	case 32:  dataObj.setScheduleEquipmentDescription(cellObj.getStringCellValue()); break;
                	case 33:  dataObj.setScheduleEquipmentAmount(cellObj.getStringCellValue()); break;
                	case 34:  dataObj.setAIFCG1001(cellObj.getStringCellValue()); break;
                	case 35:  dataObj.setAICG2010(cellObj.getStringCellValue()); break;
                	case 36:  dataObj.setAICG2037(cellObj.getStringCellValue()); break;
                	case 37:  dataObj.setAICG1019(cellObj.getStringCellValue()); break;
                	case 38:  dataObj.setAICG2404(cellObj.getStringCellValue()); break;
                	case 39:  dataObj.setAICG2012(cellObj.getStringCellValue()); break;
                	case 40:  dataObj.setAICG2029(cellObj.getStringCellValue()); break;
                	case 41:  dataObj.setAICG2028(cellObj.getStringCellValue()); break;
                	case 42:  dataObj.setAICG2024(cellObj.getStringCellValue()); break;
                	case 43:  dataObj.setAICG2005(cellObj.getStringCellValue()); break;
                	case 44:  dataObj.setAICG2011(cellObj.getStringCellValue()); break;
                	case 45:  dataObj.setAICG2007(cellObj.getStringCellValue()); break;
                	case 46:  dataObj.setAICG2026(cellObj.getStringCellValue()); break;
                	case 47:  dataObj.setFristAddressline(cellObj.getStringCellValue()); break;
                	case 48:  dataObj.setSecAddressline(cellObj.getStringCellValue()); break;
                	case 49:  dataObj.setBusinessType(cellObj.getStringCellValue()); break;
                	case 50:  dataObj.setInspectorName(cellObj.getStringCellValue()); break;
                	case 51:  dataObj.setLocationCity(cellObj.getStringCellValue()); break;
                	case 52:  dataObj.setLocationZipCode(cellObj.getStringCellValue()); break;
                	case 53:  dataObj.setBusinessPhone(cellObj.getStringCellValue()); break;
                	case 54:  dataObj.setBusinessEmail(cellObj.getStringCellValue()); break;
                	case 55:  dataObj.setActiveOwner(cellObj.getStringCellValue()); break;
                	case 56:  dataObj.setAdministrativeEmployee(cellObj.getStringCellValue()); break;
                	case 57:  dataObj.setAdministrativeEmployeeGrossAtm(cellObj.getStringCellValue()); break;
                	case 58:  dataObj.setSalesEmployees(cellObj.getStringCellValue()); break;
                	case 59:  dataObj.setSalesEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 60:  dataObj.setOtherEmployees(cellObj.getStringCellValue()); break;
                	case 61:  dataObj.setOtherEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 62:  dataObj.setLicenseType(cellObj.getStringCellValue()); break;
                	case 63:  dataObj.setLicenseNumber(cellObj.getStringCellValue()); break;
                	case 64:  dataObj.setIndustrialPercent(cellObj.getStringCellValue()); break;
                	case 65:  dataObj.setCommercialPercent(cellObj.getStringCellValue()); break;
                	case 66:  dataObj.setResidentialPercent(cellObj.getStringCellValue()); break;
                	case 67:  dataObj.setNewConstructionPercent(cellObj.getStringCellValue()); break;
                	case 68:  dataObj.setRoomAdditionsPercent(cellObj.getStringCellValue()); break;
                	case 69:  dataObj.setRemodelingPercent(cellObj.getStringCellValue()); break;
                	case 70:  dataObj.setRepairorServicePercent(cellObj.getStringCellValue()); break;
                	case 71:  dataObj.setSEMake(cellObj.getStringCellValue()); break;
                	case 72:  dataObj.setSEModel(cellObj.getStringCellValue()); break;
                	case 73:  dataObj.setSESerialNo(cellObj.getStringCellValue()); break;
                	case 74:  dataObj.setSELossPayee(cellObj.getStringCellValue()); break;
                	case 75:  dataObj.setSEName(cellObj.getStringCellValue()); break;
                	case 76:  dataObj.setSEAddr(cellObj.getStringCellValue()); break;
                	case 77:  dataObj.setSECity(cellObj.getStringCellValue()); break;
                	case 78:  dataObj.setSEZip(cellObj.getStringCellValue()); break;
                	case 79:  dataObj.setAgentNotes(cellObj.getStringCellValue()); break;
                	case 80:  dataObj.setAgentMessages(cellObj.getStringCellValue()); break;
                	case 81:  dataObj.setProducerFee(cellObj.getStringCellValue()); break;
                	case 82:  dataObj.setUWModifyPerm(cellObj.getStringCellValue()); break;
                	case 83:  dataObj.setUWModifyRiskLPerm(cellObj.getStringCellValue()); break;
                	case 84:  dataObj.setUWModifyState(cellObj.getStringCellValue()); break;
                	case 85:  dataObj.setUWModifyCity(cellObj.getStringCellValue()); break;
                	case 86:  dataObj.setUWModifyZip(cellObj.getStringCellValue()); break;
                	case 87:  dataObj.setUWModifyCounty(cellObj.getStringCellValue()); break;
                	case 88:  dataObj.setUWModifyBName(cellObj.getStringCellValue()); break;
                	case 89:  dataObj.setUWModifyFName(cellObj.getStringCellValue()); break;
                	case 90:  dataObj.setUWModifyLName(cellObj.getStringCellValue()); break;
                	case 91:  dataObj.setUWModifyLL(cellObj.getStringCellValue()); break;
                	case 92:  dataObj.setUWModifyDeductible(cellObj.getStringCellValue()); break;
                	case 93:  dataObj.setUWModifyAI(cellObj.getStringCellValue()); break;
                	case 94:  dataObj.setUWAIFCG1001(cellObj.getStringCellValue()); break;
                	case 95:  dataObj.setUWAICG2010(cellObj.getStringCellValue()); break;
                	case 96:  dataObj.setUWAICG2037(cellObj.getStringCellValue()); break;
                	case 97:  dataObj.setUWAICG1019(cellObj.getStringCellValue()); break;
                	case 98:  dataObj.setUWAICG2404(cellObj.getStringCellValue()); break;
                	case 99:  dataObj.setUWAICG2012(cellObj.getStringCellValue()); break;
                	case 100: dataObj.setUWAICG2029(cellObj.getStringCellValue()); break;
                	case 101: dataObj.setUWAICG2028(cellObj.getStringCellValue()); break;
                	case 102: dataObj.setUWAICG2024(cellObj.getStringCellValue()); break;
                	case 103: dataObj.setUWAICG2005(cellObj.getStringCellValue()); break;
                	case 104: dataObj.setUWAICG2011(cellObj.getStringCellValue()); break;
                	case 105: dataObj.setUWAICG2007(cellObj.getStringCellValue()); break;
                	case 106: dataObj.setUWAICG2026(cellObj.getStringCellValue()); break;
                	case 107: dataObj.setUWModifyWS(cellObj.getStringCellValue()); break;
                	case 108: dataObj.setUWModifyIM(cellObj.getStringCellValue()); break;
                	case 109: dataObj.setUWModifyInstallationFloater(cellObj.getStringCellValue()); break;
                	case 110: dataObj.setUWModifyContractorsHandTools(cellObj.getStringCellValue()); break;
                	case 111: dataObj.setUWModifyRentedorLeasedEquipment(cellObj.getStringCellValue()); break;
                	case 112: dataObj.setUWModifyScheduleEquipment(cellObj.getStringCellValue()); break;
                	case 113: dataObj.setUWModifyScheduleEquipmentDescription(cellObj.getStringCellValue()); break;
                	case 114: dataObj.setUWModifyScheduleEquipmentAmount(cellObj.getStringCellValue()); break;
                	case 115: dataObj.setUWModifyClassPay(cellObj.getStringCellValue()); break;
                	case 116: dataObj.setUWModifyMainClasscode(cellObj.getStringCellValue()); break;
                	case 117: dataObj.setUWModifySubClasscode(cellObj.getStringCellValue()); break;
                	case 118: dataObj.setUWModifyActiveOwner(cellObj.getStringCellValue()); break;
                	case 119: dataObj.setUWModifyExpectedGross(cellObj.getStringCellValue()); break;
                	case 120: dataObj.setUWModifySubContractorGross(cellObj.getStringCellValue()); break;
                	case 121: dataObj.setUWModifyUnSubContractorGross(cellObj.getStringCellValue()); break;
                	case 122: dataObj.setUWModifyAdministrativeEmployee(cellObj.getStringCellValue()); break;
                	case 123: dataObj.setUWModifyAdministrativeEmployeeGrossAtm(cellObj.getStringCellValue()); break;
                	case 124: dataObj.setUWModifySalesEmployees(cellObj.getStringCellValue()); break;
                	case 125: dataObj.setUWModifySalesEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 126: dataObj.setUWModifyOtherEmployees(cellObj.getStringCellValue()); break;
                	case 127: dataObj.setUWModifyOtherEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 128: dataObj.setUWModifyClassSpecificQ(cellObj.getStringCellValue()); break;
                	case 129: dataObj.setUWRateType(cellObj.getStringCellValue()); break;
                	case 130: dataObj.setUWModifiedRates(cellObj.getStringCellValue()); break;
                	case 131: dataObj.setUWNotes(cellObj.getStringCellValue()); break;
                	case 132: dataObj.setUWMessages(cellObj.getStringCellValue()); break;
                	case 133: dataObj.setUWQuoteStatus(cellObj.getStringCellValue()); break;
                	case 134: dataObj.setUWReferralRemark(cellObj.getStringCellValue()); break;
                	case 135: dataObj.setActionMessages(cellObj.getStringCellValue()); break;
                	case 136: dataObj.setTypeofCompany(cellObj.getStringCellValue()); break;
                	case 137: dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
                	case 138: dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
                	
                	//-----------------------------------------------------------------
                	
                	case 139: dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
                	case 140: dataObj.setInsuredName(cellObj.getStringCellValue()); break;
                	case 141: dataObj.setQuoteDate(cellObj.getStringCellValue()); break;
                	case 142: dataObj.setQuoteNo(cellObj.getStringCellValue()); break;
                	case 143: dataObj.setCountyCode(cellObj.getStringCellValue()); break;
                	case 144: dataObj.setFWCIPremium(cellObj.getStringCellValue()); break;
                	case 145: dataObj.setFWCIMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 146: dataObj.setCBPremium(cellObj.getStringCellValue()); break;
                	case 147: dataObj.setCBMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 148: dataObj.setFWCIProducerFee(cellObj.getStringCellValue()); break;
                	case 149: dataObj.setCBProducerFee(cellObj.getStringCellValue()); break;
                	case 150: dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
                	
                	}	 
                	
                	
                }                 
                
        	}          	
        	testCaseData.add(dataObj);
        }
                
        

@SuppressWarnings("unused")
Row rowColName=firstSheet.getRow(0);
Row rowObjMapping=firstSheet.getRow(1);
for(int colNum=1;colNum<totalCols;colNum++) {
    		
    		Cell cellObj=rowObjMapping.getCell(colNum);
            if(cellObj==null) {		                	
            	continue;
            }   
            else {
            	if(cellObj.getCellType()==Cell.CELL_TYPE_STRING) {
	            	String mappedCell=cellObj.getStringCellValue();
	            	if(!mappedCell.equalsIgnoreCase("") && (mappedCell.contains("Calculation") || mappedCell.contains("calculation"))) {
	            		mappedCell=mappedCell.replaceAll("Calculation","");
	            		mapColumnList.put(colNum, mappedCell);
	            	}
            	}	
            }
        	//
 }		        
workbook.close();
inputStream.close();
workbook=null;
inputStream=null;
return testCaseData;

}
	@SuppressWarnings("deprecation")
	public static ArrayList<LoadManager> excelGetAllData_WC(String excelFilePath, String strSheetName, int startRowNum, int startColumnNum)throws Exception {
			
			ArrayList<LoadManager> testCaseData=new ArrayList<LoadManager>();		
			System.out.println("Start Excel Memory Load: "+new Date());
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			System.out.println("End Excel Memory Load: "+new Date());
			
			Sheet firstSheet = workbook.getSheet(strSheetName);				
	        int totalRows=firstSheet.getLastRowNum();		      
	        Row rowObj=firstSheet.getRow(0);		        
	        int totalCols=rowObj.getLastCellNum();
	      	        	
	        for(int rowNum=startRowNum;rowNum<=totalRows;rowNum++) {
	        	
	        	LoadManager dataObj=new LoadManager();
	        	rowObj=firstSheet.getRow(rowNum);     	
	        	
	        	for(int colNum=startColumnNum;colNum<totalCols;colNum++) {
	        		
	        		Cell cellObj=rowObj.getCell(colNum);
	                if(cellObj==null) {		                	
	                	continue;
	                }     
	                else { 
	                	
	                	switch(colNum) {
	                	
	                	case 0:  dataObj.setTestCaseId(cellObj.getNumericCellValue());  break;
	                	case 1:	 dataObj.setProduct(cellObj.getStringCellValue()); break;
	                	case 2:  dataObj.setTCScenarios(cellObj.getStringCellValue()); break;
	                	case 3:  dataObj.setAgentName(cellObj.getStringCellValue()); break; 
	                	case 4:  dataObj.setExecutionStatus(cellObj.getStringCellValue()); break;
	                	
	                	//-----------------------------------------------------
	                	case 5:   dataObj.setWCBusinessName(cellObj.getStringCellValue()); break;
	                	case 6:   dataObj.setWCDBAName(cellObj.getStringCellValue()); break;
	                	case 7:   dataObj.setWCCity(cellObj.getStringCellValue()); break;
	                	case 8:   dataObj.setWCState(cellObj.getStringCellValue()); break;
	                	case 9:   dataObj.setWCClassCode(cellObj.getStringCellValue()); break;
	                	case 10:  dataObj.setWCClassCodeDesc(cellObj.getStringCellValue()); break;
	                	case 11:  dataObj.setWCClassCodeColor(cellObj.getStringCellValue()); break;
	                	case 12:  dataObj.setWCLegalEntity(cellObj.getStringCellValue()); break;
	                	case 13:  dataObj.setWCAddressState(cellObj.getStringCellValue()); break;
	                	case 14:  dataObj.setWCAddress1(cellObj.getStringCellValue()); break;
	                	case 15:  dataObj.setWCAddress2(cellObj.getStringCellValue()); break;
	                	case 16:  dataObj.setWCZipCode(cellObj.getStringCellValue()); break;
	                	case 17:  dataObj.setWCAditionalInsured(cellObj.getStringCellValue()); break;
	                	case 18:  dataObj.setWCEmployerLimit(cellObj.getStringCellValue()); break;
	                	case 19:  dataObj.setWCExpMod(cellObj.getStringCellValue()); break;
	                	case 20:  dataObj.setOwnerPermission(cellObj.getStringCellValue()); break;
	                	case 21:  dataObj.setOwnerCount(cellObj.getStringCellValue()); break;
	                	case 22:  dataObj.setWCFirstName(cellObj.getStringCellValue()); break;
	                	case 23:  dataObj.setWCLastName(cellObj.getStringCellValue()); break;
	                	case 24:  dataObj.setWCPerOwner(cellObj.getStringCellValue()); break;
	                	case 25:  dataObj.setWCInclude(cellObj.getStringCellValue()); break;
	                	case 26:  dataObj.setWCFTEmployee(cellObj.getStringCellValue()); break; 
	                	case 27:  dataObj.setWCPTEmployee(cellObj.getStringCellValue()); break;
	                	case 28:  dataObj.setWCGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 29:  dataObj.setWCOwnGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 30:  dataObj.setWCInsuredSubContractor(cellObj.getStringCellValue()); break;
	                	case 31:  dataObj.setWCTypeofWork(cellObj.getStringCellValue()); break;
	                	case 32:  dataObj.setWCworkperformed(cellObj.getStringCellValue()); break;
	                	case 33:  dataObj.setWCproofofWCcoverage(cellObj.getStringCellValue()); break;
	                	case 34:  dataObj.setWCUninsuredSubcontractor(cellObj.getStringCellValue()); break;
	                	case 35:  dataObj.setWCBusinessDescription(cellObj.getStringCellValue()); break;
	                	case 36:  dataObj.setWChadCoverage(cellObj.getStringCellValue()); break;
	                	case 37:  dataObj.setWCCarierName(cellObj.getStringCellValue()); break;
	                	case 38:  dataObj.setWCAnyLosses(cellObj.getStringCellValue()); break;
	                	case 39:  dataObj.setWCClaims(cellObj.getStringCellValue()); break;
	                	case 40:  dataObj.setWCTotalIncurred(cellObj.getStringCellValue()); break;
	                	case 41:  dataObj.setWCNotes(cellObj.getStringCellValue()); break;
	                	case 42:  dataObj.setWCMessages(cellObj.getStringCellValue()); break;
	                	case 43:  dataObj.setWCcontactEmail(cellObj.getStringCellValue()); break;
	                	case 44:  dataObj.setWCcontactPhone(cellObj.getStringCellValue()); break;
	                	case 45: dataObj.setUWQuoteStatus(cellObj.getStringCellValue()); break;
	                	case 46: dataObj.setUWRateType(cellObj.getStringCellValue()); break;
	                	case 47: dataObj.setUWModifiedRates(cellObj.getStringCellValue()); break;
	                	case 48: dataObj.setUWNotes(cellObj.getStringCellValue()); break;
	                	case 49: dataObj.setUWMessages(cellObj.getStringCellValue()); break;
	                	case 50: dataObj.setActionMessages(cellObj.getStringCellValue()); break;
	                	case 51:  dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
	                	case 52:  dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
	                	//-----------------------------------------------------
	                	
	                	case 53:  dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
	                	case 54:  dataObj.setInsuredName(cellObj.getStringCellValue()); break;
	                	case 55:  dataObj.setReferralReason(cellObj.getStringCellValue()); break;
	                	case 56:  dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
	                	
	                	
	                	}	                	
	                }                 
	                
	        	}          	
	        	testCaseData.add(dataObj);
	        }
	                
	        

	@SuppressWarnings("unused")
	Row rowColName=firstSheet.getRow(0);
	Row rowObjMapping=firstSheet.getRow(1);
	for(int colNum=1;colNum<totalCols;colNum++) {
	    		
	    		Cell cellObj=rowObjMapping.getCell(colNum);
	            if(cellObj==null) {		                	
	            	continue;
	            }   
	            else {
	            	if(cellObj.getCellType()==Cell.CELL_TYPE_STRING) {
		            	String mappedCell=cellObj.getStringCellValue();
		            	if(!mappedCell.equalsIgnoreCase("") && (mappedCell.contains("Calculation") || mappedCell.contains("calculation"))) {
		            		mappedCell=mappedCell.replaceAll("Calculation","");
		            		mapColumnList.put(colNum, mappedCell);
		            	}
	            	}	
	            }
	        	//
	 }		        
	workbook.close();
	inputStream.close();
	workbook=null;
	inputStream=null;
	return testCaseData;
	}
	
	
@SuppressWarnings("deprecation")
public static ArrayList<LoadManager> excelGetAllData_GL_CSQ(String excelFilePath,String strSheetName,int startRowNum,int startColumnNum) throws Exception {
		
		ArrayList<LoadManager> testCaseData=new ArrayList<LoadManager>();		
		System.out.println("Start Excel Memory Load: "+new Date());
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		System.out.println("End Excel Memory Load: "+new Date());
		
		Sheet firstSheet = workbook.getSheet(strSheetName);		
        int totalRows= firstSheet.getLastRowNum();		      
        Row rowObj=firstSheet.getRow(0);		        
        int totalCols=rowObj.getLastCellNum();
      	        	
        for(int rowNum=startRowNum;rowNum<=totalRows;rowNum++) {
        	
        	LoadManager dataObj=new LoadManager();
        	rowObj=firstSheet.getRow(rowNum);     	
        	
        	for(int colNum=startColumnNum;colNum<totalCols;colNum++) {
        		
        		Cell cellObj=rowObj.getCell(colNum);
                if(cellObj==null) {		                	
                	continue;
                }     
                else { 
                	
                	switch(colNum) {
                	case 0:  dataObj.setGLClassCodeId(cellObj.getStringCellValue());  break;
                	case 1:	 dataObj.setGLPrimaryUWQuestions(cellObj.getStringCellValue()); break;
                	case 2:  dataObj.setGLQuestionResult(cellObj.getStringCellValue()); break;
 
                	}	 
                	
                	
                }                 
                
        	}          	
        	testCaseData.add(dataObj);
        }

    	@SuppressWarnings("unused")
    	Row rowColName=firstSheet.getRow(0);
        Row rowObjMapping=firstSheet.getRow(1);
        for(int colNum=1;colNum<totalCols;colNum++) {
    		
    		Cell cellObj=rowObjMapping.getCell(colNum);
            if(cellObj==null) {		                	
            	continue;
            }   
            else {
            	if(cellObj.getCellType()==Cell.CELL_TYPE_STRING) {
	            	String mappedCell=cellObj.getStringCellValue();
	            	if(!mappedCell.equalsIgnoreCase("") && (mappedCell.contains("Calculation") || mappedCell.contains("calculation"))) {
	            		mappedCell=mappedCell.replaceAll("Calculation","");
	            		mapColumnList.put(colNum, mappedCell);
	            	}
            	}	
            }
        	//
      }		        
    workbook.close();
    inputStream.close();
    workbook=null;
    inputStream=null;
    return testCaseData;

   }
 }
	


