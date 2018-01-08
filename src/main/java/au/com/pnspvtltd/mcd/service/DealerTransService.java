package au.com.pnspvtltd.mcd.service;

import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;

public interface DealerTransService {

	DealerSearchTranspVO findById(Long id);

	DealerSearchTranspVO createDealerSearchTrans(DealerSearchTranspVO dealerSearchTranspVO,Long id);
	
	DealerSearchTranspVO updateDealerSearchTrans(DealerSearchTranspVO dealerSearchTranspVO);

}
