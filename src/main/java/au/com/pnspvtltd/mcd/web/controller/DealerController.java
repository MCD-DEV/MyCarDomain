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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.DealerEBidVO;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealServMaint;
import au.com.pnspvtltd.mcd.domain.ExtDealServMaintr1;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchFin;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchIns;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearchTp;
import au.com.pnspvtltd.mcd.domain.ExternalDealer;
import au.com.pnspvtltd.mcd.domain.ExternalDealerFin;
import au.com.pnspvtltd.mcd.domain.ExternalDealerIns;
import au.com.pnspvtltd.mcd.domain.ExternalDealerTp;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.LoyalityProgAdmin;
import au.com.pnspvtltd.mcd.domain.QuotationFeatList;
import au.com.pnspvtltd.mcd.domain.VehicleDealerServMaintDetails;
import au.com.pnspvtltd.mcd.domain.VehicleDealerTranspDetails;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetails;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsInv;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsServ;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsTransp;
import au.com.pnspvtltd.mcd.domain.VehicleServHypList;
import au.com.pnspvtltd.mcd.domain.VehicleServSpareList;
import au.com.pnspvtltd.mcd.domain.VehicleSocialList;
import au.com.pnspvtltd.mcd.domain.VehicleTranpHypList;
import au.com.pnspvtltd.mcd.repository.DealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerFinRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerInsRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerServMaintPRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerServMaintRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerTranspRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerFinRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerInsRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerRepositoryFin;
import au.com.pnspvtltd.mcd.repository.ExternalDealerTpRepository;
import au.com.pnspvtltd.mcd.repository.InventoryRepository;
import au.com.pnspvtltd.mcd.repository.LoyalityProgAdminRepository;
import au.com.pnspvtltd.mcd.repository.VehicleResourceDetailsRepo;
import au.com.pnspvtltd.mcd.repository.VehicleServMasterRepo;
import au.com.pnspvtltd.mcd.repository.VehicleTranspMasterRepo;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.AdminStatusVO;
import au.com.pnspvtltd.mcd.web.model.AdminVerifyVO;
import au.com.pnspvtltd.mcd.web.model.DealerDetailsVO;
import au.com.pnspvtltd.mcd.web.model.DealerFinanceMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerInsuranceMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerLoginVO;
import au.com.pnspvtltd.mcd.web.model.DealerResourceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.DealerServMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerSubscriptionSBLVO;
import au.com.pnspvtltd.mcd.web.model.DealerTranpMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealServMaintr1VO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerFinLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerFinListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerInsLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerInsListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchFinVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchInsVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchTpVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerServMaintVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerServMtListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSvLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerTpLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerTranspListAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerFinListVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerFinVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerInsListVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerInsVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerSmVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerTpListVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerTpVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityListVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.LoyalAdminSearchVO;
import au.com.pnspvtltd.mcd.web.model.LoyalityProgAdminVO;
import au.com.pnspvtltd.mcd.web.model.QuotationFeatListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerInsuranceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerServMaintDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerTranspDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsInvVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsServVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsTranspVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleServHypListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleServSpareListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleSocialListVO;
import au.com.pnspvtltd.mcd.web.model.VehicleTranpHypListVO;

//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "*")
@CrossOrigin
@RestController
public class DealerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerController.class);

	@Autowired
	DealerService dealerService;

	@Autowired
	DealerSearchRepository dealerSearchRepository;

	@Autowired
	ExtDealerSearchRepository extDealerSearchRepository;
	@Autowired
	ExtDealerServMaintRepository extDealerServMaintRepository;
	@Autowired
	ExtDealerServMaintPRepository extDealerServMaintPRepository;
	@Autowired
	ExtDealerTranspRepository extDealerTranspRepository;
	@Autowired
	ExtDealerFinRepository extDealerFinRepository;
	@Autowired
	ExtDealerInsRepository extDealerInsRepository;

	@Autowired
	ExternalDealerRepository externalDealerRepository;
	@Autowired
	ExternalDealerTpRepository externalDealerTpRepository;
	@Autowired
	ExternalDealerFinRepository externalDealerFinRepository;

	@Autowired
	ExternalDealerInsRepository externalDealerInsRepository;

	@Autowired
	LoyalityProgAdminRepository loyalityProgAdminRepository;

	@Autowired
	ExternalDealerRepositoryFin externalDealerepositoryFin;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private VehicleResourceDetailsRepo vehicleResourceDetailsRepo;
	@Autowired
	private VehicleServMasterRepo vehicleServMasterRepo;
	@Autowired
	private VehicleTranspMasterRepo vehicleTranspMasterRepo;
	@Autowired
	DomainModelUtil domainModelUtil;

	@PostMapping(value = "interDeal/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerVO> login(@RequestBody DealerLoginVO adminAutoVO, HttpServletResponse response) {
		LOGGER.debug("Dealer tries to register", adminAutoVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<DealerVO> responseSuc;
		DealerVO createdDealer;
		createdDealer = dealerService.findByEmailIgnoreCase(adminAutoVO.getEmail());
		if (createdDealer == null) {
			createdDealer = dealerService.createDealerLogin(adminAutoVO);
			response.setStatus(HttpStatus.CREATED.value());
			responseSuc =new ResponseEntity<>(createdDealer, status);
		} else {
			status = HttpStatus.CONFLICT;
			//status = HttpStatus.NO_CONTENT;
			responseSuc =new ResponseEntity<>(null, status);
		}
		/*response.setStatus(HttpStatus.CREATED.value());
		//return new ResponseEntity<>(createdDealer, status);
*/		
		return responseSuc;

	}

	@PostMapping(value = "interDeal/verify", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerVO> verify(@RequestBody DealerLoginVO adminAutoVO, HttpServletResponse response) {
		LOGGER.debug("Dealer tries to login", adminAutoVO.getEmail());
		DealerVO user = dealerService.findByEmailIgnoreCase(adminAutoVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		if (user == null) {
			status = HttpStatus.NO_CONTENT;
		} else if (!user.getPassword().equals(adminAutoVO.getPassword())) {
			status = HttpStatus.UNAUTHORIZED;
			user = null;
		} else {
			user.setPassword(null);
		}
		user = dealerService.findById(user.getDealerId());
		return new ResponseEntity<>(user, status);
	}

	@GetMapping(value = "dealer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerVO getDealer(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get Dealer with id {} ", id);
		DealerVO dealer = dealerService.findById(id);
		if (dealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return dealer;
	}

	@PostMapping("eBid/dealercar")
	public String eBidForCar(@RequestBody DealerEBidVO dealerEBidVO) {
		return dealerService.whenDealerEBidForCar(dealerEBidVO);
	}

	@GetMapping(value = "adminlylall", produces = { MediaType.APPLICATION_JSON_VALUE })
	public LoyalAdminSearchVO adminlylall() {
		LOGGER.debug("Received request to get all loyality with id {} ");
		LoyalAdminSearchVO userAdminSearchVO12 = new LoyalAdminSearchVO();

		List<LoyalityProgAdminVO> userVOs = new ArrayList<LoyalityProgAdminVO>();

		List<LoyalityProgAdmin> users = loyalityProgAdminRepository.getAllSearchCriteria();
		for (LoyalityProgAdmin user : users) {
			userVOs.add(domainModelUtil.fromLoyalProg(user));

		}
		userAdminSearchVO12.setUserVO(userVOs);

		return userAdminSearchVO12;
	}

	@PutMapping("loyalityUpdate")
	@Transactional
	public LoyalityProgAdminVO loyalityUpdate(@RequestBody LoyalityProgAdminVO vehicleQuotationVO,
			HttpServletResponse response) {
		// TODO: create a service for VehicleQutotation to update quotation
		// details
		LOGGER.debug("Received request to update loyality {}", vehicleQuotationVO.getLoyalityProgramId());
		if (vehicleQuotationVO != null) {
			LoyalityProgAdmin vehicleQuotation = loyalityProgAdminRepository
					.findOne(vehicleQuotationVO.getLoyalityProgramId());

			vehicleQuotation.setRevName(vehicleQuotationVO.getRevName());
			vehicleQuotation.setRevAction1(vehicleQuotationVO.getRevAction1());
			vehicleQuotation.setRevDivByAct1(vehicleQuotationVO.getRevDivByAct1());
			vehicleQuotation.setRevDivByAct2(vehicleQuotationVO.getRevDivByAct2());
			vehicleQuotation.setBlogName(vehicleQuotationVO.getBlogName());
			vehicleQuotation.setBlogAction1(vehicleQuotationVO.getBlogAction1());
			vehicleQuotation.setBlogDivByAct1(vehicleQuotationVO.getBlogDivByAct1());
			vehicleQuotation.setBlogDivByAct2(vehicleQuotationVO.getBlogDivByAct2());
			vehicleQuotation.setReferredName(vehicleQuotationVO.getReferredName());
			vehicleQuotation.setReferredAction1(vehicleQuotationVO.getReferredAction1());
			vehicleQuotation.setReferredDivByAct1(vehicleQuotationVO.getReferredDivByAct1());
			vehicleQuotation.setReferredDivByAct2(vehicleQuotationVO.getReferredDivByAct2());
			vehicleQuotation.setUserReferName(vehicleQuotationVO.getUserReferName());
			vehicleQuotation.setUserReferAction1(vehicleQuotationVO.getUserReferAction1());
			vehicleQuotation.setUserReferDivByAct1(vehicleQuotationVO.getUserReferDivByAct1());
			vehicleQuotation.setUserReferDivByAct2(vehicleQuotationVO.getUserReferDivByAct2());
			vehicleQuotation.setTypeOfTrans(vehicleQuotationVO.getTypeOfTrans());
			vehicleQuotation.setBuyCarAction1(vehicleQuotationVO.getBuyCarAction1());
			vehicleQuotation.setBuyCarDivByAct1(vehicleQuotationVO.getBuyCarDivByAct1());
			vehicleQuotation.setBuyCarDivByAct2(vehicleQuotationVO.getBuyCarDivByAct2());
			vehicleQuotation.setTypeOfSell(vehicleQuotationVO.getTypeOfSell());
			vehicleQuotation.setSellCarAction1(vehicleQuotationVO.getSellCarAction1());
			vehicleQuotation.setSellCarDivByAct1(vehicleQuotationVO.getSellCarDivByAct1());
			vehicleQuotation.setSellCarDivByAct2(vehicleQuotationVO.getSellCarDivByAct2());
			vehicleQuotation.setTypeOfFin(vehicleQuotationVO.getTypeOfFin());
			vehicleQuotation.setFinCarAction1(vehicleQuotationVO.getFinCarAction1());
			vehicleQuotation.setFinCarDivByAct1(vehicleQuotationVO.getFinCarDivByAct1());
			vehicleQuotation.setFinCarDivByAct2(vehicleQuotationVO.getFinCarDivByAct2());
			vehicleQuotation.setTypeOfIns(vehicleQuotationVO.getTypeOfIns());
			vehicleQuotation.setInsCarAction1(vehicleQuotationVO.getInsCarAction1());
			vehicleQuotation.setInsCarDivByAct1(vehicleQuotationVO.getInsCarDivByAct1());
			vehicleQuotation.setInsCarDivByAct2(vehicleQuotationVO.getInsCarDivByAct2());
			vehicleQuotation.setTypeOfTrnp(vehicleQuotationVO.getTypeOfTrnp());
			vehicleQuotation.setTranspCarAction1(vehicleQuotationVO.getTranspCarAction1());
			vehicleQuotation.setTranspCarDivByAct1(vehicleQuotationVO.getTranspCarDivByAct1());
			vehicleQuotation.setTranspCarDivByAct2(vehicleQuotationVO.getTranspCarDivByAct2());
			vehicleQuotation.setTypeOfServ(vehicleQuotationVO.getTypeOfServ());
			vehicleQuotation.setServCarAction1(vehicleQuotationVO.getServCarAction1());
			vehicleQuotation.setServCarDivByAct1(vehicleQuotationVO.getServCarDivByAct1());
			vehicleQuotation.setServCarDivByAct2(vehicleQuotationVO.getServCarDivByAct2());
			vehicleQuotation.setStatus(vehicleQuotationVO.isStatus());
			loyalityProgAdminRepository.flush();
			// vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return vehicleQuotationVO;
	}

	@PostMapping("dealer")
	public DealerVO createDealer(@RequestBody DealerVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Dealer with email {}", dealerVO.getEmail());
		DealerVO createdDealer = dealerService.createDealer(dealerVO);
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.findById(createdDealer.getDealerId());
		// createdDealer;
	}

	@PutMapping("dealer")
	public DealerVO updateDealer(@RequestBody DealerVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update Dealer {}", dealerVO);
		DealerVO updatedDealer = dealerService.updateDealer(dealerVO);
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}

	@GetMapping(value = "dealer", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerVO> getAllDealers(HttpServletResponse response) {
		LOGGER.debug("Received request to get all Dealers");
		List<DealerVO> delares = dealerService.findAllDealers();
		if (delares.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return delares;
	}

	@PostMapping(value = "dealer/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerVO> login(@RequestBody DealerVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Dealer with email {} tries to login", dealerVO.getEmail());
		DealerVO dealer = dealerService.findDealerByEmail(dealerVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		if (dealer == null) {
			status = HttpStatus.NO_CONTENT;
		} else if (!dealer.getPassword().equals(dealerVO.getPassword())) {
			status = HttpStatus.UNAUTHORIZED;
			dealer = null;
		} else {
			dealer.setPassword(null);
		}
		return new ResponseEntity<>(dealer, status);
	}

	@PostMapping("dealer/addInventory")
	public String addInventory(@RequestBody InventoryVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add inventory by the Dealer with Id {}", inventoryVO.getRefId());
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.addInventory(inventoryVO);
	}

	/**
	 * Update Inventory
	 * 
	 * @param inventoryVO
	 * @param response
	 * @return
	 */

	@PutMapping("dealer/updateInventory")
	@Transactional
	public InventoryVO updateInventory(@RequestBody InventoryVO inventoryVO, HttpServletResponse response) {
		Inventory user = new Inventory();
		LOGGER.debug("Received request to update inventory {}", inventoryVO.getRepoId());
		// TODO: create a service for VehicleQutotation to update quotation
		// details
		if (inventoryVO != null) {
			user = inventoryRepository.findOne(inventoryVO.getRepoId());

			user.setModelYear(inventoryVO.getModelYear());
			user.setModelDisplay(inventoryVO.getModelDisplay());
			user.setModelName(inventoryVO.getModelName());
			user.setModelTrim(inventoryVO.getModelTrim());
			user.setExtColour(inventoryVO.getExtColour());
			user.setIntColour(inventoryVO.getIntColour());
			user.setDemo(inventoryVO.isDemo());
			user.setRoadWorthIncluded(inventoryVO.isRoadWorthIncluded());
			user.setRegistrationIncluded(inventoryVO.isRegistrationIncluded());
			user.setAutoQuote(inventoryVO.isAutoQuote());
			user.setClassified(inventoryVO.isClassified());
			user.setTypeOfCar(inventoryVO.getTypeOfCar());
			// user.setVehicleDescription(inventoryVO.getVehicleDescription());
			user.setVariant(inventoryVO.getVariant());

			user.setPrice(inventoryVO.getPrice());
			user.setRegNo(inventoryVO.getRegNo());

			user.setKilometer(inventoryVO.getKilometer());
			user.setRegExpiryDate(inventoryVO.getRegExpiryDate());
			user.setVinNumber(inventoryVO.getVinNumber());
			user.setVendorStockNo(inventoryVO.getVendorStockNo());
			user.setState(inventoryVO.getState());
			user.setDealAmountMin(inventoryVO.getDealAmountMin());
			user.setDealAmountMax(inventoryVO.getDealAmountMax());
			user.setVehicleDescriptin(inventoryVO.getVehicleDescriptin());
			user.setVendorStockNoString(inventoryVO.getVendorStockNoString());
			user.setAdditionalDetails(inventoryVO.getAdditionalDetails());
			user.setNewCar(inventoryVO.isNewCar());
			// user.setStockItem(inventoryVO.getStockItem());
			// user.setDealerId(inventoryVO.getDealerId());
			user.setUserId(inventoryVO.getUserId());
			// user.setQuotationFeatList(inventoryVO.getQuotationFeatList());

			List<QuotationFeatListVO> qvo = inventoryVO.getQuotationFeatList();
			List<QuotationFeatList> quoList = new ArrayList<QuotationFeatList>();

			Iterator<QuotationFeatListVO> it = qvo.iterator();
			for (; it.hasNext();) {
				QuotationFeatListVO local = it.next();
				QuotationFeatList quo = new QuotationFeatList();
				try {
					BeanUtils.copyProperties(quo, local);
					quoList.add(quo);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setQuotationFeatList(quoList);
				//inventoryRepository.flush();

				//ssssssssssssssss
			}
			
			
			List<VehicleResourceDetailsInvVO> qvo1 = inventoryVO.getVehicleResourcDetails();
			List<VehicleResourceDetailsInv> quoList1 = new ArrayList<VehicleResourceDetailsInv>();

			Iterator<VehicleResourceDetailsInvVO> it1 = qvo1.iterator();
			for (; it1.hasNext();) {
				VehicleResourceDetailsInvVO local = it1.next();
				VehicleResourceDetailsInv quo1 = new VehicleResourceDetailsInv();
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
			user.setVehicleResourcDetails(quoList1);

			}
			
			inventoryRepository.save(user);
		}
		return inventoryVO;
	}

	@PostMapping("dealer/addInventoryUser")
	public String addInventoryUser(@RequestBody InventoryVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add inventory by the Dealer with Id {}", inventoryVO.getRefId());
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.addInventoryUser(inventoryVO);
	}

	@PostMapping("dealer/addInventoryList")
	public String addInventoryList(@RequestBody InventoryListVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add inventory List by the Dealer with Id {}");
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.addInventoryList(inventoryVO);
	}

	@PostMapping("dealer/addProductList")
	public String addProductList(@RequestBody FinanceEntityListVO financeEntityVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add financeEntity List by the Dealer with Id {}");
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.addFinanceEntityList(financeEntityVO);
	}

	@PostMapping("dealer/updateStatus")
	public String updateStatus(@RequestBody AdminStatusVO financeEntityVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update Status {}");
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.updateStatus(financeEntityVO);
	}

	@GetMapping(value = "dealer/getExistStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public AdminVerifyVO getExistStatus(@PathVariable Long id) {
		LOGGER.debug("Received request to get Exist Status id {} ", id);
		return dealerService.getExistStatus(id);
	}

	@GetMapping(value = "dealer/{id}/inventory", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<InventoryVO> getInventory(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Inventory with id {} ", id);
		return dealerService.getInventory(id);
	}

	@GetMapping(value = "dealer/{id}/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchVO> getDealerSearch(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search with id {} ", id);
		return dealerService.getDealerSearch(id);
	}

	@GetMapping(value = "dealer/search/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchVO getDealerSearchId(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search for unique with id {} ", id);
		return dealerService.getDealerSearchUnique(id);

	}

	@GetMapping(value = "dealer/{id}/searchInsurance", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchInsuranceVO> getDealerSearchInsurance(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search Insurance with id {} ", id);
		return dealerService.getDealerSearchInsurance(id);
	}

	@GetMapping(value = "dealer/{id}/searchFinance", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchFinanceVO> getDealerSearchFinance(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", id);
		return dealerService.getDealerSearchFinance(id);
	}

	@GetMapping(value = "dealer/{id}/vehicleQuotation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<VehicleQuotationVO> getDealerVehicleQuotation(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Vehicle Quotation with id {} ", id);
		return dealerService.getDealerVehicleQuotation(id);
	}

	@GetMapping(value = "dealer/{id}/insuranceQuotation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<InsuranceQuotationVO> getDealerInsuranceQuotation(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Insurance Quotation with id {} ", id);
		return dealerService.getDealerInsuranceQuotation(id);
	}

	@GetMapping(value = "dealer/{id}/financeQuotation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FinanceQuotationVO> getDealerFinanceQuotation(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Finance Quotation with id {} ", id);
		return dealerService.getDealerFinanceQuotation(id);
	}

	@PutMapping("dealerLeadCreation")
	public DealerSearch dealerLeadCreation(@RequestBody DealerSearchAdminVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update Dealer {}", dealerVO);

		DealerSearch updatedDealer = dealerService.dealerAdminLead(dealerVO);
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}

	@PutMapping("extDealerLeadCreation")
	public ResponseEntity<ExtDealerSearchLdAdminVO> extDealerLeadCreation(
			@RequestBody ExtDealerSearchLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Lead {}", extDealerVO);

		String updatedDealer = dealerService.extDealerAdminLead(extDealerVO);
		HttpStatus status = HttpStatus.NO_CONTENT;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			status = HttpStatus.OK;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(extDealerVO, status);
	}

	@PutMapping("extDealerSvLeadCreation")
	public ResponseEntity<ExtDealerSvLdAdminVO> extDealerSvLeadCreation(@RequestBody ExtDealerSvLdAdminVO extDealerVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Sv Lead {}", extDealerVO);

		String updatedDealer = dealerService.extDealerSvAdminLead(extDealerVO);
		// Dealer does not exist
		HttpStatus status = HttpStatus.NO_CONTENT;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			status = HttpStatus.OK;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(extDealerVO, status);
	}

	@PutMapping("extDealerTpLeadCreation")
	public ResponseEntity<ExtDealerTpLdAdminVO> extDealerTpLeadCreation(@RequestBody ExtDealerTpLdAdminVO extDealerVO,
			HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Tp Lead {}", extDealerVO);

		String updatedDealer = dealerService.extDealerTpAdminLead(extDealerVO);
		// String updatedDealer = null;
		// Dealer does not exist
		HttpStatus status = HttpStatus.NO_CONTENT;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			status = HttpStatus.OK;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(extDealerVO, status);
	}

	@PutMapping("extDealerInsLeadCreation")
	public ResponseEntity<ExtDealerInsLdAdminVO> extDealerInsLeadCreation(
			@RequestBody ExtDealerInsLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Fin Lead {}", extDealerVO);

		String updatedDealer = dealerService.extDealerInsAdminLead(extDealerVO);
		// String updatedDealer = null;
		// Dealer does not exist
		HttpStatus status = HttpStatus.NO_CONTENT;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			status = HttpStatus.OK;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(extDealerVO, status);
	}

	@PutMapping("extDealerFinLeadCreation")
	public ResponseEntity<ExtDealerFinLdAdminVO> extDealerFinLeadCreation(
			@RequestBody ExtDealerFinLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Fin Lead {}", extDealerVO);

		String updatedDealer = dealerService.extDealerFinAdminLead(extDealerVO);
		// String updatedDealer = null;
		// Dealer does not exist
		HttpStatus status = HttpStatus.NO_CONTENT;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			status = HttpStatus.OK;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(extDealerVO, status);
	}

	@GetMapping(value = "getExtDealSearchInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerSearchListAdminVO getExtDealSearchInfoId(@RequestParam("carSearchId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtDealerSearchListAdminVO userAdminSearchVO12 = new ExtDealerSearchListAdminVO();

		List<ExtDealerSearch> users = extDealerSearchRepository.getDealerSearchForID(carSearchId);
		List<ExtDealerSearchVO> searchVOs = new ArrayList<ExtDealerSearchVO>();
		for (ExtDealerSearch search : users) {
			ExtDealerSearchVO dealVO = domainModelUtil.toExtDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealServMtInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerServMtListAdminVO getExtDealServMtInfoId(@RequestParam("searchServMaintId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car searchServMaintId id {} ", carSearchId);
		ExtDealerServMtListAdminVO userAdminSearchVO12 = new ExtDealerServMtListAdminVO();

		List<ExtDealServMaintr1> users = extDealerServMaintRepository.getDealerSearchForID(carSearchId);
		List<ExtDealServMaintr1VO> searchVOs = new ArrayList<ExtDealServMaintr1VO>();
		for (ExtDealServMaintr1 search : users) {
			ExtDealServMaintr1VO dealVO = domainModelUtil.toExtDealerServMaintVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealTrnpInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerTranspListAdminVO getExtDealTrnpInfoId(@RequestParam("searchTranspId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car tranport id {} ", carSearchId);
		ExtDealerTranspListAdminVO userAdminSearchVO12 = new ExtDealerTranspListAdminVO();

		List<ExtDealerSearchTp> users = extDealerTranspRepository.getDealerSearchForID(carSearchId);
		List<ExtDealerSearchTpVO> searchVOs = new ArrayList<ExtDealerSearchTpVO>();
		for (ExtDealerSearchTp search : users) {
			ExtDealerSearchTpVO dealVO = domainModelUtil.toExtDealerTranspVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealFinInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerFinListAdminVO getExtDealFinInfoId(@RequestParam("searchFinanceId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car tranport id {} ", carSearchId);
		ExtDealerFinListAdminVO userAdminSearchVO12 = new ExtDealerFinListAdminVO();

		List<ExtDealerSearchFin> users = extDealerFinRepository.getDealerSearchForID(carSearchId);
		List<ExtDealerSearchFinVO> searchVOs = new ArrayList<ExtDealerSearchFinVO>();
		for (ExtDealerSearchFin search : users) {
			ExtDealerSearchFinVO dealVO = domainModelUtil.toExtDealerFinVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealInsInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerInsListAdminVO getExtDealInsInfoId(@RequestParam("searchInsuranceId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car insurancE id {} ", carSearchId);
		ExtDealerInsListAdminVO userAdminSearchVO12 = new ExtDealerInsListAdminVO();

		List<ExtDealerSearchIns> users = extDealerInsRepository.getDealerSearchForID(carSearchId);
		List<ExtDealerSearchInsVO> searchVOs = new ArrayList<ExtDealerSearchInsVO>();
		for (ExtDealerSearchIns search : users) {
			ExtDealerSearchInsVO dealVO = domainModelUtil.toExtDealerInsVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "dealerIDs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Long> getDealerIDs() {

		LOGGER.info("Received request to get All Dealer Ids");
		return dealerService.getDealerIDs();

	}

	@GetMapping(value = "dealerInfoforID", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerDetailsVO getDealerForID(@RequestParam("dealerID") Long dealerID) {
		LOGGER.info("Received request to get Dealer info for Dealer Id");
		return domainModelUtil.toDealerDetailsVO(dealerService.getDealerForID(dealerID));
	}

	@GetMapping(value = "getDealSearchInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchListAdminVO getSearchInfor(@RequestParam("carSearchId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		DealerSearchListAdminVO userAdminSearchVO12 = new DealerSearchListAdminVO();

		List<DealerSearch> users = dealerSearchRepository.getDealerSearchForID(carSearchId);
		List<DealerSearchVO> searchVOs = new ArrayList<DealerSearchVO>();
		for (DealerSearch search : users) {
			DealerSearchVO dealVO = domainModelUtil.toDealerSearchVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setDealerSearchVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealSearch", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSearchVO getExtDealSearch(@RequestParam("category") String category,
			@RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Search id {} ");
		ExternalDealerSearchVO userAdminSearchVO12 = new ExternalDealerSearchVO();

		List<ExternalDealer> users = externalDealerRepository.getSearchCatPost(category, postCode);
		List<ExternalDealerVO> searchVOs = new ArrayList<ExternalDealerVO>();
		for (ExternalDealer search : users) {
			ExternalDealerVO dealVO = domainModelUtil.toExternalDealerVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtDealNu", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSearchVO getExtDealNu(@RequestParam("category") String category,
			@RequestParam("state") String state) {
		LOGGER.debug("Received request to get External Dealer for New Used id {} ");
		ExternalDealerSearchVO userAdminSearchVO12 = new ExternalDealerSearchVO();

		List<ExternalDealer> users = externalDealerRepository.getSearchState(category, state);
		List<ExternalDealerVO> searchVOs = new ArrayList<ExternalDealerVO>();
		for (ExternalDealer search : users) {
			ExternalDealerVO dealVO = domainModelUtil.toExternalDealerVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	
	@GetMapping(value = "getExtDealTpSt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerTpListVO getExtDealTpSt(@RequestParam("category") String category,
			@RequestParam("state") String state) {
		LOGGER.debug("Received request to get External Dealer Tranport State id {} ");
		ExternalDealerTpListVO userAdminSearchVO12 = new ExternalDealerTpListVO();

		List<ExternalDealerTp> users = externalDealerTpRepository.getSearchCatPost(category, state);
		List<ExternalDealerTpVO> searchVOs = new ArrayList<ExternalDealerTpVO>();
		for (ExternalDealerTp search : users) {
			ExternalDealerTpVO dealVO = domainModelUtil.toExternalDealerTpVO1(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	
	
	@GetMapping(value = "getExtDealTp", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerTpListVO getExtDealTp(@RequestParam("category") String category,
			@RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer s&m id {} ");
		ExternalDealerTpListVO userAdminSearchVO12 = new ExternalDealerTpListVO();

		List<ExternalDealerTp> users = externalDealerTpRepository.getSearchCatPost(category, postCode);
		List<ExternalDealerTpVO> searchVOs = new ArrayList<ExternalDealerTpVO>();
		for (ExternalDealerTp search : users) {
			ExternalDealerTpVO dealVO = domainModelUtil.toExternalDealerTpVO1(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	// start of Finance and state
	// start of Finance
	@GetMapping(value = "getExtDealFinSt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerFinListVO getExtDealFinSt(@RequestParam("category") String category,
			@RequestParam("state") String state) {
		LOGGER.debug("Received request to get External Dealer Fin id and State{} ");
		ExternalDealerFinListVO userAdminSearchVO12 = new ExternalDealerFinListVO();

		List<ExternalDealerFin> users = externalDealerFinRepository.getSearchCatPost(category, state);
		List<ExternalDealerFinVO> searchVOs = new ArrayList<ExternalDealerFinVO>();
		for (ExternalDealerFin search : users) {
			ExternalDealerFinVO dealVO = domainModelUtil.toExternalDealerFinVO1(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	// end of Finance and State
	
	
	
	// start of Finance
	@GetMapping(value = "getExtDealFin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerFinListVO getExtDealFin(@RequestParam("category") String category,
			@RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Fin id {} ");
		ExternalDealerFinListVO userAdminSearchVO12 = new ExternalDealerFinListVO();

		List<ExternalDealerFin> users = externalDealerFinRepository.getSearchCatPost(category, postCode);
		List<ExternalDealerFinVO> searchVOs = new ArrayList<ExternalDealerFinVO>();
		for (ExternalDealerFin search : users) {
			ExternalDealerFinVO dealVO = domainModelUtil.toExternalDealerFinVO1(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	
	// starrt of Insurance and state
		@GetMapping(value = "getExtDealInsSt", produces = { MediaType.APPLICATION_JSON_VALUE })
		public ExternalDealerInsListVO getExtDealInsSt(@RequestParam("category") String category,
				@RequestParam("string") String state) {
			LOGGER.debug("Received request to get External Dealer Ins and state id {} ");
			ExternalDealerInsListVO userAdminSearchVO12 = new ExternalDealerInsListVO();

			List<ExternalDealerIns> users = externalDealerInsRepository.getSearchCatSt(category, state);
			List<ExternalDealerInsVO> searchVOs = new ArrayList<ExternalDealerInsVO>();
			for (ExternalDealerIns search : users) {
				ExternalDealerInsVO dealVO = domainModelUtil.toExternalDealerInsVO1(search);
				searchVOs.add(dealVO);
			}
			userAdminSearchVO12.setExternalDealerVO(searchVOs);

			return userAdminSearchVO12;
		}
	
	
	
	// starrt of Insurance
	@GetMapping(value = "getExtDealIns", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerInsListVO getExtDealIns(@RequestParam("category") String category,
			@RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Ins id {} ");
		ExternalDealerInsListVO userAdminSearchVO12 = new ExternalDealerInsListVO();

		List<ExternalDealerIns> users = externalDealerInsRepository.getSearchCatPost(category, postCode);
		List<ExternalDealerInsVO> searchVOs = new ArrayList<ExternalDealerInsVO>();
		for (ExternalDealerIns search : users) {
			ExternalDealerInsVO dealVO = domainModelUtil.toExternalDealerInsVO1(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	@GetMapping(value = "getExtDealSmSt", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSmVO getExtDealSmSt(@RequestParam("category") String category,
			@RequestParam("state") String state) {
		LOGGER.debug("Received request to get External Dealer s&m state id {} ");
		ExternalDealerSmVO userAdminSearchVO12 = new ExternalDealerSmVO();

		List<ExtDealServMaint> users = extDealerServMaintPRepository.getSearchCatSt(category, state);
		List<ExtDealerServMaintVO> searchVOs = new ArrayList<ExtDealerServMaintVO>();
		for (ExtDealServMaint search : users) {
			ExtDealerServMaintVO dealVO = domainModelUtil.toExternalDealerSmVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "getExtDealSM", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSmVO getExtDealSM(@RequestParam("category") String category,
			@RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer s&m id {} ");
		ExternalDealerSmVO userAdminSearchVO12 = new ExternalDealerSmVO();

		List<ExtDealServMaint> users = extDealerServMaintPRepository.getSearchCatPost(category, postCode);
		List<ExtDealerServMaintVO> searchVOs = new ArrayList<ExtDealerServMaintVO>();
		for (ExtDealServMaint search : users) {
			ExtDealerServMaintVO dealVO = domainModelUtil.toExternalDealerSmVO(search);
			searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);

		return userAdminSearchVO12;
	}

	@PostMapping(value = "extdealerCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerVO> extdealerCreation(@RequestBody ExternalDealerVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation", userVO.getCategory());
		userVO.setExternalDealerId(null);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerVO externalDealerVO = domainModelUtil
				.toExternalDealerVO(externalDealerRepository.save(domainModelUtil.toExternalDealer(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	@PostMapping(value = "extdealerTpCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerTpVO> extdealerTpCreation(@RequestBody ExternalDealerTpVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Transport", userVO.getCategory());
		userVO.setExternalDealerId(null);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerTpVO externalDealerVO = domainModelUtil
				.toExternalDealerTpVO(externalDealerTpRepository.save(domainModelUtil.toExternalDealerTp(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	@PostMapping(value = "extdealerFinCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerFinVO> extdealerFinCreation(@RequestBody ExternalDealerFinVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Finance", userVO.getCategory());
		userVO.setExternalDealerId(null);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerFinVO externalDealerVO = domainModelUtil
				.toExternalDealerFinVO(externalDealerepositoryFin.save(domainModelUtil.toExternalDealerFin(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	@PostMapping(value = "extdealerInsCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerInsVO> extdealerInsCreation(@RequestBody ExternalDealerInsVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Insurance", userVO.getCategory());
		userVO.setExternalDealerId(null);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerInsVO externalDealerVO = domainModelUtil
				.toExternalDealerInsVO(externalDealerInsRepository.save(domainModelUtil.toExternalDealerIns(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	@PostMapping(value = "loyalPrgCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LoyalityProgAdminVO> loyalPrgCreation(@RequestBody LoyalityProgAdminVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("Loyality program Creation");

		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		LoyalityProgAdminVO externalDealerVO = domainModelUtil
				.toLoyalityProgramVO(loyalityProgAdminRepository.save(domainModelUtil.toLoyalityProgram(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	@PostMapping(value = "extdealerSvCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExtDealerServMaintVO> extdealerSvCreation(@RequestBody ExtDealerServMaintVO userVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Sv", userVO.getCategory());
		userVO.setExternalDealerId(null);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExtDealerServMaintVO externalDealerVO = domainModelUtil
				.toExternalDealerSvVO(extDealerServMaintPRepository.save(domainModelUtil.toExternalDealerSv(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);

	}

	/* Subscription Starts */
	@PostMapping(value = "dealer/SubscribeSBL", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSubscriptionSBLVO createVehicleDealerSBL(@RequestBody DealerSubscriptionSBLVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Sv", dealerSubscriptionSBLVO.getDealerId());
		DealerSubscriptionSBLVO createdDealer = dealerService.createVehicleDealerSBL(dealerSubscriptionSBLVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdDealer;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}

	/* Subscription Starts */
	@PostMapping(value = "dealer/ServiceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerServMasterVO createDealerServMaster(@RequestBody DealerServMasterVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("Dealer Service Master Creation for Sv", dealerSubscriptionSBLVO.getDealerId());
		DealerServMasterVO createdDealer = dealerService.createDealerServMaster(dealerSubscriptionSBLVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdDealer;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}

	@GetMapping(value = "dealer/getServiceMaster/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public VehicleDealerServMaintDetailsVO getServiceMasterId(@PathVariable Long id, HttpServletResponse response) {
		return dealerService.getServiceMasterId(id);
	}

	@GetMapping(value = "dealer/{id}/ServiceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<VehicleDealerServMaintDetailsVO> getServiceMaster(@PathVariable Long id) {
		LOGGER.debug("Received request to get Service Master with id {} ", id);
		return dealerService.getServMast(id);
	}

	// start of Transport
	@PostMapping(value = "dealer/TranspMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerTranpMasterVO createDealerTranpMaster(@RequestBody DealerTranpMasterVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("Dealer Tranport Master Creation for Transp", dealerSubscriptionSBLVO.getDealerId());
		DealerTranpMasterVO createdDealer = dealerService.createDealerTranpMaster(dealerSubscriptionSBLVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdDealer;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}

	@GetMapping(value = "dealer/getTranspMaster/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public VehicleDealerTranspDetailsVO getTranspMasterId(@PathVariable Long id, HttpServletResponse response) {
		return dealerService.getTranspMasterId(id);
	}

	@GetMapping(value = "dealer/{id}/TransportMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<VehicleDealerTranspDetailsVO> getTransportMaster(@PathVariable Long id) {
		LOGGER.debug("Received request to get Transport Master with id {} ", id);
		return dealerService.getTranspMast(id);
	}
	// end of Transport

	// start of Finance
	@PostMapping(value = "dealer/FinanceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerFinanceMasterVO createDealerFinMaster(@RequestBody DealerFinanceMasterVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("Dealer Finance Master Creation for Transp", dealerSubscriptionSBLVO.getDealerId());
		DealerFinanceMasterVO createdDealer = dealerService.createDealerFinanceMaster(dealerSubscriptionSBLVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdDealer;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}

	@GetMapping(value = "dealer/getFinanceMaster/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public FinanceEntityVO getFinMasterId(@PathVariable Long id, HttpServletResponse response) {
		return dealerService.getFinanceMasterId(id);
	}

	@GetMapping(value = "dealer/{id}/FinanceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FinanceEntityVO> getFinanceMaster(@PathVariable Long id) {
		LOGGER.debug("Received request to get Finance Master with id {} ", id);
		return dealerService.getFinanceMast(id);
	}
	// end of Finance
	
	// start of Insurance
		@PostMapping(value = "dealer/InsuranceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
		public DealerInsuranceMasterVO createDealerInsMaster(@RequestBody DealerInsuranceMasterVO dealerSubscriptionSBLVO,
				HttpServletResponse response) {
			LOGGER.debug("Dealer Insurance Master Creation for Transp", dealerSubscriptionSBLVO.getDealerId());
			DealerInsuranceMasterVO createdDealer = dealerService.createDealerInsuranceMaster(dealerSubscriptionSBLVO);
			response.setStatus(HttpStatus.CREATED.value());
			return createdDealer;
			// createdDealer dealerService.findById(createdDealer.getDealerId());
		}

		@GetMapping(value = "dealer/getInsuranceeMaster/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
		public VehicleDealerInsuranceDetailsVO getInsMasterId(@PathVariable Long id, HttpServletResponse response) {
			return dealerService.getInsMasterId(id);
		}

		@GetMapping(value = "dealer/{id}/InsuranceMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<VehicleDealerInsuranceDetailsVO> getInsuranceeMaster(@PathVariable Long id) {
			LOGGER.debug("Received request to get Insurance Master with id {} ", id);
			return dealerService.getInsuranceMast(id);
		}
		// end of Insurance

	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "dealer/Resource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerResourceVO createVehicleResource(@RequestBody DealerResourceVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("Dealer Creation for Resource", dealerSubscriptionSBLVO.getDealerId());
		DealerResourceVO createdDealer = dealerService.createDealerResource(dealerSubscriptionSBLVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdDealer;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}

	@GetMapping(value = "dealer/getResource/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public VehicleResourceDetailsVO getDealerResourcebyID(@PathVariable Long id, HttpServletResponse response) {
		return dealerService.getDealerResourcebyID(id);
	}

	@GetMapping(value = "dealer/{id}/resource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<VehicleResourceDetailsVO> getResource(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Resources with id {} ", id);
		return dealerService.getResource(id);
	}

	/**
	 * Update Resource
	 * 
	 * @param vehicleResourceVO
	 * @param response
	 * @return
	 */

	@PutMapping("dealer/updateResource")
	@Transactional
	public VehicleResourceDetailsVO updateInventory(@RequestBody VehicleResourceDetailsVO inventoryVO,
			HttpServletResponse response) {
		VehicleResourceDetails user = new VehicleResourceDetails();
		LOGGER.debug("Received request to update resource {}", inventoryVO.getVehicleResourceDetailId());
		// TODO: create a service for VehicleQutotation to update quotation
		// details
		if (inventoryVO != null) {
			user = vehicleResourceDetailsRepo.findOne(inventoryVO.getVehicleResourceDetailId());
			user.setContactPerson(inventoryVO.getContactPerson());

			user.setDesignation(inventoryVO.getDesignation());
			user.setContactNumber1(inventoryVO.getContactNumber1());
			user.setContactNumber2(inventoryVO.getContactNumber2());
			user.setEmail(inventoryVO.getEmail());
			user.setAdditionalInfo(inventoryVO.getAdditionalInfo());
			user.setLastName(inventoryVO.getLastName());
			user.setTitle(inventoryVO.getTitle());
			user.setEmployeeCode(inventoryVO.getEmployeeCode());
			user.setId(inventoryVO.getId());
			List<VehicleSocialListVO> qvo = inventoryVO.getVehicleSocialList();
			List<VehicleSocialList> quoList = new ArrayList<VehicleSocialList>();

			Iterator<VehicleSocialListVO> it = qvo.iterator();
			for (; it.hasNext();) {
				VehicleSocialListVO local = it.next();
				VehicleSocialList quo = new VehicleSocialList();
				try {
					BeanUtils.copyProperties(quo, local);
					quoList.add(quo);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setVehicleSocialList(quoList);

			}
			
			vehicleResourceDetailsRepo.save(user);
			//vehicleResourceDetailsRepo.flush();
			// user.setAreaName(userMyVehicleVO.); // phone number
			// vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}

		return inventoryVO;
	}
	
	/**
	 * Update service Master
	 * 
	 * @param vehicleResourceVO
	 * @param response
	 * @return
	 */
	/* Subscription Starts */
	@PutMapping("dealer/updateServiceMaster")
	@Transactional
	public VehicleDealerServMaintDetailsVO updateServiceMas(@RequestBody VehicleDealerServMaintDetailsVO inventoryVO,
			HttpServletResponse response) {
		VehicleDealerServMaintDetails user = new VehicleDealerServMaintDetails();
		LOGGER.debug("Received request to update service Master {}", inventoryVO.getVehicleDealerServMaintDetailId());
		
		if (inventoryVO != null) {
			user = vehicleServMasterRepo.findOne(inventoryVO.getVehicleDealerServMaintDetailId());
			try {
				BeanUtils.copyProperties(user, inventoryVO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*user.setVehicleType(inventoryVO.getVehicleType());
			user.setPetrol(inventoryVO.isPetrol());
			user.setDiesel(inventoryVO.isDiesel());
			user.setElectric(inventoryVO.isElectric());
			user.setAll1(inventoryVO.isAll1());
			user.setClientPlaceDriveYes(inventoryVO.isClientPlaceDriveYes());
			user.setClientPlaceDriveMaybe(inventoryVO.isClientPlaceDriveMaybe());
			user.setClientPlaceDriveNo(inventoryVO.isClientPlaceDriveNo());
			user.setRoadAssistance(inventoryVO.isRoadAssistance());
			user.setServMastLevel1(inventoryVO.getServMastLevel1());
			user.setServMastLevel2(inventoryVO.getServMastLevel2());
			user.setServMastLevel3(inventoryVO.getServMastLevel3());
			
			user.setCompanyName(inventoryVO.getCompanyName());
			user.setCompanyDesc(inventoryVO.getCompanyDesc());
			user.setCompanyAddress(inventoryVO.getCompanyAddress());
			user.setCompanyWeb(inventoryVO.getCompanyWeb());
			
			
			user.setFixedPrice(inventoryVO.isFixedPrice());
			user.setHourlyRate(inventoryVO.isHourlyRate());
			user.setPartFixPartHr(inventoryVO.isPartFixPartHr());
			user.setAutoQuote(inventoryVO.isAutoQuote());
			user.setAddAutoAddCom(inventoryVO.isAddAutoAddCom());
			user.setBrowComSec(inventoryVO.isBrowComSec());
			
			user.setEstHourFix(inventoryVO.getEstHourFix());
			user.setMinChargHr(inventoryVO.getMinChargHr());
			user.setHourRate(inventoryVO.getHourRate());
			user.setFixHours(inventoryVO.getFixHours());
			user.setFixedRate(inventoryVO.getFixedRate());
			user.setEstHoursPartFix(inventoryVO.getEstHoursPartFix());
			user.setRateforExtHr(inventoryVO.getRateforExtHr());
			user.setClientPlaceDrCharg(inventoryVO.getClientPlaceDrCharg());
			
			user.setIndividual(inventoryVO.isIndividual());
			user.setLicensedBroker(inventoryVO.isLicensedBroker());
			user.setServMaintInstitute(inventoryVO.isServMaintInstitute());
			user.setNewCar(inventoryVO.isNewCar());
			user.setUsedCar(inventoryVO.isUsedCar());
			user.setBoth(inventoryVO.isBoth());
			
			user.setSubsType(inventoryVO.getSubsType());*/
			
			
			List<VehicleResourceDetailsServVO> qvo = inventoryVO.getVehicleResourceDetails();
			List<VehicleResourceDetailsServ> quoList = new ArrayList<VehicleResourceDetailsServ>();

			Iterator<VehicleResourceDetailsServVO> it = qvo.iterator();
			for (; it.hasNext();) {
				VehicleResourceDetailsServVO local = it.next();
				VehicleResourceDetailsServ quo = new VehicleResourceDetailsServ();
				try {
					BeanUtils.copyProperties(quo, local);


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
						quo.setVehicleSocialList(quoList22);

					}
					
					quoList.add(quo);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				 user.setVehicleResourceDetails(quoList);

			}
			
			List<VehicleServSpareListVO> qvo1 = inventoryVO.getVehicleDealerServSpareList();
			List<VehicleServSpareList> quoList1 = new ArrayList<VehicleServSpareList>();

			Iterator<VehicleServSpareListVO> it1 = qvo1.iterator();
			for (; it1.hasNext();) {
				VehicleServSpareListVO local = it1.next();
				VehicleServSpareList quo1 = new VehicleServSpareList();
				try {
					BeanUtils.copyProperties(quo1, local);
					quoList1.add(quo1);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setVehicleDealerServSpareList(quoList1);

			}
			
			List<VehicleServHypListVO> qvo2 = inventoryVO.getVehicleDealerServHypList();
			List<VehicleServHypList> quoList2 = new ArrayList<VehicleServHypList>();

			Iterator<VehicleServHypListVO> it2 = qvo2.iterator();
			for (; it2.hasNext();) {
				VehicleServHypListVO local = it2.next();
				VehicleServHypList quo2 = new VehicleServHypList();
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
				user.setVehicleDealerServHypList(quoList2);

			}
			
			VehicleDealerServMaintDetails dealer = vehicleServMasterRepo.save(user);
			//vehicleServMasterRepo.flush();
			
			
			
			// user.setAreaName(userMyVehicleVO.); // phone number
			// vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}

		return inventoryVO;
	}
	
	
	/**
	 * Update transport Master
	 * 
	 * @param vehicleResourceVO
	 * @param response
	 * @return
	 */
	/* Subscription Starts */
	@PutMapping("dealer/updateTranspMaster")
	@Transactional
	public VehicleDealerTranspDetailsVO updateServiceMas(@RequestBody VehicleDealerTranspDetailsVO inventoryVO,
			HttpServletResponse response) {
		VehicleDealerTranspDetails user = new VehicleDealerTranspDetails();
		LOGGER.debug("Received request to update transport Master {}", inventoryVO.getVehicleDealerTranspDetailId());
		
		if (inventoryVO != null) {
			user = vehicleTranspMasterRepo.findOne(inventoryVO.getVehicleDealerTranspDetailId());
			try {
				BeanUtils.copyProperties(user, inventoryVO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<VehicleResourceDetailsTranspVO> qvo = inventoryVO.getVehicleResourceDetails();
			List<VehicleResourceDetailsTransp> quoList = new ArrayList<VehicleResourceDetailsTransp>();

			Iterator<VehicleResourceDetailsTranspVO> it = qvo.iterator();
			for (; it.hasNext();) {
				VehicleResourceDetailsTranspVO local = it.next();
				VehicleResourceDetailsTransp quo = new VehicleResourceDetailsTransp();
				try {
					BeanUtils.copyProperties(quo, local);
					
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
						quo.setVehicleSocialList(quoList22);

					}
					
					quoList.add(quo);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 user.setVehicleResourceDetails(quoList);

			}
			
			List<VehicleTranpHypListVO> qvo1 = inventoryVO.getVehicleDealerTranpHypList();
			List<VehicleTranpHypList> quoList1 = new ArrayList<VehicleTranpHypList>();

			Iterator<VehicleTranpHypListVO> it1 = qvo1.iterator();
			for (; it1.hasNext();) {
				VehicleTranpHypListVO local = it1.next();
				VehicleTranpHypList quo1 = new VehicleTranpHypList();
				try {
					BeanUtils.copyProperties(quo1, local);
					quoList1.add(quo1);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			user.setVehicleDealerTranpHypList(quoList1);

			}
			
			
			VehicleDealerTranspDetails dealer = vehicleTranspMasterRepo.save(user);
			//return domainModelUtil.fromDealer(dealer, true);
			
			//vehicleTranspMasterRepo.flush();
			
			
			
			// user.setAreaName(userMyVehicleVO.); // phone number
			// vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}

		return inventoryVO;
	}

	
	
	//pulling dealerIds from VehicleDealerDetails
	@GetMapping(value = "dealerIDs/{subscriptionType}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Long> getDealerIDs(@PathVariable String subscriptionType){
		return dealerService.getDealerIDs(subscriptionType);
	}
}
