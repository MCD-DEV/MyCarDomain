package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import au.com.pnspvtltd.mcd.domain.VehQuotExtrasFin;

public class FinanceQuotationVO {

	// Unique Quotation id
	private Long finQuotId;
	// dealer id
	private Long dealerId;
	// user id
	private Long userId;
	// dealer search lead id
	private Long dealSearchId;
	// user search lead id
	private Long carSearchId;
	// inventory reference id
	private Long refId;
	private boolean autoBid;
	private boolean moveToUser;

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
	List<VehQuotExtrasFin> vehQuotExtras;
	
	public List<VehQuotExtrasFin> getVehQuotExtras() {
		return vehQuotExtras;
	}


	public void setVehQuotExtras(
			List<VehQuotExtrasFin> vehQuotExtras) {
		this.vehQuotExtras = vehQuotExtras;
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
		// Start from DealerFinance Lead 
		private boolean isNewer;
		private boolean isUsed;
		private String postCode;
		private String autoscoopTrim;
		private double vehValue;
		private double balloonPay;
		private double loanAmount;
		private int loanPeriod;
		private double annualIncome;
		private String incomeType;
		private String creditRating;
		private Date dateOfBirth;
		private int yearEmploymentBusiness;
		private String incomeBeforeSuperTax;
		private String incomeAfterSuperTax;
		private String ifBusinessProvideABN;
		private String rego;
		private String regoState;
		private String streetNo;
		private String streetName;
		private String mr;
		private String firstName;
		private String lastName;
		
		List<UserQuotationHistoryFinVO> userQuotationHistoryVO;
		
		public List<UserQuotationHistoryFinVO> getUserQuotationHistoryVO() {
			return userQuotationHistoryVO;
		}


		public void setUserQuotationHistoryVO(
				List<UserQuotationHistoryFinVO> userQuotationHistoryVO) {
			this.userQuotationHistoryVO = userQuotationHistoryVO;
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

		public double getAnnualIncome() {
			return annualIncome;
		}

		public void setAnnualIncome(double annualIncome) {
			this.annualIncome = annualIncome;
		}

		public String getIncomeType() {
			return incomeType;
		}

		public void setIncomeType(String incomeType) {
			this.incomeType = incomeType;
		}

		public String getCreditRating() {
			return creditRating;
		}

		public void setCreditRating(String creditRating) {
			this.creditRating = creditRating;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
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

	public Long getDealSearchId() {
		return dealSearchId;
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

	public Long getFinQuotId() {
		return this.finQuotId;
	}

	public void setFinQuotId(Long carMakeId) {
		this.finQuotId = carMakeId;
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
