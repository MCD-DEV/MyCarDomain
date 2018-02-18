package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ReferencedPoints;

public interface ReferencedPointsRepository extends JpaRepository<ReferencedPoints, Long> {

	@Query("SELECT search FROM ReferencedPoints search" + " ORDER BY search.referPointId")
	public List<ReferencedPoints> getAllSearchCriteria();

	@Query("SELECT search FROM ReferencedPoints search WHERE search.status=?1" + " ORDER BY search.referPointId")
	public List<ReferencedPoints> getAllCriteria(boolean status);

	@Query("SELECT search FROM ReferencedPoints search WHERE search.idp=?1")
	public List<ReferencedPoints> getReferByUserId(Long userid);

}
