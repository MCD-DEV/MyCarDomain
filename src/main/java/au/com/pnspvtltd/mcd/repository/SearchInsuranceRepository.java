package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.SearchInsurance;

public interface SearchInsuranceRepository extends JpaRepository<SearchInsurance, Long> {

	@Query("SELECT search FROM SearchInsurance search" + " ORDER BY search.searchInsuranceId")
	public List<SearchInsurance> getAllSearchCriteria();

	@Query("SELECT search FROM SearchInsurance search WHERE search.idp=?1")
	public List<SearchInsurance> getInsuranceByUserId(Long userid);

}
