package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "dealsearchservmaint")
public class DealerSearchServMaint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long dealerSearchServMaintId;
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

	
	
	
	private Long idp;
	private Long userId;
	private Long searchServMaintId;
	private Long dealerId;
	private Date creationDate;

	private boolean status;
	private Dealer dealer;

	
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
	
	public String getDealState() {
		return dealState;
	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
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


	
	@ManyToOne
	@JoinColumn(name = "DEALERID")
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public int getDealPostCode() {
		return dealPostCode;
	}

	public void setDealPostCode(int postCode) {
		this.dealPostCode = postCode;
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

	// User Creation Date
	private Date userCreationDate;

	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long carSearchId) {
		this.searchServMaintId = carSearchId;
	}

	@Column(name = "USERID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALSEARCHSERVMAINTID")
	public Long getDealerSearchServMaintId() {
		return dealerSearchServMaintId;
	}

	public void setDealerSearchServMaintId(Long dealerSearchServMaintId) {
		this.dealerSearchServMaintId = dealerSearchServMaintId;
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
