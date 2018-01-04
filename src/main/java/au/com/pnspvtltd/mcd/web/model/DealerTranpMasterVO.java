package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerTranpMasterVO {

	
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<VehicleDealerTranspDetailsVO> getVehicleDealerTranpDetails() {
		return vehicleDealerTranpDetails;
	}

	public void setVehicleDealerTranpDetails(List<VehicleDealerTranspDetailsVO> vehicleDealerDetails) {
		this.vehicleDealerTranpDetails = vehicleDealerDetails;
	}

	private Long dealerId;
	
	List<VehicleDealerTranspDetailsVO> vehicleDealerTranpDetails;
}
