/**
 * 
 */
package au.com.pnspvtltd.mcd.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.DealerInsService;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;

/**
 * @author Sairam Kanjarla
 *
 */

@RestController
public class DealerInsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerInsController.class);

	@Autowired
	DealerInsService dealerInsService;

	@GetMapping(value = "dealerSearchIns/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchInsuranceVO getDealerSearchIns(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search Insurance with id {} ", id);
		return dealerInsService.findById(id);
	}

	@PostMapping(value = "post/dealerIns/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerSearchInsuranceVO> verify(@RequestBody DealerSearchInsuranceVO dealerSearchInsuranceVO,@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Dealer Insurance Lead creation");
		dealerSearchInsuranceVO = dealerInsService.createDealerSearchIns(dealerSearchInsuranceVO, id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(dealerSearchInsuranceVO, status);
	}

}
