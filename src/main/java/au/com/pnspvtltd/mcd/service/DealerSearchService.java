package au.com.pnspvtltd.mcd.service;

import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;

public interface DealerSearchService {

	DealerSearchVO findById(Long id);

	DealerSearchVO createDealerSearch(DealerSearchVO dealerSearch,Long id);
	
	DealerSearchVO updateDealerSearch(DealerSearchVO dealerSearch);

}
