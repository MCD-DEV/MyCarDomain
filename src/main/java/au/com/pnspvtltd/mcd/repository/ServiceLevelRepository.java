package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ServiceLevel1L2;

public interface ServiceLevelRepository extends JpaRepository<ServiceLevel1L2, Long> {

	String JDBC_MAX_ROWS = "10";

	@Query("select distinct servmaintl1l2.servMaintLv1 from ServiceLevel1L2 servmaintl1l2 order by servmaintl1l2.servMaintLv1 Asc")
	public List<String> getAllLevels();

	@Query("select distinct servmaintl1l2.servMaintLv2 from ServiceLevel1L2 servmaintl1l2 WHERE servmaintl1l2.servMaintLv1=?1")
	public List<String> getAllLevel2(String level1);

}
