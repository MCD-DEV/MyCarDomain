package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.TempCarModelTemplateService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;
//@CrossOrigin(origins = "http://localhost:8018")
@RestController
public class TempCarModelTemplateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	TempCarModelTemplateService carModelTemplateService;

	@GetMapping(value = "tempCarModelTemplateFor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TempCarModelHeaderVO getCarModelTemplateFor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName,
			@RequestParam("modelTrim") String modelTrim) {

		LOGGER.info("Received request to get a TempCarModelTemplate for");
		return carModelTemplateService.getCarModelTemplateFor(modelYear, modelDisplay, modelName, modelTrim);
	}

	@PostMapping(value = "tempCarModelTemplate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TempCarModelHeaderVO createCarModelTemplate(@RequestBody TempCarModelHeaderVO carModelTemplateVO) {
		LOGGER.info("Received request to create TempCarModelTemplate");
		return carModelTemplateService.createCarModelTemplate(carModelTemplateVO);
	}

	@GetMapping(value = "tempCarModelTemplate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TempCarModelHeaderVO> getAllCarModelTemplates() {
		LOGGER.info("Received request to get All TempCarModelTemplates");
		return carModelTemplateService.getAllCarModelTemplates();

	}
	
	@GetMapping(value = "tempCarModelYears", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelYears() {
		LOGGER.info("Received request to get All TempCarModelYears");
		return carModelTemplateService.getAllCarModelYears();

	}
	
	//Makes in select box
	@GetMapping(value = "tempCarModelMakesForYear", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelMakesForYear(@RequestParam("modelYear") String modelYear) {
		LOGGER.info("Received request to get All TempCarModelMakes");
		return carModelTemplateService.getAllCarModelMakesForYear(modelYear);

	}
	
	//MODEL in Select Box
	@GetMapping(value = "tempCarModelNamesForMake", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCarModelNamesForMake(@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
		LOGGER.info("Received request to get All TempCarModelNames");
		return carModelTemplateService.getAllCarModelNamesForMake(modelDisplay,modelYear);

	}
	
	//String modelName,String modelDisplay,String modelYear
	//Variant in Select Box
		@GetMapping(value = "tempCarModelVariantForModel", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<String> getAllCarModelVariantsForModel(@RequestParam("modelName") String modelName,@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
			LOGGER.info("Received request to get All TempCarModelvariant");
			return carModelTemplateService.getAllCarModelVariantsForModel(modelName,modelDisplay,modelYear);

		}
		
		//String modelName,String modelDisplay,String modelYear
		//Variant in Select Box
			/*@GetMapping(value = "tempCarModelTrimForAllSelect", produces = { MediaType.APPLICATION_JSON_VALUE })
			public List<String> getAllCarModelTrimForAllSelect(@RequestParam("modelTrim") String modelTrim,@RequestParam("modelName") String modelName,@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
				LOGGER.info("Received request to get All TempCarModelvariant");
				return carModelTemplateService.getAllCarModelTrimForAllSelect(modelTrim,modelName,modelDisplay,modelYear);

			}*/
			
			@GetMapping(value = "tempCarModelTrimForAllSelect", produces = { MediaType.APPLICATION_JSON_VALUE })
			public List<String> getAllCarModelTrimForAllSelect(@RequestParam("modelName") String modelName,@RequestParam("modelDisplay") String modelDisplay,@RequestParam("modelYear") String modelYear) {
				LOGGER.info("Received request to get All TempCarModelvariantch");
				return carModelTemplateService.getAllCarModelTrimForAllSelect(modelName,modelDisplay,modelYear);

			}
			
			
			// get tempCarModelHeader for given AutoscoopTrim
			//String modelName,String modelDisplay,String modelYear
			//Variant in Select Box
			@GetMapping(value = "tempCarModelTemplateForAutoTrim", produces = { MediaType.APPLICATION_JSON_VALUE })
			public TempCarModelHeaderVO getCarModelTemplateForAutoTrim(String flex1) {

				LOGGER.info("Received request to get a TempCarModelTemplate for");
				return carModelTemplateService.getCarModelTemplateForAutoTrim(flex1);
			}		
			

}
