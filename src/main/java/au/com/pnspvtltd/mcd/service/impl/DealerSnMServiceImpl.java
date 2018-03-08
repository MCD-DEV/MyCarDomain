package au.com.pnspvtltd.mcd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchServMaint;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchSnMRepository;
import au.com.pnspvtltd.mcd.service.DealerSnMService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;

@Service
public class DealerSnMServiceImpl implements DealerSnMService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerSnMServiceImpl.class);


	
	@Autowired
	DealerSearchSnMRepository dealerSearchSnMRepository;

	@Autowired
	DomainModelUtil domainModelUtil;

	@Autowired
	DealerRepository dealerRepository;

	@Override
	public DealerSearchServMaintVO findById(Long id) {
		// TODO Auto-generated method stub
		DealerSearchServMaint DealerSearchServMaint = dealerSearchSnMRepository.findOne(id);
		DealerSearchServMaintVO DealerSearchServMaintVO = null;
		if(DealerSearchServMaint != null){
			DealerSearchServMaintVO = domainModelUtil.toDealerSearchServMaintVO(DealerSearchServMaint);
		}
		return DealerSearchServMaintVO;
	}

	@Override
	public DealerSearchServMaintVO createDealerSearchSnM(DealerSearchServMaintVO dealerSearchServMaintVO, Long id) {
		// TODO Auto-generated method stub
		DealerSearchServMaint DealerSearchServMaint = domainModelUtil.toDealerSearchServMaint1(dealerSearchServMaintVO);
		Dealer dealer = dealerRepository.findOne(id);
		
		// start of External Dealer
		DealerSearchServMaint.setCategory(dealer.getDealerGroupName());
		DealerSearchServMaint.setCompanyName(dealer.getDealername());
		DealerSearchServMaint.setStreet("Internal");
		DealerSearchServMaint.setSuburb("Internal");
					//extDealerSearchVO.setState(dealer.getState());
					//extDealerSearchVO.setPostCode(dealer.getPostCode());
		DealerSearchServMaint.setCountry("Internal");
		DealerSearchServMaint.setPhone("Internal");
		DealerSearchServMaint.setWebsite(dealer.getWebsite());
		DealerSearchServMaint.setMobile("Internal");
		DealerSearchServMaint.setTollFree("Internal");
		DealerSearchServMaint.setFax("Internal");
		DealerSearchServMaint.setAfterHours("Internal");
		DealerSearchServMaint.setPostalAddress("Internal");
		DealerSearchServMaint.setEmail(dealer.getEmail());
		DealerSearchServMaint.setLongitude(0);
		DealerSearchServMaint.setLatitude(0);
		DealerSearchServMaint.setUserId(dealerSearchServMaintVO.getIdp());
					// end of External Dealer
		//DealerSearchServMaint.setExternalDealerId(dealerSearchServMaintVO.getDealerId());
		//DealerSearchServMaint.setUserid(dealerSearchServMaintVO.getId());
		
		
		DealerSearchServMaint.setDealer(dealer);
		return domainModelUtil.toDealerSearchServMaintVO(dealerSearchSnMRepository.saveAndFlush(DealerSearchServMaint));
	}

	@Override
	public DealerSearchServMaintVO updateDealerSearchSnM(DealerSearchServMaintVO dealerSearchServMaintVO) {
		// TODO Auto-generated method stub
		return null;
	}


}
