package au.com.pnspvtltd.mcd.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.pnspvtltd.mcd.domain.*;
import au.com.pnspvtltd.mcd.web.model.*;

@Component
public class DomainModelUtil {

	@Autowired
	private NullAwareBeanUtils nullAwareBeanUtils;

	public UserVO fromUser(final User user, boolean isMinified) {

		if (user == null) {
			return null;
		}

		UserVO userVO = new UserVO();
		try {
// search
			org.springframework.beans.BeanUtils.copyProperties(user, userVO, new String[] {"search","searchInsurance",
					"searchFinance", "searchServMaint", "searchTransp", "myVehicle", "userNotification"  });

			if (!isMinified) {
				List<SearchVO> searchVOs = new ArrayList<>();
				for (Search search : user.getSearch()) {
					SearchVO searchVO = new SearchVO();
					BeanUtils.copyProperties(searchVO, search);
					searchVOs.add(searchVO);
				}
				userVO.setSearch(searchVOs);

				List<SearchInsuranceVO> searchInsuranceVOs = new ArrayList<>();
				for (SearchInsurance searchInsurance : user.getSearchInsurance()) {
					SearchInsuranceVO SearchInsuranceVO = new SearchInsuranceVO();
					BeanUtils.copyProperties(SearchInsuranceVO, searchInsurance);
					searchInsuranceVOs.add(SearchInsuranceVO);
				}
				userVO.setSearchInsurance(searchInsuranceVOs);

				List<SearchFinanceVO> searchFinanceVOs = new ArrayList<>();
				for (SearchFinance searchFinance : user.getSearchFinance()) {
					SearchFinanceVO searchFinanceVO = new SearchFinanceVO();
					BeanUtils.copyProperties(searchFinanceVO, searchFinance);
					searchFinanceVOs.add(searchFinanceVO);
				}
				userVO.setSearchFinance(searchFinanceVOs);

				List<SearchServMaintVO> searchServMaintVOs = new ArrayList<>();
				for (SearchServMaint searchFinance : user.getSearchServMaint()) {
					SearchServMaintVO searchFinanceVO = new SearchServMaintVO();
					BeanUtils.copyProperties(searchFinanceVO, searchFinance);
					searchServMaintVOs.add(searchFinanceVO);
				}
				userVO.setSearchServMaint(searchServMaintVOs);

				List<SearchTranspVO> searchTranspVOs = new ArrayList<>();
				for (SearchTransp searchFinance : user.getSearchTransp()) {
					SearchTranspVO searchFinanceVO = new SearchTranspVO();
					BeanUtils.copyProperties(searchFinanceVO, searchFinance);
					searchTranspVOs.add(searchFinanceVO);
				}
				userVO.setSearchTransp(searchTranspVOs);

				List<UserNotificationVO> userNotificationVOs = new ArrayList<>();
				for (UserNotification searchFinance : user.getUserNotification()) {
					UserNotificationVO searchFinanceVO = new UserNotificationVO();
					BeanUtils.copyProperties(searchFinanceVO, searchFinance);
					userNotificationVOs.add(searchFinanceVO);
				}
				userVO.setUserNotification(userNotificationVOs);

				List<MyVehicleVO> myVehicleVOs = new ArrayList<>();
				for (MyVehicle myVehicle : user.getMyVehicle()) {
					MyVehicleVO myVehicleVO = new MyVehicleVO();
					BeanUtils.copyProperties(myVehicleVO, myVehicle);
					myVehicleVOs.add(myVehicleVO);
				}
				userVO.setMyVehicle(myVehicleVOs);

			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	public User toUser(final UserVO userVO) {

		User user = new User();
		try {
			BeanUtils.copyProperties(user, userVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public UserOnlyVO toUserOnly(final User user) {

		UserOnlyVO userVO = new UserOnlyVO();
		try {
			BeanUtils.copyProperties(userVO, user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}
	
	public ComingSoonVO fromComingSoonUser(final ComingSoonUser user) {

		if (user == null) {
			return null;
		}

		ComingSoonVO userVO = new ComingSoonVO();
		try {
			BeanUtils.copyProperties(userVO, user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	public AdminAutoVO fromAdmin(final AdminAuto user) {

		if (user == null) {
			return null;
		}

		AdminAutoVO userVO = new AdminAutoVO();
		try {
			BeanUtils.copyProperties(userVO, user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	public ComingSoonUser toComingSoonUser(final ComingSoonVO userVO) {
		ComingSoonUser user = new ComingSoonUser();
		try {
			BeanUtils.copyProperties(user, userVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// start to retrieve total data for inventory

	public InventoryVO fromInventoryFull(final Inventory user, boolean isMinified) {

		if (user == null) {
			return null;
		}

		InventoryVO userVO = new InventoryVO();
		try {
// search
			org.springframework.beans.BeanUtils.copyProperties(user, userVO, new String[] {"quotationFeatList","vehicleResourcDetails"  });

			if (!isMinified) {
				if (user.getQuotationFeatList() != null) {
					List<QuotationFeatListVO> searchVOs = new ArrayList<>();
					for (QuotationFeatList search : user.getQuotationFeatList()) {
						QuotationFeatListVO searchVO = new QuotationFeatListVO();
						BeanUtils.copyProperties(searchVO, search);
						searchVOs.add(searchVO);
					}
					userVO.setQuotationFeatList(searchVOs);
				}
				if (user.getVehicleResourcDetails() != null) {
					List<VehicleResourceDetailsInvVO> vehicleDealerDetailsVO = new ArrayList<>();
					for (VehicleResourceDetailsInv vehicleDealerDetail : user.getVehicleResourcDetails()) {
						VehicleResourceDetailsInvVO searchFinanceVO = new VehicleResourceDetailsInvVO();
						BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
						vehicleDealerDetailsVO.add(searchFinanceVO);
					}
					userVO.setVehicleResourcDetails(vehicleDealerDetailsVO);
				}

			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	// end to retrive total data

	// start to serv master

	public VehicleDealerServMaintDetailsVO fromDealerServMast(final VehicleDealerServMaintDetails user) {

		if (user == null) {
			return null;
		}

		VehicleDealerServMaintDetailsVO userVO = new VehicleDealerServMaintDetailsVO();
		try {
			// search
			org.springframework.beans.BeanUtils.copyProperties(user, userVO,
					new String[] { "vehicleDealerServSpareList", "vehicleDealerServHypList", "vehicleResourceDetails" });

			if (user.getVehicleDealerServSpareList() != null) {
				List<VehicleServSpareListVO> searchVOs = new ArrayList<>();
				for (VehicleServSpareList search : user.getVehicleDealerServSpareList()) {
					VehicleServSpareListVO searchVO = new VehicleServSpareListVO();
					BeanUtils.copyProperties(searchVO, search);
					searchVOs.add(searchVO);
				}
				userVO.setVehicleDealerServSpareList(searchVOs);
			}
			if (user.getVehicleDealerServHypList() != null) {
				List<VehicleServHypListVO> vehicleDealerDetailsVO = new ArrayList<>();
				for (VehicleServHypList vehicleDealerDetail : user.getVehicleDealerServHypList()) {
					VehicleServHypListVO searchFinanceVO = new VehicleServHypListVO();
					BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
					vehicleDealerDetailsVO.add(searchFinanceVO);
				}
				userVO.setVehicleDealerServHypList(vehicleDealerDetailsVO);
			}
			
			if (user.getVehicleResourceDetails() != null) {
				List<VehicleResourceDetailsServVO> vehicleDealerDetailsVO = new ArrayList<>();
				for (VehicleResourceDetailsServ vehicleDealerDetail : user.getVehicleResourceDetails()) {
					VehicleResourceDetailsServVO searchFinanceVO = new VehicleResourceDetailsServVO();
					BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
					vehicleDealerDetailsVO.add(searchFinanceVO);
				}
				userVO.setVehicleResourcDetails(vehicleDealerDetailsVO);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	// end to serv master

	// start to tranp master

	public VehicleDealerTranspDetailsVO fromDealerTranspMast(final VehicleDealerTranspDetails user) {

		if (user == null) {
			return null;
		}

		VehicleDealerTranspDetailsVO userVO = new VehicleDealerTranspDetailsVO();
		try {
			// search
			org.springframework.beans.BeanUtils.copyProperties(user, userVO,
					new String[] { "vehicleDealerTranpHypList","vehicleResourceDetails" });

			if (user.getVehicleDealerTranpHypList() != null) {
				List<VehicleTranpHypListVO> vehicleDealerDetailsVO = new ArrayList<>();
				for (VehicleTranpHypList vehicleDealerDetail : user.getVehicleDealerTranpHypList()) {
					VehicleTranpHypListVO searchFinanceVO = new VehicleTranpHypListVO();
					BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
					vehicleDealerDetailsVO.add(searchFinanceVO);
				}
				userVO.setVehicleDealerTranpHypList(vehicleDealerDetailsVO);
			}
			if (user.getVehicleResourceDetails() != null) {
				List<VehicleResourceDetailsTranspVO> vehicleDealerDetailsVO = new ArrayList<>();
				for (VehicleResourceDetailsTransp vehicleDealerDetail : user.getVehicleResourceDetails()) {
					VehicleResourceDetailsTranspVO searchFinanceVO = new VehicleResourceDetailsTranspVO();
					BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
					vehicleDealerDetailsVO.add(searchFinanceVO);
				}
				userVO.setVehicleResourceDetails(vehicleDealerDetailsVO);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	// end to transp master

	public VehicleResourceDetailsVO fromResource(final VehicleResourceDetails inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		VehicleResourceDetailsVO inventoryVO = new VehicleResourceDetailsVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	public UserQuotationHistoryVO fromChatHistory(final UserQuotationHistory inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		UserQuotationHistoryVO inventoryVO = new UserQuotationHistoryVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}

	
	// finance
	public UserQuotationHistoryFinVO fromChatHistoryFin(final UserQuotationHistoryFin inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		UserQuotationHistoryFinVO inventoryVO = new UserQuotationHistoryFinVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	// insurance
		public UserQuotationHistoryInsVO fromChatHistoryIns(final UserQuotationHistoryIns inventory, boolean isMinified) {
			if (inventory == null) {
				return null;
			}

			UserQuotationHistoryInsVO inventoryVO = new UserQuotationHistoryInsVO();
			try {
				// TODO: return only minified if required
				BeanUtils.copyProperties(inventoryVO, inventory);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return inventoryVO;
		}
	
		// service
				public UserQuotationHistoryServVO fromChatHistoryServ(final UserQuotationHistoryServ inventory, boolean isMinified) {
					if (inventory == null) {
						return null;
					}

					UserQuotationHistoryServVO inventoryVO = new UserQuotationHistoryServVO();
					try {
						// TODO: return only minified if required
						BeanUtils.copyProperties(inventoryVO, inventory);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return inventoryVO;
				}
				
				// transport
				public UserQuotationHistoryTranpVO fromChatHistoryTransp(final UserQuotationHistoryTranp inventory, boolean isMinified) {
					if (inventory == null) {
						return null;
					}

					UserQuotationHistoryTranpVO inventoryVO = new UserQuotationHistoryTranpVO();
					try {
						// TODO: return only minified if required
						BeanUtils.copyProperties(inventoryVO, inventory);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return inventoryVO;
				}
				
	public VehicleDealerServMaintDetailsVO fromServMast(final VehicleDealerServMaintDetails inventory,
			boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		VehicleDealerServMaintDetailsVO inventoryVO = new VehicleDealerServMaintDetailsVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}

	public VehicleDealerTranspDetailsVO fromTranspvMast(final VehicleDealerTranspDetails inventory,
			boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		VehicleDealerTranspDetailsVO inventoryVO = new VehicleDealerTranspDetailsVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}

	public FinanceEntityVO fromFinancevMast(final FinanceEntity inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		FinanceEntityVO inventoryVO = new FinanceEntityVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	
	public DealerSearchServMaintVO fromServicenMaint(final DealerSearchServMaint inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		DealerSearchServMaintVO inventoryVO = new DealerSearchServMaintVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	
	public DealerSearchInsuranceVO fromDealerIns(final DealerSearchInsurance inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		DealerSearchInsuranceVO inventoryVO = new DealerSearchInsuranceVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	
	public DealerSearchFinanceVO fromDealerFin(final DealerSearchFinance inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		DealerSearchFinanceVO inventoryVO = new DealerSearchFinanceVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	
	public DealerSearchTranspVO fromTransport(final DealerSearchTransp inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		DealerSearchTranspVO inventoryVO = new DealerSearchTranspVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	public VehicleDealerInsuranceDetailsVO fromInsuranceMast(final VehicleDealerInsuranceDetails inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		VehicleDealerInsuranceDetailsVO inventoryVO = new VehicleDealerInsuranceDetailsVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}
	
	public InventoryVO fromInventory(final Inventory inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		InventoryVO inventoryVO = new InventoryVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}

	public RegoStateUrlVO fromRegoStateUrl(final RegoStateUrl inventory, boolean isMinified) {
		if (inventory == null) {
			return null;
		}

		RegoStateUrlVO inventoryVO = new RegoStateUrlVO();
		try {
			// TODO: return only minified if required
			BeanUtils.copyProperties(inventoryVO, inventory);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryVO;
	}

	public Inventory toInventory(final InventoryVO inventoryVO) {
		Inventory inventory = new Inventory();
		try {
			BeanUtils.copyProperties(inventory, inventoryVO);

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
			}

			inventory.setQuotationFeatList(quoList);

			// resource:

			List<VehicleResourceDetailsInvVO> qvo1 = inventoryVO.getVehicleResourcDetails();
			List<VehicleResourceDetailsInv> quoList1 = new ArrayList<VehicleResourceDetailsInv>();

			Iterator<VehicleResourceDetailsInvVO> it1 = qvo1.iterator();
			for (; it1.hasNext();) {
				VehicleResourceDetailsInvVO local1 = it1.next();
				VehicleResourceDetailsInv quo1 = new VehicleResourceDetailsInv();
				try {
					BeanUtils.copyProperties(quo1, local1);
					quoList1.add(quo1);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			inventory.setVehicleResourcDetails(quoList1);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}

	public List<Inventory> toInventoryList(final InventoryListVO inventoryListVO) {

		List<InventoryVO> inventoryVOList;
		inventoryVOList = inventoryListVO.getInventoryVO();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		Iterator<InventoryVO> it = inventoryVOList.iterator();
		for (; it.hasNext();) {
			InventoryVO local = it.next();
			Inventory inventory = new Inventory();
			try {
				BeanUtils.copyProperties(inventory, local);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inventoryList.add(inventory);
		}
		return inventoryList;
	}

	public List<FinanceEntity> toFinanceEntityList(final FinanceEntityListVO inventoryListVO) {

		List<FinanceEntityVO> inventoryVOList;
		inventoryVOList = inventoryListVO.getInventoryVO();
		List<FinanceEntity> inventoryList = new ArrayList<FinanceEntity>();
		Iterator<FinanceEntityVO> it = inventoryVOList.iterator();
		for (; it.hasNext();) {
			FinanceEntityVO local = it.next();
			FinanceEntity inventory = new FinanceEntity();
			try {
				BeanUtils.copyProperties(inventory, local);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inventoryList.add(inventory);
		}
		return inventoryList;
	}

	public MyVehicleLogBook toMyVehicleLogBook(final MyVehicleLogBookVO inventoryVO) {
		MyVehicleLogBook inventory = new MyVehicleLogBook();
		try {
			BeanUtils.copyProperties(inventory, inventoryVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}

	// User Car/MyVehicle Details lead
	public MyVehicle toMyVehicle(final MyVehicleVO searchVO) {

		MyVehicle search = new MyVehicle();
		try {
			BeanUtils.copyProperties(search, searchVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return search;
	}

	// From Vehcile

	public MyVehicleVO FromMyVehicle(final MyVehicle myVehicle) {

		MyVehicleVO myVehicleVO = new MyVehicleVO();

		try {
			// BeanUtils.copyProperties(myVehicleVO, myVehicle);
			org.springframework.beans.BeanUtils.copyProperties(myVehicle, myVehicleVO,
					new String[] { "myVehicleLogBook", "myVehicleFuelExpenses", "myVehicleServMaint" });
			List<MyVehicleLogBookVO> myVehicleLogBookVOs = new ArrayList<>();
			for (MyVehicleLogBook myVehicleLogBook : myVehicle.getMyVehicleLogBook()) {
				MyVehicleLogBookVO myVehicleLogBookVO = new MyVehicleLogBookVO();
				BeanUtils.copyProperties(myVehicleLogBookVO, myVehicleLogBook);
				myVehicleLogBookVOs.add(myVehicleLogBookVO);
			}
			myVehicleVO.setMyVehicleLogBook(myVehicleLogBookVOs);

			List<MyVehicleFuelExpensesVO> myVehicleFuelExpensesVOs = new ArrayList<>();
			for (MyVehicleFuelExpenses myVehicleFuelExpenses : myVehicle.getMyVehicleFuelExpenses()) {
				MyVehicleFuelExpensesVO myVehicleFuelExpensesVO = new MyVehicleFuelExpensesVO();
				BeanUtils.copyProperties(myVehicleFuelExpensesVO, myVehicleFuelExpenses);
				myVehicleFuelExpensesVOs.add(myVehicleFuelExpensesVO);
			}
			myVehicleVO.setMyVehicleFuelExpenses(myVehicleFuelExpensesVOs);

			List<MyVehicleServMaintVO> myVehicleServMaintVOs = new ArrayList<>();
			for (MyVehicleServMaint myVehicleServMaint : myVehicle.getMyVehicleServMaint()) {
				MyVehicleServMaintVO myVehicleServMaintVO = new MyVehicleServMaintVO();
				BeanUtils.copyProperties(myVehicleServMaintVO, myVehicleServMaint);
				myVehicleServMaintVOs.add(myVehicleServMaintVO);
			}
			myVehicleVO.setMyVehicleServMaint(myVehicleServMaintVOs);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myVehicleVO;
	}

	// User Car/Search Details lead
	public SearchVO toBatchSearchVO(final Search search) {

		SearchVO searchVO = new SearchVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public UserReferPointsVO toUserReferVO(final UserReferPoints search) {

		UserReferPointsVO searchVO = new UserReferPointsVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public ReferencedPointsVO toRefercedVO(final ReferencedPoints search) {

		ReferencedPointsVO searchVO = new ReferencedPointsVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public BlogPointsVO toBlogPointsVO(final BlogPoints search) {

		BlogPointsVO searchVO = new BlogPointsVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public ReviewPointsVO toReviewPointsVO(final ReviewPoints search) {

		ReviewPointsVO searchVO = new ReviewPointsVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public ValTransPointsVO toValTransPointsVO(final ValTransPoints search) {

		ValTransPointsVO searchVO = new ValTransPointsVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public LoyalityProgAdminVO toLoyalityProgVO(final LoyalityProgAdmin search) {

		LoyalityProgAdminVO searchVO = new LoyalityProgAdminVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public InventoryVO toMyVehInvVO(final Inventory search) {

		InventoryVO searchVO = new InventoryVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public Search toSearch(final SearchVO searchVO) {

		Search search = new Search();
		try {
			BeanUtils.copyProperties(search, searchVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return search;
	}

	// User myVehicle/myVehicleLogBook Details lead
	public MyVehicleLogBook toLogBook(final MyVehicleLogBookVO searchVO) {

		MyVehicleLogBook search = new MyVehicleLogBook();
		try {
			BeanUtils.copyProperties(search, searchVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return search;
	}

	// User myVehicle/myVehicleFuelExpenses Details lead
	public MyVehicleFuelExpenses toFuelExpenses(final MyVehicleFuelExpensesVO searchVO) {

		MyVehicleFuelExpenses search = new MyVehicleFuelExpenses();
		try {
			BeanUtils.copyProperties(search, searchVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return search;
	}

	// User myVehicle/myVehicleFuelExpenses Details lead
	public MyVehicleServMaint toServMaint(final MyVehicleServMaintVO searchVO) {

		MyVehicleServMaint search = new MyVehicleServMaint();
		try {
			BeanUtils.copyProperties(search, searchVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return search;
	}

	// Dealer Vehicle Lead
	public DealerSearch toDealerSearch(final SearchVO searchVO) {

		DealerSearch dealerSearch = new DealerSearch();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);
			dealerSearch.setsPostCode(searchVO.getPostCode());
			dealerSearch.setsCarColor(searchVO.getCarColor());

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public DealerSearch toDealerSearch1(final DealerSearchVO searchVO) {

		DealerSearch dealerSearch = new DealerSearch();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public DealerSearchVO toDealerSearchVO(final DealerSearch searchVO) {

		DealerSearchVO dealerSearch = new DealerSearchVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealerSearchVO toExtDealerSearchVO(final ExtDealerSearch searchVO) {

		ExtDealerSearchVO dealerSearch = new ExtDealerSearchVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public LoyalityProgAdminVO fromLoyalProg(final LoyalityProgAdmin searchVO) {

		LoyalityProgAdminVO dealerSearch = new LoyalityProgAdminVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealServMaintr1VO toExtDealerServMaintVO(final ExtDealServMaintr1 searchVO) {

		ExtDealServMaintr1VO dealerSearch = new ExtDealServMaintr1VO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealerSearchTpVO toExtDealerTranspVO(final ExtDealerSearchTp searchVO) {

		ExtDealerSearchTpVO dealerSearch = new ExtDealerSearchTpVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealerSearchFinVO toExtDealerFinVO(final ExtDealerSearchFin searchVO) {

		ExtDealerSearchFinVO dealerSearch = new ExtDealerSearchFinVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealerSearchInsVO toExtDealerInsVO(final ExtDealerSearchIns searchVO) {

		ExtDealerSearchInsVO dealerSearch = new ExtDealerSearchInsVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public VehicleQuotationVO toExtQtDealerSearchVO(final VehicleQuotation searchVO) {

		VehicleQuotationVO dealerSearch = new VehicleQuotationVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExternalDealerVO toExternalDealerVO(final ExternalDealer searchVO) {

		ExternalDealerVO dealerSearch = new ExternalDealerVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealer toExternalDealer(final ExternalDealerVO searchVO) {

		ExternalDealer dealerSearch = new ExternalDealer();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// start of external dealer Tp
	public ExternalDealerTpVO toExternalDealerTpVO(final ExternalDealerTp searchVO) {

		ExternalDealerTpVO dealerSearch = new ExternalDealerTpVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealerTp toExternalDealerTp(final ExternalDealerTpVO searchVO) {

		ExternalDealerTp dealerSearch = new ExternalDealerTp();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// end of external dealer Tp

	// start of external dealer Fin
	public ExternalDealerInsVO toExternalDealerInsVO(final ExternalDealerIns searchVO) {

		ExternalDealerInsVO dealerSearch = new ExternalDealerInsVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// start of external dealer Fin
	public LoyalityProgAdminVO toLoyalityProgramVO(final LoyalityProgAdmin searchVO) {

		LoyalityProgAdminVO dealerSearch = new LoyalityProgAdminVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// start of external dealer Fin
	public ExternalDealerFinVO toExternalDealerFinVO(final ExternalDealerFin searchVO) {

		ExternalDealerFinVO dealerSearch = new ExternalDealerFinVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealerFin toExternalDealerFin(final ExternalDealerFinVO searchVO) {

		ExternalDealerFin dealerSearch = new ExternalDealerFin();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealerIns toExternalDealerIns(final ExternalDealerInsVO searchVO) {

		ExternalDealerIns dealerSearch = new ExternalDealerIns();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}
	// end of external dealer Fin

	// start of Ext Dealer S& M
	// Dealer Vehicle Lead
	public ExtDealerServMaintVO toExternalDealerSvVO(final ExtDealServMaint searchVO) {

		ExtDealerServMaintVO dealerSearch = new ExtDealerServMaintVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExtDealServMaint toExternalDealerSv(final ExtDealerServMaintVO searchVO) {

		ExtDealServMaint dealerSearch = new ExtDealServMaint();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}
	// end of Ext Dealer S& M

	public LoyalityProgAdmin toLoyalityProgram(final LoyalityProgAdminVO searchVO) {

		LoyalityProgAdmin dealerSearch = new LoyalityProgAdmin();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// start of Service and Maintenance
	// Dealer Vehicle Lead
	public ServiceMaintQuotationVO toExtQtSmDealerSearchVO(final ServiceMaintQuotation searchVO) {

		ServiceMaintQuotationVO dealerSearch = new ServiceMaintQuotationVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public TranspServiceQuotationVO toExtQtTpDealerSearchVO(final TranspServiceQuotation searchVO) {

		TranspServiceQuotationVO dealerSearch = new TranspServiceQuotationVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public InsuranceQuotationVO toExtQtInsDealerSearchVO(final InsuranceQuotation searchVO) {

		InsuranceQuotationVO dealerSearch = new InsuranceQuotationVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public FinanceQuotationVO toExtQtFinDealerSearchVO(final FinanceQuotation searchVO) {

		FinanceQuotationVO dealerSearch = new FinanceQuotationVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// end of service and Maintenance
	public ExternalDealerTpVO toExternalDealerTpVO1(final ExternalDealerTp searchVO) {

		ExternalDealerTpVO dealerSearch = new ExternalDealerTpVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealerFinVO toExternalDealerFinVO1(final ExternalDealerFin searchVO) {

		ExternalDealerFinVO dealerSearch = new ExternalDealerFinVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	public ExternalDealerInsVO toExternalDealerInsVO1(final ExternalDealerIns searchVO) {

		ExternalDealerInsVO dealerSearch = new ExternalDealerInsVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// Dealer Vehicle Lead
	public ExtDealerServMaintVO toExternalDealerSmVO(final ExtDealServMaint searchVO) {

		ExtDealerServMaintVO dealerSearch = new ExtDealerServMaintVO();
		try {
			BeanUtils.copyProperties(dealerSearch, searchVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearch;
	}

	// User Finance Lead
	public SearchFinance toSearchFinance(final SearchFinanceVO searchFinanceVO) {
		SearchFinance searchFinance = null;
		if (searchFinanceVO != null) {
			searchFinance = new SearchFinance();
			try {
				BeanUtils.copyProperties(searchFinance, searchFinanceVO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return searchFinance;
	}

	// User Finance Lead
	public SearchFinanceVO toSearchFinance(final SearchFinance searchFinance) {
		SearchFinanceVO searchFinanceVO = null;

		try {
			BeanUtils.copyProperties(searchFinanceVO, searchFinance);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return searchFinanceVO;
	}

	// User Car/Search Details lead
	public SearchFinanceVO toSearchFinance1(final SearchFinance search) {

		SearchFinanceVO searchVO = new SearchFinanceVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public SearchInsuranceVO toSearchInsurance1(final SearchInsurance search) {

		SearchInsuranceVO searchVO = new SearchInsuranceVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public SearchServMaintVO toSearchServMaint1(final SearchServMaint search) {

		SearchServMaintVO searchVO = new SearchServMaintVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public SearchTranspVO toSearchTransp1(final SearchTransp search) {

		SearchTranspVO searchVO = new SearchTranspVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public SearchFinanceVO toSearchFin1(final SearchFinance search) {

		SearchFinanceVO searchVO = new SearchFinanceVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public SearchInsuranceVO toSearchIns1(final SearchInsurance search) {

		SearchInsuranceVO searchVO = new SearchInsuranceVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// User Car/Search Details lead
	public UserNotificationVO toSearchTransp1(final UserNotification search) {

		UserNotificationVO searchVO = new UserNotificationVO();
		try {
			BeanUtils.copyProperties(searchVO, search);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	// Dealer Finance Lead
	public DealerSearchFinance toDealerSearchFinance(final SearchFinanceVO searchFinanceVO) {

		DealerSearchFinance dealerSearchFinance = new DealerSearchFinance();
		try {
			BeanUtils.copyProperties(dealerSearchFinance, searchFinanceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchFinance;
	}

	// Dealer Finance Lead
	public DealerSearchFinance toDealerSearchFinance1(final DealerSearchFinanceVO searchFinanceVO) {

		DealerSearchFinance dealerSearchFinance = new DealerSearchFinance();
		try {
			BeanUtils.copyProperties(dealerSearchFinance, searchFinanceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchFinance;
	}

	public DealerSearchFinanceVO toDealerSearchFinanceVO(final DealerSearchFinance dealerSearchFinance) {

		DealerSearchFinanceVO dealerSearchFinanceVO = new DealerSearchFinanceVO();
		try {
			BeanUtils.copyProperties(dealerSearchFinanceVO, dealerSearchFinance);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchFinanceVO;
	}

	// User Insurance Lead
	public SearchInsurance toSearchInsurance(final SearchInsuranceVO searchInsuranceVO) {
		SearchInsurance searchInsurance = null;
		if (searchInsuranceVO != null) {
			searchInsurance = new SearchInsurance();
			try {
				BeanUtils.copyProperties(searchInsurance, searchInsuranceVO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return searchInsurance;
	}

	// User ServMaint Lead
	public SearchServMaint toSearchServMaint(final SearchServMaintVO searchInsuranceVO) {

		SearchServMaint searchInsurance = new SearchServMaint();
		try {
			BeanUtils.copyProperties(searchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchInsurance;
	}

	// User trans Lead
	public SearchTransp toSearchTrans(final SearchTranspVO searchInsuranceVO) {

		SearchTransp searchInsurance = new SearchTransp();
		try {
			BeanUtils.copyProperties(searchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchInsurance;
	}

	// Dealer Insurance Lead
	public DealerSearchInsurance toDealerSearchInsurance(final SearchInsuranceVO searchInsuranceVO) {

		DealerSearchInsurance dealerSearchInsurance = new DealerSearchInsurance();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}

	// Dealer Insurance Lead
	public DealerSearchInsurance toDealerSearchInsurance1(final DealerSearchInsuranceVO searchInsuranceVO) {

		DealerSearchInsurance dealerSearchInsurance = new DealerSearchInsurance();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}

	// Dealer Insurance Lead
	public DealerSearchInsuranceVO toDealerSearchInsuranceVO(final DealerSearchInsurance dealerSearchInsurance) {

		DealerSearchInsuranceVO dealerSearchInsuranceVO = new DealerSearchInsuranceVO();
		try {
			BeanUtils.copyProperties(dealerSearchInsuranceVO, dealerSearchInsurance);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsuranceVO;
	}

	// Dealer Transp Lead
	public DealerSearchTransp toDealerSearchTransp(final SearchTranspVO searchInsuranceVO) {

		DealerSearchTransp dealerSearchInsurance = new DealerSearchTransp();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}

	// Dealer Transp Lead
	public DealerSearchTransp toDealerSearchTransp1(final DealerSearchTranspVO searchInsuranceVO) {

		DealerSearchTransp dealerSearchInsurance = new DealerSearchTransp();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}
	
	// Dealer Transp Lead
	public DealerSearchTranspVO toDealerSearchTranspVO(final DealerSearchTransp dealerSearchInsurance) {

		DealerSearchTranspVO dealerSearchtransp = new DealerSearchTranspVO();
		try {
			BeanUtils.copyProperties(dealerSearchtransp, dealerSearchInsurance);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchtransp;
	}

	// Dealer ServMaint Lead
	public DealerSearchServMaint toDealerSearchServMaint(final SearchServMaintVO searchInsuranceVO) {

		DealerSearchServMaint dealerSearchInsurance = new DealerSearchServMaint();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}

	// Dealer ServMaint Lead
	public DealerSearchServMaint toDealerSearchServMaint1(final DealerSearchServMaintVO searchInsuranceVO) {

		DealerSearchServMaint dealerSearchInsurance = new DealerSearchServMaint();
		try {
			BeanUtils.copyProperties(dealerSearchInsurance, searchInsuranceVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsurance;
	}

	// Dealer ServMaint Lead
	public DealerSearchServMaintVO toDealerSearchServMaintVO(final DealerSearchServMaint dealerSearchInsurance) {

		DealerSearchServMaintVO dealerSearchInsuranceVO = new DealerSearchServMaintVO();
		try {
			BeanUtils.copyProperties(dealerSearchInsuranceVO, dealerSearchInsurance);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsuranceVO;
	}

	// start of login
	public DealerVO fromLoginDealer(final Dealer dealer, boolean isMinified) {

		if (dealer == null) {
			return null;
		}

		DealerVO dealerVO = new DealerVO();
		dealerVO.setDealerId(dealer.getDealerId());
		dealerVO.setDealername(dealer.getDealername());
		dealerVO.setEmail(dealerVO.getEmail());

		return dealerVO;
	}

	// end of login

	public DealerVO fromDealer(final Dealer dealer, boolean isMinified) {

		if (dealer == null) {
			return null;
		}

		DealerVO dealerVO = new DealerVO();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealer, dealerVO,
					new String[] { "inventory", "dealSearch", "dealSearchInsurance", "dealSearchFinance",
							"dealSearchServMaint", "dealSearchTransp", "vehicleDealerDetails", "vehicleResourcDetails",
							"vehicleDealerFinanceDetails", "vehicleDealerInsuranceDetails",
							"vehicleDealerServMaintDetails", "vehicleDealerMakeList", "vehicleDealerTranspDetails",
							"vehicleDealerAreaOfOperState", "vehicleDealerRegion", "vehicleDealerPostCode" });

			if (!isMinified) {

				List<InventoryVO> inventoryVOs = new ArrayList<>();
				if (dealer.getInventory() != null) {
					for (Inventory inventory : dealer.getInventory()) {
						InventoryVO inventoryVO = new InventoryVO();
						BeanUtils.copyProperties(inventoryVO, inventory);
						inventoryVOs.add(inventoryVO);
					}
					dealerVO.setInventory(inventoryVOs);
				}
				if (dealer.getDealSearch() != null) {
					List<DealerSearchVO> searchVOs = new ArrayList<>();
					for (DealerSearch search : dealer.getDealSearch()) {
						DealerSearchVO searchVO = new DealerSearchVO();
						BeanUtils.copyProperties(searchVO, search);
						searchVOs.add(searchVO);
					}
					dealerVO.setDealSearch(searchVOs);
				}
				if (dealer.getDealSearchInsurance() != null) {
					List<DealerSearchInsuranceVO> searchInsuranceVOs = new ArrayList<>();
					for (DealerSearchInsurance searchInsurance : dealer.getDealSearchInsurance()) {
						DealerSearchInsuranceVO SearchInsuranceVO = new DealerSearchInsuranceVO();
						BeanUtils.copyProperties(SearchInsuranceVO, searchInsurance);
						searchInsuranceVOs.add(SearchInsuranceVO);
					}
					dealerVO.setDealSearchInsurance(searchInsuranceVOs);
				}
				if (dealer.getDealSearchServMaint() != null) {
					List<DealerSearchServMaintVO> dealerSearchServMaintVOs = new ArrayList<>();
					for (DealerSearchServMaint dealerSearchServMaint : dealer.getDealSearchServMaint()) {
						DealerSearchServMaintVO dealerSearchServMaintVO = new DealerSearchServMaintVO();
						BeanUtils.copyProperties(dealerSearchServMaintVO, dealerSearchServMaint);
						dealerSearchServMaintVOs.add(dealerSearchServMaintVO);
					}
					dealerVO.setDealSearchServMaint(dealerSearchServMaintVOs);
				}

				if (dealer.getDealSearchTransp() != null) {
					List<DealerSearchTranspVO> dealerSearchTranspVOs = new ArrayList<>();
					for (DealerSearchTransp dealerSearchServMaint : dealer.getDealSearchTransp()) {
						DealerSearchTranspVO dealerSearchTranspVO = new DealerSearchTranspVO();
						BeanUtils.copyProperties(dealerSearchTranspVO, dealerSearchServMaint);
						dealerSearchTranspVOs.add(dealerSearchTranspVO);
					}
					dealerVO.setDealSearchTransp(dealerSearchTranspVOs);

				}
				if (dealer.getDealSearchFinance() != null) {
					List<DealerSearchFinanceVO> searchFinanceVOs = new ArrayList<>();
					for (DealerSearchFinance searchFinance : dealer.getDealSearchFinance()) {
						DealerSearchFinanceVO searchFinanceVO = new DealerSearchFinanceVO();
						BeanUtils.copyProperties(searchFinanceVO, searchFinance);
						searchFinanceVOs.add(searchFinanceVO);
					}
					dealerVO.setDealSearchFinance(searchFinanceVOs);
				}

				if (dealer.getVehicleDealerDetails() != null) {
					List<VehicleDealerDetailsVO> vehicleDealerDetailsVO = new ArrayList<>();
					for (VehicleDealerDetails vehicleDealerDetail : dealer.getVehicleDealerDetails()) {
						VehicleDealerDetailsVO searchFinanceVO = new VehicleDealerDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
						vehicleDealerDetailsVO.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerDetails(vehicleDealerDetailsVO);
				}

				if (dealer.getVehicleResourceDetails() != null) {
					List<VehicleResourceDetailsVO> vehicleDealerDetailsVO = new ArrayList<>();
					for (VehicleResourceDetails vehicleDealerDetail : dealer.getVehicleResourceDetails()) {
						VehicleResourceDetailsVO searchFinanceVO = new VehicleResourceDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
						vehicleDealerDetailsVO.add(searchFinanceVO);
					}
					dealerVO.setVehicleResourcDetails(vehicleDealerDetailsVO);
				}

				if (dealer.getVehicleDealerTranspDetails() != null) {
					List<VehicleDealerTranspDetailsVO> vehicleDealerTranspDetailsVO = new ArrayList<>();
					for (VehicleDealerTranspDetails VehicleDealerTranspDetails : dealer
							.getVehicleDealerTranspDetails()) {
						VehicleDealerTranspDetailsVO searchFinanceVO = new VehicleDealerTranspDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerTranspDetails);
						vehicleDealerTranspDetailsVO.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerTranspDetails(vehicleDealerTranspDetailsVO);
				}

				if (dealer.getVehicleDealerTranspDetails() != null) {
					List<VehicleDealerTranspDetailsVO> VehicleDealerTranspDetailsVO = new ArrayList<>();
					for (VehicleDealerTranspDetails VehicleDealerTranspDetails : dealer
							.getVehicleDealerTranspDetails()) {
						VehicleDealerTranspDetailsVO searchFinanceVO = new VehicleDealerTranspDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerTranspDetails);
						VehicleDealerTranspDetailsVO.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerTranspDetails(VehicleDealerTranspDetailsVO);
				}

				if (dealer.getVehicleDealerFinanceDetails() != null) {
					List<VehicleDealerFinanceDetailsVO> VehicleDealerFinanceDetailsVO = new ArrayList<>();
					for (VehicleDealerFinanceDetails VehicleDealerFinanceDetails : dealer
							.getVehicleDealerFinanceDetails()) {
						VehicleDealerFinanceDetailsVO searchFinanceVO = new VehicleDealerFinanceDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerFinanceDetails);
						VehicleDealerFinanceDetailsVO.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerFinanceDetails(VehicleDealerFinanceDetailsVO);
				}

				if (dealer.getVehicleDealerInsuranceDetails() != null) {
					List<VehicleDealerInsuranceDetailsVO> VehicleDealerInsuranceDetailsVOs = new ArrayList<>();
					for (VehicleDealerInsuranceDetails VehicleDealerInsuranceDetails : dealer
							.getVehicleDealerInsuranceDetails()) {
						VehicleDealerInsuranceDetailsVO searchFinanceVO = new VehicleDealerInsuranceDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
						VehicleDealerInsuranceDetailsVOs.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerInsuranceDetails(VehicleDealerInsuranceDetailsVOs);
				}

				if (dealer.getVehicleDealerServMaintDetails() != null) {
					List<VehicleDealerServMaintDetailsVO> vehicleDealerServMaintDetailsVOs = new ArrayList<>();
					for (VehicleDealerServMaintDetails VehicleDealerInsuranceDetails : dealer
							.getVehicleDealerServMaintDetails()) {
						VehicleDealerServMaintDetailsVO searchFinanceVO = new VehicleDealerServMaintDetailsVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
						vehicleDealerServMaintDetailsVOs.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerServMaintDetails(vehicleDealerServMaintDetailsVOs);
				}

				if (dealer.getVehicleDealerMakeList() != null) {
					List<VehicleDealerMakeListhVO> vehicleDealerMakeListVOs = new ArrayList<>();
					for (VehicleDealerMakeList VehicleDealerInsuranceDetails : dealer.getVehicleDealerMakeList()) {
						VehicleDealerMakeListhVO searchFinanceVO = new VehicleDealerMakeListhVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
						vehicleDealerMakeListVOs.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerMakeList(vehicleDealerMakeListVOs);
				}
				if (dealer.getVehicleDealerAreaOfOperState() != null) {
					List<VehicleDealerAreaOfOperStateVO> vehicleDealerAreaOfOperStateVOs = new ArrayList<>();
					for (VehicleDealerAreaOfOperState VehicleDealerInsuranceDetails : dealer
							.getVehicleDealerAreaOfOperState()) {
						VehicleDealerAreaOfOperStateVO searchFinanceVO = new VehicleDealerAreaOfOperStateVO();
						BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
						vehicleDealerAreaOfOperStateVOs.add(searchFinanceVO);
					}
					dealerVO.setVehicleDealerAreaOfOperState(vehicleDealerAreaOfOperStateVOs);
				}
				if (dealer.getVehicleDealerRegion() != null) {
					List<VehicleDealerAreaOfOperRegionVO> vehicleDealerAreaOfOperRegionVOs = new ArrayList<>();
					for (VehicleDealerAreaOfOperRegion vehicleDealerAreaOfOperRegion : dealer
							.getVehicleDealerRegion()) {
						VehicleDealerAreaOfOperRegionVO vehicleDealerAreaOfOperRegionVO = new VehicleDealerAreaOfOperRegionVO();
						BeanUtils.copyProperties(vehicleDealerAreaOfOperRegionVO, vehicleDealerAreaOfOperRegion);
						vehicleDealerAreaOfOperRegionVOs.add(vehicleDealerAreaOfOperRegionVO);
					}
					dealerVO.setVehicleDealerRegion(vehicleDealerAreaOfOperRegionVOs);

				}

				if (dealer.getVehicleDealerPostCode() != null) {
					List<VehicleDealerAreaOfOperPostCodeVO> vehicleDealerAreaOfOperPostCodeVOs = new ArrayList<>();
					for (VehicleDealerAreaOfOperPostCode vehicleDealerAreaOfOperPostCode : dealer
							.getVehicleDealerPostCode()) {
						VehicleDealerAreaOfOperPostCodeVO vehicleDealerAreaOfOperPostCodeVO = new VehicleDealerAreaOfOperPostCodeVO();
						BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCodeVO, vehicleDealerAreaOfOperPostCode);
						vehicleDealerAreaOfOperPostCodeVOs.add(vehicleDealerAreaOfOperPostCodeVO);
					}
					dealerVO.setVehicleDealerPostCode(vehicleDealerAreaOfOperPostCodeVOs);
				}
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dealerVO;
	}

	/*
	 * // start of inventory public InventoryVO fromDealerInv(final Inventory
	 * dealer) {
	 * 
	 * if (dealer == null) { return null; }
	 * 
	 * InventoryVO dealerVO = new InventoryVO(); try {
	 * 
	 * BeanUtils.copyProperties(dealerVO, dealer);
	 * 
	 * 
	 * } catch (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (InvocationTargetException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return dealerVO; } // end of inventory
	 */
	public DealerSearchVO fromDealerSearch(final DealerSearch dealerSearch) {
		DealerSearchVO searchVO = new DealerSearchVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public VehicleResourceDetailsVO fromDealerResource(final VehicleResourceDetails dealerSearch) {
		VehicleResourceDetailsVO searchVO = new VehicleResourceDetailsVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public UserQuotationHistoryVO fromUserChatVO(final UserQuotationHistory dealerSearch) {
		UserQuotationHistoryVO searchVO = new UserQuotationHistoryVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public DealerSearch toDealerSearchAdmin(final DealerSearchAdminVO dealerSearch) {
		DealerSearch searchVO = new DealerSearch();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public UserNotificationVO fromUserNotif(final UserNotification dealerSearch) {
		UserNotificationVO searchVO = new UserNotificationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public MyVehicleVO fromMyVehicleById(final MyVehicle dealerSearch) {
		MyVehicleVO searchVO = new MyVehicleVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	
	public FinanceQuotationVO fromFinanQuota(final FinanceQuotation dealerSearch) {
		FinanceQuotationVO searchVO = new FinanceQuotationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public InsuranceQuotationVO fromInsQuota(final InsuranceQuotation dealerSearch) {
		InsuranceQuotationVO searchVO = new InsuranceQuotationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public ServiceMaintQuotationVO fromServQuota(final ServiceMaintQuotation dealerSearch) {
		ServiceMaintQuotationVO searchVO = new ServiceMaintQuotationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public TranspServiceQuotationVO fromTranpQuota(final TranspServiceQuotation dealerSearch) {
		TranspServiceQuotationVO searchVO = new TranspServiceQuotationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	
	public VehicleQuotationVO fromVehiQuota(final VehicleQuotation dealerSearch) {
		VehicleQuotationVO searchVO = new VehicleQuotationVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	
	public CurrentOffersVO fromCurrentOfferId(final CurrentOffers dealerSearch) {
		CurrentOffersVO searchVO = new CurrentOffersVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public SearchFinanceVO fromSearchFinance(final SearchFinance dealerSearch) {
		SearchFinanceVO searchVO = new SearchFinanceVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public SearchInsuranceVO fromSearchInsurance(final SearchInsurance dealerSearch) {
		SearchInsuranceVO searchVO = new SearchInsuranceVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public SearchServMaintVO fromSearchServMaint(final SearchServMaint dealerSearch) {
		SearchServMaintVO searchVO = new SearchServMaintVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public SearchTranspVO fromSearchTranp(final SearchTransp dealerSearch) {
		SearchTranspVO searchVO = new SearchTranspVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public SearchVO fromSearch(final Search dealerSearch) {
		SearchVO searchVO = new SearchVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}
	
	public ExtDealerSearch toExtDealerSearchAdmin(final ExtDealerSearchVO dealerSearch) {
		ExtDealerSearch searchVO = new ExtDealerSearch();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public ExtDealServMaintr1 toExtDealerSvAdmin(final ExtDealServMaintr1VO dealerSearch) {
		ExtDealServMaintr1 searchVO = new ExtDealServMaintr1();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public ExtDealerSearchTp toExtDealerTpAdmin(final ExtDealerSearchTpVO dealerSearch) {
		ExtDealerSearchTp searchVO = new ExtDealerSearchTp();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public ExtDealerSearchIns toExtDealerInsAdmin(final ExtDealerSearchInsVO dealerSearch) {
		ExtDealerSearchIns searchVO = new ExtDealerSearchIns();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public ExtDealerSearchFin toExtDealerFinAdmin(final ExtDealerSearchFinVO dealerSearch) {
		ExtDealerSearchFin searchVO = new ExtDealerSearchFin();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public DealerVO toDealerAdmin(final Dealer dealerSearch) {
		DealerVO searchVO = new DealerVO();
		try {
			BeanUtils.copyProperties(searchVO, dealerSearch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchVO;
	}

	public DealerSearchInsuranceVO fromDealerSearchInsurance(final DealerSearchInsurance dealerSearchInsurance) {
		DealerSearchInsuranceVO dealerSearchInsuranceVO = new DealerSearchInsuranceVO();
		try {
			BeanUtils.copyProperties(dealerSearchInsuranceVO, dealerSearchInsurance);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchInsuranceVO;
	}

	public DealerSearchFinanceVO fromDealerSearchFinance(final DealerSearchFinance dealerSearchFinance) {
		DealerSearchFinanceVO dealerSearchFinanceVO = new DealerSearchFinanceVO();
		try {
			BeanUtils.copyProperties(dealerSearchFinanceVO, dealerSearchFinance);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerSearchFinanceVO;
	}

	// start login dealer
	public Dealer toLoginDealer(final DealerLoginVO dealerVO) {
		Dealer dealer = new Dealer();

		dealer.setEmail(dealerVO.getEmail());
		dealer.setPassword(dealerVO.getPassword());
		dealer.setDealername(dealerVO.getFirstName() + dealerVO.getLastName());

		return dealer;
	}
	// end login dealer

	// start of Tranp Master
	public VehicleDealerTranspDetails toDealerTranspvMast(final VehicleDealerTranspDetailsVO dealerVO) {
		VehicleDealerTranspDetails dealer = new VehicleDealerTranspDetails();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
					new String[] { "vehicleDealerTranpHypList","vehicleResourceDetails" });

			if (dealerVO.getVehicleDealerTranpHypList() != null) {
				List<VehicleTranpHypList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleTranpHypListVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerTranpHypList()) {
					VehicleTranpHypList vehicleDealerMakeList = new VehicleTranpHypList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleDealerTranpHypList(vehicleDealerMakeLists);
			}
			if (dealerVO.getVehicleResourceDetails() != null) {
				List<VehicleResourceDetailsTransp> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleResourceDetailsTranspVO vehicleDealerMakeListVO : dealerVO.getVehicleResourceDetails()) {
					VehicleResourceDetailsTransp vehicleDealerMakeList = new VehicleResourceDetailsTransp();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleResourceDetails(vehicleDealerMakeLists);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}
	// end of transp Master

	// start of Fin Master
	public FinanceEntity toDealerFinMast(final FinanceEntityVO dealerVO) {

		FinanceEntity financeQuotation = new FinanceEntity();
		try {
			BeanUtils.copyProperties(financeQuotation, dealerVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return financeQuotation;
	}
	// end of fin Master

	// start of Fin Master
	public FinanceEntityVO toDealerFinVOMast(final FinanceEntity dealer) {

		FinanceEntityVO financeQuotationVO = new FinanceEntityVO();
		try {
			BeanUtils.copyProperties(financeQuotationVO, dealer);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return financeQuotationVO;
	}
	// end of fin Master

	// start of Ins Master
public VehicleDealerInsuranceDetailsVO toDealerInsVOMast(final VehicleDealerInsuranceDetails dealer) {
							
							
							
	VehicleDealerInsuranceDetailsVO financeQuotationVO = new VehicleDealerInsuranceDetailsVO();
								try {
									BeanUtils.copyProperties(financeQuotationVO, dealer);
								} catch (IllegalAccessException | InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							
							return financeQuotationVO;
	}
						// end of Ins Master				
	
	// start of Serv Master
	public VehicleDealerServMaintDetails toDealerServMast(final VehicleDealerServMaintDetailsVO dealerVO) {
		VehicleDealerServMaintDetails dealer = new VehicleDealerServMaintDetails();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
					new String[] { "vehicleDealerServSpareList", "vehicleDealerServHypList", "vehicleResourceDetails" });

			if (dealerVO.getVehicleDealerServSpareList() != null) {
				List<VehicleServSpareList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleServSpareListVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerServSpareList()) {
					VehicleServSpareList vehicleDealerMakeList = new VehicleServSpareList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleDealerServSpareList(vehicleDealerMakeLists);
			}
			if (dealerVO.getVehicleDealerServHypList() != null) {
				List<VehicleServHypList> vehicleDealerAreaOfOperStates = new ArrayList<>();
				for (VehicleServHypListVO vehicleDealerAreaOfOperStateVO : dealerVO.getVehicleDealerServHypList()) {
					VehicleServHypList vehicleDealerAreaOfOperState = new VehicleServHypList();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperState, vehicleDealerAreaOfOperStateVO);
					vehicleDealerAreaOfOperStates.add(vehicleDealerAreaOfOperState);
				}
				dealer.setVehicleDealerServHypList(vehicleDealerAreaOfOperStates);
			}
			if (dealerVO.getVehicleResourceDetails() != null) {
				List<VehicleResourceDetailsServ> vehicleDealerAreaOfOperStates = new ArrayList<>();
				for (VehicleResourceDetailsServVO vehicleDealerAreaOfOperStateVO : dealerVO.getVehicleResourceDetails()) {
					VehicleResourceDetailsServ vehicleDealerAreaOfOperState = new VehicleResourceDetailsServ();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperState, vehicleDealerAreaOfOperStateVO);
					vehicleDealerAreaOfOperStates.add(vehicleDealerAreaOfOperState);
				}
				dealer.setVehicleResourceDetails(vehicleDealerAreaOfOperStates);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}
	// end of service Master
	// start of ins Master
				public VehicleDealerInsuranceDetails toDealerInsMast(final VehicleDealerInsuranceDetailsVO dealerVO) {
					VehicleDealerInsuranceDetails dealer = new VehicleDealerInsuranceDetails();
					try {


						org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
								new String[] { "vehicleDealerInsInsDetails"});
						
						if( dealerVO.getVehicleDealerInsInsDetails() != null){
						List<VehicleDealerInsInsDetails> vehicleDealerMakeLists = new ArrayList<>();
						for (VehicleDealerInsInsDetailsVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerInsInsDetails()) {
							VehicleDealerInsInsDetails vehicleDealerMakeList = new VehicleDealerInsInsDetails();
							BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
							vehicleDealerMakeLists.add(vehicleDealerMakeList);
						}
						dealer.setVehicleDealerInsInsDetails(vehicleDealerMakeLists);
						}
						
						
					
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return dealer;
				}
				// end of ins Master
	
	// start of SBL
	public VehicleDealerDetails toDealerSBL(final VehicleDealerDetailsVO dealerVO) {
		VehicleDealerDetails dealer = new VehicleDealerDetails();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
					new String[] { "vehicleDealerMakeList", "vehicleDealerAreaOfOperState", "vehicleDealerRegion",
							"vehicleDealerPostCode", "vehicleDealerInsDetails" });

			if (dealerVO.getVehicleDealerMakeList() != null) {
				List<VehicleMakeList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleMakeListVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerMakeList()) {
					VehicleMakeList vehicleDealerMakeList = new VehicleMakeList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleDealerMakeList(vehicleDealerMakeLists);
			}
			if (dealerVO.getVehicleDealerAreaOfOperState() != null) {
				List<VehicleAreaOfOperState> vehicleDealerAreaOfOperStates = new ArrayList<>();
				for (VehicleAreaOfOperStateVO vehicleDealerAreaOfOperStateVO : dealerVO
						.getVehicleDealerAreaOfOperState()) {
					VehicleAreaOfOperState vehicleDealerAreaOfOperState = new VehicleAreaOfOperState();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperState, vehicleDealerAreaOfOperStateVO);
					vehicleDealerAreaOfOperStates.add(vehicleDealerAreaOfOperState);
				}
				dealer.setVehicleDealerAreaOfOperState(vehicleDealerAreaOfOperStates);
			}

			if (dealerVO.getVehicleDealerRegion() != null) {
				List<VehicleAreaOfOperRegion> vehicleDealerAreaOfOperRegions = new ArrayList<>();
				for (VehicleAreaOfOperRegionVO vehicleDealerAreaOfOperRegionVO : dealerVO.getVehicleDealerRegion()) {
					VehicleAreaOfOperRegion vehicleDealerAreaOfOperRegion = new VehicleAreaOfOperRegion();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperRegion, vehicleDealerAreaOfOperRegionVO);
					vehicleDealerAreaOfOperRegions.add(vehicleDealerAreaOfOperRegion);
				}
				dealer.setVehicleDealerRegion(vehicleDealerAreaOfOperRegions);
			}

			if (dealerVO.getVehicleDealerPostCode() != null) {
				List<VehicleAreaOfOperPostCode> vehicleDealerAreaOfOperPostCodes = new ArrayList<>();
				for (VehicleAreaOfOperPostCodeVO vehicleDealerAreaOfOperPostCodeVO : dealerVO
						.getVehicleDealerPostCode()) {
					VehicleAreaOfOperPostCode vehicleDealerAreaOfOperPostCode = new VehicleAreaOfOperPostCode();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCode, vehicleDealerAreaOfOperPostCodeVO);
					vehicleDealerAreaOfOperPostCodes.add(vehicleDealerAreaOfOperPostCode);
				}
				dealer.setVehicleDealerPostCode(vehicleDealerAreaOfOperPostCodes);
			}

			if (dealerVO.getVehicleDealerInsDetails() != null) {
				List<VehicleDealerInsDetails> vehicleDealerAreaOfOperPostCodes = new ArrayList<>();
				for (VehicleDealerInsDetailsVO vehicleDealerAreaOfOperPostCodeVO : dealerVO
						.getVehicleDealerInsDetails()) {
					VehicleDealerInsDetails vehicleDealerAreaOfOperPostCode = new VehicleDealerInsDetails();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCode, vehicleDealerAreaOfOperPostCodeVO);
					vehicleDealerAreaOfOperPostCodes.add(vehicleDealerAreaOfOperPostCode);
				}
				dealer.setVehicleDealerInsDetails(vehicleDealerAreaOfOperPostCodes);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}
	// end of SBL

	// start of Resource
	public VehicleResourceDetails toDealerResource(final VehicleResourceDetailsVO dealerVO) {
		VehicleResourceDetails dealer = new VehicleResourceDetails();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer, new String[] { "vehicleSocialList" });

			if (dealerVO.getVehicleSocialList() != null) {
				List<VehicleSocialList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleSocialListVO vehicleDealerMakeListVO : dealerVO.getVehicleSocialList()) {
					VehicleSocialList vehicleDealerMakeList = new VehicleSocialList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleSocialList(vehicleDealerMakeLists);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}
	// end of Resource
	
	// start of user
		public UserQuotationHistory toUserChat(final UserQuotationHistoryVO dealerVO) {
			UserQuotationHistory dealer = new UserQuotationHistory();
				try {
					BeanUtils.copyProperties(dealer, dealerVO);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return dealer;
		}
		// end of Resource
		
		
		// start serv slot
				public UserQuotaReqBookSlotServ toServSlot(final UserQuotaReqBookSlotServVO dealerVO) {
					UserQuotaReqBookSlotServ dealer = new UserQuotaReqBookSlotServ();
						try {
							BeanUtils.copyProperties(dealer, dealerVO);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					return dealer;
				}
				// end of serv slot
				
				// start tranp slot
				public UserQuotaReqBookSlotTranp toTrnspSlot(final UserQuotaReqBookSlotTranpVO dealerVO) {
					UserQuotaReqBookSlotTranp dealer = new UserQuotaReqBookSlotTranp();
						try {
							BeanUtils.copyProperties(dealer, dealerVO);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					return dealer;
				}
				// end of transp slot
		
		// start of user
				public UserQuotaReqTestDrive toUserQuota(final UserQuotaReqTestDriveVO dealerVO) {
					UserQuotaReqTestDrive dealer = new UserQuotaReqTestDrive();
						try {
							BeanUtils.copyProperties(dealer, dealerVO);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					return dealer;
				}
				// end of Resource

				
				// start of quota doc
				public UserQuotaDocs toQuotaDoc(final UserQuotaDocVO dealerVO) {
					UserQuotaDocs dealer = new UserQuotaDocs();
						try {
							BeanUtils.copyProperties(dealer, dealerVO);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					return dealer;
				}
				// end of quota doc
	// start of ResourceVO
	public VehicleResourceDetailsVO toDealerResourceVO(final VehicleResourceDetails dealer) {
		VehicleResourceDetailsVO dealerVO = new VehicleResourceDetailsVO();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer, new String[] { "vehicleSocialList" });

			if (dealerVO.getVehicleSocialList() != null) {
				List<VehicleSocialList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleSocialListVO vehicleDealerMakeListVO : dealerVO.getVehicleSocialList()) {
					VehicleSocialList vehicleDealerMakeList = new VehicleSocialList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleSocialList(vehicleDealerMakeLists);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealerVO;
	}
	// end of ResourceVO

	public Dealer toDealer(final DealerVO dealerVO) {
		Dealer dealer = new Dealer();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
					new String[] { "inventory", "dealSearch", "dealSearchInsurance", "dealSearchFinance",
							"dealSearchServMaint", "dealSearchTransp", "vehicleDealerDetails", "vehicleResourceDetails",
							"vehicleDealerFinanceDetails", "vehicleDealerInsuranceDetails",
							"vehicleDealerServMaintDetails", "vehicleDealerMakeList", "vehicleDealerTranspDetails",
							"vehicleDealerAreaOfOperState", "vehicleDealerRegion", "vehicleDealerPostCode" });
			List<Inventory> inventorys = new ArrayList<>();
			if (dealerVO.getInventory() != null) {
				for (InventoryVO inventoryVO : dealerVO.getInventory()) {
					Inventory inventory = new Inventory();
					BeanUtils.copyProperties(inventory, inventoryVO);
					inventorys.add(inventory);
				}
				dealer.setInventory(inventorys);
			}
			if (dealerVO.getDealSearch() != null) {
				List<DealerSearch> searchs = new ArrayList<>();
				for (DealerSearchVO searchVO : dealerVO.getDealSearch()) {
					DealerSearch search = new DealerSearch();
					BeanUtils.copyProperties(search, searchVO);
					searchs.add(search);
				}
				dealer.setDealSearch(searchs);
			}
			if (dealerVO.getDealSearchInsurance() != null) {
				List<DealerSearchInsurance> searchInsurances = new ArrayList<>();
				for (DealerSearchInsuranceVO searchInsuranceVO : dealerVO.getDealSearchInsurance()) {
					DealerSearchInsurance searchInsurance = new DealerSearchInsurance();
					BeanUtils.copyProperties(searchInsurance, searchInsuranceVO);
					searchInsurances.add(searchInsurance);
				}
				dealer.setDealSearchInsurance(searchInsurances);
			}
			if (dealerVO.getDealSearchFinance() != null) {
				List<DealerSearchFinance> searchFinances = new ArrayList<>();
				for (DealerSearchFinanceVO searchFinanceVO : dealerVO.getDealSearchFinance()) {
					DealerSearchFinance searchFinance = new DealerSearchFinance();
					BeanUtils.copyProperties(searchFinance, searchFinanceVO);
					searchFinances.add(searchFinance);
				}
				dealer.setDealSearchFinance(searchFinances);
			}
			if (dealerVO.getVehicleDealerDetails() != null) {
				List<VehicleDealerDetails> vehicleDealerDetails = new ArrayList<>();

				for (VehicleDealerDetailsVO vehicleDealerDetailVO : dealerVO.getVehicleDealerDetails()) {
					VehicleDealerDetails vehicleDealerDetail = new VehicleDealerDetails();
					BeanUtils.copyProperties(vehicleDealerDetail, vehicleDealerDetailVO);
					vehicleDealerDetails.add(vehicleDealerDetail);
				}
				dealer.setVehicleDealerDetails(vehicleDealerDetails);
			}

			if (dealerVO.getVehicleResourcDetails() != null) {
				List<VehicleResourceDetails> vehicleDealerDetails = new ArrayList<>();

				for (VehicleResourceDetailsVO vehicleDealerDetailVO : dealerVO.getVehicleResourcDetails()) {
					VehicleResourceDetails vehicleDealerDetail = new VehicleResourceDetails();
					BeanUtils.copyProperties(vehicleDealerDetail, vehicleDealerDetailVO);
					vehicleDealerDetails.add(vehicleDealerDetail);
				}
				dealer.setVehicleResourceDetails(vehicleDealerDetails);
			}

			if (dealerVO.getVehicleDealerTranspDetails() != null) {
				List<VehicleDealerTranspDetails> vehicleDealerTranspDetails = new ArrayList<>();
				for (VehicleDealerTranspDetailsVO vehicleDealerTranspDetailVO : dealerVO
						.getVehicleDealerTranspDetails()) {
					VehicleDealerTranspDetails vehicleDealerFinanceDetail = new VehicleDealerTranspDetails();
					BeanUtils.copyProperties(vehicleDealerFinanceDetail, vehicleDealerTranspDetailVO);
					vehicleDealerTranspDetails.add(vehicleDealerFinanceDetail);
				}
				dealer.setVehicleDealerTranspDetails(vehicleDealerTranspDetails);
			}

			if (dealerVO.getVehicleDealerFinanceDetails() != null) {
				List<VehicleDealerFinanceDetails> vehicleDealerFinanceDetails = new ArrayList<>();
				for (VehicleDealerFinanceDetailsVO vehicleDealerFinanceDetailVO : dealerVO
						.getVehicleDealerFinanceDetails()) {
					VehicleDealerFinanceDetails vehicleDealerFinanceDetail = new VehicleDealerFinanceDetails();
					BeanUtils.copyProperties(vehicleDealerFinanceDetail, vehicleDealerFinanceDetailVO);
					vehicleDealerFinanceDetails.add(vehicleDealerFinanceDetail);
				}
				dealer.setVehicleDealerFinanceDetails(vehicleDealerFinanceDetails);
			}
			if (dealerVO.getVehicleDealerInsuranceDetails() != null) {
				List<VehicleDealerInsuranceDetails> vehicleDealerInsuranceDetails = new ArrayList<>();
				for (VehicleDealerInsuranceDetailsVO vehicleDealerInsuranceDetailVO : dealerVO
						.getVehicleDealerInsuranceDetails()) {
					VehicleDealerInsuranceDetails vehicleDealerInsuranceDetail = new VehicleDealerInsuranceDetails();
					BeanUtils.copyProperties(vehicleDealerInsuranceDetail, vehicleDealerInsuranceDetailVO);
					vehicleDealerInsuranceDetails.add(vehicleDealerInsuranceDetail);
				}
				dealer.setVehicleDealerInsuranceDetails(vehicleDealerInsuranceDetails);
			}
			if (dealerVO.getVehicleDealerServMaintDetails() != null) {
				List<VehicleDealerServMaintDetails> vehicleDealerServMaintDetails = new ArrayList<>();
				for (VehicleDealerServMaintDetailsVO vehicleDealerServMaintDetailVO : dealerVO
						.getVehicleDealerServMaintDetails()) {
					VehicleDealerServMaintDetails vehicleDealerServMaintDetail = new VehicleDealerServMaintDetails();
					BeanUtils.copyProperties(vehicleDealerServMaintDetail, vehicleDealerServMaintDetailVO);
					vehicleDealerServMaintDetails.add(vehicleDealerServMaintDetail);
				}
				dealer.setVehicleDealerServMaintDetails(vehicleDealerServMaintDetails);
			}

			if (dealerVO.getDealSearchServMaint() != null) {
				List<DealerSearchServMaint> dealerSearchServMaints = new ArrayList<>();
				for (DealerSearchServMaintVO dealerSearchServMaintVO : dealerVO.getDealSearchServMaint()) {
					DealerSearchServMaint dealerSearchServMaint = new DealerSearchServMaint();
					BeanUtils.copyProperties(dealerSearchServMaint, dealerSearchServMaintVO);
					dealerSearchServMaints.add(dealerSearchServMaint);
				}
				dealer.setDealSearchServMaint(dealerSearchServMaints);
			}

			if (dealerVO.getDealSearchTransp() != null) {
				List<DealerSearchTransp> dealerSearchTransps = new ArrayList<>();
				for (DealerSearchTranspVO dealerSearchTranspVO : dealerVO.getDealSearchTransp()) {
					DealerSearchTransp dealerSearchTransp = new DealerSearchTransp();
					BeanUtils.copyProperties(dealerSearchTransp, dealerSearchTranspVO);
					dealerSearchTransps.add(dealerSearchTransp);
				}
				dealer.setDealSearchTransp(dealerSearchTransps);

			}

			if (dealerVO.getVehicleDealerMakeList() != null) {
				List<VehicleDealerMakeList> vehicleDealerMakeLists = new ArrayList<>();
				for (VehicleDealerMakeListhVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerMakeList()) {
					VehicleDealerMakeList vehicleDealerMakeList = new VehicleDealerMakeList();
					BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
					vehicleDealerMakeLists.add(vehicleDealerMakeList);
				}
				dealer.setVehicleDealerMakeList(vehicleDealerMakeLists);
			}
			if (dealerVO.getVehicleDealerAreaOfOperState() != null) {
				List<VehicleDealerAreaOfOperState> vehicleDealerAreaOfOperStates = new ArrayList<>();
				for (VehicleDealerAreaOfOperStateVO vehicleDealerAreaOfOperStateVO : dealerVO
						.getVehicleDealerAreaOfOperState()) {
					VehicleDealerAreaOfOperState vehicleDealerAreaOfOperState = new VehicleDealerAreaOfOperState();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperState, vehicleDealerAreaOfOperStateVO);
					vehicleDealerAreaOfOperStates.add(vehicleDealerAreaOfOperState);
				}
				dealer.setVehicleDealerAreaOfOperState(vehicleDealerAreaOfOperStates);
			}

			if (dealerVO.getVehicleDealerRegion() != null) {
				List<VehicleDealerAreaOfOperRegion> vehicleDealerAreaOfOperRegions = new ArrayList<>();
				for (VehicleDealerAreaOfOperRegionVO vehicleDealerAreaOfOperRegionVO : dealerVO
						.getVehicleDealerRegion()) {
					VehicleDealerAreaOfOperRegion vehicleDealerAreaOfOperRegion = new VehicleDealerAreaOfOperRegion();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperRegion, vehicleDealerAreaOfOperRegionVO);
					vehicleDealerAreaOfOperRegions.add(vehicleDealerAreaOfOperRegion);
				}
				dealer.setVehicleDealerRegion(vehicleDealerAreaOfOperRegions);
			}

			if (dealerVO.getVehicleDealerPostCode() != null) {
				List<VehicleDealerAreaOfOperPostCode> vehicleDealerAreaOfOperPostCodes = new ArrayList<>();
				for (VehicleDealerAreaOfOperPostCodeVO vehicleDealerAreaOfOperPostCodeVO : dealerVO
						.getVehicleDealerPostCode()) {
					VehicleDealerAreaOfOperPostCode vehicleDealerAreaOfOperPostCode = new VehicleDealerAreaOfOperPostCode();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCode, vehicleDealerAreaOfOperPostCodeVO);
					vehicleDealerAreaOfOperPostCodes.add(vehicleDealerAreaOfOperPostCode);
				}
				dealer.setVehicleDealerPostCode(vehicleDealerAreaOfOperPostCodes);
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}

	public TempCarModelHeaderVO fromTempCarModelTemplate(final TempCarModelHeader carModelTemplate,
			boolean isMinified) {
		if (carModelTemplate == null) {
			return null;
		}

		TempCarModelHeaderVO carModelTemplateVO = new TempCarModelHeaderVO();

		try {

			if (isMinified) {
				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "TempCarModelPricing", "TempCarModelPricing", "TempCarModelOptionalFeatureAddOn",
								"TempCarModelColour", "TempCarModelFullSpecEngine", "TempCarModelFullSpecDimension",
								"TempCarModelFullSpecFuel", "TempCarModelFullSpecWarranty",
								"TempCarModelFullSpecStandEq", "TempCarModelOptEqpAddOn", "TempCarModelRelatedModel",
								"TempCarModelVehReview", "TempCarModelVideos", "TempCarModelExtFitting",
								"TempCarModelIntFitting", "TempCarModelUserRating", "TempCarModelExpertRating",
								"TempCarModelCountry", "TempCarModelFullSpecWheel" });
			} else {

				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "TempCarModelPricing", "TempCarModelPricing", "TempCarModelOptionalFeatureAddOn",
								"TempCarModelColour", "TempCarModelFullSpecEngine", "TempCarModelFullSpecDimension",
								"TempCarModelFullSpecFuel", "TempCarModelFullSpecWarranty",
								"TempCarModelFullSpecStandEq", "TempCarModelOptEqpAddOn", "TempCarModelRelatedModel",
								"TempCarModelVehReview", "TempCarModelVideos", "TempCarModelExtFitting",
								"TempCarModelIntFitting", "TempCarModelUserRating", "TempCarModelExpertRating",
								"TempCarModelCountry", "TempCarModelFullSpecWheel" });

				if (carModelTemplate.getCarModel() != null) {
					List<TempCarModelOverviewVO> blogTemplates = new ArrayList<>();
					for (TempCarModelOverview blogTemplate : carModelTemplate.getCarModel()) {
						TempCarModelOverviewVO blogTemplateVO = new TempCarModelOverviewVO();
						BeanUtils.copyProperties(blogTemplateVO, blogTemplate);
						blogTemplates.add(blogTemplateVO);
					}
					carModelTemplateVO.setCarModel(blogTemplates);
				}

				if (carModelTemplate.getCarModel1() != null) {
					List<TempCarModelPricingVO> countryTemplates = new ArrayList<>();
					for (TempCarModelPricing countryTemplate : carModelTemplate.getCarModel1()) {
						TempCarModelPricingVO countryTemplateVO = new TempCarModelPricingVO();
						BeanUtils.copyProperties(countryTemplateVO, countryTemplate);
						countryTemplates.add(countryTemplateVO);
					}
					carModelTemplateVO.setCarModel1(countryTemplates);
				}

				if (carModelTemplate.getCarModel2() != null) {
					List<TempCarModelOptionalFeatureAddOnVO> photosTemplates = new ArrayList<>();
					for (TempCarModelOptionalFeatureAddOn photosTemplate : carModelTemplate.getCarModel2()) {
						TempCarModelOptionalFeatureAddOnVO photosTemplateVO = new TempCarModelOptionalFeatureAddOnVO();
						BeanUtils.copyProperties(photosTemplateVO, photosTemplate);
						photosTemplates.add(photosTemplateVO);
					}
					carModelTemplateVO.setCarModel2(photosTemplates);
				}

				if (carModelTemplate.getCarModel3() != null) {
					List<TempCarModelColourVO> userReviewTemplates = new ArrayList<>();
					for (TempCarModelColour userReviewTemplate : carModelTemplate.getCarModel3()) {
						TempCarModelColourVO userReviewTemplateVO = new TempCarModelColourVO();
						BeanUtils.copyProperties(userReviewTemplateVO, userReviewTemplate);
						userReviewTemplates.add(userReviewTemplateVO);
					}
					carModelTemplateVO.setCarModel3(userReviewTemplates);
				}

				if (carModelTemplate.getCarModel4() != null) {
					List<TempCarModelFullSpecEngineVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecEngine youtubeTemplate : carModelTemplate.getCarModel4()) {
						TempCarModelFullSpecEngineVO youtubeTemplateVO = new TempCarModelFullSpecEngineVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel4(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel5() != null) {
					List<TempCarModelFullSpecDimensionVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecDimension youtubeTemplate : carModelTemplate.getCarModel5()) {
						TempCarModelFullSpecDimensionVO youtubeTemplateVO = new TempCarModelFullSpecDimensionVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel5(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel6() != null) {
					List<TempCarModelFullSpecFuelVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecFuel youtubeTemplate : carModelTemplate.getCarModel6()) {
						TempCarModelFullSpecFuelVO youtubeTemplateVO = new TempCarModelFullSpecFuelVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel6(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel7() != null) {
					List<TempCarModelFullSpecWarrantyVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecWarranty youtubeTemplate : carModelTemplate.getCarModel7()) {
						TempCarModelFullSpecWarrantyVO youtubeTemplateVO = new TempCarModelFullSpecWarrantyVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel7(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel8() != null) {
					List<TempCarModelFullSpecStandEqVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecStandEq youtubeTemplate : carModelTemplate.getCarModel8()) {
						TempCarModelFullSpecStandEqVO youtubeTemplateVO = new TempCarModelFullSpecStandEqVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel8(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel9() != null) {
					List<TempCarModelOptEqpAddOnVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelOptEqpAddOn youtubeTemplate : carModelTemplate.getCarModel9()) {
						TempCarModelOptEqpAddOnVO youtubeTemplateVO = new TempCarModelOptEqpAddOnVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel9(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel10() != null) {
					List<TempCarModelRelatedModelVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelRelatedModel youtubeTemplate : carModelTemplate.getCarModel10()) {
						TempCarModelRelatedModelVO youtubeTemplateVO = new TempCarModelRelatedModelVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel10(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel11() != null) {
					List<TempCarModelPhotosVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelPhotos youtubeTemplate : carModelTemplate.getCarModel11()) {
						TempCarModelPhotosVO youtubeTemplateVO = new TempCarModelPhotosVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel11(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel12() != null) {
					List<TempCarModelVehReviewVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelVehReview youtubeTemplate : carModelTemplate.getCarModel12()) {
						TempCarModelVehReviewVO youtubeTemplateVO = new TempCarModelVehReviewVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel12(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel13() != null) {
					List<TempCarModelVideosVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelVideos youtubeTemplate : carModelTemplate.getCarModel13()) {
						TempCarModelVideosVO youtubeTemplateVO = new TempCarModelVideosVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel13(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel14() != null) {
					List<TempCarModelExtFittingVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelExtFitting youtubeTemplate : carModelTemplate.getCarModel14()) {
						TempCarModelExtFittingVO youtubeTemplateVO = new TempCarModelExtFittingVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel14(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel15() != null) {
					List<TempCarModelIntFittingVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelIntFitting youtubeTemplate : carModelTemplate.getCarModel15()) {
						TempCarModelIntFittingVO youtubeTemplateVO = new TempCarModelIntFittingVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel15(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel16() != null) {
					List<TempCarModelUserRatingVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelUserRating youtubeTemplate : carModelTemplate.getCarModel16()) {
						TempCarModelUserRatingVO youtubeTemplateVO = new TempCarModelUserRatingVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel16(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel17() != null) {
					List<TempCarModelExpertRatingVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelExpertRating youtubeTemplate : carModelTemplate.getCarModel17()) {
						TempCarModelExpertRatingVO youtubeTemplateVO = new TempCarModelExpertRatingVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel17(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel18() != null) {
					List<TempCarModelCountryVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelCountry youtubeTemplate : carModelTemplate.getCarModel18()) {
						TempCarModelCountryVO youtubeTemplateVO = new TempCarModelCountryVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel18(youtubeTemplates);
				}

				if (carModelTemplate.getCarModel19() != null) {
					List<TempCarModelFullSpecWheelVO> youtubeTemplates = new ArrayList<>();
					for (TempCarModelFullSpecWheel youtubeTemplate : carModelTemplate.getCarModel19()) {
						TempCarModelFullSpecWheelVO youtubeTemplateVO = new TempCarModelFullSpecWheelVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setCarModel19(youtubeTemplates);
				}

			}

		} catch (BeansException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carModelTemplateVO;
	}

	public TempCarModelHeader toTempCarModelTemplate(final TempCarModelHeaderVO carModelTemplateVO) {

		TempCarModelHeader carModelTemplate = new TempCarModelHeader();

		try {

			if (carModelTemplateVO.getCarModel() != null) {
				List<TempCarModelOverview> blogTemplates = new ArrayList<>();
				for (TempCarModelOverviewVO blogTemplateVO : carModelTemplateVO.getCarModel()) {
					TempCarModelOverview blogTemplate = new TempCarModelOverview();
					BeanUtils.copyProperties(blogTemplate, blogTemplateVO);
					blogTemplates.add(blogTemplate);
				}
				carModelTemplate.setCarModel(blogTemplates);
				carModelTemplateVO.setCarModel(null);
			}

			if (carModelTemplateVO.getCarModel1() != null) {
				List<TempCarModelPricing> countryTemplates = new ArrayList<>();
				for (TempCarModelPricingVO countryTemplateVO : carModelTemplateVO.getCarModel1()) {
					TempCarModelPricing countryTemplate = new TempCarModelPricing();
					BeanUtils.copyProperties(countryTemplate, countryTemplateVO);
					countryTemplates.add(countryTemplate);
				}
				carModelTemplate.setCarModel1(countryTemplates);
				carModelTemplateVO.setCarModel1(null);
			}

			if (carModelTemplateVO.getCarModel2() != null) {
				List<TempCarModelOptionalFeatureAddOn> photosTemplates = new ArrayList<>();
				for (TempCarModelOptionalFeatureAddOnVO photosTemplateVO : carModelTemplateVO.getCarModel2()) {
					TempCarModelOptionalFeatureAddOn photosTemplate = new TempCarModelOptionalFeatureAddOn();
					BeanUtils.copyProperties(photosTemplate, photosTemplateVO);
					photosTemplates.add(photosTemplate);
				}
				carModelTemplate.setCarModel2(photosTemplates);
				carModelTemplateVO.setCarModel2(null);
			}

			if (carModelTemplateVO.getCarModel3() != null) {
				List<TempCarModelColour> userReviewTemplates = new ArrayList<>();
				for (TempCarModelColourVO userReviewTemplateVO : carModelTemplateVO.getCarModel3()) {
					TempCarModelColour userReviewTemplate = new TempCarModelColour();
					BeanUtils.copyProperties(userReviewTemplate, userReviewTemplateVO);
					userReviewTemplates.add(userReviewTemplate);
				}
				carModelTemplate.setCarModel3(userReviewTemplates);
				carModelTemplateVO.setCarModel3(null);
			}

			if (carModelTemplateVO.getCarModel4() != null) {
				List<TempCarModelFullSpecEngine> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecEngineVO youtubeTemplateVO : carModelTemplateVO.getCarModel4()) {
					TempCarModelFullSpecEngine youtubeTemplate = new TempCarModelFullSpecEngine();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel4(youtubeTemplates);
				carModelTemplateVO.setCarModel4(null);
			}
			if (carModelTemplateVO.getCarModel5() != null) {
				List<TempCarModelFullSpecDimension> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecDimensionVO youtubeTemplateVO : carModelTemplateVO.getCarModel5()) {
					TempCarModelFullSpecDimension youtubeTemplate = new TempCarModelFullSpecDimension();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel5(youtubeTemplates);
				carModelTemplateVO.setCarModel5(null);
			}
			if (carModelTemplateVO.getCarModel6() != null) {
				List<TempCarModelFullSpecFuel> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecFuelVO youtubeTemplateVO : carModelTemplateVO.getCarModel6()) {
					TempCarModelFullSpecFuel youtubeTemplate = new TempCarModelFullSpecFuel();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel6(youtubeTemplates);
				carModelTemplateVO.setCarModel6(null);
			}
			if (carModelTemplateVO.getCarModel7() != null) {
				List<TempCarModelFullSpecWarranty> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecWarrantyVO youtubeTemplateVO : carModelTemplateVO.getCarModel7()) {
					TempCarModelFullSpecWarranty youtubeTemplate = new TempCarModelFullSpecWarranty();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel7(youtubeTemplates);
				carModelTemplateVO.setCarModel7(null);
			}
			if (carModelTemplateVO.getCarModel8() != null) {
				List<TempCarModelFullSpecStandEq> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecStandEqVO youtubeTemplateVO : carModelTemplateVO.getCarModel8()) {
					TempCarModelFullSpecStandEq youtubeTemplate = new TempCarModelFullSpecStandEq();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel8(youtubeTemplates);
				carModelTemplateVO.setCarModel8(null);
			}
			if (carModelTemplateVO.getCarModel9() != null) {
				List<TempCarModelOptEqpAddOn> youtubeTemplates = new ArrayList<>();
				for (TempCarModelOptEqpAddOnVO youtubeTemplateVO : carModelTemplateVO.getCarModel9()) {
					TempCarModelOptEqpAddOn youtubeTemplate = new TempCarModelOptEqpAddOn();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel9(youtubeTemplates);
				carModelTemplateVO.setCarModel9(null);
			}
			if (carModelTemplateVO.getCarModel10() != null) {
				List<TempCarModelRelatedModel> youtubeTemplates = new ArrayList<>();
				for (TempCarModelRelatedModelVO youtubeTemplateVO : carModelTemplateVO.getCarModel10()) {
					TempCarModelRelatedModel youtubeTemplate = new TempCarModelRelatedModel();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel10(youtubeTemplates);
				carModelTemplateVO.setCarModel10(null);
			}
			if (carModelTemplateVO.getCarModel11() != null) {
				List<TempCarModelPhotos> youtubeTemplates = new ArrayList<>();
				for (TempCarModelPhotosVO youtubeTemplateVO : carModelTemplateVO.getCarModel11()) {
					TempCarModelPhotos youtubeTemplate = new TempCarModelPhotos();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel11(youtubeTemplates);
				carModelTemplateVO.setCarModel11(null);
			}
			if (carModelTemplateVO.getCarModel12() != null) {
				List<TempCarModelVehReview> youtubeTemplates = new ArrayList<>();
				for (TempCarModelVehReviewVO youtubeTemplateVO : carModelTemplateVO.getCarModel12()) {
					TempCarModelVehReview youtubeTemplate = new TempCarModelVehReview();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel12(youtubeTemplates);
				carModelTemplateVO.setCarModel12(null);
			}
			if (carModelTemplateVO.getCarModel13() != null) {
				List<TempCarModelVideos> youtubeTemplates = new ArrayList<>();
				for (TempCarModelVideosVO youtubeTemplateVO : carModelTemplateVO.getCarModel13()) {
					TempCarModelVideos youtubeTemplate = new TempCarModelVideos();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel13(youtubeTemplates);
				carModelTemplateVO.setCarModel13(null);
			}
			if (carModelTemplateVO.getCarModel14() != null) {
				List<TempCarModelExtFitting> youtubeTemplates = new ArrayList<>();
				for (TempCarModelExtFittingVO youtubeTemplateVO : carModelTemplateVO.getCarModel14()) {
					TempCarModelExtFitting youtubeTemplate = new TempCarModelExtFitting();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel14(youtubeTemplates);
				carModelTemplateVO.setCarModel14(null);
			}
			if (carModelTemplateVO.getCarModel15() != null) {
				List<TempCarModelIntFitting> youtubeTemplates = new ArrayList<>();
				for (TempCarModelIntFittingVO youtubeTemplateVO : carModelTemplateVO.getCarModel15()) {
					TempCarModelIntFitting youtubeTemplate = new TempCarModelIntFitting();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel15(youtubeTemplates);
				carModelTemplateVO.setCarModel15(null);
			}
			if (carModelTemplateVO.getCarModel16() != null) {
				List<TempCarModelUserRating> youtubeTemplates = new ArrayList<>();
				for (TempCarModelUserRatingVO youtubeTemplateVO : carModelTemplateVO.getCarModel16()) {
					TempCarModelUserRating youtubeTemplate = new TempCarModelUserRating();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel16(youtubeTemplates);
				carModelTemplateVO.setCarModel16(null);
			}
			if (carModelTemplateVO.getCarModel17() != null) {
				List<TempCarModelExpertRating> youtubeTemplates = new ArrayList<>();
				for (TempCarModelExpertRatingVO youtubeTemplateVO : carModelTemplateVO.getCarModel17()) {
					TempCarModelExpertRating youtubeTemplate = new TempCarModelExpertRating();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel17(youtubeTemplates);
				carModelTemplateVO.setCarModel17(null);
			}
			if (carModelTemplateVO.getCarModel18() != null) {
				List<TempCarModelCountry> youtubeTemplates = new ArrayList<>();
				for (TempCarModelCountryVO youtubeTemplateVO : carModelTemplateVO.getCarModel18()) {
					TempCarModelCountry youtubeTemplate = new TempCarModelCountry();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel18(youtubeTemplates);
				carModelTemplateVO.setCarModel18(null);
			}
			if (carModelTemplateVO.getCarModel19() != null) {
				List<TempCarModelFullSpecWheel> youtubeTemplates = new ArrayList<>();
				for (TempCarModelFullSpecWheelVO youtubeTemplateVO : carModelTemplateVO.getCarModel19()) {
					TempCarModelFullSpecWheel youtubeTemplate = new TempCarModelFullSpecWheel();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setCarModel19(youtubeTemplates);
				carModelTemplateVO.setCarModel19(null);
			}

			nullAwareBeanUtils.copyProperties(carModelTemplate, carModelTemplateVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carModelTemplate;
	}

	public CarModelTemplateVO fromCarModelTemplate(final CarModelTemplate carModelTemplate, boolean isMinified) {
		if (carModelTemplate == null) {
			return null;
		}

		CarModelTemplateVO carModelTemplateVO = new CarModelTemplateVO();

		try {

			if (isMinified) {
				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "photosTemplate", "countryTemplate", "youtubeTemplate", "blogTemplate",
								"userReviewTemplate", "specificationTemplate" });
			} else {

				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "photosTemplate", "countryTemplate", "youtubeTemplate", "blogTemplate",
								"userReviewTemplate", "specificationTemplate" });

				if (carModelTemplate.getBlogTemplate() != null) {
					List<BlogTemplateVO> blogTemplates = new ArrayList<>();
					for (BlogTemplate blogTemplate : carModelTemplate.getBlogTemplate()) {
						BlogTemplateVO blogTemplateVO = new BlogTemplateVO();
						BeanUtils.copyProperties(blogTemplateVO, blogTemplate);
						blogTemplates.add(blogTemplateVO);
					}
					carModelTemplateVO.setBlogTemplate(blogTemplates);
				}

				if (carModelTemplate.getCountryTemplate() != null) {
					List<CountryTemplateVO> countryTemplates = new ArrayList<>();
					for (CountryTemplate countryTemplate : carModelTemplate.getCountryTemplate()) {
						CountryTemplateVO countryTemplateVO = new CountryTemplateVO();
						BeanUtils.copyProperties(countryTemplateVO, countryTemplate);
						countryTemplates.add(countryTemplateVO);
					}
					carModelTemplateVO.setCountryTemplate(countryTemplates);
				}

				if (carModelTemplate.getPhotosTemplate() != null) {
					List<PhotosTemplateVO> photosTemplates = new ArrayList<>();
					for (PhotosTemplate photosTemplate : carModelTemplate.getPhotosTemplate()) {
						PhotosTemplateVO photosTemplateVO = new PhotosTemplateVO();
						BeanUtils.copyProperties(photosTemplateVO, photosTemplate);
						photosTemplates.add(photosTemplateVO);
					}
					carModelTemplateVO.setPhotosTemplate(photosTemplates);
				}

				if (carModelTemplate.getSpecificationTemplate() != null) {
					SpecificationTemplateVO specificationTemplateVO = new SpecificationTemplateVO();
					BeanUtils.copyProperties(specificationTemplateVO, carModelTemplate.getSpecificationTemplate());
					carModelTemplateVO.setSpecificationTemplate(specificationTemplateVO);
				}

				if (carModelTemplate.getUserReviewTemplate() != null) {
					List<UserReviewTemplateVO> userReviewTemplates = new ArrayList<>();
					for (UserReviewTemplate userReviewTemplate : carModelTemplate.getUserReviewTemplate()) {
						UserReviewTemplateVO userReviewTemplateVO = new UserReviewTemplateVO();
						BeanUtils.copyProperties(userReviewTemplateVO, userReviewTemplate);
						userReviewTemplates.add(userReviewTemplateVO);
					}
					carModelTemplateVO.setUserReviewTemplate(userReviewTemplates);
				}

				if (carModelTemplate.getYoutubeTemplate() != null) {
					List<YoutubeTemplateVO> youtubeTemplates = new ArrayList<>();
					for (YoutubeTemplate youtubeTemplate : carModelTemplate.getYoutubeTemplate()) {
						YoutubeTemplateVO youtubeTemplateVO = new YoutubeTemplateVO();
						BeanUtils.copyProperties(youtubeTemplateVO, youtubeTemplate);
						youtubeTemplates.add(youtubeTemplateVO);
					}
					carModelTemplateVO.setYoutubeTemplate(youtubeTemplates);
				}

			}

		} catch (BeansException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carModelTemplateVO;
	}

	public CarModelTemplate toCarModelTemplate(final CarModelTemplateVO carModelTemplateVO) {

		CarModelTemplate carModelTemplate = new CarModelTemplate();

		try {

			if (carModelTemplateVO.getBlogTemplate() != null) {
				List<BlogTemplate> blogTemplates = new ArrayList<>();
				for (BlogTemplateVO blogTemplateVO : carModelTemplateVO.getBlogTemplate()) {
					BlogTemplate blogTemplate = new BlogTemplate();
					BeanUtils.copyProperties(blogTemplate, blogTemplateVO);
					blogTemplates.add(blogTemplate);
				}
				carModelTemplate.setBlogTemplate(blogTemplates);
				carModelTemplateVO.setBlogTemplate(null);
			}

			if (carModelTemplateVO.getCountryTemplate() != null) {
				List<CountryTemplate> countryTemplates = new ArrayList<>();
				for (CountryTemplateVO countryTemplateVO : carModelTemplateVO.getCountryTemplate()) {
					CountryTemplate countryTemplate = new CountryTemplate();
					BeanUtils.copyProperties(countryTemplate, countryTemplateVO);
					countryTemplates.add(countryTemplate);
				}
				carModelTemplate.setCountryTemplate(countryTemplates);
				carModelTemplateVO.setCountryTemplate(null);
			}

			if (carModelTemplateVO.getPhotosTemplate() != null) {
				List<PhotosTemplate> photosTemplates = new ArrayList<>();
				for (PhotosTemplateVO photosTemplateVO : carModelTemplateVO.getPhotosTemplate()) {
					PhotosTemplate photosTemplate = new PhotosTemplate();
					BeanUtils.copyProperties(photosTemplate, photosTemplateVO);
					photosTemplates.add(photosTemplate);
				}
				carModelTemplate.setPhotosTemplate(photosTemplates);
				carModelTemplateVO.setPhotosTemplate(null);
			}

			if (carModelTemplateVO.getSpecificationTemplate() != null) {
				SpecificationTemplate specificationTemplate = new SpecificationTemplate();
				BeanUtils.copyProperties(specificationTemplate, carModelTemplateVO.getSpecificationTemplate());
				carModelTemplate.setSpecificationTemplate(specificationTemplate);
				carModelTemplateVO.setSpecificationTemplate(null);
			}

			if (carModelTemplateVO.getUserReviewTemplate() != null) {
				List<UserReviewTemplate> userReviewTemplates = new ArrayList<>();
				for (UserReviewTemplateVO userReviewTemplateVO : carModelTemplateVO.getUserReviewTemplate()) {
					UserReviewTemplate userReviewTemplate = new UserReviewTemplate();
					BeanUtils.copyProperties(userReviewTemplate, userReviewTemplateVO);
					userReviewTemplates.add(userReviewTemplate);
				}
				carModelTemplate.setUserReviewTemplate(userReviewTemplates);
				carModelTemplateVO.setUserReviewTemplate(null);
			}

			if (carModelTemplateVO.getYoutubeTemplate() != null) {
				List<YoutubeTemplate> youtubeTemplates = new ArrayList<>();
				for (YoutubeTemplateVO youtubeTemplateVO : carModelTemplateVO.getYoutubeTemplate()) {
					YoutubeTemplate youtubeTemplate = new YoutubeTemplate();
					BeanUtils.copyProperties(youtubeTemplate, youtubeTemplateVO);
					youtubeTemplates.add(youtubeTemplate);
				}
				carModelTemplate.setYoutubeTemplate(youtubeTemplates);
				carModelTemplateVO.setYoutubeTemplate(null);
			}

			nullAwareBeanUtils.copyProperties(carModelTemplate, carModelTemplateVO);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carModelTemplate;
	}

	public VehicleQuotationVO fromVehicleQuotation(final VehicleQuotation vehicleQuotation) {
		VehicleQuotationVO vehicleQuotationVO = new VehicleQuotationVO();
		try {
			BeanUtils.copyProperties(vehicleQuotationVO, vehicleQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleQuotationVO;
	}

	public VehicleQuotationVO fromVehicleQuotation(final VehicleQuotation vehicleQuotation, boolean isMinified) {

		if (vehicleQuotation == null) {
			return null;
		}

		VehicleQuotationVO userVO = new VehicleQuotationVO();
		try {

			org.springframework.beans.BeanUtils.copyProperties(vehicleQuotation, userVO,
					new String[] { "userQuotationHistory", "dealerQuotationHistory", "vehicleResourcDetails" });

			if (!isMinified) {
				if (vehicleQuotation.getUserQuotationHistory() != null) {
					List<UserQuotationHistoryVO> searchVOs = new ArrayList<>();
					for (UserQuotationHistory search : vehicleQuotation.getUserQuotationHistory()) {
						UserQuotationHistoryVO searchVO = new UserQuotationHistoryVO();
						BeanUtils.copyProperties(searchVO, search);
						searchVOs.add(searchVO);
					}
					userVO.setUserQuotationHistoryVO(searchVOs);
				}

				if (vehicleQuotation.getDealerQuotationHistory() != null) {
					List<DealerQuotationHistoryVO> search1VOs = new ArrayList<>();
					for (DealerQuotationHistory search1 : vehicleQuotation.getDealerQuotationHistory()) {
						DealerQuotationHistoryVO search1VO = new DealerQuotationHistoryVO();
						BeanUtils.copyProperties(search1VO, search1);
						search1VOs.add(search1VO);
					}
					userVO.setDealerQuotationHistoryVO(search1VOs);
				}

				if (vehicleQuotation.getVehicleResourcDetails() != null) {
					List<VehicleResourceDetailsQuoVO> vehicleDealerDetailsVO = new ArrayList<>();
					for (VehicleResourceDetailsQuo vehicleDealerDetail : vehicleQuotation.getVehicleResourcDetails()) {
						VehicleResourceDetailsQuoVO searchFinanceVO = new VehicleResourceDetailsQuoVO();
						BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
						vehicleDealerDetailsVO.add(searchFinanceVO);
					}
					userVO.setVehicleResourcDetails(vehicleDealerDetailsVO);
				}

			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	public InsuranceQuotationVO fromInsuranceQuotation(final InsuranceQuotation insuranceQuotation) {
		InsuranceQuotationVO insuranceQuotationVO = new InsuranceQuotationVO();
		try {
			BeanUtils.copyProperties(insuranceQuotationVO, insuranceQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceQuotationVO;
	}

	public FinanceQuotationVO fromFinanceQuotation(final FinanceQuotation financeQuotation) {
		FinanceQuotationVO financeQuotationVO = new FinanceQuotationVO();
		try {
			BeanUtils.copyProperties(financeQuotationVO, financeQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return financeQuotationVO;
	}

	public ServiceMaintQuotationVO fromServMaintQuotation(final ServiceMaintQuotation financeQuotation) {
		ServiceMaintQuotationVO financeQuotationVO = new ServiceMaintQuotationVO();
		try {
			BeanUtils.copyProperties(financeQuotationVO, financeQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return financeQuotationVO;
	}

	public TranspServiceQuotationVO fromTranspServQuotation(final TranspServiceQuotation financeQuotation) {
		TranspServiceQuotationVO financeQuotationVO = new TranspServiceQuotationVO();
		try {
			BeanUtils.copyProperties(financeQuotationVO, financeQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return financeQuotationVO;
	}

	public MyVehicleVO fromMyVehicle(final MyVehicle financeQuotation) {
		MyVehicleVO financeQuotationVO = new MyVehicleVO();
		try {
			BeanUtils.copyProperties(financeQuotationVO, financeQuotation);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return financeQuotationVO;
	}

	public CurrentOffersVO fromCurrentOffers(final CurrentOffers currentOffer) {
		CurrentOffersVO currentOfferVO = new CurrentOffersVO();
		try {
			BeanUtils.copyProperties(currentOfferVO, currentOffer);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentOfferVO;
	}

	public DealerDetailsVO toDealerDetailsVO(final DealerVO currentOffer) {
		DealerDetailsVO currentOfferVO = new DealerDetailsVO();
		try {
			BeanUtils.copyProperties(currentOfferVO, currentOffer);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentOfferVO;
	}
	
}
