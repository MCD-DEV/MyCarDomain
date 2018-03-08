package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;

public interface FinanceQuotationRepository extends JpaRepository<FinanceQuotation, Long> {

	@Query("SELECT financeQuotation FROM FinanceQuotation financeQuotation WHERE financeQuotation.userId=?1 AND financeQuotation.autoBid=true")
	List<FinanceQuotation> getQuotationsForUser(Long userId);

	List<FinanceQuotation> findByDealerId(Long dealerId);
	
	@Query("SELECT deal FROM FinanceQuotation deal where deal.carSearchId = ?1")
	List<FinanceQuotation> getDealerSmForID(Long carServMaintId);
	
	@Query("SELECT deal FROM FinanceQuotation deal where deal.carSearchId = ?1 AND deal.dealerId = ?2")
	List<FinanceQuotation> getDealerSmForIDDealId(Long carServMaintId, Long dealerId);
	
	@Query("SELECT vehicleQuotation FROM FinanceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1")
	List<FinanceQuotation> getQuotForUserChat(Long userId);
	
	@Query("SELECT vehicleQuotation FROM FinanceQuotation vehicleQuotation WHERE vehicleQuotation.dealerId=?1")
	List<FinanceQuotation> getQuotForUserChatDlr(Long userId);
	
	@Query("SELECT vehicleQuotation FROM FinanceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1 AND vehicleQuotation.carSearchId = ?2")
	List<FinanceQuotation> getQuotationsForUserIdEbidId(Long userId, Long carSearchId);
}
