package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelCardStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintStoreVO;

public interface MyVehicleService {

	/*
	 * UserVO findById(Long id);
	 * 
	 * UserVO createUser(UserVO user);
	 * 
	 * UserVO updateUser(UserVO user);
	 * 
	 * List<UserVO> findAllUsers();
	 * 
	 * UserVO findUserByEmail(String email);
	 */
	String addMyVehicleLogBook(MyVehicleLogBookStoreVO inventoryVO);

	String addMyVehicleFuelExpenses(MyVehicleFuelCardStoreVO inventoryVO);

	String addMyVehicleServMaint(MyVehicleServMaintStoreVO inventoryVO);

	List<MyVehicleLogBookStoreVO> getMyVehicleLogBook(MyVehicleLogBookStoreVO inventoryVO);
}
