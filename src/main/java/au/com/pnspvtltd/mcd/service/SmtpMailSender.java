package au.com.pnspvtltd.mcd.service;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class SmtpMailSender {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to,String subject,String text) throws MessagingException
	{
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(text);
		
		
		mailSender.send(message);
		
		
		
	}
	
}
