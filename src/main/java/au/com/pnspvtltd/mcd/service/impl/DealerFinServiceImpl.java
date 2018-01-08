package au.com.pnspvtltd.mcd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchFinRepository;
import au.com.pnspvtltd.mcd.service.DealerFinService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;

@Service
public class DealerFinServiceImpl implements DealerFinService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerFinServiceImpl.class);


	
	@Autowired
	DealerSearchFinRepository dealerSearchFinRepository;

	@Autowired
	DomainModelUtil domainModelUtil;

	@Autowired
	DealerRepository dealerRepository;

	@Override
	public DealerSearchFinanceVO findById(Long id) {
		// TODO Auto-generated method stub
		//return null;
		DealerSearchFinance dealerSearchFinance = dealerSearchFinRepository.findOne(id);
		DealerSearchFinanceVO dealerSearchFinanceVO = null;
		if(dealerSearchFinance != null){
			dealerSearchFinanceVO = domainModelUtil.toDealerSearchFinanceVO(dealerSearchFinance);
		}
		return dealerSearchFinanceVO;
	}

	@Override
	public DealerSearchFinanceVO createDealerSearchFin(DealerSearchFinanceVO dealerSearchFinanceVO, Long id) {
		// TODO Auto-generated method stub
		DealerSearchFinance dealerSearchFinance = domainModelUtil.toDealerSearchFinance1(dealerSearchFinanceVO);
		Dealer dealer = dealerRepository.findOne(id);
		dealerSearchFinance.setDealer(dealer);
		return domainModelUtil.toDealerSearchFinanceVO(dealerSearchFinRepository.saveAndFlush(dealerSearchFinance));
	}

	@Override
	public DealerSearchFinanceVO updateDealerSearchFin(DealerSearchFinanceVO dealerSearchFinanceVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
