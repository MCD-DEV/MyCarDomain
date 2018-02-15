package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExternalDealer;
import au.com.pnspvtltd.mcd.domain.ExternalDealerFin;
import au.com.pnspvtltd.mcd.domain.ExternalDealerTp;


public interface ExternalDealerFinRepository extends JpaRepository<ExternalDealerFin, Long>{

	
	
	@Query("SELECT search FROM ExternalDealerFin search WHERE search.postCode=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerFin> getSearchPostCd(int postCode);
	
	@Query("SELECT search FROM ExternalDealerFin search WHERE search.companyName=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerFin> getSearchComp(String companyName);
	
	@Query("SELECT search FROM ExternalDealerFin search WHERE search.category=?1 AND search.postCode=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerFin> getSearchCatPost(String category, int postCode);
	
	@Query("SELECT search FROM ExternalDealerFin search WHERE search.category=?1 AND search.state=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerFin> getSearchCatPost(String category, String state);
		
}
