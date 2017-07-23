package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class ExtDealerSearchInsVO {

	private Long extDealerSearchId;
	private String extraExter2;
	private String extraExter3;
	private String extraExter4;
	private String extraExter5;
	private String extraIntern1;
	private String extraIntern2;
	private String extraIntern3;
	private String extraIntern4;
	private String extraIntern5;
	private String incomeType;
	private int yearEmploymentBusiness;
	private String incomeBeforeSuperTax;
	private String incomeAfterSuperTax;
	private String ifBusinessProvideABN;
	private String creditRating;
	private double loanAmount;
	private int loanPeriod;
	private int noOfDependence;
	private String insuranceType;
	private String drivingLicenceType;
	private int drivingLicenceNumber;
	private String drivingLicenceIssuingState;
	private int noOfAtFaultClaims;
	private Date dateOfBirth;
	private double indicativeExcessAmount;
	private Date ageOfAdditionalDriver;
	private Long userid;
	private Long carSearchId;
	private Long dealerId;
	private Date creationDate;
	private boolean status;
	private boolean newer;
	private boolean used;
	private String state;
	
	// start of Finance Ebid
		private boolean isNewer;
		private boolean isUsed;
		
		private String finPostCode;
		
		private int year;
		
		private String make;
		private String model;
		private String variant;
		private String autoscoopTrim;
		private double vehValue;
		private double balloonPay;
		/*private double loanAmount;
		private int loanPeriod;*/
		private double annualIncome;
		/*private String incomeType;
		private String creditRating;
		private Date dateOfBirth;*/
		
		/*private int yearEmploymentBusiness;
		private String incomeBeforeSuperTax;
		private String incomeAfterSuperTax;
		private String ifBusinessProvideABN;*/
		private String rego;
		private String regoState;
		private String streetNo;
		private String streetName;
		private String mr;
		private String firstName;
		private String lastName;
		/*private Date creationDate;*/
		// end of Finance Ebid
	
	// Dealer info Start
		private String category;
		public String getFinPostCode() {
			return finPostCode;
		}

		public void setFinPostCode(String finPostCode) {
			this.finPostCode = finPostCode;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getVariant() {
			return variant;
		}

		public void setVariant(String variant) {
			this.variant = variant;
		}

		public String getAutoscoopTrim() {
			return autoscoopTrim;
		}

		public void setAutoscoopTrim(String autoscoopTrim) {
			this.autoscoopTrim = autoscoopTrim;
		}

		public double getVehValue() {
			return vehValue;
		}

		public void setVehValue(double vehValue) {
			this.vehValue = vehValue;
		}

		public double getBalloonPay() {
			return balloonPay;
		}

		public void setBalloonPay(double balloonPay) {
			this.balloonPay = balloonPay;
		}

		public double getAnnualIncome() {
			return annualIncome;
		}

		public void setAnnualIncome(double annualIncome) {
			this.annualIncome = annualIncome;
		}

		public String getRego() {
			return rego;
		}

		public void setRego(String rego) {
			this.rego = rego;
		}

		public String getRegoState() {
			return regoState;
		}

		public void setRegoState(String regoState) {
			this.regoState = regoState;
		}

		public String getStreetNo() {
			return streetNo;
		}

		public void setStreetNo(String streetNo) {
			this.streetNo = streetNo;
		}

		public String getStreetName() {
			return streetName;
		}

		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}

		public String getMr() {
			return mr;
		}

		public void setMr(String mr) {
			this.mr = mr;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
		// Start of search Insurance
		/*private boolean isNewer;
		private boolean isUsed;
		private Long searchInsuranceId;
		private String postCode;
		private String insuranceType;*/
		private String regNo;
		/*private String regoState;*/
		/*private int year;
		
		private String make;
		private String model;
		private String variant;
		private String autoscoopTrim;*/
		private double marketValue;
		private double agreedValue;
		/*private boolean finance;*/
		private String financeProvider;
		private String drivingLicenseType;
		private String drivingLicenseNo;
		private String drivingLicenseIssueState;
		private int noOfAtFaults;
		private String otherIssues;
		private String curInsProv;
		private double prefExcessAmount;
		/*private Date dateOfBirth;
		private Date ageOfAdditionalDriver;*/
		
		private String carParkedAt;
		//private String streetNO;
		/*private String streetName;*/
		private String carUsedfor;
		private String typeOfBusiness;
		private String driverFirstName;
		private String driverLastName;
		private String driverMobileNo;
		private String driverEmailId;
		private Date licenseIssueDate;
		private Date lastAtFaultClaimDate;
		private String reasonForSuspension;
		private int avgNoOfKmYr;
		private int noOfDrivers;
		private boolean licenseGotSuspened;
		
		// Insurance extra requirements
		private boolean extNudgeBar;//Emergency accommodation and Transport
		private boolean extBullBar; //Accidental Damage
		private boolean extsnokel; //Essential Temporary Repairs
		private boolean intNudgeBar; //Cover Towing Cost
		private boolean intBullBar; //Cover Theft & Fire
		private boolean intsnokel;//No Claim Bonus Protection
		private boolean AnyDriver;//Allow Under 25 Driver
		private boolean FreeWindScreen;//Excess Free wind Screen
		private boolean Roadsideasst;//Road Side Assistance
		private boolean RentalCar; //Excess Free Window Screen
		private boolean NewCarRepl;//New Car Replace
		private boolean LifetimeWarrep;//Life time Warranty repairs
		private boolean HireCar;//Hire Car after Accident(if any)
		private boolean BullBar;
		private boolean Snokel;
		private boolean NudgeBar; 
		
		/*private Date creationDate;
	private long idp;*/
		// end of search Insurance
		
		
		private String companyName;
		private String street;
		private String suburb;
		private String dealState;
		private int postCode;
		private String country;
		private String phone;
		private String website;
		private String mobile;
		private String tollFree;
		private String fax;
		private String afterHours;
		private String postalAddress;
		private String email;
		private float longitude;
		private float latitude;
		// Dealer info end
	
	
	public String getState() {
		return state;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public double getAgreedValue() {
		return agreedValue;
	}

	public void setAgreedValue(double agreedValue) {
		this.agreedValue = agreedValue;
	}

	public String getFinanceProvider() {
		return financeProvider;
	}

	public void setFinanceProvider(String financeProvider) {
		this.financeProvider = financeProvider;
	}

	public String getDrivingLicenseType() {
		return drivingLicenseType;
	}

	public void setDrivingLicenseType(String drivingLicenseType) {
		this.drivingLicenseType = drivingLicenseType;
	}

	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}

	public String getDrivingLicenseIssueState() {
		return drivingLicenseIssueState;
	}

	public void setDrivingLicenseIssueState(String drivingLicenseIssueState) {
		this.drivingLicenseIssueState = drivingLicenseIssueState;
	}

	public int getNoOfAtFaults() {
		return noOfAtFaults;
	}

	public void setNoOfAtFaults(int noOfAtFaults) {
		this.noOfAtFaults = noOfAtFaults;
	}

	public String getOtherIssues() {
		return otherIssues;
	}

	public void setOtherIssues(String otherIssues) {
		this.otherIssues = otherIssues;
	}

	public String getCurInsProv() {
		return curInsProv;
	}

	public void setCurInsProv(String curInsProv) {
		this.curInsProv = curInsProv;
	}

	public double getPrefExcessAmount() {
		return prefExcessAmount;
	}

	public void setPrefExcessAmount(double prefExcessAmount) {
		this.prefExcessAmount = prefExcessAmount;
	}

	public String getCarParkedAt() {
		return carParkedAt;
	}

	public void setCarParkedAt(String carParkedAt) {
		this.carParkedAt = carParkedAt;
	}

	public String getCarUsedfor() {
		return carUsedfor;
	}

	public void setCarUsedfor(String carUsedfor) {
		this.carUsedfor = carUsedfor;
	}

	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	public String getDriverFirstName() {
		return driverFirstName;
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	public String getDriverLastName() {
		return driverLastName;
	}

	public void setDriverLastName(String driverLastName) {
		this.driverLastName = driverLastName;
	}

	public String getDriverMobileNo() {
		return driverMobileNo;
	}

	public void setDriverMobileNo(String driverMobileNo) {
		this.driverMobileNo = driverMobileNo;
	}

	public String getDriverEmailId() {
		return driverEmailId;
	}

	public void setDriverEmailId(String driverEmailId) {
		this.driverEmailId = driverEmailId;
	}

	public Date getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Date licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public Date getLastAtFaultClaimDate() {
		return lastAtFaultClaimDate;
	}

	public void setLastAtFaultClaimDate(Date lastAtFaultClaimDate) {
		this.lastAtFaultClaimDate = lastAtFaultClaimDate;
	}

	public String getReasonForSuspension() {
		return reasonForSuspension;
	}

	public void setReasonForSuspension(String reasonForSuspension) {
		this.reasonForSuspension = reasonForSuspension;
	}

	public int getAvgNoOfKmYr() {
		return avgNoOfKmYr;
	}

	public void setAvgNoOfKmYr(int avgNoOfKmYr) {
		this.avgNoOfKmYr = avgNoOfKmYr;
	}

	public int getNoOfDrivers() {
		return noOfDrivers;
	}

	public void setNoOfDrivers(int noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}

	public boolean isLicenseGotSuspened() {
		return licenseGotSuspened;
	}

	public void setLicenseGotSuspened(boolean licenseGotSuspened) {
		this.licenseGotSuspened = licenseGotSuspened;
	}

	public boolean isExtNudgeBar() {
		return extNudgeBar;
	}

	public void setExtNudgeBar(boolean extNudgeBar) {
		this.extNudgeBar = extNudgeBar;
	}

	public boolean isExtBullBar() {
		return extBullBar;
	}

	public void setExtBullBar(boolean extBullBar) {
		this.extBullBar = extBullBar;
	}

	public boolean isExtsnokel() {
		return extsnokel;
	}

	public void setExtsnokel(boolean extsnokel) {
		this.extsnokel = extsnokel;
	}

	public boolean isIntNudgeBar() {
		return intNudgeBar;
	}

	public void setIntNudgeBar(boolean intNudgeBar) {
		this.intNudgeBar = intNudgeBar;
	}

	public boolean isIntBullBar() {
		return intBullBar;
	}

	public void setIntBullBar(boolean intBullBar) {
		this.intBullBar = intBullBar;
	}

	public boolean isIntsnokel() {
		return intsnokel;
	}

	public void setIntsnokel(boolean intsnokel) {
		this.intsnokel = intsnokel;
	}

	public boolean isAnyDriver() {
		return AnyDriver;
	}

	public void setAnyDriver(boolean anyDriver) {
		AnyDriver = anyDriver;
	}

	public boolean isFreeWindScreen() {
		return FreeWindScreen;
	}

	public void setFreeWindScreen(boolean freeWindScreen) {
		FreeWindScreen = freeWindScreen;
	}

	public boolean isRoadsideasst() {
		return Roadsideasst;
	}

	public void setRoadsideasst(boolean roadsideasst) {
		Roadsideasst = roadsideasst;
	}

	public boolean isRentalCar() {
		return RentalCar;
	}

	public void setRentalCar(boolean rentalCar) {
		RentalCar = rentalCar;
	}

	public boolean isNewCarRepl() {
		return NewCarRepl;
	}

	public void setNewCarRepl(boolean newCarRepl) {
		NewCarRepl = newCarRepl;
	}

	public boolean isLifetimeWarrep() {
		return LifetimeWarrep;
	}

	public void setLifetimeWarrep(boolean lifetimeWarrep) {
		LifetimeWarrep = lifetimeWarrep;
	}

	public boolean isHireCar() {
		return HireCar;
	}

	public void setHireCar(boolean hireCar) {
		HireCar = hireCar;
	}

	public boolean isBullBar() {
		return BullBar;
	}

	public void setBullBar(boolean bullBar) {
		BullBar = bullBar;
	}

	public boolean isSnokel() {
		return Snokel;
	}

	public void setSnokel(boolean snokel) {
		Snokel = snokel;
	}

	public boolean isNudgeBar() {
		return NudgeBar;
	}

	public void setNudgeBar(boolean nudgeBar) {
		NudgeBar = nudgeBar;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getDealState() {
		return dealState;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTollFree() {
		return tollFree;
	}

	public void setTollFree(String tollFree) {
		this.tollFree = tollFree;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAfterHours() {
		return afterHours;
	}

	public void setAfterHours(String afterHours) {
		this.afterHours = afterHours;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setState(String sState) {
		this.state = sState;
	}
	
	public boolean isNewer() {
		return newer;
	}

	public void setNewer(boolean newer) {
		this.newer = newer;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	// User Creation Date
	private Date userCreationDate;
	
	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long extdealerId) {
		this.dealerId = extdealerId;
	}
	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}
	

	
	public String getExtraExter2() {
		return extraExter2;
	}

	public void setExtraExter2(String extraExter2) {
		this.extraExter2 = extraExter2;
	}

	public String getExtraExter3() {
		return extraExter3;
	}

	public void setExtraExter3(String extraExter3) {
		this.extraExter3 = extraExter3;
	}

	public String getExtraExter4() {
		return extraExter4;
	}

	public void setExtraExter4(String extraExter4) {
		this.extraExter4 = extraExter4;
	}

	public String getExtraExter5() {
		return extraExter5;
	}

	public void setExtraExter5(String extraExter5) {
		this.extraExter5 = extraExter5;
	}

	public String getExtraIntern1() {
		return extraIntern1;
	}

	public void setExtraIntern1(String extraIntern1) {
		this.extraIntern1 = extraIntern1;
	}

	public String getExtraIntern2() {
		return extraIntern2;
	}

	public void setExtraIntern2(String extraIntern2) {
		this.extraIntern2 = extraIntern2;
	}

	public String getExtraIntern3() {
		return extraIntern3;
	}

	public void setExtraIntern3(String extraIntern3) {
		this.extraIntern3 = extraIntern3;
	}

	public String getExtraIntern4() {
		return extraIntern4;
	}

	public void setExtraIntern4(String extraIntern4) {
		this.extraIntern4 = extraIntern4;
	}

	public String getExtraIntern5() {
		return extraIntern5;
	}

	public void setExtraIntern5(String extraIntern5) {
		this.extraIntern5 = extraIntern5;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public int getYearEmploymentBusiness() {
		return yearEmploymentBusiness;
	}

	public void setYearEmploymentBusiness(int yearEmploymentBusiness) {
		this.yearEmploymentBusiness = yearEmploymentBusiness;
	}

	public String getIncomeBeforeSuperTax() {
		return incomeBeforeSuperTax;
	}

	public void setIncomeBeforeSuperTax(String incomeBeforeSuperTax) {
		this.incomeBeforeSuperTax = incomeBeforeSuperTax;
	}

	public String getIncomeAfterSuperTax() {
		return incomeAfterSuperTax;
	}

	public void setIncomeAfterSuperTax(String incomeAfterSuperTax) {
		this.incomeAfterSuperTax = incomeAfterSuperTax;
	}

	public String getIfBusinessProvideABN() {
		return ifBusinessProvideABN;
	}

	public void setIfBusinessProvideABN(String ifBusinessProvideABN) {
		this.ifBusinessProvideABN = ifBusinessProvideABN;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public int getNoOfDependence() {
		return noOfDependence;
	}

	public void setNoOfDependence(int noOfDependence) {
		this.noOfDependence = noOfDependence;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getDrivingLicenceType() {
		return drivingLicenceType;
	}

	public void setDrivingLicenceType(String drivingLicenceType) {
		this.drivingLicenceType = drivingLicenceType;
	}

	public int getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}

	public void setDrivingLicenceNumber(int drivingLicenceNumber) {
		this.drivingLicenceNumber = drivingLicenceNumber;
	}

	public String getDrivingLicenceIssuingState() {
		return drivingLicenceIssuingState;
	}

	public void setDrivingLicenceIssuingState(String drivingLicenceIssuingState) {
		this.drivingLicenceIssuingState = drivingLicenceIssuingState;
	}

	public int getNoOfAtFaultClaims() {
		return noOfAtFaultClaims;
	}

	public void setNoOfAtFaultClaims(int noOfAtFaultClaims) {
		this.noOfAtFaultClaims = noOfAtFaultClaims;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getIndicativeExcessAmount() {
		return indicativeExcessAmount;
	}

	public void setIndicativeExcessAmount(double indicativeExcessAmount) {
		this.indicativeExcessAmount = indicativeExcessAmount;
	}

	public Date getAgeOfAdditionalDriver() {
		return ageOfAdditionalDriver;
	}

	public void setAgeOfAdditionalDriver(Date ageOfAdditionalDriver) {
		this.ageOfAdditionalDriver = ageOfAdditionalDriver;
	}

	public Long getExtDealerSearchId() {
		return this.extDealerSearchId;
	}

	public void setExtDealerSearchId(Long dealerSearchId) {
		this.extDealerSearchId = dealerSearchId;
	}

	// carQuery

	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getModelDisplay() {
		return modelDisplay;
	}

	public void setModelDisplay(String modelDisplay) {
		this.modelDisplay = modelDisplay;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelTrim() {
		return modelTrim;
	}

	public void setModelTrim(String modelTrim) {
		this.modelTrim = modelTrim;
	}

	private boolean finance;
	private boolean insurance;
	private boolean dealer;

	// MARUTHI, AUDI
	private String sMake;
	// NANO, INDICA
	private String sModel;
	// hash tag
	private String sBodyType;
	// kolor
	private String carColor;
	// victoria
	private String sState;
	// melbourne
	private String sRegion;
	// 7899
	private int sPostCode;

	private Date sYearOfMake;

	// finance

	private double finAmountMin;
	private double finAmountMax;

	// insurance
	private boolean support247;
	private boolean raodSideAssitance;
	private boolean guaranteeReplacement;
	private boolean hiringCar;
	private boolean comprehensiveCover;
	private boolean thirdPartyCover;

	public boolean isFinance() {
		return finance;
	}

	public void setFinance(boolean finance) {
		this.finance = finance;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	private String sAusCapTer;
	private String sPcode;

	public String getsBodyType() {
		return sBodyType;
	}

	public void setsBodyType(String sBodyType) {
		this.sBodyType = sBodyType;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String sCarColor) {
		this.carColor = sCarColor;
	}

	public String getsState() {
		return sState;
	}

	public void setsState(String sState) {
		this.sState = sState;
	}

	public String getsRegion() {
		return sRegion;
	}

	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}

	public int getsPostCode() {
		return sPostCode;
	}

	public void setsPostCode(int sPostCode) {
		this.sPostCode = sPostCode;
	}

	public Date getsYearOfMake() {
		return sYearOfMake;
	}

	public void setsYearOfMake(Date sYearOfMake) {
		this.sYearOfMake = sYearOfMake;
	}

	public double getFinAmountMin() {
		return finAmountMin;
	}

	public void setFinAmountMin(double finAmountMin) {
		this.finAmountMin = finAmountMin;
	}

	public double getFinAmountMax() {
		return finAmountMax;
	}

	public void setFinAmountMax(double finAmountMax) {
		this.finAmountMax = finAmountMax;
	}

	public boolean isSupport247() {
		return support247;
	}

	public void setSupport247(boolean support247) {
		this.support247 = support247;
	}

	public boolean isRaodSideAssitance() {
		return raodSideAssitance;
	}

	public void setRaodSideAssitance(boolean raodSideAssitance) {
		this.raodSideAssitance = raodSideAssitance;
	}

	public boolean isGuaranteeReplacement() {
		return guaranteeReplacement;
	}

	public void setGuaranteeReplacement(boolean guaranteeReplacement) {
		this.guaranteeReplacement = guaranteeReplacement;
	}

	public boolean isHiringCar() {
		return hiringCar;
	}

	public void setHiringCar(boolean hiringCar) {
		this.hiringCar = hiringCar;
	}

	public boolean isComprehensiveCover() {
		return comprehensiveCover;
	}

	public void setComprehensiveCover(boolean comprehensiveCover) {
		this.comprehensiveCover = comprehensiveCover;
	}

	public boolean isThirdPartyCover() {
		return thirdPartyCover;
	}

	public void setThirdPartyCover(boolean thirdPartyCover) {
		this.thirdPartyCover = thirdPartyCover;
	}

	public String getsMake() {
		return sMake;
	}

	public void setsMake(String sMake) {
		this.sMake = sMake;
	}

	public String getsModel() {
		return sModel;
	}

	public void setsModel(String sModel) {
		this.sModel = sModel;
	}

	public String getsAusCapTer() {
		return sAusCapTer;
	}

	public void setsAusCapTer(String sAusCapTer) {
		this.sAusCapTer = sAusCapTer;
	}

	public String getsPcode() {
		return sPcode;
	}

	public void setsPcode(String sPcode) {
		this.sPcode = sPcode;
	}

	
}
