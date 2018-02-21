package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearchTp;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.repository.ExtDealerTpRepository;
import au.com.pnspvtltd.mcd.repository.TranspServQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerTpListAdminVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;

//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
// @CrossOrigin(origins = "*")
@RestController
public class TranspQuotationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TranspQuotationController.class);

	@Autowired
	TranspServQuotationRepository servMaintQuotationRepository;
	@Autowired
	ExtDealerTpRepository extDealerServMaintRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	DomainModelUtil domainModelUtil;

	/*
	 * @PutMapping("servMaintQuotation")
	 * 
	 * @Transactional public ServiceMaintQuotationVO
	 * updateVehicleQuotation(@RequestBody ServiceMaintQuotationVO
	 * vehicleQuotationVO, HttpServletResponse response) { LOGGER.debug(
	 * "Received request to update VehicleQuotation {}",
	 * vehicleQuotationVO.getServMaintQuotId()); //TODO: create a service for
	 * VehicleQutotation to update quotation details if(vehicleQuotationVO !=
	 * null){ ServiceMaintQuotation vehicleQuotation =
	 * servMaintQuotationRepository.findOne(vehicleQuotationVO.
	 * getServMaintQuotId());
	 * vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser()); }
	 * return vehicleQuotationVO; }
	 */

	@PutMapping("dealerQuotTpCreation")
	public TranspServiceQuotation dealerQuotTpCreation(@RequestBody TranspServiceQuotationVO dealerVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to create Tp Quotati for Ext Dealer {}", dealerVO);

		TranspServiceQuotation vehicleQuotation = new TranspServiceQuotation();
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
		/*
		 * vehicleQuotation.setRegoNo(dealerVO.getRegoNo());
		 * vehicleQuotation.setRegoStat(dealerVO.getRegoStat());
		 * vehicleQuotation.setPostCode(dealerVO.getPostCode());
		 * vehicleQuotation.setFuelType(dealerVO.getFuelType());
		 * vehicleQuotation.setServMaintL1(dealerVO.getServMaintL1());
		 * vehicleQuotation.setServMaintL2(dealerVO.getServMaintL2());
		 * vehicleQuotation.setCoveredUnderIns(dealerVO.isCoveredUnderIns());
		 * vehicleQuotation.setCurInsProv(dealerVO.getCurInsProv());
		 */
		vehicleQuotation.setFlex1(dealerVO.getFlex1());

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
		vehicleQuotation.setUserTranspServId(dealerVO.getUserTranspServId());
		vehicleQuotation.setDealTranspServId(dealerVO.getDealTranspServId());
		ExtDealerSearchTp extDealerSearch = extDealerServMaintRepository.findOne(dealerVO.getDealTranspServId());
		extDealerSearch.setStatus(true);
		vehicleQuotation.setDealerId(extDealerSearch.getDealerId()); // Dealer
																		// Lead
																		// Id
		vehicleQuotation.setFromPostCodeAddr(extDealerSearch.getFromPostCodeAddr());
		vehicleQuotation.setToPostCodeAddr(extDealerSearch.getToPostCodeAddr());
		vehicleQuotation.setTransTypeReq(extDealerSearch.getTransTypeReq());
		vehicleQuotation.setPickUpDateTime(extDealerSearch.getPickUpDateTime());
		vehicleQuotation.setNoOfCars(extDealerSearch.getNoOfCars());
		vehicleQuotation.setYear(extDealerSearch.getYear());
		vehicleQuotation.setMake(extDealerSearch.getMake());
		vehicleQuotation.setModel(extDealerSearch.getModel());
		vehicleQuotation.setVariant(extDealerSearch.getVariant());
		vehicleQuotation.setFreeText(extDealerSearch.getFreeText());
		vehicleQuotation.setTranspInsReq(extDealerSearch.isTranspInsReq());
		vehicleQuotation.setHowMay(extDealerSearch.getHowMay());
		vehicleQuotation.setFromStreetNo(extDealerSearch.getFromStreetNo());
		vehicleQuotation.setToStreetName(extDealerSearch.getToStreetName());
		vehicleQuotation.setToStreetNo(extDealerSearch.getToStreetNo());
		vehicleQuotation.setFromStreetName(extDealerSearch.getFromStreetName());
		vehicleQuotation.setKindOfTransport(extDealerSearch.getKindOfTransport());
		vehicleQuotation.setFlexWithDateDefault(extDealerSearch.isFlexWithDateDefault());
		vehicleQuotation.setUploadPhotos(extDealerSearch.getUploadPhotos());
		vehicleQuotation.setPhoto(extDealerSearch.getPhoto());
		vehicleQuotation.setRegoNo(extDealerSearch.getRegoNo());
		vehicleQuotation.setRegoState(extDealerSearch.getRegoState());
		vehicleQuotation.setUserTranspServId(extDealerSearch.getCarSearchId());

		User user = userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getTranspServQuotCt();
		user.setTranspServQuotCt(vehQuotCountTemp + 1);
		// Dealer info Start
		vehicleQuotation.setCategory(extDealerSearch.getCategory());
		vehicleQuotation.setCompanyName(extDealerSearch.getCompanyName());
		;
		vehicleQuotation.setStreet(extDealerSearch.getStreet());
		vehicleQuotation.setSuburb(extDealerSearch.getSuburb());
		;
		vehicleQuotation.setDealState(extDealerSearch.getDealState());
		;
		vehicleQuotation.setDealPostCode(extDealerSearch.getPostCode());
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

	@GetMapping(value = "getExtQtDealTpInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerTpListAdminVO getExtQtDealTpInfoId(@RequestParam("searchTranpsId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerTpListAdminVO userAdminSearchVO12 = new ExtQtDealerTpListAdminVO();

		List<TranspServiceQuotation> users = servMaintQuotationRepository.getDealerSmForID(carSearchId);
		List<TranspServiceQuotationVO> searchVOs = new ArrayList<TranspServiceQuotationVO>();
		for (TranspServiceQuotation search : users) {
			TranspServiceQuotationVO dealVO = domainModelUtil.toExtQtTpDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtQtDealTpInfoIdDealrId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerTpListAdminVO getExtQtDealTpInfoId(@RequestParam("searchTranpsId") Long carSearchId, @RequestParam("dealerId") Long dealerId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerTpListAdminVO userAdminSearchVO12 = new ExtQtDealerTpListAdminVO();

		List<TranspServiceQuotation> users = servMaintQuotationRepository.getDealerSmForIDDealId(carSearchId, dealerId);
		List<TranspServiceQuotationVO> searchVOs = new ArrayList<TranspServiceQuotationVO>();
		for (TranspServiceQuotation search : users) {
			TranspServiceQuotationVO dealVO = domainModelUtil.toExtQtTpDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);

		return userAdminSearchVO12;
	}
}
