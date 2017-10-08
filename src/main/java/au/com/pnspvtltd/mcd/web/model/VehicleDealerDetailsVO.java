package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleAreaOfOperState;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperState;
import au.com.pnspvtltd.mcd.domain.VehicleDealerMakeList;
import au.com.pnspvtltd.mcd.domain.VehicleMakeList;

public class VehicleDealerDetailsVO {


	
	
	private Long vehicleDealerDetailId;
	
	private String vehicleType;
	private boolean isNewCar;
	private boolean isUsedCar;
	private boolean isBoth;
	
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
	
	 List<VehicleMakeListVO> vehicleDealerMakeList;
	 List<VehicleAreaOfOperStateVO> vehicleDealerAreaOfOperState;
	 List<VehicleAreaOfOperRegionVO> vehicleDealerRegion;
	 List<VehicleAreaOfOperPostCodeVO> vehicleDealerPostCode;
	
	 
	 
	

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

	public boolean isNewCar() {
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
	}

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
