package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.DealerSearchServMaint;
import au.com.pnspvtltd.mcd.domain.VehicleDealerInsuranceDetails;

public interface DealerSearchSnMRepository extends JpaRepository<DealerSearchServMaint, Long> {

	/*@Query("SELECT deal FROM DealerSearchServMaint deal where deal.dealer.dealerId = ?1")
	List<DealerSearchServMaint> getDealerSearchSnMForID(Long dealerID);*/
	public List<DealerSearchServMaint> findByDealer(Dealer dealer);
}
