package au.com.pnspvtltd.mcd.web.controller;

import java.util.ArrayList;
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
import au.com.pnspvtltd.mcd.service.FinanceCompanyService;
import au.com.pnspvtltd.mcd.service.InsuranceCompanyService;
import au.com.pnspvtltd.mcd.service.ServiceLevelService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

@RestController
public class InsuranceCompController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	InsuranceCompanyService insuranceCompanyService;

	
	@GetMapping(value = "insuranceProv", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllInsurance() {
		LOGGER.info("Received request to get All InsuranceCompany");
		return insuranceCompanyService.getAllInsurnce();

	}
	
	
	
	

}
