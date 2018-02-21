package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchServMaint;
import au.com.pnspvtltd.mcd.domain.DealerSearchTransp;

public interface DealerSearchTranRepository extends JpaRepository<DealerSearchTransp, Long> {

	/*@Query("SELECT deal FROM DealerSearchTransp deal where deal.dealer.dealerId = ?1")
	List<DealerSearchTransp> getDealerSearchTranForID(Long dealerID);*/
	public List<DealerSearchTransp> findByDealer(Dealer dealer);
}
