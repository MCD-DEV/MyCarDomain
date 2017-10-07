package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleDealerTranspDetails;

public class DealerVO {

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
	private boolean new1;
	private boolean used;
	
	
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

	List<InventoryVO> inventory;
	List<DealerSearchVO> dealSearch;
	List<DealerSearchInsuranceVO> dealSearchInsurance;
	List<DealerSearchFinanceVO> dealSearchFinance;
	List<DealerSearchServMaintVO> dealSearchServMaint;
	List<DealerSearchTranspVO> dealSearchTransp;
	
	
	List<VehicleDealerDetailsVO> vehicleDealerDetails;
	List<VehicleDealerFinanceDetailsVO> vehicleDealerFinanceDetails;
	List<VehicleDealerInsuranceDetailsVO> vehicleDealerInsuranceDetails;
	List<VehicleDealerServMaintDetailsVO> vehicleDealerServMaintDetails;
	List<VehicleDealerTranspDetailsVO> vehicleDealerTranspDetails;
	List<VehicleDealerMakeListhVO> vehicleDealerMakeList;
	List<VehicleDealerAreaOfOperStateVO> vehicleDealerAreaOfOperState;
	List<VehicleDealerAreaOfOperRegionVO> vehicleDealerRegion;
	List<VehicleDealerAreaOfOperPostCodeVO> vehicleDealerPostCode;
	
	// start
	
	
	private boolean isServMaint;
	private boolean isSparesAccess;
	private boolean isVehTransProv;
	private boolean isAreaOfOperartinAllAus;
	private boolean isAreaOfOperartinStates;
	private boolean isAreaOfOperartinPostcodes;
	private boolean isAllMakes;
	
	public List<VehicleDealerTranspDetailsVO> getVehicleDealerTranspDetails() {
		return vehicleDealerTranspDetails;
	}

	public void setVehicleDealerTranspDetails(List<VehicleDealerTranspDetailsVO> vehicleDealerTranspDetails) {
		this.vehicleDealerTranspDetails = vehicleDealerTranspDetails;
	}

	public List<VehicleDealerDetailsVO> getVehicleDealerDetails() {
		return vehicleDealerDetails;
	}

	public void setVehicleDealerDetails(
			List<VehicleDealerDetailsVO> vehicleDealerDetails) {
		this.vehicleDealerDetails = vehicleDealerDetails;
	}
	
	public List<VehicleDealerFinanceDetailsVO> getVehicleDealerFinanceDetails() {
		return vehicleDealerFinanceDetails;
	}

	public void setVehicleDealerFinanceDetails(
			List<VehicleDealerFinanceDetailsVO> vehicleDealerFinanceDetails) {
		this.vehicleDealerFinanceDetails = vehicleDealerFinanceDetails;
	}
	
	public List<VehicleDealerInsuranceDetailsVO> getVehicleDealerInsuranceDetails() {
		return vehicleDealerInsuranceDetails;
	}

	public void setVehicleDealerInsuranceDetails(
			List<VehicleDealerInsuranceDetailsVO> vehicleDealerInsuranceDetails) {
		this.vehicleDealerInsuranceDetails = vehicleDealerInsuranceDetails;
	}
	
	public List<VehicleDealerServMaintDetailsVO> getVehicleDealerServMaintDetails() {
		return vehicleDealerServMaintDetails;
	}

	public void setVehicleDealerServMaintDetails(
			List<VehicleDealerServMaintDetailsVO> vehicleDealerServMaintDetails) {
		this.vehicleDealerServMaintDetails = vehicleDealerServMaintDetails;
	}
	
	public List<VehicleDealerMakeListhVO> getVehicleDealerMakeList() {
		return vehicleDealerMakeList;
	}

	public void setVehicleDealerMakeList(
			List<VehicleDealerMakeListhVO> vehicleDealerMakeList) {
		this.vehicleDealerMakeList = vehicleDealerMakeList;
	}
	
	public List<VehicleDealerAreaOfOperStateVO> getVehicleDealerAreaOfOperState() {
		return vehicleDealerAreaOfOperState;
	}

	public void setVehicleDealerAreaOfOperState(
			List<VehicleDealerAreaOfOperStateVO> vehicleDealerAreaOfOperState) {
		this.vehicleDealerAreaOfOperState = vehicleDealerAreaOfOperState;
	}
	
	public List<VehicleDealerAreaOfOperRegionVO> getVehicleDealerRegion() {
		return vehicleDealerRegion;
	}

	public void setVehicleDealerRegion(
			List<VehicleDealerAreaOfOperRegionVO> vehicleDealerRegion) {
		this.vehicleDealerRegion = vehicleDealerRegion;
	}
	
	public List<VehicleDealerAreaOfOperPostCodeVO> getVehicleDealerPostCode() {
		return vehicleDealerPostCode;
	}

	public void setVehicleDealerPostCode(
			List<VehicleDealerAreaOfOperPostCodeVO> vehicleDealerPostCode) {
		this.vehicleDealerPostCode = vehicleDealerPostCode;
	}

	public boolean isServMaint() {
		return isServMaint;
	}

	public void setServMaint(boolean isServMaint) {
		this.isServMaint = isServMaint;
	}

	public boolean isSparesAccess() {
		return isSparesAccess;
	}

	public void setSparesAccess(boolean isSparesAccess) {
		this.isSparesAccess = isSparesAccess;
	}

	public boolean isVehTransProv() {
		return isVehTransProv;
	}

	public void setVehTransProv(boolean isVehTransProv) {
		this.isVehTransProv = isVehTransProv;
	}

	public boolean isAreaOfOperartinAllAus() {
		return isAreaOfOperartinAllAus;
	}

	public void setAreaOfOperartinAllAus(boolean isAreaOfOperartinAllAus) {
		this.isAreaOfOperartinAllAus = isAreaOfOperartinAllAus;
	}

	public boolean isAreaOfOperartinStates() {
		return isAreaOfOperartinStates;
	}

	public void setAreaOfOperartinStates(boolean isAreaOfOperartinStates) {
		this.isAreaOfOperartinStates = isAreaOfOperartinStates;
	}

	public boolean isAreaOfOperartinPostcodes() {
		return isAreaOfOperartinPostcodes;
	}

	public void setAreaOfOperartinPostcodes(boolean isAreaOfOperartinPostcodes) {
		this.isAreaOfOperartinPostcodes = isAreaOfOperartinPostcodes;
	}

	public boolean isAllMakes() {
		return isAllMakes;
	}

	public void setAllMakes(boolean isAllMakes) {
		this.isAllMakes = isAllMakes;
	}

	public boolean isMakeList() {
		return isMakeList;
	}

	public void setMakeList(boolean isMakeList) {
		this.isMakeList = isMakeList;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getDealGroup() {
		return dealGroup;
	}

	public void setDealGroup(String dealGroup) {
		this.dealGroup = dealGroup;
	}

	private boolean isMakeList;
	private String licenseNo;
	private String dealGroup;
	
	
	

	List<VehicleQuotationVO> vehicleQuotation;
	List<InsuranceQuotationVO> insuranceQuotation;
	List<FinanceQuotationVO> financeQuotation;
	
	
	

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isDealer() {
		return isDealer;
	}

	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}

	public boolean isInsurer() {
		return isInsurer;
	}

	public void setInsurer(boolean isInsurer) {
		this.isInsurer = isInsurer;
	}

	public boolean isFinancer() {
		return isFinancer;
	}

	public void setFinancer(boolean isFinancer) {
		this.isFinancer = isFinancer;
	}

	public String getABNNumber() {
		return ABNNumber;
	}

	public void setABNNumber(String aBNNumber) {
		ABNNumber = aBNNumber;
	}

	public String getDealername() {
		return dealername;
	}

	public void setDealername(String dealername) {
		this.dealername = dealername;
	}

	public String getACNNumber() {
		return ACNNumber;
	}

	public void setACNNumber(String aCNNumber) {
		ACNNumber = aCNNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getDelmobile() {
		return delmobile;
	}

	public void setDelmobile(int delmobile) {
		this.delmobile = delmobile;
	}

	public int getLandLine1() {
		return landLine1;
	}

	public void setLandLine1(int landLine1) {
		this.landLine1 = landLine1;
	}

	public int getLandLine2() {
		return landLine2;
	}

	public void setLandLine2(int landLine2) {
		this.landLine2 = landLine2;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getSuborb() {
		return suborb;
	}

	public void setSuborb(String suborb) {
		this.suborb = suborb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public List<InventoryVO> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryVO> inventory) {
		this.inventory = inventory;
	}

	public List<DealerSearchVO> getDealSearch() {
		return dealSearch;
	}

	public void setDealSearch(List<DealerSearchVO> dealSearch) {
		this.dealSearch = dealSearch;
	}

	public List<DealerSearchInsuranceVO> getDealSearchInsurance() {
		return dealSearchInsurance;
	}

	public void setDealSearchInsurance(List<DealerSearchInsuranceVO> dealSearchInsurance) {
		this.dealSearchInsurance = dealSearchInsurance;
	}

	public List<DealerSearchFinanceVO> getDealSearchFinance() {
		return dealSearchFinance;
	}

	public void setDealSearchFinance(List<DealerSearchFinanceVO> dealSearchFinance) {
		this.dealSearchFinance = dealSearchFinance;
	}

	public List<DealerSearchServMaintVO> getDealSearchServMaint() {
		return dealSearchServMaint;
	}

	public void setDealSearchServMaint(List<DealerSearchServMaintVO> dealSearchServMaint) {
		this.dealSearchServMaint = dealSearchServMaint;
	}

	public List<DealerSearchTranspVO> getDealSearchTransp() {
		return dealSearchTransp;
	}

	public void setDealSearchTransp(List<DealerSearchTranspVO> dealSearchTransp) {
		this.dealSearchTransp = dealSearchTransp;
	}

	public List<VehicleQuotationVO> getVehicleQuotation() {
		return vehicleQuotation;
	}

	public void setVehicleQuotation(List<VehicleQuotationVO> vehicleQuotation) {
		this.vehicleQuotation = vehicleQuotation;
	}

	public List<InsuranceQuotationVO> getInsuranceQuotation() {
		return insuranceQuotation;
	}

	public void setInsuranceQuotation(List<InsuranceQuotationVO> insuranceQuotation) {
		this.insuranceQuotation = insuranceQuotation;
	}

	public List<FinanceQuotationVO> getFinanceQuotation() {
		return financeQuotation;
	}

	public void setFinanceQuotation(List<FinanceQuotationVO> financeQuotation) {
		this.financeQuotation = financeQuotation;
	}

}
