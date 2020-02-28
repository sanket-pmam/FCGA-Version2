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
                	
                	case 5:   dataObj.setState(cellObj.getStringCellValue()); break;
                	case 6:   dataObj.setCounty(cellObj.getStringCellValue()); break;
                	case 7:   dataObj.setClassCode(cellObj.getStringCellValue()); break;
                	case 8:   dataObj.setSubClassCode(cellObj.getStringCellValue()); break;
                	case 9:   dataObj.setExperience(cellObj.getNumericCellValue()); break;
                	case 10:  dataObj.setClaims(cellObj.getNumericCellValue()); break;
                	case 11:  dataObj.setPriorInsurance(cellObj.getStringCellValue()); break;
                	case 12:  dataObj.setLiabilityLimit(cellObj.getStringCellValue()); break;
                	case 13:  dataObj.setDeductible(cellObj.getStringCellValue()); break;
                	case 14:  dataObj.setAI(cellObj.getStringCellValue()); break;
                	case 15:  dataObj.setWaivers(cellObj.getStringCellValue()); break; 
                	case 16:  dataObj.setInlandMarine(cellObj.getStringCellValue()); break;  
                	case 17:  dataObj.setLocationAgregate(cellObj.getStringCellValue()); break;   
                	case 18:  dataObj.setProjectAgregate(cellObj.getStringCellValue()); break;
                	case 19:  dataObj.setExpectedGrossReceipts(cellObj.getNumericCellValue()); break;
                	case 20:  dataObj.setSubContractorGrossReciepts(cellObj.getNumericCellValue()); break;
                	case 21:  dataObj.setInstallationFloater(cellObj.getStringCellValue()); break;
                	case 22:  dataObj.setContractorsHandTools(cellObj.getStringCellValue()); break;
                	case 23:  dataObj.setRentedorLeasedEquipment(cellObj.getStringCellValue()); break;
                	case 24:  dataObj.setFristAddressline(cellObj.getStringCellValue()); break;
                	case 25:  dataObj.setSecAddressline(cellObj.getStringCellValue()); break;
                	case 26:  dataObj.setBusinessType(cellObj.getStringCellValue()); break;
                	case 27:  dataObj.setLocationCity(cellObj.getStringCellValue()); break;
                	case 28:  dataObj.setLocationZipCode(cellObj.getStringCellValue()); break;
                	case 29:  dataObj.setBusinessPhone(cellObj.getStringCellValue()); break;
                	case 30:  dataObj.setBusinessEmail(cellObj.getStringCellValue()); break;
                	case 31:  dataObj.setActiveOwner(cellObj.getNumericCellValue()); break;
                	case 32:  dataObj.setTypeofCompany(cellObj.getStringCellValue()); break;
                	case 33:  dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
                	case 34:  dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
                	
                	//-----------------------------------------------------------------
                	
                	case 35:  dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
                	case 36:  dataObj.setInsuredName(cellObj.getStringCellValue()); break;
                	case 37:  dataObj.setQuoteDate(cellObj.getStringCellValue()); break;
                	case 38:  dataObj.setQuoteNo(cellObj.getStringCellValue()); break;
                	case 39:  dataObj.setCountyCode(cellObj.getStringCellValue()); break;
                	case 40:  dataObj.setFWCIPremium(cellObj.getStringCellValue()); break;
                	case 41:  dataObj.setFWCIMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 42:  dataObj.setCBPremium(cellObj.getStringCellValue()); break;
                	case 43:  dataObj.setCBMGAPolicyFee(cellObj.getStringCellValue()); break;
                	case 44:  dataObj.setFWCIProducerFee(cellObj.getStringCellValue()); break;
                	case 45:  dataObj.setCBProducerFee(cellObj.getStringCellValue()); break;
                	case 46:  dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
                	
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
	                	case 5:   dataObj.setWCCity(cellObj.getStringCellValue()); break;
	                	case 6:   dataObj.setWCState(cellObj.getStringCellValue()); break;
	                	case 7:   dataObj.setWCClassCode(cellObj.getStringCellValue()); break;
	                	case 8:   dataObj.setWCLegalEntity(cellObj.getStringCellValue()); break;
	                	case 9:   dataObj.setWCAddressState(cellObj.getStringCellValue()); break;
	                	case 10:  dataObj.setWCAddress1(cellObj.getStringCellValue()); break;
	                	case 11:  dataObj.setWCAddress2(cellObj.getStringCellValue()); break;
	                	case 12:  dataObj.setWCZipCode(cellObj.getStringCellValue()); break;
	                	case 13:  dataObj.setWCAditionalInsured(cellObj.getStringCellValue()); break;
	                	case 14:  dataObj.setWCEmployerLimit(cellObj.getStringCellValue()); break;
	                	case 15:  dataObj.setWCExpMod(cellObj.getStringCellValue()); break;
	                	case 16:  dataObj.setWCFirstName(cellObj.getStringCellValue()); break;
	                	case 17:  dataObj.setWCLastName(cellObj.getStringCellValue()); break;
	                	case 18:  dataObj.setWCPerOwner(cellObj.getStringCellValue()); break;
	                	case 19:  dataObj.setWCInclude(cellObj.getStringCellValue()); break;
	                	case 20:  dataObj.setWCFTEmployee(cellObj.getStringCellValue()); break; 
	                	case 21:  dataObj.setWCPTEmployee(cellObj.getStringCellValue()); break;
	                	case 22:  dataObj.setWCGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 23:  dataObj.setWCOwnGrossannualPayroll(cellObj.getStringCellValue()); break;
	                	case 24:  dataObj.setWCcontactEmail(cellObj.getStringCellValue()); break;
	                	case 25:  dataObj.setWCcontactPhone(cellObj.getStringCellValue()); break;
	                	case 26:  dataObj.setPaymentOption(cellObj.getStringCellValue()); break;
	                	case 27:  dataObj.setDepositPaymentMethod(cellObj.getStringCellValue()); break;
	                	//-----------------------------------------------------
	                	
	                	case 28:  dataObj.setScriptStatus(cellObj.getStringCellValue()); break;   
	                	case 29:  dataObj.setQuoteNo(cellObj.getStringCellValue()); break;
	                	case 30:  dataObj.setPolicyNo(cellObj.getStringCellValue()); break;
	                	
	                	
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
	


