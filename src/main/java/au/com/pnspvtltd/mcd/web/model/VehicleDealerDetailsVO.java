package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperState;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperState;
import au.com.pnspvtltd.mcd.domain.VehicleDealerInsDetails;
import au.com.pnspvtltd.mcd.domain.VehicleDealerMakeList;
import au.com.pnspvtltd.mcd.domain.VehicleMakeList;

public class VehicleDealerDetailsVO {


	
	
	private Long vehicleDealerDetailId;
	
	private String vehicleType;
	private String dealerType;
	/*private boolean isNewCar;
	private boolean isUsedCar;*/
	private boolean isBoth;
	private boolean newCar;
	private boolean usedCar;
/*start */
	
	
	// Flex start
	private String flex1;	
	private String flex2;	
	private String flex3;	
	private String flex4;
	private int flex5;	
	private int flex6;	
	private double flex7;	
	private double flex8;
	private double flex9;	
	private double flex10;
	private Date flex11;
	private Date flex12;
	private boolean isFlex13;
	private boolean isFlex14;
		
	
	private String licenceNumber;
	 private String dealerGroupName;
	 private String designation;
	 private String additionalInfo;
	 private String subscription;
	 private String subscriptionType;
	private String ABNNumber;
	 private String dealername;
	 private String website;
	 private String delmobile;
	 private String landLine1;
	 private String contactNumber2;
	 private String streetNumber;
	 private String streetName;
	 private String areaName;
	 private String suborb;
	 private String state;
	 private int postcode;
	
	 // finance and insurance
	 private String afslNo;
		private String authRepNo;
		private String aclNo;
		private String brokerLicenceNo;
		private String contactPerson;
		private String email;
		private Date dob;
		private String lastName;
		private String title;
		private boolean comprehensive;
		private boolean thirdParty;
		private boolean thirdProperty;
		private boolean individual;
		private boolean licensedBroker;
		private boolean insuranceInstitute;
		private boolean loanNewVeh;
		private boolean loanUsedVeh;	
	 // end of finance and insurance
	 
		
		// start of service maint
				private boolean petrol;
				private boolean diesel;
				private boolean electric;
				private boolean all1;
				private boolean clientPlaceDriveYes;
				private boolean clientPlaceDriveMaybe;
				private boolean clientPlaceDriveNo;
				private boolean roadAssistance;
				private boolean servMaintInstitute;
				
				// end of service maint
				
				
				// start of transport
				private String fromState;
				private String toState;
				private String fromRegion;
				private String toRegion;
				private String fromPost;
				private String toPost;
				private String stateRate;
				private String regionRate;
				private String postRate;
				private boolean stateRoute;
				private boolean regionRoute;
				private boolean postRoute;
				
				// end of transport
	 
	 List<VehicleMakeListVO> vehicleDealerMakeList;
	 List<VehicleAreaOfOperStateVO> vehicleDealerAreaOfOperState;
	 List<VehicleAreaOfOperRegionVO> vehicleDealerRegion;
	 List<VehicleAreaOfOperPostCodeVO> vehicleDealerPostCode;
	 List<VehicleDealerInsDetailsVO> vehicleDealerInsDetails;
	
	 
	 
	

	public List<VehicleDealerInsDetailsVO> getVehicleDealerInsDetails() {
		return vehicleDealerInsDetails;
	}

	public void setVehicleDealerInsDetails(List<VehicleDealerInsDetailsVO> vehicleDealerInsDetails) {
		this.vehicleDealerInsDetails = vehicleDealerInsDetails;
	}

	public String getDealerType() {
		return dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}

	public boolean isNewCar() {
		return newCar;
	}

	public void setNewCar(boolean newCar) {
		this.newCar = newCar;
	}

	public boolean isUsedCar() {
		return usedCar;
	}

	public void setUsedCar(boolean usedCar) {
		this.usedCar = usedCar;
	}

	public boolean isPetrol() {
		return petrol;
	}

	public void setPetrol(boolean petrol) {
		this.petrol = petrol;
	}

	public boolean isDiesel() {
		return diesel;
	}

	public void setDiesel(boolean diesel) {
		this.diesel = diesel;
	}

	public boolean isElectric() {
		return electric;
	}

	public void setElectric(boolean electric) {
		this.electric = electric;
	}

	public boolean isAll1() {
		return all1;
	}

	public void setAll1(boolean all1) {
		this.all1 = all1;
	}

	public boolean isClientPlaceDriveYes() {
		return clientPlaceDriveYes;
	}

	public void setClientPlaceDriveYes(boolean clientPlaceDriveYes) {
		this.clientPlaceDriveYes = clientPlaceDriveYes;
	}

	public boolean isClientPlaceDriveMaybe() {
		return clientPlaceDriveMaybe;
	}

	public void setClientPlaceDriveMaybe(boolean clientPlaceDriveMaybe) {
		this.clientPlaceDriveMaybe = clientPlaceDriveMaybe;
	}

	public boolean isClientPlaceDriveNo() {
		return clientPlaceDriveNo;
	}

	public void setClientPlaceDriveNo(boolean clientPlaceDriveNo) {
		this.clientPlaceDriveNo = clientPlaceDriveNo;
	}

	public boolean isRoadAssistance() {
		return roadAssistance;
	}

	public void setRoadAssistance(boolean roadAssistance) {
		this.roadAssistance = roadAssistance;
	}

	public boolean isServMaintInstitute() {
		return servMaintInstitute;
	}

	public void setServMaintInstitute(boolean servMaintInstitute) {
		this.servMaintInstitute = servMaintInstitute;
	}

	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public String getFromRegion() {
		return fromRegion;
	}

	public void setFromRegion(String fromRegion) {
		this.fromRegion = fromRegion;
	}

	public String getToRegion() {
		return toRegion;
	}

	public void setToRegion(String toRegion) {
		this.toRegion = toRegion;
	}

	public String getFromPost() {
		return fromPost;
	}

	public void setFromPost(String fromPost) {
		this.fromPost = fromPost;
	}

	public String getToPost() {
		return toPost;
	}

	public void setToPost(String toPost) {
		this.toPost = toPost;
	}

	public String getStateRate() {
		return stateRate;
	}

	public void setStateRate(String stateRate) {
		this.stateRate = stateRate;
	}

	public String getRegionRate() {
		return regionRate;
	}

	public void setRegionRate(String regionRate) {
		this.regionRate = regionRate;
	}

	public String getPostRate() {
		return postRate;
	}

	public void setPostRate(String postRate) {
		this.postRate = postRate;
	}

	public boolean isStateRoute() {
		return stateRoute;
	}

	public void setStateRoute(boolean stateRoute) {
		this.stateRoute = stateRoute;
	}

	public boolean isRegionRoute() {
		return regionRoute;
	}

	public void setRegionRoute(boolean regionRoute) {
		this.regionRoute = regionRoute;
	}

	public boolean isPostRoute() {
		return postRoute;
	}

	public void setPostRoute(boolean postRoute) {
		this.postRoute = postRoute;
	}

	public boolean isComprehensive() {
		return comprehensive;
	}

	public void setComprehensive(boolean comprehensive) {
		this.comprehensive = comprehensive;
	}

	public boolean isThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(boolean thirdParty) {
		this.thirdParty = thirdParty;
	}

	public boolean isThirdProperty() {
		return thirdProperty;
	}

	public void setThirdProperty(boolean thirdProperty) {
		this.thirdProperty = thirdProperty;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public boolean isLicensedBroker() {
		return licensedBroker;
	}

	public void setLicensedBroker(boolean licensedBroker) {
		this.licensedBroker = licensedBroker;
	}

	public boolean isInsuranceInstitute() {
		return insuranceInstitute;
	}

	public void setInsuranceInstitute(boolean insuranceInstitute) {
		this.insuranceInstitute = insuranceInstitute;
	}

	public boolean isLoanNewVeh() {
		return loanNewVeh;
	}

	public void setLoanNewVeh(boolean loanNewVeh) {
		this.loanNewVeh = loanNewVeh;
	}

	public boolean isLoanUsedVeh() {
		return loanUsedVeh;
	}

	public void setLoanUsedVeh(boolean loanUsedVeh) {
		this.loanUsedVeh = loanUsedVeh;
	}

	public String getAfslNo() {
		return afslNo;
	}

	public void setAfslNo(String afslNo) {
		this.afslNo = afslNo;
	}

	public String getAuthRepNo() {
		return authRepNo;
	}

	public void setAuthRepNo(String authRepNo) {
		this.authRepNo = authRepNo;
	}

	public String getAclNo() {
		return aclNo;
	}

	public void setAclNo(String aclNo) {
		this.aclNo = aclNo;
	}

	public String getBrokerLicenceNo() {
		return brokerLicenceNo;
	}

	public void setBrokerLicenceNo(String brokerLicenceNo) {
		this.brokerLicenceNo = brokerLicenceNo;
	}

	
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<VehicleMakeListVO> getVehicleDealerMakeList() {
		return vehicleDealerMakeList;
	}

	public void setVehicleDealerMakeList(List<VehicleMakeListVO> vehicleDealerMakeList) {
		this.vehicleDealerMakeList = vehicleDealerMakeList;
	}

	public List<VehicleAreaOfOperStateVO> getVehicleDealerAreaOfOperState() {
		return vehicleDealerAreaOfOperState;
	}

	public void setVehicleDealerAreaOfOperState(List<VehicleAreaOfOperStateVO> vehicleDealerAreaOfOperState) {
		this.vehicleDealerAreaOfOperState = vehicleDealerAreaOfOperState;
	}

	public List<VehicleAreaOfOperRegionVO> getVehicleDealerRegion() {
		return vehicleDealerRegion;
	}

	public void setVehicleDealerRegion(List<VehicleAreaOfOperRegionVO> vehicleDealerRegion) {
		this.vehicleDealerRegion = vehicleDealerRegion;
	}

	public List<VehicleAreaOfOperPostCodeVO> getVehicleDealerPostCode() {
		return vehicleDealerPostCode;
	}

	public void setVehicleDealerPostCode(List<VehicleAreaOfOperPostCodeVO> vehicleDealerPostCode) {
		this.vehicleDealerPostCode = vehicleDealerPostCode;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}


	public String getDelmobile() {
		return delmobile;
	}

	public void setDelmobile(String delmobile) {
		this.delmobile = delmobile;
	}

	public String getLandLine1() {
		return landLine1;
	}

	public void setLandLine1(String landLine1) {
		this.landLine1 = landLine1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
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

	

	public String getFlex1() {
		return flex1;
	}

	public Long getVehicleDealerDetailId() {
		return vehicleDealerDetailId;
	}

	public void setVehicleDealerDetailId(Long vehicleDealerDetailId) {
		this.vehicleDealerDetailId = vehicleDealerDetailId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/*public boolean isNewCar() {
		return isNewCar;
	}

	public void setNewCar(boolean isNewCar) {
		this.isNewCar = isNewCar;
	}

	public boolean isUsedCar() {
		return isUsedCar;
	}

	public void setUsedCar(boolean isUsedCar) {
		this.isUsedCar = isUsedCar;
	}*/

	public boolean isBoth() {
		return isBoth;
	}

	public void setBoth(boolean isBoth) {
		this.isBoth = isBoth;
	}

	public boolean isFlex13() {
		return isFlex13;
	}

	public void setFlex13(boolean isFlex13) {
		this.isFlex13 = isFlex13;
	}

	public boolean isFlex14() {
		return isFlex14;
	}

	public void setFlex14(boolean isFlex14) {
		this.isFlex14 = isFlex14;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}
// End of flex
		

	 	
	
}
