package au.com.pnspvtltd.mcd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//@CrossOrigin(origins = "https://www.autoscoop.com.au/")
//@CrossOrigin(origins = "http://www.shirdienterprises.com/")
//@CrossOrigin(origins = "http://www.mycardomain.com/")
//@CrossOrigin(origins = "http://localhost:8018")
//@CrossOrigin(origins = "http://autoscoop-staging.s3-website-ap-southeast-2.amazonaws.com")
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@Controller
public class WelcomePageController {

	@RequestMapping("/")
	public String showWelcomePage() {
		return "forward:/travelo-travel-tour-booking-html5-template/html/Hm_BetaV1.html";
	}
}
