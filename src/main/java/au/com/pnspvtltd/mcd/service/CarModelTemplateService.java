package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

public interface CarModelTemplateService {

	CarModelTemplateVO getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim);

	List<CarModelTemplateVO> getAllCarModelTemplates();

	CarModelTemplateVO createCarModelTemplate(CarModelTemplateVO carModelTemplateVO);

	List<String> getAllCarModelYears();

	List<String> getAllCarModelMakesForYear(String modelYear);

	List<String> getAllCarModelNamesForMake(String modelDisplay, String modelYear);

	List<String> getAllCarModelVariantsForModel(String modelName, String modelDisplay, String modelYear);
}
