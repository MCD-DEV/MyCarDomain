package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.UserReferPoints;

public interface UserReferPointsRepository extends JpaRepository<UserReferPoints, Long> {

	@Query("SELECT search FROM UserReferPoints search" + " ORDER BY search.userReferPointId")
	public List<UserReferPoints> getAllSearchCriteria();

	@Query("SELECT search FROM UserReferPoints search WHERE search.status=?1" + " ORDER BY search.userReferPointId")
	public List<UserReferPoints> getAllCriteria(boolean status);

	@Query("SELECT search FROM UserReferPoints search WHERE search.idp=?1")
	public List<UserReferPoints> getReferByUserId(Long userid);

}
