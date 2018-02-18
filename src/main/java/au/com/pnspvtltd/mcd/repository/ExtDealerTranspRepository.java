package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ExtDealerSearchTp;

public interface ExtDealerTranspRepository extends JpaRepository<ExtDealerSearchTp, Long> {

	@Query("SELECT deal FROM ExtDealerSearchTp deal where deal.carSearchId = ?1")
	List<ExtDealerSearchTp> getDealerSearchForID(Long carSearchId);

}
