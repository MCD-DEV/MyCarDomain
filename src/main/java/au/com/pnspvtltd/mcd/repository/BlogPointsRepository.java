package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.BlogPoints;

public interface BlogPointsRepository extends JpaRepository<BlogPoints, Long> {

	@Query("SELECT search FROM BlogPoints search" + " ORDER BY search.blogPointId")
	public List<BlogPoints> getAllSearchCriteria();

	@Query("SELECT search FROM BlogPoints search WHERE search.idp=?1")
	public List<BlogPoints> getReferByUserId(Long userid);

}
