package au.com.pnspvtltd.mcd.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.CurrentOffers;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.CurrentOffersRepository;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.ServMaintQuotationRepository;
import au.com.pnspvtltd.mcd.repository.TranspServQuotationRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.service.UserService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.CurrentOffersVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.UserOnlyVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleQuotationRepository vehicleQuotationRepository;
	@Autowired
	private InsuranceQuotationRepository insuranceQuotationRepository;
	@Autowired
	private FinanceQuotationRepository financeQuotationRepository;
	@Autowired
	private ServMaintQuotationRepository servMaintQuotationRepository;
	@Autowired
	private TranspServQuotationRepository transpServQuotationRepository;
	@Autowired
	private CurrentOffersRepository currentOffersRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	@Transactional(readOnly = true)
	public UserVO findById(Long id) {
		UserVO userVO = null;
		User user = userRepository.findOne(id);
		if (user != null) {
			userVO = domainModelUtil.fromUser(user, false);

			List<VehicleQuotation> vehicleQuotations = vehicleQuotationRepository.getQuotationsForUser(id);
			List<VehicleQuotationVO> vehicleQuotationVOs = new ArrayList<>();
			for (VehicleQuotation vehicleQuotation : vehicleQuotations) {
				vehicleQuotationVOs.add(domainModelUtil.fromVehicleQuotation(vehicleQuotation, false));
			}
			userVO.setVehicleQuotation(vehicleQuotationVOs);

			List<InsuranceQuotation> insuranceQuotations = insuranceQuotationRepository.getQuotationsForUser(id);
			List<InsuranceQuotationVO> insuranceQuotationVOs = new ArrayList<>();
			for (InsuranceQuotation insuranceQuotation : insuranceQuotations) {
				insuranceQuotationVOs.add(domainModelUtil.fromInsuranceQuotation(insuranceQuotation));
			}
			userVO.setInsuranceQuotation(insuranceQuotationVOs);

			List<FinanceQuotation> financeQuotations = financeQuotationRepository.getQuotationsForUser(id);
			List<FinanceQuotationVO> financeQuotationVOs = new ArrayList<>();
			for (FinanceQuotation financeQuotation : financeQuotations) {
				financeQuotationVOs.add(domainModelUtil.fromFinanceQuotation(financeQuotation));
			}
			userVO.setFinanceQuotation(financeQuotationVOs);
			
			// start ServMaint
			List<ServiceMaintQuotation> servMaintQuotations = servMaintQuotationRepository.getQuotationsForUser(id);
			List<ServiceMaintQuotationVO> serviceMaintQuotationVOs = new ArrayList<>();
			for (ServiceMaintQuotation servMaintQuotation : servMaintQuotations) {
				serviceMaintQuotationVOs.add(domainModelUtil.fromServMaintQuotation(servMaintQuotation));
			}
			userVO.setServMaintQuotation(serviceMaintQuotationVOs);
			// end ServMaint
			
			// start transp serv
			List<TranspServiceQuotation> transpServiceQuotations = transpServQuotationRepository.getQuotationsForUser(id);
			List<TranspServiceQuotationVO> transpServiceQuotationVOs = new ArrayList<>();
			for (TranspServiceQuotation transpServiceQuotation : transpServiceQuotations) {
				transpServiceQuotationVOs.add(domainModelUtil.fromTranspServQuotation(transpServiceQuotation));
			}
			userVO.setTranspServQuotation(transpServiceQuotationVOs);
			// end transp serv
			
			List<CurrentOffers> currentOffers = currentOffersRepository.findAll();
			List<CurrentOffersVO> currentOffersVOs = new ArrayList<>();
			for (CurrentOffers currentOffer : currentOffers) {
				currentOffersVOs.add(domainModelUtil.fromCurrentOffers(currentOffer));
			}
			userVO.setCurrentOffers(currentOffersVOs);

		}
		return userVO;
	}

	
	@Override
	@Transactional(readOnly = true)
	public UserOnlyVO findByUserOnlyId(Long id) {
		UserOnlyVO userVO = null;
		User user = userRepository.findOne(id);
		if (user != null) {
			userVO = domainModelUtil.toUserOnly(user);
		}
		return userVO;
	}
	
	
	@Override
	@Transactional
	public UserVO createUser(UserVO userVO) {
		userVO.setUserId(null);
		 // (2) create a java sql date object we want to insert
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	    
		userVO.setCreationDate(ourJavaDateObject);
		return domainModelUtil.fromUser(userRepository.save(domainModelUtil.toUser(userVO)), true);
	}

	@Override
	@Transactional
	public UserVO updateUser(UserVO userVO) {
		User userToUpdate = userRepository.findOne(userVO.getUserId());

		if (userToUpdate == null) {
			LOGGER.debug("User with id {} does not exist", userVO.getUserId());
			return null;
		}

		try {
			BeanUtils.copyProperties(userToUpdate, userVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		User user = userRepository.save(userToUpdate);
		return domainModelUtil.fromUser(user, false);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserVO> findAllUsers() {
		List<UserVO> userVOs = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			userVOs.add(domainModelUtil.fromUser(user, true));
		}
		return userVOs;
	}

	@Override
	@Transactional(readOnly = true)
	public UserVO findUserByEmail(String email) {
		return domainModelUtil.fromUser(userRepository.findByEmailIgnoreCase(email), true);
	}

}
