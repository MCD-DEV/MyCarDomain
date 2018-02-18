package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearchFin;

public interface ExtDealerFinRepository extends JpaRepository<ExtDealerSearchFin, Long> {

	@Query("SELECT deal FROM ExtDealerSearchFin deal where deal.carSearchId = ?1")
	List<ExtDealerSearchFin> getDealerSearchForID(Long carSearchId);

}
