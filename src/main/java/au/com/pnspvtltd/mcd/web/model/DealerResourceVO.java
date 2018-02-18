package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerResourceVO {

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<VehicleResourceDetailsVO> getVehicleResourceDetails() {
		return vehicleResourceDetails;
	}

	public void setVehicleDealerDetails(List<VehicleResourceDetailsVO> vehicleResourceDetails) {
		this.vehicleResourceDetails = vehicleResourceDetails;
	}

	private Long dealerId;

	List<VehicleResourceDetailsVO> vehicleResourceDetails;
}
