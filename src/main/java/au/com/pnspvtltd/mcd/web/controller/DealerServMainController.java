/**
 * 
 */
package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.service.DealerSnMService;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;
import au.com.pnspvtltd.mcd.web.model.FinanceEntityVO;

/**
 * @author Sairam Kanjarla
 *
 */
@CrossOrigin
@RestController
public class DealerServMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerServMainController.class);

	@Autowired
	DealerSnMService dealerSnMService;
	
	@Autowired
	DealerService dealerService;

	@GetMapping(value = "dealerSearchSnM/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchServMaintVO getDealerSearchFin(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search with id {} ", id);
		return dealerSnMService.findById(id);
	}

	@GetMapping(value = "dealer/{id}/dealerSearchSnM", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchServMaintVO> getDealerSearchSnM(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search SnM with id {} ", id);
		return dealerService.getDealerSearchSnM(id);
	}
	
	
	
	@PostMapping(value = "post/dealerSnM/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerSearchServMaintVO> verify(@RequestBody DealerSearchServMaintVO dealerSearchServMaintVO,
			@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Dealer Serv & Maint lead creation");
		dealerSearchServMaintVO = dealerSnMService.createDealerSearchSnM(dealerSearchServMaintVO, id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(dealerSearchServMaintVO, status);
	}

}
