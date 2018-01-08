package au.com.pnspvtltd.mcd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchInsurance;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchInsRepository;
import au.com.pnspvtltd.mcd.service.DealerInsService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;

@Service
public class DealerInsServiceImpl implements DealerInsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerInsServiceImpl.class);


	
	@Autowired
	DealerSearchInsRepository dealerSearchInsRepository;

	@Autowired
	DomainModelUtil domainModelUtil;

	@Autowired
	DealerRepository dealerRepository;

	@Override
	public DealerSearchInsuranceVO findById(Long id) {
		// TODO Auto-generated method stub
		//return null;
		DealerSearchInsurance DealerSearchInsurance = dealerSearchInsRepository.findOne(id);
		DealerSearchInsuranceVO DealerSearchInsuranceVO = null;
		if(DealerSearchInsurance != null){
			DealerSearchInsuranceVO = domainModelUtil.toDealerSearchInsuranceVO(DealerSearchInsurance);
		}
		return DealerSearchInsuranceVO;
	}

	@Override
	public DealerSearchInsuranceVO createDealerSearchIns(DealerSearchInsuranceVO dealerSearchInsuranceVO, Long id) {
		// TODO Auto-generated method stub
		DealerSearchInsurance dealerSearchInsurance = domainModelUtil.toDealerSearchInsurance1(dealerSearchInsuranceVO);
		Dealer dealer = dealerRepository.findOne(id);
		dealerSearchInsurance.setDealer(dealer);
		return domainModelUtil.toDealerSearchInsuranceVO(dealerSearchInsRepository.saveAndFlush(dealerSearchInsurance));
	}

	@Override
	public DealerSearchInsuranceVO updateDealerSearchIns(DealerSearchInsuranceVO dealerSearchInsuranceVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
