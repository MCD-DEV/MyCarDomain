package au.com.pnspvtltd.mcd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchTransp;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchTranRepository;
import au.com.pnspvtltd.mcd.service.DealerTransService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;

@Service
public class DealerTransServiceImpl implements DealerTransService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerTransServiceImpl.class);


	
	@Autowired
	DealerSearchTranRepository dealerSearchTranRepository;

	@Autowired
	DomainModelUtil domainModelUtil;

	@Autowired
	DealerRepository dealerRepository;

	@Override
	public DealerSearchTranspVO findById(Long id) {
		// TODO Auto-generated method stub
		DealerSearchTransp DealerSearchTransp = dealerSearchTranRepository.findOne(id);
		DealerSearchTranspVO DealerSearchTranspVO = null;
		if(DealerSearchTransp != null){
			DealerSearchTranspVO = domainModelUtil.toDealerSearchTranspVO(DealerSearchTransp);
		}
		return DealerSearchTranspVO;
	}

	@Override
	public DealerSearchTranspVO createDealerSearchTrans(DealerSearchTranspVO dealerSearchTranspVO, Long id) {
		// TODO Auto-generated method stub
		DealerSearchTransp dealerSearchTransp = domainModelUtil.toDealerSearchTransp1(dealerSearchTranspVO);
		Dealer dealer = dealerRepository.findOne(id);
		dealerSearchTransp.setDealer(dealer);
		return domainModelUtil.toDealerSearchTranspVO(dealerSearchTranRepository.saveAndFlush(dealerSearchTransp));
	}

	@Override
	public DealerSearchTranspVO updateDealerSearchTrans(DealerSearchTranspVO dealerSearchTranspVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
