package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import au.com.pnspvtltd.mcd.enums.LeadInitiatedBy;

@Entity
@Table(name = "searchrepo")
public class Search implements Serializable {

	private Long carSearchId;
	//private boolean isNew;
	private boolean isNewer;
	private boolean isUsed;
	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;
	private boolean finance;
	private boolean insurance;
	private boolean dealer;
	private Long userid;
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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	private Date creationDate;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	// FLEX1
	private String sModel;
	@Column(name = "ISUSED")
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	@Column(name = "ISNEWER")
	public boolean isNewer() {
		return isNewer;
	}

	public void setNewer(boolean isNewer) {
		this.isNewer = isNewer;
	}
	/*@Column(name = "ISNEW")
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}*/
	@Column(name = "SMODEL")
	public String getsModel() {
		return sModel;
	}

	public void setsModel(String sModel) {
		this.sModel = sModel;
	}

	/* Mapping 
	 * "carColor" : $("carColor").val(),
																			 "postCode":$('#postCode').val(),
																			"make":$('#seats').val(),
																			"bodyType":$('#driveType').val(),
																			"state":$('#fuelType').val(),
																			"region":$('#freetext').val(),
																			"ausCapTer":$('#vehiclePurpose').val(),
																			"region":$('#transmission').val(),
																			"sMake":$('#extraExternal1').val(),
	 * */
	private String make;
	private String bodyType;
	private String carColor;
	private String state;
	private String region;
	private int postCode;
	private double finAmountMin;
	private double finAmountMax;
	private boolean support247;
	private boolean roadSideAssistance;
	private boolean guaranteeReplacement;
	private boolean hiringCar;
	private boolean comprehensiveCover;
	private boolean thirdPartyCover;
	private String ausCapTer;

	
	
	private String extraExter2;
	private String extraExter3;	
	private String extraExter4;	
	private String extraExter5;	
	private String extraExter6;
	public String getExtraExter6() {
		return extraExter6;
	}

	public void setExtraExter6(String extraExter6) {
		this.extraExter6 = extraExter6;
	}

	public String getExtraIntern6() {
		return extraIntern6;
	}

	public void setExtraIntern6(String extraIntern6) {
		this.extraIntern6 = extraIntern6;
	}

	public String getExtraIntern7() {
		return extraIntern7;
	}

	public void setExtraIntern7(String extraIntern7) {
		this.extraIntern7 = extraIntern7;
	}

	public String getExtraIntern8() {
		return extraIntern8;
	}

	public void setExtraIntern8(String extraIntern8) {
		this.extraIntern8 = extraIntern8;
	}

	public String getExtraIntern9() {
		return extraIntern9;
	}

	public void setExtraIntern9(String extraIntern9) {
		this.extraIntern9 = extraIntern9;
	}

	public String getExtraIntern10() {
		return extraIntern10;
	}

	public void setExtraIntern10(String extraIntern10) {
		this.extraIntern10 = extraIntern10;
	}

	public String getExtraIntern11() {
		return extraIntern11;
	}

	public void setExtraIntern11(String extraIntern11) {
		this.extraIntern11 = extraIntern11;
	}

	private String extraIntern1;	
	private String extraIntern2;	
	private String extraIntern3;	
	private String extraIntern4;	
	private String extraIntern5;
	private String extraIntern6;	
	private String extraIntern7;	
	private String extraIntern8;	
	private String extraIntern9;	
	private String extraIntern10;
	private String extraIntern11;
	private LeadInitiatedBy leadInitiatedBy;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARSEARCHID")
	public Long getCarSearchId() {
		return this.carSearchId;
	}

	public void setCarSearchId(Long carMakeId) {
		this.carSearchId = carMakeId;
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

	@Column(name = "BODYTYPE")
	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String sBodyType) {
		this.bodyType = sBodyType;
	}

	@Column(name = "CARCOLOR")
	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String sCarColor) {
		this.carColor = sCarColor;
	}

	@Column(name = "SSTATE")
	public String getState() {
		return state;
	}

	public void setState(String sState) {
		this.state = sState;
	}

	@Column(name = "SREGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String sRegion) {
		this.region = sRegion;
	}

	@Column(name = "SPOSTCODE")
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int sPostCode) {
		this.postCode = sPostCode;
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
	public boolean isRoadSideAssistance() {
		return roadSideAssistance;
	}

	public void setRoadSideAssistance(boolean raodSideAssitance) {
		this.roadSideAssistance = raodSideAssitance;
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
	public String getMake() {
		return make;
	}

	public void setMake(String sMake) {
		this.make = sMake;
	}

	@Column(name = "SAUSCAPTER")
	public String getAusCapTer() {
		return ausCapTer;
	}

	public void setAusCapTer(String sAusCapTer) {
		this.ausCapTer = sAusCapTer;
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

	@Enumerated(EnumType.STRING)
	public LeadInitiatedBy getLeadInitiatedBy() {
		return leadInitiatedBy;
	}

	public void setLeadInitiatedBy(LeadInitiatedBy leadInitiatedBy) {
		this.leadInitiatedBy = leadInitiatedBy;
	}
	
	
	
}
