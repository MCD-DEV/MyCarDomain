package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "searchservmaint")
public class SearchServMaint implements Serializable {

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
	
/*private int mobile;
private int landLine;*/
private String abnNumber;
private String email;
private String drivingLicense;
private boolean credStat;
private boolean idCheck;
private boolean mobCheck;

	
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
	private Date creationDate;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEARCHSERVMAINTID")
	public Long getSearchServMaintId() {
		return searchServMaintId;
	}
	@Column(name = "AUTOSCOOPTRIM")
	public String getAutoscoopTrim() {
		return autoscoopTrim;
	}

	public void setAutoscoopTrim(String autoscoopTrim) {
		this.autoscoopTrim = autoscoopTrim;
	}
	@Column(name = "LOOKSERVICE")
	public String getLookService() {
		return lookService;
	}

	public void setLookService(String lookService) {
		this.lookService = lookService;
	}
	@Column(name = "CURFINPROV")
	public String getCurFinProv() {
		return curFinProv;
	}

	public void setCurFinProv(String curFinProv) {
		this.curFinProv = curFinProv;
	}
	@Column(name = "COVEREDUNDERFIN")
	public boolean isCoveredUnderFin() {
		return coveredUnderFin;
	}

	public void setCoveredUnderFin(boolean coveredUnderFin) {
		this.coveredUnderFin = coveredUnderFin;
	}
	@Column(name = "PHOTO1")
	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	@Column(name = "PHOTO2")
	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	@Column(name = "PHOTO3")
	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}
	@Column(name = "FUELTYPE")
	public String getFeulType() {
		return feulType;
	}

	public void setFeulType(String feulType) {
		this.feulType = feulType;
	}
	@Column(name = "SERVMAINTL1")
	public String getServMaintL1() {
		return servMaintL1;
	}

	public void setServMaintL1(String servMaintL1) {
		this.servMaintL1 = servMaintL1;
	}
	@Column(name = "SERVMAINTL2")
	public String getServMaintL2() {
		return servMaintL2;
	}

	public void setServMaintL2(String servMaintL2) {
		this.servMaintL2 = servMaintL2;
	}
	@Column(name = "UPLOADPHOTO")
	public String getUploadPhotos() {
		return uploadPhotos;
	}

	public void setUploadPhotos(String uploadPhotos) {
		this.uploadPhotos = uploadPhotos;
	}
	@Column(name = "COVEREDUNDINS")
	public boolean isCoveredUnderIns() {
		return coveredUnderIns;
	}

	public void setCoveredUnderIns(boolean coveredUnderIns) {
		this.coveredUnderIns = coveredUnderIns;
	}
	@Column(name = "FREETEXT")
	public String getFreeText() {
		return freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	@Column(name = "POSTCODE")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	@Column(name = "CURINSPROV")
	public String getCurInsProv() {
		return curInsProv;
	}

	public void setCurInsProv(String curInsProv) {
		this.curInsProv = curInsProv;
	}
		

}
