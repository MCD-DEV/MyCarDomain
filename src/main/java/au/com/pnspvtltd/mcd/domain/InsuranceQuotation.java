package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CARMODEL
 * 
 */
@Entity
@Table(name = "insurance_quoation")
public class InsuranceQuotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */
	// Unique Quotation id
	private Long insQuotId;
	// dealer id
	private Long dealerId;
	// user id
	private Long userId;
	// dealer insurance lead id
	private Long dealSearchId;
	// user insurance lead id
	private Long carSearchId;
	// inventory repo id
	private Long refId;
	private boolean interested;
	private boolean testDrive;
	private boolean autoBid;
	private boolean moveToUser;
	private String quotaStatus;
	
	public String getQuotaStatus() {
		return quotaStatus;
	}


	public void setQuotaStatus(String quotaStatus) {
		this.quotaStatus = quotaStatus;
	}
	
	public boolean isInterested() {
		return interested;
	}

	public void setInterested(boolean interested) {
		this.interested = interested;
	}

	public boolean isTestDrive() {
		return testDrive;
	}

	public void setTestDrive(boolean testDrive) {
		this.testDrive = testDrive;
	}

	public boolean isAutoBid() {
		return autoBid;
	}

	public void setAutoBid(boolean autoBid) {
		this.autoBid = autoBid;
	}

	public boolean isMoveToUser() {
		return moveToUser;
	}

	public void setMoveToUser(boolean moveToUser) {
		this.moveToUser = moveToUser;
	}

	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;

	private String dealerName;
	private String dealerABN;
	private String quotHeaderFreeText;
	private boolean isNew;
	private String vinNumber;
	private String regoNo;
	private Date regoEndDate;
	private String regoStat;
	private int dealerStockNo;
	private int noOfKms;
	private double driveAwayPrice;
	private boolean negotiable;
	private Date offerValidDate;
	private boolean firstCumServe;
	private String color;
	private String transmission;
	private String driveType;
	private String fuelType;
	private int noOfSeats;
	private int noOfDoors;
	private boolean delPrefLocation;
	private String freeText;
	private double offerPrice2;
	private double offerPrice3;
	private String adhoc1;
	private String adhoc2;
	private String adhoc3;
	private String adhoc4;

	List<VehQuotExtrasIns> vehQuotExtras;
	List<UserQuotaDocsIns> userQuotaDocs;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "insQuotId")
	
	public List<UserQuotaDocsIns> getUserQuotaDocs() {
		return userQuotaDocs;
	}


	public void setUserQuotaDocs(
			List<UserQuotaDocsIns> userQuotaDocs) {
		this.userQuotaDocs = userQuotaDocs;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "insQuotId")
	
	public List<VehQuotExtrasIns> getVehQuotExtras() {
		return vehQuotExtras;
	}


	public void setVehQuotExtras(
			List<VehQuotExtrasIns> vehQuotExtras) {
		this.vehQuotExtras = vehQuotExtras;
	}
	
	List<UserQuotaReqTestDriveIns> userQuotaReqTestDrive;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "insQuotId")
	
	public List<UserQuotaReqTestDriveIns> getUserQuotaReqTestDrive() {
		return userQuotaReqTestDrive;
	}


	public void setUserQuotaReqTestDrive(
			List<UserQuotaReqTestDriveIns> userQuotaReqTestDrive) {
		this.userQuotaReqTestDrive = userQuotaReqTestDrive;
	}
	
	
	List<UserQuotationHistoryIns> userQuotationHistory;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "insQuotId")
	
	public List<UserQuotationHistoryIns> getUserQuotationHistory() {
		return userQuotationHistory;
	}


	public void setUserQuotationHistory(
			List<UserQuotationHistoryIns> userQuotationHistory) {
		this.userQuotationHistory = userQuotationHistory;
	}
	
	// Start of search Insurance
	
		private boolean isNewer;
		private boolean isUsed;
		//private Long searchInsuranceId;
		private String postCode;
		private String insuranceType;
		private String regNo;
		private String regoState;
		private int year;
		
		private String make;
		private String model;
		private String variant;
		private String autoscoopTrim;
		private double marketValue;
		private double agreedValue;
		private boolean finance;
		private String financeProvider;
		private String drivingLicenseType;
		private String drivingLicenseNo;
		private String drivingLicenseIssueState;
		private int noOfAtFaults;
		private String otherIssues;
		private String curInsProv;
		private double prefExcessAmount;
		private Date dateOfBirth;
		private Date ageOfAdditionalDriver;
		
		private String carParkedAt;
		private String streetNO;
		private String streetName;
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
	
	// start of External Dealer info
		// Dealer info Start
			private String category;
			private String companyName;
			private String street;
			private String suburb;
			private String dealState;
			private int dealPostCode;
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
		// end of External Dealer info
	
	
			
	public Long getDealSearchId() {
		return dealSearchId;
	}

	public boolean isNewer() {
		return isNewer;
	}

	public void setNewer(boolean isNewer) {
		this.isNewer = isNewer;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getRegoState() {
		return regoState;
	}

	public void setRegoState(String regoState) {
		this.regoState = regoState;
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

	public boolean isFinance() {
		return finance;
	}

	public void setFinance(boolean finance) {
		this.finance = finance;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getAgeOfAdditionalDriver() {
		return ageOfAdditionalDriver;
	}

	public void setAgeOfAdditionalDriver(Date ageOfAdditionalDriver) {
		this.ageOfAdditionalDriver = ageOfAdditionalDriver;
	}

	public String getCarParkedAt() {
		return carParkedAt;
	}

	public void setCarParkedAt(String carParkedAt) {
		this.carParkedAt = carParkedAt;
	}

	public String getStreetNO() {
		return streetNO;
	}

	public void setStreetNO(String streetNO) {
		this.streetNO = streetNO;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public int getDealPostCode() {
		return dealPostCode;
	}

	public void setDealPostCode(int dealPostCode) {
		this.dealPostCode = dealPostCode;
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

	public void setDealSearchId(Long dealSearchId) {
		this.dealSearchId = dealSearchId;
	}

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerABN() {
		return dealerABN;
	}

	public void setDealerABN(String dealerABN) {
		this.dealerABN = dealerABN;
	}

	public String getQuotHeaderFreeText() {
		return quotHeaderFreeText;
	}

	public void setQuotHeaderFreeText(String quotHeaderFreeText) {
		this.quotHeaderFreeText = quotHeaderFreeText;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getRegoNo() {
		return regoNo;
	}

	public void setRegoNo(String regoNo) {
		this.regoNo = regoNo;
	}

	public Date getRegoEndDate() {
		return regoEndDate;
	}

	public void setRegoEndDate(Date regoEndDate) {
		this.regoEndDate = regoEndDate;
	}

	public String getRegoStat() {
		return regoStat;
	}

	public void setRegoStat(String regoStat) {
		this.regoStat = regoStat;
	}

	public int getDealerStockNo() {
		return dealerStockNo;
	}

	public void setDealerStockNo(int dealerStockNo) {
		this.dealerStockNo = dealerStockNo;
	}

	public int getNoOfKms() {
		return noOfKms;
	}

	public void setNoOfKms(int noOfKms) {
		this.noOfKms = noOfKms;
	}

	public double getDriveAwayPrice() {
		return driveAwayPrice;
	}

	public void setDriveAwayPrice(double driveAwayPrice) {
		this.driveAwayPrice = driveAwayPrice;
	}

	public boolean isNegotiable() {
		return negotiable;
	}

	public void setNegotiable(boolean negotiable) {
		this.negotiable = negotiable;
	}

	public Date getOfferValidDate() {
		return offerValidDate;
	}

	public void setOfferValidDate(Date offerValidDate) {
		this.offerValidDate = offerValidDate;
	}

	public boolean isFirstCumServe() {
		return firstCumServe;
	}

	public void setFirstCumServe(boolean firstCumServe) {
		this.firstCumServe = firstCumServe;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public boolean isDelPrefLocation() {
		return delPrefLocation;
	}

	public void setDelPrefLocation(boolean delPrefLocation) {
		this.delPrefLocation = delPrefLocation;
	}

	public String getFreeText() {
		return freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	public double getOfferPrice2() {
		return offerPrice2;
	}

	public void setOfferPrice2(double offerPrice2) {
		this.offerPrice2 = offerPrice2;
	}

	public double getOfferPrice3() {
		return offerPrice3;
	}

	public void setOfferPrice3(double offerPrice3) {
		this.offerPrice3 = offerPrice3;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getAdhoc1() {
		return adhoc1;
	}

	public void setAdhoc1(String adhoc1) {
		this.adhoc1 = adhoc1;
	}

	public String getAdhoc2() {
		return adhoc2;
	}

	public void setAdhoc2(String adhoc2) {
		this.adhoc2 = adhoc2;
	}

	public String getAdhoc3() {
		return adhoc3;
	}

	public void setAdhoc3(String adhoc3) {
		this.adhoc3 = adhoc3;
	}

	public String getAdhoc4() {
		return adhoc4;
	}

	public void setAdhoc4(String adhoc4) {
		this.adhoc4 = adhoc4;
	}

	public String getFlex1() {
		return flex1;
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

	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;

	public InsuranceQuotation() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSQUOTID")
	public Long getInsQuotId() {
		return this.insQuotId;
	}

	public void setInsQuotId(Long quotId) {
		this.insQuotId = quotId;
	}

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

}
