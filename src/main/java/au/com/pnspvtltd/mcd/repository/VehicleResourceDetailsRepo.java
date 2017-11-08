package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetails;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;

public interface VehicleResourceDetailsRepo extends JpaRepository<VehicleResourceDetails, Long> {

	
	
	@Query("SELECT inv FROM Inventory inv WHERE inv.userId=?1 AND inv.refId=?2" +
			" ORDER BY inv.repoId")
			public List<Inventory> getAllInvForSellMy(Long id, Long dealerId);
}
