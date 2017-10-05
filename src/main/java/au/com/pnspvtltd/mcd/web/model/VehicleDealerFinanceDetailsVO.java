package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleDealerFinInsDetails;


public class VehicleDealerFinanceDetailsVO {


		

	
	private Long vehicleDealerFinanceDetailId;
	
	private String vehicleType;
	private String afslNo;
	private String authRepNo;
	private String aclNo;
	private String brokerLicenceNo;
	private boolean isLoanNewVeh;
	private boolean isLoanUsedVeh;
	private boolean isIndividual;
	private boolean isLicensedBroker;
	private boolean isFinancialInstitute;
	private boolean isNewCar;
	private boolean isUsedCar;
	private boolean isBoth;
	
/*start */
	List<VehicleDealerFinInsDetailsVO> vehicleDealerFinInsDetails;
	
	public List<VehicleDealerFinInsDetailsVO> getVehicleDealerFinInsDetails() {
		return vehicleDealerFinInsDetails;
	}

	public void setVehicleDealerFinInsDetails(List<VehicleDealerFinInsDetailsVO> vehicleDealerFinInsDetails) {
		this.vehicleDealerFinInsDetails = vehicleDealerFinInsDetails;
	}

	public String getAfslNo() {
		return afslNo;
	}

	public String getAclNo() {
		return aclNo;
	}

	public void setAclNo(String aclNo) {
		this.aclNo = aclNo;
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

	public String getBrokerLicenceNo() {
		return brokerLicenceNo;
	}

	public void setBrokerLicenceNo(String brokerLicenceNo) {
		this.brokerLicenceNo = brokerLicenceNo;
	}

	public boolean isLoanNewVeh() {
		return isLoanNewVeh;
	}

	public void setLoanNewVeh(boolean isLoanNewVeh) {
		this.isLoanNewVeh = isLoanNewVeh;
	}

	public boolean isLoanUsedVeh() {
		return isLoanUsedVeh;
	}

	public void setLoanUsedVeh(boolean isLoanUsedVeh) {
		this.isLoanUsedVeh = isLoanUsedVeh;
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
	
	
	public Long getVehicleDealerFinanceDetailId() {
		return vehicleDealerFinanceDetailId;
	}

	public void setVehicleDealerFinanceDetailId(Long vehicleDealerFinanceDetailId) {
		this.vehicleDealerFinanceDetailId = vehicleDealerFinanceDetailId;
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

	public boolean isFinancialInstitute() {
		return isFinancialInstitute;
	}

	public void setFinancialInstitute(boolean isFinancialInstitute) {
		this.isFinancialInstitute = isFinancialInstitute;
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
