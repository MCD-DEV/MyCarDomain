package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerEBidVO;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.VehicleDealerDetails;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;
import au.com.pnspvtltd.mcd.web.model.AdminStatusVO;
import au.com.pnspvtltd.mcd.web.model.AdminVerifyVO;
import au.com.pnspvtltd.mcd.web.model.DealerFinanceMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerInsuranceMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerLoginVO;
import au.com.pnspvtltd.mcd.web.model.DealerResourceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchAdminVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
import au.com.pnspvtltd.mcd.web.model.DealerServMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerSubscriptionSBLVO;
import au.com.pnspvtltd.mcd.web.model.DealerTranpMasterVO;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerFinLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerInsLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSearchLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerSvLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.ExtDealerTpLdAdminVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityListVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryListVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerInsuranceDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerServMaintDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleDealerTranspDetailsVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;
import au.com.pnspvtltd.mcd.web.model.VehicleResourceDetailsVO;

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

	DealerSubscriptionSBLVO createVehicleDealerSBL(DealerSubscriptionSBLVO dealerVO);
	DealerResourceVO createDealerResource(DealerResourceVO dealerVO);
	DealerSearchVO getDealerSearchUnique(Long dealerId);

	VehicleResourceDetailsVO getDealerResourcebyID(long id);
	List<VehicleResourceDetailsVO> getResource(Long dealerId);
	DealerServMasterVO createDealerServMaster(DealerServMasterVO dealerVO);
	

	VehicleDealerServMaintDetailsVO getServiceMasterId(long id);

	List<VehicleDealerServMaintDetailsVO> getServMast(Long dealerId);

	DealerTranpMasterVO createDealerTranpMaster(DealerTranpMasterVO dealerVO);

	VehicleDealerTranspDetailsVO getTranspMasterId(long id);

	List<VehicleDealerTranspDetailsVO> getTranspMast(Long dealerId);

	DealerFinanceMasterVO createDealerFinanceMaster(DealerFinanceMasterVO dealerVO);

	FinanceEntityVO getFinanceMasterId(long id);

	List<FinanceEntityVO> getFinanceMast(Long dealerId);

	DealerInsuranceMasterVO createDealerInsuranceMaster(DealerInsuranceMasterVO dealerVO);

	VehicleDealerInsuranceDetailsVO getInsMasterId(long id);

	List<VehicleDealerInsuranceDetailsVO> getInsuranceMast(Long dealerId);
	
	List<Long> getDealerIDs(String subscriptionType);

	List<DealerSearchServMaintVO> getDealerSearchSnM(Long dealerId);

	List<DealerSearchTranspVO> getDealerSearchTrans(Long dealerId);

	List<DealerSearchInsuranceVO> getDealerSearchIns(Long dealerId);

	List<DealerSearchFinanceVO> getDealerSearchFin(Long dealerId);

}
