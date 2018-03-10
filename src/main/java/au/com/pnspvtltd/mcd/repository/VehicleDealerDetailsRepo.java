package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.VehicleDealerDetails;

public interface VehicleDealerDetailsRepo extends JpaRepository<VehicleDealerDetails, Long>{
	
	
	@Query("SELECT ds.dealer.dealerId FROM VehicleDealerDetails ds where ds.subscriptionType = ?1")
	public List<Long> getDealerIDs(String subscriptionType);
	
	

}
