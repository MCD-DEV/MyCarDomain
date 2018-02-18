package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ReviewPoints;

public interface ReviewPointsRepository extends JpaRepository<ReviewPoints, Long> {

	@Query("SELECT search FROM ReviewPoints search" + " ORDER BY search.revPointId")
	public List<ReviewPoints> getAllSearchCriteria();

	@Query("SELECT search FROM ReviewPoints search WHERE search.idp=?1")
	public List<ReviewPoints> getReferByUserId(Long userid);

}
