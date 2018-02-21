package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;

public interface InsuranceQuotationRepository extends JpaRepository<InsuranceQuotation, Long> {

	@Query("SELECT insuranceQuotation FROM InsuranceQuotation insuranceQuotation WHERE insuranceQuotation.userId=?1 AND insuranceQuotation.autoBid=true")
	List<InsuranceQuotation> getQuotationsForUser(Long userId);

	List<InsuranceQuotation> findByDealerId(Long dealerId);
	@Query("SELECT deal FROM InsuranceQuotation deal where deal.carSearchId = ?1")
	List<InsuranceQuotation> getDealerSmForID(Long carServMaintId);
	
	
	@Query("SELECT deal FROM InsuranceQuotation deal where deal.carSearchId = ?1 AND deal.dealerId = ?2")
	List<InsuranceQuotation> getDealerSmForIDDealId(Long carServMaintId, Long dealerId);
	
	
	@Query("SELECT vehicleQuotation FROM InsuranceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1")
	List<InsuranceQuotation> getQuotForUserChat(Long userId);
	
	@Query("SELECT vehicleQuotation FROM InsuranceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1 AND vehicleQuotation.carSearchId = ?2")
	List<InsuranceQuotation> getQuotationsForUserIdEbidId(Long userId, Long carSearchId);
}

