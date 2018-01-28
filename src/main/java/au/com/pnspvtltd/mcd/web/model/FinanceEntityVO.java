package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

import au.com.pnspvtltd.mcd.domain.Dealer;



public class FinanceEntityVO {


	
												
		
	
	
	private Long financeEntityId;
	private long refId;
	
	private String financeProvider;
	private String financeProviderType;
	private String abnNo;
	private String australianCreditLicenceNo;
	private String australianFinancialSerLic;
	private String financeSerAuthRepLicNo;
	private String contactNumber;
	private String registeredAddress;
	private String contactPerson;
	private String contactPersonPhone;
	private String contactPersonEmail;
	private String uniqueID;
	private String productID;
	private Date productStartDate;
	private Date productEndDate;
	//private boolean creditCheckReq;
	private String minAgeLoanSeeker;
	private String maxAgeLoanSeeker;
	private boolean perResReqType;
	private String minAgeCar;
	private String maxAgeCar;
	private double norIntRateInitApp;
	private double normalCompRateInitApp;
	private double minAmtLoan;
	private double maxAmtLoan;
	private boolean insCostInc;
	private boolean onRoadCostInc;
	private String resAgeCarManfYear;
	private boolean directDebit;
	private boolean bpayMode;
	private boolean addPayAllow;
	private boolean foreClosAllow;
	//private double earlyRepayFees;
	private String payFreq;
	private boolean canFinPurThrPrivSell;
	private String creditRatingTypAllowed;
	private String minCreditScore;
	private String maxCreditScore;
	private boolean badCredAllowed;
	private double intrRateBelowAvrg;
	private double compRateBelowAvrg;
	private double intrRateAvrg;
	private double compRateAvrg;
	private double intrRateGood;
	private double compRateGood;
	private double intrRateVeryGood;
	private double compRateVeryGood;
	private double intrRateExcellent;
	private double compRateExcellent;
	private double bankCharges;
	private boolean addPayAllowed;
	private boolean foreClosureAllowed;
	private double earlyRepayFees;
	private double charge1;	
	private double charge2;
	private double charge3;
	private double charge4;
	private double charge5;
	private String restAgeCarManfYear;
	private String verifCert;
	private String paymentCond;
	private String paymentFreq;
	private boolean canFinPurchthrPrvSeller;
	private boolean creditCheckReq;
	private boolean addCond1;	
	private boolean addCond2;
	private boolean addCond3;
	private boolean addCond4;
	private String docReq1;
	private String docReq2;
	private String docReq3;
	private String docReq4;
	private String docReq5;
	private String docReq6;
	private String docReq7;
	private String termsConditions;
	private String productHighlights;
	private String pdsDocumentAttach;

	private Date creationDate;
	/*private boolean status;*/
	
	
	
	
	private String subsType;
	
	

	public String getSubsType() {
		return subsType;
	}

	public void setSubsType(String subsType) {
		this.subsType = subsType;
	}
	
	
	
	public Long getFinanceEntityId() {
		return financeEntityId;
	}


	public boolean isPerResReqType() {
		return perResReqType;
	}


	public void setPerResReqType(boolean perResReqType) {
		this.perResReqType = perResReqType;
	}
	public long getRefId() {
		return refId;
	}

	public void setRefId(long dealerId) {
		this.refId = dealerId;
	}


	public boolean isInsCostInc() {
		return insCostInc;
	}


	public void setInsCostInc(boolean insCostInc) {
		this.insCostInc = insCostInc;
	}


	public boolean isOnRoadCostInc() {
		return onRoadCostInc;
	}


	public void setOnRoadCostInc(boolean onRoadCostInc) {
		this.onRoadCostInc = onRoadCostInc;
	}


	public boolean isDirectDebit() {
		return directDebit;
	}


	public void setDirectDebit(boolean directDebit) {
		this.directDebit = directDebit;
	}


	public boolean isBpayMode() {
		return bpayMode;
	}


	public void setBpayMode(boolean bpayMode) {
		this.bpayMode = bpayMode;
	}


	public boolean isAddPayAllow() {
		return addPayAllow;
	}


	public void setAddPayAllow(boolean addPayAllow) {
		this.addPayAllow = addPayAllow;
	}


	public boolean isForeClosAllow() {
		return foreClosAllow;
	}


	public void setForeClosAllow(boolean foreClosAllow) {
		this.foreClosAllow = foreClosAllow;
	}


	public boolean isAddPayAllowed() {
		return addPayAllowed;
	}


	public void setAddPayAllowed(boolean addPayAllowed) {
		this.addPayAllowed = addPayAllowed;
	}


	public boolean isCanFinPurchthrPrvSeller() {
		return canFinPurchthrPrvSeller;
	}


	public void setCanFinPurchthrPrvSeller(boolean canFinPurchthrPrvSeller) {
		this.canFinPurchthrPrvSeller = canFinPurchthrPrvSeller;
	}


	public boolean isCreditCheckReq() {
		return creditCheckReq;
	}


	public void setCreditCheckReq(boolean creditCheckReq) {
		this.creditCheckReq = creditCheckReq;
	}


	public boolean isAddCond1() {
		return addCond1;
	}


	public void setAddCond1(boolean addCond1) {
		this.addCond1 = addCond1;
	}


	public boolean isAddCond2() {
		return addCond2;
	}


	public void setAddCond2(boolean addCond2) {
		this.addCond2 = addCond2;
	}


	public boolean isAddCond3() {
		return addCond3;
	}


	public void setAddCond3(boolean addCond3) {
		this.addCond3 = addCond3;
	}


	public boolean isAddCond4() {
		return addCond4;
	}


	public void setAddCond4(boolean addCond4) {
		this.addCond4 = addCond4;
	}


	public String getFinanceProvider() {
		return financeProvider;
	}


	public void setFinanceProvider(String financeProvider) {
		this.financeProvider = financeProvider;
	}


	public String getFinanceProviderType() {
		return financeProviderType;
	}


	public void setFinanceProviderType(String financeProviderType) {
		this.financeProviderType = financeProviderType;
	}


	public String getAbnNo() {
		return abnNo;
	}


	public void setAbnNo(String abnNo) {
		this.abnNo = abnNo;
	}


	public String getAustralianCreditLicenceNo() {
		return australianCreditLicenceNo;
	}


	public void setAustralianCreditLicenceNo(String australianCreditLicenceNo) {
		this.australianCreditLicenceNo = australianCreditLicenceNo;
	}


	public String getAustralianFinancialSerLic() {
		return australianFinancialSerLic;
	}


	public void setAustralianFinancialSerLic(String australianFinancialSerLic) {
		this.australianFinancialSerLic = australianFinancialSerLic;
	}


	public String getFinanceSerAuthRepLicNo() {
		return financeSerAuthRepLicNo;
	}


	public void setFinanceSerAuthRepLicNo(String financeSerAuthRepLicNo) {
		this.financeSerAuthRepLicNo = financeSerAuthRepLicNo;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getRegisteredAddress() {
		return registeredAddress;
	}


	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getContactPersonPhone() {
		return contactPersonPhone;
	}


	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}


	public String getContactPersonEmail() {
		return contactPersonEmail;
	}


	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}


	public String getUniqueID() {
		return uniqueID;
	}


	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public Date getProductStartDate() {
		return productStartDate;
	}


	public void setProductStartDate(Date productStartDate) {
		this.productStartDate = productStartDate;
	}


	public Date getProductEndDate() {
		return productEndDate;
	}


	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}


	public String getMinAgeLoanSeeker() {
		return minAgeLoanSeeker;
	}


	public void setMinAgeLoanSeeker(String minAgeLoanSeeker) {
		this.minAgeLoanSeeker = minAgeLoanSeeker;
	}


	public String getMaxAgeLoanSeeker() {
		return maxAgeLoanSeeker;
	}


	public void setMaxAgeLoanSeeker(String maxAgeLoanSeeker) {
		this.maxAgeLoanSeeker = maxAgeLoanSeeker;
	}


	public String getMinAgeCar() {
		return minAgeCar;
	}


	public void setMinAgeCar(String minAgeCar) {
		this.minAgeCar = minAgeCar;
	}


	public String getMaxAgeCar() {
		return maxAgeCar;
	}


	public void setMaxAgeCar(String maxAgeCar) {
		this.maxAgeCar = maxAgeCar;
	}


	public double getNorIntRateInitApp() {
		return norIntRateInitApp;
	}


	public void setNorIntRateInitApp(double norIntRateInitApp) {
		this.norIntRateInitApp = norIntRateInitApp;
	}


	public double getNormalCompRateInitApp() {
		return normalCompRateInitApp;
	}


	public void setNormalCompRateInitApp(double normalCompRateInitApp) {
		this.normalCompRateInitApp = normalCompRateInitApp;
	}


	public double getMinAmtLoan() {
		return minAmtLoan;
	}


	public void setMinAmtLoan(double minAmtLoan) {
		this.minAmtLoan = minAmtLoan;
	}


	public double getMaxAmtLoan() {
		return maxAmtLoan;
	}


	public void setMaxAmtLoan(double maxAmtLoan) {
		this.maxAmtLoan = maxAmtLoan;
	}


	public String getResAgeCarManfYear() {
		return resAgeCarManfYear;
	}


	public void setResAgeCarManfYear(String resAgeCarManfYear) {
		this.resAgeCarManfYear = resAgeCarManfYear;
	}


	public String getPayFreq() {
		return payFreq;
	}


	public void setPayFreq(String payFreq) {
		this.payFreq = payFreq;
	}


	public boolean isCanFinPurThrPrivSell() {
		return canFinPurThrPrivSell;
	}


	public void setCanFinPurThrPrivSell(boolean canFinPurThrPrivSell) {
		this.canFinPurThrPrivSell = canFinPurThrPrivSell;
	}


	public String getCreditRatingTypAllowed() {
		return creditRatingTypAllowed;
	}


	public void setCreditRatingTypAllowed(String creditRatingTypAllowed) {
		this.creditRatingTypAllowed = creditRatingTypAllowed;
	}


	public String getMinCreditScore() {
		return minCreditScore;
	}


	public void setMinCreditScore(String minCreditScore) {
		this.minCreditScore = minCreditScore;
	}


	public String getMaxCreditScore() {
		return maxCreditScore;
	}


	public void setMaxCreditScore(String maxCreditScore) {
		this.maxCreditScore = maxCreditScore;
	}


	public boolean isBadCredAllowed() {
		return badCredAllowed;
	}


	public void setBadCredAllowed(boolean badCredAllowed) {
		this.badCredAllowed = badCredAllowed;
	}


	public double getIntrRateBelowAvrg() {
		return intrRateBelowAvrg;
	}


	public void setIntrRateBelowAvrg(double intrRateBelowAvrg) {
		this.intrRateBelowAvrg = intrRateBelowAvrg;
	}


	public double getCompRateBelowAvrg() {
		return compRateBelowAvrg;
	}


	public void setCompRateBelowAvrg(double compRateBelowAvrg) {
		this.compRateBelowAvrg = compRateBelowAvrg;
	}


	public double getIntrRateAvrg() {
		return intrRateAvrg;
	}


	public void setIntrRateAvrg(double intrRateAvrg) {
		this.intrRateAvrg = intrRateAvrg;
	}


	public double getCompRateAvrg() {
		return compRateAvrg;
	}


	public void setCompRateAvrg(double compRateAvrg) {
		this.compRateAvrg = compRateAvrg;
	}


	public double getIntrRateGood() {
		return intrRateGood;
	}


	public void setIntrRateGood(double intrRateGood) {
		this.intrRateGood = intrRateGood;
	}


	public double getCompRateGood() {
		return compRateGood;
	}


	public void setCompRateGood(double compRateGood) {
		this.compRateGood = compRateGood;
	}


	public double getIntrRateVeryGood() {
		return intrRateVeryGood;
	}


	public void setIntrRateVeryGood(double intrRateVeryGood) {
		this.intrRateVeryGood = intrRateVeryGood;
	}


	public double getCompRateVeryGood() {
		return compRateVeryGood;
	}


	public void setCompRateVeryGood(double compRateVeryGood) {
		this.compRateVeryGood = compRateVeryGood;
	}


	public double getIntrRateExcellent() {
		return intrRateExcellent;
	}


	public void setIntrRateExcellent(double intrRateExcellent) {
		this.intrRateExcellent = intrRateExcellent;
	}


	public double getCompRateExcellent() {
		return compRateExcellent;
	}


	public void setCompRateExcellent(double compRateExcellent) {
		this.compRateExcellent = compRateExcellent;
	}


	public double getBankCharges() {
		return bankCharges;
	}


	public void setBankCharges(double bankCharges) {
		this.bankCharges = bankCharges;
	}


	public boolean isForeClosureAllowed() {
		return foreClosureAllowed;
	}


	public void setForeClosureAllowed(boolean foreClosureAllowed) {
		this.foreClosureAllowed = foreClosureAllowed;
	}


	public double getEarlyRepayFees() {
		return earlyRepayFees;
	}


	public void setEarlyRepayFees(double earlyRepayFees) {
		this.earlyRepayFees = earlyRepayFees;
	}


	public double getCharge1() {
		return charge1;
	}


	public void setCharge1(double charge1) {
		this.charge1 = charge1;
	}


	public double getCharge2() {
		return charge2;
	}


	public void setCharge2(double charge2) {
		this.charge2 = charge2;
	}


	public double getCharge3() {
		return charge3;
	}


	public void setCharge3(double charge3) {
		this.charge3 = charge3;
	}


	public double getCharge4() {
		return charge4;
	}


	public void setCharge4(double charge4) {
		this.charge4 = charge4;
	}


	public double getCharge5() {
		return charge5;
	}


	public void setCharge5(double charge5) {
		this.charge5 = charge5;
	}


	public String getRestAgeCarManfYear() {
		return restAgeCarManfYear;
	}


	public void setRestAgeCarManfYear(String restAgeCarManfYear) {
		this.restAgeCarManfYear = restAgeCarManfYear;
	}


	public String getVerifCert() {
		return verifCert;
	}


	public void setVerifCert(String verifCert) {
		this.verifCert = verifCert;
	}


	public String getPaymentCond() {
		return paymentCond;
	}


	public void setPaymentCond(String paymentCond) {
		this.paymentCond = paymentCond;
	}


	public String getPaymentFreq() {
		return paymentFreq;
	}


	public void setPaymentFreq(String paymentFreq) {
		this.paymentFreq = paymentFreq;
	}


	public String getDocReq1() {
		return docReq1;
	}


	public void setDocReq1(String docReq1) {
		this.docReq1 = docReq1;
	}


	public String getDocReq2() {
		return docReq2;
	}


	public void setDocReq2(String docReq2) {
		this.docReq2 = docReq2;
	}


	public String getDocReq3() {
		return docReq3;
	}


	public void setDocReq3(String docReq3) {
		this.docReq3 = docReq3;
	}


	public String getDocReq4() {
		return docReq4;
	}


	public void setDocReq4(String docReq4) {
		this.docReq4 = docReq4;
	}


	public String getDocReq5() {
		return docReq5;
	}


	public void setDocReq5(String docReq5) {
		this.docReq5 = docReq5;
	}


	public String getDocReq6() {
		return docReq6;
	}


	public void setDocReq6(String docReq6) {
		this.docReq6 = docReq6;
	}


	public String getDocReq7() {
		return docReq7;
	}


	public void setDocReq7(String docReq7) {
		this.docReq7 = docReq7;
	}


	public String getTermsConditions() {
		return termsConditions;
	}


	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}


	public String getProductHighlights() {
		return productHighlights;
	}


	public void setProductHighlights(String productHighlights) {
		this.productHighlights = productHighlights;
	}


	public String getPdsDocumentAttach() {
		return pdsDocumentAttach;
	}


	public void setPdsDocumentAttach(String pdsDocumentAttach) {
		this.pdsDocumentAttach = pdsDocumentAttach;
	}


	public void setFinanceEntityId(Long financeEntityId) {
		this.financeEntityId = financeEntityId;
	}

	
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	/*public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}*/
	
	// Flex start
		private String flex1;

	private String flex2;	
	private String flex3;	
	private String flex4;
	private int flex5;	
	private int flex6;	
	private double flex7;	
	private double flex8;
	private double flex9;	
	private double flex10;
	private Date flex11;
	private Date flex12;
	private boolean isFlex13;
	private boolean isFlex14;
		
	
	

	


	public String getFlex1() {
		return flex1;
	}

	
	public boolean isFlex13() {
		return isFlex13;
	}

	public void setFlex13(boolean isFlex13) {
		this.isFlex13 = isFlex13;
	}

	public boolean isFlex14() {
		return isFlex14;
	}

	public void setFlex14(boolean isFlex14) {
		this.isFlex14 = isFlex14;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}
// End of flex
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	
	

	 	
	
}
