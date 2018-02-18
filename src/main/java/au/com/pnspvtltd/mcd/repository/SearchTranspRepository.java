package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.SearchTransp;

public interface SearchTranspRepository extends JpaRepository<SearchTransp, Long> {

	@Query("SELECT search FROM SearchTransp search" + " ORDER BY search.searchTranspId")
	public List<SearchTransp> getAllSearchCriteria();

	@Query("SELECT search FROM SearchTransp search WHERE search.idp=?1")
	public List<SearchTransp> getTranspByUserId(Long userid);

}
