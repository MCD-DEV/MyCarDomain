package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerFinanceMasterVO {

	
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public List<FinanceEntityVO> getVehicleDealerFinDetails() {
		return vehicleDealerFinDetails;
	}

	public void setVehicleDealerFinDetails(List<FinanceEntityVO> vehicleDealerDetails) {
		this.vehicleDealerFinDetails = vehicleDealerDetails;
	}

	private Long dealerId;
	
	List<FinanceEntityVO> vehicleDealerFinDetails;
}
