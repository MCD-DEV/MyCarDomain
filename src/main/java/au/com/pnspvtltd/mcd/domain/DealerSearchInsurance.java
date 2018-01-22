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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dealsearchinsurance")
public class DealerSearchInsurance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isNewer;
	private boolean isUsed;
	// private boolean isNew;
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

	private Dealer dealer;

	@ManyToOne
	@JoinColumn(name = "DEALERID")
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	List<DealerSearchInsAdditionalDriv> dealerSearchInsAdditionalDriv;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerSearchInsuranceId")

	public List<DealerSearchInsAdditionalDriv> getDealerSearchInsAdditionalDriv() {
		return dealerSearchInsAdditionalDriv;
	}

	public void setDealerSearchInsAdditionalDriv(List<DealerSearchInsAdditionalDriv> dealerSearchInsAdditionalDriv) {
		this.dealerSearchInsAdditionalDriv = dealerSearchInsAdditionalDriv;
	}

	@Column(name = "USERID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/*
	 * @Column(name = "ISNEW") public boolean isNew() { return isNew; }
	 * 
	 * public void setNew(boolean isNew) { this.isNew = isNew; }
	 */

	@Column(name = "DATEOFBIRTH")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "AGEOFADDITIONALDRIV")
	public Date getAgeOfAdditionalDriver() {
		return ageOfAdditionalDriver;
	}

	public void setAgeOfAdditionalDriver(Date ageOfAdditionalDriver) {
		this.ageOfAdditionalDriver = ageOfAdditionalDriver;
	}

	@Column(name = "POSTCODE")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "INSURANCETYPE")
	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	@Column(name = "REGONO")
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Column(name = "REGOSTATE")
	public String getRegoState() {
		return regoState;
	}

	public void setRegoState(String regoState) {
		this.regoState = regoState;
	}

	@Column(name = "YEAR")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "MAKE")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "VARIANT")
	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	@Column(name = "MARKETVALUE")
	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	@Column(name = "AGREEDVALUE")
	public double getAgreedValue() {
		return agreedValue;
	}

	public void setAgreedValue(double agreedValue) {
		this.agreedValue = agreedValue;
	}

	@Column(name = "ISFINANCE")
	public boolean isFinance() {
		return finance;
	}

	public void setFinance(boolean finance) {
		this.finance = finance;
	}

	@Column(name = "FINANCEPROV")
	public String getFinanceProvider() {
		return financeProvider;
	}

	public void setFinanceProvider(String financeProvider) {
		this.financeProvider = financeProvider;
	}

	@Column(name = "DRIVINGLICENSETYPE")
	public String getDrivingLicenseType() {
		return drivingLicenseType;
	}

	public void setDrivingLicenseType(String drivingLicenseType) {
		this.drivingLicenseType = drivingLicenseType;
	}

	@Column(name = "DRIVINGLICENSENO")
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}

	@Column(name = "DRIVINGLICENSEISSUESTATE")
	public String getDrivingLicenseIssueState() {
		return drivingLicenseIssueState;
	}

	public void setDrivingLicenseIssueState(String drivingLicenseIssueState) {
		this.drivingLicenseIssueState = drivingLicenseIssueState;
	}

	@Column(name = "NOOFFAULTS")
	public int getNoOfAtFaults() {
		return noOfAtFaults;
	}

	public void setNoOfAtFaults(int noOfAtFaults) {
		this.noOfAtFaults = noOfAtFaults;
	}

	@Column(name = "OTHERISSUES")
	public String getOtherIssues() {
		return otherIssues;
	}

	public void setOtherIssues(String otherIssues) {
		this.otherIssues = otherIssues;
	}

	@Column(name = "CURINSPROV")
	public String getCurInsProv() {
		return curInsProv;
	}

	public void setCurInsProv(String curInsProv) {
		this.curInsProv = curInsProv;
	}

	@Column(name = "PREFEXCESSAMT")
	public double getPrefExcessAmount() {
		return prefExcessAmount;
	}

	public void setPrefExcessAmount(double prefExcessAmount) {
		this.prefExcessAmount = prefExcessAmount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALSEARCHINSURANCEID")
	public Long getDealerSearchInsuranceId() {
		return dealerSearchInsuranceId;
	}

	public void setDealerSearchInsuranceId(Long dealerSearchInsuranceId) {
		this.dealerSearchInsuranceId = dealerSearchInsuranceId;
	}

	@Column(name = "ISNEWER")
	public boolean isNewer() {
		return isNewer;
	}

	public void setNewer(boolean isNewer) {
		this.isNewer = isNewer;
	}

	@Column(name = "ISUSED")
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Column(name = "AUTOSCOOPTRIM")
	public String getAutoscoopTrim() {
		return autoscoopTrim;
	}

	public void setAutoscoopTrim(String autoscoopTrim) {
		this.autoscoopTrim = autoscoopTrim;
	}

	@Column(name = "CARPARKEDAT")
	public String getCarParkedAt() {
		return carParkedAt;
	}

	public void setCarParkedAt(String carParkedAt) {
		this.carParkedAt = carParkedAt;
	}

	@Column(name = "STREETNO")
	public String getStreetNO() {
		return streetNO;
	}

	public void setStreetNO(String streetNO) {
		this.streetNO = streetNO;
	}

	@Column(name = "STREETNAME")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Column(name = "CARUSEDFOR")
	public String getCarUsedfor() {
		return carUsedfor;
	}

	public void setCarUsedfor(String carUsedfor) {
		this.carUsedfor = carUsedfor;
	}

	@Column(name = "TYPEOFBUSINESS")
	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	@Column(name = "DRIVERFIRSTNAME")
	public String getDriverFirstName() {
		return driverFirstName;
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	@Column(name = "DRIVERLASTNAME")
	public String getDriverLastName() {
		return driverLastName;
	}

	public void setDriverLastName(String driverLastName) {
		this.driverLastName = driverLastName;
	}

	@Column(name = "DRIVERMOBILENO")
	public String getDriverMobileNo() {
		return driverMobileNo;
	}

	public void setDriverMobileNo(String driverMobileNo) {
		this.driverMobileNo = driverMobileNo;
	}

	@Column(name = "DRIVEREMAILID")
	public String getDriverEmailId() {
		return driverEmailId;
	}

	public void setDriverEmailId(String driverEmailId) {
		this.driverEmailId = driverEmailId;
	}

	@Column(name = "LICENSEISSUEDATE")
	public Date getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Date licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	@Column(name = "LASTATFAULTCLAIMDATE")
	public Date getLastAtFaultClaimDate() {
		return lastAtFaultClaimDate;
	}

	public void setLastAtFaultClaimDate(Date lastAtFaultClaimDate) {
		this.lastAtFaultClaimDate = lastAtFaultClaimDate;
	}

	@Column(name = "REASONFORSUSPEND")
	public String getReasonForSuspension() {
		return reasonForSuspension;
	}

	public void setReasonForSuspension(String reasonForSuspension) {
		this.reasonForSuspension = reasonForSuspension;
	}

	@Column(name = "AVERGNOOFKMYR")
	public int getAvgNoOfKmYr() {
		return avgNoOfKmYr;
	}

	public void setAvgNoOfKmYr(int avgNoOfKmYr) {
		this.avgNoOfKmYr = avgNoOfKmYr;
	}

	@Column(name = "NOOFDRIVERS")
	public int getNoOfDrivers() {
		return noOfDrivers;
	}

	public void setNoOfDrivers(int noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}

	@Column(name = "LICENSEGOTSUSPEND")
	public boolean isLicenseGotSuspened() {
		return licenseGotSuspened;
	}

	public void setLicenseGotSuspened(boolean licenseGotSuspened) {
		this.licenseGotSuspened = licenseGotSuspened;
	}

}
