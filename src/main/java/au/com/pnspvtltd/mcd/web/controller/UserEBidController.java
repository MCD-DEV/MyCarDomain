package au.com.pnspvtltd.mcd.web.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.DealerQuotationHistory;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.MyVehicleFuelExpenses;
import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;
import au.com.pnspvtltd.mcd.domain.MyVehicleServMaint;
import au.com.pnspvtltd.mcd.domain.ReferencedPoints;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.SearchFinance;
import au.com.pnspvtltd.mcd.domain.SearchInsurance;
import au.com.pnspvtltd.mcd.domain.SearchServMaint;
import au.com.pnspvtltd.mcd.domain.SearchTransp;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserNotification;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocs;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocsFin;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocsIns;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocsServ;
import au.com.pnspvtltd.mcd.domain.UserQuotaDocsTranp;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqBookSlotServ;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqBookSlotTranp;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDrive;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDriveFin;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDriveIns;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDriveServ;
import au.com.pnspvtltd.mcd.domain.UserQuotaReqTestDriveTranp;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryFin;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryIns;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryServ;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryTranp;
import au.com.pnspvtltd.mcd.domain.UserReferPoints;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleFuelExpensesRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleLogBookRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleServMaintRepository;
import au.com.pnspvtltd.mcd.repository.SearchFinanceRepository;
import au.com.pnspvtltd.mcd.repository.SearchInsuranceRepository;
import au.com.pnspvtltd.mcd.repository.SearchServMtLeadRepository;
import au.com.pnspvtltd.mcd.repository.SearchTranspRepository;
import au.com.pnspvtltd.mcd.repository.ServMaintQuotationRepository;
import au.com.pnspvtltd.mcd.repository.TranspServQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserNotificationRepository;
import au.com.pnspvtltd.mcd.repository.UserQuotationHistoryRepo;
import au.com.pnspvtltd.mcd.repository.UserQuotationHistoryRepoFin;
import au.com.pnspvtltd.mcd.repository.UserQuotationHistoryRepoIns;
import au.com.pnspvtltd.mcd.repository.UserQuotationHistoryRepoServ;
import au.com.pnspvtltd.mcd.repository.UserQuotationHistoryRepoTranp;
import au.com.pnspvtltd.mcd.repository.UserReferPointsRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.UserSearchLeadRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.service.SmtpMailSender;
import au.com.pnspvtltd.mcd.service.UserEBidService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.BlogPointsVO;
import au.com.pnspvtltd.mcd.web.model.CurrentOffersVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.LoyalityProgAdminVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelExpensesVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.QuotaDocVO;
import au.com.pnspvtltd.mcd.web.model.QuotaInterestVO;
import au.com.pnspvtltd.mcd.web.model.ReferencedPointsVO;
import au.com.pnspvtltd.mcd.web.model.ReviewPointsVO;
import au.com.pnspvtltd.mcd.web.model.SampleSuccessVO;
import au.com.pnspvtltd.mcd.web.model.SearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.SearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.SearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.SearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.UserAdminInviteMailVO;
import au.com.pnspvtltd.mcd.web.model.UserAdminSearchVO;
import au.com.pnspvtltd.mcd.web.model.UserChatAllVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidFinanceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidServMaintVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidTransServVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidVO;
import au.com.pnspvtltd.mcd.web.model.UserFinAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserInsAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserMyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserNotificationVO;
import au.com.pnspvtltd.mcd.web.model.UserPhotoVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaAllSingleVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaAllVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaDocVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaReqBookSlotServVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaReqBookSlotTranpVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotaReqTestDriveVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryFinVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryInsVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryServVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryTranpVO;
import au.com.pnspvtltd.mcd.web.model.UserQuotationHistoryVO;
import au.com.pnspvtltd.mcd.web.model.UserReferPointsVO;
import au.com.pnspvtltd.mcd.web.model.UserSearchAdminOtDateVO;
import au.com.pnspvtltd.mcd.web.model.UserSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserServiceMaintAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserServiceSlotVO;
import au.com.pnspvtltd.mcd.web.model.UserTranspAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserTransportSlotVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.ValTransPointsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleUserChatVO;
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "*")
@RestController

public class UserEBidController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserEBidController.class);

	@Autowired
	private SmtpMailSender smtp;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSearchLeadRepository userSearchLeadRepository;
	
	@Autowired
	private UserNotificationRepository userNotificationRepository;
	@Autowired
	private SearchServMtLeadRepository searchServMtLeadRepository;
	@Autowired
	private SearchTranspRepository searchTranspRepository;
	@Autowired
	private SearchFinanceRepository searchFinanceRepository;
	@Autowired
	private SearchInsuranceRepository searchInsuranceRepository;
	
	@Autowired
	UserEBidService userEBidService;
	@Autowired
	VehicleQuotationRepository vehicleQuotationRepository;
	@Autowired
	MyVehicleLogBookRepository myVehicleLogBookRepository;
	@Autowired
	MyVehicleFuelExpensesRepository myVehicleFuelExpensesRepository;
	@Autowired
	MyVehicleServMaintRepository myVehicleServMaintRepository;
	
	@Autowired
	private DomainModelUtil domainModelUtil;
	
	@Autowired
	MyVehicleRepository myVehicleRepository;
	
	@Autowired
	UserQuotationHistoryRepo userQuotationHistoryRepo;
	
	@Autowired
	UserQuotationHistoryRepoFin userQuotationHistoryRepoFin;
	
	@Autowired
	UserQuotationHistoryRepoIns userQuotationHistoryRepoIns;

	@Autowired
	FinanceQuotationRepository financeQuotationRepository;
	
	
	@Autowired
	InsuranceQuotationRepository insuranceQuotationRepository;
	
	
	@Autowired
	ServMaintQuotationRepository serviceQuotationRepository;
	
	
	@Autowired
	TranspServQuotationRepository transQuotationRepository;
	
	@Autowired
	UserQuotationHistoryRepoServ userQuotationHistoryRepoServ;
	
	@Autowired
	UserQuotationHistoryRepoTranp userQuotationHistoryRepoTranp;
	@Autowired
	UserReferPointsRepository userReferPointsRepository;

	@GetMapping(value = "getSearchByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<SearchVO> getSearchByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to CarSearc");
		return userEBidService.getSearchByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getSearchById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchVO getSearchById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getSearchByID(id);
	}
	
	@GetMapping(value = "getReferUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserReferPointsVO> getReferUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to loyality refer");
		return userEBidService.getReferUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getReferredDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserReferPointsVO> getReferredDetails()
	{
		LOGGER.debug("Received request to loyality referred Details");
		return userEBidService.getReferredDetails();
		//return null;
	}
	
	@GetMapping(value = "getReferencedUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ReferencedPointsVO> getReferencedUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to loyality referenced");
		return userEBidService.getReferencedUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getBlogUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<BlogPointsVO> getBlogUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to loyality blog");
		return userEBidService.getBlogUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getReviewUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ReviewPointsVO> getReviewUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to loyality Review");
		return userEBidService.getReviewUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getValTransUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ValTransPointsVO> getValTransUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to loyality Review");
		return userEBidService.getValTransUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getLoyalityProgram", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<LoyalityProgAdminVO> getLoayalityProgram()
	{
		LOGGER.debug("Received request to loyality admin");
		return userEBidService.getLoayalityProgram();
		//return null;
	}
	
	@GetMapping(value = "getSellMyVehCarUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<InventoryVO> getSellMyVehCarUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to sell My Vehicle");
		return userEBidService.getSellMyVehByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getFinanceByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<SearchFinanceVO> getFinanceByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to CarFinance");
		return userEBidService.getFinanceByUserId(userid);
		//return null;
	}
	
	
	@GetMapping(value = "getFinanceById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchFinanceVO getFinanceById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getFinanceByID(id);
	}
	
	
	@GetMapping(value = "getInsuranceByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<SearchInsuranceVO> getInsuranceByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to CarInsurance");
		return userEBidService.getInsuranceByUserId(userid);
		//return null;
	}
	
	
	@GetMapping(value = "getInsuranceById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchInsuranceVO getInsuranceById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getInsuranceByID(id);
	}
	
	
	@GetMapping(value = "getServMtByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<SearchServMaintVO> getServMtByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to CarServMaint");
		return userEBidService.getServMaintByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getServMaintById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchServMaintVO getServMaintById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getServMaintByID(id);
	}
	
	@GetMapping(value = "getTranspByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<SearchTranspVO> getTranspByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to CarTransp");
		return userEBidService.getTranspByUserId(userid);
		//return null;
	}
	
	
	@GetMapping(value = "getTranspById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchTranspVO getTranspById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getTranpByID(id);
	}
	
	
	@GetMapping(value = "getUseNotByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserNotificationVO> getUseNotByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to userNotiF");
		return userEBidService.getUserNotiByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getUserNotById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserNotificationVO getUserNotById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getUserNotiByID(id);
	}
	
	
	@GetMapping(value = "getCurrentOffers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CurrentOffersVO> getCurrentOffers()
	{
		LOGGER.debug("Received request to current offers");
		return userEBidService.getCurrentOffers();
		//return null;
	}
	
	
	@GetMapping(value = "getCurrentOffersById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CurrentOffersVO getCurrentOffersById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getCurrentOfferByID(id);
	}
	
	
	@GetMapping(value = "getVehQuotaByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<VehicleQuotationVO> getVehQuotaByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user vehicle Quotation");
		return userEBidService.getUserQuotByUserId(userid);
		//return null;
	}
	
	
	@GetMapping(value = "getVehQuotaById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public VehicleQuotationVO getVehQuotaById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getVehQuotaByID(id);
	}
	
	
	@GetMapping(value = "getVehQuotaByUserIdEbidId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserQuotaAllVO getVehQuotaByUserIdEbidId(@RequestParam("userid") Long userid, @RequestParam("ebidid") Long eBidId, @RequestParam("typeOfQuota") String typeOfQuota) {
		LOGGER.debug("Received request to user Quotation and EbidId type");
		UserQuotaAllVO userQuotaAllVO = new UserQuotaAllVO();
		
		if(typeOfQuota.equals("vehicle")){
			userQuotaAllVO.setVehicleQuotationVO(userEBidService.getVehQuotaByUserIDEbidId(userid, eBidId));
		}
		else if (typeOfQuota.equals("finance")){
			userQuotaAllVO.setFinanceQuotationVO(userEBidService.getFinQuotaByUserIDEbidId(userid, eBidId));
		}
		else if (typeOfQuota.equals("insurance")){
			userQuotaAllVO.setInsuranceQuotationVO(userEBidService.getInsQuotaByUserIDEbidId(userid, eBidId));
		}
		else if (typeOfQuota.equals("service")){
			userQuotaAllVO.setServiceMaintQuotationVO(userEBidService.getServQuotaByUserIDEbidId(userid, eBidId));
		}
		else if (typeOfQuota.equals("transport")){
			userQuotaAllVO.setTranspServiceQuotationVO(userEBidService.getTranspQuotaByUserIDEbidId(userid, eBidId));
		}
		return userQuotaAllVO;
	}
	
		
	
	@GetMapping(value = "getFinQuotaByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FinanceQuotationVO> getFinQuotaByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user Finance Quotation");
		return userEBidService.getFinQuotByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getFinQuotaById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public FinanceQuotationVO getFinQuotaById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getFinQuotaByID(id);
	}
	
	
	
	@GetMapping(value = "getInsQuotaByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<InsuranceQuotationVO> getInsQuotaByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user Insurance Quotation");
		return userEBidService.getInsQuotByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getInsQuotaById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public InsuranceQuotationVO getInsQuotaById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getInsQuotaByID(id);
	}
	
	
	@GetMapping(value = "getServMQuotaByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ServiceMaintQuotationVO> getServMQuotaByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user serv && Main Quotation");
		return userEBidService.getServMQuotByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getServMaintQuotaById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ServiceMaintQuotationVO getServMaintQuotaById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getServMaintQuotaByID(id);
	}
	
	
	@GetMapping(value = "getTranpQuotaByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TranspServiceQuotationVO> getTranpQuotaByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user Transport Quotation");
		return userEBidService.getTranspQuotByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getTranpQuotaById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TranspServiceQuotationVO getTranpQuotaById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getTranpQuotaByID(id);
	}
	
	
	@GetMapping(value = "getLogBookByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MyVehicleVO> getLogBookByUserId(@RequestParam("userid") Long userid)
	{
		LOGGER.debug("Received request to user MyVehicle Garage");
		return userEBidService.getMyVehicleByUserId(userid);
		//return null;
	}
	
	@GetMapping(value = "getMyVehiById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MyVehicleVO getMyVehiById(@PathVariable Long id, HttpServletResponse response) {
		return userEBidService.getMyVehiByID(id);
	}
	
	
	@PostMapping("eBid/userReferPoints")
	public UserReferPoints userReferPoints(@RequestBody UserReferPointsVO userEBidVO) {
		
		UserReferPoints userReferPoint = userEBidService.whenUserReferUserId(userEBidVO);
		//UserReferPoints userReferPoint = new UserReferPoints();
		if(userReferPoint.getAction().equalsIgnoreCase("INITIATED")){
			try {
				smtp.sendMail(userEBidVO.getfName(),userEBidVO.getlName(),userEBidVO.getFirstName(),userEBidVO.getLastName(),userEBidVO.getReferedEmailId(), "Autoscoop Notification",
						"You have been successfully Registered");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userReferPoint;
	}
	
	
	@PostMapping("eBid/sendInviteEmailFrAd")
	public UserAdminInviteMailVO sendInviteEmailFrAd(@RequestBody UserAdminInviteMailVO userEBidVO) {
		
		
		//UserReferPoints userReferPoint = new UserReferPoints();
			try {
				smtp.sendMail(userEBidVO.getfName(),userEBidVO.getlName(),userEBidVO.getFirstName(),userEBidVO.getLastName(),userEBidVO.getReferedEmailId(), "Autoscoop Notification",
						"You have been successfully Registered");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return userEBidVO;
	}
	
	
	@PostMapping("eBid/questionRealLoyal")
	public UserReferPoints questionRealLoyal(@RequestBody UserReferPointsVO userEBidVO) {
		
		//UserReferPoints userReferPoint = userEBidService.whenUserReferUserId(userEBidVO);
		UserReferPoints userReferPoint = new UserReferPoints();
		//if(userReferPoint.getAction().equalsIgnoreCase("INITIATED")){
			try {
				smtp.sendMailQuestion(userEBidVO.getfName(),userEBidVO.getFirstName(),userEBidVO.getLastName(),userEBidVO.getReferedEmailId(), "Question / Suggestion",
						"You have been successfully Registered");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
		return userReferPoint;
	}
	@PostMapping("eBid/welcomeMail")
	public User welcomeMail(@RequestBody UserVO userVO) {
		
		User user = userRepository.findOne(userVO.getUserId());
		
		if(!user.isWelstatus()){
			try {
				smtp.sendMailWelcome(user.getFirstName(),user.getLastName(),user.getEmail(), "Autoscoop Welcome Mail",
						"You have been successfully Welcome");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setWelstatus(true);
			userRepository.flush();
		}
		
		return user;
	}
	
	@PostMapping("eBid/referencedPoints")
	public ReferencedPoints referencedPoints(@RequestBody ReferencedPointsVO userEBidVO) {
		return userEBidService.whenReferedUserId(userEBidVO);
	}
	@PostMapping("eBid/car")
	public String eBidForCar(@RequestBody UserEBidVO userEBidVO) {
		return userEBidService.whenUserEBidForCar(userEBidVO);
	}
	
	@PostMapping("eBid/insurance")
	public String eBidForInsurance(@RequestBody UserEBidInsuranceVO userEBidVO) {
		return userEBidService.whenUserEBidForInsurance(userEBidVO);
	}
	@PostMapping("eBid/finance")
	public String eBidForFinance(@RequestBody UserEBidFinanceVO userEBidVO) {
		return userEBidService.whenUserEBidForFinance(userEBidVO);
	}
	@PostMapping("eBid/transserv")
	public String eBidForTransServ(@RequestBody UserEBidTransServVO userEBidVO) {
		return userEBidService.whenUserEBidForTransServ(userEBidVO);
	}
	
	@PostMapping("eBid/servmaint")
	public String eBidForServMaint(@RequestBody UserEBidServMaintVO userEBidVO) {
		return userEBidService.whenUserEBidForServMaint(userEBidVO);
	}
	@PostMapping("eBid/myVehicle")
	public String addMyVehicle(@RequestBody UserMyVehicleVO userEBidVO) {
		return userEBidService.createMyVehicle(userEBidVO);
	}
	
	@PutMapping("updatePhoto")
	@Transactional
	public User updatePhoto(@RequestBody UserPhotoVO userMyVehicleVO,
			HttpServletResponse response) {
		User user = new User();
		LOGGER.debug("Received request to update photo {}", userMyVehicleVO.getUserId());
	    //TODO: create a service for VehicleQutotation to update quotation details
		if(userMyVehicleVO != null){
			user = userRepository.findOne(userMyVehicleVO.getUserId());
			user.setIssueState(userMyVehicleVO.getPhoto());
			user.setFirstName(userMyVehicleVO.getFirstName());
			user.setLastName(userMyVehicleVO.getLastName());
			user.setState(userMyVehicleVO.getState());
			user.setStreetName(userMyVehicleVO.getStreetName());
			user.setStreetNumber(userMyVehicleVO.getStreetName());
			user.setPostCode(userMyVehicleVO.getPostCode());
			user.setSubOrb(userMyVehicleVO.getDesc()); // desc
			user.setAbnNumber(userMyVehicleVO.getPhoneNumber());   // phonenumber
			user.setDrivingLicense(userMyVehicleVO.getRegion()); // region
			user.setDateOfBirth(userMyVehicleVO.getDob()); // dob
			user.setGender(userMyVehicleVO.getGender()); // dob
			//user.setAreaName(userMyVehicleVO.); // phone number
			//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return user;
	}
	
	
	// serv time slot start

	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "serviceslotupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ServiceMaintQuotationVO serviceSlotUpdate(@RequestBody UserServiceSlotVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("Service Book Slot Creation", dealerSubscriptionSBLVO.getQuotId());
		
		ServiceMaintQuotation vehicleQuotation = serviceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
		
		
		
		List<UserQuotaReqBookSlotServVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqBookSlotServVO();
		List<UserQuotaReqBookSlotServ> vehicleDealerDetailsList = new ArrayList<UserQuotaReqBookSlotServ>();
		boolean saved = false;
		for (UserQuotaReqBookSlotServVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			UserQuotaReqBookSlotServ vehicleDealerDetails = domainModelUtil.toServSlot(vehicleDealerDetailsVO1);
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
		    
		    vehicleDealerDetails.setCreationDate(ourJavaTimestampObject);
		   
			if (vehicleQuotation.getUserQuotaReqBookSlotServ() != null) {
				vehicleQuotation.getUserQuotaReqBookSlotServ().add(vehicleDealerDetails);
				saved=true;
			}
			else {
				vehicleDealerDetailsList.add(vehicleDealerDetails);
				}
						
		}
		if(!saved){ // intialization
			vehicleQuotation.setUserQuotaReqBookSlotServ(vehicleDealerDetailsList);
		}
		
		
		serviceQuotationRepository.flush();
		
		return domainModelUtil.fromServQuota(vehicleQuotation);
		//return dealerSubscriptionSBLVO;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}
	// serv time slot end
	
	
	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "transportslotupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TranspServiceQuotationVO transportSlotUpdate(@RequestBody UserTransportSlotVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("transport Book Slot Creation", dealerSubscriptionSBLVO.getQuotId());
		
		TranspServiceQuotation vehicleQuotation = transQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
		
		
		
		List<UserQuotaReqBookSlotTranpVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqBookSlotTranpVO();
		List<UserQuotaReqBookSlotTranp> vehicleDealerDetailsList = new ArrayList<UserQuotaReqBookSlotTranp>();
		boolean saved = false;
		for (UserQuotaReqBookSlotTranpVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			UserQuotaReqBookSlotTranp vehicleDealerDetails = domainModelUtil.toTrnspSlot(vehicleDealerDetailsVO1);
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
		    
		    vehicleDealerDetails.setCreationDate(ourJavaTimestampObject);
		   
			if (vehicleQuotation.getUserQuotaReqBookSlotTranp() != null) {
				vehicleQuotation.getUserQuotaReqBookSlotTranp().add(vehicleDealerDetails);
				saved=true;
			}
			else {
				vehicleDealerDetailsList.add(vehicleDealerDetails);
				}
						
		}
		if(!saved){ // intialization
			vehicleQuotation.setUserQuotaReqBookSlotTranp(vehicleDealerDetailsList);
		}
		
		
		transQuotationRepository.flush();
		
		return domainModelUtil.fromTranpQuota(vehicleQuotation);
		//return dealerSubscriptionSBLVO;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}
	// serv time slot end
	
	
	
	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "userQuotaChatAdd", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserChatAllVO createVehicleResource(@RequestBody VehicleUserChatVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("User Chat Creation", dealerSubscriptionSBLVO.getQuotId());
		
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("vehicle")){
		
		VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
		
		
		
		List<UserQuotationHistoryVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotationHistoryVO();
		List<UserQuotationHistory> vehicleDealerDetailsList = new ArrayList<UserQuotationHistory>();
		boolean saved = false;
		for (UserQuotationHistoryVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			UserQuotationHistory vehicleDealerDetails = domainModelUtil.toUserChat(vehicleDealerDetailsVO1);
			Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		    
		    vehicleDealerDetails.setCreationDate(ourJavaTimestampObject);
		    vehicleDealerDetails.setIdp(vehicleQuotation.getQuotId());
		    
			if (vehicleQuotation.getUserQuotationHistory() != null) {
				vehicleQuotation.getUserQuotationHistory().add(vehicleDealerDetails);
				saved=true;
			}
			else {
				vehicleDealerDetailsList.add(vehicleDealerDetails);
				}
						
		}
		if(!saved){ // intialization
			vehicleQuotation.setUserQuotationHistory(vehicleDealerDetailsList);
		}
		
		
		vehicleQuotationRepository.flush();
		
		}
		// finance
		else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("finance")){
			
			FinanceQuotation vehicleQuotation = financeQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
			
			
			
			List<UserQuotationHistoryVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotationHistoryVO();
			List<UserQuotationHistoryFin> vehicleDealerDetailsList = new ArrayList<UserQuotationHistoryFin>();
			boolean saved = false;
			for (UserQuotationHistoryVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
				UserQuotationHistory vehicleDealerDetails = domainModelUtil.toUserChat(vehicleDealerDetailsVO1);
				UserQuotationHistoryFin fin = new UserQuotationHistoryFin();
				
				fin.setComment(vehicleDealerDetails.getComment());
				fin.setName(vehicleDealerDetails.getName());
				Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			    
			    fin.setCreationDate(ourJavaTimestampObject);
			    fin.setIdp(vehicleQuotation.getFinQuotId());
			    
				if (vehicleQuotation.getUserQuotationHistory() != null) {
					vehicleQuotation.getUserQuotationHistory().add(fin);
					saved=true;
				}
				else {
					vehicleDealerDetailsList.add(fin);
					}
							
			}
			if(!saved){ // intialization
				vehicleQuotation.setUserQuotationHistory(vehicleDealerDetailsList);
			}
			
			
			financeQuotationRepository.flush();
			
			}
		
		// insurance
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("insurance")){
			
			InsuranceQuotation vehicleQuotation = insuranceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
			
			
			
			List<UserQuotationHistoryVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotationHistoryVO();
			List<UserQuotationHistoryIns> vehicleDealerDetailsList = new ArrayList<UserQuotationHistoryIns>();
			boolean saved = false;
			for (UserQuotationHistoryVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
				UserQuotationHistory vehicleDealerDetails = domainModelUtil.toUserChat(vehicleDealerDetailsVO1);
				UserQuotationHistoryIns fin = new UserQuotationHistoryIns();
				
				fin.setComment(vehicleDealerDetails.getComment());
				fin.setName(vehicleDealerDetails.getName());
				Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			    
			    fin.setCreationDate(ourJavaTimestampObject);
			    fin.setIdp(vehicleQuotation.getInsQuotId());
			    
				if (vehicleQuotation.getUserQuotationHistory() != null) {
					vehicleQuotation.getUserQuotationHistory().add(fin);
					saved=true;
				}
				else {
					vehicleDealerDetailsList.add(fin);
					}
							
			}
			if(!saved){ // intialization
				vehicleQuotation.setUserQuotationHistory(vehicleDealerDetailsList);
			}
			
			
			insuranceQuotationRepository.flush();
			
			}
		
		// serv
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("service")){
			
			ServiceMaintQuotation vehicleQuotation = serviceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
			
			
			
			List<UserQuotationHistoryVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotationHistoryVO();
			List<UserQuotationHistoryServ> vehicleDealerDetailsList = new ArrayList<UserQuotationHistoryServ>();
			boolean saved = false;
			for (UserQuotationHistoryVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
				UserQuotationHistory vehicleDealerDetails = domainModelUtil.toUserChat(vehicleDealerDetailsVO1);
				UserQuotationHistoryServ fin = new UserQuotationHistoryServ();
				
				fin.setComment(vehicleDealerDetails.getComment());
				fin.setName(vehicleDealerDetails.getName());
				Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			    
			    fin.setCreationDate(ourJavaTimestampObject);
			    fin.setIdp(vehicleQuotation.getServMaintQuotId());
			    
				if (vehicleQuotation.getUserQuotationHistory() != null) {
					vehicleQuotation.getUserQuotationHistory().add(fin);
					saved=true;
				}
				else {
					vehicleDealerDetailsList.add(fin);
					}
							
			}
			if(!saved){ // intialization
				vehicleQuotation.setUserQuotationHistory(vehicleDealerDetailsList);
			}
			
			
			serviceQuotationRepository.flush();
			
			}
		// transp
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("transport")){
			
			TranspServiceQuotation vehicleQuotation = transQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
			
			
			
			List<UserQuotationHistoryVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotationHistoryVO();
			List<UserQuotationHistoryTranp> vehicleDealerDetailsList = new ArrayList<UserQuotationHistoryTranp>();
			boolean saved = false;
			for (UserQuotationHistoryVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
				UserQuotationHistory vehicleDealerDetails = domainModelUtil.toUserChat(vehicleDealerDetailsVO1);
				UserQuotationHistoryTranp fin = new UserQuotationHistoryTranp();
				
				fin.setComment(vehicleDealerDetails.getComment());
				fin.setName(vehicleDealerDetails.getName());
				fin.setIdp(vehicleQuotation.getTranspServQuotId());
				Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			    
			    fin.setCreationDate(ourJavaTimestampObject);
			    
			    
				if (vehicleQuotation.getUserQuotationHistory() != null) {
					vehicleQuotation.getUserQuotationHistory().add(fin);
					saved=true;
				}
				else {
					vehicleDealerDetailsList.add(fin);
					}
							
			}
			if(!saved){ // intialization
				vehicleQuotation.setUserQuotationHistory(vehicleDealerDetailsList);
			}
			
			
			transQuotationRepository.flush();
			
			}
		
		response.setStatus(HttpStatus.CREATED.value());
		UserChatAllVO userChatAllVO = new UserChatAllVO();
				if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("vehicle")){
		
		VehicleQuotation dealer = new VehicleQuotation();
		dealer.setQuotId(dealerSubscriptionSBLVO.getQuotId());
		
		List<UserQuotationHistoryVO> inventoryList = new ArrayList<>();
		
		for(UserQuotationHistory inventory : userQuotationHistoryRepo.findByVehicleQuotation(dealer)){
			inventoryList.add(domainModelUtil.fromChatHistory(inventory, true));
		}
		userChatAllVO.setUserQuotationHistoryVO(inventoryList);
				}
		
				else if (dealerSubscriptionSBLVO.getTypeOfQuotation().equals("finance")){
					FinanceQuotation dealer = new FinanceQuotation();
					dealer.setFinQuotId(dealerSubscriptionSBLVO.getQuotId());
					
					List<UserQuotationHistoryFinVO> inventoryList = new ArrayList<>();
					
					for(UserQuotationHistoryFin inventory : userQuotationHistoryRepoFin.findByVehicleQuotation(dealer)){
						inventoryList.add(domainModelUtil.fromChatHistoryFin(inventory, true));
					}
					userChatAllVO.setUserQuotationHistoryFinVO(inventoryList);
					// end of finance history
				}
				else if (dealerSubscriptionSBLVO.getTypeOfQuotation().equals("insurance")){
					InsuranceQuotation dealer = new InsuranceQuotation();
					dealer.setInsQuotId(dealerSubscriptionSBLVO.getQuotId());
					
					List<UserQuotationHistoryInsVO> inventoryList = new ArrayList<>();
					
					for(UserQuotationHistoryIns inventory : userQuotationHistoryRepoIns.findByVehicleQuotation(dealer)){
						inventoryList.add(domainModelUtil.fromChatHistoryIns(inventory, true));
					}
					userChatAllVO.setUserQuotationHistoryInsVO(inventoryList);
					// end of finance history
				}
				else if (dealerSubscriptionSBLVO.getTypeOfQuotation().equals("service")){
					ServiceMaintQuotation dealer = new ServiceMaintQuotation();
					dealer.setServMaintQuotId(dealerSubscriptionSBLVO.getQuotId());
					
					List<UserQuotationHistoryServVO> inventoryList = new ArrayList<>();
					
					for(UserQuotationHistoryServ inventory : userQuotationHistoryRepoServ.findByVehicleQuotation(dealer)){
						inventoryList.add(domainModelUtil.fromChatHistoryServ(inventory, true));
					}
					userChatAllVO.setUserQuotationHistoryServVO(inventoryList);
					// end of finance history
				}
				else if (dealerSubscriptionSBLVO.getTypeOfQuotation().equals("transport")){
					TranspServiceQuotation dealer = new TranspServiceQuotation();
					dealer.setTranspServQuotId(dealerSubscriptionSBLVO.getQuotId());
					
					List<UserQuotationHistoryTranpVO> inventoryList = new ArrayList<>();
					
					for(UserQuotationHistoryTranp inventory : userQuotationHistoryRepoTranp.findByVehicleQuotation(dealer)){
						inventoryList.add(domainModelUtil.fromChatHistoryTransp(inventory, true));
					}
					userChatAllVO.setUserQuotationHistoryTranspVO(inventoryList);
					// end of finance history
				}
		
		return userChatAllVO;
		//return dealerSubscriptionSBLVO;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}
	
	// start of userQuotaDocs add
	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "userQuotaDocsAdd", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SampleSuccessVO userQuotaDocsAdd(@RequestBody QuotaDocVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("User Quoation Docs addition", dealerSubscriptionSBLVO.getQuotId());
		SampleSuccessVO success = new SampleSuccessVO();
		
		// vehicle
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("vehicle")){
		VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
		
		
		// start of test drive logic
		List<UserQuotaDocVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaDocVO();
		List<UserQuotaDocs> vehicleDealerDetailsList = new ArrayList<UserQuotaDocs>();
		boolean saved = false;
		for (UserQuotaDocVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			UserQuotaDocs vehicleDealerDetails = domainModelUtil.toQuotaDoc(vehicleDealerDetailsVO1);
			Calendar calendar = Calendar.getInstance();
			java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		    
		    //vehicleDealerDetails.setCreationDate(ourJavaTimestampObject);
		    
		    
			if (vehicleQuotation.getUserQuotaDocs() != null) {
				vehicleQuotation.getUserQuotaDocs().add(vehicleDealerDetails);
				saved=true;
			}
			else {
				vehicleDealerDetailsList.add(vehicleDealerDetails);
				}
						
		}
		if(!saved){ // intialization
			vehicleQuotation.setUserQuotaDocs(vehicleDealerDetailsList);
			}
		
		vehicleQuotationRepository.saveAndFlush(vehicleQuotation);
		}
		
		// finance
		else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("finance")){
				FinanceQuotation vehicleQuotation = financeQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
				
				
				// start of test drive logic
				
				List<UserQuotaDocVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaDocVO();
				List<UserQuotaDocsFin> vehicleDealerDetailsList = new ArrayList<UserQuotaDocsFin>();
				boolean saved = false;
				for (UserQuotaDocVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
					UserQuotaDocs vehicleDealerDetails = domainModelUtil.toQuotaDoc(vehicleDealerDetailsVO1);
					UserQuotaDocsFin fin = new UserQuotaDocsFin();
					fin.setDocName(vehicleDealerDetails.getDocName());
					fin.setDescDoc(vehicleDealerDetails.getDescDoc());
					
					Calendar calendar = Calendar.getInstance();
				    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
				    
				    fin.setCreationDate(ourJavaTimestampObject);
				    
				    
					if (vehicleQuotation.getUserQuotaDocs() != null) {
						vehicleQuotation.getUserQuotaDocs().add(fin);
						saved=true;
					}
					else {
						vehicleDealerDetailsList.add(fin);
						}
								
				}
				if(!saved){ // intialization
					vehicleQuotation.setUserQuotaDocs(vehicleDealerDetailsList);
					}
				
				// end of test drive logic
				
						
				financeQuotationRepository.flush();
				}
		
		
		// insurance
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("insurance")){
						InsuranceQuotation vehicleQuotation = insuranceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						
						// start of test drive logic
						
						List<UserQuotaDocVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaDocVO();
						List<UserQuotaDocsIns> vehicleDealerDetailsList = new ArrayList<UserQuotaDocsIns>();
						boolean saved = false;
						for (UserQuotaDocVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaDocs vehicleDealerDetails = domainModelUtil.toQuotaDoc(vehicleDealerDetailsVO1);
							UserQuotaDocsIns fin = new UserQuotaDocsIns();
							fin.setDocName(vehicleDealerDetails.getDocName());
							fin.setDescDoc(vehicleDealerDetails.getDescDoc());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaDocs() != null) {
								vehicleQuotation.getUserQuotaDocs().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaDocs(vehicleDealerDetailsList);
							}
						
						// end of test drive logic
						
												
						insuranceQuotationRepository.flush();
						
						}
		// service
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("service")){
						ServiceMaintQuotation vehicleQuotation = serviceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						

						// start of test drive logic
						
						List<UserQuotaDocVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaDocVO();
						List<UserQuotaDocsServ> vehicleDealerDetailsList = new ArrayList<UserQuotaDocsServ>();
						boolean saved = false;
						for (UserQuotaDocVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaDocs vehicleDealerDetails = domainModelUtil.toQuotaDoc(vehicleDealerDetailsVO1);
							UserQuotaDocsServ fin = new UserQuotaDocsServ();
							fin.setDocName(vehicleDealerDetails.getDocName());
							fin.setDescDoc(vehicleDealerDetails.getDescDoc());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaDocs() != null) {
								vehicleQuotation.getUserQuotaDocs().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaDocs(vehicleDealerDetailsList);
							}
						
						// end of test drive logic
						
						
						serviceQuotationRepository.flush();
						}
		
		// transport
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("transport")){
						TranspServiceQuotation vehicleQuotation = transQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						
// start of test drive logic
						
						List<UserQuotaDocVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaDocVO();
						List<UserQuotaDocsTranp> vehicleDealerDetailsList = new ArrayList<UserQuotaDocsTranp>();
						boolean saved = false;
						for (UserQuotaDocVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaDocs vehicleDealerDetails = domainModelUtil.toQuotaDoc(vehicleDealerDetailsVO1);
							UserQuotaDocsTranp fin = new UserQuotaDocsTranp();
							fin.setDocName(vehicleDealerDetails.getDocName());
							fin.setDescDoc(vehicleDealerDetails.getDescDoc());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaDocs() != null) {
								vehicleQuotation.getUserQuotaDocs().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaDocs(vehicleDealerDetailsList);
							}
						
						// end of test drive logic
						
						
						serviceQuotationRepository.flush();
						}
		
		
			response.setStatus(HttpStatus.CREATED.value());
			success.setStatus("success");
		
		
		return success;
		//return dealerSubscriptionSBLVO;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}
	// end of userQuotaDocs add
	

	/**
	 * 
	 * @param dealer
	 *            Resource
	 * @param response
	 * @return
	 */
	@PostMapping(value = "userQuotaInterest", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SampleSuccessVO userQuotaInterest(@RequestBody QuotaInterestVO dealerSubscriptionSBLVO,
			HttpServletResponse response) {
		LOGGER.debug("User Quoation Interested or not Creation", dealerSubscriptionSBLVO.getQuotId());
		UserQuotaAllSingleVO userQuotaAllVO = new UserQuotaAllSingleVO();
		boolean failCondition = false;
		SampleSuccessVO success = new SampleSuccessVO();
		
		// vehicle
		if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("vehicle")){
		VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
		
		
		// start of test drive logic
		if(dealerSubscriptionSBLVO.isTestDrive()){
		List<UserQuotaReqTestDriveVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqTestDriveVO();
		List<UserQuotaReqTestDrive> vehicleDealerDetailsList = new ArrayList<UserQuotaReqTestDrive>();
		boolean saved = false;
		for (UserQuotaReqTestDriveVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
			UserQuotaReqTestDrive vehicleDealerDetails = domainModelUtil.toUserQuota(vehicleDealerDetailsVO1);
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
		    
		    vehicleDealerDetails.setCreationDate(ourJavaTimestampObject);
		    
		    
			if (vehicleQuotation.getUserQuotaReqTestDrive() != null) {
				vehicleQuotation.getUserQuotaReqTestDrive().add(vehicleDealerDetails);
				saved=true;
			}
			else {
				vehicleDealerDetailsList.add(vehicleDealerDetails);
				}
						
		}
		if(!saved){ // intialization
			vehicleQuotation.setUserQuotaReqTestDrive(vehicleDealerDetailsList);
			}
		}
		// end of test drive logic
		
		String value= "other" ;
		// end of test drive logic
		 
		 if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("created")) {
	           value = "created";
	        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("interested")) {
	        	 value = "interested";
	        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("notinterested")) {
	        	 value = "notinterested";
	        }
		 if(!value.equalsIgnoreCase("other")){
			 vehicleQuotation.setQuotaStatus(value);
			 if(value.equalsIgnoreCase("notinterested")){
			 vehicleQuotation.setInterested(false);
			 }
		}
		 else{
			 // fail condition
			 failCondition = true;
		 }
		
		vehicleQuotationRepository.saveAndFlush(vehicleQuotation);
		userQuotaAllVO.setVehicleQuotationVO(domainModelUtil.fromVehicleQuotation(vehicleQuotation, false));
		}
		
		// finance
		else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("finance")){
				FinanceQuotation vehicleQuotation = financeQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
				
				
				// start of test drive logic
				if(dealerSubscriptionSBLVO.isTestDrive()){
				List<UserQuotaReqTestDriveVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqTestDriveVO();
				List<UserQuotaReqTestDriveFin> vehicleDealerDetailsList = new ArrayList<UserQuotaReqTestDriveFin>();
				boolean saved = false;
				for (UserQuotaReqTestDriveVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
					UserQuotaReqTestDrive vehicleDealerDetails = domainModelUtil.toUserQuota(vehicleDealerDetailsVO1);
					UserQuotaReqTestDriveFin fin = new UserQuotaReqTestDriveFin();
					fin.setAddress(vehicleDealerDetails.getAddress());
					fin.setPostCode(vehicleDealerDetails.getPostCode());
					fin.setfName(vehicleDealerDetails.getfName());
					fin.setlName(vehicleDealerDetails.getlName());
					fin.setTitle(vehicleDealerDetails.getTitle());
					fin.setPrefDate(vehicleDealerDetails.getPrefDate());
					fin.setMobile(vehicleDealerDetails.getMobile());
					
					Calendar calendar = Calendar.getInstance();
				    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
				    
				    fin.setCreationDate(ourJavaTimestampObject);
				    
				    
					if (vehicleQuotation.getUserQuotaReqTestDrive() != null) {
						vehicleQuotation.getUserQuotaReqTestDrive().add(fin);
						saved=true;
					}
					else {
						vehicleDealerDetailsList.add(fin);
						}
								
				}
				if(!saved){ // intialization
					vehicleQuotation.setUserQuotaReqTestDrive(vehicleDealerDetailsList);
					}
				}
				// end of test drive logic
				
				String value= "other" ;
				// end of test drive logic
				 
				 if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("created")) {
			           value = "created";
			        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("interested")) {
			        	 value = "interested";
			        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("notinterested")) {
			        	 value = "notinterested";
			        }
				 if(!value.equalsIgnoreCase("other")){
					 vehicleQuotation.setQuotaStatus(value);
					 if(value.equalsIgnoreCase("notinterested")){
					 vehicleQuotation.setInterested(false);
					 }
				}
				 else{
					 // fail condition
					 failCondition = true;
				 }
				
				financeQuotationRepository.flush();
				userQuotaAllVO.setFinanceQuotationVO(domainModelUtil.fromFinanQuota(vehicleQuotation));
				}
		
		
		// insurance
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("insurance")){
						InsuranceQuotation vehicleQuotation = insuranceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						
						// start of test drive logic
						if(dealerSubscriptionSBLVO.isTestDrive()){
						List<UserQuotaReqTestDriveVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqTestDriveVO();
						List<UserQuotaReqTestDriveIns> vehicleDealerDetailsList = new ArrayList<UserQuotaReqTestDriveIns>();
						boolean saved = false;
						for (UserQuotaReqTestDriveVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaReqTestDrive vehicleDealerDetails = domainModelUtil.toUserQuota(vehicleDealerDetailsVO1);
							UserQuotaReqTestDriveIns fin = new UserQuotaReqTestDriveIns();
							fin.setAddress(vehicleDealerDetails.getAddress());
							fin.setPostCode(vehicleDealerDetails.getPostCode());
							fin.setfName(vehicleDealerDetails.getfName());
							fin.setlName(vehicleDealerDetails.getlName());
							fin.setTitle(vehicleDealerDetails.getTitle());
							fin.setPrefDate(vehicleDealerDetails.getPrefDate());
							fin.setMobile(vehicleDealerDetails.getMobile());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaReqTestDrive() != null) {
								vehicleQuotation.getUserQuotaReqTestDrive().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaReqTestDrive(vehicleDealerDetailsList);
							}
						}
						// end of test drive logic
						
						String value= "other" ;
						// end of test drive logic
						 
						 if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("created")) {
					           value = "created";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("interested")) {
					        	 value = "interested";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("notinterested")) {
					        	 value = "notinterested";
					        }
						 if(!value.equalsIgnoreCase("other")){
							 vehicleQuotation.setQuotaStatus(value);
							 if(value.equalsIgnoreCase("notinterested")){
							 vehicleQuotation.setInterested(false);
							 }
						}
						 else{
							 // fail condition
							 failCondition = true;
						 }
						
						insuranceQuotationRepository.flush();
						userQuotaAllVO.setInsuranceQuotationVO(domainModelUtil.fromInsQuota(vehicleQuotation));
						}
		// service
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("service")){
						ServiceMaintQuotation vehicleQuotation = serviceQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						
						// start of test drive logic
						if(dealerSubscriptionSBLVO.isTestDrive()){
						List<UserQuotaReqTestDriveVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqTestDriveVO();
						List<UserQuotaReqTestDriveServ> vehicleDealerDetailsList = new ArrayList<UserQuotaReqTestDriveServ>();
						boolean saved = false;
						for (UserQuotaReqTestDriveVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaReqTestDrive vehicleDealerDetails = domainModelUtil.toUserQuota(vehicleDealerDetailsVO1);
							UserQuotaReqTestDriveServ fin = new UserQuotaReqTestDriveServ();
							fin.setAddress(vehicleDealerDetails.getAddress());
							fin.setPostCode(vehicleDealerDetails.getPostCode());
							fin.setfName(vehicleDealerDetails.getfName());
							fin.setlName(vehicleDealerDetails.getlName());
							fin.setTitle(vehicleDealerDetails.getTitle());
							fin.setPrefDate(vehicleDealerDetails.getPrefDate());
							fin.setMobile(vehicleDealerDetails.getMobile());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaReqTestDrive() != null) {
								vehicleQuotation.getUserQuotaReqTestDrive().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaReqTestDrive(vehicleDealerDetailsList);
							}
						}
						// end of test drive logic
						
						String value= "other" ;
						// end of test drive logic
						 
						 if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("created")) {
					           value = "created";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("interested")) {
					        	 value = "interested";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("notinterested")) {
					        	 value = "notinterested";
					        }
						 if(!value.equalsIgnoreCase("other")){
							 vehicleQuotation.setQuotaStatus(value);
							 if(value.equalsIgnoreCase("notinterested")){
							 vehicleQuotation.setInterested(false);
							 }
						}
						 else{
							 // fail condition
							 failCondition = true;
						 }
						
						serviceQuotationRepository.flush();
						userQuotaAllVO.setServiceMaintQuotationVO(domainModelUtil.fromServQuota(vehicleQuotation));
						}
		
		// transport
				else if(dealerSubscriptionSBLVO.getTypeOfQuotation().equals("transport")){
						TranspServiceQuotation vehicleQuotation = transQuotationRepository.findOne(dealerSubscriptionSBLVO.getQuotId());
						
						
						// start of test drive logic
						if(dealerSubscriptionSBLVO.isTestDrive()){
						List<UserQuotaReqTestDriveVO> vehicleDealerDetailsVO = dealerSubscriptionSBLVO.getUserQuotaReqTestDriveVO();
						List<UserQuotaReqTestDriveTranp> vehicleDealerDetailsList = new ArrayList<UserQuotaReqTestDriveTranp>();
						boolean saved = false;
						for (UserQuotaReqTestDriveVO vehicleDealerDetailsVO1 : vehicleDealerDetailsVO) {
							UserQuotaReqTestDrive vehicleDealerDetails = domainModelUtil.toUserQuota(vehicleDealerDetailsVO1);
							UserQuotaReqTestDriveTranp fin = new UserQuotaReqTestDriveTranp();
							fin.setAddress(vehicleDealerDetails.getAddress());
							fin.setPostCode(vehicleDealerDetails.getPostCode());
							fin.setfName(vehicleDealerDetails.getfName());
							fin.setlName(vehicleDealerDetails.getlName());
							fin.setTitle(vehicleDealerDetails.getTitle());
							fin.setPrefDate(vehicleDealerDetails.getPrefDate());
							fin.setMobile(vehicleDealerDetails.getMobile());
							
							Calendar calendar = Calendar.getInstance();
						    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
						    
						    fin.setCreationDate(ourJavaTimestampObject);
						    
						    
							if (vehicleQuotation.getUserQuotaReqTestDrive() != null) {
								vehicleQuotation.getUserQuotaReqTestDrive().add(fin);
								saved=true;
							}
							else {
								vehicleDealerDetailsList.add(fin);
								}
										
						}
						if(!saved){ // intialization
							vehicleQuotation.setUserQuotaReqTestDrive(vehicleDealerDetailsList);
							}
						}
						// end of test drive logic
						
						String value= "other" ;
						// end of test drive logic
						 
						 if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("created")) {
					           value = "created";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("interested")) {
					        	 value = "interested";
					        } else if (dealerSubscriptionSBLVO.getQuotaStatus().equalsIgnoreCase("notinterested")) {
					        	 value = "notinterested";
					        }
						 if(!value.equalsIgnoreCase("other")){
							 vehicleQuotation.setQuotaStatus(value);
							 if(value.equalsIgnoreCase("notinterested")){
							 vehicleQuotation.setInterested(false);
							 }
						}
						 else{
							 // fail condition
							 failCondition = true;
						 }
						serviceQuotationRepository.flush();
						userQuotaAllVO.setTranspServiceQuotationVO(domainModelUtil.fromTranpQuota(vehicleQuotation));
						}
		
		
		if(failCondition){
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			success.setStatus("failure - Due to Bad Quota Status");
		}
		else{
			response.setStatus(HttpStatus.CREATED.value());
			success.setStatus("success");
		}
		
		return success;
		//return dealerSubscriptionSBLVO;
		// createdDealer dealerService.findById(createdDealer.getDealerId());
	}
	
	
	
	
	
	
	
	@GetMapping(value = "userQuota/getChat/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserQuotationHistoryVO getUserQuotaChatbyID(@PathVariable Long id, HttpServletResponse response) {
		
		UserQuotationHistoryVO dealerVO = null;
		UserQuotationHistory dealer = userQuotationHistoryRepo.findOne(id);
		if(dealer != null){
			dealerVO = domainModelUtil.fromUserChatVO(dealer);
			/*try {
				BeanUtils.copyProperties(dealerVO, dealer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		return dealerVO;
	}

	@GetMapping(value = "userQuota/{id}/chat", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserQuotationHistoryVO> getUserQuotaChat(@PathVariable Long id) {
		LOGGER.debug("Received request to get User Chat{} ", id);
		
		VehicleQuotation dealer = new VehicleQuotation();
		dealer.setQuotId(id);
		
		List<UserQuotationHistoryVO> inventoryList = new ArrayList<>();
		
		for(UserQuotationHistory inventory : userQuotationHistoryRepo.findByVehicleQuotation(dealer)){
			inventoryList.add(domainModelUtil.fromChatHistory(inventory, true));
		}
		return inventoryList;
		
	}
	
	@GetMapping(value = "chatByQuotaIdType", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserChatAllVO getChatByQuotaIdType(@RequestParam("quotaid") Long userid, @RequestParam("typeOfQuota") String typeOfQuota) {
		LOGGER.debug("Received request to get QuotaIdType Chat{} ", userid);
		//String name = userEBidService.getNameByUserID(userid);
		UserChatAllVO userChatAllVO = new UserChatAllVO();
		if(typeOfQuota.equals("vehicle")){
		List<UserQuotationHistoryVO> inventoryList = new ArrayList<>();
		VehicleQuotation searchs = vehicleQuotationRepository.findOne(userid);
		
			
			for(UserQuotationHistory inventory : userQuotationHistoryRepo.findByVehicleQuotation(searchs)){
				//inventory.setName(name);
				//inventory.setIdp(search.getQuotId());
				inventoryList.add(domainModelUtil.fromChatHistory(inventory, true));
			}
			userChatAllVO.setUserQuotationHistoryVO(inventoryList);
		
		}
		// start of finance history
		if(typeOfQuota.equals("finance")){
		List<UserQuotationHistoryFinVO> inventoryListFin = new ArrayList<>();
		FinanceQuotation searchFin = financeQuotationRepository.findOne(userid);
		
			
			for(UserQuotationHistoryFin inventory : userQuotationHistoryRepoFin.findByVehicleQuotation(searchFin)){
				//inventory.setName(name);
				//inventory.setIdp(search.getQuotId());
				inventoryListFin.add(domainModelUtil.fromChatHistoryFin(inventory, true));
			}
			userChatAllVO.setUserQuotationHistoryFinVO(inventoryListFin);
		
		
		}
		// end of finance history
		
		// start of insurance history
		if(typeOfQuota.equals("insurance")){
				List<UserQuotationHistoryInsVO> inventoryListIns = new ArrayList<>();
				InsuranceQuotation searchIns = insuranceQuotationRepository.findOne(userid);
				
					
					for(UserQuotationHistoryIns inventory : userQuotationHistoryRepoIns.findByVehicleQuotation(searchIns)){
						//inventory.setName(name);
						//inventory.setIdp(search.getQuotId());
						inventoryListIns.add(domainModelUtil.fromChatHistoryIns(inventory, true));
					}
					
				
				userChatAllVO.setUserQuotationHistoryInsVO(inventoryListIns);
				
		}
		// end of insurance history
		if(typeOfQuota.equals("service")){
				// start of serv history
				List<UserQuotationHistoryServVO> inventoryListServ = new ArrayList<>();
				ServiceMaintQuotation searchServ = serviceQuotationRepository.findOne(userid);
				
					for(UserQuotationHistoryServ inventory : userQuotationHistoryRepoServ.findByVehicleQuotation(searchServ)){
						//inventory.setName(name);
						//inventory.setIdp(search.getQuotId());
						inventoryListServ.add(domainModelUtil.fromChatHistoryServ(inventory, true));
					}
					userChatAllVO.setUserQuotationHistoryServVO(inventoryListServ);	
				
		}
		// end of serv history
		if(typeOfQuota.equals("transport")){
				// start of transp history
				List<UserQuotationHistoryTranpVO> inventoryListTransp = new ArrayList<>();
				TranspServiceQuotation searchTranp = transQuotationRepository.findOne(userid);
				
					
					for(UserQuotationHistoryTranp inventory : userQuotationHistoryRepoTranp.findByVehicleQuotation(searchTranp)){
						//inventory.setName(name);
						//inventory.setIdp(search.getQuotId());
						inventoryListTransp.add(domainModelUtil.fromChatHistoryTransp(inventory, true));
					}
					
					userChatAllVO.setUserQuotationHistoryTranspVO(inventoryListTransp);
		}
		// end of serv history
		
		
		return userChatAllVO;
		
	}
	
	
	@GetMapping(value = "chatByUserId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserChatAllVO getChatByUserid(@RequestParam("userid") Long userid) {
		LOGGER.debug("Received request to get User Chat{} ", userid);
		String name = userEBidService.getNameByUserID(userid);
		List<UserQuotationHistoryVO> inventoryList = new ArrayList<>();
		List<VehicleQuotation> searchs = userEBidService.getVehQuotaByUserID(userid);
		for (VehicleQuotation search : searchs) {
			
			for(UserQuotationHistory inventory : userQuotationHistoryRepo.findByVehicleQuotation(search)){
				//inventory.setName(name);
				//inventory.setIdp(search.getQuotId());
				inventoryList.add(domainModelUtil.fromChatHistory(inventory, true));
			}
			
		}
		
		// start of finance history
		List<UserQuotationHistoryFinVO> inventoryListFin = new ArrayList<>();
		List<FinanceQuotation> searchFins = userEBidService.getFinQuotaByUserID(userid);
		for (FinanceQuotation searchFin : searchFins) {
			
			for(UserQuotationHistoryFin inventory : userQuotationHistoryRepoFin.findByVehicleQuotation(searchFin)){
				//inventory.setName(name);
				//inventory.setIdp(searchFin.getFinQuotId());
				inventoryListFin.add(domainModelUtil.fromChatHistoryFin(inventory, true));
			}
			
		}
		// end of finance history
		
		// start of insurance history
				List<UserQuotationHistoryInsVO> inventoryListIns = new ArrayList<>();
				List<InsuranceQuotation> searchInss = userEBidService.getInsQuotaByUserID(userid);
				for (InsuranceQuotation searchIns : searchInss) {
					
					for(UserQuotationHistoryIns inventory : userQuotationHistoryRepoIns.findByVehicleQuotation(searchIns)){
						//inventory.setName(name);
						//inventory.setIdp(searchIns.getInsQuotId());
						inventoryListIns.add(domainModelUtil.fromChatHistoryIns(inventory, true));
					}
					
				}
		// end of insurance history
		
				// start of serv history
				List<UserQuotationHistoryServVO> inventoryListServ = new ArrayList<>();
				List<ServiceMaintQuotation> searchServs = userEBidService.getServQuotaByUserID(userid);
				for (ServiceMaintQuotation searchServ : searchServs) {
					
					for(UserQuotationHistoryServ inventory : userQuotationHistoryRepoServ.findByVehicleQuotation(searchServ)){
						//inventory.setName(name);
						//inventory.setIdp(searchServ.getServMaintQuotId());
						inventoryListServ.add(domainModelUtil.fromChatHistoryServ(inventory, true));
					}
					
				}
		// end of serv history
				
				// start of transp history
				List<UserQuotationHistoryTranpVO> inventoryListTransp = new ArrayList<>();
				List<TranspServiceQuotation> searchTranps = userEBidService.getTranpQuotaByUserID(userid);
				for (TranspServiceQuotation searchTrans : searchTranps) {
					
					for(UserQuotationHistoryTranp inventory : userQuotationHistoryRepoTranp.findByVehicleQuotation(searchTrans)){
						//inventory.setName(name);
						//inventory.setIdp(searchTrans.getTranspServQuotId());
						inventoryListTransp.add(domainModelUtil.fromChatHistoryTransp(inventory, true));
					}
					
				}
		// end of serv history
		
		UserChatAllVO userChatAllVO = new UserChatAllVO();
		userChatAllVO.setUserQuotationHistoryFinVO(inventoryListFin);
		userChatAllVO.setUserQuotationHistoryVO(inventoryList);
		userChatAllVO.setUserQuotationHistoryInsVO(inventoryListIns);
		userChatAllVO.setUserQuotationHistoryServVO(inventoryListServ);
		userChatAllVO.setUserQuotationHistoryTranspVO(inventoryListTransp);
		return userChatAllVO;
		
	}
	
	
	
	@GetMapping(value = "chatByDealerId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserChatAllVO getChatByDealerid(@RequestParam("dealerid") Long userid) {
		LOGGER.debug("Received request to get User Chat{} ", userid);
		String name = userEBidService.getNameByUserID(userid);
		List<UserQuotationHistoryVO> inventoryList = new ArrayList<>();
		List<VehicleQuotation> searchs = userEBidService.getVehQuotaByDealerID(userid);
		for (VehicleQuotation search : searchs) {
			
			for(UserQuotationHistory inventory : userQuotationHistoryRepo.findByVehicleQuotation(search)){
				//inventory.setName(name);
				//inventory.setIdp(search.getQuotId());
				inventoryList.add(domainModelUtil.fromChatHistory(inventory, true));
			}
			
		}
		
		// start of finance history
		List<UserQuotationHistoryFinVO> inventoryListFin = new ArrayList<>();
		List<FinanceQuotation> searchFins = userEBidService.getFinQuotaByDealID(userid);
		for (FinanceQuotation searchFin : searchFins) {
			
			for(UserQuotationHistoryFin inventory : userQuotationHistoryRepoFin.findByVehicleQuotation(searchFin)){
				//inventory.setName(name);
				//inventory.setIdp(searchFin.getFinQuotId());
				inventoryListFin.add(domainModelUtil.fromChatHistoryFin(inventory, true));
			}
			
		}
		// end of finance history
		
		// start of insurance history
				List<UserQuotationHistoryInsVO> inventoryListIns = new ArrayList<>();
				List<InsuranceQuotation> searchInss = userEBidService.getInsQuotaByDealID(userid);
				for (InsuranceQuotation searchIns : searchInss) {
					
					for(UserQuotationHistoryIns inventory : userQuotationHistoryRepoIns.findByVehicleQuotation(searchIns)){
						//inventory.setName(name);
						//inventory.setIdp(searchIns.getInsQuotId());
						inventoryListIns.add(domainModelUtil.fromChatHistoryIns(inventory, true));
					}
					
				}
		// end of insurance history
		
				// start of serv history
				List<UserQuotationHistoryServVO> inventoryListServ = new ArrayList<>();
				List<ServiceMaintQuotation> searchServs = userEBidService.getServQuotaByDealID(userid);
				for (ServiceMaintQuotation searchServ : searchServs) {
					
					for(UserQuotationHistoryServ inventory : userQuotationHistoryRepoServ.findByVehicleQuotation(searchServ)){
						//inventory.setName(name);
						//inventory.setIdp(searchServ.getServMaintQuotId());
						inventoryListServ.add(domainModelUtil.fromChatHistoryServ(inventory, true));
					}
					
				}
		// end of serv history
				
				// start of transp history
				List<UserQuotationHistoryTranpVO> inventoryListTransp = new ArrayList<>();
				List<TranspServiceQuotation> searchTranps = userEBidService.getTranpQuotaByDealrID(userid);
				for (TranspServiceQuotation searchTrans : searchTranps) {
					
					for(UserQuotationHistoryTranp inventory : userQuotationHistoryRepoTranp.findByVehicleQuotation(searchTrans)){
						//inventory.setName(name);
						//inventory.setIdp(searchTrans.getTranspServQuotId());
						inventoryListTransp.add(domainModelUtil.fromChatHistoryTransp(inventory, true));
					}
					
				}
		// end of serv history
		
		UserChatAllVO userChatAllVO = new UserChatAllVO();
		userChatAllVO.setUserQuotationHistoryFinVO(inventoryListFin);
		userChatAllVO.setUserQuotationHistoryVO(inventoryList);
		userChatAllVO.setUserQuotationHistoryInsVO(inventoryListIns);
		userChatAllVO.setUserQuotationHistoryServVO(inventoryListServ);
		userChatAllVO.setUserQuotationHistoryTranspVO(inventoryListTransp);
		return userChatAllVO;
		
	}
	
	
	@PutMapping("vehicleSearchQuotation")
	@Transactional
	public VehicleQuotationVO vehicleSearchQuotation(@RequestBody VehicleQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update vehicle {}", vehicleQuotationVO.getQuotId());
				if(vehicleQuotationVO != null){
					VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(vehicleQuotationVO.getQuotId());
					
					
					vehicleQuotation.setPostCode(vehicleQuotationVO.getPostCode());
					vehicleQuotation.setTitle(vehicleQuotationVO.getTitle());
					vehicleQuotation.setFname(vehicleQuotationVO.getFname());
					vehicleQuotation.setLname(vehicleQuotationVO.getLname());
					vehicleQuotation.setAddress(vehicleQuotationVO.getAddress());
					vehicleQuotation.setMobileNum(vehicleQuotationVO.getMobileNum());
					vehicleQuotation.setPrefDate(vehicleQuotationVO.getPrefDate());
					vehicleQuotation.setMakeOffer(vehicleQuotationVO.isMakeOffer());
					vehicleQuotation.setMakeDeposit(vehicleQuotationVO.isMakeDeposit());
					vehicleQuotation.setChat(vehicleQuotationVO.isChat());
					vehicleQuotation.setRejectIt(vehicleQuotationVO.isRejectIt());
					vehicleQuotation.setShortList(vehicleQuotationVO.isShortList());
					vehicleQuotationVO.setUserId(vehicleQuotation.getUserId());
					if(vehicleQuotationVO.getComment() != null){
						UserQuotationHistory userQuotationHistory = new UserQuotationHistory();
						userQuotationHistory.setComment(vehicleQuotationVO.getComment());
						Calendar calendar = Calendar.getInstance();
					    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
					    
						userQuotationHistory.setCreationDate(ourJavaTimestampObject);
						if (vehicleQuotation.getUserQuotationHistory() != null) {
							vehicleQuotation.getUserQuotationHistory().add(userQuotationHistory);
						} else {
							List<UserQuotationHistory> userQuotationHistorys = new ArrayList<>();
							userQuotationHistorys.add(userQuotationHistory);
							vehicleQuotation.setUserQuotationHistory(userQuotationHistorys);
						}
						vehicleQuotationRepository.flush();
					}
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PutMapping("vehicleSearchDealQuotation")
	@Transactional
	public VehicleQuotationVO vehicleSearchDealQuotation(@RequestBody VehicleQuotationVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update vehicle {}", vehicleQuotationVO.getQuotId());
				if(vehicleQuotationVO != null){
					VehicleQuotation vehicleQuotation = vehicleQuotationRepository.findOne(vehicleQuotationVO.getQuotId());
					
					
					vehicleQuotation.setPostCode(vehicleQuotationVO.getPostCode());
					vehicleQuotation.setTitle(vehicleQuotationVO.getTitle());
					vehicleQuotation.setFname(vehicleQuotationVO.getFname());
					vehicleQuotation.setLname(vehicleQuotationVO.getLname());
					vehicleQuotation.setAddress(vehicleQuotationVO.getAddress());
					vehicleQuotation.setMobileNum(vehicleQuotationVO.getMobileNum());
					vehicleQuotation.setPrefDate(vehicleQuotationVO.getPrefDate());
					vehicleQuotation.setMakeOffer(vehicleQuotationVO.isMakeOffer());
					vehicleQuotation.setMakeDeposit(vehicleQuotationVO.isMakeDeposit());
					vehicleQuotation.setChat(vehicleQuotationVO.isChat());
					vehicleQuotation.setRejectIt(vehicleQuotationVO.isRejectIt());
					vehicleQuotation.setShortList(vehicleQuotationVO.isShortList());
					vehicleQuotationVO.setUserId(vehicleQuotation.getUserId());
					if(vehicleQuotationVO.getComment() != null){
						DealerQuotationHistory userQuotationHistory = new DealerQuotationHistory();
						userQuotationHistory.setComment(vehicleQuotationVO.getComment());
						Calendar calendar = Calendar.getInstance();
					    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
					    
						userQuotationHistory.setCreationDate(ourJavaTimestampObject);
						if (vehicleQuotation.getDealerQuotationHistory() != null) {
							vehicleQuotation.getDealerQuotationHistory().add(userQuotationHistory);
						} else {
							List<DealerQuotationHistory> userQuotationHistorys = new ArrayList<>();
							userQuotationHistorys.add(userQuotationHistory);
							vehicleQuotation.setDealerQuotationHistory(userQuotationHistorys);
						}
						vehicleQuotationRepository.flush();
					}
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	
	@PutMapping("myvehicleLogBookUpdate")
	@Transactional
	public MyVehicleLogBookVO vehicleLogBookUpdate(@RequestBody MyVehicleLogBookVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update my vehicle log book {}", vehicleQuotationVO.getMyVehicleLogBookId());
				if(vehicleQuotationVO != null){
					MyVehicleLogBook vehicleQuotation = myVehicleLogBookRepository.findOne(vehicleQuotationVO.getMyVehicleLogBookId());
					
					
					vehicleQuotation.setTripType(vehicleQuotationVO.getTripType());
					vehicleQuotation.setFromLocation(vehicleQuotationVO.getFromLocation());
					vehicleQuotation.setToLocation(vehicleQuotationVO.getToLocation());
					vehicleQuotation.setDate(vehicleQuotationVO.getDate());
					vehicleQuotation.setOdoMeterStartOfTrip(vehicleQuotationVO.getOdoMeterStartOfTrip());
					vehicleQuotation.setOdoMeterEndOfTrip(vehicleQuotationVO.getOdoMeterEndOfTrip());
					vehicleQuotation.setRouteKm(vehicleQuotationVO.getRouteKm());
					vehicleQuotation.setTripDescription(vehicleQuotationVO.getTripDescription());
					vehicleQuotation.setFlex1(vehicleQuotationVO.getFlex1());
					myVehicleLogBookRepository.flush();
					
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PutMapping("myvehicleLogExpensesUpdate")
	@Transactional
	public MyVehicleFuelExpensesVO vehicleLogExpensesUpdate(@RequestBody MyVehicleFuelExpensesVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update my vehicle Expenses {}", vehicleQuotationVO.getMyVehicleFuelExpensesId());
				if(vehicleQuotationVO != null){
					MyVehicleFuelExpenses vehicleQuotation = myVehicleFuelExpensesRepository.findOne(vehicleQuotationVO.getMyVehicleFuelExpensesId());
					
					
					vehicleQuotation.setRecordType(vehicleQuotationVO.getRecordType());
					vehicleQuotation.setBusiness(vehicleQuotationVO.getBusiness());
					vehicleQuotation.setDate(vehicleQuotationVO.getDate());
					vehicleQuotation.setOthers(vehicleQuotationVO.getOthers());
					vehicleQuotation.setAmount(vehicleQuotationVO.getAmount());
					myVehicleFuelExpensesRepository.flush();
					
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PutMapping("myVehicleServMaintUpdate")
	@Transactional
	public MyVehicleServMaintVO vehicleServMaintUpdate(@RequestBody MyVehicleServMaintVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update my vehicle Serv Maint {}", vehicleQuotationVO.getMyVehicleServMaintId());
				if(vehicleQuotationVO != null){
					MyVehicleServMaint vehicleQuotation = myVehicleServMaintRepository.findOne(vehicleQuotationVO.getMyVehicleServMaintId());
					
					
					vehicleQuotation.setRecordType(vehicleQuotationVO.getRecordType());
					vehicleQuotation.setTypeOfServMaint(vehicleQuotationVO.getTypeOfServMaint());
					vehicleQuotation.setDate(vehicleQuotationVO.getDate());
					vehicleQuotation.setOdoMeterKm(vehicleQuotationVO.getOdoMeterKm());
					vehicleQuotation.setMechanicName(vehicleQuotationVO.getMechanicName());
					vehicleQuotation.setMechanicAddress(vehicleQuotationVO.getMechanicAddress());
					vehicleQuotation.setContactDetails(vehicleQuotationVO.getContactDetails());
					vehicleQuotation.setTotalAmount(vehicleQuotationVO.getTotalAmount());
					vehicleQuotation.setNextOdoMeterKm(vehicleQuotationVO.getNextOdoMeterKm());
					vehicleQuotation.setNextServDate(vehicleQuotationVO.getNextServDate());
					
					myVehicleServMaintRepository.flush();
					
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PutMapping("myVehicleGarageUpdate")
	@Transactional
	public MyVehicleVO myVehicleGarageUpdate(@RequestBody MyVehicleVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update my vehicle Garage Id {}", vehicleQuotationVO.getMyVehicleId());
				if(vehicleQuotationVO != null){
					MyVehicle vehicleQuotation = myVehicleRepository.findOne(vehicleQuotationVO.getMyVehicleId());
					
					
					//vehicleQuotation.setPostalCode(vehicleQuotationVO.getPostalCode());
					vehicleQuotation.setYear(vehicleQuotationVO.getYear());
					vehicleQuotation.setMake(vehicleQuotationVO.getMake());
					vehicleQuotation.setModel(vehicleQuotationVO.getModel());
					vehicleQuotation.setVariant(vehicleQuotationVO.getVariant());
					vehicleQuotation.setVin(vehicleQuotationVO.getVin());
					vehicleQuotation.setRegNum(vehicleQuotationVO.getRegNum());
					vehicleQuotation.setRegState(vehicleQuotationVO.getRegState());
					vehicleQuotation.setRegExpDate(vehicleQuotationVO.getRegExpDate());
					vehicleQuotation.setInsProv(vehicleQuotationVO.getInsProv());
					
					vehicleQuotation.setInsProvMan(vehicleQuotationVO.getInsProvMan());
					vehicleQuotation.setInsPremPaid(vehicleQuotationVO.getInsPremPaid());
					vehicleQuotation.setInsPremPaidFreq(vehicleQuotationVO.getInsPremPaidFreq());
					vehicleQuotation.setInsExpiry(vehicleQuotationVO.getInsExpiry());
					
					vehicleQuotation.setOdoMeter(vehicleQuotationVO.getOdoMeter());
					vehicleQuotation.setLastServiceDt(vehicleQuotationVO.getLastServiceDt());
					vehicleQuotation.setNextServiceDt(vehicleQuotationVO.getNextServiceDt());
					vehicleQuotation.setNextServKms(vehicleQuotationVO.getNextServKms());
					
					vehicleQuotation.setFinProvider(vehicleQuotationVO.getFinProvider());
					vehicleQuotation.setLoanAmt1(vehicleQuotationVO.getLoanAmt1());
					vehicleQuotation.setLoanTakenDt(vehicleQuotationVO.getLoanTakenDt());
					vehicleQuotation.setLoanPaidFreq(vehicleQuotationVO.getLoanPaidFreq());
					
					vehicleQuotation.setLoanAmt2(vehicleQuotationVO.getLoanAmt2());
					vehicleQuotation.setLoanPeriod(vehicleQuotationVO.getLoanPeriod());
					vehicleQuotation.setLoanInterest(vehicleQuotationVO.getLoanInterest());
					
					vehicleQuotation.setInsRemind(vehicleQuotationVO.isInsRemind());
					vehicleQuotation.setMaiRemind(vehicleQuotationVO.isMaiRemind());
					vehicleQuotation.setFinRemind(vehicleQuotationVO.isFinRemind());
					
				
					
					myVehicleRepository.flush();
					
						
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				return vehicleQuotationVO;
	}
	
	@PutMapping("myVehicleNotifyeUpdate")
	@Transactional
	public UserNotificationVO myVehicleNotifyUpdate(@RequestBody UserNotificationVO vehicleQuotationVO,
			HttpServletResponse response) {
		  //TODO: create a service for VehicleQutotation to update quotation details
		LOGGER.debug("Received request to update with Notification Id {}", vehicleQuotationVO.getUserNotificationId());
		
		//LOGGER.debug("Received request to update my vehicle with Notification Id {}", vehicleQuotationVO.getMyVehicleId());
				if(vehicleQuotationVO != null){
					UserNotification userNotification = userNotificationRepository.findOne(vehicleQuotationVO.getUserNotificationId());
					if(vehicleQuotationVO.getMyVehicleId() != null){
					MyVehicle vehicleQuotation = myVehicleRepository.findOne(vehicleQuotationVO.getMyVehicleId());
					
					if(vehicleQuotationVO.getCode().equalsIgnoreCase("ReGo Due Date")){
					vehicleQuotation.setRegExpDate(vehicleQuotationVO.getFlex11());
					vehicleQuotation.setVehIdentRegoRemMon(true);
					vehicleQuotation.setVehIdentRegoRemTwo(true);
					vehicleQuotation.setVehIdentRegoOne(true);
					
					}
					if(vehicleQuotationVO.getCode().equalsIgnoreCase("Insurance Due Date")){
						vehicleQuotation.setInsExpiry(vehicleQuotationVO.getFlex11());
						vehicleQuotation.setVehInsRemMon(true);
						vehicleQuotation.setVehInsRemTwo(true);
						vehicleQuotation.setVehInsRemOne(true);
						
						}
					if(vehicleQuotationVO.getCode().equalsIgnoreCase("Finance EMI due date")){
						vehicleQuotation.setLoanTakenDt(vehicleQuotationVO.getFlex11());
						vehicleQuotation.setVehFinRemMon(true);
						vehicleQuotation.setVehFinRemTwo(true);
						vehicleQuotation.setVehFinRemOne(true);
						
						}
					if(vehicleQuotationVO.getCode().equalsIgnoreCase("S&M Next due date")){
						vehicleQuotation.setNextServiceDt(vehicleQuotationVO.getFlex11());
						vehicleQuotation.setVehServRemMon(true);
						vehicleQuotation.setVehServRemTwo(true);
						vehicleQuotation.setVehServRemOne(true);
						}
					
					myVehicleRepository.flush();
					}
					userNotification.setStatus(true);
					userNotificationRepository.flush();	
					//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
				}
				
				return vehicleQuotationVO;
	}
	
	@GetMapping(value = "adminuserOtDate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserAdminSearchVO adminuser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email
			) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", firstName);
		UserAdminSearchVO userAdminSearchVO12 = new UserAdminSearchVO();
	if(!firstName.equalsIgnoreCase("undefined") && !lastName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined")  )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaFirLas(email,firstName, lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, lastName, creationDate
	else if(!lastName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaLas(email,lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, firstName, creationDate
	else if(!firstName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaFir(email,lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, firstName, creationDate
	else if(!email.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmail(email);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, firstName, creationDate
	else if(!lastName.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserLastName(lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, firstName, creationDate
	else if(!email.equalsIgnoreCase("undefined") && !firstName.equalsIgnoreCase("undefined") && !lastName.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaFirLas(email,firstName, lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}
	// email
		else if(!email.equalsIgnoreCase("undefined"))	
		{
			List<UserVO> userVOs = new ArrayList<UserVO>();
			
			List<User> users = userRepository.getUserEmail(email);
			for (User user : users) {
				userVOs.add(domainModelUtil.fromUser(user, true));
			
			}
			userAdminSearchVO12.setUserVO(userVOs);
		}
	
	// firstName
				else if(!firstName.equalsIgnoreCase("undefined"))	
				{
					List<UserVO> userVOs = new ArrayList<UserVO>();
					
					List<User> users = userRepository.getUserFirstName(firstName);
					for (User user : users) {
						userVOs.add(domainModelUtil.fromUser(user, true));
					
					}
					userAdminSearchVO12.setUserVO(userVOs);
				}
	// lastName
				else if(!lastName.equalsIgnoreCase("undefined"))	
				{
					List<UserVO> userVOs = new ArrayList<UserVO>();
					
					List<User> users = userRepository.getUserLastName(lastName);
					for (User user : users) {
						userVOs.add(domainModelUtil.fromUser(user, true));
					
					}
					userAdminSearchVO12.setUserVO(userVOs);
				}
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "adminuserall", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserAdminSearchVO adminuserall() {
		LOGGER.debug("Received request to get all users with id {} ");
		UserAdminSearchVO userAdminSearchVO12 = new UserAdminSearchVO();
	
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getAllUser();
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "adminuser", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserAdminSearchVO adminuser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("creationDate") Date creationDate) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", firstName);
		UserAdminSearchVO userAdminSearchVO12 = new UserAdminSearchVO();
	if(!firstName.equalsIgnoreCase("undefined") && !lastName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined") && creationDate != null )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserAllCriteria(email,firstName, lastName, creationDate);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, lastName, creationDate
	else if(!lastName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined") && creationDate !=null )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaLasCr(email,lastName, creationDate);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, firstName, creationDate
	else if(!firstName.equalsIgnoreCase("undefined") && !email.equalsIgnoreCase("undefined") && creationDate != null )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaFirsCr(email,firstName, creationDate);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}//email, creation Date
	else if(!email.equalsIgnoreCase("undefined") && creationDate != null )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaCr(email,creationDate);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}// email, firstName, LastName
	else if(!email.equalsIgnoreCase("undefined") && !firstName.equalsIgnoreCase("undefined") && !lastName.equalsIgnoreCase("undefined") )	
	{
		List<UserVO> userVOs = new ArrayList<UserVO>();
		
		List<User> users = userRepository.getUserEmaFirLas(email,firstName, lastName);
		for (User user : users) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		
		}
		userAdminSearchVO12.setUserVO(userVOs);
	}
	// email
		else if(!email.equalsIgnoreCase("undefined"))	
		{
			List<UserVO> userVOs = new ArrayList<UserVO>();
			
			List<User> users = userRepository.getUserEmail(email);
			for (User user : users) {
				userVOs.add(domainModelUtil.fromUser(user, true));
			
			}
			userAdminSearchVO12.setUserVO(userVOs);
		}
	// creation Date
			else if(creationDate != null)	
			{
				List<UserVO> userVOs = new ArrayList<UserVO>();
				
				List<User> users = userRepository.getUserCreationDate(creationDate);
				for (User user : users) {
					userVOs.add(domainModelUtil.fromUser(user, true));
				
				}
				userAdminSearchVO12.setUserVO(userVOs);
			}
	// firstName
				else if(!firstName.equalsIgnoreCase("undefined"))	
				{
					List<UserVO> userVOs = new ArrayList<UserVO>();
					
					List<User> users = userRepository.getUserFirstName(firstName);
					for (User user : users) {
						userVOs.add(domainModelUtil.fromUser(user, true));
					
					}
					userAdminSearchVO12.setUserVO(userVOs);
				}
	// lastName
				else if(!lastName.equalsIgnoreCase("undefined"))	
				{
					List<UserVO> userVOs = new ArrayList<UserVO>();
					
					List<User> users = userRepository.getUserLastName(lastName);
					for (User user : users) {
						userVOs.add(domainModelUtil.fromUser(user, true));
					
					}
					userAdminSearchVO12.setUserVO(userVOs);
				}
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "getSearchInforOtDate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserSearchAdminOtDateVO getSearchInforOtDate(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName, @RequestParam("modelTrim") String modelTrim
			) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", modelYear);
		UserSearchAdminOtDateVO userAdminSearchVO12 = new UserSearchAdminOtDateVO();
	if(!modelYear.equalsIgnoreCase("undefined") && !modelDisplay.equalsIgnoreCase("undefined") && !modelName.equalsIgnoreCase("undefined")  && !modelTrim.equalsIgnoreCase("undefined") )	
	{
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getSearchAllOtDate(modelYear,modelDisplay, modelName, modelTrim);
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, lastName, creationDate
	else if(!modelYear.equalsIgnoreCase("undefined") && !modelDisplay.equalsIgnoreCase("undefined")  && !modelName.equalsIgnoreCase("undefined"))	
	{
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getSearchAllOtDate1(modelYear,modelDisplay,modelName);
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, firstName, creationDate
	
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getSearchInforAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserSearchAdminVO getSearchInforAll() {
		LOGGER.debug("Received request to get Search Ebid All with id {} ");
		UserSearchAdminVO userAdminSearchVO12 = new UserSearchAdminVO();
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getAllSearch();
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getSearchInfor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserSearchAdminVO getSearchInfor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName, @RequestParam("modelTrim") String modelTrim,
			@RequestParam("creationDate") Date creationDate) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", modelYear);
		UserSearchAdminVO userAdminSearchVO12 = new UserSearchAdminVO();
	if(!modelYear.equalsIgnoreCase("undefined") && !modelDisplay.equalsIgnoreCase("undefined") && !modelName.equalsIgnoreCase("undefined")  && !modelTrim.equalsIgnoreCase("undefined") && creationDate != null )	
	{
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getSearchAllCriteria(modelYear,modelDisplay, modelName, modelTrim, creationDate);
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, lastName, creationDate
	else if(!modelYear.equalsIgnoreCase("undefined") && !modelDisplay.equalsIgnoreCase("undefined") && creationDate !=null )	
	{
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getSearchAYearDis(modelYear,modelDisplay, creationDate);
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, firstName, creationDate
	else if(creationDate !=null )	
	{
		List<SearchVO> userVOs = new ArrayList<SearchVO>();
		
		List<Search> users = userSearchLeadRepository.getSearchCreationDate(creationDate);
		for (Search user : users) {
			userVOs.add(domainModelUtil.toBatchSearchVO(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, firstName, creationDate
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getsmInforAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserServiceMaintAdminVO getsmInforAll() {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ");
		UserServiceMaintAdminVO userAdminSearchVO12 = new UserServiceMaintAdminVO();
	 
		List<SearchServMaintVO> userVOs = new ArrayList<SearchServMaintVO>();
		
		List<SearchServMaint> users = searchServMtLeadRepository.getAllSearchCriteria();
		for (SearchServMaint user : users) {
			userVOs.add(domainModelUtil.toSearchServMaint1(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "gettpInforAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserTranspAdminVO gettpInforAll() {
		LOGGER.debug("Received request to get Transport Requests with id {} ");
		UserTranspAdminVO userAdminSearchVO12 = new UserTranspAdminVO();
	 
		List<SearchTranspVO> userVOs = new ArrayList<SearchTranspVO>();
		
		List<SearchTransp> users = searchTranspRepository.getAllSearchCriteria();
		for (SearchTransp user : users) {
			userVOs.add(domainModelUtil.toSearchTransp1(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getfinInforAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserFinAdminVO getfinInforAll() {
		LOGGER.debug("Received request to get Finance Requests with id {} ");
		UserFinAdminVO userAdminSearchVO12 = new UserFinAdminVO();
	 
		List<SearchFinanceVO> userVOs = new ArrayList<SearchFinanceVO>();
		
		List<SearchFinance> users = searchFinanceRepository.getAllSearchCriteria();
		for (SearchFinance user : users) {
			userVOs.add(domainModelUtil.toSearchFin1(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getinsInforAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserInsAdminVO getinsInforAll() {
		LOGGER.debug("Received request to get Insurance Requests with id {} ");
		UserInsAdminVO userAdminSearchVO12 = new UserInsAdminVO();
	 
		List<SearchInsuranceVO> userVOs = new ArrayList<SearchInsuranceVO>();
		
		List<SearchInsurance> users = searchInsuranceRepository.getAllSearchCriteria();
		for (SearchInsurance user : users) {
			userVOs.add(domainModelUtil.toSearchIns1(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	
		return userAdminSearchVO12;
	}
	
	
	@GetMapping(value = "getSmInfor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserServiceMaintAdminVO getSmInfor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName, @RequestParam("modelTrim") String modelTrim,
			@RequestParam("creationDate") Date creationDate) {
		LOGGER.debug("Received request to get Dealer Search Finance with id {} ", modelYear);
		UserServiceMaintAdminVO userAdminSearchVO12 = new UserServiceMaintAdminVO();
	 if(creationDate !=null )	
	{
		List<SearchServMaintVO> userVOs = new ArrayList<SearchServMaintVO>();
		
		List<SearchServMaint> users = searchServMtLeadRepository.getSearchCreationDate(creationDate);
		for (SearchServMaint user : users) {
			userVOs.add(domainModelUtil.toSearchServMaint1(user));
		
		}
		userAdminSearchVO12.setSearchVO(userVOs);
	}//email, firstName, creationDate
	
		return userAdminSearchVO12;
	}
	
	@GetMapping(value = "getStatusforReferenced")
	public boolean getStatusforReferenced(@RequestParam("rEmailId") String rEmailId){
		if(userRepository.getUserEmail(rEmailId) == null){
			return false;
		}else{
			// logic to update refernced email
			List<UserReferPoints> checkUserReferPoints=userReferPointsRepository.getReferEmail(rEmailId);
			for (UserReferPoints checkUserReferPoint : checkUserReferPoints) {
				checkUserReferPoint.setStatus(true);
				userReferPointsRepository.flush();
			}
			return true;
		}
		
	}

}
