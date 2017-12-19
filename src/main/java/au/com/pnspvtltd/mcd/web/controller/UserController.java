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
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.UserService;
import au.com.pnspvtltd.mcd.web.model.MyVehicleVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "*")
@RestController

public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping(value = "user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserVO getUser(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get User with id {} ", id);
		UserVO user = userService.findById(id);
		if (user == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return user;
	}
	@GetMapping(value = "userVehicle/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MyVehicleVO> getVehicleFor(@PathVariable Long id, HttpServletResponse response) {
		LOGGER.debug("Received request to get User with id {} ", id);
		UserVO user = userService.findById(id);
		List<MyVehicleVO> userVehicles =user.getMyVehicle();
		if (userVehicles == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return userVehicles;
	}

	@PostMapping("user")
	public UserVO createUser(@RequestBody UserVO userVO, HttpServletResponse response) {
		LOGGER.debug("Received request to create User with email {}", userVO.getEmail());
		UserVO createdUser = userService.createUser(userVO);
		response.setStatus(HttpStatus.CREATED.value());
		return createdUser;
	}

	@PutMapping("user")
	public UserVO updateUser(@RequestBody UserVO userVO, HttpServletResponse response) {
		LOGGER.debug("Received request to update User {}", userVO);
		UserVO updatedUser = userService.updateUser(userVO);
		// User does not exist
		if (updatedUser == null) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return updatedUser;
	}

	@GetMapping(value = "user", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserVO> getAllUsers(HttpServletResponse response) {
		LOGGER.debug("Received request to get all Users");
		List<UserVO> users = userService.findAllUsers();
		if (users.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return users;
	}

	@PostMapping(value = "user/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserVO> login(@RequestBody UserVO userVO, HttpServletResponse response) {
		LOGGER.debug("User with email {} tries to login", userVO.getEmail());
		UserVO user = userService.findUserByEmail(userVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		if (user == null) {
			status = HttpStatus.NO_CONTENT;
		} else if (!user.getPassword().equals(userVO.getPassword())) {
			status = HttpStatus.UNAUTHORIZED;
			user = null;
		} else {
			user.setPassword(null);
		}
		return new ResponseEntity<>(user, status);
	}
	
	@PostMapping(value = "user/login/social", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserVO> loginSocial(@RequestBody UserVO userVO, HttpServletResponse response) {
		LOGGER.debug("User with email {} tries to login", userVO.getEmail());
		UserVO user = userService.findUserByEmail(userVO.getEmail());
		HttpStatus status = HttpStatus.OK;
		if (user == null) {
			user = userService.createUser(userVO);
			user.setLoyalityFlag(true);
			response.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<>(user, status);
		} 
		return new ResponseEntity<>(user, status);
	}
}
