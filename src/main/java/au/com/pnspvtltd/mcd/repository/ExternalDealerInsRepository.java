package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExternalDealer;
import au.com.pnspvtltd.mcd.domain.ExternalDealerFin;
import au.com.pnspvtltd.mcd.domain.ExternalDealerIns;
import au.com.pnspvtltd.mcd.domain.ExternalDealerTp;


public interface ExternalDealerInsRepository extends JpaRepository<ExternalDealerIns, Long>{

	
	
	@Query("SELECT search FROM ExternalDealerIns search WHERE search.postCode=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerIns> getSearchPostCd(int postCode);
	
	@Query("SELECT search FROM ExternalDealerIns search WHERE search.companyName=?1" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerIns> getSearchComp(String companyName);
	
	@Query("SELECT search FROM ExternalDealerIns search WHERE search.category=?1 AND search.postCode=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerIns> getSearchCatPost(String category, int postCode);
	
	@Query("SELECT search FROM ExternalDealerIns search WHERE search.category=?1 AND search.state=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExternalDealerIns> getSearchCatSt(String category, String state);
		
}
