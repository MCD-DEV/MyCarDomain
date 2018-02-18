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

/**
 * Entity implementation class for Entity: FinanceCompany
 * 
 */
@Entity
@Table(name = "externalDealerTp")
public class ExternalDealerTp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long externalDealerId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "externalDealerId")
	public Long getExternalDealerId() {
		return externalDealerId;
	}

	public void setExternalDealerId(Long externalDealerId) {
		this.externalDealerId = externalDealerId;
	}

	private String category;
	private String companyName;
	private String street;
	private String suburb;
	private String state;
	private int postCode;
	private String country;
	private String phone;
	private String website;
	private String mobile;
	private String tollFree;
	private String fax;
	private String afterHours;
	private String postalAddress;
	private String abnNumber;
	private String contactPerson;
	private String transportFrom;
	private String transportTo;
	private String email;
	private float longitude;
	private float latitude;
	private Date creationDate;

	//

	public String getAbnNumber() {
		return abnNumber;
	}

	public void setAbnNumber(String abnNumber) {
		this.abnNumber = abnNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getTransportFrom() {
		return transportFrom;
	}

	public void setTransportFrom(String transportFrom) {
		this.transportFrom = transportFrom;
	}

	public String getTransportTo() {
		return transportTo;
	}

	public void setTransportTo(String transportTo) {
		this.transportTo = transportTo;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	List<ExtDealerSearchTp> extDealSearch;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "externalDealerId")
	public List<ExtDealerSearchTp> getExtDealSearch() {
		return extDealSearch;
	}

	public void setExtDealSearch(List<ExtDealerSearchTp> extDealSearch) {
		this.extDealSearch = extDealSearch;
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

}
