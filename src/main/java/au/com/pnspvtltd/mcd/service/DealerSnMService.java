package au.com.pnspvtltd.mcd.service;

import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;

public interface DealerSnMService {

	DealerSearchServMaintVO findById(Long id);

	DealerSearchServMaintVO createDealerSearchSnM(DealerSearchServMaintVO dealerSearchServMaintVO,Long id);
	
	DealerSearchServMaintVO updateDealerSearchSnM(DealerSearchServMaintVO dealerSearchServMaintVO);

}
