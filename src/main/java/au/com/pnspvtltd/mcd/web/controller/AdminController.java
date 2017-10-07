package au.com.pnspvtltd.mcd.web.controller;

import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.AdminService;
import au.com.pnspvtltd.mcd.service.DealerService;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;


@RestController
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	DealerService dealerService;
	
	@PostMapping(value = "adminlo/login1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AdminAutoVO> login(@RequestBody AdminAutoVO adminAutoVO, HttpServletResponse response) {
		LOGGER.debug("Admin tries to login", adminAutoVO.getUserName());
		AdminAutoVO user = dealerService.findUserName(adminAutoVO.getUserName());
		HttpStatus status = HttpStatus.OK;
		if (user == null) {
			status = HttpStatus.NO_CONTENT;
		} else if (!user.getPassword().equals(adminAutoVO.getPassword())) {
			status = HttpStatus.UNAUTHORIZED;
			user = null;
		} else {
			user.setPassword(null);
		}
		return new ResponseEntity<>(user, status);
	}
	
	
	
}
