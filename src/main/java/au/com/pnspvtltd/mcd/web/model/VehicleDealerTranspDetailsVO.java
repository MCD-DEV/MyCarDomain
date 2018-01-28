package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsTransp;
import au.com.pnspvtltd.mcd.domain.VehicleTranpHypList;


public class VehicleDealerTranspDetailsVO {


		

private Long vehicleDealerTranspDetailId;
	
	private String fromState;
	private String toState;
	private String fromRegion;
	private String toRegion;
	private String fromPost;
	private String toPost;
	private String stateRate;
	private String regionRate;
	private String postRate;
		
	private boolean isStateRoute;
	private boolean isRegionRoute;
	private boolean isPostRoute;
	
	private String fromCity;
	private String toCity;
	private String fromSuborb;
	private String toSuborb;
	
	private boolean fixedRate;
	private boolean perKms;
	private boolean perHrs;
	private boolean autoQuote;
	private boolean addAutoAddCom;
	private boolean browComSec;
	
	private double fixedAmt;
	private double perKmsAmt;
	private double perHrsAmt;
	
	private String companyName;
	private String companyDesc;
	private String companyAddress;
	private String companyWeb;
	private String vehicleType;
	private String subsType;
	
	

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getSubsType() {
		return subsType;
	}

	public void setSubsType(String subsType) {
		this.subsType = subsType;
	}
	
	List<VehicleResourceDetailsTranspVO> vehicleResourceDetails;
	
	List<VehicleTranpHypListVO> vehicleDealerTranpHypList;
	
	
	public List<VehicleResourceDetailsTranspVO> getVehicleResourceDetails() {
		return vehicleResourceDetails;
	}

	public void setVehicleResourceDetails(List<VehicleResourceDetailsTranspVO> vehicleResourceDetails) {
		this.vehicleResourceDetails = vehicleResourceDetails;
	}

	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromSuborb() {
		return fromSuborb;
	}
	public void setFromSuborb(String fromSuborb) {
		this.fromSuborb = fromSuborb;
	}
	public String getToSuborb() {
		return toSuborb;
	}
	public void setToSuborb(String toSuborb) {
		this.toSuborb = toSuborb;
	}
	public boolean isFixedRate() {
		return fixedRate;
	}
	public void setFixedRate(boolean fixedRate) {
		this.fixedRate = fixedRate;
	}
	public boolean isPerKms() {
		return perKms;
	}
	public void setPerKms(boolean perKms) {
		this.perKms = perKms;
	}
	public boolean isPerHrs() {
		return perHrs;
	}
	public void setPerHrs(boolean perHrs) {
		this.perHrs = perHrs;
	}
	public boolean isAutoQuote() {
		return autoQuote;
	}
	public void setAutoQuote(boolean autoQuote) {
		this.autoQuote = autoQuote;
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
	public double getFixedAmt() {
		return fixedAmt;
	}
	public void setFixedAmt(double fixedAmt) {
		this.fixedAmt = fixedAmt;
	}
	public double getPerKmsAmt() {
		return perKmsAmt;
	}
	public void setPerKmsAmt(double perKmsAmt) {
		this.perKmsAmt = perKmsAmt;
	}
	public double getPerHrsAmt() {
		return perHrsAmt;
	}
	public void setPerHrsAmt(double perHrsAmt) {
		this.perHrsAmt = perHrsAmt;
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
	public List<VehicleTranpHypListVO> getVehicleDealerTranpHypList() {
		return vehicleDealerTranpHypList;
	}
	public void setVehicleDealerTranpHypList(List<VehicleTranpHypListVO> vehicleDealerTranpHypList) {
		this.vehicleDealerTranpHypList = vehicleDealerTranpHypList;
	}
	public Long getVehicleDealerTranspDetailId() {
		return vehicleDealerTranspDetailId;
	}
	public void setVehicleDealerTranspDetailId(Long vehicleDealerTranspDetailId) {
		this.vehicleDealerTranspDetailId = vehicleDealerTranspDetailId;
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
		return isStateRoute;
	}
	public void setStateRoute(boolean isStateRoute) {
		this.isStateRoute = isStateRoute;
	}
	public boolean isRegionRoute() {
		return isRegionRoute;
	}
	public void setRegionRoute(boolean isRegionRoute) {
		this.isRegionRoute = isRegionRoute;
	}
	public boolean isPostRoute() {
		return isPostRoute;
	}
	public void setPostRoute(boolean isPostRoute) {
		this.isPostRoute = isPostRoute;
	}
	


	
	

	

	 
    
 

 	
 	
 	
 	
 	
	
}
