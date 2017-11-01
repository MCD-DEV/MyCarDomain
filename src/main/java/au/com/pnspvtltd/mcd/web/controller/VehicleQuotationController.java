package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.SearchFinance;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehQuotExtras;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.DealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
@RestController
public class VehicleQuotationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleQuotationController.class);

	@Autowired
	VehicleQuotationRepository vehicleQuotationRepository;
	@Autowired
	ExtDealerSearchRepository extDealerSearchRepository;
	@Autowired
	DealerSearchRepository dealerSearchRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DomainModelUtil domainModelUtil;
	
	@GetMapping(value = "vehicleQuotation/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public VehicleQuotationVO getQuotation(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get Vehicle Quotation with id {} ", id);
		/*VehicleQuotationVO dealer = vehicleQuotationRepository.findById(id);
		if (dealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}*/
		
		VehicleQuotation dealer = vehicleQuotationRepository.findOne(id);
		VehicleQuotationVO dealerVO = null;
		
		if(dealer != null){
			dealerVO = domainModelUtil.fromVehicleQuotation(dealer, false);
			
			

			
		}else {
			
				response.setStatus(HttpStatus.NO_CONTENT.value());
			
		}
		return dealerVO;
		
	}
	
	
	@PutMapping("vehicleQuotation")
	@Transactional
	public VehicleQuotationVO updateVehicleQuotation(@RequestBody VehicleQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update VehicleQuotation {}", vehicleQuotationVO.getQuotId());
	    //TODO: create a service for VehicleQutotation to update quotation details
		if(vehicleQuotationVO != null){
			VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(vehicleQuotationVO.getQuotId());
			vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return vehicleQuotationVO;
	}
	
	@PutMapping("dealerQuotCreation")
	public VehicleQuotation dealerQuotCreation(@RequestBody VehicleQuotationVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Quotati for Ext Dealer {}", dealerVO);
		
		VehicleQuotation vehicleQuotation = new VehicleQuotation();
		vehicleQuotation.setRegoEndDate(dealerVO.getRegoEndDate());// set Offer Valid Date
		vehicleQuotation.setDriveAwayPrice(dealerVO.getDriveAwayPrice()); // set Drive Away Price
		vehicleQuotation.setOfferPrice2(dealerVO.getOfferPrice2());// set Save Price
		vehicleQuotation.setOfferPrice3(dealerVO.getOfferPrice3());// Actual value of Offer
		// Offer Details select Template Id from Car Templates via list
		vehicleQuotation.setModelYear(dealerVO.getModelYear());
		vehicleQuotation.setModelDisplay(dealerVO.getModelDisplay());
		vehicleQuotation.setModelName(dealerVO.getModelName());
		vehicleQuotation.setModelTrim(dealerVO.getModelTrim());
		
		// Addition of extras
		
		/*if (vehicleQuotation.getVehQuotExtras() != null) {
			vehicleQuotation.getVehQuotExtras().add(dealerVO.getVehQuotExtras());
		} else {
			List<VehQuotExtras> vehQuotExtras = new ArrayList<>();
			vehQuotExtras.add(vehQuotExtras);
			vehicleQuotation.setVehQuotExtras(vehQuotExtras);
		}*/
		vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		vehicleQuotation.setVehQuotDoc(dealerVO.getVehQuotDoc());
		vehicleQuotation.setOfferDateList(dealerVO.getOfferDateList());
		vehicleQuotation.setVehQuotTerm(dealerVO.getVehQuotTerm());
		vehicleQuotation.setFname(dealerVO.getFname()); // Terms and conditions
		vehicleQuotation.setBasicPrice(dealerVO.getBasicPrice()); // set Basic Price
		
		vehicleQuotation.setDealerId(dealerVO.getDealerId()); // Dealer Lead Id
		vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotation.setUserCreationDate(dealerVO.getUserCreationDate());
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		vehicleQuotation.setCreationDate(ourJavaDateObject);
		vehicleQuotation.setStatus(true);
		vehicleQuotation.setDealSearchId(dealerVO.getDealSearchId());
		DealerSearch extDealerSearch=dealerSearchRepository.findOne(dealerVO.getDealSearchId());
		extDealerSearch.setStatus(true);
		User user =userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getVehicleQuotCt();
		user.setVehicleQuotCt(vehQuotCountTemp+1);
		// Dealer info Start
		/*vehicleQuotation.setCategory(extDealerSearch.getCategory());
		vehicleQuotation.setCompanyName(extDealerSearch.getCompanyName());;
		vehicleQuotation.setStreet(extDealerSearch.getStreet());
		vehicleQuotation.setSuburb(extDealerSearch.getSuburb());;
		vehicleQuotation.setDealState(extDealerSearch.getDealState());;
		vehicleQuotation.setDealPostCode(extDealerSearch.getPostCode());;
		vehicleQuotation.setCountry(extDealerSearch.getCountry());;
		vehicleQuotation.setPhone(extDealerSearch.getPhone());;
		vehicleQuotation.setWebsite(extDealerSearch.getWebsite());;
		vehicleQuotation.setMobile(extDealerSearch.getMobile());
		vehicleQuotation.setTollFree(extDealerSearch.getTollFree());
		vehicleQuotation.setFax(extDealerSearch.getFax());
		vehicleQuotation.setAfterHours(extDealerSearch.getAfterHours());
		vehicleQuotation.setPostalAddress(extDealerSearch.getPostalAddress());
		vehicleQuotation.setEmail(extDealerSearch.getEmail());
		vehicleQuotation.setLongitude(extDealerSearch.getLongitude());
		vehicleQuotation.setLatitude(extDealerSearch.getLatitude());
		vehicleQuotation.setColor(extDealerSearch.getCarColor());
		vehicleQuotation.setDriveType(extDealerSearch.getState());
		vehicleQuotation.setIdCheck(extDealerSearch.isIdCheck());
		vehicleQuotation.setCredStat(extDealerSearch.isCredStat());
		vehicleQuotation.setMobCheck(extDealerSearch.isMobCheck());*/
		vehicleQuotation.setDealStockNo(0);
		vehicleQuotation.setAutoscpStockNo(0);
		//vehicleQuotation.
					// Dealer info end
		
		
		
		dealerSearchRepository.flush();
		vehicleQuotation.setCarSearchId(dealerVO.getCarSearchId()); // user Ebid Id
		
		//vehicleQuotation.setRefId(vehicleQuotation.getRefId());
		vehicleQuotation.setAutoBid(true);
		
		//vehicleQuotation.setDealerStockNo(vehicleQuotation.getDealerStockNo());
		Long l =(long) 0;
		// Ebid Request
		vehicleQuotation.setNewer(dealerVO.isNewer());
		vehicleQuotation.setUsed(dealerVO.isUsed());
		vehicleQuotation.setPostCode(dealerVO.getPostCode());
		//vehicleQuotation.setColor(dealerVO.getColor());// color 1
		vehicleQuotation.setTransmission(dealerVO.getTransmission()); // color2
		//vehicleQuotation.setDriveType(dealerVO.getDriveType());// more about more requirement
		vehicleQuotation.setRefId(l);
		vehicleQuotation.setAddress(dealerVO.getAddress()); // set image
		//vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotationRepository.save(vehicleQuotation);
		vehicleQuotationRepository.flush();
		return vehicleQuotation;
	}
	
	
	@PutMapping("dealerQuotCreationExt")
	public VehicleQuotation dealerQuotCreationExt(@RequestBody VehicleQuotationVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Quotati for Ext Dealer {}", dealerVO);
		
		VehicleQuotation vehicleQuotation = new VehicleQuotation();
		vehicleQuotation.setRegoEndDate(dealerVO.getRegoEndDate());// set Offer Valid Date
		vehicleQuotation.setDriveAwayPrice(dealerVO.getDriveAwayPrice()); // set Drive Away Price
		vehicleQuotation.setOfferPrice2(dealerVO.getOfferPrice2());// set Save Price
		vehicleQuotation.setOfferPrice3(dealerVO.getOfferPrice3());// Actual value of Offer
		// Offer Details select Template Id from Car Templates via list
		vehicleQuotation.setModelYear(dealerVO.getModelYear());
		vehicleQuotation.setModelDisplay(dealerVO.getModelDisplay());
		vehicleQuotation.setModelName(dealerVO.getModelName());
		vehicleQuotation.setModelTrim(dealerVO.getModelTrim());
		
		// Addition of extras
		
		/*if (vehicleQuotation.getVehQuotExtras() != null) {
			vehicleQuotation.getVehQuotExtras().add(dealerVO.getVehQuotExtras());
		} else {
			List<VehQuotExtras> vehQuotExtras = new ArrayList<>();
			vehQuotExtras.add(vehQuotExtras);
			vehicleQuotation.setVehQuotExtras(vehQuotExtras);
		}*/
		vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		vehicleQuotation.setVehQuotDoc(dealerVO.getVehQuotDoc());
		vehicleQuotation.setOfferDateList(dealerVO.getOfferDateList());
		vehicleQuotation.setVehQuotTerm(dealerVO.getVehQuotTerm());
		vehicleQuotation.setFname(dealerVO.getFname()); // Terms and conditions
		vehicleQuotation.setBasicPrice(dealerVO.getBasicPrice()); // set Basic Price
		
		vehicleQuotation.setDealerId(dealerVO.getDealerId()); // Dealer Lead Id
		vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotation.setUserCreationDate(dealerVO.getUserCreationDate());
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		vehicleQuotation.setCreationDate(ourJavaDateObject);
		vehicleQuotation.setStatus(true);
		vehicleQuotation.setDealSearchId(dealerVO.getDealSearchId());
		ExtDealerSearch extDealerSearch=extDealerSearchRepository.findOne(dealerVO.getDealSearchId());
		extDealerSearch.setStatus(true);
		User user =userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getVehicleQuotCt();
		user.setVehicleQuotCt(vehQuotCountTemp+1);
		// Dealer info Start
		vehicleQuotation.setCategory(extDealerSearch.getCategory());
		vehicleQuotation.setCompanyName(extDealerSearch.getCompanyName());;
		vehicleQuotation.setStreet(extDealerSearch.getStreet());
		vehicleQuotation.setSuburb(extDealerSearch.getSuburb());;
		vehicleQuotation.setDealState(extDealerSearch.getDealState());;
		vehicleQuotation.setDealPostCode(extDealerSearch.getPostCode());;
		vehicleQuotation.setCountry(extDealerSearch.getCountry());;
		vehicleQuotation.setPhone(extDealerSearch.getPhone());;
		vehicleQuotation.setWebsite(extDealerSearch.getWebsite());;
		vehicleQuotation.setMobile(extDealerSearch.getMobile());
		vehicleQuotation.setTollFree(extDealerSearch.getTollFree());
		vehicleQuotation.setFax(extDealerSearch.getFax());
		vehicleQuotation.setAfterHours(extDealerSearch.getAfterHours());
		vehicleQuotation.setPostalAddress(extDealerSearch.getPostalAddress());
		vehicleQuotation.setEmail(extDealerSearch.getEmail());
		vehicleQuotation.setLongitude(extDealerSearch.getLongitude());
		vehicleQuotation.setLatitude(extDealerSearch.getLatitude());
		vehicleQuotation.setColor(extDealerSearch.getCarColor());
		vehicleQuotation.setDriveType(extDealerSearch.getState());
		vehicleQuotation.setIdCheck(extDealerSearch.isIdCheck());
		vehicleQuotation.setCredStat(extDealerSearch.isCredStat());
		vehicleQuotation.setMobCheck(extDealerSearch.isMobCheck());
		vehicleQuotation.setDealStockNo(0);
		vehicleQuotation.setAutoscpStockNo(0);
		//vehicleQuotation.
					// Dealer info end
		
		
		
		extDealerSearchRepository.flush();
		vehicleQuotation.setCarSearchId(dealerVO.getCarSearchId()); // user Ebid Id
		
		//vehicleQuotation.setRefId(vehicleQuotation.getRefId());
		vehicleQuotation.setAutoBid(true);
		
		//vehicleQuotation.setDealerStockNo(vehicleQuotation.getDealerStockNo());
		Long l =(long) 0;
		// Ebid Request
		vehicleQuotation.setNewer(dealerVO.isNewer());
		vehicleQuotation.setUsed(dealerVO.isUsed());
		vehicleQuotation.setPostCode(dealerVO.getPostCode());
		//vehicleQuotation.setColor(dealerVO.getColor());// color 1
		vehicleQuotation.setTransmission(dealerVO.getTransmission()); // color2
		//vehicleQuotation.setDriveType(dealerVO.getDriveType());// more about more requirement
		vehicleQuotation.setRefId(l);
		vehicleQuotation.setAddress(dealerVO.getAddress()); // set image
		//vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotationRepository.save(vehicleQuotation);
		vehicleQuotationRepository.flush();
		return vehicleQuotation;
	}
	
	@GetMapping(value = "getExtQtDealSearchInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSearchListAdminVO getExtQtDealSearchInfoId(@RequestParam("carSearchId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerSearchListAdminVO userAdminSearchVO12 = new ExtQtDealerSearchListAdminVO();

		List<VehicleQuotation> users = vehicleQuotationRepository.getDealerSearchForID(carSearchId);
		List<VehicleQuotationVO> searchVOs = new ArrayList<VehicleQuotationVO>();
		for (VehicleQuotation search : users) {
			//VehicleQuotationVO dealVO= domainModelUtil.toExtQtDealerSearchVO(search);
			VehicleQuotationVO dealVO= domainModelUtil.fromVehicleQuotation(search,false);
			
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setVehicleQuotationVO(searchVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtQtSearchInfoIdDealrId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSearchListAdminVO getExtQtDealSearchInfoId(@RequestParam("leadId") Long carSearchId, @RequestParam("dealerId") Long dealerId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerSearchListAdminVO userAdminSearchVO12 = new ExtQtDealerSearchListAdminVO();

		List<VehicleQuotation> users = vehicleQuotationRepository.getDealerSearchDealID(carSearchId, dealerId);
		List<VehicleQuotationVO> searchVOs = new ArrayList<VehicleQuotationVO>();
		for (VehicleQuotation search : users) {
			//VehicleQuotationVO dealVO= domainModelUtil.toExtQtDealerSearchVO(search);
			VehicleQuotationVO dealVO= domainModelUtil.fromVehicleQuotation(search,false);
			
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setVehicleQuotationVO(searchVOs);
	
		return userAdminSearchVO12;
	}
}
