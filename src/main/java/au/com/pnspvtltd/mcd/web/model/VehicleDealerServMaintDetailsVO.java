package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsServ;
import au.com.pnspvtltd.mcd.domain.VehicleServHypList;
import au.com.pnspvtltd.mcd.domain.VehicleServSpareList;


public class VehicleDealerServMaintDetailsVO {


		

	
	private Long vehicleDealerServMaintDetailId;
	
	private String vehicleType;
	private boolean isPetrol;
	private boolean isDiesel;
	private boolean isElectric;
	private boolean all1;
	private boolean clientPlaceDriveYes;
	private boolean clientPlaceDriveMaybe;
	private boolean clientPlaceDriveNo;
	private boolean roadAssistance;
	
	private boolean isIndividual;
	private boolean isLicensedBroker;
	private boolean isServMaintInstitute;
	private boolean isNewCar;
	private boolean isUsedCar;
	private boolean isBoth;
	
	private String servMastLevel1;
	private String servMastLevel2;
	private String servMastLevel3;
	
	private String companyName;
	private String companyDesc;
	private String companyAddress;
	private String companyWeb;
	
	private boolean fixedPrice;
	private boolean hourlyRate;
	private boolean partFixPartHr;
	private boolean isAutoQuote;
	private boolean addAutoAddCom;
	private boolean browComSec;
	
	private double estHourFix;
	private double minChargHr;
	private double hourRate;
	private double fixHours;
	private double fixedRate;
	private double estHoursPartFix;
	private double rateforExtHr;
	private double clientPlaceDrCharg;
	
	private String subsType;
	
	

	public String getSubsType() {
		return subsType;
	}

	public void setSubsType(String subsType) {
		this.subsType = subsType;
	}
	List<VehicleResourceDetailsServVO> vehicleResourceDetails;
	
	List<VehicleServSpareListVO> vehicleDealerServSpareList;
	List<VehicleServHypListVO> vehicleDealerServHypList;
	
	
/*start */
	
	
	public boolean isAll1() {
		return all1;
	}

	public List<VehicleResourceDetailsServVO> getVehicleResourceDetails() {
		return vehicleResourceDetails;
	}

	public void setVehicleResourcDetails(List<VehicleResourceDetailsServVO> vehicleResourceDetails) {
		this.vehicleResourceDetails = vehicleResourceDetails;
	}

	public boolean isAddAutoAddCom() {
		return addAutoAddCom;
	}

	public void setAddAutoAddCom(boolean addAutoAddCom) {
		this.addAutoAddCom = addAutoAddCom;
	}

	public boolean isBrowComSec() {
		return browComSec;
	}

	public void setBrowComSec(boolean browComSec) {
		this.browComSec = browComSec;
	}

	public String getServMastLevel1() {
		return servMastLevel1;
	}

	public void setServMastLevel1(String servMastLevel1) {
		this.servMastLevel1 = servMastLevel1;
	}

	public String getServMastLevel2() {
		return servMastLevel2;
	}

	public void setServMastLevel2(String servMastLevel2) {
		this.servMastLevel2 = servMastLevel2;
	}

	public String getServMastLevel3() {
		return servMastLevel3;
	}

	public void setServMastLevel3(String servMastLevel3) {
		this.servMastLevel3 = servMastLevel3;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyWeb() {
		return companyWeb;
	}

	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}

	public boolean isFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(boolean fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public boolean isHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(boolean hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public boolean isPartFixPartHr() {
		return partFixPartHr;
	}

	public void setPartFixPartHr(boolean partFixPartHr) {
		this.partFixPartHr = partFixPartHr;
	}

	public boolean isAutoQuote() {
		return isAutoQuote;
	}

	public void setAutoQuote(boolean isAutoQuote) {
		this.isAutoQuote = isAutoQuote;
	}

	public double getEstHourFix() {
		return estHourFix;
	}

	public void setEstHourFix(double estHourFix) {
		this.estHourFix = estHourFix;
	}

	public double getMinChargHr() {
		return minChargHr;
	}

	public void setMinChargHr(double minChargHr) {
		this.minChargHr = minChargHr;
	}

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}

	public double getFixHours() {
		return fixHours;
	}

	public void setFixHours(double fixHours) {
		this.fixHours = fixHours;
	}

	public double getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(double fixedRate) {
		this.fixedRate = fixedRate;
	}

	public double getEstHoursPartFix() {
		return estHoursPartFix;
	}

	public void setEstHoursPartFix(double estHoursPartFix) {
		this.estHoursPartFix = estHoursPartFix;
	}

	public double getRateforExtHr() {
		return rateforExtHr;
	}

	public void setRateforExtHr(double rateforExtHr) {
		this.rateforExtHr = rateforExtHr;
	}

	public double getClientPlaceDrCharg() {
		return clientPlaceDrCharg;
	}

	public void setClientPlaceDrCharg(double clientPlaceDrCharg) {
		this.clientPlaceDrCharg = clientPlaceDrCharg;
	}

	public List<VehicleServSpareListVO> getVehicleDealerServSpareList() {
		return vehicleDealerServSpareList;
	}

	public void setVehicleDealerServSpareList(List<VehicleServSpareListVO> vehicleDealerServSpareList) {
		this.vehicleDealerServSpareList = vehicleDealerServSpareList;
	}

	public List<VehicleServHypListVO> getVehicleDealerServHypList() {
		return vehicleDealerServHypList;
	}

	public void setVehicleDealerServHypList(List<VehicleServHypListVO> vehicleDealerServHypList) {
		this.vehicleDealerServHypList = vehicleDealerServHypList;
	}

	public void setAll1(boolean all1) {
		this.all1 = all1;
	}

	public boolean isPetrol() {
		return isPetrol;
	}

	public void setPetrol(boolean isPetrol) {
		this.isPetrol = isPetrol;
	}

	public boolean isDiesel() {
		return isDiesel;
	}

	public void setDiesel(boolean isDiesel) {
		this.isDiesel = isDiesel;
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
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
		
	
	public Long getVehicleDealerServMaintDetailId() {
		return vehicleDealerServMaintDetailId;
	}

	public void setVehicleDealerServMaintDetailId(
			Long vehicleDealerServMaintDetailId) {
		this.vehicleDealerServMaintDetailId = vehicleDealerServMaintDetailId;
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

	public boolean isServMaintInstitute() {
		return isServMaintInstitute;
	}

	public void setServMaintInstitute(boolean isServMaintInstitute) {
		this.isServMaintInstitute = isServMaintInstitute;
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
