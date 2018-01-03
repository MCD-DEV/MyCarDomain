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
 * Entity implementation class for Entity: TEMPCARMODELOVERVIEW
 * 
 */
@Entity @Table(name = "vehicledealersermaintdetails") public class VehicleDealerServMaintDetails implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
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
	
	
	
	
	private boolean isIndividual;
	private boolean isLicensedBroker;
	private boolean isServMaintInstitute;
	private boolean isNewCar;
	private boolean isUsedCar;
	private boolean isBoth;
	
	List<VehicleServSpareList> vehicleDealerServSpareList;
	 List<VehicleServHypList> vehicleDealerServHypList;
	
/*start */
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "vehicleDealerServMaintDetailId")
	public List<VehicleServSpareList> getVehicleDealerServSpareList() {
		return vehicleDealerServSpareList;
	}

	public void setVehicleDealerServSpareList(
			List<VehicleServSpareList> vehicleDealerMakeList) {
		this.vehicleDealerServSpareList = vehicleDealerMakeList;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "vehicleDealerServMaintDetailId")
	public List<VehicleServHypList> getVehicleDealerServHypList() {
		return vehicleDealerServHypList;
	}

	public void setVehicleDealerServHypList(
			List<VehicleServHypList> vehicleDealerMakeList) {
		this.vehicleDealerServHypList = vehicleDealerMakeList;
	}
	// Flex start
	private String flex1;	
	public boolean isAll1() {
		return all1;
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
		
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "VEHICLEDEALERSERVMAINTDETAILID") public Long getVehicleDealerServMaintDetailId() {
		return vehicleDealerServMaintDetailId;
	}

	public void setVehicleDealerServMaintDetailId(
			Long vehicleDealerServMaintDetailId) {
		this.vehicleDealerServMaintDetailId = vehicleDealerServMaintDetailId;
	}

	@Column(name = "VEHICLETYPE") public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Column(name = "ISINDIVIDUAL") public boolean isIndividual() {
		return isIndividual;
	}

	public void setIndividual(boolean isIndividual) {
		this.isIndividual = isIndividual;
	}

	@Column(name = "ISLICENSEDBROKER") public boolean isLicensedBroker() {
		return isLicensedBroker;
	}

	public void setLicensedBroker(boolean isLicensedBroker) {
		this.isLicensedBroker = isLicensedBroker;
	}

	@Column(name = "ISSERVMAINTINSTITUTE") public boolean isServMaintInstitute() {
		return isServMaintInstitute;
	}

	public void setServMaintInstitute(boolean isServMaintInstitute) {
		this.isServMaintInstitute = isServMaintInstitute;
	}

	@Column(name = "ISNEWCAR") public boolean isNewCar() {
		return isNewCar;
	}

	public void setNewCar(boolean isNewCar) {
		this.isNewCar = isNewCar;
	}

	@Column(name = "ISUSEDCAR") public boolean isUsedCar() {
		return isUsedCar;
	}

	public void setUsedCar(boolean isUsedCar) {
		this.isUsedCar = isUsedCar;
	}

	@Column(name = "ISBOTH") public boolean isBoth() {
		return isBoth;
	}

	public void setBoth(boolean isBoth) {
		this.isBoth = isBoth;
	}

	@Column(name = "ISFLEX13") public boolean isFlex13() {
		return isFlex13;
	}

	public void setFlex13(boolean isFlex13) {
		this.isFlex13 = isFlex13;
	}

	@Column(name = "ISFLEX14") public boolean isFlex14() {
		return isFlex14;
	}

	public void setFlex14(boolean isFlex14) {
		this.isFlex14 = isFlex14;
	}

	@Column(name = "FLEX1") public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Column(name = "FLEX2") public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	@Column(name = "FLEX3") public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	@Column(name = "FLEX4") public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	@Column(name = "FLEX5") public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	@Column(name = "FLEX6") public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	@Column(name = "FLEX7") public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	@Column(name = "FLEX8") public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	@Column(name = "FLEX9") public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	@Column(name = "FLEX10") public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	@Column(name = "FLEX11") public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	@Column(name = "FLEX12") public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}
// End of flex
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	public VehicleDealerServMaintDetails() {
        super();
    }
	
	

	

	 
    
 

 	
 	
 	
 	
 	
	
}
