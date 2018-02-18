package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;

public interface TempCarModelTemplateService {

	TempCarModelHeaderVO getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim);

	List<TempCarModelHeaderVO> getAllCarModelTemplates();

	TempCarModelHeaderVO createCarModelTemplate(TempCarModelHeaderVO carModelTemplateVO);

	List<String> getAllCarModelYears();

	List<String> getAllCarModelMakesForYear(String modelYear);

	List<String> getAllCarModelNamesForMake(String modelDisplay, String modelYear);

	List<String> getAllCarModelVariantsForModel(String modelName, String modelDisplay, String modelYear);

	/*
	 * List<String> getAllCarModelTrimForAllSelect(String modelTrim, String
	 * modelName, String modelDisplay, String modelYear);
	 */
	List<String> getAllCarModelTrimForAllSelect(String modelName, String modelDisplay, String modelYear);

	TempCarModelHeaderVO getCarModelTemplateForAutoTrim(String flex1);
}
