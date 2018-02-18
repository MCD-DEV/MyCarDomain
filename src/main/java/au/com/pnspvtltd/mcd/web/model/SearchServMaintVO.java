package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class SearchServMaintVO {

	private Long searchServMaintId;
	private String postCode;
	private int year;
	private String regNo;
	private String regoState;
	private String make;
	private String model;
	private String variant;
	private String feulType;
	private String servMaintL1;
	private String servMaintL2;
	private String uploadPhotos;
	private boolean coveredUnderIns;
	private String curInsProv;
	private String freeText;

	private String autoscoopTrim;
	private String lookService;
	private String curFinProv;
	private boolean coveredUnderFin;
	private String photo1;
	private String photo2;
	private String photo3;
	private long idp;

	/*
	 * private int mobile; private int landLine;
	 */
	private String abnNumber;
	private String email;
	private String drivingLicense;
	private boolean credStat;
	private boolean idCheck;
	private boolean mobCheck;

	// New fields
	private Date preferredServDt;
	private boolean doorStep;
	private String address;
	private String landmark;
	private boolean dropNpick;
	private boolean complCar;
	private String contactNum;
	private String contactPerson;

	/*
	 * public int getMobile() { return mobile; }
	 * 
	 * public void setMobile(int mobile) { this.mobile = mobile; }
	 * 
	 * public int getLandLine() { return landLine; }
	 * 
	 * public void setLandLine(int landLine) { this.landLine = landLine; }
	 */

	public Date getPreferredServDt() {
		return preferredServDt;
	}

	public void setPreferredServDt(Date preferredServDt) {
		this.preferredServDt = preferredServDt;
	}

	public boolean isDoorStep() {
		return doorStep;
	}

	public void setDoorStep(boolean doorStep) {
		this.doorStep = doorStep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public boolean isDropNpick() {
		return dropNpick;
	}

	public void setDropNpick(boolean dropNpick) {
		this.dropNpick = dropNpick;
	}

	public boolean isComplCar() {
		return complCar;
	}

	public void setComplCar(boolean complCar) {
		this.complCar = complCar;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

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

	private Date creationDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAutoscoopTrim() {
		return autoscoopTrim;
	}

	public void setAutoscoopTrim(String autoscoopTrim) {
		this.autoscoopTrim = autoscoopTrim;
	}

	public String getLookService() {
		return lookService;
	}

	public void setLookService(String lookService) {
		this.lookService = lookService;
	}

	public String getCurFinProv() {
		return curFinProv;
	}

	public void setCurFinProv(String curFinProv) {
		this.curFinProv = curFinProv;
	}

	public boolean isCoveredUnderFin() {
		return coveredUnderFin;
	}

	public void setCoveredUnderFin(boolean coveredUnderFin) {
		this.coveredUnderFin = coveredUnderFin;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}

	public String getFeulType() {
		return feulType;
	}

	public void setFeulType(String feulType) {
		this.feulType = feulType;
	}

	public String getServMaintL1() {
		return servMaintL1;
	}

	public void setServMaintL1(String servMaintL1) {
		this.servMaintL1 = servMaintL1;
	}

	public String getServMaintL2() {
		return servMaintL2;
	}

	public void setServMaintL2(String servMaintL2) {
		this.servMaintL2 = servMaintL2;
	}

	public String getUploadPhotos() {
		return uploadPhotos;
	}

	public void setUploadPhotos(String uploadPhotos) {
		this.uploadPhotos = uploadPhotos;
	}

	public boolean isCoveredUnderIns() {
		return coveredUnderIns;
	}

	public void setCoveredUnderIns(boolean coveredUnderIns) {
		this.coveredUnderIns = coveredUnderIns;
	}

	public String getFreeText() {
		return freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getCurInsProv() {
		return curInsProv;
	}

	public void setCurInsProv(String curInsProv) {
		this.curInsProv = curInsProv;
	}

}
