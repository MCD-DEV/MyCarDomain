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
import au.com.pnspvtltd.mcd.service.DealerTransService;
import au.com.pnspvtltd.mcd.web.model.DealerSearchServMaintVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchTranspVO;

/**
 * @author Sairam Kanjarla
 *
 */
@CrossOrigin
@RestController
public class DealerTransController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerTransController.class);

	@Autowired
	DealerTransService dealerTransService;
	
	@Autowired
	DealerService dealerService;

	@GetMapping(value = "dealerSearchTrans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchTranspVO getDealerSearchTrans(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search Trans with id {} ", id);
		return dealerTransService.findById(id);
	}

	@GetMapping(value = "dealer/{id}/dealerSearchTrans", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchTranspVO> getDealeSearchTrans(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search trans with id {} ", id);
		return dealerService.getDealerSearchTrans(id);
	}
	
	@PostMapping(value = "post/dealerTrans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerSearchTranspVO> verify(@RequestBody DealerSearchTranspVO dealerSearchTranspVO,
			@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Dealer transport lead creation");
		dealerSearchTranspVO = dealerTransService.createDealerSearchTrans(dealerSearchTranspVO, id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(dealerSearchTranspVO, status);
	}

}
