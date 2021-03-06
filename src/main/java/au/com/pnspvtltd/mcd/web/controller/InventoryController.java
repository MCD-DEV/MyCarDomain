package au.com.pnspvtltd.mcd.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.InventoryService;
import au.com.pnspvtltd.mcd.web.model.InventoryStatisticsVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelColourVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;

//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "http://springbootaws-env.yh4cnzetmj.us-east-1.elasticbeanstalk.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
@CrossOrigin
@RestController
public class InventoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	InventoryService inventoryService;

	@GetMapping(value = "inventory/getStatisticsFor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public InventoryStatisticsVO getStatisticsFor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName,
			@RequestParam("autoscoopTrim") String autoscoopTrim) {

		return inventoryService.getStatisticsFor(modelYear, modelDisplay, modelName, autoscoopTrim);

	}

	@GetMapping(value = "inventory/getColorFor", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TempCarModelColourVO> getColorFor(@RequestParam("modelYear") String modelYear,
			@RequestParam("modelDisplay") String modelDisplay, @RequestParam("modelName") String modelName,
			@RequestParam("autoscoopTrim") String autoscoopTrim) {
		TempCarModelHeaderVO tempVO = inventoryService.getColorFor(modelYear, modelDisplay, modelName, autoscoopTrim);

		return tempVO.getCarModel3();

	}

	@GetMapping(value = "inventory/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public InventoryVO getInventoryUnique(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get Dealer Inventory with unique id {} ", id);

		InventoryVO dealer = inventoryService.findById(id);
		if (dealer == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return dealer;

	}

}
