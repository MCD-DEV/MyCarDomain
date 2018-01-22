package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dealersearchrepo")
public class DealerSearch implements Serializable {

	private static final long serialVersionUID = 2795828321233759004L;

	private Long dealerSearchId;
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
	private Date ageOfAdditionalDriver;// Lead Creation Date
	private Long userId;
	private Long carSearchId;
	private boolean status;
	
	private Dealer dealer1;


	@ManyToOne
	@JoinColumn(name = "DEALERID")
	public Dealer getDealer1() {
		return dealer1;
	}

	public void setDealer1(Dealer dealer1) {
		this.dealer1 = dealer1;
	}
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	@Column(name = "USERID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public DealerSearch() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALSEARCHID")
	public Long getDealerSearchId() {
		return this.dealerSearchId;
	}

	public void setDealerSearchId(Long dealerSearchId) {
		this.dealerSearchId = dealerSearchId;
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
	private String sCarColor;
	// victoria
	private String sState;
	// melbourne
	private String sRegion;
	// 7899
	private int sPostCode;

	private Date sYearOfMake;

	private boolean newer;
	private boolean used;

	public boolean isFinApproved() {
		return finApproved;
	}

	public void setFinApproved(boolean finApproved) {
		this.finApproved = finApproved;
	}

	private String carColor2;
	private boolean finApproved;
	// finance

	public String getCarColor2() {
		return carColor2;
	}

	public void setCarColor2(String carColor2) {
		this.carColor2 = carColor2;
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

	private double finAmountMin;
	private double finAmountMax;

	// insurance
	private boolean support247;
	private boolean raodSideAssitance;
	private boolean guaranteeReplacement;
	private boolean hiringCar;
	private boolean comprehensiveCover;
	private boolean thirdPartyCover;

	@Column(name = "ISFINANCE")
	public boolean isFinance() {
		return finance;
	}

	public void setFinance(boolean finance) {
		this.finance = finance;
	}

	@Column(name = "ISINSURANCE")
	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	@Column(name = "ISDEALER")
	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	private String sAusCapTer;
	private String sPcode;

	@Column(name = "BODYTYPE")
	public String getsBodyType() {
		return sBodyType;
	}

	public void setsBodyType(String sBodyType) {
		this.sBodyType = sBodyType;
	}

	@Column(name = "CARCOLOR")
	public String getsCarColor() {
		return sCarColor;
	}

	public void setsCarColor(String sCarColor) {
		this.sCarColor = sCarColor;
	}

	@Column(name = "SSTATE")
	public String getsState() {
		return sState;
	}

	public void setsState(String sState) {
		this.sState = sState;
	}

	@Column(name = "SREGION")
	public String getsRegion() {
		return sRegion;
	}

	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}

	@Column(name = "SPOSTCODE")
	public int getsPostCode() {
		return sPostCode;
	}

	public void setsPostCode(int sPostCode) {
		this.sPostCode = sPostCode;
	}

	@Column(name = "YEAROFMAKE")
	public Date getsYearOfMake() {
		return sYearOfMake;
	}

	public void setsYearOfMake(Date sYearOfMake) {
		this.sYearOfMake = sYearOfMake;
	}

	@Column(name = "FINAMOUNTMIN")
	public double getFinAmountMin() {
		return finAmountMin;
	}

	public void setFinAmountMin(double finAmountMin) {
		this.finAmountMin = finAmountMin;
	}

	@Column(name = "FINAMOUNTMAX")
	public double getFinAmountMax() {
		return finAmountMax;
	}

	public void setFinAmountMax(double finAmountMax) {
		this.finAmountMax = finAmountMax;
	}

	@Column(name = "ISSUPPORT247")
	public boolean isSupport247() {
		return support247;
	}

	public void setSupport247(boolean support247) {
		this.support247 = support247;
	}

	@Column(name = "ISROASIDEASSITANCE")
	public boolean isRaodSideAssitance() {
		return raodSideAssitance;
	}

	public void setRaodSideAssitance(boolean raodSideAssitance) {
		this.raodSideAssitance = raodSideAssitance;
	}

	@Column(name = "ISGUARANTEEREPLACEMENT")
	public boolean isGuaranteeReplacement() {
		return guaranteeReplacement;
	}

	public void setGuaranteeReplacement(boolean guaranteeReplacement) {
		this.guaranteeReplacement = guaranteeReplacement;
	}

	@Column(name = "ISHIRINGCAR")
	public boolean isHiringCar() {
		return hiringCar;
	}

	public void setHiringCar(boolean hiringCar) {
		this.hiringCar = hiringCar;
	}

	@Column(name = "ISCOMPREHENSIVECOVER")
	public boolean isComprehensiveCover() {
		return comprehensiveCover;
	}

	public void setComprehensiveCover(boolean comprehensiveCover) {
		this.comprehensiveCover = comprehensiveCover;
	}

	@Column(name = "ISTHIRDPARTYCOVER")
	public boolean isThirdPartyCover() {
		return thirdPartyCover;
	}

	public void setThirdPartyCover(boolean thirdPartyCover) {
		this.thirdPartyCover = thirdPartyCover;
	}

	@Column(name = "SMAKE")
	public String getsMake() {
		return sMake;
	}

	public void setsMake(String sMake) {
		this.sMake = sMake;
	}

	@Column(name = "SMODEL")
	public String getsModel() {
		return sModel;
	}

	public void setsModel(String sModel) {
		this.sModel = sModel;
	}

	@Column(name = "SAUSCAPTER")
	public String getsAusCapTer() {
		return sAusCapTer;
	}

	public void setsAusCapTer(String sAusCapTer) {
		this.sAusCapTer = sAusCapTer;
	}

	@Column(name = "SPCODE")
	public String getsPcode() {
		return sPcode;
	}

	public void setsPcode(String sPcode) {
		this.sPcode = sPcode;
	}

}
