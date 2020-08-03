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
                	case 6:   dataObj.setPermFristLastName(cellObj.getStringCellValue()); break;
                	case 7:   dataObj.setFristName(cellObj.getStringCellValue()); break;
                	case 8:   dataObj.setLastName(cellObj.getStringCellValue()); break;
                	case 9:   dataObj.setState(cellObj.getStringCellValue()); break;
                	case 10:  dataObj.setCounty(cellObj.getStringCellValue()); break;
                	case 11:  dataObj.setDescriptionOfBusiness(cellObj.getStringCellValue()); break;
                	case 12:  dataObj.setYearsInBusiness(cellObj.getStringCellValue()); break;
                	case 13:  dataObj.setClassCode(cellObj.getStringCellValue()); break;
                	case 14:  dataObj.setSubClassCode(cellObj.getStringCellValue()); break;
                	case 15:  dataObj.setSubcontractorDesc(cellObj.getStringCellValue()); break;
                	case 16:  dataObj.setExperience(cellObj.getNumericCellValue()); break;
                	case 17:  dataObj.setClaims(cellObj.getNumericCellValue()); break;
                	case 18:  dataObj.setPriorInsurance(cellObj.getStringCellValue()); break;
                	case 19:  dataObj.setLiabilityLimit(cellObj.getStringCellValue()); break;
                	case 20:  dataObj.setDeductible(cellObj.getStringCellValue()); break;
                	case 21:  dataObj.setAI(cellObj.getStringCellValue()); break;
                	case 22:  dataObj.setWaivers(cellObj.getStringCellValue()); break; 
                	case 23:  dataObj.setInlandMarine(cellObj.getStringCellValue()); break;  
                	case 24:  dataObj.setLocationAgregate(cellObj.getStringCellValue()); break;   
                	case 25:  dataObj.setProjectAgregate(cellObj.getStringCellValue()); break;
                	case 26:  dataObj.setExpectedGrossReceipts(cellObj.getNumericCellValue()); break;
                	case 27:  dataObj.setSubContractorGrossReciepts(cellObj.getNumericCellValue()); break;
                	case 28:  dataObj.setUnSubContractorGrossReciepts(cellObj.getStringCellValue()); break;
                	case 29:  dataObj.setActiveOwner(cellObj.getStringCellValue()); break;
                	case 30:  dataObj.setAdministrativeEmployee(cellObj.getStringCellValue()); break;
                	case 31:  dataObj.setAdministrativeEmployeeGrossAtm(cellObj.getStringCellValue()); break;
                	case 32:  dataObj.setSalesEmployees(cellObj.getStringCellValue()); break;
                	case 33:  dataObj.setSalesEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 34:  dataObj.setOtherEmployees(cellObj.getStringCellValue()); break;
                	case 35:  dataObj.setOtherEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 36:  dataObj.setAIFCG1001(cellObj.getStringCellValue()); break;
                	case 37:  dataObj.setAICG2010(cellObj.getStringCellValue()); break;
                	case 38:  dataObj.setAICG2037(cellObj.getStringCellValue()); break;
                	case 39:  dataObj.setAICG1019(cellObj.getStringCellValue()); break;
                	case 40:  dataObj.setAICG2404(cellObj.getStringCellValue()); break;
                	case 41:  dataObj.setAICG2012(cellObj.getStringCellValue()); break;
                	case 42:  dataObj.setAICG2029(cellObj.getStringCellValue()); break;
                	case 43:  dataObj.setAICG2028(cellObj.getStringCellValue()); break;
                	case 44:  dataObj.setAICG2024(cellObj.getStringCellValue()); break;
                	case 45:  dataObj.setAICG2005(cellObj.getStringCellValue()); break;
                	case 46:  dataObj.setAICG2011(cellObj.getStringCellValue()); break;
                	case 47:  dataObj.setAICG2007(cellObj.getStringCellValue()); break;
                	case 48:  dataObj.setAICG2026(cellObj.getStringCellValue()); break;
                	case 49:  dataObj.setInstallationFloater(cellObj.getStringCellValue()); break;
                	case 50:  dataObj.setContractorsHandTools(cellObj.getStringCellValue()); break;
                	case 51:  dataObj.setRentedorLeasedEquipment(cellObj.getStringCellValue()); break;
                	case 52:  dataObj.setScheduleEquipment(cellObj.getStringCellValue()); break;
                	case 53:  dataObj.setScheduleEquipmentDescription(cellObj.getStringCellValue()); break;
                	case 54:  dataObj.setScheduleEquipmentAmount(cellObj.getStringCellValue()); break;
                	case 55:  dataObj.setProducerFee(cellObj.getStringCellValue()); break;
                	case 56: dataObj.setTypeofCompany(cellObj.getStringCellValue()); break;
                	case 57: dataObj.setMExcess(cellObj.getStringCellValue()); break;
                	case 58:  dataObj.setFristAddressline(cellObj.getStringCellValue()); break;
                	case 59:  dataObj.setSecAddressline(cellObj.getStringCellValue()); break;
                	case 60:  dataObj.setBusinessType(cellObj.getStringCellValue()); break;
                	case 61:  dataObj.setInspectorName(cellObj.getStringCellValue()); break;
                	case 62:  dataObj.setLocationCity(cellObj.getStringCellValue()); break;
                	case 63:  dataObj.setLocationZipCode(cellObj.getStringCellValue()); break;
                	case 64:  dataObj.setBusinessPhone(cellObj.getStringCellValue()); break;
                	case 65:  dataObj.setBusinessEmail(cellObj.getStringCellValue()); break;
                	case 66:  dataObj.setLicenseType(cellObj.getStringCellValue()); break;
                	case 67:  dataObj.setLicenseNumber(cellObj.getStringCellValue()); break;
                	case 68:  dataObj.setIndustrialPercent(cellObj.getStringCellValue()); break;
                	case 69:  dataObj.setCommercialPercent(cellObj.getStringCellValue()); break;
                	case 70:  dataObj.setResidentialPercent(cellObj.getStringCellValue()); break;
                	case 71:  dataObj.setNewConstructionPercent(cellObj.getStringCellValue()); break;
                	case 72:  dataObj.setRoomAdditionsPercent(cellObj.getStringCellValue()); break;
                	case 73:  dataObj.setRemodelingPercent(cellObj.getStringCellValue()); break;
                	case 74:  dataObj.setRepairorServicePercent(cellObj.getStringCellValue()); break;
                	case 75:  dataObj.setSEMake(cellObj.getStringCellValue()); break;
                	case 76:  dataObj.setSEModel(cellObj.getStringCellValue()); break;
                	case 77:  dataObj.setSESerialNo(cellObj.getStringCellValue()); break;
                	case 78:  dataObj.setSELossPayee(cellObj.getStringCellValue()); break;
                	case 79:  dataObj.setSEName(cellObj.getStringCellValue()); break;
                	case 80:  dataObj.setSEAddr(cellObj.getStringCellValue()); break;
                	case 81:  dataObj.setSECity(cellObj.getStringCellValue()); break;
                	case 82:  dataObj.setSEZip(cellObj.getStringCellValue()); break;
                	case 83:  dataObj.setAgentNotes(cellObj.getStringCellValue()); break;
                	case 84:  dataObj.setAgentMessages(cellObj.getStringCellValue()); break;
                	case 85:  dataObj.setUWModifyPerm(cellObj.getStringCellValue()); break;
                	case 86:  dataObj.setUWModifyRiskLPerm(cellObj.getStringCellValue()); break;
                	case 87:  dataObj.setUWModifyState(cellObj.getStringCellValue()); break;
                	case 88:  dataObj.setUWModifyCity(cellObj.getStringCellValue()); break;
                	case 89:  dataObj.setUWModifyZip(cellObj.getStringCellValue()); break;
                	case 90:  dataObj.setUWModifyCounty(cellObj.getStringCellValue()); break;
                	case 91:  dataObj.setUWModifyBName(cellObj.getStringCellValue()); break;
                	case 92:  dataObj.setUWModifyPremFLName(cellObj.getStringCellValue()); break;
                	case 93:  dataObj.setUWModifyFName(cellObj.getStringCellValue()); break;
                	case 94:  dataObj.setUWModifyLName(cellObj.getStringCellValue()); break;
                	case 95:  dataObj.setUWModifyLL(cellObj.getStringCellValue()); break;
                	case 96:  dataObj.setUWModifyDeductible(cellObj.getStringCellValue()); break;
                	case 97:  dataObj.setUWModifyAI(cellObj.getStringCellValue()); break;
                	case 98:  dataObj.setUWAIFCG1001(cellObj.getStringCellValue()); break;
                	case 99:  dataObj.setUWAICG2010(cellObj.getStringCellValue()); break;
                	case 100:  dataObj.setUWAICG2037(cellObj.getStringCellValue()); break;
                	case 101: dataObj.setUWAICG1019(cellObj.getStringCellValue()); break;
                	case 102: dataObj.setUWAICG2404(cellObj.getStringCellValue()); break;
                	case 103: dataObj.setUWAICG2012(cellObj.getStringCellValue()); break;
                	case 104: dataObj.setUWAICG2029(cellObj.getStringCellValue()); break;
                	case 105: dataObj.setUWAICG2028(cellObj.getStringCellValue()); break;
                	case 106: dataObj.setUWAICG2024(cellObj.getStringCellValue()); break;
                	case 107: dataObj.setUWAICG2005(cellObj.getStringCellValue()); break;
                	case 108: dataObj.setUWAICG2011(cellObj.getStringCellValue()); break;
                	case 109: dataObj.setUWAICG2007(cellObj.getStringCellValue()); break;
                	case 110: dataObj.setUWAICG2026(cellObj.getStringCellValue()); break;
                	case 111: dataObj.setUWModifyWS(cellObj.getStringCellValue()); break;
                	case 112: dataObj.setUWModifyIM(cellObj.getStringCellValue()); break;
                	case 113: dataObj.setUWModifyInstallationFloater(cellObj.getStringCellValue()); break;
                	case 114: dataObj.setUWModifyContractorsHandTools(cellObj.getStringCellValue()); break;
                	case 115: dataObj.setUWModifyRentedorLeasedEquipment(cellObj.getStringCellValue()); break;
                	case 116: dataObj.setUWModifyScheduleEquipment(cellObj.getStringCellValue()); break;
                	case 117: dataObj.setUWModifyScheduleEquipmentDescription(cellObj.getStringCellValue()); break;
                	case 118: dataObj.setUWModifyScheduleEquipmentAmount(cellObj.getStringCellValue()); break;
                	case 119: dataObj.setUWModifyClassPay(cellObj.getStringCellValue()); break;
                	case 120: dataObj.setUWModifyMainClasscode(cellObj.getStringCellValue()); break;
                	case 121: dataObj.setUWModifySubClasscode(cellObj.getStringCellValue()); break;
                	case 122: dataObj.setUWModifyActiveOwner(cellObj.getStringCellValue()); break;
                	case 123: dataObj.setUWModifyExpectedGross(cellObj.getStringCellValue()); break;
                	case 124: dataObj.setUWModifySubContractorGross(cellObj.getStringCellValue()); break;
                	case 125: dataObj.setUWModifyUnSubContractorGross(cellObj.getStringCellValue()); break;
                	case 126: dataObj.setUWModifyAdministrativeEmployee(cellObj.getStringCellValue()); break;
                	case 127: dataObj.setUWModifyAdministrativeEmployeeGrossAtm(cellObj.getStringCellValue()); break;
                	case 128: dataObj.setUWModifySalesEmployees(cellObj.getStringCellValue()); break;
                	case 129: dataObj.setUWModifySalesEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 130: dataObj.setUWModifyOtherEmployees(cellObj.getStringCellValue()); break;
                	case 131: dataObj.setUWModifyOtherEmployeesGrossAtm(cellObj.getStringCellValue()); break;
                	case 132: dataObj.setUWModifyClassSpecificQ(cellObj.getStringCellValue()); break;
                	case 133: dataObj.setUWRateType(cellObj.getStringCellValue()); break;
                	case 134: dataObj.setUWModifiedRates(cellObj.getStringCellValue()); break;
                	case 135: dataObj.setUWNotes(cellObj.getStringCellValue()); break;
                	case 136: dataObj.setUWMessages(cellObj.getStringCellValue()); break;
                	case 137: dataObj.setUWQuoteStatus(cellObj.getStringCellValue()); break;
                	case 138: dataObj.setUWReferralRemark(cellObj.getStringCellValue()); break;
                	case 139: dataObj.setIncludeExcess(cellObj.getStringCellValue()); break;
                	case 140: dataObj.setChkConvertPolicy(cellObj.getStringCellValue()); break;
                	case 141: dataObj.setConvertPolicyNo(cellObj.getStringCellValue()); break;
                	case 142: dataObj.setActionMessages(cellObj.getStringCellValue()); break;
                	case 143: dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
                	case 144: dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
                	case 145: dataObj.setCreditCardNumber(cellObj.getStringCellValue()); break;
                	case 146: dataObj.setCVVNumber(cellObj.getStringCellValue()); break;
                	
                	//-----------------------------------------------------------------
                	
                	case 147: dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
                	case 148: dataObj.setInsuredName(cellObj.getStringCellValue()); break;
                	case 149: dataObj.setQuoteDate(cellObj.getStringCellValue()); break;
                	case 150: dataObj.setQuoteNo(cellObj.getStringCellValue()); break;
                	case 151: dataObj.setCountyCode(cellObj.getStringCellValue()); break;
                	case 152: dataObj.setFWCIPremium(cellObj.getStringCellValue()); break;
                	case 153: dataObj.setFWCIMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 154: dataObj.setCBPremium(cellObj.getStringCellValue()); break;
                	case 155: dataObj.setCBMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 156: dataObj.setFWCIProducerFee(cellObj.getStringCellValue()); break;
                	case 157: dataObj.setCBProducerFee(cellObj.getStringCellValue()); break;
                	case 158: dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
                	
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
	                	case 45:  dataObj.setActionMessages(cellObj.getStringCellValue()); break;
	                	case 46:  dataObj.setUWPermission(cellObj.getStringCellValue()); break;
	                	case 47:  dataObj.setUWQuoteStatus(cellObj.getStringCellValue()); break;
	                	case 48:  dataObj.setUWRateType(cellObj.getStringCellValue()); break;
	                	case 49:  dataObj.setUWModifiedRates(cellObj.getStringCellValue()); break;
	                	case 50:  dataObj.setUWNotes(cellObj.getStringCellValue()); break;
	                	case 51:  dataObj.setUWMessages(cellObj.getStringCellValue()); break;
	                	case 52:  dataObj.setWCUWModifyBusinessName(cellObj.getStringCellValue()); break;
	                	case 53:  dataObj.setWCUWModifyDBAName(cellObj.getStringCellValue()); break;
	                	case 54:  dataObj.setWCUWModifyCity(cellObj.getStringCellValue()); break;
	                	case 55:  dataObj.setWCUWModifyState(cellObj.getStringCellValue()); break;
	                	case 56:  dataObj.setWCUWModifyClassCode(cellObj.getStringCellValue()); break;
	                	case 57:  dataObj.setWCUWModifyClassCodeDesc(cellObj.getStringCellValue()); break;
	                	case 58:  dataObj.setWCUWModifyClassCodeColor(cellObj.getStringCellValue()); break;
	                	case 59:  dataObj.setWCUWModifyLegalEntity(cellObj.getStringCellValue()); break;
	                	case 60:  dataObj.setWCUWModifyAddressState(cellObj.getStringCellValue()); break;
	                	case 61:  dataObj.setWCUWModifyAddress1(cellObj.getStringCellValue()); break;
	                	case 62:  dataObj.setWCUWModifyAddress2(cellObj.getStringCellValue()); break;
	                	case 63:  dataObj.setWCUWModifyZipCode(cellObj.getStringCellValue()); break;
	                	case 64:  dataObj.setWCUWModifyAditionalInsured(cellObj.getStringCellValue()); break;
	                	case 65:  dataObj.setWCUWModifyEmployerLimit(cellObj.getStringCellValue()); break;
	                	case 66:  dataObj.setWCUWModifyExpMod(cellObj.getStringCellValue()); break;
	                	case 67:  dataObj.setUWModifyOwnerPermission(cellObj.getStringCellValue()); break;
	                	case 68:  dataObj.setUWModifyOwnerCount(cellObj.getStringCellValue()); break;
	                	case 69:  dataObj.setWCUWModifyFirstName(cellObj.getStringCellValue()); break;
	                	case 70:  dataObj.setWCUWModifyLastName(cellObj.getStringCellValue()); break;
	                	case 71:  dataObj.setWCUWModifyPerOwner(cellObj.getStringCellValue()); break;
	                	case 72:  dataObj.setWCUWModifyInclude(cellObj.getStringCellValue()); break;
	                	case 73:  dataObj.setWCUWModifyFTEmployee(cellObj.getStringCellValue()); break; 
	                	case 74:  dataObj.setWCUWModifyPTEmployee(cellObj.getStringCellValue()); break;
	                	case 75:  dataObj.setWCUWModifyGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 76:  dataObj.setWCUWModifyOwnGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 77:  dataObj.setWCUWModifyInsuredSubContractor(cellObj.getStringCellValue()); break;
	                	case 78:  dataObj.setWCUWModifyTypeofWork(cellObj.getStringCellValue()); break;
	                	case 79:  dataObj.setWCUWModifyworkperformed(cellObj.getStringCellValue()); break;
	                	case 80:  dataObj.setWCUWModifyproofofWCcoverage(cellObj.getStringCellValue()); break;
	                	case 81:  dataObj.setWCUWModifyUninsuredSubcontractor(cellObj.getStringCellValue()); break;
	                	case 82:  dataObj.setWCUWModifyBusinessDescription(cellObj.getStringCellValue()); break;
	                	case 83:  dataObj.setWCUWModifyhadCoverage(cellObj.getStringCellValue()); break;
	                	case 84:  dataObj.setWCUWModifyCarierName(cellObj.getStringCellValue()); break;
	                	case 85:  dataObj.setWCUWModifyAnyLosses(cellObj.getStringCellValue()); break;
	                	case 86:  dataObj.setWCUWModifyClaims(cellObj.getStringCellValue()); break;
	                	case 87:  dataObj.setWCUWModifyTotalIncurred(cellObj.getStringCellValue()); break;
	                	case 88:  dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
	                	case 89:  dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
	                	case 90:  dataObj.setCreditCardNumber(cellObj.getStringCellValue()); break;
	                	case 91:  dataObj.setCVVNumber(cellObj.getStringCellValue()); break;
	                	//-----------------------------------------------------
	                	
	                	case 92:  dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
	                	case 93:  dataObj.setInsuredName(cellObj.getStringCellValue()); break;
	                	case 94:  dataObj.setReferralReason(cellObj.getStringCellValue()); break;
	                	case 95:  dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
	                	
	                	
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
	


