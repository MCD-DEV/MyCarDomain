package au.com.pnspvtltd.mcd.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.BlogPoints;
import au.com.pnspvtltd.mcd.domain.CurrentOffers;
import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;
import au.com.pnspvtltd.mcd.domain.DealerSearchInsurance;
import au.com.pnspvtltd.mcd.domain.DealerSearchServMaint;
import au.com.pnspvtltd.mcd.domain.DealerSearchTransp;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.LoyalityProgAdmin;
import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.ReferencedPoints;
import au.com.pnspvtltd.mcd.domain.ReviewPoints;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.SearchFinance;
import au.com.pnspvtltd.mcd.domain.SearchInsurance;
import au.com.pnspvtltd.mcd.domain.SearchServMaint;
import au.com.pnspvtltd.mcd.domain.SearchTransp;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserNotification;
import au.com.pnspvtltd.mcd.domain.UserReferPoints;
import au.com.pnspvtltd.mcd.domain.ValTransPoints;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetails;
import au.com.pnspvtltd.mcd.enums.LeadInitiatedBy;
import au.com.pnspvtltd.mcd.repository.BlogPointsRepository;
import au.com.pnspvtltd.mcd.repository.CountyRegPostSubRepository;
import au.com.pnspvtltd.mcd.repository.CurrentOffersRepository;
import au.com.pnspvtltd.mcd.repository.DealerRepository;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InventoryRepository;
import au.com.pnspvtltd.mcd.repository.LoyalityProgAdminRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleRepository;
import au.com.pnspvtltd.mcd.repository.ReferencedPointsRepository;
import au.com.pnspvtltd.mcd.repository.ReviewPointsRepository;
import au.com.pnspvtltd.mcd.repository.SearchFinanceRepository;
import au.com.pnspvtltd.mcd.repository.SearchInsuranceRepository;
import au.com.pnspvtltd.mcd.repository.SearchServMtRepository;
import au.com.pnspvtltd.mcd.repository.SearchTranspRepository;
import au.com.pnspvtltd.mcd.repository.ServMaintQuotationRepository;
import au.com.pnspvtltd.mcd.repository.TranspServQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserNotificationRepository;
import au.com.pnspvtltd.mcd.repository.UserReferPointsRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.UserSearchLeadRepository;
import au.com.pnspvtltd.mcd.repository.ValTransPointsRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.service.UserEBidService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.BlogPointsVO;
import au.com.pnspvtltd.mcd.web.model.CurrentOffersVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.LoyalityProgAdminVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.ReferencedPointsVO;
import au.com.pnspvtltd.mcd.web.model.ReviewPointsVO;
import au.com.pnspvtltd.mcd.web.model.SearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.SearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.SearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.SearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidFinanceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidServMaintVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidTransServVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidVO;
import au.com.pnspvtltd.mcd.web.model.UserMyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserNotificationVO;
import au.com.pnspvtltd.mcd.web.model.UserReferPointsVO;
import au.com.pnspvtltd.mcd.web.model.ValTransPointsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsVO;

@Service
public class UserEBidServiceImpl implements UserEBidService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserSearchLeadRepository userSearclLeadRepository;
	@Autowired
	private MyVehicleRepository myVehicleRepository;
	@Autowired
	private SearchFinanceRepository searchFinanceRepository;
	@Autowired
	private TranspServQuotationRepository transpServQuotationRepository;
	@Autowired
	private ServMaintQuotationRepository servMaintQuotationRepository;
	@Autowired
	private SearchInsuranceRepository searchInsuranceRepository;
	@Autowired
	private UserReferPointsRepository userReferPointsRepository;
	@Autowired
	private ReferencedPointsRepository referencedPointsRepository;
	@Autowired
	private BlogPointsRepository blogPointsRepository;
	@Autowired
	private ReviewPointsRepository reviewPointsRepository;
	@Autowired
	private LoyalityProgAdminRepository loyalityProgAdminRepository;
	@Autowired
	private ValTransPointsRepository valTransPointsRepository;
	@Autowired
	private SearchServMtRepository searchServMtRepository;
	@Autowired
	private SearchTranspRepository searchTranspRepository;
	@Autowired
	private UserNotificationRepository userNotificationRepository;
	@Autowired
	private CurrentOffersRepository currentOffersRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private DealerRepository dealerRepository;
	@Autowired
	private VehicleQuotationRepository vehicleQuotationRepository;
	@Autowired
	private FinanceQuotationRepository financeQuotationRepository;
	@Autowired
	private InsuranceQuotationRepository insuranceQuotationRepository;
	@Autowired
	private CountyRegPostSubRepository countyRegPostSubRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	@Transactional
	public UserReferPoints whenUserReferUserId(UserReferPointsVO userReferPointsVO) {
		User user = userRepository.findOne(userReferPointsVO.getUserId());
		UserReferPoints valTransPoints = new UserReferPoints();
		// start check whether email id is already referred
		String emailCheck = userReferPointsVO.getReferedEmailId();
		boolean present = false;
		List<UserReferPoints> checkUserReferPoints = user.getUserReferPoints();
		for (UserReferPoints checkUserReferPoint : checkUserReferPoints) {
			if (emailCheck.equalsIgnoreCase(checkUserReferPoint.getReferedEmailId())) {
				present = true;
			}
		}
		// end check whether email id
		if (!present) {
			Calendar calendar = Calendar.getInstance();
			java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			// Start of loyality program search car
			// Retrieval from loyalityAdminProg
			List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
			// setting the ProvDiv value and actualDiv value
			// userReferPoints
			int userReferProvDiv = 0;
			int userReferActDiv = 0;
			int referedProvDiv = 0;
			int referedActDiv = 0;
			int revProvDiv = 0;
			int revActDiv = 0;
			int blogProvDiv = 0;
			int blogActDiv = 0;
			int valBuyProvDiv = 0;
			int valBuyActDiv = 0;
			int valSelProvDiv = 0;
			int valSelActDiv = 0;
			int valFinProvDiv = 0;
			int valFinActDiv = 0;
			int valInsProvDiv = 0;
			int valInsActDiv = 0;
			int valTrpProvDiv = 0;
			int valTrpActDiv = 0;
			int valServProvDiv = 0;
			int valServActDiv = 0;
			String userReferProvDivAct = null;
			String referedProvDivAct = null;
			// Setting values

			for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
				userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
				userReferProvDivAct = loyalityProgAdmin.getUserReferAction1();
				userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
				referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
				referedProvDivAct = loyalityProgAdmin.getReferredAction1();
				referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
				revProvDiv = loyalityProgAdmin.getRevDivByAct1();
				revActDiv = loyalityProgAdmin.getRevDivByAct2();
				blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
				blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
				valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
				valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

				/*
				 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
				 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
				 */
				valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
				valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

				valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
				valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

				valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
				valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

				valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
				valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

				valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
				valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
			}
			// end of loyalityAdmiProg
			// UserReferPoints valTransPoints = new UserReferPoints();
			valTransPoints.setCreationDate(ourJavaDateObject);
			// valTransPoints.setId(search.getCarSearchId());
			valTransPoints.setFirstName(userReferPointsVO.getFirstName());
			valTransPoints.setLastName(userReferPointsVO.getLastName());
			valTransPoints.setReferedEmailId(userReferPointsVO.getReferedEmailId());
			valTransPoints.setAction("INITIATED");
			valTransPoints.setIdp(userReferPointsVO.getUserId());
			valTransPoints.setNoOfPoints(userReferProvDiv);
			if (user.getValTransPoints() != null) {
				user.getUserReferPoints().add(valTransPoints);
			} else {
				List<UserReferPoints> userInsuranceLeads = new ArrayList<>();
				userInsuranceLeads.add(valTransPoints);
				user.setUserReferPoints(userInsuranceLeads);
			}
			userRepository.flush();
			// valTransPoints.setAction("Sent");
			// return valTransPoints;
		} else {
			// UserReferPoints valTransPoints = new UserReferPoints();
			valTransPoints.setAction("Already Sent");
		}
		return valTransPoints;
	}

	@Override
	@Transactional
	public ReferencedPoints whenReferedUserId(ReferencedPointsVO referencedPointsVO) {

		// User user = userRepository.findOne(referencedPointsVO.getUserId());
		User user = userRepository.findByEmailIgnoreCase(referencedPointsVO.getReferencedEmailId());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		// Start of loyality program search car

		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg
		ReferencedPoints valTransPoints = new ReferencedPoints();
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setRefUserId(referencedPointsVO.getRefUserId());
		valTransPoints.setCreationDate(ourJavaDateObject);
		// valTransPoints.setId(search.getCarSearchId());
		valTransPoints.setReferencedFirstName(referencedPointsVO.getReferencedFirstName());
		valTransPoints.setReferencedLastName(referencedPointsVO.getReferencedLastName());
		valTransPoints.setReferencedEmailId(referencedPointsVO.getReferencedEmailId());
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(referedProvDiv);
		//user.setRefer(true);
		if (user.getValTransPoints() != null) {
			user.getReferencedPoints().add(valTransPoints);
		} else {
			List<ReferencedPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setReferencedPoints(userInsuranceLeads);
		}
		userRepository.flush();
		// set refer true start
		User userRef = userRepository.findOne(referencedPointsVO.getRefUserId());
		userRef.setRefer(true);
		userRepository.flush();
		// set refer true start
		return valTransPoints;

	}

	@Override
	@Transactional
	public String whenUserEBidForCar(UserEBidVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User Search Lead (Vehicle Lead)
		Search search = domainModelUtil.toSearch(userEBidVO.getSearchLead());
		search.setLeadInitiatedBy(LeadInitiatedBy.USER);
		// (2) create a java sql date object we want to insert
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		search.setCreationDate(ourJavaDateObject);
		// start of check
		search.setAbnNumber(user.getAbnNumber());
		search.setEmail(user.getEmail());
		search.setDrivingLicense(user.getDrivingLicense());
		search.setUserid(user.getUserId());
		search.setMobCheck(user.isMobCheck());
		search.setIdCheck(user.isIdCheck());
		// end of check
		if (user.getSearch() != null) {
			user.getSearch().add(search);
		} else {
			List<Search> userVehicleLeads = new ArrayList<>();
			userVehicleLeads.add(search);
			user.setSearch(userVehicleLeads);
		}

		int searchCountTemp = user.getSearchCount();
		user.setSearchCount(searchCountTemp + 1);
		SearchFinance searchFinance = null;
		searchFinance = domainModelUtil.toSearchFinance(userEBidVO.getFinanceLead());
		// (2) create a java sql date object we want to insert
		Calendar calendar12 = Calendar.getInstance();
		java.sql.Date ourJavaDateObject1 = new java.sql.Date(calendar12.getTime().getTime());
		// start of check
		/*searchFinance.setMobile(user.getMobile());
		searchFinance.setLandLine(user.getLandLine());*/
		searchFinance.setAbnNumber(user.getAbnNumber());
		searchFinance.setEmail(user.getEmail());
		searchFinance.setDrivingLicense(user.getDrivingLicense());
		searchFinance.setMobCheck(user.isMobCheck());
		searchFinance.setIdCheck(user.isIdCheck());
		// end of check

		searchFinance.setCreationDate(ourJavaDateObject1);
		searchFinance.setIdp(user.getUserId());
		// Create User Finance Lead when isfinance and searchFinance != null
		if (userEBidVO.isFinance() && searchFinance != null) {

			/*
			 * searchFinance =
			 * domainModelUtil.toSearchFinance(userEBidVO.getFinanceLead());
			 */
			int searchInfCountTemp = user.getSearchFinCount();
			user.setSearchFinCount(searchInfCountTemp + 1);
			if (user.getSearchFinance() != null) {
				user.getSearchFinance().add(searchFinance);
			} else {
				List<SearchFinance> userFinanceLeads = new ArrayList<>();
				userFinanceLeads.add(searchFinance);
				user.setSearchFinance(userFinanceLeads);
			}

		}
		SearchInsurance searchInsurance = null;
		searchInsurance = domainModelUtil.toSearchInsurance(userEBidVO.getInsuranceLead());
		Calendar calendar14 = Calendar.getInstance();
		java.sql.Date ourJavaDateObject12 = new java.sql.Date(calendar14.getTime().getTime());
		searchInsurance.setCreationDate(ourJavaDateObject12);
		searchInsurance.setIdp(user.getUserId());
		
		// start of check
		/*searchInsurance.setMobile(user.getMobile());
		searchInsurance.setLandLine(user.getLandLine());*/
		searchInsurance.setAbnNumber(user.getAbnNumber());
		searchInsurance.setEmail(user.getEmail());
		searchInsurance.setDrivingLicense(user.getDrivingLicense());
		searchInsurance.setMobCheck(user.isMobCheck());
		searchInsurance.setIdCheck(user.isIdCheck());
				// end of check
		// Create User Insurance Lead when isinsurer and searchInsurance != null
		if (userEBidVO.isInsurance() && searchInsurance != null) {

			/*
			 * searchInsurance =
			 * domainModelUtil.toSearchInsurance(userEBidVO.getInsuranceLead());
			 */
			int searchInsCountTemp = user.getSearchInsCount();
			user.setSearchInsCount(searchInsCountTemp + 1);
			if (user.getSearchInsurance() != null) {
				user.getSearchInsurance().add(searchInsurance);
			} else {
				List<SearchInsurance> userInsuranceLeads = new ArrayList<>();
				userInsuranceLeads.add(searchInsurance);
				user.setSearchInsurance(userInsuranceLeads);
			}

		}

		userRepository.flush();
		// Start of loyality program search car
		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg
		ValTransPoints valTransPoints = new ValTransPoints();
		valTransPoints.setCreationDate(ourJavaDateObject);
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setId(search.getCarSearchId());
		valTransPoints.setName("CarReq");
		valTransPoints.setTypeOfTrans("CarReq");
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(valBuyProvDiv);
		if (user.getValTransPoints() != null) {
			user.getValTransPoints().add(valTransPoints);
		} else {
			List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setValTransPoints(userInsuranceLeads);
		}
		// end of loyality program
		if (userEBidVO.isFinance() && searchFinance != null) {
			// Start of loyality program for finance
			ValTransPoints valTransPointsFin = new ValTransPoints();
			valTransPointsFin.setCreationDate(ourJavaDateObject);
			valTransPointsFin.setIdp(user.getUserId());
			valTransPointsFin.setId(searchFinance.getSearchFinanceId());
			valTransPointsFin.setName("FinReq");
			valTransPointsFin.setTypeOfTrans("FinReq");
			valTransPoints.setAction("INITIATED");
			valTransPointsFin.setNoOfPoints(valFinProvDiv);
			if (user.getValTransPoints() != null) {
				user.getValTransPoints().add(valTransPointsFin);
			} else {
				List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
				userInsuranceLeads.add(valTransPointsFin);
				user.setValTransPoints(userInsuranceLeads);
			}
			// end of loyality program
		}
		if (userEBidVO.isInsurance() && searchInsurance != null) {
			// Start of loyality program for insurance
			ValTransPoints valTransPointsIns = new ValTransPoints();
			valTransPointsIns.setCreationDate(ourJavaDateObject);
			valTransPointsIns.setIdp(user.getUserId());
			valTransPointsIns.setId(searchInsurance.getSearchInsuranceId());
			valTransPointsIns.setName("InsReq");
			valTransPointsIns.setTypeOfTrans("InsReq");
			valTransPoints.setAction("INITIATED");
			valTransPointsIns.setNoOfPoints(valInsProvDiv);
			if (user.getValTransPoints() != null) {
				user.getValTransPoints().add(valTransPointsIns);
			} else {
				List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
				userInsuranceLeads.add(valTransPointsIns);
				user.setValTransPoints(userInsuranceLeads);
			}
			// end of loyality program
		}

		/*
		 * // // Checking for following conditions to create Leads and
		 * Quotations for // Dealers // 1. {year, make, model, autoscooptrim}
		 * perfect match // 2. Region, 3. Postcode //
		 * 
		 * List<Inventory> inventories =
		 * inventoryRepository.getInventoryForTrim(search.getModelYear(),
		 * search.getModelDisplay(), search.getModelTrim());
		 * 
		 * for (Inventory inventory : inventories) {
		 * 
		 * System.out.println("details for Dealer and Quotations Creation" +
		 * inventory.getRepoId() + inventory.getModelYear() +
		 * inventory.getModelDisplay() + inventory.getModelTrim()); Dealer
		 * dealer = inventory.getDealer();
		 * 
		 * DealerSearch dealerSearch = null;
		 * 
		 * // Create Dealer Vehicle Lead if // he is a Dealer and // check for
		 * region, postCode // TODO: Rename isDealer to reflect whether the
		 * Dealer is eligible // for Vehicle Lead if (dealer.isDealer() &&
		 * (checkDealerRegion(dealer, search.getPostCode()) ||
		 * checkDealerPostCode(dealer, search.getPostCode()))) {
		 * System.out.println("isDealer" + dealer.isDealer() +
		 * "region and postcode is matching"); dealerSearch =
		 * domainModelUtil.toDealerSearch(userEBidVO.getSearchLead());
		 * dealerSearch.setUserId(user.getUserId()); if (dealer.getDealSearch()
		 * != null) { dealer.getDealSearch().add(dealerSearch); } else {
		 * List<DealerSearch> dealerVehicleLeads = new ArrayList<>();
		 * dealerVehicleLeads.add(dealerSearch);
		 * dealer.setDealSearch(dealerVehicleLeads); }
		 * inventoryRepository.flush(); // Create Quotation for Dealer matching
		 * Region and postCode System.out.println(
		 * "create quotation when region and postcode is matching" +
		 * dealer.isDealer()); createVehicleQuotation(user, dealer, search,
		 * dealerSearch, inventory); }
		 * 
		 * }
		 * 
		 * // Create Dealer Leads from "Inventory make" // Checking for
		 * following conditions to create Leads for Dealers from //
		 * "inventory make" // 1. IsDealer and // 2. Region, Postcode
		 * List<Inventory> inventorieMakes =
		 * inventoryRepository.getInventoryForMake(search.getModelDisplay());
		 * for (Inventory inventory : inventorieMakes) { System.out.println(
		 * "details for matching Make from inventory repo" +
		 * inventory.getRepoId() + inventory.getModelYear() +
		 * inventory.getModelDisplay() + inventory.getModelTrim()); Dealer
		 * dealer = inventory.getDealer();
		 * 
		 * DealerSearch dealerSearch = null;
		 * 
		 * // Create Dealer Vehicle Lead if he is a Dealer // check for region,
		 * postCode and IsDealer // TODO: Rename isDealer to reflect whether the
		 * Dealer is eligible // for Vehicle Lead if (dealer.isDealer() &&
		 * (checkDealerRegion(dealer, search.getPostCode()) ||
		 * checkDealerPostCode(dealer, search.getPostCode()))) { dealerSearch =
		 * domainModelUtil.toDealerSearch(userEBidVO.getSearchLead());
		 * dealerSearch.setUserId(user.getUserId()); if (dealer.getDealSearch()
		 * != null) { dealer.getDealSearch().add(dealerSearch); } else {
		 * List<DealerSearch> dealerVehicleLeads = new ArrayList<>();
		 * dealerVehicleLeads.add(dealerSearch);
		 * dealer.setDealSearch(dealerVehicleLeads); } }
		 * 
		 * inventoryRepository.flush();
		 * 
		 * }
		 * 
		 * // Create Dealer Leads from "Dealer's make" // Checking for following
		 * conditions to create Leads for Dealers from // "Dealer's make" // 1.
		 * Dealer make and // 2. Region, Postcode List<Dealer> dealerMakes =
		 * dealerRepository.getDealerForMake(); // boolean present12 = false;
		 * for (Dealer dealer : dealerMakes) { // present12 = true;
		 * 
		 * List<VehicleDealerMakeList> makeLists =
		 * dealer.getVehicleDealerMakeList(); for (VehicleDealerMakeList
		 * dealMake : makeLists) { if
		 * (dealMake.getMake().equals(search.getModelDisplay()) &&
		 * (checkDealerRegion(dealer, search.getPostCode()) ||
		 * checkDealerPostCode(dealer, search.getPostCode()))) { DealerSearch
		 * dealerSearch = null; System.out.println(
		 * "details for matching make from dealer's repo" + dealer.getDealerId()
		 * + dealMake.getMake()); // Create Dealer Vehicle Lead if he is a
		 * Dealer // check for region, postCode and IsDealer // TODO: Rename
		 * isDealer to reflect whether the Dealer is // eligible // for Vehicle
		 * Lead if (dealer.isDealer() && (checkDealerRegion(dealer,
		 * search.getPostCode()) || checkDealerPostCode(dealer,
		 * search.getPostCode()))) { dealerSearch =
		 * domainModelUtil.toDealerSearch(userEBidVO.getSearchLead());
		 * dealerSearch.setUserId(user.getUserId()); if (dealer.getDealSearch()
		 * != null) { dealer.getDealSearch().add(dealerSearch); } else {
		 * List<DealerSearch> dealerVehicleLeads = new ArrayList<>();
		 * dealerVehicleLeads.add(dealerSearch);
		 * dealer.setDealSearch(dealerVehicleLeads); } }
		 * 
		 * dealerRepository.flush(); } }
		 * 
		 * }
		 * 
		 * // Create Finance Leads when // dealer isFinancer List<Dealer>
		 * financeDealers = dealerRepository.getDealerForFinance(true); for
		 * (Dealer dealer : financeDealers) { DealerSearchFinance
		 * dealerSearchFinance = null;
		 * 
		 * if (userEBidVO.isFinance() && searchFinance != null) { // Create
		 * Dealer Finance Lead if he provides finance
		 * 
		 * dealerSearchFinance =
		 * domainModelUtil.toDealerSearchFinance(userEBidVO.getFinanceLead());
		 * dealerSearchFinance.setUserId(user.getUserId()); if
		 * (dealer.getDealSearchFinance() != null) {
		 * dealer.getDealSearchFinance().add(dealerSearchFinance); } else {
		 * List<DealerSearchFinance> dealerFinanceLeads = new ArrayList<>();
		 * dealerFinanceLeads.add(dealerSearchFinance);
		 * dealer.setDealSearchFinance(dealerFinanceLeads); }
		 * dealerRepository.flush(); }
		 * 
		 * 
		 * if (dealer.isFinancer() && searchFinance != null &&
		 * userEBidVO.isFinance()) { createFinanceQuotation(user, dealer,
		 * searchFinance, dealerSearchFinance, inventory); } if
		 * (dealer.isInsurer() && searchInsurance != null &&
		 * userEBidVO.isInsurance()) { createInsuranceQuotation(user, dealer,
		 * searchInsurance, dealerSearchInsurance, inventory); }
		 * 
		 * }
		 * 
		 * // Create insurance Leads // when dealer isInsurer List<Dealer>
		 * insuranceDealers = dealerRepository.getDealerForInsurance(true); for
		 * (Dealer dealer : insuranceDealers) { DealerSearchInsurance
		 * dealerSearchInsurance = null;
		 * 
		 * if (userEBidVO.isInsurance() && searchInsurance != null) { // Create
		 * Dealer Insurance Lead if he provides insurance if
		 * (dealer.isInsurer()) { dealerSearchInsurance =
		 * domainModelUtil.toDealerSearchInsurance(userEBidVO.getInsuranceLead()
		 * ); dealerSearchInsurance.setUserId(user.getUserId()); if
		 * (dealer.getDealSearchInsurance() != null) {
		 * dealer.getDealSearchInsurance().add(dealerSearchInsurance); } else {
		 * List<DealerSearchInsurance> dealerInsuranceLeads = new ArrayList<>();
		 * dealerInsuranceLeads.add(dealerSearchInsurance);
		 * dealer.setDealSearchInsurance(dealerInsuranceLeads); } } }
		 * 
		 * 
		 * if (dealer.isFinancer() && searchFinance != null &&
		 * userEBidVO.isFinance()) { createFinanceQuotation(user, dealer,
		 * searchFinance, dealerSearchFinance, inventory); } if
		 * (dealer.isInsurer() && searchInsurance != null &&
		 * userEBidVO.isInsurance()) { createInsuranceQuotation(user, dealer,
		 * searchInsurance, dealerSearchInsurance, inventory); }
		 * 
		 * dealerRepository.flush(); }
		 */

		return "{\"userId\":" + userEBidVO.getUserId() + ",\"searchId\":" + search.getCarSearchId() + "}";

	}

	public boolean checkDealerPostCode(Dealer dealer, int postCode) {
		List<VehicleDealerAreaOfOperPostCode> dealerPostCodes = dealer.getVehicleDealerPostCode();
		boolean eligibled = false;
		for (VehicleDealerAreaOfOperPostCode dealerPostCode : dealerPostCodes) {
			if (dealerPostCode.getPostCode() == String.valueOf(postCode)) {
				eligibled = true;
			}
		}
		return eligibled;

	}

	public boolean checkDealerRegion(Dealer dealer, int postCode) {
		// to do
		List<String> region = countyRegPostSubRepository.getRegionForGivenPostCode(postCode);
		List<VehicleDealerAreaOfOperRegion> dealerRegions = dealer.getVehicleDealerRegion();
		boolean eligibled = false;
		for (VehicleDealerAreaOfOperRegion dealerRegion : dealerRegions) {
			if (region.contains(dealerRegion.getRegion())) {
				eligibled = true;
			}
		}
		return eligibled;
	}

	@Override
	@Transactional
	public String whenUserEBidForFinance(UserEBidFinanceVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User Finance Lead
		SearchFinance searchFinance = domainModelUtil.toSearchFinance(userEBidVO.getFinanceLead());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		searchFinance.setCreationDate(ourJavaDateObject);
		searchFinance.setIdp(user.getUserId());
		// start of check
				/*searchFinance.setMobile(user.getMobile());
				searchFinance.setLandLine(user.getLandLine());*/
				searchFinance.setAbnNumber(user.getAbnNumber());
				searchFinance.setEmail(user.getEmail());
				searchFinance.setDrivingLicense(user.getDrivingLicense());
				searchFinance.setMobCheck(user.isMobCheck());
				searchFinance.setIdCheck(user.isIdCheck());
				// end of check

		int searchFinCountTemp = user.getSearchFinCount();
		user.setSearchFinCount(searchFinCountTemp + 1);
		if (user.getSearchFinance() != null) {
			user.getSearchFinance().add(searchFinance);
		} else {
			List<SearchFinance> userFinanceLeads = new ArrayList<>();
			userFinanceLeads.add(searchFinance);
			user.setSearchFinance(userFinanceLeads);
		}
		userRepository.flush();
		// Start of loyality program
		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg
		ValTransPoints valTransPoints = new ValTransPoints();
		valTransPoints.setCreationDate(ourJavaDateObject);
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setId(searchFinance.getSearchFinanceId());
		valTransPoints.setName("FinReq");
		valTransPoints.setTypeOfTrans("FinReq");
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(valFinProvDiv);
		if (user.getValTransPoints() != null) {
			user.getValTransPoints().add(valTransPoints);
		} else {
			List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setValTransPoints(userInsuranceLeads);
		}
		// end of loyality program

		// Create Finance Leads when
		// dealer isFinancer
		List<Dealer> financeDealers = dealerRepository.getDealerForFinance(true);
		for (Dealer dealer : financeDealers) {
			DealerSearchFinance dealerSearchFinance = null;

			if (searchFinance != null) {
				// Create Dealer Finance Lead if he provides finance

				dealerSearchFinance = domainModelUtil.toDealerSearchFinance(userEBidVO.getFinanceLead());
				dealerSearchFinance.setUserId(user.getUserId());
				if (dealer.getDealSearchFinance() != null) {
					dealer.getDealSearchFinance().add(dealerSearchFinance);
				} else {
					List<DealerSearchFinance> dealerFinanceLeads = new ArrayList<>();
					dealerFinanceLeads.add(dealerSearchFinance);
					dealer.setDealSearchFinance(dealerFinanceLeads);
				}

			}

			dealerRepository.flush();

			/*
			 * if (dealer.isFinancer() && searchFinance != null &&
			 * userEBidVO.isFinance()) { createFinanceQuotation(user, dealer,
			 * searchFinance, dealerSearchFinance, inventory); } if
			 * (dealer.isInsurer() && searchInsurance != null &&
			 * userEBidVO.isInsurance()) { createInsuranceQuotation(user,
			 * dealer, searchInsurance, dealerSearchInsurance, inventory); }
			 */
		}

		return "{\"userId\":" + userEBidVO.getUserId() + "}";

	}

	// start
	@Override
	@Transactional
	public String whenUserEBidForTransServ(UserEBidTransServVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User Insurance Lead
		SearchTransp searchInsurance = domainModelUtil.toSearchTrans(userEBidVO.getSearchTranspLead());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		// searchInsurance.setCreationDate(ourJavaDateObject);
		searchInsurance.setIdp(user.getUserId());
		// start of check
	/*	searchInsurance.setMobile(user.getMobile());
		searchInsurance.setLandLine(user.getLandLine());*/
		searchInsurance.setAbnNumber(user.getAbnNumber());
		searchInsurance.setEmail(user.getEmail());
		searchInsurance.setDrivingLicense(user.getDrivingLicense());
		searchInsurance.setMobCheck(user.isMobCheck());
		searchInsurance.setIdCheck(user.isIdCheck());
		// end of check
		int searchTranCountTemp = user.getSearchTranspCount();
		user.setSearchTranspCount(searchTranCountTemp + 1);
		if (user.getSearchTransp() != null) {
			user.getSearchTransp().add(searchInsurance);
		} else {
			List<SearchTransp> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(searchInsurance);
			user.setSearchTransp(userInsuranceLeads);
		}
		userRepository.flush();
		// Start of loyality program
		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg

		ValTransPoints valTransPoints = new ValTransPoints();
		valTransPoints.setCreationDate(ourJavaDateObject);
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setId(searchInsurance.getSearchTranspId());
		valTransPoints.setName("TranspReq");
		valTransPoints.setTypeOfTrans("TranspReq");
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(valServProvDiv);
		if (user.getValTransPoints() != null) {
			user.getValTransPoints().add(valTransPoints);
		} else {
			List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setValTransPoints(userInsuranceLeads);
		}
		// end of loyality program

		// Get Inventory matching the User EBid for Car
		// (Model, Make, Year, Trim)

		/*
		 * String withOutSpace = searchInsurance.getVariant().replaceAll("%20",
		 * " "); System.out.println("without"+withOutSpace);
		 * System.out.println("with"+searchInsurance.getVariant());
		 */

		List<Inventory> inventories = inventoryRepository.getInventoryFor(String.valueOf(searchInsurance.getYear()),
				searchInsurance.getMake(), searchInsurance.getModel(), searchInsurance.getVariant());
		boolean present = false;
		for (Inventory inventory : inventories) {
			present = true;
			System.out.println("details" + inventory.getRepoId() + inventory.getModelYear()
					+ inventory.getModelDisplay() + inventory.getModelName() + inventory.getModelTrim());
			Dealer dealer = inventory.getDealer();

			DealerSearchTransp dealerSearchInsurance = null;

			// Create Dealer Insurance Lead if he provides insurance
			if (dealer.isSparesAccess()) {
				dealerSearchInsurance = domainModelUtil.toDealerSearchTransp(userEBidVO.getSearchTranspLead());
				dealerSearchInsurance.setUserId(user.getUserId());
				if (dealer.getDealSearchTransp() != null) {
					dealer.getDealSearchTransp().add(dealerSearchInsurance);
				} else {
					List<DealerSearchTransp> dealerInsuranceLeads = new ArrayList<>();
					dealerInsuranceLeads.add(dealerSearchInsurance);
					dealer.setDealSearchTransp(dealerInsuranceLeads);
				}
			}

			inventoryRepository.flush();
			System.out.println("isServMaint" + dealer.isServMaint());
			if (dealer.isServMaint()) {
				// createInsuranceQuotation(user, dealer, searchInsurance,
				// dealerSearchInsurance, inventory);
			}

		}
		System.out.println("present value" + present);
		if (!present) {
			System.out.println("inventory not present");
		}
		return "{\"userId\":" + userEBidVO.getUserId() + "}";

	}

	// end
	// start
	@Override
	@Transactional
	public String whenUserEBidForServMaint(UserEBidServMaintVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User Insurance Lead
		SearchServMaint searchInsurance = domainModelUtil.toSearchServMaint(userEBidVO.getServMaintLead());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		searchInsurance.setCreationDate(ourJavaDateObject);
		searchInsurance.setIdp(user.getUserId());
		// start of check
				/*searchInsurance.setMobile(user.getMobile());
				searchInsurance.setLandLine(user.getLandLine());*/
				searchInsurance.setAbnNumber(user.getAbnNumber());
				searchInsurance.setEmail(user.getEmail());
				searchInsurance.setDrivingLicense(user.getDrivingLicense());
				searchInsurance.setMobCheck(user.isMobCheck());
				searchInsurance.setIdCheck(user.isIdCheck());
				// end of check
		int searchServCountTemp = user.getSearchServCount();
		user.setSearchServCount(searchServCountTemp + 1);
		if (user.getSearchServMaint() != null) {
			user.getSearchServMaint().add(searchInsurance);
		} else {
			List<SearchServMaint> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(searchInsurance);
			user.setSearchServMaint(userInsuranceLeads);
		}
		userRepository.flush();

		// Start of loyality program
		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg
		ValTransPoints valTransPoints = new ValTransPoints();
		valTransPoints.setCreationDate(ourJavaDateObject);
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setId(searchInsurance.getSearchServMaintId());
		valTransPoints.setName("ServMaint");
		valTransPoints.setTypeOfTrans("ServMaint");
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(valServProvDiv);
		if (user.getValTransPoints() != null) {
			user.getValTransPoints().add(valTransPoints);
		} else {
			List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setValTransPoints(userInsuranceLeads);
		}
		// end of loyality program

		// Get Inventory matching the User EBid for Car
		// (Model, Make, Year, Trim)

		/*
		 * String withOutSpace = searchInsurance.getVariant().replaceAll("%20",
		 * " "); System.out.println("without"+withOutSpace);
		 * System.out.println("with"+searchInsurance.getVariant());
		 */

		List<Inventory> inventories = inventoryRepository.getInventoryFor(String.valueOf(searchInsurance.getYear()),
				searchInsurance.getMake(), searchInsurance.getModel(), searchInsurance.getVariant());
		boolean present = false;
		for (Inventory inventory : inventories) {
			present = true;
			System.out.println("details" + inventory.getRepoId() + inventory.getModelYear()
					+ inventory.getModelDisplay() + inventory.getModelName() + inventory.getModelTrim());
			Dealer dealer = inventory.getDealer();

			DealerSearchServMaint dealerSearchInsurance = null;

			// Create Dealer Insurance Lead if he provides insurance
			if (dealer.isServMaint()) {
				dealerSearchInsurance = domainModelUtil.toDealerSearchServMaint(userEBidVO.getServMaintLead());
				dealerSearchInsurance.setUserId(user.getUserId());
				if (dealer.getDealSearchServMaint() != null) {
					dealer.getDealSearchServMaint().add(dealerSearchInsurance);
				} else {
					List<DealerSearchServMaint> dealerInsuranceLeads = new ArrayList<>();
					dealerInsuranceLeads.add(dealerSearchInsurance);
					dealer.setDealSearchServMaint(dealerInsuranceLeads);
				}
			}

			inventoryRepository.flush();
			System.out.println("isServMaint" + dealer.isServMaint());
			if (dealer.isServMaint()) {
				// createInsuranceQuotation(user, dealer, searchInsurance,
				// dealerSearchInsurance, inventory);
			}

		}
		System.out.println("present value" + present);
		if (!present) {
			System.out.println("inventory not present");
		}
		return "{\"userId\":" + userEBidVO.getUserId() + "}";

	}
	// end

	@Override
	@Transactional
	public String whenUserEBidForInsurance(UserEBidInsuranceVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User Insurance Lead
		SearchInsurance searchInsurance = domainModelUtil.toSearchInsurance(userEBidVO.getInsuranceLead());
		Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		searchInsurance.setCreationDate(ourJavaDateObject);
		searchInsurance.setIdp(user.getUserId());
		// start of check
		/*searchInsurance.setMobile(user.getMobile());
		searchInsurance.setLandLine(user.getLandLine());*/
		searchInsurance.setAbnNumber(user.getAbnNumber());
		searchInsurance.setEmail(user.getEmail());
		searchInsurance.setDrivingLicense(user.getDrivingLicense());
		searchInsurance.setMobCheck(user.isMobCheck());
		searchInsurance.setIdCheck(user.isIdCheck());
				// end of check

		
		int searchInsCountTemp = user.getSearchInsCount();
		user.setSearchInsCount(searchInsCountTemp + 1);
		if (user.getSearchInsurance() != null) {
			user.getSearchInsurance().add(searchInsurance);
		} else {
			List<SearchInsurance> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(searchInsurance);
			user.setSearchInsurance(userInsuranceLeads);
		}
		userRepository.flush();

		// Start of loyality program
		// Retrieval from loyalityAdminProg
		List<LoyalityProgAdmin> loyalityProgAdmins = loyalityProgAdminRepository.getAllCriteria(true);
		// setting the ProvDiv value and actualDiv value
		// userReferPoints
		int userReferProvDiv = 0;
		int userReferActDiv = 0;
		int referedProvDiv = 0;
		int referedActDiv = 0;
		int revProvDiv = 0;
		int revActDiv = 0;
		int blogProvDiv = 0;
		int blogActDiv = 0;
		int valBuyProvDiv = 0;
		int valBuyActDiv = 0;
		int valSelProvDiv = 0;
		int valSelActDiv = 0;
		int valFinProvDiv = 0;
		int valFinActDiv = 0;
		int valInsProvDiv = 0;
		int valInsActDiv = 0;
		int valTrpProvDiv = 0;
		int valTrpActDiv = 0;
		int valServProvDiv = 0;
		int valServActDiv = 0;

		// Setting values

		for (LoyalityProgAdmin loyalityProgAdmin : loyalityProgAdmins) {
			userReferProvDiv = loyalityProgAdmin.getUserReferDivByAct1();
			userReferActDiv = loyalityProgAdmin.getUserReferDivByAct2();
			referedProvDiv = loyalityProgAdmin.getReferredDivByAct1();
			referedActDiv = loyalityProgAdmin.getReferredDivByAct2();
			revProvDiv = loyalityProgAdmin.getRevDivByAct1();
			revActDiv = loyalityProgAdmin.getRevDivByAct2();
			blogProvDiv = loyalityProgAdmin.getBlogDivByAct1();
			blogActDiv = loyalityProgAdmin.getBlogDivByAct2();
			valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();

			/*
			 * valBuyProvDiv = loyalityProgAdmin.getBuyCarDivByAct1();
			 * valBuyActDiv = loyalityProgAdmin.getBuyCarDivByAct2();
			 */
			valSelProvDiv = loyalityProgAdmin.getSellCarDivByAct1();
			valSelActDiv = loyalityProgAdmin.getSellCarDivByAct2();

			valFinProvDiv = loyalityProgAdmin.getFinCarDivByAct1();
			valFinActDiv = loyalityProgAdmin.getFinCarDivByAct2();

			valInsProvDiv = loyalityProgAdmin.getInsCarDivByAct1();
			valInsActDiv = loyalityProgAdmin.getInsCarDivByAct2();

			valServProvDiv = loyalityProgAdmin.getServCarDivByAct1();
			valServActDiv = loyalityProgAdmin.getServCarDivByAct2();

			valTrpProvDiv = loyalityProgAdmin.getTranspCarDivByAct1();
			valTrpActDiv = loyalityProgAdmin.getTranspCarDivByAct2();
		}
		// end of loyalityAdmiProg
		ValTransPoints valTransPoints = new ValTransPoints();
		valTransPoints.setCreationDate(ourJavaDateObject);
		valTransPoints.setIdp(user.getUserId());
		valTransPoints.setId(searchInsurance.getSearchInsuranceId());
		valTransPoints.setName("InsReq");
		valTransPoints.setTypeOfTrans("InsReq");
		valTransPoints.setAction("INITIATED");
		valTransPoints.setNoOfPoints(valInsProvDiv);
		if (user.getValTransPoints() != null) {
			user.getValTransPoints().add(valTransPoints);
		} else {
			List<ValTransPoints> userInsuranceLeads = new ArrayList<>();
			userInsuranceLeads.add(valTransPoints);
			user.setValTransPoints(userInsuranceLeads);
		}
		// end of loyality program

		// Create insurance Leads
		// when dealer isInsurer
		List<Dealer> insuranceDealers = dealerRepository.getDealerForInsurance(true);
		for (Dealer dealer : insuranceDealers) {
			DealerSearchInsurance dealerSearchInsurance = null;

			if (searchInsurance != null) {
				// Create Dealer Insurance Lead if he provides insurance
				if (dealer.isInsurer()) {
					dealerSearchInsurance = domainModelUtil.toDealerSearchInsurance(userEBidVO.getInsuranceLead());
					dealerSearchInsurance.setUserId(user.getUserId());
					if (dealer.getDealSearchInsurance() != null) {
						dealer.getDealSearchInsurance().add(dealerSearchInsurance);
					} else {
						List<DealerSearchInsurance> dealerInsuranceLeads = new ArrayList<>();
						dealerInsuranceLeads.add(dealerSearchInsurance);
						dealer.setDealSearchInsurance(dealerInsuranceLeads);
					}
				}
			}

			/*
			 * if (dealer.isFinancer() && searchFinance != null &&
			 * userEBidVO.isFinance()) { createFinanceQuotation(user, dealer,
			 * searchFinance, dealerSearchFinance, inventory); } if
			 * (dealer.isInsurer() && searchInsurance != null &&
			 * userEBidVO.isInsurance()) { createInsuranceQuotation(user,
			 * dealer, searchInsurance, dealerSearchInsurance, inventory); }
			 */
			dealerRepository.flush();
		}

		return "{\"userId\":" + userEBidVO.getUserId() + "}";

	}

	@Override
	@Transactional
	public String createMyVehicle(UserMyVehicleVO userEBidVO) {

		// Find the User
		User user = userRepository.findOne(userEBidVO.getUserId());

		// Create User MyVehicle Details (MyVehicle details)
		MyVehicle search = domainModelUtil.toMyVehicle(userEBidVO.getMyVehicleVO());
		search.setIdp(user.getUserId());
		if (user.getMyVehicle() != null) {
			user.getMyVehicle().add(search);
		} else {
			List<MyVehicle> userVehicleLeads = new ArrayList<>();
			userVehicleLeads.add(search);
			user.setMyVehicle(userVehicleLeads);
		}

		userRepository.flush();

		return "{\"userId\":" + userEBidVO.getUserId() + ",\"myVehicleId\":" + search.getMyVehicleId() + "}";

	}

	private void createVehicleQuotation(User user, Dealer dealer, Search search, DealerSearch dealerSearch,
			Inventory inventory) {
		System.out.println("create quotation when dealer ID" + dealer.getDealerId());
		VehicleQuotation vehicleQuotation = new VehicleQuotation();
		vehicleQuotation.setDealerId(dealer.getDealerId());
		vehicleQuotation.setUserId(user.getUserId());
		vehicleQuotation.setDealSearchId(dealerSearch.getDealerSearchId());
		vehicleQuotation.setCarSearchId(search.getCarSearchId());
		vehicleQuotation.setRefId(inventory.getRepoId());
		vehicleQuotation.setAutoBid(inventory.isStockItem());
		vehicleQuotation.setDealerStockNo(inventory.getVendorStockNo());
		vehicleQuotation.setDriveAwayPrice(inventory.getPrice());
		vehicleQuotation.setModelYear(inventory.getModelYear());
		vehicleQuotation.setModelDisplay(inventory.getModelDisplay());
		vehicleQuotation.setModelName(inventory.getModelName());
		vehicleQuotation.setModelTrim(inventory.getModelTrim());
		vehicleQuotationRepository.save(vehicleQuotation);

	}

	private void createFinanceQuotation(User user, Dealer dealer, SearchFinance userSearchFinance,
			DealerSearchFinance dealerSearchFinance, Inventory inventory) {

		FinanceQuotation financeQuotation = new FinanceQuotation();
		financeQuotation.setDealerId(dealer.getDealerId());
		financeQuotation.setUserId(user.getUserId());
		financeQuotation.setDealSearchId(dealerSearchFinance.getDealerSearchFinanceId());
		financeQuotation.setCarSearchId(userSearchFinance.getSearchFinanceId());
		financeQuotation.setRefId(inventory.getRepoId());
		financeQuotation.setAutoBid(inventory.isStockItem());
		financeQuotationRepository.save(financeQuotation);

	}

	private void createInsuranceQuotation(User user, Dealer dealer, SearchInsurance userSearchInsurance,
			DealerSearchInsurance dealerSearchInsurance, Inventory inventory) {

		InsuranceQuotation insuranceQuotation = new InsuranceQuotation();
		insuranceQuotation.setDealerId(dealer.getDealerId());
		insuranceQuotation.setUserId(user.getUserId());
		insuranceQuotation.setDealSearchId(dealerSearchInsurance.getDealerSearchInsuranceId());
		insuranceQuotation.setCarSearchId(userSearchInsurance.getSearchInsuranceId());
		insuranceQuotation.setRefId(inventory.getRepoId());
		insuranceQuotation.setAutoBid(inventory.isStockItem());
		insuranceQuotationRepository.save(insuranceQuotation);

	}

	private void createServMaintQuotation(User user, Dealer dealer, SearchServMaint userSearchInsurance,
			DealerSearchServMaint dealerSearchInsurance, Inventory inventory) {

		/*
		 * InsuranceQuotation insuranceQuotation = new InsuranceQuotation();
		 * insuranceQuotation.setDealerId(dealer.getDealerId());
		 * insuranceQuotation.setUserId(user.getUserId());
		 * insuranceQuotation.setDealSearchId(dealerSearchInsurance.
		 * getDealerSearchInsuranceId());
		 * insuranceQuotation.setCarSearchId(userSearchInsurance.
		 * getSearchInsuranceId());
		 * insuranceQuotation.setRefId(inventory.getRepoId());
		 * insuranceQuotation.setAutoBid(inventory.isStockItem());
		 * insuranceQuotationRepository.save(insuranceQuotation);
		 */

	}

	@Override
	public List<SearchVO> getSearchByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<SearchVO> searchVOs = new ArrayList<SearchVO>();
		List<Search> searchs = userSearclLeadRepository.getSearchByUserId(userid);
		SearchVO searchVO;
		for (Search search : searchs) {
			searchVO = domainModelUtil.toBatchSearchVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<InventoryVO> getSellMyVehByUserId(Long userid) {
		// TODO Auto-generated method stub
		Long id = new Long(35);
		List<InventoryVO> searchVOs = new ArrayList<InventoryVO>();
		List<Inventory> searchs = inventoryRepository.getAllInvForSellMy(userid, id);
		InventoryVO searchVO;
		for (Inventory search : searchs) {
			searchVO = domainModelUtil.toMyVehInvVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<UserReferPointsVO> getReferUserId(Long userid) {

		List<UserReferPointsVO> searchVOs = new ArrayList<UserReferPointsVO>();
		List<UserReferPoints> searchs = userReferPointsRepository.getReferByUserId(userid);
		UserReferPointsVO searchVO;
		for (UserReferPoints search : searchs) {
			searchVO = domainModelUtil.toUserReferVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<ReferencedPointsVO> getReferencedUserId(Long userid) {

		List<ReferencedPointsVO> searchVOs = new ArrayList<ReferencedPointsVO>();
		List<ReferencedPoints> searchs = referencedPointsRepository.getReferByUserId(userid);
		ReferencedPointsVO searchVO;
		for (ReferencedPoints search : searchs) {
			searchVO = domainModelUtil.toRefercedVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<BlogPointsVO> getBlogUserId(Long userid) {

		List<BlogPointsVO> searchVOs = new ArrayList<BlogPointsVO>();
		List<BlogPoints> searchs = blogPointsRepository.getReferByUserId(userid);
		BlogPointsVO searchVO;
		for (BlogPoints search : searchs) {
			searchVO = domainModelUtil.toBlogPointsVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<ReviewPointsVO> getReviewUserId(Long userid) {

		List<ReviewPointsVO> searchVOs = new ArrayList<ReviewPointsVO>();
		List<ReviewPoints> searchs = reviewPointsRepository.getReferByUserId(userid);
		ReviewPointsVO searchVO;
		for (ReviewPoints search : searchs) {
			searchVO = domainModelUtil.toReviewPointsVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<ValTransPointsVO> getValTransUserId(Long userid) {

		List<ValTransPointsVO> searchVOs = new ArrayList<ValTransPointsVO>();
		List<ValTransPoints> searchs = valTransPointsRepository.getReferByUserId(userid);
		ValTransPointsVO searchVO;
		for (ValTransPoints search : searchs) {
			searchVO = domainModelUtil.toValTransPointsVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<LoyalityProgAdminVO> getLoayalityProgram() {

		List<LoyalityProgAdminVO> searchVOs = new ArrayList<LoyalityProgAdminVO>();
		List<LoyalityProgAdmin> searchs = loyalityProgAdminRepository.getAllSearchCriteria();
		LoyalityProgAdminVO searchVO;
		for (LoyalityProgAdmin search : searchs) {
			searchVO = domainModelUtil.toLoyalityProgVO(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<SearchFinanceVO> getFinanceByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<SearchFinanceVO> searchVOs = new ArrayList<SearchFinanceVO>();
		List<SearchFinance> searchs = searchFinanceRepository.getFinanceByUserId(userid);
		SearchFinanceVO searchVO;
		for (SearchFinance search : searchs) {
			searchVO = domainModelUtil.toSearchFinance1(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<SearchInsuranceVO> getInsuranceByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<SearchInsuranceVO> searchVOs = new ArrayList<SearchInsuranceVO>();
		List<SearchInsurance> searchs = searchInsuranceRepository.getInsuranceByUserId(userid);
		SearchInsuranceVO searchVO;
		for (SearchInsurance search : searchs) {
			searchVO = domainModelUtil.toSearchInsurance1(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<SearchServMaintVO> getServMaintByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<SearchServMaintVO> searchVOs = new ArrayList<SearchServMaintVO>();
		List<SearchServMaint> searchs = searchServMtRepository.getServMtByUserId(userid);
		SearchServMaintVO searchVO;
		for (SearchServMaint search : searchs) {
			searchVO = domainModelUtil.toSearchServMaint1(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<SearchTranspVO> getTranspByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<SearchTranspVO> searchVOs = new ArrayList<SearchTranspVO>();
		List<SearchTransp> searchs = searchTranspRepository.getTranspByUserId(userid);
		SearchTranspVO searchVO;
		for (SearchTransp search : searchs) {
			searchVO = domainModelUtil.toSearchTransp1(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<CurrentOffersVO> getCurrentOffers() {
		// TODO Auto-generated method stub
		List<CurrentOffersVO> searchVOs = new ArrayList<CurrentOffersVO>();
		List<CurrentOffers> searchs = currentOffersRepository.findAll();
		CurrentOffersVO searchVO;
		for (CurrentOffers search : searchs) {
			searchVO = domainModelUtil.fromCurrentOffers(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<UserNotificationVO> getUserNotiByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<UserNotificationVO> searchVOs = new ArrayList<UserNotificationVO>();
		List<UserNotification> searchs = userNotificationRepository.getUserNotByUserId(userid);
		UserNotificationVO searchVO;
		for (UserNotification search : searchs) {
			searchVO = domainModelUtil.toSearchTransp1(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public UserNotificationVO getUserNotiByID(long id) {
		
		
		UserNotificationVO dealerVO = null;
		UserNotification dealer = userNotificationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromUserNotif(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public MyVehicleVO getMyVehiByID(long id) {
		
		
		MyVehicleVO dealerVO = null;
		MyVehicle dealer = myVehicleRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromMyVehicleById(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	
	@Override
	public VehicleQuotationVO getVehQuotaByID(long id) {
		
		
		VehicleQuotationVO dealerVO = null;
		VehicleQuotation dealer = vehicleQuotationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromVehiQuota(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	
	@Override
	public List<VehicleQuotationVO> getVehQuotaByUserIDEbidId(long userid, long eBidid) {
		
		
		List<VehicleQuotationVO> searchVOs = new ArrayList<VehicleQuotationVO>();
		List<VehicleQuotation> searchs = vehicleQuotationRepository.getQuotationsForUserIdEbidId(userid,eBidid );
		VehicleQuotationVO searchVO;
		for (VehicleQuotation search : searchs) {
			searchVO = domainModelUtil.fromVehicleQuotation(search, false);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
		
		
		
	}
	
	@Override
	public List<VehicleQuotation> getVehQuotaByUserID(long userid) {
		
		
		
		return vehicleQuotationRepository.getQuotForUserChat(userid );
		
		
		
	}
	
	
	
	@Override
	public FinanceQuotationVO getFinQuotaByID(long id) {
		
		
		FinanceQuotationVO dealerVO = null;
		FinanceQuotation dealer = financeQuotationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromFinanQuota(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public InsuranceQuotationVO getInsQuotaByID(long id) {
		
		
		InsuranceQuotationVO dealerVO = null;
		InsuranceQuotation dealer = insuranceQuotationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromInsQuota(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public ServiceMaintQuotationVO getServMaintQuotaByID(long id) {
		
		
		ServiceMaintQuotationVO dealerVO = null;
		ServiceMaintQuotation dealer = servMaintQuotationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromServQuota(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	
	@Override
	public TranspServiceQuotationVO getTranpQuotaByID(long id) {
		
		
		TranspServiceQuotationVO dealerVO = null;
		TranspServiceQuotation dealer = transpServQuotationRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromTranpQuota(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	
	
	@Override
	public CurrentOffersVO getCurrentOfferByID(long id) {
		
		
		CurrentOffersVO dealerVO = null;
		CurrentOffers dealer = currentOffersRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromCurrentOfferId(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public SearchFinanceVO getFinanceByID(long id) {
		
		
		SearchFinanceVO dealerVO = null;
		SearchFinance dealer = searchFinanceRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromSearchFinance(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public SearchInsuranceVO getInsuranceByID(long id) {
		
		
		SearchInsuranceVO dealerVO = null;
		SearchInsurance dealer = searchInsuranceRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromSearchInsurance(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	
	@Override
	public SearchServMaintVO getServMaintByID(long id) {
		
		
		SearchServMaintVO dealerVO = null;
		SearchServMaint dealer = searchServMtRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromSearchServMaint(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public SearchTranspVO getTranpByID(long id) {
		
		
		SearchTranspVO dealerVO = null;
		SearchTransp dealer = searchTranspRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromSearchTranp(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public SearchVO getSearchByID(long id) {
		
		
		SearchVO dealerVO = null;
		Search dealer = userSearclLeadRepository.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromSearch(dealer);
			
		}	
		return dealerVO;
		
		
	}
	
	@Override
	public String getNameByUserID(long id) {
		
		User user = userRepository.findOne(id);
		String name = user.getFirstName() + user.getLastName();
		return name;
	}
	
	
	@Override
	public List<VehicleQuotationVO> getUserQuotByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<VehicleQuotationVO> searchVOs = new ArrayList<VehicleQuotationVO>();
		List<VehicleQuotation> searchs = vehicleQuotationRepository.getQuotationsForUser(userid);
		VehicleQuotationVO searchVO;
		for (VehicleQuotation search : searchs) {
			searchVO = domainModelUtil.fromVehicleQuotation(search, false);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<FinanceQuotationVO> getFinQuotByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<FinanceQuotationVO> searchVOs = new ArrayList<FinanceQuotationVO>();
		List<FinanceQuotation> searchs = financeQuotationRepository.getQuotationsForUser(userid);
		FinanceQuotationVO searchVO;
		for (FinanceQuotation search : searchs) {
			searchVO = domainModelUtil.fromFinanceQuotation(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<InsuranceQuotationVO> getInsQuotByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<InsuranceQuotationVO> searchVOs = new ArrayList<InsuranceQuotationVO>();
		List<InsuranceQuotation> searchs = insuranceQuotationRepository.getQuotationsForUser(userid);
		InsuranceQuotationVO searchVO;
		for (InsuranceQuotation search : searchs) {
			searchVO = domainModelUtil.fromInsuranceQuotation(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<ServiceMaintQuotationVO> getServMQuotByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<ServiceMaintQuotationVO> searchVOs = new ArrayList<ServiceMaintQuotationVO>();
		List<ServiceMaintQuotation> searchs = servMaintQuotationRepository.getQuotationsForUser(userid);
		ServiceMaintQuotationVO searchVO;
		for (ServiceMaintQuotation search : searchs) {
			searchVO = domainModelUtil.fromServMaintQuotation(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<TranspServiceQuotationVO> getTranspQuotByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<TranspServiceQuotationVO> searchVOs = new ArrayList<TranspServiceQuotationVO>();
		List<TranspServiceQuotation> searchs = transpServQuotationRepository.getQuotationsForUser(userid);
		TranspServiceQuotationVO searchVO;
		for (TranspServiceQuotation search : searchs) {
			searchVO = domainModelUtil.fromTranspServQuotation(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}

	@Override
	public List<MyVehicleVO> getMyVehicleByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<MyVehicleVO> searchVOs = new ArrayList<MyVehicleVO>();
		List<MyVehicle> searchs = myVehicleRepository.getMyVehicleByUserId(userid);
		MyVehicleVO searchVO;
		for (MyVehicle search : searchs) {
			searchVO = domainModelUtil.fromMyVehicle(search);
			// BeanUtils.copyProperties(searchVO, search);
			searchVOs.add(searchVO);
		}
		return searchVOs;
	}
}
