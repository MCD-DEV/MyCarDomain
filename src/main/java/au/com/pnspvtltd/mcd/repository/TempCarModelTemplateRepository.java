package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.TempCarModelHeader;

public interface TempCarModelTemplateRepository extends JpaRepository<TempCarModelHeader, Long> {

	@Query("SELECT tempCarModelHeader FROM TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelYear=?1 AND tempCarModelHeader.modelDisplay=?2 AND tempCarModelHeader.modelName=?3 AND tempCarModelHeader.modelTrim=?4")
	public TempCarModelHeader getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim);

	@Query("SELECT tempCarModelHeader FROM TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.flex1=?1")
	public TempCarModelHeader getCarModelTemplateForAutoTrim(String flex1);

	public TempCarModelHeader findByFlex1IgnoreCase(String flex1);

	@Query("select distinct tempCarModelHeader.modelYear from TempCarModelHeader tempCarModelHeader order by tempCarModelHeader.modelYear desc")
	public List<String> getAllCarModelYears();

	@Query("select distinct tempCarModelHeader.modelDisplay from TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelYear=?1")
	public List<String> getAllCarModelMakesForYear(String modelYear);

	@Query("select distinct tempCarModelHeader.modelName from TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelDisplay=?1 AND tempCarModelHeader.modelYear=?2")
	public List<String> getAllCarModelNamesForMake(String modelDisplay, String modelYear);

	@Query("select distinct tempCarModelHeader.modelVariant from TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelName=?1 AND tempCarModelHeader.modelDisplay=?2 AND tempCarModelHeader.modelYear=?3")
	public List<String> getAllCarModelVariantsForModel(String modelName, String modelDisplay, String modelYear);

	/*
	 * @Query(
	 * "select tempCarModelHeader.flex1 from TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelVariant=?1 AND tempCarModelHeader.modelName=?2 AND tempCarModelHeader.modelDisplay=?3 AND tempCarModelHeader.modelYear=?4"
	 * ) public List<String> getAllCarModelTrimForAllSelect(String modelVariant,
	 * String modelName, String modelDisplay, String modelYear);
	 */

	@Query("select tempCarModelHeader.flex1 from TempCarModelHeader tempCarModelHeader WHERE tempCarModelHeader.modelName=?1 AND tempCarModelHeader.modelDisplay=?2 AND tempCarModelHeader.modelYear=?3")
	public List<String> getAllCarModelTrimForAllSelect(String modelName, String modelDisplay, String modelYear);

	// public CarModelTemplate getCarModelYear();
}
