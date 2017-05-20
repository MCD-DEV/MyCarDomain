package au.com.pnspvtltd.mcd.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.pnspvtltd.mcd.domain.BlogTemplate;
import au.com.pnspvtltd.mcd.domain.CarModelTemplate;
import au.com.pnspvtltd.mcd.domain.ComingSoonUser;
import au.com.pnspvtltd.mcd.domain.CountryTemplate;
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
import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.MyVehicleFuelExpenses;
import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;
import au.com.pnspvtltd.mcd.domain.MyVehicleServMaint;
import au.com.pnspvtltd.mcd.domain.PhotosTemplate;
import au.com.pnspvtltd.mcd.domain.RegoStateUrl;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.SearchFinance;
import au.com.pnspvtltd.mcd.domain.SearchInsurance;
import au.com.pnspvtltd.mcd.domain.SearchServMaint;
import au.com.pnspvtltd.mcd.domain.SearchTransp;
import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.SpecificationTemplate;
import au.com.pnspvtltd.mcd.domain.TempCarModelColour;
import au.com.pnspvtltd.mcd.domain.TempCarModelCountry;
import au.com.pnspvtltd.mcd.domain.TempCarModelExpertRating;
import au.com.pnspvtltd.mcd.domain.TempCarModelExtFitting;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecDimension;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecEngine;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecFuel;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecStandEq;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecWarranty;
import au.com.pnspvtltd.mcd.domain.TempCarModelFullSpecWheel;
import au.com.pnspvtltd.mcd.domain.TempCarModelHeader;
import au.com.pnspvtltd.mcd.domain.TempCarModelIntFitting;
import au.com.pnspvtltd.mcd.domain.TempCarModelOptEqpAddOn;
import au.com.pnspvtltd.mcd.domain.TempCarModelOptionalFeatureAddOn;
import au.com.pnspvtltd.mcd.domain.TempCarModelOverview;
import au.com.pnspvtltd.mcd.domain.TempCarModelPhotos;
import au.com.pnspvtltd.mcd.domain.TempCarModelPricing;
import au.com.pnspvtltd.mcd.domain.TempCarModelRelatedModel;
import au.com.pnspvtltd.mcd.domain.TempCarModelUserRating;
import au.com.pnspvtltd.mcd.domain.TempCarModelVehReview;
import au.com.pnspvtltd.mcd.domain.TempCarModelVideos;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.User;
import au.com.pnspvtltd.mcd.domain.UserNotification;
import au.com.pnspvtltd.mcd.domain.UserReviewTemplate;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperPostCode;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperRegion;
import au.com.pnspvtltd.mcd.domain.VehicleDealerAreaOfOperState;
import au.com.pnspvtltd.mcd.domain.VehicleDealerDetails;
import au.com.pnspvtltd.mcd.domain.VehicleDealerFinanceDetails;
import au.com.pnspvtltd.mcd.domain.VehicleDealerInsuranceDetails;
import au.com.pnspvtltd.mcd.domain.VehicleDealerMakeList;
import au.com.pnspvtltd.mcd.domain.VehicleDealerServMaintDetails;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.YoutubeTemplate;
import au.com.pnspvtltd.mcd.web.model.BlogTemplateVO;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;
import au.com.pnspvtltd.mcd.web.model.ComingSoonVO;
import au.com.pnspvtltd.mcd.web.model.CountryTemplateVO;
import au.com.pnspvtltd.mcd.web.model.CurrentOffersVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelExpensesVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.PhotosTemplateVO;
import au.com.pnspvtltd.mcd.web.model.RegoStateUrlVO;
import au.com.pnspvtltd.mcd.web.model.SearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.SearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.SearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.SearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.SearchVO;
import au.com.pnspvtltd.mcd.web.model.ServiceMaintQuotationVO;
import au.com.pnspvtltd.mcd.web.model.SpecificationTemplateVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelColourVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelCountryVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelExpertRatingVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelExtFittingVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecDimensionVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecEngineVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecFuelVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecStandEqVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecWarrantyVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelFullSpecWheelVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelIntFittingVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelOptEqpAddOnVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelOptionalFeatureAddOnVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelOverviewVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelPhotosVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelPricingVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelRelatedModelVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelUserRatingVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelVehReviewVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelVideosVO;
import au.com.pnspvtltd.mcd.web.model.TranspServiceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.UserNotificationVO;
import au.com.pnspvtltd.mcd.web.model.UserReviewTemplateVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerAreaOfOperPostCodeVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerAreaOfOperRegionVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerAreaOfOperStateVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerFinanceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerInsuranceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerMakeListhVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerServMaintDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.YoutubeTemplateVO;

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

			org.springframework.beans.BeanUtils.copyProperties(user, userVO, new String[] { "search", "searchInsurance",
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
			for(;it.hasNext();){
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

		
	
	//From Vehcile
	
	public MyVehicleVO FromMyVehicle(final MyVehicle myVehicle) {

		MyVehicleVO myVehicleVO = new MyVehicleVO();
		
		try {
			//BeanUtils.copyProperties(myVehicleVO, myVehicle);
			org.springframework.beans.BeanUtils.copyProperties(myVehicle, myVehicleVO, new String[] {"myVehicleLogBook","myVehicleFuelExpenses","myVehicleServMaint"});
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

	// User Finance Lead
	public SearchFinance toSearchFinance(final SearchFinanceVO searchFinanceVO) {
		SearchFinance searchFinance = null;
		if(searchFinanceVO != null){
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

	// User Insurance Lead
	public SearchInsurance toSearchInsurance(final SearchInsuranceVO searchInsuranceVO) {
		SearchInsurance searchInsurance = null;
		if(searchInsuranceVO != null){
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

	public DealerVO fromDealer(final Dealer dealer, boolean isMinified) {

		if (dealer == null) {
			return null;
		}

		DealerVO dealerVO = new DealerVO();
		try {

			org.springframework.beans.BeanUtils.copyProperties(dealer, dealerVO,
					new String[] { "inventory", "dealSearch", "dealSearchInsurance", "dealSearchFinance",
							"dealSearchServMaint", "dealSearchTransp","vehicleDealerDetails","vehicleDealerFinanceDetails","vehicleDealerInsuranceDetails","vehicleDealerServMaintDetails",
							"vehicleDealerMakeList","vehicleDealerAreaOfOperState","vehicleDealerRegion","vehicleDealerPostCode"});

			if (!isMinified) {

				List<InventoryVO> inventoryVOs = new ArrayList<>();
				for (Inventory inventory : dealer.getInventory()) {
					InventoryVO inventoryVO = new InventoryVO();
					BeanUtils.copyProperties(inventoryVO, inventory);
					inventoryVOs.add(inventoryVO);
				}
				dealerVO.setInventory(inventoryVOs);

				List<DealerSearchVO> searchVOs = new ArrayList<>();
				for (DealerSearch search : dealer.getDealSearch()) {
					DealerSearchVO searchVO = new DealerSearchVO();
					BeanUtils.copyProperties(searchVO, search);
					searchVOs.add(searchVO);
				}
				dealerVO.setDealSearch(searchVOs);

				List<DealerSearchInsuranceVO> searchInsuranceVOs = new ArrayList<>();
				for (DealerSearchInsurance searchInsurance : dealer.getDealSearchInsurance()) {
					DealerSearchInsuranceVO SearchInsuranceVO = new DealerSearchInsuranceVO();
					BeanUtils.copyProperties(SearchInsuranceVO, searchInsurance);
					searchInsuranceVOs.add(SearchInsuranceVO);
				}
				dealerVO.setDealSearchInsurance(searchInsuranceVOs);
				
				List<DealerSearchServMaintVO> dealerSearchServMaintVOs = new ArrayList<>();
				for (DealerSearchServMaint dealerSearchServMaint : dealer.getDealSearchServMaint()) {
					DealerSearchServMaintVO dealerSearchServMaintVO = new DealerSearchServMaintVO();
					BeanUtils.copyProperties(dealerSearchServMaintVO, dealerSearchServMaint);
					dealerSearchServMaintVOs.add(dealerSearchServMaintVO);
				}
				dealerVO.setDealSearchServMaint(dealerSearchServMaintVOs);
				
				
				

				List<DealerSearchTranspVO> dealerSearchTranspVOs = new ArrayList<>();
				for (DealerSearchTransp dealerSearchServMaint : dealer.getDealSearchTransp()) {
					DealerSearchTranspVO dealerSearchTranspVO = new DealerSearchTranspVO();
					BeanUtils.copyProperties(dealerSearchTranspVO, dealerSearchServMaint);
					dealerSearchTranspVOs.add(dealerSearchTranspVO);
				}
				dealerVO.setDealSearchTransp(dealerSearchTranspVOs);
				
				

				List<DealerSearchFinanceVO> searchFinanceVOs = new ArrayList<>();
				for (DealerSearchFinance searchFinance : dealer.getDealSearchFinance()) {
					DealerSearchFinanceVO searchFinanceVO = new DealerSearchFinanceVO();
					BeanUtils.copyProperties(searchFinanceVO, searchFinance);
					searchFinanceVOs.add(searchFinanceVO);
				}
				dealerVO.setDealSearchFinance(searchFinanceVOs);
				
				List<VehicleDealerDetailsVO> vehicleDealerDetailsVO = new ArrayList<>();
				for (VehicleDealerDetails vehicleDealerDetail : dealer.getVehicleDealerDetails()) {
					VehicleDealerDetailsVO searchFinanceVO = new VehicleDealerDetailsVO();
					BeanUtils.copyProperties(searchFinanceVO, vehicleDealerDetail);
					vehicleDealerDetailsVO.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerDetails(vehicleDealerDetailsVO);
				
				List<VehicleDealerFinanceDetailsVO> VehicleDealerFinanceDetailsVO = new ArrayList<>();
				for (VehicleDealerFinanceDetails VehicleDealerFinanceDetails : dealer.getVehicleDealerFinanceDetails()) {
					VehicleDealerFinanceDetailsVO searchFinanceVO = new VehicleDealerFinanceDetailsVO();
					BeanUtils.copyProperties(searchFinanceVO, VehicleDealerFinanceDetails);
					VehicleDealerFinanceDetailsVO.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerFinanceDetails(VehicleDealerFinanceDetailsVO);
				
				List<VehicleDealerInsuranceDetailsVO> VehicleDealerInsuranceDetailsVOs = new ArrayList<>();
				for (VehicleDealerInsuranceDetails VehicleDealerInsuranceDetails : dealer.getVehicleDealerInsuranceDetails()) {
					VehicleDealerInsuranceDetailsVO searchFinanceVO = new VehicleDealerInsuranceDetailsVO();
					BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
					VehicleDealerInsuranceDetailsVOs.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerInsuranceDetails(VehicleDealerInsuranceDetailsVOs);
				
				List<VehicleDealerServMaintDetailsVO> vehicleDealerServMaintDetailsVOs = new ArrayList<>();
				for (VehicleDealerServMaintDetails VehicleDealerInsuranceDetails : dealer.getVehicleDealerServMaintDetails()) {
					VehicleDealerServMaintDetailsVO searchFinanceVO = new VehicleDealerServMaintDetailsVO();
					BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
					vehicleDealerServMaintDetailsVOs.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerServMaintDetails(vehicleDealerServMaintDetailsVOs);
				
				List<VehicleDealerMakeListhVO> vehicleDealerMakeListVOs = new ArrayList<>();
				for (VehicleDealerMakeList VehicleDealerInsuranceDetails : dealer.getVehicleDealerMakeList()) {
					VehicleDealerMakeListhVO searchFinanceVO = new VehicleDealerMakeListhVO();
					BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
					vehicleDealerMakeListVOs.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerMakeList(vehicleDealerMakeListVOs);
				
				List<VehicleDealerAreaOfOperStateVO> vehicleDealerAreaOfOperStateVOs = new ArrayList<>();
				for (VehicleDealerAreaOfOperState VehicleDealerInsuranceDetails : dealer.getVehicleDealerAreaOfOperState()) {
					VehicleDealerAreaOfOperStateVO searchFinanceVO = new VehicleDealerAreaOfOperStateVO();
					BeanUtils.copyProperties(searchFinanceVO, VehicleDealerInsuranceDetails);
					vehicleDealerAreaOfOperStateVOs.add(searchFinanceVO);
				}
				dealerVO.setVehicleDealerAreaOfOperState(vehicleDealerAreaOfOperStateVOs);
				
				List<VehicleDealerAreaOfOperRegionVO> vehicleDealerAreaOfOperRegionVOs = new ArrayList<>();
				for (VehicleDealerAreaOfOperRegion vehicleDealerAreaOfOperRegion : dealer.getVehicleDealerRegion()) {
					VehicleDealerAreaOfOperRegionVO vehicleDealerAreaOfOperRegionVO = new VehicleDealerAreaOfOperRegionVO();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperRegionVO, vehicleDealerAreaOfOperRegion);
					vehicleDealerAreaOfOperRegionVOs.add(vehicleDealerAreaOfOperRegionVO);
				}
				dealerVO.setVehicleDealerRegion(vehicleDealerAreaOfOperRegionVOs);
				
				
				
				
				List<VehicleDealerAreaOfOperPostCodeVO> vehicleDealerAreaOfOperPostCodeVOs = new ArrayList<>();
				for (VehicleDealerAreaOfOperPostCode vehicleDealerAreaOfOperPostCode : dealer.getVehicleDealerPostCode()) {
					VehicleDealerAreaOfOperPostCodeVO vehicleDealerAreaOfOperPostCodeVO = new VehicleDealerAreaOfOperPostCodeVO();
					BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCodeVO, vehicleDealerAreaOfOperPostCode);
					vehicleDealerAreaOfOperPostCodeVOs.add(vehicleDealerAreaOfOperPostCodeVO);
				}
				dealerVO.setVehicleDealerPostCode(vehicleDealerAreaOfOperPostCodeVOs);

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

	public Dealer toDealer(final DealerVO dealerVO) {
		Dealer dealer = new Dealer();
		try {


			org.springframework.beans.BeanUtils.copyProperties(dealerVO, dealer,
					new String[] { "inventory", "dealSearch", "dealSearchInsurance", "dealSearchFinance",
							"dealSearchServMaint", "dealSearchTransp","vehicleDealerDetails","vehicleDealerFinanceDetails","vehicleDealerInsuranceDetails","vehicleDealerServMaintDetails",
							"vehicleDealerMakeList","vehicleDealerAreaOfOperState","vehicleDealerRegion","vehicleDealerPostCode"});
			List<Inventory> inventorys = new ArrayList<>();
			if(dealerVO.getInventory()!= null){
			for (InventoryVO inventoryVO : dealerVO.getInventory()) {
				Inventory inventory = new Inventory();
				BeanUtils.copyProperties(inventory,inventoryVO);
				inventorys.add(inventory);
			}
			dealer.setInventory(inventorys);
			}
			if(dealerVO.getDealSearch() != null){
			List<DealerSearch> searchs = new ArrayList<>();
			for (DealerSearchVO searchVO : dealerVO.getDealSearch()) {
				DealerSearch search = new DealerSearch();
				BeanUtils.copyProperties(search, searchVO);
				searchs.add(search);
			}
			dealer.setDealSearch(searchs);
			}
			if(dealerVO.getDealSearchInsurance() != null){
			List<DealerSearchInsurance> searchInsurances = new ArrayList<>();
			for (DealerSearchInsuranceVO searchInsuranceVO : dealerVO.getDealSearchInsurance()) {
				DealerSearchInsurance searchInsurance = new DealerSearchInsurance();
				BeanUtils.copyProperties(searchInsurance, searchInsuranceVO);
				searchInsurances.add(searchInsurance);
			}
			dealer.setDealSearchInsurance(searchInsurances);
			}
			if(dealerVO.getDealSearchFinance() != null){
			List<DealerSearchFinance> searchFinances = new ArrayList<>();
			for (DealerSearchFinanceVO searchFinanceVO : dealerVO.getDealSearchFinance()) {
				DealerSearchFinance searchFinance = new DealerSearchFinance();
				BeanUtils.copyProperties(searchFinance, searchFinanceVO);
				searchFinances.add(searchFinance);
			}
			dealer.setDealSearchFinance(searchFinances);
			}
			List<VehicleDealerDetails> vehicleDealerDetails = new ArrayList<>();
			for (VehicleDealerDetailsVO vehicleDealerDetailVO : dealerVO.getVehicleDealerDetails()) {
				VehicleDealerDetails vehicleDealerDetail = new VehicleDealerDetails();
				BeanUtils.copyProperties(vehicleDealerDetail, vehicleDealerDetailVO);
				vehicleDealerDetails.add(vehicleDealerDetail);
			}
			dealer.setVehicleDealerDetails(vehicleDealerDetails);
			
			List<VehicleDealerFinanceDetails> vehicleDealerFinanceDetails = new ArrayList<>();
			for (VehicleDealerFinanceDetailsVO vehicleDealerFinanceDetailVO : dealerVO.getVehicleDealerFinanceDetails()) {
				VehicleDealerFinanceDetails vehicleDealerFinanceDetail = new VehicleDealerFinanceDetails();
				BeanUtils.copyProperties(vehicleDealerFinanceDetail, vehicleDealerFinanceDetailVO);
				vehicleDealerFinanceDetails.add(vehicleDealerFinanceDetail);
			}
			dealer.setVehicleDealerFinanceDetails(vehicleDealerFinanceDetails);
			
			List<VehicleDealerInsuranceDetails> vehicleDealerInsuranceDetails = new ArrayList<>();
			for (VehicleDealerInsuranceDetailsVO vehicleDealerInsuranceDetailVO : dealerVO.getVehicleDealerInsuranceDetails()) {
				VehicleDealerInsuranceDetails vehicleDealerInsuranceDetail = new VehicleDealerInsuranceDetails();
				BeanUtils.copyProperties(vehicleDealerInsuranceDetail, vehicleDealerInsuranceDetailVO);
				vehicleDealerInsuranceDetails.add(vehicleDealerInsuranceDetail);
			}
			dealer.setVehicleDealerInsuranceDetails(vehicleDealerInsuranceDetails);
			
			List<VehicleDealerServMaintDetails> vehicleDealerServMaintDetails = new ArrayList<>();
			for (VehicleDealerServMaintDetailsVO vehicleDealerServMaintDetailVO : dealerVO.getVehicleDealerServMaintDetails()) {
				VehicleDealerServMaintDetails vehicleDealerServMaintDetail = new VehicleDealerServMaintDetails();
				BeanUtils.copyProperties(vehicleDealerServMaintDetail, vehicleDealerServMaintDetailVO);
				vehicleDealerServMaintDetails.add(vehicleDealerServMaintDetail);
			}
			dealer.setVehicleDealerServMaintDetails(vehicleDealerServMaintDetails);
			
			
			if(dealerVO.getDealSearchServMaint() != null){
			List<DealerSearchServMaint> dealerSearchServMaints = new ArrayList<>();
			for (DealerSearchServMaintVO dealerSearchServMaintVO : dealerVO.getDealSearchServMaint()) {
				DealerSearchServMaint dealerSearchServMaint = new DealerSearchServMaint();
				BeanUtils.copyProperties(dealerSearchServMaint, dealerSearchServMaintVO);
				dealerSearchServMaints.add(dealerSearchServMaint);
			}
			dealer.setDealSearchServMaint(dealerSearchServMaints);
			}
			
			
			if(dealerVO.getDealSearchTransp() != null) {
			List<DealerSearchTransp> dealerSearchTransps = new ArrayList<>();
			for (DealerSearchTranspVO dealerSearchTranspVO : dealerVO.getDealSearchTransp()) {
				DealerSearchTransp dealerSearchTransp = new DealerSearchTransp();
				BeanUtils.copyProperties(dealerSearchTransp, dealerSearchTranspVO);
				dealerSearchTransps.add(dealerSearchTransp);
			}
			dealer.setDealSearchTransp(dealerSearchTransps);
			
			}
			
			
			
			List<VehicleDealerMakeList> vehicleDealerMakeLists = new ArrayList<>();
			for (VehicleDealerMakeListhVO vehicleDealerMakeListVO : dealerVO.getVehicleDealerMakeList()) {
				VehicleDealerMakeList vehicleDealerMakeList = new VehicleDealerMakeList();
				BeanUtils.copyProperties(vehicleDealerMakeList, vehicleDealerMakeListVO);
				vehicleDealerMakeLists.add(vehicleDealerMakeList);
			}
			dealer.setVehicleDealerMakeList(vehicleDealerMakeLists);
			
			List<VehicleDealerAreaOfOperState> vehicleDealerAreaOfOperStates = new ArrayList<>();
			for (VehicleDealerAreaOfOperStateVO vehicleDealerAreaOfOperStateVO : dealerVO.getVehicleDealerAreaOfOperState()) {
				VehicleDealerAreaOfOperState vehicleDealerAreaOfOperState = new VehicleDealerAreaOfOperState();
				BeanUtils.copyProperties(vehicleDealerAreaOfOperState, vehicleDealerAreaOfOperStateVO);
				vehicleDealerAreaOfOperStates.add(vehicleDealerAreaOfOperState);
			}
			dealer.setVehicleDealerAreaOfOperState(vehicleDealerAreaOfOperStates);
			
			List<VehicleDealerAreaOfOperRegion> vehicleDealerAreaOfOperRegions = new ArrayList<>();
			for (VehicleDealerAreaOfOperRegionVO vehicleDealerAreaOfOperRegionVO : dealerVO.getVehicleDealerRegion()) {
				VehicleDealerAreaOfOperRegion vehicleDealerAreaOfOperRegion = new VehicleDealerAreaOfOperRegion();
				BeanUtils.copyProperties(vehicleDealerAreaOfOperRegion, vehicleDealerAreaOfOperRegionVO);
				vehicleDealerAreaOfOperRegions.add(vehicleDealerAreaOfOperRegion);
			}
			dealer.setVehicleDealerRegion(vehicleDealerAreaOfOperRegions);
			
			
			
			
			List<VehicleDealerAreaOfOperPostCode> vehicleDealerAreaOfOperPostCodes = new ArrayList<>();
			for (VehicleDealerAreaOfOperPostCodeVO vehicleDealerAreaOfOperPostCodeVO : dealerVO.getVehicleDealerPostCode()) {
				VehicleDealerAreaOfOperPostCode vehicleDealerAreaOfOperPostCode = new VehicleDealerAreaOfOperPostCode();
				BeanUtils.copyProperties(vehicleDealerAreaOfOperPostCode, vehicleDealerAreaOfOperPostCodeVO);
				vehicleDealerAreaOfOperPostCodes.add(vehicleDealerAreaOfOperPostCode);
			}
			dealer.setVehicleDealerPostCode(vehicleDealerAreaOfOperPostCodes);

		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealer;
	}

	
	
	public TempCarModelHeaderVO fromTempCarModelTemplate(final TempCarModelHeader carModelTemplate, boolean isMinified) {
		if (carModelTemplate == null) {
			return null;
		}

		TempCarModelHeaderVO carModelTemplateVO = new TempCarModelHeaderVO();

		try {

			if (isMinified) {
				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "TempCarModelPricing", "TempCarModelPricing", "TempCarModelOptionalFeatureAddOn", "TempCarModelColour",
								"TempCarModelFullSpecEngine", "TempCarModelFullSpecDimension","TempCarModelFullSpecFuel", "TempCarModelFullSpecWarranty",
								"TempCarModelFullSpecStandEq", "TempCarModelOptEqpAddOn","TempCarModelRelatedModel", "TempCarModelVehReview",
								"TempCarModelVideos", "TempCarModelExtFitting","TempCarModelIntFitting", "TempCarModelUserRating",
								"TempCarModelExpertRating", "TempCarModelCountry","TempCarModelFullSpecWheel"});
			} else {

				org.springframework.beans.BeanUtils.copyProperties(carModelTemplate, carModelTemplateVO,
						new String[] { "TempCarModelPricing", "TempCarModelPricing", "TempCarModelOptionalFeatureAddOn", "TempCarModelColour",
								"TempCarModelFullSpecEngine", "TempCarModelFullSpecDimension","TempCarModelFullSpecFuel", "TempCarModelFullSpecWarranty",
								"TempCarModelFullSpecStandEq", "TempCarModelOptEqpAddOn","TempCarModelRelatedModel", "TempCarModelVehReview",
								"TempCarModelVideos", "TempCarModelExtFitting","TempCarModelIntFitting", "TempCarModelUserRating",
								"TempCarModelExpertRating", "TempCarModelCountry","TempCarModelFullSpecWheel" });

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

}
