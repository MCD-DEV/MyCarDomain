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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.Dealer;
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
import au.com.pnspvtltd.mcd.domain.LoyalityProgAdmin;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
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
import au.com.pnspvtltd.mcd.repository.LoyalityProgAdminRepository;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;
import au.com.pnspvtltd.mcd.web.model.AdminStatusVO;
import au.com.pnspvtltd.mcd.web.model.AdminVerifyVO;
import au.com.pnspvtltd.mcd.web.model.DealerLoginVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchListAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
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
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.LoyalAdminSearchVO;
import au.com.pnspvtltd.mcd.web.model.LoyalityProgAdminVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.UserAdminSearchVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidVO;
import au.com.pnspvtltd.mcd.web.model.UserSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

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
	DomainModelUtil domainModelUtil;
	
	@PostMapping(value = "interDeal/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerVO> login(@RequestBody DealerLoginVO adminAutoVO, HttpServletResponse response) {
		LOGGER.debug("Dealer tries to register", adminAutoVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		DealerVO createdDealer;
		createdDealer = dealerService.findByEmailIgnoreCase(adminAutoVO.getEmail());
		if(createdDealer.getEmail() == null){
			createdDealer = dealerService.createDealerLogin(adminAutoVO);
		}
		else{
			status = HttpStatus.NO_CONTENT;
		}
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(createdDealer,status);
		
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
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update loyality {}", vehicleQuotationVO.getLoyalityProgramId());
				if(vehicleQuotationVO != null){
					LoyalityProgAdmin vehicleQuotation = loyalityProgAdminRepository.findOne(vehicleQuotationVO.getLoyalityProgramId());
					
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
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PostMapping("dealer")
	public DealerVO createDealer(@RequestBody DealerVO dealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create Dealer with email {}", dealerVO.getEmail());
		DealerVO createdDealer = dealerService.createDealer(dealerVO);
		response.setStatus(HttpStatus.CREATED.value());
		return dealerService.findById(createdDealer.getDealerId());
		//createdDealer;
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
	public String extDealerLeadCreation(@RequestBody ExtDealerSearchLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Lead {}", extDealerVO);
		
		String updatedDealer = dealerService.extDealerAdminLead(extDealerVO);
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}
	
	
	@PutMapping("extDealerSvLeadCreation")
	public String extDealerSvLeadCreation(@RequestBody ExtDealerSvLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Sv Lead {}", extDealerVO);
		
		String updatedDealer = dealerService.extDealerSvAdminLead(extDealerVO);
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}
	
	@PutMapping("extDealerTpLeadCreation")
	public String extDealerTpLeadCreation(@RequestBody ExtDealerTpLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Tp Lead {}", extDealerVO);
		
		String updatedDealer = dealerService.extDealerTpAdminLead(extDealerVO);
		//String updatedDealer = null;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}
	
	@PutMapping("extDealerInsLeadCreation")
	public String extDealerInsLeadCreation(@RequestBody ExtDealerInsLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Fin Lead {}", extDealerVO);
		
		String updatedDealer = dealerService.extDealerInsAdminLead(extDealerVO);
		//String updatedDealer = null;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}
	
	@PutMapping("extDealerFinLeadCreation")
	public String extDealerFinLeadCreation(@RequestBody ExtDealerFinLdAdminVO extDealerVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update ext Dealer Fin Lead {}", extDealerVO);
		
		String updatedDealer = dealerService.extDealerFinAdminLead(extDealerVO);
		//String updatedDealer = null;
		// Dealer does not exist
		if (updatedDealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedDealer;
	}
	
	@GetMapping(value = "getExtDealSearchInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExtDealerSearchListAdminVO getExtDealSearchInfoId(@RequestParam("carSearchId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		ExtDealerSearchListAdminVO userAdminSearchVO12 = new ExtDealerSearchListAdminVO();

		List<ExtDealerSearch> users = extDealerSearchRepository.getDealerSearchForID(carSearchId);
		List<ExtDealerSearchVO> searchVOs = new ArrayList<ExtDealerSearchVO>();
		for (ExtDealerSearch search : users) {
		ExtDealerSearchVO dealVO= domainModelUtil.toExtDealerSearchVO(search);
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
			ExtDealServMaintr1VO dealVO= domainModelUtil.toExtDealerServMaintVO(search);
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
			ExtDealerSearchTpVO dealVO= domainModelUtil.toExtDealerTranspVO(search);
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
			ExtDealerSearchFinVO dealVO= domainModelUtil.toExtDealerFinVO(search);
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
			ExtDealerSearchInsVO dealVO= domainModelUtil.toExtDealerInsVO(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExtDealerSearchVO(searchVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "dealerIDs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Long> getDealerIDs(){
		
		LOGGER.info("Received request to get All Dealer Ids");
		return dealerService.getDealerIDs();
		
	}
	
	
	@GetMapping(value = "dealerInfoforID", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerVO getDealerForID(@RequestParam("dealerID") Long dealerID) {
		LOGGER.info("Received request to get Dealer info for Dealer Id");
		return dealerService.getDealerForID(dealerID);
	}
	
	@GetMapping(value = "getDealSearchInfoId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchListAdminVO getSearchInfor(@RequestParam("carSearchId") Long carSearchId) {
		LOGGER.debug("Received request to get Dealer car Search id {} ", carSearchId);
		DealerSearchListAdminVO userAdminSearchVO12 = new DealerSearchListAdminVO();

		List<DealerSearch> users = dealerSearchRepository.getDealerSearchForID(carSearchId);
		List<DealerSearchVO> searchVOs = new ArrayList<DealerSearchVO>();
		for (DealerSearch search : users) {
		DealerSearchVO dealVO= domainModelUtil.toDealerSearchVO(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setDealerSearchVO(searchVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getExtDealSearch", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSearchVO getExtDealSearch(@RequestParam("category") String category, @RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Search id {} ");
		ExternalDealerSearchVO userAdminSearchVO12 = new ExternalDealerSearchVO();

		List<ExternalDealer> users = externalDealerRepository.getSearchCatPost(category,postCode);
		List<ExternalDealerVO> searchVOs = new ArrayList<ExternalDealerVO>();
		for (ExternalDealer search : users) {
		ExternalDealerVO dealVO= domainModelUtil.toExternalDealerVO(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);
	
		return userAdminSearchVO12;
	}

	
	@GetMapping(value = "getExtDealTp", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerTpListVO getExtDealTp(@RequestParam("category") String category, @RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer s&m id {} ");
		ExternalDealerTpListVO userAdminSearchVO12 = new ExternalDealerTpListVO();

		List<ExternalDealerTp> users = externalDealerTpRepository.getSearchCatPost(category,postCode);
		List<ExternalDealerTpVO> searchVOs = new ArrayList<ExternalDealerTpVO>();
		for (ExternalDealerTp search : users) {
			ExternalDealerTpVO dealVO= domainModelUtil.toExternalDealerTpVO1(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);
	
		return userAdminSearchVO12;
	}
// start of Finance
	@GetMapping(value = "getExtDealFin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerFinListVO getExtDealFin(@RequestParam("category") String category, @RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Fin id {} ");
		ExternalDealerFinListVO userAdminSearchVO12 = new ExternalDealerFinListVO();

		List<ExternalDealerFin> users = externalDealerFinRepository.getSearchCatPost(category,postCode);
		List<ExternalDealerFinVO> searchVOs = new ArrayList<ExternalDealerFinVO>();
		for (ExternalDealerFin search : users) {
			ExternalDealerFinVO dealVO= domainModelUtil.toExternalDealerFinVO1(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);
	
		return userAdminSearchVO12;
	}
// starrt of Insurance	
	@GetMapping(value = "getExtDealIns", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerInsListVO getExtDealIns(@RequestParam("category") String category, @RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer Ins id {} ");
		ExternalDealerInsListVO userAdminSearchVO12 = new ExternalDealerInsListVO();

		List<ExternalDealerIns> users = externalDealerInsRepository.getSearchCatPost(category,postCode);
		List<ExternalDealerInsVO> searchVOs = new ArrayList<ExternalDealerInsVO>();
		for (ExternalDealerIns search : users) {
			ExternalDealerInsVO dealVO= domainModelUtil.toExternalDealerInsVO1(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);
	
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "getExtDealSM", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ExternalDealerSmVO getExtDealSM(@RequestParam("category") String category, @RequestParam("postCode") int postCode) {
		LOGGER.debug("Received request to get External Dealer s&m id {} ");
		ExternalDealerSmVO userAdminSearchVO12 = new ExternalDealerSmVO();

		List<ExtDealServMaint> users = extDealerServMaintPRepository.getSearchCatPost(category,postCode);
		List<ExtDealerServMaintVO> searchVOs = new ArrayList<ExtDealerServMaintVO>();
		for (ExtDealServMaint search : users) {
			ExtDealerServMaintVO dealVO= domainModelUtil.toExternalDealerSmVO(search);
		searchVOs.add(dealVO);
		}
		userAdminSearchVO12.setExternalDealerVO(searchVOs);
	
		return userAdminSearchVO12;
	}

	@PostMapping(value = "extdealerCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerVO> extdealerCreation(@RequestBody ExternalDealerVO userVO, HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation", userVO.getCategory());
		userVO.setExternalDealerId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerVO externalDealerVO = domainModelUtil.toExternalDealerVO(externalDealerRepository.save(domainModelUtil.toExternalDealer(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
	
	@PostMapping(value = "extdealerTpCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerTpVO> extdealerTpCreation(@RequestBody ExternalDealerTpVO userVO, HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Transport", userVO.getCategory());
		userVO.setExternalDealerId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerTpVO externalDealerVO = domainModelUtil.toExternalDealerTpVO(externalDealerTpRepository.save(domainModelUtil.toExternalDealerTp(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
	@PostMapping(value = "extdealerFinCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerFinVO> extdealerFinCreation(@RequestBody ExternalDealerFinVO userVO, HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Finance", userVO.getCategory());
		userVO.setExternalDealerId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerFinVO externalDealerVO = domainModelUtil.toExternalDealerFinVO(externalDealerepositoryFin.save(domainModelUtil.toExternalDealerFin(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
	@PostMapping(value = "extdealerInsCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExternalDealerInsVO> extdealerInsCreation(@RequestBody ExternalDealerInsVO userVO, HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Insurance", userVO.getCategory());
		userVO.setExternalDealerId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExternalDealerInsVO externalDealerVO = domainModelUtil.toExternalDealerInsVO(externalDealerInsRepository.save(domainModelUtil.toExternalDealerIns(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
	@PostMapping(value = "loyalPrgCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LoyalityProgAdminVO> loyalPrgCreation(@RequestBody LoyalityProgAdminVO userVO, HttpServletResponse response) {
		LOGGER.debug("Loyality program Creation");
		
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		LoyalityProgAdminVO externalDealerVO = domainModelUtil.toLoyalityProgramVO(loyalityProgAdminRepository.save(domainModelUtil.toLoyalityProgram(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
	@PostMapping(value = "extdealerSvCreation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ExtDealerServMaintVO> extdealerSvCreation(@RequestBody ExtDealerServMaintVO userVO, HttpServletResponse response) {
		LOGGER.debug("External Dealer Creation for Sv", userVO.getCategory());
		userVO.setExternalDealerId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		HttpStatus status = HttpStatus.OK;
		response.setStatus(HttpStatus.CREATED.value());
		ExtDealerServMaintVO externalDealerVO = domainModelUtil.toExternalDealerSvVO(extDealerServMaintPRepository.save(domainModelUtil.toExternalDealerSv(userVO)));
		return new ResponseEntity<>(externalDealerVO, status);
		
	}
	
}
