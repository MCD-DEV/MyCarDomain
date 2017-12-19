package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
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
import au.com.pnspvtltd.mcd.service.CountyRegPostSubService;
import au.com.pnspvtltd.mcd.service.ServiceLevelService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "*")
@RestController
public class ServiceLevelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	ServiceLevelService serviceLevelService;

	
	@GetMapping(value = "level1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllLevels() {
		LOGGER.info("Received request to get All level1");
		return serviceLevelService.getAllLevels();

	}
	
	
	//MODEL in Select Box
	@GetMapping(value = "level2", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> existsLevel2ForLevel1(@RequestParam("level1") String level1) {
		LOGGER.info("Received request to get All level2");
		return serviceLevelService.existsLevel2ForLevel1(level1);

	}
	
	

}
