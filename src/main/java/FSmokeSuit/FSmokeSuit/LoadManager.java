package FSmokeSuit.FSmokeSuit;

public class LoadManager implements Cloneable {
	
		private String AICG2037;
		private String AICG1019;
		private String AICG2404;
		private String AICG2012;
		private String AICG2028;
		private String AICG2029;
		private String AICG2024;
		private String AICG2005;
		private String AICG2011;
		private String AICG2007;
		private String AICG2026;
		private String UWModifyPerm;
		private String SEMake;
		private String SEModel;
		private String SESerialNo;
		private String SELossPayee;
		private String SEName;
		private String SEAddr;
		private String SECity;
		private String SEZip;
		private String ProducerFee;
		private String InspectorName;
		private String LicenseType;
		private String LicenseNumber;
		private String IndustrialPercent;
		private String CommercialPercent;
		private String ResidentialPercent;
		private String NewConstPercent;
		private String RoomAdditionsPercent;
		private String RemodelingPercent;
		private String RepairorServicePercent;
		private String DescriptionOfBusiness;
		private String YearsInBusiness;
		private String SubcontractorDesc;
		private String OwnerPermission;
		private String OwnerCount;
		private String WCInsuredSC;
		private String WCTypeofWork;
		private String WCworkperformed;
		private String WCproofofWCCov;
		private String WCUninsuredSC;
		private String WCBusinessDesc;
		private String AdministrativeEmp;
        private String AdministrativeEmpGrossAtm;
        private String SalesEmployees;
        private String SalesEmployeesGA;
        private String OtherEmp;
        private String WChadCoverage;
        private String WCCarierName;
        private String WCAnyLosses;
        private String WCClaims;
        private String WCTotalIncurred;
        private String WCNotes;
        private String WCMessages;
        private String ActionMessages;
        private String OtherEmpGrossAtm;
        private String UWModifyAdministrativeEmp;
        private String UWModifyAdministrativeEmpGrossAtm;
        private String UWModifySalesEmployees;
        private String UWModifySalesEmployeesGrossAtm;
        private String UWModifyOtherEmployees;
        private String UWModifyOtherEmployeesGA;
		private String AgentNotes;
		private String AgentMessages;
		private String UWModifySEA;
		private String UWModifySED;
		private String UWModifySE;
		private String UWModifyRLE;
		private String UWModifyCHT;
		private String UWModifyIF;
		private String UWModifyIM;
		private String UWModifyAI;
		private String UWModifyWS;
		private String UWModifyRiskLPerm;
		private String UWModifyCounty;
		private String UWModifyBName;
		private String UWModifyFName;
		private String UWModifyLName;
		private String UWModifyLL;
		private String UWModifyDeductible;
		private String UWModifyClassPay;
		private String UWModifyMClasscode;
		private String UWModifySClasscode;
		private String UWModifyActiveOwner;
		private String UWModifyClassSpecificQ;
		private String UWModifyExpectedGross;
		private String UWModifySubContractorGross;
		private String UWModifyUnSubContractorGross;
		private String UWQuoteStatus;
		private String UWReferralRemark;
		private String UWModifyState;
		private String UWModifyCity;
		private String UWModifyZip;
		private String UWAICG2037;
		private String UWAICG1019;
		private String UWAICG2404;
		private String UWAICG2012;
		private String UWAICG2028;
		private String UWAICG2029;
		private String UWAICG2024;
		private String UWAICG2005;
		private String UWAICG2011;
		private String UWAICG2007;
		private String UWAICG2026;
		private String UWAIFCG1001;
		private String UWAICG2010;
		private String UWNotes;
		private String UWMessages;
		private double TestCaseId;
		private String UWPermission;
		private String WCUWModifyBusinessName;
		private String WCUWModifyDBAName;
		private String WCUWModifyCity;
		private String WCUWModifyState;
		private String WCUWModifyClassCode;
		private String WCUWModifyClassCodeDesc;
		private String WCUWModifyClassCodeColor;
		private String WCUWModifyLegalEntity;
		private String WCUWModifyAddressState;
		private String WCUWModifyAddress1;
		private String WCUWModifyAddress2;
		private String WCUWModifyZipCode;
		private String WCUWModifyAditionalInsured;
		private String WCUWModifyEmployerLimit;
		private String WCUWModifyExpMod;
		private String UWModifyOwnerPermission;
		private String UWModifyOwnerCount;
		private String WCUWModifyFirstName;
		private String WCUWModifyLastName;
		private String WCUWModifyPerOwner;
		private String WCUWModifyInclude;
		private String WCUWModifyFTEmployee;
		private String WCUWModifyPTEmployee;
		private String WCUWModifyGrossannualPayroll;
		private String WCUWModifyOwnGrossannualPayroll;
		private String WCUWModifyInsuredSubContractor;
		private String WCUWModifyTypeofWork;
		private String WCUWModifyworkperformed;
		private String WCUWModifyproofofWCcoverage;
		private String WCUWModifyUninsuredSubcontractor;
		private String WCUWModifyBusinessDescription;
		private String WCUWModifyhadCoverage;
		private String WCUWModifyCarierName;
		private String WCUWModifyAnyLosses;
		private String WCUWModifyClaims;
		private String WCUWModifyTotalIncurred;
		private String PermFristLastName;
		private String UWModifyPremFLName;
		private String CreditCardNumber;
		private String CVVNumber;
		private String IncludeExcess;
		private String MExcess;
		private String ChkConvertPolicy;
		private String ConvertPolicyNo;
		private String WCClassCodeGr;
		private String UWWCClassCodeGr;
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
		private String ActiveOwner;
		private double SubContractorGrossReciepts;
		private String UnSubContractorGrossReciepts;
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
		private String UWRateType;
		private String UWModifiedRates;
		private String WCClassCodeDesc;
		private String WCClassCodeColor;
		private String ReferralReason;
		private String WCBusinessName;
		private String WCDBAName;
		private String BusinessName;
		private String FristName;
		private String LastName;
		private String ScheduleEquipment;
		private String ScheduleEquipmentDescription;
		private String ScheduleEquipmentAmount;
		private String AIFCG1001;
		private String AICG2010;
		
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
		public void setActiveOwner(String activeowner) {
			ActiveOwner = activeowner;
		}
		public String getActiveOwner() {
			return ActiveOwner;		
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

		public void setUnSubContractorGrossReciepts(String unSubcontractorGR) {
			UnSubContractorGrossReciepts = unSubcontractorGR;
		}
		public String getUnSubContractorGrossReciepts() {
			return UnSubContractorGrossReciepts;
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

		public void setUWRateType(String suwratetype) {
			UWRateType = suwratetype;
		}
		
		public String getUWRateType() {
			return UWRateType;
		}
		public void setUWModifiedRates(String sUWModifiedRates) {
			UWModifiedRates = sUWModifiedRates;
		}
		public String getUWModifiedRates() {
			return UWModifiedRates;
		}

		public void setWCClassCodeDesc(String swcclasscodedesc) {
			WCClassCodeDesc = swcclasscodedesc;
		}
		public String getWCClassCodeDesc() {
			return WCClassCodeDesc;
		}

		public void setWCClassCodeColor(String swcclasscodecolor) {
			WCClassCodeColor = swcclasscodecolor;
		}
		public String getWCClassCodeColor() {
			return WCClassCodeColor;
		}

		public void setReferralReason(String sreferralreason) {
			ReferralReason = sreferralreason;
		}
		public String getReferralReason() {
			return ReferralReason;
		}

		public void setWCBusinessName(String swcbusinessname) {
			WCBusinessName = swcbusinessname;
		}
		public String getWCBusinessName() {
			return WCBusinessName;
		}

		public void setWCDBAName(String swcdbaname) {
			WCDBAName = swcdbaname;
		}
		public String getWCDBAName() {
			return WCDBAName;
		}

		public void setBusinessName(String sbusinessname) {
			BusinessName = sbusinessname;
		}
		public String getBusinessName() {
			return BusinessName;
		}

		public void setFristName(String sfristname) {
			FristName = sfristname;
		}
		public String getGLFristName() {
			return FristName;
		}
		public void setLastName(String slastname) {
			LastName = slastname;
		}
		public String getLastName() {
			return LastName;
		}

		public void setScheduleEquipment(String sScheduleEquipment) {
			ScheduleEquipment = sScheduleEquipment;	
		}
		public String getScheduleEquipment() {
			return ScheduleEquipment;
		}

		public void setScheduleEquipmentDescription(String sScheduleEquipDesc) {
			ScheduleEquipmentDescription = sScheduleEquipDesc;
		}
		public String getScheduleEquipmentDescription() {
			return ScheduleEquipmentDescription;
		}

		public void setScheduleEquipmentAmount(String sScheduleEquipmentAmount) {
			ScheduleEquipmentAmount = sScheduleEquipmentAmount;
		}
		public String getScheduleEquipmentAmount() {
			return ScheduleEquipmentAmount;
		}

		public void setAIFCG1001(String sAIFCG1001) {
			AIFCG1001 = sAIFCG1001;
		}
		public String getAIFCG1001() {
			return AIFCG1001;
		}

		public void setAICG2010(String sAICG2010) {
			AICG2010 = sAICG2010;
		}
		public String getAICG2010() {
			return AICG2010;
		}

		public void setAICG2037(String sAICG2037) {
			AICG2037 = sAICG2037;
		}
		public String getAICG2037() {
			return AICG2037;
		}
		
		public void setAICG1019(String sAICG1019) {
			AICG1019 = sAICG1019;
			
		}
		public String getAICG1019() {
			return AICG1019;
		}
		
		public void setAICG2404(String sAICG2404) {
			AICG2404 = sAICG2404;
		}
		public String getAICG2404() {
			return AICG2404;
		}
		
		public void setAICG2012(String sAICG2012) {
			AICG2012 = sAICG2012;
		}
		public String getAICG2012() {
			return AICG2012;
		}
		
		public void setAICG2029(String sAICG2029) {
			AICG2029 = sAICG2029;
		}
		public String getAICG2029() {
			return AICG2029;
		}
		
		public void setAICG2028(String sAICG2028) {
			AICG2028 = sAICG2028;			
		}
		public String getAICG2028() {
			return AICG2028;
		}

		public void setAICG2024(String sAICG2024) {
			AICG2024 =sAICG2024;			
		}
		public String getAICG2024() {
			return AICG2024;
		}
		
		public void setAICG2005(String sAICG2005) {
			AICG2005 = sAICG2005;		
		}
		public String getAICG2005() {
			return AICG2005;
		}
		
		public void setAICG2011(String sAICG2011) {
			AICG2011= sAICG2011;			
		}
		public String getAICG2011() {
			return AICG2011;
		}
		
		public void setAICG2007(String sAICG2007) {
			AICG2007 = sAICG2007;		
		}
		public String getAICG2007() {
			return AICG2007;
		}
		
		public void setAICG2026(String sAICG2026) {
			AICG2026 = sAICG2026;		
		}
		public String getAICG2026() {
			return AICG2026;
		}

		public void setUWModifyPerm(String sUWModifyPerm) {
			UWModifyPerm = sUWModifyPerm;		
		}
		public String getUWModifyPerm() {
			return UWModifyPerm;
		}

		public void setSEMake(String sSEMake) {
			SEMake = sSEMake;
		}
		public String getSEMake() {
			return SEMake;
		}
		
		public void setSEModel(String sSEModel) {
			SEModel = sSEModel;
		}
		public String getSEModel() {
			return SEModel;
		}
		
		public void setSESerialNo(String sSESerialNo) {
			SESerialNo = sSESerialNo;	
		}
		public String getSESerialNo() {
			return SESerialNo;
		}
		
		public void setSELossPayee(String sSELossPayee) {
			SELossPayee = sSELossPayee;		
		}
		public String getSELossPayee() {
			return SELossPayee;
		}
		
		public void setSEName(String sSEName) {
			SEName = sSEName;			
		}
		public String getSEName() {
			return SEName;
		}
		
		public void setSEAddr(String sSEAddr) {
			SEAddr = sSEAddr;			
		}
		public String getSEAddr() {
			return SEAddr;
		}
		
		public void setSECity(String sSECity) {
			SECity	= sSECity;	
		}
		public String getSECity() {
			return SECity;
		}
		
		public void setSEZip(String sSEZip) {
			SEZip = sSEZip;
		}
		public String getSEZip() {
			return SEZip;
		}

		public void setAgentNotes(String sAgentNotes) {
			AgentNotes = sAgentNotes;
		}
		public String getAgentNotes() {
			return AgentNotes;
		}

		public void setAgentMessages(String sAgentMessages) {
			AgentMessages = sAgentMessages;
		}
		public String getAgentMessages() {
			return AgentMessages;
		}
		
		public void setUWModifyRiskLPerm(String sUWModifyRiskLPerm) {
			UWModifyRiskLPerm = sUWModifyRiskLPerm;
		}
		public String getUWModifyRiskLPerm() {
			return UWModifyRiskLPerm;
		}
		
		public void setUWModifyCounty(String sUWModifyCounty) {
			UWModifyCounty = sUWModifyCounty;	
		}
		public String getUWModifyCounty() {
			return UWModifyCounty;
		}
		
		public void setUWModifyBName(String sUWModifyBName) {
			UWModifyBName = sUWModifyBName;
		}
		public String getUWModifyBName() {
			return UWModifyBName;
		}
		
		public void setUWModifyFName(String sUWModifyFName) {
			UWModifyFName = sUWModifyFName;
		}
		public String getUWModifyFName() {
			return UWModifyFName;
		}
		
		public void setUWModifyLName(String sUWModifyLName) {
			UWModifyLName = sUWModifyLName;
		}
		public String getUWModifyLName() {
			return UWModifyLName;
		}
		
		public void setUWModifyLL(String sUWModifyLL) {
			UWModifyLL = sUWModifyLL;
		}
		public String getUWModifyLL() {
			return UWModifyLL;
		}
		
		public void setUWModifyDeductible(String sUWModifyDeductible) {
			UWModifyDeductible = sUWModifyDeductible;
		}
		public String getUWModifyDeductible() {
			return UWModifyDeductible;
		}
		
		public void setUWModifyClassPay(String sUWModifyClassPay) {
			UWModifyClassPay = sUWModifyClassPay;
		}
		public String getUWModifyClassPay() {
			return UWModifyClassPay;
		}
		
		public void setUWModifyMainClasscode(String sUWModifyMClasscode) {
			UWModifyMClasscode = sUWModifyMClasscode;
		}
		public String getUWModifyMainClasscode(){
			return UWModifyMClasscode;
		}
		
		public void setUWModifySubClasscode(String sUWModifySClasscode) {
			UWModifySClasscode = sUWModifySClasscode;
			
		}
		public String getUWModifySubClasscode(){
			return UWModifySClasscode;
		}
		
		public void setUWModifyActiveOwner(String sUWModifyActiveOwner) {
			UWModifyActiveOwner = sUWModifyActiveOwner;
		}
		public String getUWModifyActiveOwner(){
			return UWModifyActiveOwner;
		}
		
		public void setUWModifyClassSpecificQ(String sUWModifyClassSpecificQ) {
			UWModifyClassSpecificQ = sUWModifyClassSpecificQ;			
		}
		public String getUWModifyClassSpecificQ(){
			return UWModifyClassSpecificQ;
		}
		
		public void setUWNotes(String sUWNotes) {
			UWNotes = sUWNotes;
		}
		public String getUWNotes(){
			return UWNotes;
		}
		
		public void setUWMessages(String sUWMessages) {
			UWMessages = sUWMessages;
		}
		public String getUWMessages(){
			return UWMessages;
		}

		public void setUWModifyExpectedGross(String sUWModifyExpectedGross) {
			UWModifyExpectedGross =sUWModifyExpectedGross;
		}
		public String getUWModifyExpectedGross(){
			return UWModifyExpectedGross;
		}
		
		public void setUWModifySubContractorGross(String sUWModifySubContractorGross) {
			UWModifySubContractorGross = sUWModifySubContractorGross;			
		}
		public String getUWModifySubContractorGross(){
			return UWModifySubContractorGross;
		}
		
		public void setUWModifyUnSubContractorGross(String sUWModifyUnSubContractorGross) {
			UWModifyUnSubContractorGross = sUWModifyUnSubContractorGross;	
		}
		public String getUWModifyUnSubContractorGross(){
			return UWModifyUnSubContractorGross;
		}

		public void setUWQuoteStatus(String sUWQuoteStatus) {
			UWQuoteStatus = sUWQuoteStatus;			
		}
		public String getUWQuoteStatus(){
			return UWQuoteStatus;
		}

		public void setUWReferralRemark(String sUWReferralRemark) {
			UWReferralRemark = sUWReferralRemark;
		}
		public String getUWReferralRemark(){
			return UWReferralRemark;
		}

		public void setUWModifyState(String sUWModifyState) {
			UWModifyState = sUWModifyState;		
		}
		public String getUWModifyState(){
			return UWModifyState;
		}

		public void setUWModifyCity(String sUWModifycity) {
			UWModifyCity = sUWModifycity;		
		}
		public String getUWModifyCity(){
			return UWModifyCity;
		}

		public void setUWModifyZip(String sUWModifyZip) {
			UWModifyZip = sUWModifyZip;		
		}
		public String getUWModifyZip(){
			return UWModifyZip;
		}

		public void setProducerFee(String sProducerFee) {
			ProducerFee = sProducerFee;			
		}
		public String getProducerFee(){
			return ProducerFee;
		}

		public void setInspectorName(String sInspectorName) {
			InspectorName = sInspectorName;		
		}
		public String getInspectorName(){
			return InspectorName;
		}

		public void setLicenseType(String sLicenseType) {
			LicenseType = sLicenseType ;	
		}
		public String getLicenseType(){
			return LicenseType;
		}

		public void setLicenseNumber(String sLicenseNumber) {
			LicenseNumber = sLicenseNumber;
		}
		public String getLicenseNumber(){
			return LicenseNumber;
		}

		public void setIndustrialPercent(String sIndustrialPercent) {
			IndustrialPercent = sIndustrialPercent;			
		}
		public String getIndustrialPercent(){
			return IndustrialPercent;
		}
		
		public void setCommercialPercent(String sCommercialPercent) {
			CommercialPercent = sCommercialPercent;		
		}
		public String getCommercialPercent(){
			return CommercialPercent;
		}
		
		public void setResidentialPercent(String sResidentialPercent) {
			ResidentialPercent = sResidentialPercent;			
		}
		public String getResidentialPercent(){
			return ResidentialPercent;
		}
		
		public void setNewConstructionPercent(String sNewConstPercent) {
			NewConstPercent = sNewConstPercent;			
		}
		public String getNewConstPercent(){
			return NewConstPercent;
		}
		
		public void setRoomAdditionsPercent(String sRoomAdditionsPercent) {
			RoomAdditionsPercent = sRoomAdditionsPercent;			
		}
		public String getRoomAdditionsPercent(){
			return RoomAdditionsPercent;
		}
		
		public void setRemodelingPercent(String sRemodelingPercent) {
			 RemodelingPercent = sRemodelingPercent;			
		}
		public String getRemodelingPercent(){
			return RemodelingPercent;
		}
		
		public void setRepairorServicePercent(String sRepairorServicePercent) {
			RepairorServicePercent = sRepairorServicePercent;	
		}
		public String getRepairorServicePercent(){
			return RepairorServicePercent;
		}

		public void setDescriptionOfBusiness(String sDescriptionOfBusiness) {
			DescriptionOfBusiness = sDescriptionOfBusiness;			
		}
		public String getDescriptionOfBusiness(){
			return DescriptionOfBusiness;
		}

		public void setYearsInBusiness(String sYearsInBusiness) {
			YearsInBusiness = sYearsInBusiness;			
		}
		public String getYearsInBusiness(){
			return YearsInBusiness;
		}

		public void setSubcontractorDesc(String sSubcontractorDesc) {
			SubcontractorDesc = sSubcontractorDesc;
		}
		public String getSubcontractorDesc(){
			return SubcontractorDesc;
		}

		public void setOwnerPermission(String sOwnerPermission) {
			OwnerPermission = sOwnerPermission;		
		}
		public String getOwnerPermission(){
			return OwnerPermission;
		}

		public void setOwnerCount(String sOwnerCount) {
			OwnerCount = sOwnerCount;
		}
		public String getOwnerCount(){
			return OwnerCount;
		}

		public void setUWModifyAI(String sUWModifyAI) {
			UWModifyAI = sUWModifyAI;
		}
		public String getUWModifyAI(){
			return UWModifyAI;
		}

		public void setUWAIFCG1001(String sUWAIFCG1001) {
			UWAIFCG1001 = sUWAIFCG1001;		
		}
		public String getUWAIFCG1001(){
			return UWAIFCG1001;
		}

		public void setUWAICG2010(String sUWAICG2010) {
			UWAICG2010 = sUWAICG2010;		
		}
		public String getUWAICG2010(){
			return UWAICG2010;
		}

		public void setUWAICG2037(String sUWAICG2037) {
			UWAICG2037 = sUWAICG2037;  			
		}
		public String getUWAICG2037(){
			return UWAICG2037;
		}

		public void setUWAICG1019(String sUWAICG1019) {
			UWAICG1019 = sUWAICG1019;			
		}
		public String getUWAICG1019(){
			return UWAICG1019;
		}

		public void setUWAICG2404(String sUWAICG2404) {
			UWAICG2404 = sUWAICG2404;			
		}
		public String getUWAICG2404(){
			return UWAICG2404;
		}
		
		public void setUWAICG2012(String sUWAICG2012) {
			UWAICG2012 = sUWAICG2012; 			
		}
		public String getUWAICG2012(){
			return UWAICG2012;
		}
		
		public void setUWAICG2029(String sUWAICG2029) {
			UWAICG2029 = sUWAICG2029;			
		}
		public String getUWAICG2029(){
			return UWAICG2029;
		}
		
		public void setUWAICG2028(String sUWAICG2028) {
			UWAICG2028 = sUWAICG2028;			
		}
		public String getUWAICG2028(){
			return UWAICG2028;
		}
		
		public void setUWAICG2024(String sUWAICG2024) {
			UWAICG2024 = sUWAICG2024;			
		}
		public String getUWAICG2024(){
			return UWAICG2024;
		}
		
		public void setUWAICG2005(String sUWAICG2005) {
			UWAICG2005 = sUWAICG2005;			
		}
		public String getUWAICG2005(){
			return UWAICG2005;
		}
		
		public void setUWAICG2011(String sUWAICG2011) {
			UWAICG2011 = sUWAICG2011;		
		}
		public String getUWAICG2011(){
			return UWAICG2011;
		}
		
		public void setUWAICG2007(String sUWAICG2007) {
			UWAICG2007 = sUWAICG2007;			
		}
		public String getUWAICG2007(){
			return UWAICG2007;
		}

		public void setUWAICG2026(String sUWAICG2026) {
			UWAICG2026 = sUWAICG2026;			
		}
		public String getUWAICG2026(){
			return UWAICG2026;
		}

		public void setUWModifyIM(String sUWModifyIM) {
			UWModifyIM = sUWModifyIM;			
		}
		public String getUWModifyIM(){
			return UWModifyIM;
		}
		
		public void setUWModifyInstallationFloater(String sUWModifyIF) {
			UWModifyIF = sUWModifyIF;
		}
		public String getUWModifyInstallationFloater(){
			return UWModifyIF;
		}
		
		public void setUWModifyContractorsHandTools(String sUWModifyCHT) {
			UWModifyCHT = sUWModifyCHT;			
		}
		public String getUWModifyContractorsHandTools(){
			return UWModifyCHT;
		}
		
		public void setUWModifyRentedorLeasedEquipment(String sUWModifyRLE) {
			UWModifyRLE = sUWModifyRLE;		
		}
		public String getUWModifyRentedorLeasedEquipment(){
			return UWModifyRLE;
		}
		
		public void setUWModifyScheduleEquipment(String sUWModifySE) {
			UWModifySE = sUWModifySE;			
		}
		public String getUWModifyScheduleEquipment(){
			return UWModifySE;
		}
		
		public void setUWModifyScheduleEquipmentDescription(String sUWModifySED) {
			UWModifySED = sUWModifySED;
		}
		public String getUWModifyScheduleEquipmentDescription(){
			return UWModifySED;
		}
		
		public void setUWModifyScheduleEquipmentAmount(String sUWModifySEA) {
			UWModifySEA = sUWModifySEA; 			
		}
		public String getUWModifyScheduleEquipmentAmount(){
			return UWModifySEA;
		}

		public void setUWModifyWS(String sUWModifyWS) {
			UWModifyWS = sUWModifyWS;		
		}
		public String getUWModifyWS(){
			return UWModifyWS;
		}

		public void setWCInsuredSubContractor(String sWCInsuredSC) {
			WCInsuredSC	= sWCInsuredSC;	
		}
		public String getWCInsuredSubContractor(){
			return WCInsuredSC;
		}

		public void setWCTypeofWork(String sWCTypeofWork) {
			WCTypeofWork = sWCTypeofWork;			
		}
		public String getWCTypeofWork(){
			return WCTypeofWork;
		}

		public void setWCworkperformed(String sWCworkperformed) {
			WCworkperformed = sWCworkperformed;		
		}
		public String getWCworkperformed(){
			return WCworkperformed;
		}

		public void setWCproofofWCcoverage(String sWCproofofWCCov) {
			WCproofofWCCov = sWCproofofWCCov;			
		}
		public String getWCproofofWCCov(){
			return WCproofofWCCov;
		}

		public void setWCUninsuredSubcontractor(String sWCUninsuredSC) {
			WCUninsuredSC = sWCUninsuredSC;		
		}
		public String getWCUnInsuredSubcontractor(){
			return WCUninsuredSC;
		}

		public void setWCBusinessDescription(String sWCBusinessDesc) {
			WCBusinessDesc = sWCBusinessDesc; 			
		}
		public String getWCBusinessDescription(){
			return WCBusinessDesc;
		}

		public void setAdministrativeEmployee(String sAdministrativeEmp) {
			AdministrativeEmp = sAdministrativeEmp;		
		}
		public String getAdministrativeEmployee(){
			return AdministrativeEmp;
		}
		
		public void setAdministrativeEmployeeGrossAtm(String sAdministrativeEmpGrossAtm) {
			AdministrativeEmpGrossAtm = sAdministrativeEmpGrossAtm;		
		}
		public String getAdministrativeEmployeeGrossAtm(){
			return AdministrativeEmpGrossAtm;
		}
		
		public void setSalesEmployees(String sSalesEmployees) {
			SalesEmployees = sSalesEmployees;			
		}
		public String getSalesEmployees(){
			return SalesEmployees;
		}
		
		public void setSalesEmployeesGrossAtm(String sSalesEmployeesGA) {
			SalesEmployeesGA = sSalesEmployeesGA;
		}
		public String getSalesEmployeesGrossAtm(){
			return SalesEmployeesGA;
		}
		
		public void setOtherEmployees(String sOtherEmp) {
			OtherEmp = sOtherEmp;			
		}
		public String getOtherEmployees(){
			return OtherEmp;
		}
		
		public void setOtherEmployeesGrossAtm(String sOtherEmpGrossAtm) {
			OtherEmpGrossAtm = sOtherEmpGrossAtm;			
		}
		public String getOtherEmpGrossAtm(){
			return OtherEmpGrossAtm;
		}
		
		public void setUWModifyAdministrativeEmployee(String sUWModifyAdministrativeEmp) {
			UWModifyAdministrativeEmp = sUWModifyAdministrativeEmp;		
		}
		public String getUWModifyAdministrativeEmployee(){
			return UWModifyAdministrativeEmp;
		}
		
		public void setUWModifyAdministrativeEmployeeGrossAtm(String sUWModifyAdministrativeEmpGrossAtm) {
			  UWModifyAdministrativeEmpGrossAtm	 = sUWModifyAdministrativeEmpGrossAtm;		
		}
		public String getUWModifyAdministrativeEmployeeGrossAtm(){
			return UWModifyAdministrativeEmpGrossAtm;
		}
		
		public void setUWModifySalesEmployees(String sUWModifySalesEmployees) {
			UWModifySalesEmployees = sUWModifySalesEmployees;			
		}
		public String getUWModifySalesEmployee(){
			return UWModifySalesEmployees;
		}
		
		public void setUWModifySalesEmployeesGrossAtm(String sUWModifySalesEmployeesGrossAtm) {
			 UWModifySalesEmployeesGrossAtm = sUWModifySalesEmployeesGrossAtm;			
		}
		public String getUWModifySalesEmployeeGrossAtm(){
			return UWModifySalesEmployeesGrossAtm;
		}
		
		public void setUWModifyOtherEmployees(String sUWModifyOtherEmployees) {
			UWModifyOtherEmployees = sUWModifyOtherEmployees;			
		}
		public String getUWModifyOtherEmployees(){
			return UWModifyOtherEmployees;
		}
		
		public void setUWModifyOtherEmployeesGrossAtm(String sUWModifyOtherEmployeesGA) {
			UWModifyOtherEmployeesGA = sUWModifyOtherEmployeesGA;			
		}
		public String getUWModifyOtherEmployeesGrossAtm(){
			return UWModifyOtherEmployeesGA;
		}

		public void setWChadCoverage(String sWChadCoverage) {
			WChadCoverage = sWChadCoverage;  			
		}
		public String getWChadCoverage(){
			return WChadCoverage;
		}
		
		public void setWCCarierName(String sWCCarierName) {
			 WCCarierName = sWCCarierName;			
		}
		public String getWCCarierName(){
			return WCCarierName;
		}
		
		public void setWCAnyLosses(String sWCAnyLosses) {
			WCAnyLosses = sWCAnyLosses;			
		}
		public String getWCAnyLosses(){
			return WCAnyLosses;
		}
		
		public void setWCClaims(String sWCClaims) {
			WCClaims = sWCClaims;			
		}
		public String getWCClaims(){
			return WCClaims;
		}
		
		public void setWCTotalIncurred(String sWCTotalIncurred) {
			WCTotalIncurred = sWCTotalIncurred;			
		}
		public String getWCTotalIncurred(){
			return WCTotalIncurred;
		}

		public void setWCNotes(String sWCNotes) {
			WCNotes = sWCNotes;
		}
		public String getWCNotes(){
			return WCNotes;
		}

		public void setWCMessages(String sWCMessages) {
			WCMessages = sWCMessages; 			
		}
		public String getWCMessages(){
			return WCMessages;
		}

		public void setActionMessages(String sActionMessages) {
			ActionMessages = sActionMessages;		
		}
		public String getActionMessages(){
			return ActionMessages;
		}

		public void setUWPermission(String sUWPermission) {
			UWPermission = sUWPermission;		
		}
		public String getUWPermission(){
			return UWPermission;
		}
		
		public void setWCUWModifyBusinessName(String sWCUWModifyBusinessName) {
			WCUWModifyBusinessName	= sWCUWModifyBusinessName;		
		}
		public String getWCUWModifyBusinessName(){
			return WCUWModifyBusinessName;
		}
		
		public void setWCUWModifyDBAName(String sWCUWModifyDBAName) {
			WCUWModifyDBAName = sWCUWModifyDBAName;			
		}
		public String getWCUWModifyDBAName(){
			return WCUWModifyDBAName;
		}
		
		public void setWCUWModifyCity(String sWCUWModifyCity) {
			WCUWModifyCity	= sWCUWModifyCity;		
		}
		public String getWCUWModifyCity(){
			return WCUWModifyCity;
		}
		
		public void setWCUWModifyState(String sWCUWModifyState) {
			WCUWModifyState = sWCUWModifyState;
		}
		public String getWCUWModifyState(){
			return WCUWModifyState;
		}
		
		public void setWCUWModifyClassCode(String sWCUWModifyClassCode) {
			WCUWModifyClassCode	= sWCUWModifyClassCode;
		}
		public String getWCUWModifyClassCode(){
			return WCUWModifyClassCode;
		}
		
		public void setWCUWModifyClassCodeDesc(String sWCUWModifyClassCodeDesc) {
			WCUWModifyClassCodeDesc	= sWCUWModifyClassCodeDesc;	
		}
		public String getWCUWModifyClassCodeDesc(){
			return WCUWModifyClassCodeDesc;
		}
		
		public void setWCUWModifyClassCodeColor(String sWCUWModifyClassCodeColor) {
			WCUWModifyClassCodeColor = sWCUWModifyClassCodeColor;
		}
		public String getWCUWModifyClassCodeColor(){
			return WCUWModifyClassCodeColor;
		}
		
		public void setWCUWModifyLegalEntity(String sWCUWModifyLegalEntity) {
			WCUWModifyLegalEntity = sWCUWModifyLegalEntity;			
		}
		public String getWCUWModifyLegalEntity(){
			return WCUWModifyLegalEntity;
		}
		
		public void setWCUWModifyAddressState(String sWCUWModifyAddressState) {
			WCUWModifyAddressState = sWCUWModifyAddressState;
		}
		public String getWCUWModifyAddressState(){
			return WCUWModifyAddressState;
		}
		
		public void setWCUWModifyAddress1(String sWCUWModifyAddress1) {
			WCUWModifyAddress1 = sWCUWModifyAddress1;			
		}
		public String getWCUWModifyAddress1(){
			return WCUWModifyAddress1;
		}
		
		public void setWCUWModifyAddress2(String sWCUWModifyAddress2) {
			WCUWModifyAddress2 = sWCUWModifyAddress2;			
		}
		public String getWCUWModifyAddress2(){
			return WCUWModifyAddress2;
		}
		
		public void setWCUWModifyZipCode(String sWCUWModifyZipCode) {
			WCUWModifyZipCode = sWCUWModifyZipCode;		
		}
		public String getWCUWModifyZipCode(){
			return WCUWModifyZipCode;
		}
		public void setWCUWModifyAditionalInsured(String sWCUWModifyAditionalInsured) {
			WCUWModifyAditionalInsured = sWCUWModifyAditionalInsured; 			
		}
		public String getWCUWModifyAditionalInsured(){
			return WCUWModifyAditionalInsured;
		}
		
		public void setWCUWModifyEmployerLimit(String sWCUWModifyEmployerLimit) {
			WCUWModifyEmployerLimit	= sWCUWModifyEmployerLimit;
		}
		public String getWCUWModifyEmployerLimit(){
			return WCUWModifyEmployerLimit;
		}
		
		public void setWCUWModifyExpMod(String sWCUWModifyExpMod) {
			WCUWModifyExpMod = sWCUWModifyExpMod;	
		}
		public String getWCUWModifyExpMod(){
			return WCUWModifyExpMod;
		}
		
		public void setUWModifyOwnerPermission(String sUWModifyOwnerPermission) {
			UWModifyOwnerPermission = sUWModifyOwnerPermission;			
		}
		public String getUWModifyOwnerPermission(){
			return UWModifyOwnerPermission;
		}

		public void setUWModifyOwnerCount(String sUWModifyOwnerCount) {
			UWModifyOwnerCount	= sUWModifyOwnerCount;	
		}
		public String getUWModifyOwnerCount(){
			return UWModifyOwnerCount;
		}
		
		public void setWCUWModifyFirstName(String sWCUWModifyFirstName) {
			WCUWModifyFirstName = sWCUWModifyFirstName;			
		}
		public String getWCUWModifyFirstName(){
			return WCUWModifyFirstName;
		}
		
		public void setWCUWModifyLastName(String sWCUWModifyLastName) {
			WCUWModifyLastName = sWCUWModifyLastName;			
		}
		public String getWCUWModifyLastName(){
			return WCUWModifyLastName;
		}
		
		public void setWCUWModifyPerOwner(String sWCUWModifyPerOwner) {
			WCUWModifyPerOwner = sWCUWModifyPerOwner;		
		}
		public String getWCUWModifyPerOwner(){
			return WCUWModifyPerOwner;
		}
		
		public void setWCUWModifyInclude(String sWCUWModifyInclude) {
			WCUWModifyInclude = sWCUWModifyInclude;			
		}
		public String getWCUWModifyInclude(){
			return WCUWModifyInclude;
		}

		public void setWCUWModifyFTEmployee(String sWCUWModifyFTEmployee) {
			WCUWModifyFTEmployee = sWCUWModifyFTEmployee;			
		}
		public String getWCUWModifyFTEmployee(){
			return WCUWModifyFTEmployee;
		}
		
		public void setWCUWModifyPTEmployee(String sWCUWModifyPTEmployee) {
			WCUWModifyPTEmployee = sWCUWModifyPTEmployee;			
		}
		public String getWCUWModifyPTEmployee(){
			return WCUWModifyPTEmployee;
		}
		
		public void setWCUWModifyGrossannualPayroll(String sWCUWModifyGrossannualPayroll) {
			WCUWModifyGrossannualPayroll = sWCUWModifyGrossannualPayroll;			
		}
		public String getWCUWModifyGrossannualPayroll(){
			return WCUWModifyGrossannualPayroll;
		}
		
		public void setWCUWModifyOwnGrossannualPayroll(String sWCUWModifyOwnGrossannualPayroll) {
			WCUWModifyOwnGrossannualPayroll = sWCUWModifyOwnGrossannualPayroll;			
		}
		public String getWCUWModifyOwnGrossannualPayroll(){
			return WCUWModifyOwnGrossannualPayroll;
		}
		
		public void setWCUWModifyInsuredSubContractor(String sWCUWModifyInsuredSubContractor) {
			WCUWModifyInsuredSubContractor = sWCUWModifyInsuredSubContractor;			
		}
		public String getWCUWModifyInsuredSubContractor(){
			return WCUWModifyInsuredSubContractor;
		}

		public void setWCUWModifyTypeofWork(String sWCUWModifyTypeofWork) {
			WCUWModifyTypeofWork = sWCUWModifyTypeofWork;			
		}
		public String getWCUWModifyTypeofWork(){
			return WCUWModifyTypeofWork;
		}
		
		public void setWCUWModifyworkperformed(String sWCUWModifyworkperformed) {
			WCUWModifyworkperformed = sWCUWModifyworkperformed;			
		}
		public String getWCUWModifyworkperformed(){
			return WCUWModifyworkperformed;
		}
		
		public void setWCUWModifyproofofWCcoverage(String sWCUWModifyproofofWCcoverage) {
		   WCUWModifyproofofWCcoverage	= sWCUWModifyproofofWCcoverage;		
		}
		public String getWCUWModifyproofofWCcoverage(){
			return WCUWModifyproofofWCcoverage;
		}
		
		public void setWCUWModifyUninsuredSubcontractor(String sWCUWModifyUninsuredSubcontractor) {
			WCUWModifyUninsuredSubcontractor = sWCUWModifyUninsuredSubcontractor;			
		}
		public String getWCUWModifyUninsuredSubcontractor(){
			return WCUWModifyUninsuredSubcontractor;
		}
		
		public void setWCUWModifyBusinessDescription(String sWCUWModifyBusinessDescription) {
			WCUWModifyBusinessDescription = sWCUWModifyBusinessDescription;			
		}
		public String getWCUWModifyBusinessDescription(){
			return WCUWModifyBusinessDescription;
		}
		
		public void setWCUWModifyhadCoverage(String sWCUWModifyhadCoverage) {
			WCUWModifyhadCoverage = sWCUWModifyhadCoverage;		
		}
		public String getWCUWModifyhadCoverage(){
			return WCUWModifyhadCoverage;
		}
		
		public void setWCUWModifyCarierName(String sWCUWModifyCarierName) {
			WCUWModifyCarierName = sWCUWModifyCarierName;			
		}
		public String getWCUWModifyCarierName(){
			return WCUWModifyCarierName;
		}
		
		public void setWCUWModifyAnyLosses(String sWCUWModifyAnyLosses) {
			WCUWModifyAnyLosses = sWCUWModifyAnyLosses; 			
		}
		public String getWCUWModifyAnyLosses(){
			return WCUWModifyAnyLosses;
		}
		
		public void setWCUWModifyClaims(String sWCUWModifyClaims) {
			WCUWModifyClaims = sWCUWModifyClaims;			
		}
		public String getWCUWModifyClaims(){
			return WCUWModifyClaims;
		}
		
		public void setWCUWModifyTotalIncurred(String sWCUWModifyTotalIncurred) {
			WCUWModifyTotalIncurred = sWCUWModifyTotalIncurred;			
		}
		public String getWCUWModifyTotalIncurred(){
			return WCUWModifyTotalIncurred;
		}

		public void setPermFristLastName(String sPermFristLastName) {
			PermFristLastName = sPermFristLastName;
		}
		public String getPermFristLastName(){
			return PermFristLastName;
		}

		public void setUWModifyPremFLName(String sUWModifyPremFLName) {
			UWModifyPremFLName = sUWModifyPremFLName;			
		}
		public String getUWModifyPremFLName(){
			return UWModifyPremFLName;
		}

		public void setCreditCardNumber(String sCreditCardNmber) {
			CreditCardNumber= sCreditCardNmber;
		}
		public String getCreditCardNumber(){
			return CreditCardNumber;
		}

		public void setCVVNumber(String sCVVNumber) {
			CVVNumber = sCVVNumber; 			
		}
		public String getCVVNumber(){
			return CVVNumber;
		}

		public void setIncludeExcess(String sIncludeExcess) {
			IncludeExcess = sIncludeExcess;	
		}
		public String getIncludeExcess(){
			return IncludeExcess;
		}

		public void setMExcess(String sMExcess) {
			MExcess = sMExcess;	
		}
		public String getMExcess(){
			return MExcess;
		}

		public void setChkConvertPolicy(String sChkConvertPolicy) {
			ChkConvertPolicy = sChkConvertPolicy;
		}
		
		public String getChkConvertPolicy(){
			return ChkConvertPolicy;
		}

		public void setConvertPolicyNo(String sConvertPolicyNo) {
			ConvertPolicyNo = sConvertPolicyNo;
		}
		public String getConvertPolicy(){
			return ConvertPolicyNo;
		}

		public void setWCClassCodeGroup(String sWCClassCodeGr) {
			WCClassCodeGr = sWCClassCodeGr;
		}
		public String getWCClassCodeGroup(){
			return WCClassCodeGr;
		}

		public void setWCUWModifyClassCodeGroup(String sUWWCClassCodeGr) {
			UWWCClassCodeGr = sUWWCClassCodeGr;
		}
		public String getWCUWModifyClassCodeGroup(){
			return UWWCClassCodeGr;
		}
		
	}
