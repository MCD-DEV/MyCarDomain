package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerEBidVO;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;
import au.com.pnspvtltd.mcd.web.model.AdminStatusVO;
import au.com.pnspvtltd.mcd.web.model.AdminVerifyVO;
import au.com.pnspvtltd.mcd.web.model.DealerLoginVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerFinLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerInsLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSvLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerTpLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityListVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

public interface DealerService {

	DealerVO findById(Long id);

	DealerVO createDealer(DealerVO dealer);
	DealerVO createDealerLogin(DealerLoginVO dealer);

	DealerVO updateDealer(DealerVO dealer);
	AdminAutoVO findUserName(String userName);
	DealerSearch dealerAdminLead(DealerSearchAdminVO dealer);
	String extDealerAdminLead(ExtDealerSearchLdAdminVO dealer);
	String extDealerSvAdminLead(ExtDealerSvLdAdminVO dealerVO);
	String extDealerTpAdminLead(ExtDealerTpLdAdminVO dealerVO);
	String extDealerFinAdminLead(ExtDealerFinLdAdminVO dealerVO);
	String extDealerInsAdminLead(ExtDealerInsLdAdminVO dealerVO);
	List<DealerVO> findAllDealers();

	DealerVO findDealerByEmail(String email);
	
	String addInventory(InventoryVO inventoryVO);
	String addInventoryUser(InventoryVO inventoryVO);
	String addInventoryList(InventoryListVO inventoryVO);
	String addFinanceEntityList(FinanceEntityListVO inventoryVO);
	
	List<InventoryVO> getInventory(Long dealerId);
	
	List<DealerSearchVO> getDealerSearch(Long dealerId);
	
	List<DealerSearchInsuranceVO> getDealerSearchInsurance(Long dealerId);
	
	List<DealerSearchFinanceVO> getDealerSearchFinance(Long dealerId);
	
	List<VehicleQuotationVO> getDealerVehicleQuotation(Long dealerId);
	
	List<InsuranceQuotationVO> getDealerInsuranceQuotation(Long dealerId);
	
	List<FinanceQuotationVO> getDealerFinanceQuotation(Long dealerId);

	String whenDealerEBidForCar(DealerEBidVO dealerEBidVO);
	
	List<Long> getDealerIDs();

	DealerVO getDealerForID(Long dealerID);
	String updateStatus(AdminStatusVO financeEntityListVO);
	AdminVerifyVO getExistStatus(Long eBidId);

	DealerVO findByEmailIgnoreCase(String email);
}
