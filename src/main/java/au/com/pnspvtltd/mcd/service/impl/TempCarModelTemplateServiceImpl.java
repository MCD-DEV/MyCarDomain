package au.com.pnspvtltd.mcd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.TempCarModelHeader;
import au.com.pnspvtltd.mcd.repository.TempCarModelTemplateRepository;
import au.com.pnspvtltd.mcd.service.TempCarModelTemplateService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;

@Service
public class TempCarModelTemplateServiceImpl implements TempCarModelTemplateService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(TempCarModelTemplateServiceImpl.class);

	@Autowired
	private TempCarModelTemplateRepository carModelTemplateRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	@Transactional(readOnly = true)
	public TempCarModelHeaderVO getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim) {

		return domainModelUtil.fromTempCarModelTemplate(
				carModelTemplateRepository.getCarModelTemplateFor(modelYear, modelDisplay, modelName, modelTrim),
				false);
	}

	@Override
	@Transactional
	public TempCarModelHeaderVO createCarModelTemplate(TempCarModelHeaderVO carModelTemplateVO) {
		TempCarModelHeader carModelTemplate = carModelTemplateRepository
				.save(domainModelUtil.toTempCarModelTemplate(carModelTemplateVO));
		return domainModelUtil.fromTempCarModelTemplate(carModelTemplate, true);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempCarModelHeaderVO> getAllCarModelTemplates() {
		List<TempCarModelHeader> carModelTemplates = carModelTemplateRepository.findAll();
		// carModelTemplateRepository.findAll(modelYear)
		List<TempCarModelHeaderVO> carModelTemplateVOs = new ArrayList<>();
		for (TempCarModelHeader carModelTemplate : carModelTemplates) {
			carModelTemplateVOs.add(domainModelUtil.fromTempCarModelTemplate(carModelTemplate, false));
		}
		return carModelTemplateVOs;
	}

	@Override
	public List<String> getAllCarModelYears() {
		// TODO Auto-generated method stub
		List<String> carModelTemplates = carModelTemplateRepository.getAllCarModelYears();
		return carModelTemplates;
	}

	@Override
	public List<String> getAllCarModelMakesForYear(String modelYear) {
		// TODO Auto-generated method stub
		List<String> carModelTemplates = carModelTemplateRepository.getAllCarModelMakesForYear(modelYear);
		return carModelTemplates;
	}

	@Override
	public List<String> getAllCarModelNamesForMake(String modelDisplay, String modelYear) {
		// TODO Auto-generated method stub
		List<String> carModelTemplates = carModelTemplateRepository.getAllCarModelNamesForMake(modelDisplay, modelYear);
		return carModelTemplates;
	}

	@Override
	public List<String> getAllCarModelVariantsForModel(String modelName, String modelDisplay, String modelYear) {
		// TODO Auto-generated method stub
		List<String> carModelTemplates = carModelTemplateRepository.getAllCarModelVariantsForModel(modelName,
				modelDisplay, modelYear);
		return carModelTemplates;
	}

	/*
	 * @Override public List<String> getAllCarModelTrimForAllSelect(String
	 * modelTrim, String modelName, String modelDisplay, String modelYear) { //
	 * TODO Auto-generated method stub List<String> carModelTemplates =
	 * carModelTemplateRepository.getAllCarModelTrimForAllSelect(modelTrim,
	 * modelName,modelDisplay,modelYear); return carModelTemplates; }
	 */

	@Override
	public List<String> getAllCarModelTrimForAllSelect(String modelName, String modelDisplay, String modelYear) {
		// TODO Auto-generated method stub
		List<String> carModelTemplates = carModelTemplateRepository.getAllCarModelTrimForAllSelect(modelName,
				modelDisplay, modelYear);
		return carModelTemplates;
	}

	@Override
	public TempCarModelHeaderVO getCarModelTemplateForAutoTrim(String flex1) {
		return domainModelUtil.fromTempCarModelTemplate(carModelTemplateRepository.findByFlex1IgnoreCase(flex1), false);
	}

}
