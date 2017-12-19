package au.com.pnspvtltd.mcd.web.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.ExtDealServMaintr1;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchFin;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchIns;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchTp;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehQuotExtras;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.ExtDealerFinRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerInsRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerServMaintRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerTpRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerTpRepository;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.ServMaintQuotationRepository;
import au.com.pnspvtltd.mcd.repository.TranspServQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerFinListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerInsListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerSmListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerTpListAdminVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "*")
@RestController
public class InsQuotationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsQuotationController.class);

	@Autowired
	InsuranceQuotationRepository servMaintQuotationRepository;
	@Autowired
	ExtDealerInsRepository extDealerServMaintRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	DomainModelUtil domainModelUtil;
	
	/*@PutMapping("servMaintQuotation")
	@Transactional
	public ServiceMaintQuotationVO updateVehicleQuotation(@RequestBody ServiceMaintQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update VehicleQuotation {}", vehicleQuotationVO.getServMaintQuotId());
	    //TODO: create a service for VehicleQutotation to update quotation details
		if(vehicleQuotationVO != null){
			ServiceMaintQuotation vehicleQuotation = servMaintQuotationRepository.findOne(vehicleQuotationVO.getServMaintQuotId());
			vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return vehicleQuotationVO;
	}*/
	
	@PutMapping("dealerQuotInsCreation")
	public InsuranceQuotation dealerQuotFinCreation(@RequestBody InsuranceQuotationVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Ins Quotati for Ext Dealer {}", dealerVO);
		
		InsuranceQuotation vehicleQuotation = new InsuranceQuotation();
		vehicleQuotation.setOfferValidDate(dealerVO.getOfferValidDate());// set Offer Valid Date
		vehicleQuotation.setDriveAwayPrice(dealerVO.getDriveAwayPrice()); // set Drive Away Price
		vehicleQuotation.setOfferPrice2(dealerVO.getOfferPrice2());// set Save Price
		vehicleQuotation.setOfferPrice3(dealerVO.getOfferPrice3());// Actual value of Offer
		// Offer Details select Template Id from Car Templates via list
		vehicleQuotation.setModelYear(dealerVO.getModelYear());
		vehicleQuotation.setModelDisplay(dealerVO.getModelDisplay());
		vehicleQuotation.setModelName(dealerVO.getModelName());
		vehicleQuotation.setModelTrim(dealerVO.getModelTrim());
		/*vehicleQuotation.setRegoNo(dealerVO.getRegoNo());
		vehicleQuotation.setRegoStat(dealerVO.getRegoStat());
		vehicleQuotation.setPostCode(dealerVO.getPostCode());
		vehicleQuotation.setFuelType(dealerVO.getFuelType());
		vehicleQuotation.setServMaintL1(dealerVO.getServMaintL1());
		vehicleQuotation.setServMaintL2(dealerVO.getServMaintL2());
		vehicleQuotation.setCoveredUnderIns(dealerVO.isCoveredUnderIns());
		vehicleQuotation.setCurInsProv(dealerVO.getCurInsProv());*/
		vehicleQuotation.setFlex1(dealerVO.getFlex1());
		
		// Addition of extras
		//vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		//vehicleQuotation.setFname(dealerVO.getFlex2()); // Terms and conditions
		
		vehicleQuotation.setVehQuotExtras(dealerVO.getVehQuotExtras());
		vehicleQuotation.setUserId(dealerVO.getUserId());
		//vehicleQuotation.setUserCreationDate(dealerVO.getUserCreationDate());
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		//vehicleQuotation.setCreationDate(ourJavaDateObject);
		//vehicleQuotation.setStatus(true);
		vehicleQuotation.setCarSearchId(dealerVO.getCarSearchId());
		vehicleQuotation.setDealSearchId(dealerVO.getDealSearchId());
		ExtDealerSearchIns extDealerSearch=extDealerServMaintRepository.findOne(dealerVO.getDealSearchId());
		extDealerSearch.setStatus(true);
		vehicleQuotation.setDealerId(extDealerSearch.getDealerId()); // Dealer Lead Id
		
		vehicleQuotation.setNewer(extDealerSearch.isNewer());
		vehicleQuotation.setUsed(extDealerSearch.isUsed());
		vehicleQuotation.setPostCode(String.valueOf(extDealerSearch.getPostCode()));
		vehicleQuotation.setInsuranceType(extDealerSearch.getInsuranceType());
		vehicleQuotation.setRegNo(extDealerSearch.getRegNo());
		vehicleQuotation.setRegoState(extDealerSearch.getRegoState());
		vehicleQuotation.setYear(extDealerSearch.getYear());
		
		vehicleQuotation.setMake(extDealerSearch.getMake());
		vehicleQuotation.setModel(extDealerSearch.getModel());
		vehicleQuotation.setVariant(extDealerSearch.getVariant());
		vehicleQuotation.setAutoscoopTrim(extDealerSearch.getAutoscoopTrim());
		vehicleQuotation.setMarketValue(extDealerSearch.getMarketValue());
		vehicleQuotation.setAgreedValue(extDealerSearch.getAgreedValue());
		vehicleQuotation.setFinance(extDealerSearch.isFinance());
		vehicleQuotation.setFinanceProvider(extDealerSearch.getFinanceProvider());
		vehicleQuotation.setDrivingLicenseType(extDealerSearch.getDrivingLicenceType());
		vehicleQuotation.setDrivingLicenseNo(extDealerSearch.getDrivingLicenseNo());
		vehicleQuotation.setDrivingLicenseIssueState(extDealerSearch.getDrivingLicenseIssueState());
		vehicleQuotation.setNoOfAtFaults(extDealerSearch.getNoOfAtFaults());
		vehicleQuotation.setOtherIssues(extDealerSearch.getOtherIssues());
		vehicleQuotation.setCurInsProv(extDealerSearch.getCurInsProv());
		vehicleQuotation.setPrefExcessAmount(extDealerSearch.getPrefExcessAmount());
		vehicleQuotation.setDateOfBirth(extDealerSearch.getDateOfBirth());
		vehicleQuotation.setAgeOfAdditionalDriver(extDealerSearch.getAgeOfAdditionalDriver());
		
		vehicleQuotation.setCarParkedAt(extDealerSearch.getCarParkedAt());
		//vehicleQuotation.setStreetNO(extDealerSearch.getStreetNO());
		vehicleQuotation.setStreetName(extDealerSearch.getStreetName());
		vehicleQuotation.setCarUsedfor(extDealerSearch.getCarUsedfor());
		vehicleQuotation.setTypeOfBusiness(extDealerSearch.getTypeOfBusiness());
		vehicleQuotation.setDriverFirstName(extDealerSearch.getDriverFirstName());
		vehicleQuotation.setDriverLastName(extDealerSearch.getDriverLastName());
		vehicleQuotation.setDriverMobileNo(extDealerSearch.getDriverMobileNo());
		vehicleQuotation.setDriverEmailId(extDealerSearch.getDriverEmailId());
		vehicleQuotation.setLicenseIssueDate(extDealerSearch.getLicenseIssueDate());
		vehicleQuotation.setLastAtFaultClaimDate(extDealerSearch.getLastAtFaultClaimDate());
		vehicleQuotation.setReasonForSuspension(extDealerSearch.getReasonForSuspension());
		vehicleQuotation.setAvgNoOfKmYr(extDealerSearch.getAvgNoOfKmYr());
		vehicleQuotation.setNoOfDrivers(extDealerSearch.getNoOfDrivers());
		vehicleQuotation.setLicenseGotSuspened(extDealerSearch.isLicenseGotSuspened());
		
		// Insurance extra requirements
		vehicleQuotation.setExtNudgeBar(extDealerSearch.isExtNudgeBar());//Emergency accommodation and Transport
		vehicleQuotation.setExtBullBar(extDealerSearch.isExtBullBar()); //Accidental Damage
		vehicleQuotation.setExtsnokel(extDealerSearch.isExtsnokel()); //Essential Temporary Repairs
		vehicleQuotation.setIntNudgeBar(extDealerSearch.isIntNudgeBar()); //Cover Towing Cost
		vehicleQuotation.setIntBullBar(extDealerSearch.isIntBullBar()); //Cover Theft & Fire
		vehicleQuotation.setIntsnokel(extDealerSearch.isIntsnokel());//No Claim Bonus Protection
		vehicleQuotation.setAnyDriver(extDealerSearch.isAnyDriver());//Allow Under 25 Driver
		vehicleQuotation.setFreeWindScreen(extDealerSearch.isFreeWindScreen());//Excess Free wind Screen
		vehicleQuotation.setRoadsideasst(extDealerSearch.isRoadsideasst());//Road Side Assistance
		vehicleQuotation.setRentalCar(extDealerSearch.isRentalCar()); //Excess Free Window Screen
		vehicleQuotation.setNewCarRepl(extDealerSearch.isNewCarRepl());//New Car Replace
		vehicleQuotation.setLifetimeWarrep(extDealerSearch.isLifetimeWarrep());//Life time Warranty repairs
		vehicleQuotation.setHireCar(extDealerSearch.isHireCar());//Hire Car after Accident(if any)
		vehicleQuotation.setBullBar(extDealerSearch.isBullBar());
		vehicleQuotation.setSnokel(extDealerSearch.isSnokel());
		vehicleQuotation.setNudgeBar(extDealerSearch.isNudgeBar()); 
		
		
		User user =userRepository.findOne(dealerVO.getUserId());
		int vehQuotCountTemp = user.getInsuranceQuotCt();
		user.setInsuranceQuotCt(vehQuotCountTemp);
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
					// Dealer info end
		
		
		
		extDealerServMaintRepository.flush();
		//vehicleQuotation.setCarSearchId(dealerVO.getDealServMaintId()); // user Ebid Id
		
		//vehicleQuotation.setRefId(vehicleQuotation.getRefId());
		vehicleQuotation.setAutoBid(true);
		
		//vehicleQuotation.setDealerStockNo(vehicleQuotation.getDealerStockNo());
		Long l =(long) 0;
		// Ebid Request
		/*vehicleQuotation.setNewer(extDealerSearch.isNewer());
		vehicleQuotation.setUsed(extDealerSearch.isUsed());
		vehicleQuotation.setPostCode(String.valueOf(extDealerSearch.getPostCode()));*/
		vehicleQuotation.setColor(dealerVO.getColor());// color 1
		vehicleQuotation.setTransmission(dealerVO.getTransmission()); // color2
		vehicleQuotation.setDriveType(dealerVO.getDriveType());// more about more requirement
		vehicleQuotation.setRefId(l);
		//vehicleQuotation.setAddress(dealerVO.getAddress()); // set image
		servMaintQuotationRepository.save(vehicleQuotation);
		servMaintQuotationRepository.flush();
		return vehicleQuotation;
	}
	
	@GetMapping(value = "getExtQtDealInsInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerInsListAdminVO getExtQtDealInsInfoId(@RequestParam("searchInsuranceId") Long carSearchId) {
		LOGGER.debug("Received request to get Insurance car Search id {} ", carSearchId);
		ExtQtDealerInsListAdminVO userAdminSearchVO12 = new ExtQtDealerInsListAdminVO();

		List<InsuranceQuotation> users = servMaintQuotationRepository.getDealerSmForID(carSearchId);
		List<InsuranceQuotationVO> searchVOs = new ArrayList<InsuranceQuotationVO>();
		for (InsuranceQuotation search : users) {
			InsuranceQuotationVO dealVO= domainModelUtil.toExtQtInsDealerSearchVO(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setServiceMaintQuotationVO(searchVOs);
	
		return userAdminSearchVO12;
	}
}
