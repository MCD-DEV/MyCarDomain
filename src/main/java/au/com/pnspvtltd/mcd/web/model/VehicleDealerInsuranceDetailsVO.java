package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class VehicleDealerInsuranceDetailsVO {


		

	
	private Long vehicleDealerInsuranceDetailId;
	
	private String vehicleType;
	private String afslNo;
	private String authRepNo;
	private String aclNo;
	private String brokerLicenceNo;
	private boolean isComprehensive;
	private boolean isThirdParty;
	private boolean isThirdProperty;
	
	private boolean isIndividual;
	private boolean isLicensedBroker;
	private boolean isInsuranceInstitute;
	private boolean isNewCar;
	private boolean isUsedCar;
	private boolean isBoth;
	
	
	private String contactPerson;
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
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

	private String designation;
	private String contactNumber1;
	private String contactNumber2;
	private String email;
	private String additionalInfo;
	private Date dob;
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	private String lastName;
	private String title;
	
/*start */
	List<VehicleDealerInsInsDetailsVO> vehicleDealerInsInsDetails;
	
	public List<VehicleDealerInsInsDetailsVO> getVehicleDealerInsInsDetails() {
		return vehicleDealerInsInsDetails;
	}

	public void setVehicleDealerInsInsDetails(List<VehicleDealerInsInsDetailsVO> vehicleDealerInsInsDetails) {
		this.vehicleDealerInsInsDetails = vehicleDealerInsInsDetails;
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

	public boolean isComprehensive() {
		return isComprehensive;
	}

	public void setComprehensive(boolean isComprehensive) {
		this.isComprehensive = isComprehensive;
	}

	public boolean isThirdParty() {
		return isThirdParty;
	}

	public void setThirdParty(boolean isThirdParty) {
		this.isThirdParty = isThirdParty;
	}

	public boolean isThirdProperty() {
		return isThirdProperty;
	}

	public void setThirdProperty(boolean isThirdProperty) {
		this.isThirdProperty = isThirdProperty;
	}

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
	
	
	
	
	public Long getVehicleDealerInsuranceDetailId() {
		return vehicleDealerInsuranceDetailId;
	}

	public void setVehicleDealerInsuranceDetailId(
			Long vehicleDealerInsuranceDetailId) {
		this.vehicleDealerInsuranceDetailId = vehicleDealerInsuranceDetailId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isIndividual() {
		return isIndividual;
	}

	public void setIndividual(boolean isIndividual) {
		this.isIndividual = isIndividual;
	}

	public boolean isLicensedBroker() {
		return isLicensedBroker;
	}

	public void setLicensedBroker(boolean isLicensedBroker) {
		this.isLicensedBroker = isLicensedBroker;
	}

	public boolean isInsuranceInstitute() {
		return isInsuranceInstitute;
	}

	public void setInsuranceInstitute(boolean isInsuranceInstitute) {
		this.isInsuranceInstitute = isInsuranceInstitute;
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

	public String getFlex1() {
		return flex1;
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
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	
	

	
    
 

 	
 	
 	
 	
 	
	
}
