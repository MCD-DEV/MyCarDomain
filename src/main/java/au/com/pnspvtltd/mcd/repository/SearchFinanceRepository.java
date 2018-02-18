package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.SearchFinance;

public interface SearchFinanceRepository extends JpaRepository<SearchFinance, Long> {

	@Query("SELECT search FROM SearchFinance search" + " ORDER BY search.searchFinanceId")
	public List<SearchFinance> getAllSearchCriteria();

	@Query("SELECT search FROM SearchFinance search WHERE search.idp=?1")
	public List<SearchFinance> getFinanceByUserId(Long userid);

}
