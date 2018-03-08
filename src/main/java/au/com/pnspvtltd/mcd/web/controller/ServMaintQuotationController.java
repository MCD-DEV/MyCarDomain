package au.com.pnspvtltd.mcd.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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

import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.DealerSearchServMaint;
import au.com.pnspvtltd.mcd.domain.ExtDealServMaintr1;
import au.com.pnspvtltd.mcd.domain.SearchServMaint;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsQuo;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsServQuo;
import au.com.pnspvtltd.mcd.repository.ExtDealerServMaintRepository;
import au.com.pnspvtltd.mcd.repository.ServMaintQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerSmListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsQuoVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsServQuoVO;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
// @CrossOrigin(origins = "*")
@RestController
public class ServMaintQuotationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServMaintQuotationController.class);

	@Autowired
	ServMaintQuotationRepository servMaintQuotationRepository;
	@Autowired
	ExtDealerServMaintRepository extDealerServMaintRepository;
	@Autowired
	au.com.pnspvtltd.mcd.repository.DealerSearchSnMRepository DealerSearchSnMRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	DomainModelUtil domainModelUtil;
	
	@GetMapping(value = "servMaintQuotation/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ServiceMaintQuotationVO getQuotation(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get service Quotation with id {} ", id);
		/*VehicleQuotationVO dealer = vehicleQuotationRepository.findById(id);
		if (dealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}*/
		
		ServiceMaintQuotation dealer = servMaintQuotationRepository.findOne(id);
		ServiceMaintQuotationVO dealerVO = null;
		
		if(dealer != null){
			dealerVO = domainModelUtil.fromServMaintQuotation(dealer);
			
			

			
		}else {
			
				response.setStatus(HttpStatus.NO_CONTENT.value());
			
		}
		return dealerVO;
		
	}
	
	

	@PutMapping("servMaintQuotation")
	@Transactional
	public ServiceMaintQuotationVO updateVehicleQuotation(@RequestBody ServiceMaintQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update VehicleQuotation {}", vehicleQuotationVO.getServMaintQuotId());
		// TODO: create a service for VehicleQutotation to update quotation
		// details
		if (vehicleQuotationVO != null) {
			ServiceMaintQuotation vehicleQuotation = servMaintQuotationRepository
					.findOne(vehicleQuotationVO.getServMaintQuotId());
			vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return vehicleQuotationVO;
	}

	
	// start internal dealer quota creation for service and maintenance
	@PutMapping("dealerQuotSmCreationInt")
	public ServiceMaintQuotation dealerQuotSmCreationInt(@RequestBody ServiceMaintQuotationVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Quotati for Int service Dealer {}", dealerVO);
		
		ServiceMaintQuotation vehicleQuotation = new ServiceMaintQuotation();
		vehicleQuotation.setOfferValidDate(dealerVO.getOfferValidDate());// set
																			// Offer
																			// Valid
																			// Date
		vehicleQuotation.setDriveAwayPrice(dealerVO.getDriveAwayPrice()); // set
																			// Drive
																			// Away
																			// Price
		vehicleQuotation.setOfferPrice2(dealerVO.getOfferPrice2());// set Save
																	// Price
		vehicleQuotation.setOfferPrice3(dealerVO.getOfferPrice3());// Actual
																	// value of
																	// Offer
		// Offer Details select Template Id from Car Templates via list
		vehicleQuotation.setModelYear(dealerVO.getModelYear());
		vehicleQuotation.setModelDisplay(dealerVO.getModelDisplay());
		vehicleQuotation.setModelName(dealerVO.getModelName());
		vehicleQuotation.setModelTrim(dealerVO.getModelTrim());
		vehicleQuotation.setRegoNo(dealerVO.getRegoNo());
		vehicleQuotation.setRegoStat(dealerVO.getRegoStat());
		vehicleQuotation.setPostCode(dealerVO.getPostCode());
		vehicleQuotation.setFuelType(dealerVO.getFuelType());
		vehicleQuotation.setServMaintL1(dealerVO.getServMaintL1());
		vehicleQuotation.setServMaintL2(dealerVO.getServMaintL2());
		vehicleQuotation.setCoveredUnderIns(dealerVO.isCoveredUnderIns());
		vehicleQuotation.setCurInsProv(dealerVO.getCurInsProv());
		vehicleQuotation.setFlex1(dealerVO.getFlex1());
		vehicleQuotation.setInternal(true);
		// start of logic change of ID to resourceDetail
				List<VehicleResourceDetailsServQuoVO> vehicleResourceDetailsQuos= dealerVO.getVehicleResourcDetails();
				if(vehicleResourceDetailsQuos != null){
				List<VehicleResourceDetailsServQuo> chVehicleResourceDetailsQuos = new ArrayList<VehicleResourceDetailsServQuo>();
				for (VehicleResourceDetailsServQuoVO search : vehicleResourceDetailsQuos) {
					search.setId(search.getVehicleResourceDetailId().toString());
					search.setVehicleResourceDetailId(null);
					VehicleResourceDetailsServQuo th = new VehicleResourceDetailsServQuo();
					
					try {
						BeanUtils.copyProperties(th, search);
						
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					chVehicleResourceDetailsQuos.add(th);
				}
		vehicleQuotation.setVehicleResourcDetails(chVehicleResourceDetailsQuos);
				}
				
		// Addition of extras
		// vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		// vehicleQuotation.setFname(dealerVO.getFname()); // Terms and
		// conditions

		vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotation.setUserCreationDate(dealerVO.getUserCreationDate());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		vehicleQuotation.setCreationDate(ourJavaDateObject);
		// vehicleQuotation.setStatus(true);
		vehicleQuotation.setSearchServMaintId(dealerVO.getSearchServMaintId());
		vehicleQuotation.setDealServMaintId(dealerVO.getDealServMaintId());
		DealerSearchServMaint extDealerSearch = DealerSearchSnMRepository.findOne(dealerVO.getDealServMaintId());
		extDealerSearch.setStatus(true);
		vehicleQuotation.setDealerId(dealerVO.getDealerId()); // Dealer
																		// Lead
																		// Id
		User user = userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getVehicleQuotCt();
		user.setServMaintQuotCt(vehQuotCountTemp + 1);
		// Dealer info Start
		vehicleQuotation.setCategory(extDealerSearch.getCategory());
		vehicleQuotation.setCompanyName(extDealerSearch.getCompanyName());
		;
		vehicleQuotation.setStreet(extDealerSearch.getStreet());
		vehicleQuotation.setSuburb(extDealerSearch.getSuburb());
		;
		vehicleQuotation.setDealState(extDealerSearch.getDealState());
		;
		vehicleQuotation.setDealPostCode(extDealerSearch.getDealPostCode());
		;
		vehicleQuotation.setCountry(extDealerSearch.getCountry());
		;
		vehicleQuotation.setPhone(extDealerSearch.getPhone());
		;
		vehicleQuotation.setWebsite(extDealerSearch.getWebsite());
		;
		vehicleQuotation.setMobile(extDealerSearch.getMobile());
		vehicleQuotation.setTollFree(extDealerSearch.getTollFree());
		vehicleQuotation.setFax(extDealerSearch.getFax());
		vehicleQuotation.setAfterHours(extDealerSearch.getAfterHours());
		vehicleQuotation.setPostalAddress(extDealerSearch.getPostalAddress());
		vehicleQuotation.setEmail(extDealerSearch.getEmail());
		vehicleQuotation.setLongitude(extDealerSearch.getLongitude());
		vehicleQuotation.setLatitude(extDealerSearch.getLatitude());
		// Dealer info end

		extDealerServMaintRepository.flush();
		// vehicleQuotation.setCarSearchId(dealerVO.getDealServMaintId()); //
		// user Ebid Id

		// vehicleQuotation.setRefId(vehicleQuotation.getRefId());
		vehicleQuotation.setAutoBid(true);

		// vehicleQuotation.setDealerStockNo(vehicleQuotation.getDealerStockNo());
		// Long l =(long) 0;
		// Ebid Request
		/*
		 * vehicleQuotation.setNewer(dealerVO.isNewer());
		 * vehicleQuotation.setUsed(dealerVO.isUsed());
		 * vehicleQuotation.setPostCode(dealerVO.getPostCode());
		 * vehicleQuotation.setColor(dealerVO.getColor());// color 1
		 * vehicleQuotation.setTransmission(dealerVO.getTransmission()); //
		 * color2 vehicleQuotation.setDriveType(dealerVO.getDriveType());// more
		 * about more requirement vehicleQuotation.setRefId(l);
		 * vehicleQuotation.setAddress(dealerVO.getAddress()); // set image
		 */ servMaintQuotationRepository.save(vehicleQuotation);
		servMaintQuotationRepository.flush();
		return vehicleQuotation;
	}
	// end 
	
	
	
	@PutMapping("dealerQuotSmCreation")
	public ServiceMaintQuotation dealerQuotCreation(@RequestBody ServiceMaintQuotationVO dealerVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to create SM Quotati for Ext Dealer {}", dealerVO);

		ServiceMaintQuotation vehicleQuotation = new ServiceMaintQuotation();
		vehicleQuotation.setOfferValidDate(dealerVO.getOfferValidDate());// set
																			// Offer
																			// Valid
																			// Date
		vehicleQuotation.setDriveAwayPrice(dealerVO.getDriveAwayPrice()); // set
																			// Drive
																			// Away
																			// Price
		vehicleQuotation.setOfferPrice2(dealerVO.getOfferPrice2());// set Save
																	// Price
		vehicleQuotation.setOfferPrice3(dealerVO.getOfferPrice3());// Actual
																	// value of
																	// Offer
		// Offer Details select Template Id from Car Templates via list
		vehicleQuotation.setModelYear(dealerVO.getModelYear());
		vehicleQuotation.setModelDisplay(dealerVO.getModelDisplay());
		vehicleQuotation.setModelName(dealerVO.getModelName());
		vehicleQuotation.setModelTrim(dealerVO.getModelTrim());
		vehicleQuotation.setRegoNo(dealerVO.getRegoNo());
		vehicleQuotation.setRegoStat(dealerVO.getRegoStat());
		vehicleQuotation.setPostCode(dealerVO.getPostCode());
		vehicleQuotation.setFuelType(dealerVO.getFuelType());
		vehicleQuotation.setServMaintL1(dealerVO.getServMaintL1());
		vehicleQuotation.setServMaintL2(dealerVO.getServMaintL2());
		vehicleQuotation.setCoveredUnderIns(dealerVO.isCoveredUnderIns());
		vehicleQuotation.setCurInsProv(dealerVO.getCurInsProv());
		vehicleQuotation.setFlex1(dealerVO.getFlex1());
		vehicleQuotation.setExternal(true);
		// Addition of extras
		// vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		// vehicleQuotation.setFname(dealerVO.getFname()); // Terms and
		// conditions

		vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		vehicleQuotation.setUserId(dealerVO.getUserId());
		vehicleQuotation.setUserCreationDate(dealerVO.getUserCreationDate());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		vehicleQuotation.setCreationDate(ourJavaDateObject);
		// vehicleQuotation.setStatus(true);
		vehicleQuotation.setSearchServMaintId(dealerVO.getSearchServMaintId());
		vehicleQuotation.setDealServMaintId(dealerVO.getDealServMaintId());
		ExtDealServMaintr1 extDealerSearch = extDealerServMaintRepository.findOne(dealerVO.getDealServMaintId());
		extDealerSearch.setStatus(true);
		vehicleQuotation.setDealerId(extDealerSearch.getDealerId()); // Dealer
																		// Lead
																		// Id
		User user = userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getVehicleQuotCt();
		user.setServMaintQuotCt(vehQuotCountTemp + 1);
		// Dealer info Start
		vehicleQuotation.setCategory(extDealerSearch.getCategory());
		vehicleQuotation.setCompanyName(extDealerSearch.getCompanyName());
		;
		vehicleQuotation.setStreet(extDealerSearch.getStreet());
		vehicleQuotation.setSuburb(extDealerSearch.getSuburb());
		;
		vehicleQuotation.setDealState(extDealerSearch.getDealState());
		;
		vehicleQuotation.setDealPostCode(extDealerSearch.getDealPostCode());
		;
		vehicleQuotation.setCountry(extDealerSearch.getCountry());
		;
		vehicleQuotation.setPhone(extDealerSearch.getPhone());
		;
		vehicleQuotation.setWebsite(extDealerSearch.getWebsite());
		;
		vehicleQuotation.setMobile(extDealerSearch.getMobile());
		vehicleQuotation.setTollFree(extDealerSearch.getTollFree());
		vehicleQuotation.setFax(extDealerSearch.getFax());
		vehicleQuotation.setAfterHours(extDealerSearch.getAfterHours());
		vehicleQuotation.setPostalAddress(extDealerSearch.getPostalAddress());
		vehicleQuotation.setEmail(extDealerSearch.getEmail());
		vehicleQuotation.setLongitude(extDealerSearch.getLongitude());
		vehicleQuotation.setLatitude(extDealerSearch.getLatitude());
		// Dealer info end

		extDealerServMaintRepository.flush();
		// vehicleQuotation.setCarSearchId(dealerVO.getDealServMaintId()); //
		// user Ebid Id

		// vehicleQuotation.setRefId(vehicleQuotation.getRefId());
		vehicleQuotation.setAutoBid(true);

		// vehicleQuotation.setDealerStockNo(vehicleQuotation.getDealerStockNo());
		// Long l =(long) 0;
		// Ebid Request
		/*
		 * vehicleQuotation.setNewer(dealerVO.isNewer());
		 * vehicleQuotation.setUsed(dealerVO.isUsed());
		 * vehicleQuotation.setPostCode(dealerVO.getPostCode());
		 * vehicleQuotation.setColor(dealerVO.getColor());// color 1
		 * vehicleQuotation.setTransmission(dealerVO.getTransmission()); //
		 * color2 vehicleQuotation.setDriveType(dealerVO.getDriveType());// more
		 * about more requirement vehicleQuotation.setRefId(l);
		 * vehicleQuotation.setAddress(dealerVO.getAddress()); // set image
		 */ servMaintQuotationRepository.save(vehicleQuotation);
		servMaintQuotationRepository.flush();
		return vehicleQuotation;
	}

	@GetMapping(value = "getExtQtDealSmInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSmListAdminVO getExtQtDealSmInfoId(@RequestParam("searchServMaintId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerSmListAdminVO userAdminSearchVO12 = new ExtQtDealerSmListAdminVO();

		List<ServiceMaintQuotation> users = servMaintQuotationRepository.getDealerSmForID(carSearchId);
		List<ServiceMaintQuotationVO> searchVOs = new ArrayList<ServiceMaintQuotationVO>();
		for (ServiceMaintQuotation search : users) {
			ServiceMaintQuotationVO dealVO = domainModelUtil.toExtQtSmDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtQtDealSmInfoIdInt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSmListAdminVO getExtQtDealSmInfoIdInt(@RequestParam("searchServMaintId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerSmListAdminVO userAdminSearchVO12 = new ExtQtDealerSmListAdminVO();

		List<ServiceMaintQuotation> users = servMaintQuotationRepository.getDealerSmForIDInt(carSearchId);
		List<ServiceMaintQuotationVO> searchVOs = new ArrayList<ServiceMaintQuotationVO>();
		for (ServiceMaintQuotation search : users) {
			ServiceMaintQuotationVO dealVO = domainModelUtil.toExtQtSmDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "getExtQtDealSmInfoIdDealrId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSmListAdminVO getExtQtDealSmInfoId(@RequestParam("searchServMaintId") Long carSearchId, @RequestParam("dealerId") Long dealerId) {
		LOGGER.debug("Received request to get Dealer car Search id {} for External", carSearchId);
		ExtQtDealerSmListAdminVO userAdminSearchVO12 = new ExtQtDealerSmListAdminVO();

		List<ServiceMaintQuotation> users = servMaintQuotationRepository.getDealerSmForDealIdExt(carSearchId, dealerId);
		List<ServiceMaintQuotationVO> searchVOs = new ArrayList<ServiceMaintQuotationVO>();
		for (ServiceMaintQuotation search : users) {
			ServiceMaintQuotationVO dealVO = domainModelUtil.toExtQtSmDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtQtDealSmInfoIdDealrIdInt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSmListAdminVO getExtQtDealSmInfoIdInt(@RequestParam("searchServMaintId") Long carSearchId, @RequestParam("dealerId") Long dealerId) {
		LOGGER.debug("Received request to get Dealer car Search id {} for Internal", carSearchId);
		ExtQtDealerSmListAdminVO userAdminSearchVO12 = new ExtQtDealerSmListAdminVO();

		List<ServiceMaintQuotation> users = servMaintQuotationRepository.getDealerSmForDealIdInt(carSearchId, dealerId);
		List<ServiceMaintQuotationVO> searchVOs = new ArrayList<ServiceMaintQuotationVO>();
		for (ServiceMaintQuotation search : users) {
			ServiceMaintQuotationVO dealVO = domainModelUtil.toExtQtSmDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	
}
