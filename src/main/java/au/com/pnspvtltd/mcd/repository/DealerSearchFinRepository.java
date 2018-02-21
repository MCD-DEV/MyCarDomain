package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;
import au.com.pnspvtltd.mcd.domain.DealerSearchInsurance;

public interface DealerSearchFinRepository extends JpaRepository<DealerSearchFinance, Long> {

	/*@Query("SELECT deal FROM DealerSearchFinance deal where deal.dealer.dealerId = ?1")
	List<DealerSearchFinance> getDealerSearchFinForID(Long dealerID);*/
	public List<DealerSearchFinance> findByDealer(Dealer dealer);
}
