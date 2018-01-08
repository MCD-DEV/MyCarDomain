package au.com.pnspvtltd.mcd.service;

import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;

public interface DealerFinService {

	DealerSearchFinanceVO findById(Long id);

	DealerSearchFinanceVO createDealerSearchFin(DealerSearchFinanceVO dealerSearchFinanceVO,Long id);
	
	DealerSearchFinanceVO updateDealerSearchFin(DealerSearchFinanceVO dealerSearchFinanceVO);

}
