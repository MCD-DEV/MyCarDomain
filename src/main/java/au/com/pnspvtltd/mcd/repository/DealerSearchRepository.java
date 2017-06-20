package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.web.model.DealerVO;

public interface DealerSearchRepository extends JpaRepository<DealerSearch, Long>{
	
	@Query("SELECT deal FROM DealerSearch deal where deal.carSearchId = ?1")
	List<DealerSearch> getDealerSearchForID(Long dealerID);
	

}
