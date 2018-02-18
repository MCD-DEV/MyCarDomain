package au.com.pnspvtltd.mcd.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private SmtpMailSender smtp;

	@RequestMapping("/send")
	public String sendMessage() throws UnsupportedEncodingException {
		try {
			smtp.sendMail("", "", "", "", "srmkanjerla@gmail.com", "Autoscoop",
					"You have been successfully Registered");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mail has been sent";
	}

}
