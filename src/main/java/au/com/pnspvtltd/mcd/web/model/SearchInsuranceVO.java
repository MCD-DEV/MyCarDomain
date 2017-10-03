package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import au.com.pnspvtltd.mcd.domain.SearchInsAdditionalDriv;

public class SearchInsuranceVO {

	//private boolean isNew;
	private boolean isNewer;
	private boolean isUsed;
	private Long searchInsuranceId;
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
	
	private Date creationDate;
private long idp;
	
/*private int mobile;
private int landLine;*/
private String abnNumber;
private String email;
private String drivingLicense;
private boolean credStat;
private boolean idCheck;
private boolean mobCheck;
	
	
	public String getAbnNumber() {
	return abnNumber;
}

public void setAbnNumber(String abnNumber) {
	this.abnNumber = abnNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

	/*public int getMobile() {
	return mobile;
}

public void setMobile(int mobile) {
	this.mobile = mobile;
}

public int getLandLine() {
	return landLine;
}

public void setLandLine(int landLine) {
	this.landLine = landLine;
}*/

public String getDrivingLicense() {
	return drivingLicense;
}

public void setDrivingLicense(String drivingLicense) {
	this.drivingLicense = drivingLicense;
}

public boolean isCredStat() {
	return credStat;
}

public void setCredStat(boolean credStat) {
	this.credStat = credStat;
}

public boolean isIdCheck() {
	return idCheck;
}

public void setIdCheck(boolean idCheck) {
	this.idCheck = idCheck;
}

public boolean isMobCheck() {
	return mobCheck;
}

public void setMobCheck(boolean mobCheck) {
	this.mobCheck = mobCheck;
}

	public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

List<SearchInsAdditionalDriv> searchInsAdditionalDriv;
	
	
	public List<SearchInsAdditionalDriv> getSearchInsAdditionalDriv() {
		return searchInsAdditionalDriv;
	}


	public void setSearchInsAdditionalDriv(
			List<SearchInsAdditionalDriv> searchInsAdditionalDriv) {
		this.searchInsAdditionalDriv = searchInsAdditionalDriv;
	}
	
	public String getAutoscoopTrim() {
		return autoscoopTrim;
	}

	public void setAutoscoopTrim(String autoscoopTrim) {
		this.autoscoopTrim = autoscoopTrim;
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

	/*public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}*/

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

	public Long getSearchInsuranceId() {
		return searchInsuranceId;
	}

	public void setSearchInsuranceId(Long searchInsuranceId) {
		this.searchInsuranceId = searchInsuranceId;
	}

}
