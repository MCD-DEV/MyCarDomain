package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.MyVehicleFuelExpenses;
import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;
import au.com.pnspvtltd.mcd.domain.MyVehicleServMaint;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserNotification;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.service.UserEBidService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelExpensesVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.UserAdminSearchVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidFinanceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidServMaintVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidTransServVO;
import au.com.pnspvtltd.mcd.web.model.UserEBidVO;
import au.com.pnspvtltd.mcd.web.model.UserMyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserNotificationVO;
import au.com.pnspvtltd.mcd.web.model.UserPhotoVO;
import au.com.pnspvtltd.mcd.web.model.UserSearchAdminOtDateVO;
import au.com.pnspvtltd.mcd.web.model.UserSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.repository.MyVehicleFuelExpensesRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleLogBookRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleServMaintRepository;
import au.com.pnspvtltd.mcd.repository.UserNotificationRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.UserSearchLeadRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;

@RestController

public class UserEBidController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserEBidController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSearchLeadRepository userSearchLeadRepository;
	
	@Autowired
	private UserNotificationRepository userNotificationRepository;
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
			//user.setAreaName(userMyVehicleVO.); // phone number
			//vehicleQuotation.setMoveToUser(vehicleQuotationVO.isMoveToUser());
		}
		return user;
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
					if(vehicleQuotationVO.getComment() != null){
						UserQuotationHistory userQuotationHistory = new UserQuotationHistory();
						userQuotationHistory.setComment(vehicleQuotationVO.getComment());
						Calendar calendar = Calendar.getInstance();
					    java.sql.Date ourJavaTimestampObject = new java.sql.Date(calendar.getTime().getTime());
					    
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
}
