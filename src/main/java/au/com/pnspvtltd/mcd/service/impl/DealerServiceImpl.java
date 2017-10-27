package au.com.pnspvtltd.mcd.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.AdminAuto;
import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerEBidVO;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;
import au.com.pnspvtltd.mcd.domain.DealerSearchInsurance;
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
import au.com.pnspvtltd.mcd.domain.FinanceEntity;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehicleDealerDetails;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetails;
import au.com.pnspvtltd.mcd.repository.AdminRepository;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.DealerSearchRepository;
import au.com.pnspvtltd.mcd.repository.ExtDealerServMaintPRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerFinRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerInsRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerRepository;
import au.com.pnspvtltd.mcd.repository.ExternalDealerTpRepository;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InventoryRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.UserSearchLeadRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;
import au.com.pnspvtltd.mcd.web.model.AdminStatusVO;
import au.com.pnspvtltd.mcd.web.model.AdminVerifyVO;
import au.com.pnspvtltd.mcd.web.model.DealerLoginVO;
import au.com.pnspvtltd.mcd.web.model.DealerResourceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.DealerSubscriptionSBLVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealServMaintr1VO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerFinLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerInsLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchFinVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchInsVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchTpVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSvLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerTpLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExternalDealerFinVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityListVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsVO;

@Service
public class DealerServiceImpl implements DealerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);


	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DealerSearchRepository dealerSearchRepository;
	@Autowired
	private DealerRepository dealerRepository;
	@Autowired
	private ExternalDealerRepository externalDealerRepository;
	@Autowired
	private InventoryRepository InventoryRepository;
	@Autowired
	private ExtDealerServMaintPRepository extDealerServMaintPRepository;
	@Autowired
	private VehicleQuotationRepository vehicleQuotationRepository;
	@Autowired
	private InsuranceQuotationRepository insuranceQuotationRepository;
	@Autowired
	private FinanceQuotationRepository financeQuotationRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;
	@Autowired
	private ExternalDealerTpRepository externalDealerTpRepository;
	@Autowired
	private ExternalDealerFinRepository externalDealerFinRepository;
	@Autowired
	private ExternalDealerInsRepository externalDealerInsRepository;
	@Autowired
	private UserSearchLeadRepository userSearchLeadRepository;

	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional(readOnly = true)
	public AdminAutoVO findUserName(String userName) {
		// TODO Auto-generated method stub
		List<AdminAuto> admins = adminRepository.findByUserNameIgnoreCase(userName);
		if (admins == null || admins.isEmpty()) {
			return null;
		}
		return domainModelUtil.fromAdmin(admins.get(0));
	}

	@Override
	@Transactional(readOnly = true)
	public DealerVO findById(Long id) {
		Dealer dealer = dealerRepository.findOne(id);
		DealerVO dealerVO = null;
		if(dealer != null){
			dealerVO = domainModelUtil.fromDealer(dealer, false);
			
			List<VehicleQuotation> vehicleQuotations = vehicleQuotationRepository.findByDealerId(id);
			List<VehicleQuotationVO> vehicleQuotationVOs = new ArrayList<>();
			for (VehicleQuotation vehicleQuotation : vehicleQuotations) {
				vehicleQuotationVOs.add(domainModelUtil.fromVehicleQuotation(vehicleQuotation));
			}
			dealerVO.setVehicleQuotation(vehicleQuotationVOs);

			List<InsuranceQuotation> insuranceQuotations = insuranceQuotationRepository.findByDealerId(id);
			List<InsuranceQuotationVO> insuranceQuotationVOs = new ArrayList<>();
			for (InsuranceQuotation insuranceQuotation : insuranceQuotations) {
				insuranceQuotationVOs.add(domainModelUtil.fromInsuranceQuotation(insuranceQuotation));
			}
			dealerVO.setInsuranceQuotation(insuranceQuotationVOs);

			List<FinanceQuotation> financeQuotations = financeQuotationRepository.findByDealerId(id);
			List<FinanceQuotationVO> financeQuotationVOs = new ArrayList<>();
			for (FinanceQuotation financeQuotation : financeQuotations) {
				financeQuotationVOs.add(domainModelUtil.fromFinanceQuotation(financeQuotation));
			}
			dealerVO.setFinanceQuotation(financeQuotationVOs);

			
		}
		return dealerVO;
	}
	
	@Override
	@Transactional
	public DealerVO createDealerLogin(DealerLoginVO dealerLoginVO) {
		DealerVO dealerVO = new DealerVO();
		dealerVO.setDealerId(null);
		return domainModelUtil.fromLoginDealer(dealerRepository.save(domainModelUtil.toLoginDealer(dealerLoginVO)), true);
	}

	@Override
	@Transactional
	public DealerVO createDealer(DealerVO dealerVO) {
		dealerVO.setDealerId(null);
		return domainModelUtil.fromDealer(dealerRepository.save(domainModelUtil.toDealer(dealerVO)), true);
	}

	@Override
	@Transactional
	public DealerVO updateDealer(DealerVO dealerVO) {
		Dealer dealerToUpdate = dealerRepository.findOne(dealerVO.getDealerId());

		if (dealerToUpdate == null) {
			LOGGER.debug("Dealer with id {} does not exist", dealerVO.getDealerId());
			return null;
		}

		try {
			BeanUtils.copyProperties(dealerToUpdate, dealerVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Dealer dealer = dealerRepository.save(dealerToUpdate);
		return domainModelUtil.fromDealer(dealer, true);

	}

	@Override
	@Transactional
	public DealerSearch dealerAdminLead(DealerSearchAdminVO dealerVO) {
		Dealer dealer = dealerRepository.findOne(dealerVO.getDealerId());

		DealerSearch dealerSearch = null;
			dealerSearch = domainModelUtil.toDealerSearchAdmin(dealerVO);
			Search search = userSearchLeadRepository.findOne(dealerVO.getCarSearchId());
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		    dealerSearch.setDateOfBirth(ourJavaDateObject);
		    dealerSearch.setAgeOfAdditionalDriver(ourJavaDateObject);
		    dealerSearch.setsYearOfMake(ourJavaDateObject);
		    
		    dealerSearch.setUserId(search.getUserid());
		    dealerSearch.setAgeOfAdditionalDriver(search.getCreationDate()); // Ebid creation date
		    
		    
		    dealerSearch.setNewer(search.isNewer());
		    dealerSearch.setUsed(search.isUsed());
		    dealerSearch.setsPostCode(search.getPostCode());
		    dealerSearch.setsCarColor(search.getCarColor());
		    dealerSearch.setCarColor2(search.getsModel());//carcolor2
		    dealerSearch.setsState(search.getState());// tell me more about
			
			
			if (dealer.getDealSearch() != null) {
				dealer.getDealSearch().add(dealerSearch);
			} else {
				List<DealerSearch> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setDealSearch(dealerVehicleLeads);
			}
			dealerRepository.flush();
			return dealerSearch;
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}
	
	@Override
	@Transactional
	public String extDealerInsAdminLead(ExtDealerInsLdAdminVO dealerVO) {
		
		List<ExtDealerSearchInsVO> extDealerSearchVOs = dealerVO.getExtDealerSearchVO();
		for (ExtDealerSearchInsVO extDealerSearchVO : extDealerSearchVOs) {
			ExternalDealerIns dealer = externalDealerInsRepository.findOne(extDealerSearchVO.getDealerId());
			ExtDealerSearchIns dealerSearch = null;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			//extDealerSearchVO.setDateOfBirth(ourJavaDateObject);
			//extDealerSearchVO.setAgeOfAdditionalDriver(ourJavaDateObject);
			//extDealerSearchVO.setsYearOfMake(ourJavaDateObject);
			// start of External Dealer
			extDealerSearchVO.setCategory(dealer.getCategory());
			extDealerSearchVO.setCompanyName(dealer.getCompanyName());
			extDealerSearchVO.setStreet(dealer.getStreet());
			extDealerSearchVO.setSuburb(dealer.getSuburb());
			//extDealerSearchVO.setState(dealer.getState());
			//extDealerSearchVO.setPostCode(dealer.getPostCode());
			extDealerSearchVO.setCountry(dealer.getCountry());
			extDealerSearchVO.setPhone(dealer.getPhone());
			extDealerSearchVO.setWebsite(dealer.getWebsite());
			extDealerSearchVO.setMobile(dealer.getMobile());
			extDealerSearchVO.setTollFree(dealer.getTollFree());
			extDealerSearchVO.setFax(dealer.getFax());
			extDealerSearchVO.setAfterHours(dealer.getAfterHours());
			extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());
			extDealerSearchVO.setEmail(dealer.getEmail());
			extDealerSearchVO.setLongitude(dealer.getLongitude());
			extDealerSearchVO.setLatitude(dealer.getLatitude());
			// end of External Dealer
			
			dealerSearch = domainModelUtil.toExtDealerInsAdmin(extDealerSearchVO);
			
			dealerSearch.setUserid(extDealerSearchVO.getUserid());
			if (dealer.getExtDealSearch() != null) {
				dealer.getExtDealSearch().add(dealerSearch);
			} else {
				List<ExtDealerSearchIns> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setExtDealSearch(dealerVehicleLeads);
			}
			externalDealerTpRepository.flush();
			
		}
		return "success";

		
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}
	
	
	@Override
	@Transactional
	public String extDealerTpAdminLead(ExtDealerTpLdAdminVO dealerVO) {
		
		List<ExtDealerSearchTpVO> extDealerSearchVOs = dealerVO.getExtDealerSearchVO();
		for (ExtDealerSearchTpVO extDealerSearchVO : extDealerSearchVOs) {
			ExternalDealerTp dealer = externalDealerTpRepository.findOne(extDealerSearchVO.getDealerId());
			ExtDealerSearchTp dealerSearch = null;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			//extDealerSearchVO.setDateOfBirth(ourJavaDateObject);
			//extDealerSearchVO.setAgeOfAdditionalDriver(ourJavaDateObject);
			//extDealerSearchVO.setsYearOfMake(ourJavaDateObject);
			// start of External Dealer
			extDealerSearchVO.setCategory(dealer.getCategory());
			extDealerSearchVO.setCompanyName(dealer.getCompanyName());
			extDealerSearchVO.setStreet(dealer.getStreet());
			extDealerSearchVO.setSuburb(dealer.getSuburb());
			//extDealerSearchVO.setState(dealer.getState());
			//extDealerSearchVO.setPostCode(dealer.getPostCode());
			extDealerSearchVO.setCountry(dealer.getCountry());
			extDealerSearchVO.setPhone(dealer.getPhone());
			extDealerSearchVO.setWebsite(dealer.getWebsite());
			extDealerSearchVO.setMobile(dealer.getMobile());
			extDealerSearchVO.setTollFree(dealer.getTollFree());
			extDealerSearchVO.setFax(dealer.getFax());
			extDealerSearchVO.setAfterHours(dealer.getAfterHours());
			extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());
			extDealerSearchVO.setEmail(dealer.getEmail());
			extDealerSearchVO.setLongitude(dealer.getLongitude());
			extDealerSearchVO.setLatitude(dealer.getLatitude());
			// end of External Dealer
			
			dealerSearch = domainModelUtil.toExtDealerTpAdmin(extDealerSearchVO);
			
			dealerSearch.setUserid(extDealerSearchVO.getUserid());
			if (dealer.getExtDealSearch() != null) {
				dealer.getExtDealSearch().add(dealerSearch);
			} else {
				List<ExtDealerSearchTp> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setExtDealSearch(dealerVehicleLeads);
			}
			externalDealerTpRepository.flush();
			
		}
		return "success";

		
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}

	@Override
	@Transactional
	public String extDealerFinAdminLead(ExtDealerFinLdAdminVO dealerVO) {
		
		List<ExtDealerSearchFinVO> extDealerSearchVOs = dealerVO.getExtDealerSearchVO();
		for (ExtDealerSearchFinVO extDealerSearchVO : extDealerSearchVOs) {
			ExternalDealerFin dealer = externalDealerFinRepository.findOne(extDealerSearchVO.getDealerId());
			ExtDealerSearchFin dealerSearch = null;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			//extDealerSearchVO.setDateOfBirth(ourJavaDateObject);
			//extDealerSearchVO.setAgeOfAdditionalDriver(ourJavaDateObject);
			//extDealerSearchVO.setsYearOfMake(ourJavaDateObject);
			// start of External Dealer
			extDealerSearchVO.setCategory(dealer.getCategory());
			extDealerSearchVO.setCompanyName(dealer.getCompanyName());
			extDealerSearchVO.setStreet(dealer.getStreet());
			extDealerSearchVO.setSuburb(dealer.getSuburb());
			//extDealerSearchVO.setState(dealer.getState());
			//extDealerSearchVO.setPostCode(dealer.getPostCode());
			extDealerSearchVO.setCountry(dealer.getCountry());
			extDealerSearchVO.setPhone(dealer.getPhone());
			extDealerSearchVO.setWebsite(dealer.getWebsite());
			extDealerSearchVO.setMobile(dealer.getMobile());
			extDealerSearchVO.setTollFree(dealer.getTollFree());
			extDealerSearchVO.setFax(dealer.getFax());
			extDealerSearchVO.setAfterHours(dealer.getAfterHours());
			extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());
			extDealerSearchVO.setEmail(dealer.getEmail());
			extDealerSearchVO.setLongitude(dealer.getLongitude());
			extDealerSearchVO.setLatitude(dealer.getLatitude());
			// end of External Dealer
			
			dealerSearch = domainModelUtil.toExtDealerFinAdmin(extDealerSearchVO);
			
			dealerSearch.setUserid(extDealerSearchVO.getUserid());
			if (dealer.getExtDealSearch() != null) {
				dealer.getExtDealSearch().add(dealerSearch);
			} else {
				List<ExtDealerSearchFin> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setExtDealSearch(dealerVehicleLeads);
			}
			externalDealerFinRepository.flush();
			
		}
		return "success";

		
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}

	
	@Override
	@Transactional
	public String extDealerSvAdminLead(ExtDealerSvLdAdminVO dealerVO) {
		
		List<ExtDealServMaintr1VO> extDealerSearchVOs = dealerVO.getExtDealerSearchVO();
		for (ExtDealServMaintr1VO extDealerSearchVO : extDealerSearchVOs) {
			ExtDealServMaint dealer = extDealerServMaintPRepository.findOne(extDealerSearchVO.getDealerId());
			ExtDealServMaintr1 dealerSearch = null;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			//extDealerSearchVO.setDateOfBirth(ourJavaDateObject);
			//extDealerSearchVO.setAgeOfAdditionalDriver(ourJavaDateObject);
			//extDealerSearchVO.setsYearOfMake(ourJavaDateObject);
			// start of External Dealer
			extDealerSearchVO.setCategory(dealer.getCategory());
			extDealerSearchVO.setCompanyName(dealer.getCompanyName());
			extDealerSearchVO.setStreet(dealer.getStreet());
			extDealerSearchVO.setSuburb(dealer.getSuburb());
			//extDealerSearchVO.setState(dealer.getState());
			//extDealerSearchVO.setPostCode(dealer.getPostCode());
			extDealerSearchVO.setCountry(dealer.getCountry());
			extDealerSearchVO.setPhone(dealer.getPhone());
			extDealerSearchVO.setWebsite(dealer.getWebsite());
			extDealerSearchVO.setMobile(dealer.getMobile());
			extDealerSearchVO.setTollFree(dealer.getTollFree());
			extDealerSearchVO.setFax(dealer.getFax());
			extDealerSearchVO.setAfterHours(dealer.getAfterHours());
			extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());
			extDealerSearchVO.setEmail(dealer.getEmail());
			extDealerSearchVO.setLongitude(dealer.getLongitude());
			extDealerSearchVO.setLatitude(dealer.getLatitude());
			// end of External Dealer
			
			dealerSearch = domainModelUtil.toExtDealerSvAdmin(extDealerSearchVO);
			
			dealerSearch.setUserid(extDealerSearchVO.getUserid());
			if (dealer.getExtDealSearch() != null) {
				dealer.getExtDealSearch().add(dealerSearch);
			} else {
				List<ExtDealServMaintr1> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setExtDealSearch(dealerVehicleLeads);
			}
			extDealerServMaintPRepository.flush();
			
		}
		return "success";

		
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}
	
	@Override
	@Transactional
	public String extDealerAdminLead(ExtDealerSearchLdAdminVO dealerVO) {
		
		List<ExtDealerSearchVO> extDealerSearchVOs = dealerVO.getExtDealerSearchVO();
		for (ExtDealerSearchVO extDealerSearchVO : extDealerSearchVOs) {
			ExternalDealer dealer = externalDealerRepository.findOne(extDealerSearchVO.getDealerId());
			ExtDealerSearch dealerSearch = null;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			extDealerSearchVO.setDateOfBirth(ourJavaDateObject);
			extDealerSearchVO.setAgeOfAdditionalDriver(ourJavaDateObject);
			extDealerSearchVO.setsYearOfMake(ourJavaDateObject);
			// start of External Dealer
			extDealerSearchVO.setCategory(dealer.getCategory());
			extDealerSearchVO.setCompanyName(dealer.getCompanyName());
			extDealerSearchVO.setStreet(dealer.getStreet());
			extDealerSearchVO.setSuburb(dealer.getSuburb());
			extDealerSearchVO.setDealState(dealer.getState());
			extDealerSearchVO.setPostCode(dealer.getPostCode());
			extDealerSearchVO.setCountry(dealer.getCountry());
			extDealerSearchVO.setPhone(dealer.getPhone());
			extDealerSearchVO.setWebsite(dealer.getWebsite());
			extDealerSearchVO.setMobile(dealer.getMobile());
			extDealerSearchVO.setTollFree(dealer.getTollFree());
			extDealerSearchVO.setFax(dealer.getFax());
			extDealerSearchVO.setAfterHours(dealer.getAfterHours());
			extDealerSearchVO.setPostalAddress(dealer.getPostalAddress());
			extDealerSearchVO.setEmail(dealer.getEmail());
			extDealerSearchVO.setLongitude(dealer.getLongitude());
			extDealerSearchVO.setLatitude(dealer.getLatitude());
			// end of External Dealer
			
			dealerSearch = domainModelUtil.toExtDealerSearchAdmin(extDealerSearchVO);
			
			dealerSearch.setUserid(extDealerSearchVO.getUserid());
			dealerSearch.setLatitude(0);
			if (dealer.getExtDealSearch() != null) {
				dealer.getExtDealSearch().add(dealerSearch);
			} else {
				List<ExtDealerSearch> dealerVehicleLeads = new ArrayList<>();
				dealerVehicleLeads.add(dealerSearch);
				dealer.setExtDealSearch(dealerVehicleLeads);
			}
			externalDealerRepository.flush();
			
		}
		return "success";

		
			//return domainModelUtil.toDealerAdmin(dealer);
		

	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DealerVO> findAllDealers() {
		List<DealerVO> dealerVOs = new ArrayList<>();
		for (Dealer dealer : dealerRepository.findAll()) {
			dealerVOs.add(domainModelUtil.fromDealer(dealer, true));
		}
		return dealerVOs;
	}

	@Override
	@Transactional(readOnly = true)
	public DealerVO findDealerByEmail(String email) {
		return domainModelUtil.fromDealer(dealerRepository.findByEmailIgnoreCase(email), true);
	}

	@Override
	@Transactional
	public String addInventory(InventoryVO inventoryVO) {
		Dealer dealer = dealerRepository.findOne(inventoryVO.getRefId());
		Inventory inventory = domainModelUtil.toInventory(inventoryVO);
		dealer.getInventory().add(inventory);
		dealerRepository.flush();
		return "{\"dealerId\":" + dealer.getDealerId() + ",\"inventoryId\":" + inventory.getRepoId() + "}";
	}

	@Override
	@Transactional
	public String addInventoryUser(InventoryVO inventoryVO) {
		Long refId=new Long(35);
		Dealer dealer = dealerRepository.findOne(refId);
	//		inventoryVO.setUserId(inventoryVO.getRefId());
		Inventory inventory = domainModelUtil.toInventory(inventoryVO);
		dealer.getInventory().add(inventory);
		dealerRepository.flush();
		return "{\"dealerId\":" + dealer.getDealerId() + ",\"inventoryId\":" + inventory.getRepoId() + "}";
	}
	@Override
	@Transactional
	public String addInventoryList(InventoryListVO inventoryVO) {
		List<Inventory> inventory = domainModelUtil.toInventoryList(inventoryVO);
		Iterator<Inventory> it = inventory.iterator();
		List<InventoryVO> listVO = inventoryVO.getInventoryVO();
		Iterator<InventoryVO> it2 = listVO.iterator();
		while(it.hasNext() && it2.hasNext()){
		Inventory localInven = it.next();
		InventoryVO localInvenVO = it2.next();
		Dealer dealer = dealerRepository.findOne(localInvenVO.getRefId());
		
		dealer.getInventory().add(localInven);
		dealerRepository.flush();
		}
		return "{\"dealerId\":" + "" + ",\"inventoryId\":" + "" + "}";
	}
	
	@Override
	@Transactional
	public String addFinanceEntityList(FinanceEntityListVO financeEntityListVO) {
		List<FinanceEntity> inventory = domainModelUtil.toFinanceEntityList(financeEntityListVO);
		Iterator<FinanceEntity> it = inventory.iterator();
		List<FinanceEntityVO> listVO = financeEntityListVO.getInventoryVO();
		Iterator<FinanceEntityVO> it2 = listVO.iterator();
		while(it.hasNext() && it2.hasNext()){
			FinanceEntity localInven = it.next();
			FinanceEntityVO localInvenVO = it2.next();
		Dealer dealer = dealerRepository.findOne(localInvenVO.getRefId());
		
		dealer.getFinanceEntity().add(localInven);
		dealerRepository.flush();
		}
		return "{\"dealerId\":" + "" + ",\"financeEntityId\":" + "" + "}";
	}
	
	@Override
	@Transactional
	public String updateStatus(AdminStatusVO financeEntityListVO) {
		Search search = userSearchLeadRepository.findOne(financeEntityListVO.getCarSearchId());
		search.setMobCheck(financeEntityListVO.isMobCheck());
		search.setIdCheck(financeEntityListVO.isIdCheck());
		userSearchLeadRepository.flush();
		User user = userRepository.findOne(search.getUserid());
		user.setMobCheck(financeEntityListVO.isMobCheck());
		user.setIdCheck(financeEntityListVO.isIdCheck());
		
		userRepository.flush();
		
		return "";
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<InventoryVO> getInventory(Long dealerId) {
		Dealer dealer = new Dealer();
		dealer.setDealerId(dealerId);
		
		List<InventoryVO> inventoryList = new ArrayList<>();
		
		for(Inventory inventory : InventoryRepository.findByDealer(dealer)){
			inventoryList.add(domainModelUtil.fromInventory(inventory, true));
		}
		return inventoryList;
	}

	@Override
	@Transactional(readOnly = true)
	public AdminVerifyVO getExistStatus(Long eBidId) {
		AdminVerifyVO adminVerifyVO = new AdminVerifyVO();
		Search search = userSearchLeadRepository.findOne(eBidId);
		User user = userRepository.findOne(search.getUserid());
		adminVerifyVO.setMobCheck(user.isMobCheck());
		adminVerifyVO.setIdCheck(user.isIdCheck());
		adminVerifyVO.setMobile(user.getAbnNumber());
		adminVerifyVO.setDrivingLicense(user.getDrivingLicense());
		adminVerifyVO.setEmail(user.getEmail());
		return adminVerifyVO;
		
	}
	@Override
	@Transactional(readOnly = true)
	public List<DealerSearchVO> getDealerSearch(Long dealerId) {
		List<DealerSearchVO> dealerSearchList = new ArrayList<>(); 
		for(DealerSearch dealerSearch : dealerRepository.findOne(dealerId).getDealSearch()){
			dealerSearchList.add(domainModelUtil.fromDealerSearch(dealerSearch));
		}
		return dealerSearchList;
	}
	
	@Override
	@Transactional(readOnly = true)
	public DealerSearchVO getDealerSearchUnique(Long dealerId) {
		DealerSearchVO dealerSearchList = new DealerSearchVO(); 
		DealerSearch dealerSearch= dealerSearchRepository.findOne(dealerId);
		dealerSearchList = domainModelUtil.toDealerSearchVO(dealerSearch);
		return dealerSearchList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DealerSearchInsuranceVO> getDealerSearchInsurance(Long dealerId) {
		List<DealerSearchInsuranceVO> dealerSearchInsuranceList = new ArrayList<>(); 
		for(DealerSearchInsurance dealerSearchInsurance : dealerRepository.findOne(dealerId).getDealSearchInsurance()){
			dealerSearchInsuranceList.add(domainModelUtil.fromDealerSearchInsurance(dealerSearchInsurance));
		}
		return dealerSearchInsuranceList;
	}

	@Override
	public List<DealerSearchFinanceVO> getDealerSearchFinance(Long dealerId) {
		List<DealerSearchFinanceVO> dealerSearchFinanceList = new ArrayList<>(); 
		for(DealerSearchFinance dealerSearchFinance : dealerRepository.findOne(dealerId).getDealSearchFinance()){
			dealerSearchFinanceList.add(domainModelUtil.fromDealerSearchFinance(dealerSearchFinance));
		}
		return dealerSearchFinanceList;
	}

	@Override
	public List<VehicleQuotationVO> getDealerVehicleQuotation(Long dealerId) {
		List<VehicleQuotationVO> vehicleQuotationVOs = new ArrayList<>();
		for (VehicleQuotation vehicleQuotation : vehicleQuotationRepository.findByDealerId(dealerId)) {
			vehicleQuotationVOs.add(domainModelUtil.fromVehicleQuotation(vehicleQuotation));
		}
		return vehicleQuotationVOs; 
	}

	@Override
	public List<InsuranceQuotationVO> getDealerInsuranceQuotation(Long dealerId) {
		List<InsuranceQuotationVO> insuranceQuotationVOs = new ArrayList<>();
		for (InsuranceQuotation insuranceQuotation : insuranceQuotationRepository.findByDealerId(dealerId)) {
			insuranceQuotationVOs.add(domainModelUtil.fromInsuranceQuotation(insuranceQuotation));
		}
		return insuranceQuotationVOs; 
	}

	@Override
	public List<FinanceQuotationVO> getDealerFinanceQuotation(Long dealerId) {
		List<FinanceQuotationVO> financeQuotationVOs = new ArrayList<>();
		for (FinanceQuotation financeQuotation : financeQuotationRepository.findByDealerId(dealerId)) {
			financeQuotationVOs.add(domainModelUtil.fromFinanceQuotation(financeQuotation));
		}
		return financeQuotationVOs;
	}

	@Override
	public String whenDealerEBidForCar(DealerEBidVO dealerEBidVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> getDealerIDs() {
		// TODO Auto-generated method stub
		return dealerRepository.getDealerIDs();
	}

	@Override
	public DealerVO getDealerForID(Long dealerID) {
		// TODO Auto-generated method stub
		DealerVO dealerVO = null;
		Dealer dealer = dealerRepository.getDealerForID(dealerID);
		if(dealer != null){
			dealerVO = domainModelUtil.fromDealer(dealer, false);
			/*try {
				BeanUtils.copyProperties(dealerVO, dealer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}	
		return dealerVO;
	}

	@Override
	public DealerVO findByEmailIgnoreCase(String email) {
		// TODO Auto-generated method stub
		return domainModelUtil.fromDealer(dealerRepository.findByEmailIgnoreCase(email), true);
		
	}

	@Override
	public DealerSubscriptionSBLVO createVehicleDealerSBL(DealerSubscriptionSBLVO dealerVO) {
		// TODO Auto-generated method stub
		Dealer dealer = dealerRepository.getDealerForID(dealerVO.getDealerId());
		List<VehicleDealerDetailsVO> vehicleDealerDetailsVO = dealerVO.getVehicleDealerDetails();
		List<VehicleDealerDetails> vehicleDealerDetailsList = new ArrayList<VehicleDealerDetails>();
		for (VehicleDealerDetailsVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			VehicleDealerDetails vehicleDealerDetails = domainModelUtil.toDealerSBL(vehicleDealerDetailsVO1);
			vehicleDealerDetailsList.add(vehicleDealerDetails);
		}
		dealer.setVehicleDealerDetails(vehicleDealerDetailsList);
		dealerRepository.saveAndFlush(dealer);
		return dealerVO;
	}
	
	@Override
	public DealerResourceVO createDealerResource(DealerResourceVO dealerVO) {
		// TODO Auto-generated method stub
		Dealer dealer = dealerRepository.getDealerForID(dealerVO.getDealerId());
		List<VehicleResourceDetailsVO> vehicleDealerDetailsVO = dealerVO.getVehicleResourceDetails();
		List<VehicleResourceDetails> vehicleDealerDetailsList = new ArrayList<VehicleResourceDetails>();
		for (VehicleResourceDetailsVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			VehicleResourceDetails vehicleDealerDetails = domainModelUtil.toDealerResource(vehicleDealerDetailsVO1);
			vehicleDealerDetailsList.add(vehicleDealerDetails);
		}
		dealer.setVehicleResourceDetails(vehicleDealerDetailsList);
		dealerRepository.saveAndFlush(dealer);
		return dealerVO;
	}
}
