package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;




public class UserOnlyVO {

	private Long userId;
	private String password;
	private String abnNumber;
	private String firstName;
	private String lastName;
	private String email;
	private int mobile;
	private int landLine;
	private String streetNumber;
	private String streetName;
	private String areaName;
	private String subOrb;
	private String state;
	private int postCode;
	private String drivingLicense;
	private String issueState;
	private boolean facebook;
	private boolean payDeposit;
	private boolean refer;
	private boolean welstatus;
	private boolean credStat;
	private boolean idCheck;
	private boolean mobCheck;
	private boolean loyalityFlag;
	
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

	public boolean isWelstatus() {
		return welstatus;
	}

	public void setWelstatus(boolean welstatus) {
		this.welstatus = welstatus;
	}

	public boolean isLoyalityFlag() {
		return loyalityFlag;
	}

	public void setLoyalityFlag(boolean loyalityFlag) {
		this.loyalityFlag = loyalityFlag;
	}
	public boolean isRefer() {
		return refer;
	}

	public void setRefer(boolean refer) {
		this.refer = refer;
	}
	List<SearchVO> search;
	List<SearchInsuranceVO> searchInsurance;
	List<SearchFinanceVO> searchFinance;
	List<SearchServMaintVO> searchServMaint;
	List<SearchTranspVO> searchTransp;
	List<MyVehicleVO> myVehicle;
	List<CurrentOffersVO> currentOffers;
	List<UserNotificationVO> userNotification;
	
	List<UserReferPointsVO> userReferPoints;
	List<ReferencedPointsVO> referencedPoints;
	List<BlogPointsVO> blogPoints;
	List<ReviewPointsVO> reviewPoints;
	List<ValTransPointsVO> valTransPoints;
	
	private int searchCount;
	private int searchInsCount;
	private int searchFinCount;
	private int searchServCount;
	private int searchTranspCount;
	
	private int vehicleQuotCt;
	private int insuranceQuotCt;
	private int financeQuotCt;
	private int servMaintQuotCt;
	private int transpServQuotCt;
	
	public int getVehicleQuotCt() {
		return vehicleQuotCt;
	}

	public void setVehicleQuotCt(int vehicleQuotCt) {
		this.vehicleQuotCt = vehicleQuotCt;
	}

	public int getInsuranceQuotCt() {
		return insuranceQuotCt;
	}

	public void setInsuranceQuotCt(int insuranceQuotCt) {
		this.insuranceQuotCt = insuranceQuotCt;
	}

	public int getFinanceQuotCt() {
		return financeQuotCt;
	}

	public void setFinanceQuotCt(int financeQuotCt) {
		this.financeQuotCt = financeQuotCt;
	}

	public int getServMaintQuotCt() {
		return servMaintQuotCt;
	}

	public void setServMaintQuotCt(int servMaintQuotCt) {
		this.servMaintQuotCt = servMaintQuotCt;
	}

	public int getTranspServQuotCt() {
		return transpServQuotCt;
	}

	public void setTranspServQuotCt(int transpServQuotCt) {
		this.transpServQuotCt = transpServQuotCt;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public int getSearchInsCount() {
		return searchInsCount;
	}

	public void setSearchInsCount(int searchInsCount) {
		this.searchInsCount = searchInsCount;
	}

	public int getSearchFinCount() {
		return searchFinCount;
	}

	public void setSearchFinCount(int searchFinCount) {
		this.searchFinCount = searchFinCount;
	}

	public int getSearchServCount() {
		return searchServCount;
	}

	public void setSearchServCount(int searchServCount) {
		this.searchServCount = searchServCount;
	}

	public int getSearchTranspCount() {
		return searchTranspCount;
	}

	public void setSearchTranspCount(int searchTranspCount) {
		this.searchTranspCount = searchTranspCount;
	}
	
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private Date creationDate;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private Date dateOfBirth;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public List<UserReferPointsVO> getUserReferPoints() {
		return userReferPoints;
	}

	public void setUserReferPoints(List<UserReferPointsVO> userReferPoints) {
		this.userReferPoints = userReferPoints;
	}

	public List<ReferencedPointsVO> getReferencedPoints() {
		return referencedPoints;
	}

	public void setReferencedPoints(List<ReferencedPointsVO> referencedPoints) {
		this.referencedPoints = referencedPoints;
	}

	public List<BlogPointsVO> getBlogPoints() {
		return blogPoints;
	}

	public void setBlogPoints(List<BlogPointsVO> blogPoints) {
		this.blogPoints = blogPoints;
	}

	public List<ReviewPointsVO> getReviewPoints() {
		return reviewPoints;
	}

	public void setReviewPoints(List<ReviewPointsVO> reviewPoints) {
		this.reviewPoints = reviewPoints;
	}

	public List<ValTransPointsVO> getValTransPoints() {
		return valTransPoints;
	}

	public void setValTransPoints(List<ValTransPointsVO> valTransPoints) {
		this.valTransPoints = valTransPoints;
	}

	

	public List<CurrentOffersVO> getCurrentOffers() {
		return currentOffers;
	}

	public void setCurrentOffers(List<CurrentOffersVO> currentOffers) {
		this.currentOffers = currentOffers;
	}

	
	public List<UserNotificationVO> getUserNotification() {
		return userNotification;
	}

	public void setUserNotification(List<UserNotificationVO> userNotification) {
		this.userNotification = userNotification;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<MyVehicleVO> getMyVehicle() {
		return myVehicle;
	}

	public void setMyVehicle(List<MyVehicleVO> myVehicle) {
		this.myVehicle = myVehicle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbnNumber() {
		return abnNumber;
	}

	public void setAbnNumber(String abnNumber) {
		this.abnNumber = abnNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
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
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getSubOrb() {
		return subOrb;
	}

	public void setSubOrb(String subOrb) {
		this.subOrb = subOrb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getIssueState() {
		return issueState;
	}

	public void setIssueState(String issueState) {
		this.issueState = issueState;
	}

	public boolean isFacebook() {
		return facebook;
	}

	public void setFacebook(boolean facebook) {
		this.facebook = facebook;
	}

	public boolean isPayDeposit() {
		return payDeposit;
	}

	public void setPayDeposit(boolean payDeposit) {
		this.payDeposit = payDeposit;
	}

	public List<SearchVO> getSearch() {
		return search;
	}

	public void setSearch(List<SearchVO> search) {
		this.search = search;
	}

	public List<SearchInsuranceVO> getSearchInsurance() {
		return searchInsurance;
	}

	public void setSearchInsurance(List<SearchInsuranceVO> searchInsurance) {
		this.searchInsurance = searchInsurance;
	}

	public List<SearchFinanceVO> getSearchFinance() {
		return searchFinance;
	}

	public void setSearchFinance(List<SearchFinanceVO> searchFinance) {
		this.searchFinance = searchFinance;
	}

	public List<SearchServMaintVO> getSearchServMaint() {
		return searchServMaint;
	}

	public void setSearchServMaint(List<SearchServMaintVO> searchServMaint) {
		this.searchServMaint = searchServMaint;
	}

	public List<SearchTranspVO> getSearchTransp() {
		return searchTransp;
	}

	public void setSearchTransp(List<SearchTranspVO> searchTransp) {
		this.searchTransp = searchTransp;
	}

	

}
