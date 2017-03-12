package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.CarModelTemplateService;
import au.com.pnspvtltd.mcd.service.CountyRegPostSubService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

@RestController
public class CountyRegPostSubController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	CountyRegPostSubService countyRegPostSubService;

	
	@GetMapping(value = "countries", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllCountries() {
		LOGGER.info("Received request to get All Countries");
		return countyRegPostSubService.getAllCountries();

	}
	
	//Makes in select box
	@GetMapping(value = "states", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllStatesForCountry(@RequestParam("country") String country) {
		LOGGER.info("Received request to get All States");
		return countyRegPostSubService.getAllStatesForCountry(country);

	}
	
	//MODEL in Select Box
	@GetMapping(value = "regions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllRegionsForCountynState(@RequestParam("country") String country,@RequestParam("state") String state) {
		LOGGER.info("Received request to get All regions");
		return countyRegPostSubService.getAllRegionsForCountynState(country,state);

	}
	
	//String modelName,String modelDisplay,String modelYear
	//Variant in Select Box
		@GetMapping(value = "postcodes", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<Integer> getPostCodeForCSR(@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("region") String region) {
			LOGGER.info("Received request to get All postcodes");
			return countyRegPostSubService.getPostCodeForCSR(country,state,region);

		}

}
