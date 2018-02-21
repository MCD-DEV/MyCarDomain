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

import au.com.pnspvtltd.mcd.repository.DealerSearchFinRepository;
import au.com.pnspvtltd.mcd.service.DealerFinService;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;
/**
 * @author Sairam Kanjarla
 *
 */
@CrossOrigin
@RestController
public class DealerFinController {

	private static final Logger LOGGER =
	LoggerFactory.getLogger(DealerFinController.class);
	
	@Autowired
	DealerFinService dealerFinService;
	
	@Autowired
	DealerService dealerService;
	
	@GetMapping(value = "dealerSearchFin/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DealerSearchFinanceVO getDealerSearchFin(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search with id {} ", id);
		return dealerFinService.findById(id);
	}
	
	@GetMapping(value = "dealer/{id}/dealerSearchFin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DealerSearchFinanceVO> getDealSearchFin(@PathVariable Long id) {
		LOGGER.debug("Received request to get Dealer Search Ins with id {} ", id);
		return dealerService.getDealerSearchFin(id);
	}
	
	
	
	@PostMapping(value = "post/dealerFin/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DealerSearchFinanceVO> createDealerSearchFin(@RequestBody DealerSearchFinanceVO dealerSearchFinanceVO, @PathVariable Long id,HttpServletResponse response) {
		LOGGER.debug("Dealer Finance lead creation");
		dealerSearchFinanceVO = dealerFinService.createDealerSearchFin(dealerSearchFinanceVO, id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(dealerSearchFinanceVO, status);
	}
	

}
