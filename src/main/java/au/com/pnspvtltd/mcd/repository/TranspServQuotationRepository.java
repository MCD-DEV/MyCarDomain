package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ServiceMaintQuotation;
import au.com.pnspvtltd.mcd.domain.TranspServiceQuotation;

public interface TranspServQuotationRepository extends JpaRepository<TranspServiceQuotation, Long> {

	@Query("SELECT transpServiceQuotation FROM TranspServiceQuotation transpServiceQuotation WHERE transpServiceQuotation.userId=?1 AND transpServiceQuotation.autoBid=true")
	List<TranspServiceQuotation> getQuotationsForUser(Long userId);

	List<TranspServiceQuotation> findByDealerId(Long dealerId);
	
	@Query("SELECT deal FROM TranspServiceQuotation deal where deal.userTranspServId = ?1")
	List<TranspServiceQuotation> getDealerSmForID(Long carServMaintId);
	
	
	@Query("SELECT deal FROM TranspServiceQuotation deal where deal.dealTranspServId = ?1 AND deal.dealerId = ?2 AND deal.internal = true")
	List<TranspServiceQuotation> getDealerSmForIDDealIdInt(Long carServMaintId, Long dealerId);
	
	@Query("SELECT deal FROM TranspServiceQuotation deal where deal.dealTranspServId = ?1 AND deal.dealerId = ?2 AND deal.external = true")
	List<TranspServiceQuotation> getDealerSmForIDDealIdExt(Long carServMaintId, Long dealerId);
	
	@Query("SELECT vehicleQuotation FROM TranspServiceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1")
	List<TranspServiceQuotation> getQuotForUserChat(Long userId);
	
	@Query("SELECT vehicleQuotation FROM TranspServiceQuotation vehicleQuotation WHERE vehicleQuotation.dealerId=?1 AND vehicleQuotation.internal = true")
	List<TranspServiceQuotation> getQuotForUserChatDlr(Long userId);
	
	@Query("SELECT vehicleQuotation FROM TranspServiceQuotation vehicleQuotation WHERE vehicleQuotation.dealerId=?1 AND vehicleQuotation.external = true")
	List<TranspServiceQuotation> getQuotForUserChatDlrExt(Long userId);
	
	@Query("SELECT vehicleQuotation FROM TranspServiceQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1 AND vehicleQuotation.userTranspServId = ?2")
	List<TranspServiceQuotation> getQuotationsForUserIdEbidId(Long userId, Long carSearchId);

}
