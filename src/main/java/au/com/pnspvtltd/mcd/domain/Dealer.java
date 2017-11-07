package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
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
import au.com.pnspvtltd.mcd.domain.*;
@Entity
@Table(name = "inventorydealer")
public class Dealer implements Serializable {

	private Long dealerId;
	private String password;
	private String email;
	
	private String vehicleType;
	private String licenceNumber;
	private String dealerGroupName;
	private String designation;
	private String additionalInfo;
	private String subscription;
	private String subscriptionType;
	private boolean new1;
	private boolean used;
	
	private boolean isAdmin;
	private boolean isDealer;
	private boolean isInsurer;
	private boolean isFinancer;
	private String ABNNumber;
	private String dealername;
	private String ACNNumber;
	private String website;
	private int delmobile;
	private int landLine1;
	private int landLine2;
	private String streetNumber;
	private String streetName;
	private String areaName;
	private String suborb;
	private String state;
	private int postcode;
	
	public boolean isNew1() {
		return new1;
	}

	public void setNew1(boolean new1) {
		this.new1 = new1;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	List<Inventory> inventory;

	List<DealerSearch> dealSearch;
	List<DealerSearchInsurance> dealSearchInsurance;
	List<DealerSearchFinance> dealSearchFinance;
	List<DealerSearchServMaint> dealSearchServMaint;
	List<DealerSearchTransp> dealSearchTransp;

	List<VehicleDealerDetails> vehicleDealerDetails;
	List<VehicleDealerFinanceDetails> vehicleDealerFinanceDetails;
	List<VehicleDealerInsuranceDetails> vehicleDealerInsuranceDetails;
	List<VehicleDealerServMaintDetails> vehicleDealerServMaintDetails;
	List<VehicleDealerTranspDetails> vehicleDealerTranspDetails;
	List<VehicleDealerMakeList> vehicleDealerMakeList;
	List<VehicleDealerAreaOfOperState> vehicleDealerAreaOfOperState;
	List<VehicleDealerAreaOfOperRegion> vehicleDealerRegion;
	List<VehicleDealerAreaOfOperPostCode> vehicleDealerPostCode;
	List<FinanceEntity> financeEntity;
	List<VehicleResourceDetails> vehicleResourcDetails;
	
	// start
	private int leaadSellCount;
	private int leaadLeaseCount;
	private int leaadBuyCount;
	private int leadInsCount;
	private int leadFinCount;
	private int leadServCount;
	private int leadTranspCount;
	
	private boolean isServMaint;
	private boolean isSparesAccess;
	private boolean isVehTransProv;
	private boolean isAreaOfOperartinAllAus;
	private boolean isAreaOfOperartinStates;
	private boolean isAreaOfOperartinPostcodes;
	private boolean isAllMakes;
	
	
	
	public int getLeadInsCount() {
		return leadInsCount;
	}

	public void setLeadInsCount(int leadInsCount) {
		this.leadInsCount = leadInsCount;
	}

	public int getLeadFinCount() {
		return leadFinCount;
	}

	public void setLeadFinCount(int leadFinCount) {
		this.leadFinCount = leadFinCount;
	}

	public int getLeadServCount() {
		return leadServCount;
	}

	public void setLeadServCount(int leadServCount) {
		this.leadServCount = leadServCount;
	}

	public int getLeadTranspCount() {
		return leadTranspCount;
	}

	public void setLeadTranspCount(int leadTranspCount) {
		this.leadTranspCount = leadTranspCount;
	}

	public int getLeaadSellCount() {
		return leaadSellCount;
	}

	public void setLeaadSellCount(int leaadSellCount) {
		this.leaadSellCount = leaadSellCount;
	}

	public int getLeaadLeaseCount() {
		return leaadLeaseCount;
	}

	public void setLeaadLeaseCount(int leaadLeaseCount) {
		this.leaadLeaseCount = leaadLeaseCount;
	}

	public int getLeaadBuyCount() {
		return leaadBuyCount;
	}

	public void setLeaadBuyCount(int leaadBuyCount) {
		this.leaadBuyCount = leaadBuyCount;
	}

	

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getDealerGroupName() {
		return dealerGroupName;
	}

	public void setDealerGroupName(String dealerGroupName) {
		this.dealerGroupName = dealerGroupName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<FinanceEntity> getFinanceEntity() {
		return financeEntity;
	}

	public void setFinanceEntity(
			List<FinanceEntity> financeEntity) {
		this.financeEntity = financeEntity;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerDetails> getVehicleDealerDetails() {
		return vehicleDealerDetails;
	}

	public void setVehicleDealerDetails(
			List<VehicleDealerDetails> vehicleDealerDetails) {
		this.vehicleDealerDetails = vehicleDealerDetails;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleResourceDetails> getVehicleResourceDetails() {
		return vehicleResourcDetails;
	}

	public void setVehicleResourceDetails(
			List<VehicleResourceDetails> vehicleResourcDetails) {
		this.vehicleResourcDetails = vehicleResourcDetails;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerFinanceDetails> getVehicleDealerFinanceDetails() {
		return vehicleDealerFinanceDetails;
	}

	public void setVehicleDealerFinanceDetails(
			List<VehicleDealerFinanceDetails> vehicleDealerFinanceDetails) {
		this.vehicleDealerFinanceDetails = vehicleDealerFinanceDetails;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerTranspDetails> getVehicleDealerTranspDetails() {
		return vehicleDealerTranspDetails;
	}

	public void setVehicleDealerTranspDetails(
			List<VehicleDealerTranspDetails> vehicleDealerTranspDetails) {
		this.vehicleDealerTranspDetails = vehicleDealerTranspDetails;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerInsuranceDetails> getVehicleDealerInsuranceDetails() {
		return vehicleDealerInsuranceDetails;
	}

	public void setVehicleDealerInsuranceDetails(
			List<VehicleDealerInsuranceDetails> vehicleDealerInsuranceDetails) {
		this.vehicleDealerInsuranceDetails = vehicleDealerInsuranceDetails;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerServMaintDetails> getVehicleDealerServMaintDetails() {
		return vehicleDealerServMaintDetails;
	}

	public void setVehicleDealerServMaintDetails(
			List<VehicleDealerServMaintDetails> vehicleDealerServMaintDetails) {
		this.vehicleDealerServMaintDetails = vehicleDealerServMaintDetails;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerMakeList> getVehicleDealerMakeList() {
		return vehicleDealerMakeList;
	}

	public void setVehicleDealerMakeList(
			List<VehicleDealerMakeList> vehicleDealerMakeList) {
		this.vehicleDealerMakeList = vehicleDealerMakeList;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerAreaOfOperState> getVehicleDealerAreaOfOperState() {
		return vehicleDealerAreaOfOperState;
	}

	public void setVehicleDealerAreaOfOperState(
			List<VehicleDealerAreaOfOperState> vehicleDealerAreaOfOperState) {
		this.vehicleDealerAreaOfOperState = vehicleDealerAreaOfOperState;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerAreaOfOperRegion> getVehicleDealerRegion() {
		return vehicleDealerRegion;
	}

	public void setVehicleDealerRegion(
			List<VehicleDealerAreaOfOperRegion> vehicleDealerRegion) {
		this.vehicleDealerRegion = vehicleDealerRegion;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<VehicleDealerAreaOfOperPostCode> getVehicleDealerPostCode() {
		return vehicleDealerPostCode;
	}

	public void setVehicleDealerPostCode(
			List<VehicleDealerAreaOfOperPostCode> vehicleDealerPostCode) {
		this.vehicleDealerPostCode = vehicleDealerPostCode;
	}

	@Column(name = "ISSERVMAINT") public boolean isServMaint() {
		return isServMaint;
	}

	public void setServMaint(boolean isServMaint) {
		this.isServMaint = isServMaint;
	}

	@Column(name = "ISSPARESACCESS") public boolean isSparesAccess() {
		return isSparesAccess;
	}

	public void setSparesAccess(boolean isSparesAccess) {
		this.isSparesAccess = isSparesAccess;
	}

	@Column(name = "ISVEHTRANSPROV") public boolean isVehTransProv() {
		return isVehTransProv;
	}

	public void setVehTransProv(boolean isVehTransProv) {
		this.isVehTransProv = isVehTransProv;
	}

	@Column(name = "ISAREAOFOPERALLAUS") public boolean isAreaOfOperartinAllAus() {
		return isAreaOfOperartinAllAus;
	}

	public void setAreaOfOperartinAllAus(boolean isAreaOfOperartinAllAus) {
		this.isAreaOfOperartinAllAus = isAreaOfOperartinAllAus;
	}

	@Column(name = "ISAREAOFOPERINSTATES") public boolean isAreaOfOperartinStates() {
		return isAreaOfOperartinStates;
	}

	public void setAreaOfOperartinStates(boolean isAreaOfOperartinStates) {
		this.isAreaOfOperartinStates = isAreaOfOperartinStates;
	}

	@Column(name = "ISAREAOFOPERPOSTCODE") public boolean isAreaOfOperartinPostcodes() {
		return isAreaOfOperartinPostcodes;
	}

	public void setAreaOfOperartinPostcodes(boolean isAreaOfOperartinPostcodes) {
		this.isAreaOfOperartinPostcodes = isAreaOfOperartinPostcodes;
	}

	@Column(name = "ISALLMAKES")public boolean isAllMakes() {
		return isAllMakes;
	}

	public void setAllMakes(boolean isAllMakes) {
		this.isAllMakes = isAllMakes;
	}

	@Column(name = "ISMAKELIST") public boolean isMakeList() {
		return isMakeList;
	}

	public void setMakeList(boolean isMakeList) {
		this.isMakeList = isMakeList;
	}

	@Column(name = "LICENSENO") public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Column(name = "DEALGROUP") public String getDealGroup() {
		return dealGroup;
	}

	public void setDealGroup(String dealGroup) {
		this.dealGroup = dealGroup;
	}

	private boolean isMakeList;
	private String licenseNo;
	private String dealGroup;
	
	
	
	
	
	
	public @Column(name = "ISADMIN") boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALERID")
	public Long getDealerId() {
		return this.dealerId;
	}

	public void setDealerId(Long carId) {
		this.dealerId = carId;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<DealerSearch> getDealSearch() {
		return dealSearch;
	}

	public void setDealSearch(List<DealerSearch> search) {
		this.dealSearch = search;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<DealerSearchFinance> getDealSearchFinance() {
		return dealSearchFinance;
	}

	public void setDealSearchFinance(List<DealerSearchFinance> search) {
		this.dealSearchFinance = search;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<DealerSearchInsurance> getDealSearchInsurance() {
		return dealSearchInsurance;
	}

	public void setDealSearchInsurance(List<DealerSearchInsurance> search) {
		this.dealSearchInsurance = search;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<DealerSearchServMaint> getDealSearchServMaint() {
		return dealSearchServMaint;
	}

	public void setDealSearchServMaint(List<DealerSearchServMaint> search) {
		this.dealSearchServMaint = search;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public List<DealerSearchTransp> getDealSearchTransp() {
		return dealSearchTransp;
	}

	public void setDealSearchTransp(List<DealerSearchTransp> search) {
		this.dealSearchTransp = search;
	}
	
	
	@Column(name = "ISDEALER")
	public boolean isDealer() {
		return isDealer;
	}

	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}

	@Column(name = "ISINSURER")
	public boolean isInsurer() {
		return isInsurer;
	}

	public void setInsurer(boolean isInsurer) {
		this.isInsurer = isInsurer;
	}

	@Column(name = "ISFINANCER")
	public boolean isFinancer() {
		return isFinancer;
	}

	public void setFinancer(boolean isFinancer) {
		this.isFinancer = isFinancer;
	}

	@Column(name = "ABNNUMBER")
	public String getABNNumber() {
		return ABNNumber;
	}

	public void setABNNumber(String aBNNumber) {
		ABNNumber = aBNNumber;
	}

	@Column(name = "DEALERNAME")
	public String getDealername() {
		return dealername;
	}

	public void setDealername(String dealername) {
		this.dealername = dealername;
	}

	@Column(name = "ACNNUMBER")
	public String getACNNumber() {
		return ACNNumber;
	}

	public void setACNNumber(String aCNNumber) {
		ACNNumber = aCNNumber;
	}

	@Column(name = "WEBSITE")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "DELMOBILE")
	public int getDelmobile() {
		return delmobile;
	}

	public void setDelmobile(int delmobile) {
		this.delmobile = delmobile;
	}

	@Column(name = "LANDLINE1")
	public int getLandLine1() {
		return landLine1;
	}

	public void setLandLine1(int landLine1) {
		this.landLine1 = landLine1;
	}

	@Column(name = "LANDLINE2")
	public int getLandLine2() {
		return landLine2;
	}

	public void setLandLine2(int landLine2) {
		this.landLine2 = landLine2;
	}

	@Column(name = "STREETNUMBER")
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Column(name = "STREETNAME")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Column(name = "AREANAME")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "SUBORB")
	public String getSuborb() {
		return suborb;
	}

	public void setSuborb(String suborb) {
		this.suborb = suborb;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "POSTCODE")
	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

}
