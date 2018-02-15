package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearch;
import au.com.pnspvtltd.mcd.domain.ExtDealServMaint;
import au.com.pnspvtltd.mcd.domain.ExtDealServMaintr1;
import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;
import au.com.pnspvtltd.mcd.domain.ExternalDealer;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.web.model.DealerVO;

public interface ExtDealerServMaintPRepository extends JpaRepository<ExtDealServMaint, Long>{
	
	@Query("SELECT search FROM ExtDealServMaint search WHERE search.category=?1 AND search.postCode=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExtDealServMaint> getSearchCatPost(String category, int postCode);
	
	@Query("SELECT search FROM ExtDealServMaint search WHERE search.category=?1 AND search.state=?2" +
			" ORDER BY search.externalDealerId")
			public List<ExtDealServMaint> getSearchCatSt(String category, String state);
	

}
