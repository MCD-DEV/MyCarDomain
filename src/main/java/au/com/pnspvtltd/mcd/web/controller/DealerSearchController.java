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

import au.com.pnspvtltd.mcd.service.DealerSearchService;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
/**
 * @author Sairam Kanjarla
 *
 */

@RestController
public class DealerSearchController {

	private static final Logger LOGGER =
	LoggerFactory.getLogger(DealerSearchController.class);
	

	@Autowired
	DealerSearchService dealerSearchService;
	
	@GetMapping(value = "dealerSearch/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchVO getDealerSearch(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search with id {} ", id);
		return dealerSearchService.findById(id);
	}
	
	
	@PostMapping(value = "post/dealerSearch/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerSearchVO> verify(@RequestBody DealerSearchVO dealerSearchVO,@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Dealer Search lead creation");
		dealerSearchVO = dealerSearchService.createDealerSearch(dealerSearchVO,id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(dealerSearchVO, status);
	}
	

}
