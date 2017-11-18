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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.domain.MyVehicle;
import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;
import au.com.pnspvtltd.mcd.repository.MyVehicleRepository;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.service.MyVehicleService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleFuelCardStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleLogBookVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleServMaintStoreVO;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
@CrossOrigin(origins = "http://localhost:8018")
@RestController
public class MyVehicleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyVehicleController.class);
	
	@Autowired
	MyVehicleService myVehicleService;
	@Autowired
	MyVehicleRepository myVehicleRepository;
	@Autowired
	private DomainModelUtil domainModelUtil;
	
	
	@PostMapping("myvehicle/addMyVehicleLogBook")
	public String addMyVehicleLogBook(@RequestBody MyVehicleLogBookStoreVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add myvehicle log book by the myvehicle with Id {}"+inventoryVO.getMyVehicleId());
		response.setStatus(HttpStatus.CREATED.value());
		return myVehicleService.addMyVehicleLogBook(inventoryVO);
	}

	
	@GetMapping(value = "Myvehicle/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MyVehicleVO getMyVehicleLogBook(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get myvehicle log book by the myvehicle with Id {}");
		MyVehicle myVehicle = myVehicleRepository.findOne(id);
		System.out.println(myVehicle.toString());
		MyVehicleVO myVehicleVO= new MyVehicleVO();
		if (myVehicle != null) {
			System.out.println(myVehicle.getMyVehicleId());
			myVehicleVO = domainModelUtil.FromMyVehicle(myVehicle);
			//response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return myVehicleVO;
	}

	
	
	@PostMapping("myvehicle/addMyVehicleFuelExpenses")
	public String addMyVehicleFuelExpenses(@RequestBody MyVehicleFuelCardStoreVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add myvehicle fuel Expenses by the myvehicle with Id {}"+inventoryVO.getMyVehicleId());
		response.setStatus(HttpStatus.CREATED.value());
		return myVehicleService.addMyVehicleFuelExpenses(inventoryVO);
	}

	
	@PostMapping("myvehicle/addMyVehicleServMaint")
	public String addMyVehicleServMaint(@RequestBody MyVehicleServMaintStoreVO inventoryVO, HttpServletResponse response) {
		LOGGER.debug("Received request to add myvehicle serv maint by the myvehicle with Id {}"+inventoryVO.getMyVehicleId());
		response.setStatus(HttpStatus.CREATED.value());
		return myVehicleService.addMyVehicleServMaint(inventoryVO);
	}
	
}
