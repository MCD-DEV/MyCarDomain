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

@Entity
@Table(name = "userrepo")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String gender;
	private Date creationDate;

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

	public boolean isRefer() {
		return refer;
	}

	public void setRefer(boolean refer) {
		this.refer = refer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	List<Search> search;
	List<SearchInsurance> searchInsurance;
	List<SearchFinance> searchFinance;
	List<SearchServMaint> searchServMaint;
	List<SearchTransp> searchTransp;
	List<MyVehicle> myVehicle;
	List<UserNotification> userNotification;

	List<UserReferPoints> userReferPoints;
	List<ReferencedPoints> referencedPoints;
	List<BlogPoints> blogPoints;
	List<ReviewPoints> reviewPoints;
	List<ValTransPoints> valTransPoints;

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

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<UserReferPoints> getUserReferPoints() {
		return userReferPoints;
	}

	public void setUserReferPoints(List<UserReferPoints> userReferPoints) {
		this.userReferPoints = userReferPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<ReferencedPoints> getReferencedPoints() {
		return referencedPoints;
	}

	public void setReferencedPoints(List<ReferencedPoints> referencedPoints) {
		this.referencedPoints = referencedPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<BlogPoints> getBlogPoints() {
		return blogPoints;
	}

	public void setBlogPoints(List<BlogPoints> blogPoints) {
		this.blogPoints = blogPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<ReviewPoints> getReviewPoints() {
		return reviewPoints;
	}

	public void setReviewPoints(List<ReviewPoints> reviewPoints) {
		this.reviewPoints = reviewPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<ValTransPoints> getValTransPoints() {
		return valTransPoints;
	}

	public void setValTransPoints(List<ValTransPoints> valTransPoints) {
		this.valTransPoints = valTransPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<UserNotification> getUserNotification() {
		return userNotification;
	}

	public void setUserNotification(List<UserNotification> userNotification) {
		this.userNotification = userNotification;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<MyVehicle> getMyVehicle() {
		return myVehicle;
	}

	public void setMyVehicle(List<MyVehicle> myVehicle) {
		this.myVehicle = myVehicle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ABNNUMBER")
	public String getAbnNumber() {
		return abnNumber;
	}

	public void setAbnNumber(String abnNumber) {
		this.abnNumber = abnNumber;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	@Column(name = "LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "UMOBILE")
	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Column(name = "ULANDLINE")
	public int getLandLine() {
		return landLine;
	}

	public void setLandLine(int landLine) {
		this.landLine = landLine;
	}

	@Column(name = "USTREETNUMBER")
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Column(name = "USTREETNAME")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Column(name = "UAREANAME")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "USUBORB")
	public String getSubOrb() {
		return subOrb;
	}

	public void setSubOrb(String subOrb) {
		this.subOrb = subOrb;
	}

	@Column(name = "USTATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "UPOSTCODE")
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Column(name = "DRIINGLICENSE")
	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	@Column(name = "ISSUESTATE")
	public String getIssueState() {
		return issueState;
	}

	public void setIssueState(String issueState) {
		this.issueState = issueState;
	}

	@Column(name = "ISFACEBOOK")
	public boolean isFacebook() {
		return facebook;
	}

	public void setFacebook(boolean facebook) {
		this.facebook = facebook;
	}

	@Column(name = "ISPAYDEPOSIT")
	public boolean isPayDeposit() {
		return payDeposit;
	}

	public void setPayDeposit(boolean payDeposit) {
		this.payDeposit = payDeposit;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<Search> getSearch() {
		return search;
	}

	public void setSearch(List<Search> search) {
		this.search = search;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<SearchInsurance> getSearchInsurance() {
		return searchInsurance;
	}

	public void setSearchInsurance(List<SearchInsurance> search) {
		this.searchInsurance = search;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<SearchFinance> getSearchFinance() {
		return searchFinance;
	}

	public void setSearchFinance(List<SearchFinance> search) {
		this.searchFinance = search;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<SearchServMaint> getSearchServMaint() {
		return searchServMaint;
	}

	public void setSearchServMaint(List<SearchServMaint> search) {
		this.searchServMaint = search;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	public List<SearchTransp> getSearchTransp() {
		return searchTransp;
	}

	public void setSearchTransp(List<SearchTransp> search) {
		this.searchTransp = search;
	}

}
