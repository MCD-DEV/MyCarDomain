package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.ValTransPoints;

public interface ValTransPointsRepository extends JpaRepository<ValTransPoints, Long> {

	@Query("SELECT search FROM ValTransPoints search" + " ORDER BY search.valTransPointId")
	public List<ValTransPoints> getAllSearchCriteria();

	@Query("SELECT search FROM ValTransPoints search WHERE search.status=?1 and search.typeOfTrans=?2"
			+ " ORDER BY search.valTransPointId")
	public List<ValTransPoints> getAllCriteria(boolean status, String buy);

	@Query("SELECT search FROM ValTransPoints search WHERE search.idp=?1")
	public List<ValTransPoints> getReferByUserId(Long userid);

}
