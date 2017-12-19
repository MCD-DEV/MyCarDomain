package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.CarModelTemplateService;
import au.com.pnspvtltd.mcd.service.CountyRegPostSubService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "*")
@CrossOrigin
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
	
	
	
	@GetMapping(value = "statePostcode", produces = { MediaType.APPLICATION_JSON_VALUE })
	public boolean existsPostcodeForState(@RequestParam("state") String state,@RequestParam("postcode") int postcode) {
		LOGGER.info("Received request to get bool for state postcode existence");
		return countyRegPostSubService.existsPostcodeForState(state,postcode);

	}
	
	

	@GetMapping(value = "regionPostcode", produces = { MediaType.APPLICATION_JSON_VALUE })
	public boolean existsPostcodeForRegion(@RequestParam("region") String region,@RequestParam("postcode") int postcode) {
		LOGGER.info("Received request to get bool for region postcode existence");
		return countyRegPostSubService.existsPostcodeForRegion(region,postcode);

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
	
	@GetMapping(value = "regions/CountryStates", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getRegionForCountryStates(@RequestParam("country") String country,@RequestParam("states") List<String> states)
	{
		LOGGER.info("Received request to get All regions for Country & States");
		return countyRegPostSubService.getRegionForCountryStates(country,states);
	}
	
	@GetMapping(value = "postcodes/CountryStatesRegions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Integer> getPostcodesForCountryStatesRegions(@RequestParam("country") String country,@RequestParam("states") List<String> states,@RequestParam("regions") List<String> regions){
		LOGGER.info("Received request to get All regions for Country & States & Regions");
		return countyRegPostSubService.getPostcodesForCountryStatesRegions(country,states,regions);
	}
	//String modelName,String modelDisplay,String modelYear
	//Variant in Select Box
		@GetMapping(value = "postcodes", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<Integer> getPostCodeForCSR(@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("region") String region) {
			LOGGER.info("Received request to get All postcodes for criteria");
			return countyRegPostSubService.getPostCodeForCSR(country,state,region);

		}
		
		
		@GetMapping(value = "postcodesLike", produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<Integer> getPostCodeForLike(@RequestParam("substr") String substr) {
			LOGGER.info("Received request to get All postcodes for like");
			List<Integer> sl= countyRegPostSubService.getPostCodeForLike(substr);
			List<Integer> s2 = new ArrayList<Integer>(10);
			for(int i=0;i<10 && i <sl.size();i++)
			{
				s2.add(sl.get(i));
			}
			return s2;
		}

}
