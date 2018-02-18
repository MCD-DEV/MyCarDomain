package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.CarModelTemplate;

public interface CarModelTemplateRepository extends JpaRepository<CarModelTemplate, Long> {

	@Query("SELECT carModelTemplate FROM CarModelTemplate carModelTemplate WHERE carModelTemplate.modelYear=?1 AND carModelTemplate.modelDisplay=?2 AND carModelTemplate.modelName=?3 AND carModelTemplate.modelTrim=?4")
	public CarModelTemplate getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim);

	@Query("select distinct carModelTemplate.modelYear from CarModelTemplate carModelTemplate order by carModelTemplate.modelYear desc")
	public List<String> getAllCarModelYears();

	@Query("select carModelTemplate.modelDisplay from CarModelTemplate carModelTemplate WHERE carModelTemplate.modelYear=?1")
	public List<String> getAllCarModelMakesForYear(String modelYear);

	@Query("select carModelTemplate.modelName from CarModelTemplate carModelTemplate WHERE carModelTemplate.modelDisplay=?1 AND carModelTemplate.modelYear=?2")
	public List<String> getAllCarModelNamesForMake(String modelDisplay, String modelYear);

	@Query("select carModelTemplate.modelTrim from CarModelTemplate carModelTemplate WHERE carModelTemplate.modelName=?1 AND carModelTemplate.modelDisplay=?2 AND carModelTemplate.modelYear=?3")
	public List<String> getAllCarModelVariantsForModel(String modelName, String modelDisplay, String modelYear);

	// public CarModelTemplate getCarModelYear();
}
