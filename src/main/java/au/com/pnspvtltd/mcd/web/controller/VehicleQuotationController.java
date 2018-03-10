package au.com.pnspvtltd.mcd.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.SearchFinance;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocs;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDrive;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.VehQuotExtras;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsInv;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsQuo;
import au.com.pnspvtltd.mcd.domain.VehicleServHypList;
import au.com.pnspvtltd.mcd.domain.VehicleServSpareList;
import au.com.pnspvtltd.mcd.domain.VehicleSocialList;
import au.com.pnspvtltd.mcd.repository.DealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.UserSearchLeadRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerInsuranceMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExtQtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaDocVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaReqTestDriveVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerInsuranceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsInvVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsQuoVO;
import au.com.pnspvtltd.mcd.web.model.VehicleServHypListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleServSpareListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleSocialListVO;

//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "*")
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
	private UserSearchLeadRepository userSearchLeadRepository;
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
	
	@PutMapping("vehicleQuotationUpd")
	@Transactional
	public VehicleQuotationVO updVehicleQuotation(@RequestBody VehicleQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update total VehicleQuotation {}", vehicleQuotationVO.getQuotId());
	    //TODO: create a service for VehicleQutotation to update quotation details
		if(vehicleQuotationVO != null){
			VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(vehicleQuotationVO.getQuotId());
			vehicleQuotation.setRegoEndDate(vehicleQuotationVO.getRegoEndDate());// set Offer Valid Date
			vehicleQuotation.setDriveAwayPrice(vehicleQuotationVO.getDriveAwayPrice()); // set Drive Away Price
			vehicleQuotation.setOfferPrice2(vehicleQuotationVO.getOfferPrice2());// set Save Price
			vehicleQuotation.setOfferPrice3(vehicleQuotationVO.getOfferPrice3());// Actual value of Offer
			// Offer Details select Template Id from Car Templates via list
			vehicleQuotation.setModelYear(vehicleQuotationVO.getModelYear());
			vehicleQuotation.setModelDisplay(vehicleQuotationVO.getModelDisplay());
			vehicleQuotation.setModelName(vehicleQuotationVO.getModelName());
			vehicleQuotation.setModelTrim(vehicleQuotationVO.getModelTrim());
			vehicleQuotation.setVehQuotExtras(vehicleQuotationVO.getVehQuotExtras());
			vehicleQuotation.setVehQuotDoc(vehicleQuotationVO.getVehQuotDoc());
			vehicleQuotation.setOfferDateList(vehicleQuotationVO.getOfferDateList());
			// start of logic change of ID to resourceDetail
			/*List<VehicleResourceDetailsQuo> vehicleResourceDetailsQuos= vehicleQuotationVO.getVehicleResourcDetails();
			List<VehicleResourceDetailsQuo> chVehicleResourceDetailsQuos = new ArrayList<VehicleResourceDetailsQuo>();
			for (VehicleResourceDetailsQuo search : vehicleResourceDetailsQuos) {
				search.setId(search.getVehicleResourceDetailId().toString());
				search.setVehicleResourceDetailId(null);
				chVehicleResourceDetailsQuos.add(search);
			}
			vehicleQuotation.setVehicleResourcDetails(chVehicleResourceDetailsQuos);*/
			
			List<VehicleResourceDetailsQuoVO> qvo1 = vehicleQuotationVO.getVehicleResourcDetails();
			List<VehicleResourceDetailsQuo> quoList1 = new ArrayList<VehicleResourceDetailsQuo>();

			Iterator<VehicleResourceDetailsQuoVO> it1 = qvo1.iterator();
			for (; it1.hasNext();) {
				VehicleResourceDetailsQuoVO local = it1.next();
				VehicleResourceDetailsQuo quo1 = new VehicleResourceDetailsQuo();
				try {
					BeanUtils.copyProperties(quo1, local);
					
					List<VehicleSocialListVO> qvo22 = local.getVehicleSocialList();
					List<VehicleSocialList> quoList22 = new ArrayList<VehicleSocialList>();

					Iterator<VehicleSocialListVO> it22 = qvo22.iterator();
					for (; it22.hasNext();) {
						VehicleSocialListVO local22 = it22.next();
						VehicleSocialList quo22 = new VehicleSocialList();
						try {
							BeanUtils.copyProperties(quo22, local22);
							quoList22.add(quo22);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						quo1.setVehicleSocialList(quoList22);

					}
					
					
					quoList1.add(quo1);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vehicleQuotation.setVehicleResourcDetails(quoList1);

			}
			
			
			
			vehicleQuotation.setVehQuotExtras(vehicleQuotationVO.getVehQuotExtras());
			vehicleQuotation.setVehQuotDoc(vehicleQuotationVO.getVehQuotDoc());
			vehicleQuotation.setVehQuotTerm(vehicleQuotationVO.getVehQuotTerm());
			vehicleQuotation.setOfferDateList(vehicleQuotationVO.getOfferDateList());
						
			
			
			
			
			
			if (vehicleQuotationVO.getUserQuotaDocs() != null) {
			List<UserQuotaDocVO> qvo2 = vehicleQuotationVO.getUserQuotaDocs();
			List<UserQuotaDocs> quoList2 = new ArrayList<UserQuotaDocs>();

			Iterator<UserQuotaDocVO> it2 = qvo2.iterator();
			for (; it2.hasNext();) {
				UserQuotaDocVO local = it2.next();
				UserQuotaDocs quo2 = new UserQuotaDocs();
				try {
					BeanUtils.copyProperties(quo2, local);
					quoList2.add(quo2);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vehicleQuotation.setUserQuotaDocs(quoList2);

			}
			}
			if (vehicleQuotationVO.getUserQuotaReqTestDrive() != null) {
			List<UserQuotaReqTestDriveVO> qvo3 = vehicleQuotationVO.getUserQuotaReqTestDrive();
			List<UserQuotaReqTestDrive> quoList3 = new ArrayList<UserQuotaReqTestDrive>();

			Iterator<UserQuotaReqTestDriveVO> it3 = qvo3.iterator();
			for (; it3.hasNext();) {
				UserQuotaReqTestDriveVO local = it3.next();
				UserQuotaReqTestDrive quo3 = new UserQuotaReqTestDrive();
				try {
					BeanUtils.copyProperties(quo3, local);
					quoList3.add(quo3);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vehicleQuotation.setUserQuotaReqTestDrive(quoList3);

			}
			}
			if (vehicleQuotationVO.getUserQuotationHistoryVO() != null){
			List<UserQuotationHistoryVO> qvo4 = vehicleQuotationVO.getUserQuotationHistoryVO();
			List<UserQuotationHistory> quoList4 = new ArrayList<UserQuotationHistory>();

			Iterator<UserQuotationHistoryVO> it4 = qvo4.iterator();
			for (; it4.hasNext();) {
				UserQuotationHistoryVO local = it4.next();
				UserQuotationHistory quo4 = new UserQuotationHistory();
				try {
					BeanUtils.copyProperties(quo4, local);
					quoList4.add(quo4);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vehicleQuotation.setUserQuotationHistory(quoList4);

			}
			}
			
			
			
			vehicleQuotation.setVehQuotTerm(vehicleQuotationVO.getVehQuotTerm());
			vehicleQuotation.setFname(vehicleQuotationVO.getFname()); // Terms and conditions
			vehicleQuotation.setBasicPrice(vehicleQuotationVO.getBasicPrice()); // set Basic Price
			
			vehicleQuotationRepository.save(vehicleQuotation);
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
		// start of logic change of ID to resourceDetail
		List<VehicleResourceDetailsQuoVO> vehicleResourceDetailsQuos= dealerVO.getVehicleResourcDetails();
		List<VehicleResourceDetailsQuo> chVehicleResourceDetailsQuos = new ArrayList<VehicleResourceDetailsQuo>();
		for (VehicleResourceDetailsQuoVO search : vehicleResourceDetailsQuos) {
			search.setId(search.getVehicleResourceDetailId().toString());
			search.setVehicleResourceDetailId(null);
			VehicleResourceDetailsQuo th = new VehicleResourceDetailsQuo();
			
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
		//vehicleQuotation.setDealSearchId(dealerVO.getCarSearchId());
		DealerSearch extDealerSearch=dealerSearchRepository.findOne(dealerVO.getDealSearchId());
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
		vehicleQuotation.setDealPostCode(extDealerSearch.getsPostCode());;
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
		vehicleQuotation.setColor(extDealerSearch.getsCarColor());
		vehicleQuotation.setDriveType(extDealerSearch.getState());
		vehicleQuotation.setIdCheck(extDealerSearch.isIdCheck());
		vehicleQuotation.setCredStat(extDealerSearch.isCredStat());
		vehicleQuotation.setMobCheck(extDealerSearch.isMobCheck());
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
		vehicleQuotation.setInternal(true);
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
		Search search=userSearchLeadRepository.findOne(dealerVO.getCarSearchId());
		
		vehicleQuotation.setModelYear(search.getModelYear());
		vehicleQuotation.setModelDisplay(search.getModelDisplay());
		vehicleQuotation.setModelName(search.getModelName());
		vehicleQuotation.setModelTrim(search.getModelTrim());
		
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
		vehicleQuotation.setExternal(true);
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
	
	@GetMapping(value = "getExtQtSearchInfoIdDealrIdExt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtQtDealerSearchListAdminVO getExtQtDealSearchInfoIdExt(@RequestParam("leadId") Long carSearchId, @RequestParam("dealerId") Long dealerId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtQtDealerSearchListAdminVO userAdminSearchVO12 = new ExtQtDealerSearchListAdminVO();

		List<VehicleQuotation> users = vehicleQuotationRepository.getDealerSearchDealIDExt(carSearchId, dealerId);
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
