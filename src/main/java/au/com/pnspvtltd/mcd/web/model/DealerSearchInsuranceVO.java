package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class DealerSearchInsuranceVO {
	// private boolean isNew;
	private boolean isNewer;
	private boolean isUsed;
	private Long dealerSearchInsuranceId;
	private String postCode;
	private String insuranceType;
	private String regNo;
	private String regoState;
	private int year;

	private String make;
	private String model;
	private String variant;
	private String autoscoopTrim;

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

	public String getAutoscoopTrim() {
		return autoscoopTrim;
	}

	public void setAutoscoopTrim(String autoscoopTrim) {
		this.autoscoopTrim = autoscoopTrim;
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
	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/*
	 * public boolean isNew() { return isNew; }
	 * 
	 * public void setNew(boolean isNew) { this.isNew = isNew; }
	 */

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

	public Long getDealerSearchInsuranceId() {
		return dealerSearchInsuranceId;
	}

	public void setDealerSearchInsuranceId(Long dealerSearchInsuranceId) {
		this.dealerSearchInsuranceId = dealerSearchInsuranceId;
	}

}
