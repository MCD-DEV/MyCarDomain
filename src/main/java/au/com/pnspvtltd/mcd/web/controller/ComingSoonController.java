package au.com.pnspvtltd.mcd.web.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.pnspvtltd.mcd.service.ComingSoonService;
import au.com.pnspvtltd.mcd.service.SmtpMailSender;
import au.com.pnspvtltd.mcd.web.model.ComingSoonVO;

@RestController
public class ComingSoonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComingSoonController.class);

	@Autowired
	private SmtpMailSender smtp;

	@Autowired
	ComingSoonService comingSoonUserService;

	/*
	 * @GetMapping(value = "user/{id}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE }) public UserVO getUser(@PathVariable
	 * Long id, HttpServletResponse response) { LOGGER.debug(
	 * "Received request to get User with id {} ", id); UserVO user =
	 * userService.findById(id); if (user == null) {
	 * response.setStatus(HttpStatus.NO_CONTENT.value()); } return user; }
	 */

	@PostMapping("comingsoonuser")
	public ResponseEntity<ComingSoonVO> createUser(@RequestBody ComingSoonVO userVO, HttpServletResponse response) {

		LOGGER.debug("Received request to create User with email {}", userVO.getComingSoonUserEmail());

		// If User with the given email already exists?
		/*
		 * if
		 * (comingSoonUserService.findUserByEmail(userVO.getComingSoonUserEmail(
		 * )) != null) { LOGGER.debug(
		 * "User with email {} already exists/notified",
		 * userVO.getComingSoonUserEmail()); return new ResponseEntity<>(null,
		 * HttpStatus.ALREADY_REPORTED); }
		 */

		ComingSoonVO createdUser = comingSoonUserService.createUser(userVO);
		response.setStatus(HttpStatus.CREATED.value());

		try {
			smtp.sendMail(userVO.getComingSoonUserEmail(), "", "", "", "", "Autoscoop Notification",
					"You have been successfully Registered");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* user.sendMessage(userVO.getComingSoonUserEmail()); */
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	public void sendMessage(String rec) throws UnsupportedEncodingException {

		String recipient = rec;

		try {
			smtp.sendMail(recipient, "", "", "", "", "Autoscoop", "You have been successfully Registered");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* return "Mail has been sent"; */
	}

	/*
	 * @PutMapping("user") public UserVO updateUser(@RequestBody UserVO userVO,
	 * HttpServletResponse response) { LOGGER.debug(
	 * "Received request to update User {}", userVO); UserVO updatedUser =
	 * userService.updateUser(userVO); // User does not exist if (updatedUser ==
	 * null) { response.setStatus(HttpStatus.NO_CONTENT.value()); } return
	 * updatedUser; }
	 * 
	 * @GetMapping(value = "user", produces = { MediaType.APPLICATION_JSON_VALUE
	 * }) public List<UserVO> getAllUsers(HttpServletResponse response) {
	 * LOGGER.debug("Received request to get all Users"); List<UserVO> users =
	 * userService.findAllUsers(); if (users.isEmpty()) {
	 * response.setStatus(HttpStatus.NO_CONTENT.value()); } return users; }
	 * 
	 * @PostMapping(value = "user/login", produces = {
	 * MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<UserVO>
	 * login(@RequestBody UserVO userVO, HttpServletResponse response) {
	 * LOGGER.debug("User with email {} tries to login", userVO.getEmail());
	 * UserVO user = userService.findUserByEmail(userVO.getEmail()); HttpStatus
	 * status = HttpStatus.OK; if (user == null) { status =
	 * HttpStatus.NO_CONTENT; } else if
	 * (!user.getPassword().equals(userVO.getPassword())) { status =
	 * HttpStatus.UNAUTHORIZED; user = null; } else { user.setPassword(null); }
	 * return new ResponseEntity<>(user, status); }
	 */
}
