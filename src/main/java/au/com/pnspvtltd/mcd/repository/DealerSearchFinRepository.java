package au.com.pnspvtltd.mcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.DealerSearchFinance;

public interface DealerSearchFinRepository extends JpaRepository<DealerSearchFinance, Long> {

	/*@Query("SELECT deal FROM DealerSearchFinance deal where deal.dealer.dealerId = ?1")
	List<DealerSearchFinance> getDealerSearchFinForID(Long dealerID);*/

}
