package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExternalDealer;
import au.com.pnspvtltd.mcd.domain.ExternalDealerTp;


public interface ExternalDealerTpRepository extends JpaRepository<ExternalDealerTp, Long>{

	
	
	@Query("SELECT search FROM ExternalDealerTp search WHERE search.postCode=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerTp> getSearchPostCd(int postCode);
	
	@Query("SELECT search FROM ExternalDealerTp search WHERE search.companyName=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerTp> getSearchComp(String companyName);
	
	@Query("SELECT search FROM ExternalDealerTp search WHERE search.category=?1 AND search.postCode=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerTp> getSearchCatPost(String category, int postCode);
	
	@Query("SELECT search FROM ExternalDealerTp search WHERE search.category=?1 AND search.state=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerTp> getSearchCatPost(String category, String state);
		
}
