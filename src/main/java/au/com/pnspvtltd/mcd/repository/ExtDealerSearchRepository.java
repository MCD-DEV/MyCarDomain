package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearch;

public interface ExtDealerSearchRepository extends JpaRepository<ExtDealerSearch, Long> {

	@Query("SELECT deal FROM ExtDealerSearch deal where deal.carSearchId = ?1")
	List<ExtDealerSearch> getDealerSearchForID(Long carSearchId);

}
