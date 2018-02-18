package au.com.pnspvtltd.mcd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.CarModelTemplate;
import au.com.pnspvtltd.mcd.repository.CarModelTemplateRepository;
import au.com.pnspvtltd.mcd.service.CarModelTemplateService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

@Service
public class CarModelTemplateServiceImpl implements CarModelTemplateService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(CarModelTemplateServiceImpl.class);

	@Autowired
	private CarModelTemplateRepository carModelTemplateRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	@Transactional(readOnly = true)
	public CarModelTemplateVO getCarModelTemplateFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim) {

		return domainModelUtil.fromCarModelTemplate(
				carModelTemplateRepository.getCarModelTemplateFor(modelYear, modelDisplay, modelName, modelTrim),
				false);
	}

	@Override
	@Transactional
	public CarModelTemplateVO createCarModelTemplate(CarModelTemplateVO carModelTemplateVO) {
		CarModelTemplate carModelTemplate = carModelTemplateRepository
				.save(domainModelUtil.toCarModelTemplate(carModelTemplateVO));
		return domainModelUtil.fromCarModelTemplate(carModelTemplate, true);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarModelTemplateVO> getAllCarModelTemplates() {
		List<CarModelTemplate> carModelTemplates = carModelTemplateRepository.findAll();
		// carModelTemplateRepository.findAll(modelYear)
		List<CarModelTemplateVO> carModelTemplateVOs = new ArrayList<>();
		for (CarModelTemplate carModelTemplate : carModelTemplates) {
			carModelTemplateVOs.add(domainModelUtil.fromCarModelTemplate(carModelTemplate, false));
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

}
