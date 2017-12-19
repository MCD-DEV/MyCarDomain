package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.CarModelTemplateService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
@CrossOrigin
@RestController
public class CarModelTemplateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	CarModelTemplateService carModelTemplateService;

	@GetMapping(value = "carModelTemplateFor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CarModelTemplateVO getCarModelTemplateFor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName,
			@RequestParam("modelTrim") String modelTrim) {

		LOGGER.info("Received request to get a CarModelTemplate for");
		return carModelTemplateService.getCarModelTemplateFor(modelYear, modelDisplay, modelName, modelTrim);
	}

	@PostMapping(value = "carModelTemplate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CarModelTemplateVO createCarModelTemplate(@RequestBody CarModelTemplateVO carModelTemplateVO) {
		LOGGER.info("Received request to create CarModelTemplate");
		return carModelTemplateService.createCarModelTemplate(carModelTemplateVO);
	}

	@GetMapping(value = "carModelTemplate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CarModelTemplateVO> getAllCarModelTemplates() {
		LOGGER.info("Received request to get All CarModelTemplates");
		return carModelTemplateService.getAllCarModelTemplates();

	}
	
	@GetMapping(value = "carModelYears", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelYears() {
		LOGGER.info("Received request to get All CarModelYears");
		return carModelTemplateService.getAllCarModelYears();

	}
	
	//Makes in select box
	@GetMapping(value = "carModelMakesForYear", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelMakesForYear(@RequestParam("modelYear") String modelYear) {
		LOGGER.info("Received request to get All CarModelMakes");
		return carModelTemplateService.getAllCarModelMakesForYear(modelYear);

	}
	
	//MODEL in Select Box
	@GetMapping(value = "carModelNamesForMake", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelNamesForMake(@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
		LOGGER.info("Received request to get All CarModelNames");
		return carModelTemplateService.getAllCarModelNamesForMake(modelDisplay,modelYear);

	}
	
	//String modelName,String modelDisplay,String modelYear
	//Variant in Select Box
		@GetMapping(value = "carModelVariantForModel", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<String> getAllCarModelVariantsForModel(@RequestParam("modelName") String modelName,@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
			LOGGER.info("Received request to get All CarModelvariant");
			return carModelTemplateService.getAllCarModelVariantsForModel(modelName,modelDisplay,modelYear);

		}

}
