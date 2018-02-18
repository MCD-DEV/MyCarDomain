package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
	Dealer findByEmailIgnoreCase(String emailId);

	@Query("SELECT deal FROM Dealer deal WHERE deal.financer=?1")
	public List<Dealer> getDealerForFinance(boolean isFinancer);

	@Query("SELECT deal FROM Dealer deal WHERE deal.insurer=?1")
	public List<Dealer> getDealerForInsurance(boolean isInsurancer);

	@Query("SELECT deal FROM Dealer deal")
	public List<Dealer> getDealerForMake();

	@Query("SELECT deal.dealerId FROM Dealer deal")
	public List<Long> getDealerIDs();

	@Query("SELECT deal FROM Dealer deal where deal.dealerId = ?1")
	Dealer getDealerForID(Long dealerID);

}
