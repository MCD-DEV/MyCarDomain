package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;
import au.com.pnspvtltd.mcd.domain.DealerSearchInsurance;
import au.com.pnspvtltd.mcd.domain.DealerSearchTransp;

public interface DealerSearchInsRepository extends JpaRepository<DealerSearchInsurance, Long> {

	/*@Query("SELECT deal FROM DealerSearchInsurance deal where deal.dealer.dealerId = ?1")
	List<DealerSearchInsurance> getDealerSearchInsForID(Long dealerID);*/
	public List<DealerSearchInsurance> findByDealer(Dealer dealer);
}
