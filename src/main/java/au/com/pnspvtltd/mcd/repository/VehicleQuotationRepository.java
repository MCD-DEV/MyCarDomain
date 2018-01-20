package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;

public interface VehicleQuotationRepository extends JpaRepository<VehicleQuotation, Long> {

	@Query("SELECT vehicleQuotation FROM VehicleQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1 AND (vehicleQuotation.autoBid=true OR vehicleQuotation.moveToUser=true)")
	List<VehicleQuotation> getQuotationsForUser(Long userId);

	List<VehicleQuotation> findByDealerId(Long dealerId);

	@Query("SELECT deal FROM VehicleQuotation deal where deal.carSearchId = ?1")
	List<VehicleQuotation> getDealerSearchForID(Long carSearchId);
	
	@Query("SELECT deal FROM VehicleQuotation deal where deal.dealSearchId = ?1 AND deal.dealerId = ?2")
	List<VehicleQuotation> getDealerSearchDealID(Long carSearchId, Long dealerId);
	
	
	@Query("SELECT vehicleQuotation FROM VehicleQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1 AND vehicleQuotation.carSearchId = ?2")
	List<VehicleQuotation> getQuotationsForUserIdEbidId(Long userId, Long carSearchId);
	
	
	@Query("SELECT vehicleQuotation FROM VehicleQuotation vehicleQuotation WHERE vehicleQuotation.userId=?1")
	List<VehicleQuotation> getQuotForUserChat(Long userId);
	
}
