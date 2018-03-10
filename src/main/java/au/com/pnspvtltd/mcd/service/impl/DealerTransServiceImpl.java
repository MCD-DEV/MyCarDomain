package au.com.pnspvtltd.mcd.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchTransp;
import au.com.pnspvtltd.mcd.domain.VehicleDealerDetails;
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
		
		
		 List<VehicleDealerDetails>  vehicleDealerDetails=dealer.getVehicleDealerDetails();
		    if(vehicleDealerDetails != null){
		    for (VehicleDealerDetails singleRecord : vehicleDealerDetails) {
		    	if(singleRecord.getSubscriptionType() == "SellVehicle")
		    	// start of External Dealer
		    		dealerSearchTransp.setCategory(singleRecord.getDealerType());
		    	dealerSearchTransp.setCompanyName(singleRecord.getDealerGroupName());
		    	dealerSearchTransp.setStreet(singleRecord.getStreetName());
		    	dealerSearchTransp.setSuburb(singleRecord.getSuborb());
		    	dealerSearchTransp.setDealState(singleRecord.getState());
		    	//DealerSearchServMaint.setPostCode(singleRecord.getPostcode());
		    	dealerSearchTransp.setCountry("Australia");
		    	dealerSearchTransp.setPhone(singleRecord.getContactNumber2());
		    	dealerSearchTransp.setWebsite(singleRecord.getWebsite());
		    	dealerSearchTransp.setMobile(singleRecord.getDelmobile());
		    	/*extDealerSearchVO.setTollFree(singleRecord.getTollFree());
				extDealerSearchVO.setFax(singleRecord.getFax());
				extDealerSearchVO.setAfterHours(dealer.getAfterHours());
				extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());*/
		    	dealerSearchTransp.setEmail(dealer.getEmail());
				/*extDealerSearchVO.setLongitude(dealer.getLongitude());
				extDealerSearchVO.setLatitude(dealer.getLatitude());*/
		    }
		    }
		
		
		
		// start of External Dealer
		/*dealerSearchTransp.setCategory(dealer.getDealerGroupName());
		dealerSearchTransp.setCompanyName(dealer.getDealername());
		dealerSearchTransp.setStreet("Internal");
		dealerSearchTransp.setSuburb("Internal");
							//extDealerSearchVO.setState(dealer.getState());
							//extDealerSearchVO.setPostCode(dealer.getPostCode());
		dealerSearchTransp.setCountry("Internal");
		dealerSearchTransp.setPhone("Internal");
		dealerSearchTransp.setWebsite(dealer.getWebsite());
		dealerSearchTransp.setMobile("Internal");
		dealerSearchTransp.setTollFree("Internal");
		dealerSearchTransp.setFax("Internal");
		dealerSearchTransp.setAfterHours("Internal");
		dealerSearchTransp.setPostalAddress("Internal");
		dealerSearchTransp.setEmail(dealer.getEmail());
		dealerSearchTransp.setLongitude(0);
		dealerSearchTransp.setLatitude(0);*/
		dealerSearchTransp.setUserId(dealerSearchTranspVO.getIdp());
							// end of External Dealer
		dealerSearchTransp.setDealer(dealer);
		return domainModelUtil.toDealerSearchTranspVO(dealerSearchTranRepository.saveAndFlush(dealerSearchTransp));
	}

	@Override
	public DealerSearchTranspVO updateDealerSearchTrans(DealerSearchTranspVO dealerSearchTranspVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
