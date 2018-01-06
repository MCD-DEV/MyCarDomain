package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerInsuranceMasterVO {

	
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<VehicleDealerInsuranceDetailsVO> getVehicleDealerInsDetails() {
		return vehicleDealerInsDetails;
	}

	public void setVehicleDealerInsDetails(List<VehicleDealerInsuranceDetailsVO> vehicleDealerDetails) {
		this.vehicleDealerInsDetails = vehicleDealerDetails;
	}

	private Long dealerId;
	
	List<VehicleDealerInsuranceDetailsVO> vehicleDealerInsDetails;
}
