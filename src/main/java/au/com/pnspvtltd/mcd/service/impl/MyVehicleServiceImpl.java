package au.com.pnspvtltd.mcd.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.MyVehicleFuelExpenses;
import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;
import au.com.pnspvtltd.mcd.domain.MyVehicleServMaint;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.FinanceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.InsuranceQuotationRepository;
import au.com.pnspvtltd.mcd.repository.MyVehicleRepository;
import au.com.pnspvtltd.mcd.repository.UserRepository;
import au.com.pnspvtltd.mcd.repository.VehicleQuotationRepository;
import au.com.pnspvtltd.mcd.service.MyVehicleService;
import au.com.pnspvtltd.mcd.service.UserService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelCardStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

@Service
public class MyVehicleServiceImpl implements MyVehicleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyVehicleServiceImpl.class);

	@Autowired
	private MyVehicleRepository myVehicleRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	@Transactional
	public String addMyVehicleLogBook(MyVehicleLogBookStoreVO inventoryVO) {
		
		// Find the MyVehicle
				MyVehicle myVehicle = myVehicleRepository.findOne(inventoryVO.getMyVehicleId());
				// Create User Search Lead (Vehicle Lead)
				MyVehicleLogBook search = domainModelUtil.toLogBook(inventoryVO.getMyVehicleLogBookVO());
				if (myVehicle.getMyVehicleLogBook() != null) {
					myVehicle.getMyVehicleLogBook().add(search);
				} else {
					List<MyVehicleLogBook> myvehicleLogBook = new ArrayList<>();
					myvehicleLogBook.add(search);
					myVehicle.setMyVehicleLogBook(myvehicleLogBook);
				}
				myVehicleRepository.flush();
		return "{\"myVehicleId\":" + myVehicle.getMyVehicleId() + ",\"myVehicleLogBookId\":" + search.getMyVehicleServMaintId() + "}";
	}
	
	@Override
	@Transactional
	public String addMyVehicleFuelExpenses(MyVehicleFuelCardStoreVO inventoryVO) {
		
		// Find the MyVehicle
				MyVehicle myVehicle = myVehicleRepository.findOne(inventoryVO.getMyVehicleId());
				// Create User Search Lead (Vehicle Lead)
				MyVehicleFuelExpenses search = domainModelUtil.toFuelExpenses(inventoryVO.getMyVehicleFuelExpensesVO());
				if (myVehicle.getMyVehicleFuelExpenses() != null) {
					myVehicle.getMyVehicleFuelExpenses().add(search);
				} else {
					List<MyVehicleFuelExpenses> myvehicleLogBook = new ArrayList<>();
					myvehicleLogBook.add(search);
					myVehicle.setMyVehicleFuelExpenses(myvehicleLogBook);
				}
				myVehicleRepository.flush();
		return "{\"myVehicleId\":" + myVehicle.getMyVehicleId() + ",\"myVehicleFuelExpensesId\":" + search.getMyVehicleFuelExpensesId() + "}";
	}
	
	
	@Override
	@Transactional
	public String addMyVehicleServMaint(MyVehicleServMaintStoreVO inventoryVO) {
		
		// Find the MyVehicle
				MyVehicle myVehicle = myVehicleRepository.findOne(inventoryVO.getMyVehicleId());
				// Create User Search Lead (Vehicle Lead)
				MyVehicleServMaint search = domainModelUtil.toServMaint(inventoryVO.getMyVehicleServMaintVO());
				if (myVehicle.getMyVehicleServMaint() != null) {
					myVehicle.getMyVehicleServMaint().add(search);
				} else {
					List<MyVehicleServMaint> myvehicleLogBook = new ArrayList<>();
					myvehicleLogBook.add(search);
					myVehicle.setMyVehicleServMaint(myvehicleLogBook);
				}
				myVehicleRepository.flush();
		return "{\"myVehicleId\":" + myVehicle.getMyVehicleId() + ",\"myVehicleServMaintId\":" + search.getMyVehicleServMaintId() + "}";
	}

}
