package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "searchtransp")
public class SearchTransp implements Serializable {

	private Long searchTranspId;
	private String fromPostCodeAddr;
	private String toPostCodeAddr;
	private String transTypeReq;
	private Date pickUpDateTime;
	private int noOfCars;
	private int year;
	private String make;
	private String model;
	private String variant;
	private String freeText;
	private boolean transpInsReq;
	private String howMay;
	private String fromStreetNo;
	private String toStreetName;
	private String toStreetNo;
	private String fromStreetName;
	private String kindOfTransport;
	private boolean flexWithDateDefault;
	private String uploadPhotos;
	private String photo;
	private String regoNo;
	private String regoState;
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
	
	
	List<TranspSearchMakeList> carModel;
	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Column(name = "REGONO")
	public String getRegoNo() {
		return regoNo;
	}

	public void setRegoNo(String regoNo) {
		this.regoNo = regoNo;
	}
	@Column(name = "REGOSTATE")
	public String getRegoState() {
		return regoState;
	}

	public void setRegoState(String regoState) {
		this.regoState = regoState;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })  @JoinColumn(name="searchTranspId") public List<TranspSearchMakeList> getCarModel() {
		return carModel;
	}

	public void setCarModel(List<TranspSearchMakeList> carModel) {
		this.carModel = carModel;
	}
	
	@Column(name = "howMay")
	public String getHowMay() {
		return howMay;
	}

	public void setHowMay(String howMay) {
		this.howMay = howMay;
	}
	@Column(name = "fromStreetNo")
	public String getFromStreetNo() {
		return fromStreetNo;
	}

	public void setFromStreetNo(String fromStreetNo) {
		this.fromStreetNo = fromStreetNo;
	}
	@Column(name = "toStreetName")
	public String getToStreetName() {
		return toStreetName;
	}

	public void setToStreetName(String toStreetName) {
		this.toStreetName = toStreetName;
	}
	@Column(name = "toStreetNo")
	public String getToStreetNo() {
		return toStreetNo;
	}

	public void setToStreetNo(String toStreetNo) {
		this.toStreetNo = toStreetNo;
	}
	@Column(name = "fromStreetName")
	public String getFromStreetName() {
		return fromStreetName;
	}

	public void setFromStreetName(String fromStreetName) {
		this.fromStreetName = fromStreetName;
	}
	@Column(name = "kindOfTransport")
	public String getKindOfTransport() {
		return kindOfTransport;
	}

	public void setKindOfTransport(String kindOfTransport) {
		this.kindOfTransport = kindOfTransport;
	}
	@Column(name = "flexWithDateDefault")
	public boolean isFlexWithDateDefault() {
		return flexWithDateDefault;
	}

	public void setFlexWithDateDefault(boolean flexWithDateDefault) {
		this.flexWithDateDefault = flexWithDateDefault;
	}

	@Column(name = "FROMPOSTADDR")
	public String getFromPostCodeAddr() {
		return fromPostCodeAddr;
	}

	public void setFromPostCodeAddr(String fromPostCodeAddr) {
		this.fromPostCodeAddr = fromPostCodeAddr;
	}
	@Column(name = "TOPOSTADDR")
	public String getToPostCodeAddr() {
		return toPostCodeAddr;
	}

	public void setToPostCodeAddr(String toPostCodeAddr) {
		this.toPostCodeAddr = toPostCodeAddr;
	}
	@Column(name = "TRANSTYPEREQ")
	public String getTransTypeReq() {
		return transTypeReq;
	}

	public void setTransTypeReq(String transTypeReq) {
		this.transTypeReq = transTypeReq;
	}
	@Column(name = "PICKUPDATETIME")
	public Date getPickUpDateTime() {
		return pickUpDateTime;
	}

	public void setPickUpDateTime(Date pickUpDateTime) {
		this.pickUpDateTime = pickUpDateTime;
	}
	@Column(name = "NOOFCARS")
	public int getNoOfCars() {
		return noOfCars;
	}

	public void setNoOfCars(int noOfCars) {
		this.noOfCars = noOfCars;
	}
	@Column(name = "ISTRANSINSREQ")
	public boolean isTranspInsReq() {
		return transpInsReq;
	}

	public void setTranspInsReq(boolean transpInsReq) {
		this.transpInsReq = transpInsReq;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEARCHTRANSPID")
	public Long getSearchTranspId() {
		return searchTranspId;
	}

	public void setSearchTranspId(Long searchTranspId) {
		this.searchTranspId = searchTranspId;
	}
		@Column(name = "UPLOADPHOTO")
	public String getUploadPhotos() {
		return uploadPhotos;
	}

	public void setUploadPhotos(String uploadPhotos) {
		this.uploadPhotos = uploadPhotos;
	}
	@Column(name = "FREETEXT")
	public String getFreeText() {
		return freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
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
			

}
