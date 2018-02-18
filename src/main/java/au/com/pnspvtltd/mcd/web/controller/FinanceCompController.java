package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.FinanceCompanyService;
import au.com.pnspvtltd.mcd.service.impl.DealerServiceImpl;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
// @CrossOrigin(origins = "*")
@RestController
public class FinanceCompController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Autowired
	FinanceCompanyService financeCompanyService;

	@GetMapping(value = "financeProv", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getAllFinance() {
		LOGGER.info("Received request to get All FinanceCompany");
		return financeCompanyService.getAllFinance();

	}

}
