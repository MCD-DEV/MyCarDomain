package au.com.pnspvtltd.mcd.service;

import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;

public interface DealerInsService {

	DealerSearchInsuranceVO findById(Long id);

	DealerSearchInsuranceVO createDealerSearchIns(DealerSearchInsuranceVO dealerSearchInsuranceVO,Long id);
	
	DealerSearchInsuranceVO updateDealerSearchIns(DealerSearchInsuranceVO dealerSearchInsuranceVO);

}
