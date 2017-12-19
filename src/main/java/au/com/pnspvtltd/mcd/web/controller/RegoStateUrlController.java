package au.com.pnspvtltd.mcd.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import au.com.pnspvtltd.mcd.service.RegoStateUrlService;

import au.com.pnspvtltd.mcd.web.model.RegoStateUrlVO;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
public class RegoStateUrlController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegoStateUrlController.class);
	@Autowired
	RegoStateUrlService inventoryService;

	@GetMapping(value = "regostateurl/getRegoStateUrlFor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public RegoStateUrlVO getRegoStateUrlFor(@RequestParam("vehState") String vehState,
			@RequestParam("vehType") String vehType) {

		return inventoryService.getRegoStateUrlFor(vehState, vehType);

	}

}
