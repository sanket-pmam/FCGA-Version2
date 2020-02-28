package FSmokeSuit.FSmokeSuit;

public class LoadManager implements Cloneable {
	
		private double TestCaseId;
		private String Product;
		private String State;
		private String County;
        private String TCScenarios;
        private String AgentName;
        private String ExecutionStatus;
		private String ScriptStatus;
		private String QuoteNo;
		private String PolicyNo;
		private String ClassCode;
		private String SubClassCode;
		private double Experience;
		private double Claims;
		private String PriorInsurance;
		private String LiabilityLimit;
		private String Deductible;
		private String AI;
		private String Waivers;
		private String InlandMarine;
		private String LocationAgregate;
		private String ProjectAgregate;
		private double ExpectedGrossReceipts;
		private String TypeofCompany;
		private double ActiveOwner;
		private double SubContractorGrossReciepts;
		private String InstallationFloater;
		private String ContractorsHandTools;
		private String RentedorLeasedEquipment;
		private String WCCity;
		private String WCState;
		private String WCClassCode;
		private String WCLegalEntity;
		private String WCAddress1;
		private String WCAddress2;
		private String WCZipCode;
		private String WCEmployerLimit;
		private String WCExpMod;
		private String WCFirstName;
		private String WCLastName;
		private String WCPerOwner;
		private String WCInclude;
		private String WCFTEmployee;
		private String WCPTEmployee;
		private String WCGrossannualPayroll;
		private String BusinessEmail;
		private String FristAddressline;
		private String SecAddressline;
		private String LocationCity;
		private String LocationZipCode;
		private String BusinessPhone;
		private String BusinessType;
		private String PaymentOption;
		private String DepositPaymentMethod;
		private String LPCarrier;
		private String WCcontactEmail;
		private String WCcontactPhone;
		private String ClassCodeId;
		private String GLPrimaryUWQuestions;
		private String GLQuestionResult;
		private String InsuredName;
		private String QuoteDate;
		private String CountyCode;
		private String FWCIPremium;
		private String FWCIMGAPolicyFee;
		private String CBPremium;
		private String CBMGAPolicyFee;
		private String FWCIProducerFee;
		private String CBProducerFee;
		private String WCAddressState;
		private String WCOwnGrossannualPayroll;
		private String WCAditionalInsured;
		
		public Object clone() throws
	     CloneNotSupportedException
			{
			return super.clone();
		}
		
		public void setTestCaseId(double testCaseId) {
			TestCaseId = testCaseId;
		}
		public String getTestCaseId() {
			return String.valueOf(Math.round(TestCaseId));
		}
		public void setProduct(String product) {
			Product = product;
		}
		public String getProduct() {
			return Product;
		}
		public void setState(String state) {
			State = state;
		}
		public String getState() {
			return State;
		}

		public void setCounty(String county) {
			County = county;
		}
		public String getCounty() {
			return County;
		}

		public void setTCScenarios(String tcScenarios) {
			TCScenarios = tcScenarios;
		}
		public String getTCScenarios() {
			return TCScenarios;
		}
		
		public void setAgentName(String agentname) {
			AgentName = agentname;
		}
		public String getAgentName() {
			return AgentName;
		}
		public void setExecutionStatus(String executionstatus) {
			ExecutionStatus = executionstatus;
		}
		public String getExecutionStatus() {
			return ExecutionStatus;
		}

		public void setScriptStatus(String scriptstatus) {
			ScriptStatus = scriptstatus;
		}
		public String getScriptStatus() {
			return ScriptStatus;
		}
		public void setQuoteNo(String quoteno) {
			QuoteNo = quoteno;
		}
		public String getQuoteNo() {
			return QuoteNo;
		}
		public void setPolicyNo(String policyno) {
			PolicyNo = policyno;
		}
		public String getPolicyNo() {
			return PolicyNo;
		}
		public void setClassCode(String classcode) {
			ClassCode = classcode;	
		}
		public String getClassCode() {
			return ClassCode;	
		}
		public void setSubClassCode(String subclasscode) {
			SubClassCode = subclasscode;	
		}
		public String getSubClassCode() {
			return SubClassCode;	
		}
		public void setExperience(double experience) {
			Experience = experience;
		}
		public String getExperience() {
			return String.valueOf(Math.round(Experience));	
		}
		public void setClaims(double claims) {
			Claims = claims;
		}
		public String getClaims() {
			return String.valueOf(Math.round(Claims));	
		}
		public void setPriorInsurance(String priorinsurance) {
			PriorInsurance = priorinsurance;
		}
		public String getPriorInsurance() {
			return PriorInsurance;	
		}
		public void setLiabilityLimit(String liabilitylimit) {
			LiabilityLimit = liabilitylimit;
			
		}
		public String getLiabilityLimit() {
			return LiabilityLimit;	
		}
		public void setDeductible(String deductible) {
			Deductible = deductible;
		}
		public String getDeductible() {
			return Deductible;	
		}
		public void setAI(String sAI) {
			AI = sAI;
		}
		public String getAI() {
			return AI;	
		}
		public void setWaivers(String waivers) {
			Waivers = waivers;
		}
		public String getWaivers() {
			return Waivers;	
		}
		public void setInlandMarine(String inlandmarine) {
			InlandMarine = inlandmarine;
		}
		public String getInlandMarine() {
			return InlandMarine;	
		}
		public void setLocationAgregate(String locationagregate) {
			LocationAgregate = locationagregate;
		}
		public String getLocationAgregate() {
			return LocationAgregate;	
		}
		public void setProjectAgregate(String projectagregate) {
			ProjectAgregate = projectagregate;
		}
		public String getProjectAgregate() {
			return ProjectAgregate;	
		}
		public void setExpectedGrossReceipts(double expectedgrossreceipts) {
			ExpectedGrossReceipts = expectedgrossreceipts;	
		}
		public String getExpectedGrossReceipts() {
			return Double.toString(Math.round(ExpectedGrossReceipts));	
		}
		public void setActiveOwner(double activeowner) {
			ActiveOwner = activeowner;
		}
		public String getActiveOwner() {
			return String.valueOf(Math.round(ActiveOwner));		
		}
		public void setTypeofCompany(String typeofcompany) {
			TypeofCompany = typeofcompany;
		}
		public String getTypeofCompany() {
			return TypeofCompany;	
		}

		public void setSubContractorGrossReciepts(double SubcontractorGR) {
			SubContractorGrossReciepts = SubcontractorGR;
		}
		public String getSubContractorGrossReciepts() {
			return String.valueOf(Math.round(SubContractorGrossReciepts));
		}

		public void setInstallationFloater(String installationfloater) {
			InstallationFloater = installationfloater;
		}
		public String getInstallationFloater() {
			return InstallationFloater;
		}

		public void setContractorsHandTools(String contractorshandtools) {
			ContractorsHandTools = contractorshandtools;	
		}
		public String getContractorsHandTools() {
			return ContractorsHandTools;
		}

		public void setRentedorLeasedEquipment(String rentedorleasedequipment) {
			RentedorLeasedEquipment = rentedorleasedequipment;
			
		}
		public String getRentedorLeasedEquipment() {
			return RentedorLeasedEquipment;	
		}

		public void setFristAddressline(String fristaddressline) {
			FristAddressline = fristaddressline;
			
		}
		public String getFristAddressline() {
			return FristAddressline;	
		}
		
		public void setSecAddressline(String secaddressline) {
			SecAddressline = secaddressline;
			
		}
		public String getSecAddressline() {
			return SecAddressline;	
		}
		public void setLocationCity(String locationcity) {
			LocationCity = locationcity;
			
		}
		public String getLocationCity() {
			return LocationCity;	
		}
		public void setLocationZipCode(String locationzipcode) {
			LocationZipCode = locationzipcode;
			
		}
		public String getLocationZipCode() {
			return LocationZipCode;	
		}
		
		public void setBusinessPhone(String businessphone) {
			BusinessPhone = businessphone;
			
		}
		public String getBusinessPhone() {
			return BusinessPhone;	
		}
		public void setBusinessEmail(String businessemail) {
			BusinessEmail = businessemail;
			
		}
		public String getBusinessEmail() {
			return BusinessEmail;	
		}
		
		public void setBusinessType(String businesstype) {
			BusinessType = businesstype;
			
		}
		public String getBusinessType() {
			return BusinessType;	
		}
		
		public void setPaymentOption(String paymentoption) {
			PaymentOption = paymentoption;
			
		}
		public String getPaymentOption() {
			return PaymentOption;	
		}
		
		public void setDepositPaymentMethod(String depositpaymentmethod) {
			DepositPaymentMethod = depositpaymentmethod;
			
		}
		public String getDepositPaymentMethod() {
			return DepositPaymentMethod;	
		}
		//----- WC Load Manager ------ 
		
		public void setWCCity(String wccity) {
			WCCity = wccity;
		}
		public String getWCCity() {
			return WCCity;
		}
		
		public void setWCState(String wcstate) {
			WCState = wcstate;
		}
		public String getWCState() {
			return WCState;
		}

		public void setWCClassCode(String wcclasscode) {
			WCClassCode = wcclasscode;
		}
		public String getWCClassCode() {
			return WCClassCode;
		}

		public void setWCLegalEntity(String wclegalentity) {
			WCLegalEntity = wclegalentity;
		}
		
		public String getWCLegalEntity() {
			return WCLegalEntity;
		}
		
		public void setWCAddress1(String wcaddress1) {
			WCAddress1 = wcaddress1;
		}
		
		public String getWCAddress1() {
			return WCAddress1;
		}
		
		public void setWCAddress2(String wcaddress2) {
			WCAddress2 = wcaddress2;
		}
		
		public String getWCAddress2() {
			return WCAddress2;
		}
		
		public void setWCExpMod(String wcexpmod) {
			WCExpMod = wcexpmod;
		}
		
		public String getWCExpMod() {
			return WCExpMod;
		}
		
		public void setWCZipCode(String wczipcode) {
			WCZipCode = wczipcode;
		}
		
		public String getWCZipCode() {
			return WCZipCode;
		}
		
		public void setWCEmployerLimit(String wcemployerlimit) {
			WCEmployerLimit = wcemployerlimit;
		}
		
		public String getWCEmployerLimit() {
			return WCEmployerLimit;
		}
		
		public void setWCFirstName(String wcfirstname) {
			WCFirstName = wcfirstname;
		}
		
		public String getWCFirstName() {
			return WCFirstName;
		}
		
		public void setWCLastName(String wclastname) {
			WCLastName = wclastname;
		}
		
		public String getWCLastName() {
			return WCLastName;
		}
		
		public void setWCPerOwner(String wcperowner) {
			WCPerOwner = wcperowner;
		}
		
		public String getWCPerOwner() {
			return WCPerOwner;
		}
		
		public void setWCInclude(String wcinclude) {
			WCInclude = wcinclude;
		}
		
		public String getWCInclude() {
			return WCInclude;
		}
		
		public void setWCFTEmployee(String wcftemployee) {
			WCFTEmployee = wcftemployee;
		}
		
		public String getWCFTEmployee() {
			return WCFTEmployee;
		}
		
		public void setWCPTEmployee(String wcptemployee) {
			WCPTEmployee = wcptemployee;
		}
		
		public String getWCPTEmployee() {
			return WCPTEmployee;
		}
		
		public void setWCGrossannualPayroll(String wcgrossannualpayroll) {
			WCGrossannualPayroll = wcgrossannualpayroll;
		}
		
		public String getWCGrossannualPayroll() {
			return WCGrossannualPayroll;
		}
		
		
		public void setLPCarrier(String lpCarrier) {
			LPCarrier = lpCarrier;
		}
		
		public String getLPCarrier() {
			return LPCarrier;
		}
		
		public void setWCcontactEmail(String wcContactEmail) {
			WCcontactEmail = wcContactEmail;
		}
		
		public String getWCcontactEmail() {
			return WCcontactEmail;
		}
		
		public void setWCcontactPhone(String wcContactPhone) {
			WCcontactPhone = wcContactPhone;
		}
		
		public String getWCcontactPhone() {
			return WCcontactPhone;
		}

		public void setGLClassCodeId(String classcodeId) {
			ClassCodeId = classcodeId;
			
		}
		
		public String getGLClassCodeId() {
			return ClassCodeId;
		}

		public void setGLPrimaryUWQuestions(String UWQuestion) {
			GLPrimaryUWQuestions = UWQuestion;
			
		}
		
		public String getGLPrimaryUWQuestions() {
			return GLPrimaryUWQuestions;
		}

		public void setGLQuestionResult(String QuestionResult) {
			GLQuestionResult =QuestionResult;
		}
		
		public String getGLQuestionResult() {
			return GLQuestionResult;
		}

		public void setInsuredName(String sInsuredName) {
			InsuredName = sInsuredName;
		}
		
		public String getInsuredName() {
			return InsuredName;
		}

		public void setQuoteDate(String sQuoteDate) {
			QuoteDate = sQuoteDate;
		}
		
		public String getQuoteDate() {
			return QuoteDate;
		}

		public void setCountyCode(String sCountyCode) {
			CountyCode = sCountyCode;
		}
		public String getCountyCode() {
			return CountyCode;
		}

		public void setFWCIPremium(String sFWCIPremium) {
			FWCIPremium = sFWCIPremium;
		}
		public String getFWCIPremium() {
			return FWCIPremium;
		}

		public void setFWCIMGAPolicyFee(String sFWCIMGAPolicyFee) {
			FWCIMGAPolicyFee = sFWCIMGAPolicyFee;
		}
		public String getFWCIMGAPolicyFee() {
			return FWCIMGAPolicyFee;
		}

		public void setCBPremium(String sCBPremium) {
			CBPremium = sCBPremium;	
		}
		public String getCBPremium() {
			return CBPremium;
		}
		
		public void setCBMGAPolicyFee(String sCBMGAPolicyFee) {
			CBMGAPolicyFee = sCBMGAPolicyFee;
		}
		public String getCBMGAPolicyFee() {
			return CBMGAPolicyFee;
		}

		public void setFWCIProducerFee(String sFWCIProducerFee) {
			FWCIProducerFee = sFWCIProducerFee;
		}
		public String getFWCIProducerFee() {
			return FWCIProducerFee;
		}

		public void setCBProducerFee(String sCBProducerFee) {
			CBProducerFee = sCBProducerFee;	
		}
		public String getCBProducerFee() {
			return CBProducerFee;
		}

		public void setWCAddressState(String sWCAddressState) {
			WCAddressState = sWCAddressState;
		}
		public String getWCAddressState() {
			return WCAddressState;
		}

		public void setWCOwnGrossannualPayroll(String sWCOwnGrossannualPayroll) {
			WCOwnGrossannualPayroll = sWCOwnGrossannualPayroll;
			
		}
		public String getWCOwnGrossannualPayroll() {
			return WCOwnGrossannualPayroll;
		}
		public void setWCAditionalInsured(String sWCAditionalInsured) {
			WCAditionalInsured = sWCAditionalInsured;
		}
		public String getWCAditionalInsured() {
			return WCAditionalInsured;
		}
	}

