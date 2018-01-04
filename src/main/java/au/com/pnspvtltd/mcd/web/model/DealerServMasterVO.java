package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerServMasterVO {

	
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<VehicleDealerServMaintDetailsVO> getVehicleDealerServMaintDetails() {
		return vehicleDealerServMaintDetails;
	}

	public void setVehicleDealerServMaintDetails(List<VehicleDealerServMaintDetailsVO> vehicleDealerDetails) {
		this.vehicleDealerServMaintDetails = vehicleDealerDetails;
	}

	private Long dealerId;
	
	List<VehicleDealerServMaintDetailsVO> vehicleDealerServMaintDetails;
}
