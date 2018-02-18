package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearchIns;

public interface ExtDealerInsRepository extends JpaRepository<ExtDealerSearchIns, Long> {

	@Query("SELECT deal FROM ExtDealerSearchIns deal where deal.carSearchId = ?1")
	List<ExtDealerSearchIns> getDealerSearchForID(Long carSearchId);

}
