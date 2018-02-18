package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerSubscriptionSBLVO {

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<VehicleDealerDetailsVO> getVehicleDealerDetails() {
		return vehicleDealerDetails;
	}

	public void setVehicleDealerDetails(List<VehicleDealerDetailsVO> vehicleDealerDetails) {
		this.vehicleDealerDetails = vehicleDealerDetails;
	}

	private Long dealerId;

	List<VehicleDealerDetailsVO> vehicleDealerDetails;
}
