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
@Table(name = "DEALSEARCHSERVMAINT")
public class Deal_SearchServMaint implements Serializable {

	private Long dealSearchServMaintId;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALSEARCHSERVMAINTID")
	public Long getDealSearchServMaintId() {
		return dealSearchServMaintId;
	}

	public void setDealSearchServMaintId(Long searchServMaintId) {
		this.dealSearchServMaintId = searchServMaintId;
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
