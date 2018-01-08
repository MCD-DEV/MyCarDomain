package au.com.pnspvtltd.mcd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchRepository;
import au.com.pnspvtltd.mcd.service.DealerSearchService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;

@Service
public class DealerSearchServiceImpl implements DealerSearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerSearchServiceImpl.class);


	
	@Autowired
	DealerSearchRepository dealerSearchRepository;

	@Autowired
	DomainModelUtil domainModelUtil;

	@Autowired
	DealerRepository dealerRepository;
	@Override
	public DealerSearchVO findById(Long id) {
		// TODO Auto-generated method stub
		DealerSearch dealerSearch = dealerSearchRepository.findOne(id);
		DealerSearchVO dealerSearchVO = null;
		if(dealerSearch != null){
			dealerSearchVO = domainModelUtil.toDealerSearchVO(dealerSearch);
		}
		return dealerSearchVO;
	}



	@Override
	public DealerSearchVO createDealerSearch(DealerSearchVO dealerSearchVO,Long id) {
		// TODO Auto-generated method stub
		DealerSearch dealerSearch = domainModelUtil.toDealerSearch1(dealerSearchVO);
		Dealer dealer = dealerRepository.findOne(id);
		dealerSearch.setDealer1(dealer);
		return domainModelUtil.toDealerSearchVO(dealerSearchRepository.saveAndFlush(dealerSearch));
	}



	@Override
	public DealerSearchVO updateDealerSearch(DealerSearchVO dealerSearch) {
		// TODO Auto-generated method stub
		//dealerSearchRepository.findBy
		return null;
	}
	
}
