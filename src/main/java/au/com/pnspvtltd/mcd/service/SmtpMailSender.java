package au.com.pnspvtltd.mcd.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String fName, String lName, String firstName, String lastName, String to, String subject,
			String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(text);
		// String msg="<html><i>Dear Subscriber<br/><br/><b>Thank you for
		// subscribing to Autoscoop updates!!!</b><br/><br/>We hope to delight
		// you with our range of seamlessly integrated offerings for buying,
		// selling, financing, Insurance and your services & maintenance needs
		// and much more for your automobiles needs starting with managing your
		// Cars! Get ready to transform your experience for all your automobile
		// related needs.<br/><br/>Stay tuned for
		// <b>more!</b><br/><br/>Regards<br/>Team Autoscoop</i></html> ";
		// String msg="<html><i>Dear Subscriber<br/><br/><b>You are invited to
		// register with Autoscoop!!!</b><br/><br/>We hope to delight you with
		// our range of seamlessly integrated offerings for buying, selling,
		// financing, Insurance and your services & maintenance needs and much
		// more for your automobiles needs starting with managing your Cars! Get
		// ready to transform your experience for all your automobile related
		// needs.<br/><br/>Stay tuned for <b>more!</b><br/><br/>Regards<br/>Team
		// Autoscoop</i></html> ";
		// String msg="<table border="+"+"+"0"+"+"+" width="+"+"+"100%"+"+"+"
		// cellspacing="+"+"+"0"+"+"+"
		// cellpadding="+"+"+"0"+"+"+"><tbody><tr><td
		// id="+"m_-587128254324886174m_4516884308862247289templateHeader"+"
		// align="+"center"+" valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289headerContainer"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><div><strong>AutoScoop</strong></div></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td
		// id="+"m_-587128254324886174m_4516884308862247289templateBody"+"
		// align="+"center"+" valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289bodyContainer"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h1>Hi There!.</h1><p>Your are invited to Register
		// with&nbsp;<a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">www.AutoScoop.com.au</a>,<br
		// /><br />I "+firstName+" "+lastName+" have started using&nbsp;<a
		// href="+"http://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=http://www.autoscoop.com.au/&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNFb1HS3q0ereNtYlgTRFEtV5uBaqg"+">AutoScoop</a>&nbsp;,
		// I&nbsp;recommend&nbsp;you to Join and reap the benifits, as it is a
		// one stop&nbsp;shop for all your Vehicle Needs.<br /><br />I use
		// AutoScoop for
		// following&nbsp;</p></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci3.googleusercontent.com/proxy/VbguPrat2o_zg7V__WjBB3F8a2v2ow5NGy_3d8RfQpk08AfqqwOjj7siYrVfQYbfiYFmD6mdUZnlvUJarMLseDA83j5Avb0yB0ilY-l7KEP46K746NLDPOCxuHRY_4JCmHWK_pxFYCmr01Zpsrt0sgLYEEXnZD1iKaXkALw=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7e3b8aec-7511-4dc0-8b05-536bbbf28b3d.jpg"+"
		// alt="+""+" width="+"564"+" align="+"center"+"
		// /></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h4>Welcome to the
		// convenience!</h4></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><div>AutoScoop is the one stop solution for all your
		// Vehicle needs, starting with Car! I started using AutoScoop, when I
		// am looking to</div><ul><li><strong>Buy My Next
		// Car!</strong></li><li><strong>Lease My next
		// Car!</strong></li><li><strong>Sell My current Car!.</strong>..<a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></li></ul></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci4.googleusercontent.com/proxy/M5VhyQZpICI4Gx7OfpnChJ2ub88B0gjvm7pFXNRhQza93YE5HBsExPiToQj-gIV1gc2BhAhl8g8CJxL_h8WL5x7VlnpCODrR9s4eLgcdKJ2eZt3VJuVm9izf456IW87cTc6ls8ebKDiV8IMCb7YVl6H7vYcMAEN7h3_weoM=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/ec116d84-903f-4384-b162-517c9f133ef9.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Your vehicle Finance</h3><p>Getting Finance is
		// integrated into into the Vehicle Buy process in itself or you can
		// request and access best quote or deals which suits your
		// requirement.<br /><br /><a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci6.googleusercontent.com/proxy/ik2OXNzoW9rDe3eg2BC49Upod-TmyZfS5kMy_OrSlbaiC0ovYXhemYJzIkieAk82ew1JzK2FFiyWBT2gJm9XEKSkQeAXQHRXl7B93AXKKbcVVzVb44Kuc9NuZGn7sdRcRB8Z6kFJ3WuwAXTsxxizMFr8hjB5tf8oOy4EZZE=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/d31f670d-bc34-4c0a-aa1b-9a39d751c0e7.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Your Vehicle Insurance</h3><p>Buying a New or
		// renewing or looking out for best deals and features for your next
		// Vehicle Insurance, We have simplified and integrated with your
		// favourate Insurance provider.<br /><br /><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci6.googleusercontent.com/proxy/ndZeQs69TQnTqrdR-qg5CysCHBwM5Z-53QMuH5VKxbYysmAFlEd7OZBzqKtez_cXwoNVONvzHdnHCQbyWOJOomzEtoRHZtOUfD1OEuTt6v_nHZXlY6NzPZ0TFppbuq3uZkw_mjIisrwIckKByzuJp6Sm8bp2u45y4x6wj90=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7ad77ed1-8859-4de0-a48b-a50dda967bf3.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Service &amp; Maintenance</h3><p>You need not to
		// an expert and you need not run arround, simply give your requirement
		// and we will connect you to best Mechanics available in Australia<br
		// /><br /><a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">Learn
		// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci5.googleusercontent.com/proxy/hekSBkA969NAUmEB8UFcyLvRsGn4IbKfBv3_ewdTGTPvUtFFHblEETD2UaMdrp_s6CyB_PSG8xpPIzYYxaknKrcSjUSGoOceOwlpTScBdzXtWFVEsAboJ4o_4TufTv5O861sXpv61GdiDW4ORQxHjxVH04RhKtuJW3NVjCQ=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6842bce9-4054-484f-bc19-8b53176ccb00.png"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Transport&nbsp;Car<br /><br />Dont worry, you
		// will best deal with Australia wide network of transporter</h3><p><a
		// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
		// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd"+"
		// src="+"https://ci5.googleusercontent.com/proxy/ALngKwneygVXkPb3UFjtakzQs4oQ0gFnF7IwbHU9mJayYbTkA3ZOQOg3SWfus0SgQuzlsYn-75k0yN7vcQDNU11qp51ha8XYvQVYkkqmupgzJ7wO--fsOUfYYLOP-66wXMORk-J5UqMU_kEHoh1iOau_3gDU1gq65Gf4hcc=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/8a57faf3-4cdd-4e70-9a08-005c91bd0942.png"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>AutoScoop Logbook</h3><p>Invite people to your
		// next event, let them know about an upcoming sale, or give them a
		// sneak peek at a new collection that&rsquo;s coming
		// soon.</p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci3.googleusercontent.com/proxy/N4uSXFfSvHkEEFdkiKAOx5nnreY69Z1f2ODnWfYhvbgoyn20IJM5fasdf31C8nSBPQgvfhsb7wxGzS1VdJgTw6RyFBQtZS8MUu_E2Z7u3DxcqWSp7uQrNPwglyJDyvZ4UQnh0WAJWR7vtdcXn6zsvTs7IwWW3mVBYcv0aGY=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6bad69b8-59f9-4dd0-bf7e-3f7141c17208.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Smart Garage</h3><p>You need not buy anything
		// from us, you can still use of Smart Garage for free, yes you read it
		// right its free, simplfy and keeps track of the all important due
		// date's and get you best deals when it is required.</p><p><a
		// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table>";
		String msg = "<!doctype html>"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">"
				+ "	<head>" + "	<!-- NAME: TELL A STORY -->" + "	<!--[if gte mso 15]>" + "	<xml>"
				+ "	<o:OfficeDocumentSettings>" + "	<o:AllowPNG/>" + "	<o:PixelsPerInch>96</o:PixelsPerInch>"
				+ "	</o:OfficeDocumentSettings>" + "	</xml>" + "	<![endif]-->" + "	<meta charset=\"UTF-8\">"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "	<title>*|MC:SUBJECT|*</title>" + "        " + "    <style type=\"text/css\">" + "	p{"
				+ "	margin:10px 0;" + "	padding:0;" + "	}" + "	table{" + "	border-collapse:collapse;" + "	}"
				+ "	h1,h2,h3,h4,h5,h6{" + "	display:block;" + "	margin:0;" + "	padding:0;" + "	}" + "	img,a img{"
				+ "	border:0;" + "	height:auto;" + "	outline:none;" + "	text-decoration:none;" + "	}"
				+ "	body,#bodyTable,#bodyCell{" + "	height:100%;" + "	margin:0;" + "	padding:0;" + "	width:100%;"
				+ "	}" + "	.mcnPreviewText{" + "	display:none !important;" + "	}" + "	#outlook a{"
				+ "	padding:0;" + "	}" + "	img{" + "	-ms-interpolation-mode:bicubic;" + "	}" + "	table{"
				+ "	mso-table-lspace:0pt;" + "	mso-table-rspace:0pt;" + "	}" + "	.ReadMsgBody{" + "	width:100%;"
				+ "	}" + "	.ExternalClass{" + "	width:100%;" + "	}" + "	p,a,li,td,blockquote{"
				+ "	mso-line-height-rule:exactly;" + "	}" + "	a[href^=tel],a[href^=sms]{" + "	color:inherit;"
				+ "	cursor:default;" + "	text-decoration:none;" + "	}" + "	p,a,li,td,body,table,blockquote{"
				+ "	-ms-text-size-adjust:100%;" + "	-webkit-text-size-adjust:100%;" + "	}"
				+ "	.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{"
				+ "	line-height:100%;" + "	}" + "	a[x-apple-data-detectors]{" + "	color:inherit !important;"
				+ "	text-decoration:none !important;" + "	font-size:inherit !important;"
				+ "	font-family:inherit !important;" + "	font-weight:inherit !important;"
				+ "	line-height:inherit !important;" + "	}" + "	.templateContainer{"
				+ "	max-width:600px !important;" + "	}" + "	a.mcnButton{" + "	display:block;" + "	}"
				+ "	.mcnImage{" + "	vertical-align:bottom;" + "	}" + "	.mcnTextContent{" + "	word-break:break-word;"
				+ "	}" + "	.mcnTextContent img{" + "	height:auto !important;" + "	}" + "	.mcnDividerBlock{"
				+ "	table-layout:fixed !important;" + "	}" + "	/*" + "	@tab Page" + "	@section Heading 1"
				+ "	@style heading 1" + "	*/" + "	h1{" + "	/*@editable*/color:#222222;"
				+ "	/*@editable*/font-family:Helvetica;" + "	/*@editable*/font-size:40px;"
				+ "	/*@editable*/font-style:normal;" + "	/*@editable*/font-weight:bold;"
				+ "	/*@editable*/line-height:150%;" + "	/*@editable*/letter-spacing:normal;"
				+ "	/*@editable*/text-align:center;" + "	}" + "	/*" + "	@tab Page" + "	@section Heading 2"
				+ "	@style heading 2" + "	*/" + "	h2{" + "	/*@editable*/color:#222222;"
				+ "	/*@editable*/font-family:Helvetica;" + "	/*@editable*/font-size:34px;"
				+ "	/*@editable*/font-style:normal;" + "	/*@editable*/font-weight:bold;"
				+ "	/*@editable*/line-height:150%;" + "	/*@editable*/letter-spacing:normal;"
				+ "	/*@editable*/text-align:left;" + "	}" + "	/*" + "	@tab Page" + "	@section Heading 3"
				+ "	@style heading 3" + "	*/" + "	h3{" + "	/*@editable*/color:#444444;"
				+ "	/*@editable*/font-family:Helvetica;" + "	/*@editable*/font-size:22px;"
				+ "	/*@editable*/font-style:normal;" + "	/*@editable*/font-weight:bold;"
				+ "	/*@editable*/line-height:150%;" + "	/*@editable*/letter-spacing:normal;"
				+ "	/*@editable*/text-align:left;" + "	}" + "	/*" + "	@tab Page" + "	@section Heading 4"
				+ "	@style heading 4" + "	*/" + "	h4{" + "	/*@editable*/color:#999999;"
				+ "	/*@editable*/font-family:Georgia;" + "	/*@editable*/font-size:20px;"
				+ "	/*@editable*/font-style:italic;" + "	/*@editable*/font-weight:normal;"
				+ "	/*@editable*/line-height:125%;" + "	/*@editable*/letter-spacing:normal;"
				+ "	/*@editable*/text-align:left;" + "	}" + "	/*" + "	@tab Header"
				+ "	@section Header Container Style" + "	*/" + "	#templateHeader{"
				+ "	/*@editable*/background-color:#ffffff;" + "	/*@editable*/background-image:none;"
				+ "	/*@editable*/background-repeat:no-repeat;" + "	/*@editable*/background-position:center;"
				+ "	/*@editable*/background-size:cover;" + "	/*@editable*/border-top:0;"
				+ "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:0px;"
				+ "	/*@editable*/padding-bottom:0px;" + "	}" + "	/*" + "	@tab Header"
				+ "	@section Header Interior Style" + "	*/" + "	.headerContainer{"
				+ "	/*@editable*/background-color:transparent;" + "	/*@editable*/background-image:none;"
				+ "	/*@editable*/background-repeat:no-repeat;" + "	/*@editable*/background-position:center;"
				+ "	/*@editable*/background-size:cover;" + "	/*@editable*/border-top:0;"
				+ "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:0;"
				+ "	/*@editable*/padding-bottom:0;" + "	}" + "	/*" + "	@tab Header" + "	@section Header Text"
				+ "	*/" + "	.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"
				+ "	/*@editable*/color:#808080;" + "	/*@editable*/font-family:Helvetica;"
				+ "	/*@editable*/font-size:16px;" + "	/*@editable*/line-height:150%;"
				+ "	/*@editable*/text-align:left;" + "	}" + "	/*" + "	@tab Header" + "	@section Header Link"
				+ "	*/" + "	.headerContainer .mcnTextContent a,.headerContainer .mcnTextContent p a{"
				+ "	/*@editable*/color:#00ADD8;" + "	/*@editable*/font-weight:normal;"
				+ "	/*@editable*/text-decoration:underline;" + "	}" + "	/*" + "	@tab Body"
				+ "	@section Body Container Style" + "	*/" + "	#templateBody{"
				+ "	/*@editable*/background-color:#FFFFFF;" + "	/*@editable*/background-image:none;"
				+ "	/*@editable*/background-repeat:no-repeat;" + "	/*@editable*/background-position:center;"
				+ "	/*@editable*/background-size:cover;" + "	/*@editable*/border-top:0;"
				+ "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:27px;"
				+ "	/*@editable*/padding-bottom:54px;" + "	}" + "	/*" + "	@tab Body"
				+ "	@section Body Interior Style" + "	*/" + "	.bodyContainer{"
				+ "	/*@editable*/background-color:transparent;" + "	/*@editable*/background-image:none;"
				+ "	/*@editable*/background-repeat:no-repeat;" + "	/*@editable*/background-position:center;"
				+ "	/*@editable*/background-size:cover;" + "	/*@editable*/border-top:0;"
				+ "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:0;"
				+ "	/*@editable*/padding-bottom:0;" + "	}" + "	/*" + "	@tab Body" + "	@section Body Text" + "	*/"
				+ "	.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{" + "	/*@editable*/color:#808080;"
				+ "	/*@editable*/font-family:Helvetica;" + "	/*@editable*/font-size:16px;"
				+ "	/*@editable*/line-height:150%;" + "	/*@editable*/text-align:left;" + "	}" + "	/*" + "	@tab Body"
				+ "	@section Body Link" + "	*/"
				+ "	.bodyContainer .mcnTextContent a,.bodyContainer .mcnTextContent p a{"
				+ "	/*@editable*/color:#00ADD8;" + "	/*@editable*/font-weight:normal;"
				+ "	/*@editable*/text-decoration:underline;" + "	}" + "	/*" + "	@tab Footer"
				+ "	@section Footer Style" + "	*/" + "	#templateFooter{" + "	/*@editable*/background-color:#333333;"
				+ "	/*@editable*/background-image:none;" + "	/*@editable*/background-repeat:no-repeat;"
				+ "	/*@editable*/background-position:center;" + "	/*@editable*/background-size:cover;"
				+ "	/*@editable*/border-top:0;" + "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:45px;"
				+ "	/*@editable*/padding-bottom:63px;" + "	}" + "	/*" + "	@tab Footer"
				+ "	@section Footer Interior Style" + "	*/" + "	.footerContainer{"
				+ "	/*@editable*/background-color:transparent;" + "	/*@editable*/background-image:none;"
				+ "	/*@editable*/background-repeat:no-repeat;" + "	/*@editable*/background-position:center;"
				+ "	/*@editable*/background-size:cover;" + "	/*@editable*/border-top:0;"
				+ "	/*@editable*/border-bottom:0;" + "	/*@editable*/padding-top:0;"
				+ "	/*@editable*/padding-bottom:0;" + "	}" + "	/*" + "	@tab Footer" + "	@section Footer Text"
				+ "	*/" + "	.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"
				+ "	/*@editable*/color:#FFFFFF;" + "	/*@editable*/font-family:Helvetica;"
				+ "	/*@editable*/font-size:12px;" + "	/*@editable*/line-height:150%;"
				+ "	/*@editable*/text-align:center;" + "	}" + "	/*" + "	@tab Footer" + "	@section Footer Link"
				+ "	*/" + "	.footerContainer .mcnTextContent a,.footerContainer .mcnTextContent p a{"
				+ "	/*@editable*/color:#FFFFFF;" + "	/*@editable*/font-weight:normal;"
				+ "	/*@editable*/text-decoration:underline;" + "	}" + "	@media only screen and (min-width:768px){"
				+ "	.templateContainer{" + "	width:600px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	body,table,td,p,a,li,blockquote{"
				+ "	-webkit-text-size-adjust:none !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	body{" + "	width:100% !important;"
				+ "	min-width:100% !important;" + "	}" + "" + "}	@media only screen and (max-width: 480px){"
				+ "	.mcnImage{" + "	width:100% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "	.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{"
				+ "	max-width:100% !important;" + "	width:100% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	.mcnBoxedTextContentContainer{"
				+ "	min-width:100% !important;" + "	}" + "" + "}	@media only screen and (max-width: 480px){"
				+ "	.mcnImageGroupContent{" + "	padding:9px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "	.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{"
				+ "	padding-top:9px !important;" + "	}" + "" + "}	@media only screen and (max-width: 480px){"
				+ "	.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{"
				+ "	padding-top:18px !important;" + "	}" + "" + "}	@media only screen and (max-width: 480px){"
				+ "	.mcnImageCardBottomImageContent{" + "	padding-bottom:9px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	.mcnImageGroupBlockInner{"
				+ "	padding-top:0 !important;" + "	padding-bottom:0 !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	.mcnImageGroupBlockOuter{"
				+ "	padding-top:9px !important;" + "	padding-bottom:9px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	.mcnTextContent,.mcnBoxedTextContentColumn{"
				+ "	padding-right:18px !important;" + "	padding-left:18px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "	.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{" + "	padding-right:18px !important;"
				+ "	padding-bottom:0 !important;" + "	padding-left:18px !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	.mcpreview-image-uploader{"
				+ "	display:none !important;" + "	width:100% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 1"
				+ "	@tip Make the first-level headings larger in size for better readability on small screens." + "	*/"
				+ "	h1{" + "	/*@editable*/font-size:30px !important;"
				+ "	/*@editable*/line-height:125% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 2"
				+ "	@tip Make the second-level headings larger in size for better readability on small screens."
				+ "	*/" + "	h2{" + "	/*@editable*/font-size:26px !important;"
				+ "	/*@editable*/line-height:125% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 3"
				+ "	@tip Make the third-level headings larger in size for better readability on small screens." + "	*/"
				+ "	h3{" + "	/*@editable*/font-size:20px !important;"
				+ "	/*@editable*/line-height:150% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 4"
				+ "	@tip Make the fourth-level headings larger in size for better readability on small screens."
				+ "	*/" + "	h4{" + "	/*@editable*/font-size:18px !important;"
				+ "	/*@editable*/line-height:150% !important;" + "	}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Boxed Text"
				+ "	@tip Make the boxed text larger in size for better readability on small screens. We recommend a font size of at least 16px."
				+ "	*/"
				+ "	.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{"
				+ "	/*@editable*/font-size:14px !important;" + "	/*@editable*/line-height:150% !important;" + "	}"
				+ "" + "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Header Text"
				+ "	@tip Make the header text larger in size for better readability on small screens." + "	*/"
				+ "	.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"
				+ "	/*@editable*/font-size:16px !important;" + "	/*@editable*/line-height:150% !important;" + "	}"
				+ "" + "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Body Text"
				+ "	@tip Make the body text larger in size for better readability on small screens. We recommend a font size of at least 16px."
				+ "	*/" + "	.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{"
				+ "	/*@editable*/font-size:16px !important;" + "	/*@editable*/line-height:150% !important;" + "	}"
				+ "" + "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Footer Text"
				+ "	@tip Make the footer content text larger in size for better readability on small screens." + "	*/"
				+ "	.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"
				+ "	/*@editable*/font-size:14px !important;" + "	/*@editable*/line-height:150% !important;" + "	}"
				+ "" + "}</style></head>" + "    <body>" + "	<!--*|IF:MC_PREVIEW_TEXT|*-->"
				+ "	<!--[if !gte mso 9]><!----><span class=\"mcnPreviewText\" style=\"display:none; font-size:0px; line-height:0px; max-height:0px; max-width:0px; opacity:0; overflow:hidden; visibility:hidden; mso-hide:all;\">*|MC_PREVIEW_TEXT|*</span><!--<![endif]-->"
				+ "	<!--*|END:IF|*-->" + "        <center>"
				+ "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\">"
				+ "                <tr>" + "                    <td align=\"center\" valign=\"top\" id=\"bodyCell\">"
				+ "                        <!-- BEGIN TEMPLATE // -->"
				+ "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"
				+ "	<tr>" + "	<td align=\"center\" valign=\"top\" id=\"templateHeader\" data-template-container>"
				+ "	<!--[if gte mso 9]>"
				+ "	<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "	<tr>" + "	<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "	<![endif]-->"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "	<tr>" + "                                	<td valign=\"top\" class=\"headerContainer\"></td>"
				+ "	</tr>" + "	</table>" + "	<!--[if gte mso 9]>" + "	</td>" + "	</tr>" + "	</table>"
				+ "	<![endif]-->" + "	</td>" + "                            </tr>" + "	<tr>"
				+ "	<td align=\"center\" valign=\"top\" id=\"templateBody\" data-template-container>"
				+ "	<!--[if gte mso 9]>"
				+ "	<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "	<tr>" + "	<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "	<![endif]-->"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "	<tr>"
				+ "                                	<td valign=\"top\" class=\"bodyContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnTextBlockOuter\">" + "        <tr>"
				+ "            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"
				+ "              	<!--[if mso]>"
				+ "	<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"
				+ "	<tr>" + "	<![endif]-->" + "	    " + "	<!--[if mso]>"
				+ "	<td valign=\"top\" width=\"600\" style=\"width:600px;\">" + "	<![endif]-->"
				+ "                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"
				+ "                    <tbody><tr>" + "                        "
				+ "                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"
				+ "                        " + "                            <h1>Hi " + firstName + " " + lastName
				+ " !</h1>" + ""
				+ "<p style=\"text-align:center !important;\">Your are invited to Register with <a href=\"https://www.autoscoop.com.au\" target=\"_blank\">www.AutoScoop.com.au</a>,<br>"
				+ "<br>" + "I " + fName + " " + lName+text
				+ " have started using <a data-saferedirecturl=\"https://www.google.com/url?hl=en&q=http://www.AutoScoop.com.au&source=gmail&ust=1503478351801000&usg=AFQjCNHTyJRw36aHH-mV3uK07NYJHzN9-Q\" href=\"http://www.autoscoop.com.au/\" target=\"_blank\">AutoScoop</a> , I recommend you to Join and reap the benifits, as it is a one stop shop for all your Vehicle Needs.<br>"
				+ "<br>" + "I use AutoScoop for</p>" + "" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "	<!--[if mso]>" + "	</td>"
				+ "	<![endif]-->" + "                " + "	<!--[if mso]>" + "	</tr>" + "	</table>"
				+ "	<![endif]-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnTextBlockOuter\">" + "        <tr>"
				+ "            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"
				+ "              	<!--[if mso]>"
				+ "	<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"
				+ "	<tr>" + "	<![endif]-->" + "	    " + "	<!--[if mso]>"
				+ "	<td valign=\"top\" width=\"600\" style=\"width:600px;\">" + "	<![endif]-->"
				+ "                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"
				+ "                    <tbody><tr>" + "                        "
				+ "                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"
				+ "                        "
				+ "                            <div style=\"text-align: center;\"><span style=\"font-size:20px\"><strong><span style=\"color:#000000\">BUY - LEASE - SELL - Your CAR!</span></strong></span></div>"
				+ "" + "                        </td>" + "                    </tr>"
				+ "                </tbody></table>" + "	<!--[if mso]>" + "	</td>" + "	<![endif]-->"
				+ "                " + "	<!--[if mso]>" + "	</tr>" + "	</table>" + "	<![endif]-->"
				+ "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%; padding: 18px 18px 0px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnImageBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnImageBlockOuter\">" + "            <tr>"
				+ "                <td valign=\"top\" style=\"padding:9px\" class=\"mcnImageBlockInner\">"
				+ "                    <table align=\"left\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"min-width:100%;\">"
				+ "                        <tbody><tr>"
				+ "                            <td class=\"mcnImageContent\" valign=\"top\" style=\"padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;\">"
				+ "                                " + "                                    "
				+ "                                        <img align=\"center\" alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7e3b8aec-7511-4dc0-8b05-536bbbf28b3d.jpg\" width=\"564\" style=\"max-width:1366px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" class=\"mcnImage\">"
				+ "                                    " + "                                "
				+ "                            </td>" + "                        </tr>"
				+ "                    </tbody></table>" + "                </td>" + "            </tr>"
				+ "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnTextBlockOuter\">" + "        <tr>"
				+ "            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"
				+ "              	<!--[if mso]>"
				+ "	<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"
				+ "	<tr>" + "	<![endif]-->" + "	    " + "	<!--[if mso]>"
				+ "	<td valign=\"top\" width=\"600\" style=\"width:600px;\">" + "	<![endif]-->"
				+ "                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"
				+ "                    <tbody><tr>" + "                        "
				+ "                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"
				+ "                        "
				+ "                            <div style=\"text-align: left;\">AutoScoop is the one stop solution for all your Vehicle needs, starting with Car! I started using AutoScoop, when I am looking to ..<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More!</a></div>"
				+ "" + "                        </td>" + "                    </tr>"
				+ "                </tbody></table>" + "	<!--[if mso]>" + "	</td>" + "	<![endif]-->"
				+ "                " + "	<!--[if mso]>" + "	</tr>" + "	</table>" + "	<![endif]-->"
				+ "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + "" + "" + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionRightContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionRightImageContent\" valign=\"top\">"
				+ "                    " + "                        " + ""
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/ec116d84-903f-4384-b162-517c9f133ef9.jpg\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "" + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionRightTextContentContainer\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Your vehicle Finance</h3>" + ""
				+ "<p>Getting Finance is integrated into into the Vehicle Buy process in itself or you can request and access best quote or deals which suits your requirement.<br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More!</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%; padding: 27px 18px 0px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionLeftContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionLeftImageContent\" valign=\"top\">"
				+ "                    " + "                        "
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/d31f670d-bc34-4c0a-aa1b-9a39d751c0e7.jpg\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionLeftTextContentContainer\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Your Vehicle Insurance</h3>" + ""
				+ "<p>Buying a New or renewing or looking out for best deals and features for your next Vehicle Insurance, We have simplified and integrated with your favourate Insurance provider.<br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More!</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%; padding: 27px 18px 0px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + "" + "" + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionRightContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionRightImageContent\" valign=\"top\">"
				+ "                    " + "                        " + ""
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7ad77ed1-8859-4de0-a48b-a50dda967bf3.jpg\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "" + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionRightTextContentContainer\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Service & Maintenance</h3>" + ""
				+ "<p>You need not be an expert and you need not run around, simply give your requirement and we will connect you to best Mechanics available in Australia<br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionLeftContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionLeftImageContent\" valign=\"top\">"
				+ "                    " + "                        "
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/ef2d04cf-febd-4f3b-ae4c-4b17da6e1abd.png\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionLeftTextContentContainer\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Transport</h3>" + ""
				+ "<p>If you are relocating or you need to move your vehicle or any things, simple give your requirement, from and to place we will find and get you best quote.<br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More!</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + "" + "" + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionRightContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionRightImageContent\" valign=\"top\">"
				+ "                    " + "                        " + ""
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/065dcc86-2e79-4416-b50e-5f21a9f01231.png\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "" + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionRightTextContentContainer\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>AutoScoop Logbook</h3>" + ""
				+ "<p>You can not only record you Business, Work or Personal trips, you record Vehicle Expensess and this will help you to submit tax claims to ATO. and record your Service Log history with our the worry of loosing or damaging the your manual service log book and its Free<br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More.</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionLeftContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionLeftImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionLeftImageContent\" valign=\"top\">"
				+ "                    " + "                        "
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/d1567436-b4c5-417b-b77a-0b8566a42b26.jpg\" width=\"264\" style=\"max-width:1000px;\" class=\"mcnImage\">"
				+ "                        " + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionLeftTextContentContainer\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Smart Garage</h3>" + ""
				+ "<p>You use our Smart Garage, and its simplfy keep track of the all important due date's and get you best deals when it is required.</p>"
				+ ""
				+ "<p><a href=\"#\">L</a><a href=\"https://www.autoscoop.com.au\" target=\"_blank\">earn More!</a></p>"
				+ "" + "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnCaptionBlock\">"
				+ "    <tbody class=\"mcnCaptionBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnCaptionBlockInner\" valign=\"top\" style=\"padding:9px;\">"
				+ "                " + "" + "" + ""
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightContentOuter\" width=\"100%\">"
				+ "    <tbody><tr>"
				+ "        <td valign=\"top\" class=\"mcnCaptionRightContentInner\" style=\"padding:0 9px ;\">"
				+ "            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnCaptionRightImageContentContainer\">"
				+ "                <tbody><tr>"
				+ "                    <td class=\"mcnCaptionRightImageContent\" valign=\"top\">"
				+ "                    " + "                        " + ""
				+ "                        <img alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/c5f62af6-6a3e-401b-a35e-e5fd4ac4d583.jpg\" width=\"264\" style=\"max-width:441px;\" class=\"mcnImage\">"
				+ "                        " + "" + "                    " + "                    </td>"
				+ "                </tr>" + "            </tbody></table>"
				+ "            <table class=\"mcnCaptionRightTextContentContainer\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">"
				+ "                <tbody><tr>" + "                    <td valign=\"top\" class=\"mcnTextContent\">"
				+ "                        <h3>Loyalty Program</h3>" + ""
				+ "<p>You can earn using AutoScoop, there are many Ways<br>"
				+ "If you do any of the activity Listed above and more to come, and you can do lot of things with this Loyalty points earnerd, <br>"
				+ "<br>" + "<a href=\"https://www.autoscoop.com.au\" target=\"_blank\">Learn More.</a></p>" + ""
				+ "                    </td>" + "                </tr>" + "            </tbody></table>"
				+ "        </td>" + "    </tr>" + "</tbody></table>" + "" + "" + "" + "" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnButtonBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnButtonBlockOuter\">" + "        <tr>"
				+ "            <td style=\"padding-top:0; padding-right:18px; padding-bottom:18px; padding-left:18px;\" valign=\"top\" align=\"center\" class=\"mcnButtonBlockInner\">"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonContentContainer\" style=\"border-collapse: separate !important;border-top-left-radius: 3px;border-top-right-radius: 3px;border-bottom-right-radius: 3px;border-bottom-left-radius: 3px;background-color: #2BAADF;\">"
				+ "                    <tbody>" + "                        <tr>"
				+ "                            <td align=\"center\" valign=\"middle\" class=\"mcnButtonContent\" style=\"font-family: Arial; font-size: 16px; padding: 15px;\">"
				+ "                                <a class=\"mcnButton \" title=\" Join Us AutoScoop            \" href=\"https://www.autoscoop.com.au\" target=\"_blank\" style=\"font-weight: bold;letter-spacing: normal;line-height: 100%;text-align: center;text-decoration: none;color: #FFFFFF;\"> Join Us AutoScoop            </a>"
				+ "                            </td>" + "                        </tr>" + "                    </tbody>"
				+ "                </table>" + "            </td>" + "        </tr>" + "    </tbody>" + "</table></td>"
				+ "	</tr>" + "	</table>" + "	<!--[if gte mso 9]>" + "	</td>" + "	</tr>" + "	</table>"
				+ "	<![endif]-->" + "	</td>" + "                            </tr>"
				+ "                            <tr>"
				+ "	<td align=\"center\" valign=\"top\" id=\"templateFooter\" data-template-container>"
				+ "	<!--[if gte mso 9]>"
				+ "	<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "	<tr>" + "	<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "	<![endif]-->"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "	<tr>"
				+ "                                	<td valign=\"top\" class=\"footerContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnFollowBlockOuter\">" + "        <tr>"
				+ "            <td align=\"center\" valign=\"top\" style=\"padding:9px\" class=\"mcnFollowBlockInner\">"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentContainer\" style=\"min-width:100%;\">"
				+ "    <tbody><tr>" + "        <td align=\"center\" style=\"padding-left:9px;padding-right:9px;\">"
				+ "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\" class=\"mcnFollowContent\">"
				+ "                <tbody><tr>"
				+ "                    <td align=\"center\" valign=\"top\" style=\"padding-top:9px; padding-right:9px; padding-left:9px;\">"
				+ "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"
				+ "                            <tbody><tr>"
				+ "                                <td align=\"center\" valign=\"top\">"
				+ "                                    <!--[if mso]>"
				+ "                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
				+ "                                    <tr>" + "                                    <![endif]-->"
				+ "                                    " + "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://www.facebook.com/autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-facebook-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://www.twitter.com/AutoScoopA\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-twitter-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://www.instagram.com/\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-instagram-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:0; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"https://www.autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-link-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                    <!--[if mso]>" + "                                    </tr>"
				+ "                                    </table>" + "                                    <![endif]-->"
				+ "                                </td>" + "                            </tr>"
				+ "                        </tbody></table>" + "                    </td>" + "                </tr>"
				+ "            </tbody></table>" + "        </td>" + "    </tr>" + "</tbody></table>" + ""
				+ "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width:100%; padding:18px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width: 100%;border-top: 2px solid #505050;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnTextBlockOuter\">" + "        <tr>"
				+ "            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"
				+ "              	<!--[if mso]>"
				+ "	<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"
				+ "	<tr>" + "	<![endif]-->" + "	    " + "	<!--[if mso]>"
				+ "	<td valign=\"top\" width=\"600\" style=\"width:600px;\">" + "	<![endif]-->"
				+ "                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"
				+ "                    <tbody><tr>" + "                        "
				+ "                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"
				+ "                        "
				+ "                            <em>Copyright © 2017 AutoScoop is the Venture of Partners & Solutions Pvt Ltd, All rights reserved.</em><br>"
				+ "<br>" + "<br>" + "<strong>Our mailing address is:</strong><br>" + "contact@autoscoop.com.au<br>"
				+ "<br>" + "Want to change how you receive these emails?<br>"
				+ "You can update your preferences or <a href=\"*|UNSUB|*\">unsubscribe from this list</a>.<br>"
				+ "<br>" + "*Check out our AutoScoop Loyalty Program*" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "	<!--[if mso]>" + "	</td>"
				+ "	<![endif]-->" + "                " + "	<!--[if mso]>" + "	</tr>" + "	</table>"
				+ "	<![endif]-->" + "            </td>" + "        </tr>" + "    </tbody>" + "</table></td>"
				+ "	</tr>" + "	</table>" + "	<!--[if gte mso 9]>" + "	</td>" + "	</tr>" + "	</table>"
				+ "	<![endif]-->" + "	</td>" + "                            </tr>"
				+ "                        </table>" + "                        <!-- // END TEMPLATE -->"
				+ "                    </td>" + "                </tr>" + "            </table>" + "        </center>"
				+ "    </body>" + "</html>";
		// String msg="<img
		// src=\"src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png\">";
		helper.setFrom(new InternetAddress("support@autoscoop.com.au", "support@autoscoop.com.au"));
		// message.setDescription(msg,"text/html; charset=utf-8");
		// message.setContent(msg,"text/html");
		message.setContent(msg, "text/html; charset=utf-8");
		mailSender.send(message);

		/*
		 * MimeMessage message=mailSender.createMimeMessage(); MimeMessageHelper
		 * helper=new MimeMessageHelper(message,true);
		 * helper.setSubject(subject); helper.setTo(to); helper.setText(text);
		 * helper.setFrom(new InternetAddress("support@autoscoop.com.au",
		 * "support@autoscoop.com.au")); // This mail has 2 part, the BODY and
		 * the embedded image MimeMultipart multipart = new
		 * MimeMultipart("related"); // first part (the html) BodyPart
		 * messageBodyPart = new MimeBodyPart(); //String htmlText =
		 * "<H1>Hello</H1><img src=\"cid:image\">"; String htmlText =
		 * "<img src=\"cid:image\">"; messageBodyPart.setContent(htmlText,
		 * "text/html"); // add it multipart.addBodyPart(messageBodyPart); //
		 * second part (the image) messageBodyPart = new MimeBodyPart();
		 * //DataSource fds = new
		 * FileDataSource("C:\\Users\\mk\\Desktop\\AutoscoopImg.png");
		 * FileReader fs; try { fs = new
		 * FileReader("src/main/java/au/com/pnspvtltd/mcd/service/abc.txt");
		 * if(fs!=null){ System.out.println("fiel is open"); } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * DataSource fds = new FileDataSource(
		 * "src\\main\\java\\au\\com\\pnspvtltd\\mcd\\service\\abc.txt");
		 * //src/main/java/au.com.pnspvtltd.mcd.service
		 * src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png
		 * //DataSource fds = new
		 * FileDataSource("localhost:8080\\MyCarDomain\\AutoscoopImg.png"); File
		 * f= new File(null); DataSource fds1 = new FileDataSource(f);
		 * messageBodyPart.setDataHandler(new DataHandler(fds));
		 * messageBodyPart.setHeader("Content-ID", "<image>"); // add image to
		 * the multipart multipart.addBodyPart(messageBodyPart); // put
		 * everything together message.setContent(multipart);
		 * mailSender.send(message);
		 */
		// Send the actual HTML message, as big as you like
		// Transport.send(message);
		System.out.println("Mail sent successfully!!!");
	}
	
	public void sendDealerRegistration(String firstName, String lastName, String to, String subject, String userid, String pwd, String text)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(text);
		
		String msg = "<!doctype html>"+
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">"+
				"	<head>"+
				"		<!-- NAME: SELL PRODUCTS -->"+
				"		<!--[if gte mso 15]>"+
				"		<xml>"+
				"			<o:OfficeDocumentSettings>"+
				"			<o:AllowPNG/>"+
				"			<o:PixelsPerInch>96</o:PixelsPerInch>"+
				"			</o:OfficeDocumentSettings>"+
				"		</xml>"+
				"		<![endif]-->"+
				"		<meta charset=\"UTF-8\">"+
				"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"+
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
				"		<title>*|MC:SUBJECT|*</title>"+
				"        "+
				"    <style type=\"text/css\">"+
				"		p{"+
				"			margin:10px 0;"+
				"			padding:0;"+
				"		}"+
				"		table{"+
				"			border-collapse:collapse;"+
				"		}"+
				"		h1,h2,h3,h4,h5,h6{"+
				"			display:block;"+
				"			margin:0;"+
				"			padding:0;"+
				"		}"+
				"		img,a img{"+
				"			border:0;"+
				"			height:auto;"+
				"			outline:none;"+
				"			text-decoration:none;"+
				"		}"+
				"		body,#bodyTable,#bodyCell{"+
				"			height:100%;"+
				"			margin:0;"+
				"			padding:0;"+
				"			width:100%;"+
				"		}"+
				"		.mcnPreviewText{"+
				"			display:none !important;"+
				"		}"+
				"		#outlook a{"+
				"			padding:0;"+
				"		}"+
				"		img{"+
				"			-ms-interpolation-mode:bicubic;"+
				"		}"+
				"		table{"+
				"			mso-table-lspace:0pt;"+
				"			mso-table-rspace:0pt;"+
				"		}"+
				"		.ReadMsgBody{"+
				"			width:100%;"+
				"		}"+
				"		.ExternalClass{"+
				"			width:100%;"+
				"		}"+
				"		p,a,li,td,blockquote{"+
				"			mso-line-height-rule:exactly;"+
				"		}"+
				"		a[href^=tel],a[href^=sms]{"+
				"			color:inherit;"+
				"			cursor:default;"+
				"			text-decoration:none;"+
				"		}"+
				"		p,a,li,td,body,table,blockquote{"+
				"			-ms-text-size-adjust:100%;"+
				"			-webkit-text-size-adjust:100%;"+
				"		}"+
				"		.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{"+
				"			line-height:100%;"+
				"		}"+
				"		a[x-apple-data-detectors]{"+
				"			color:inherit !important;"+
				"			text-decoration:none !important;"+
				"			font-size:inherit !important;"+
				"			font-family:inherit !important;"+
				"			font-weight:inherit !important;"+
				"			line-height:inherit !important;"+
				"		}"+
				"		.templateContainer{"+
				"			max-width:600px !important;"+
				"		}"+
				"		a.mcnButton{"+
				"			display:block;"+
				"		}"+
				"		.mcnImage,.mcnRetinaImage{"+
				"			vertical-align:bottom;"+
				"		}"+
				"		.mcnTextContent{"+
				"			word-break:break-word;"+
				"		}"+
				"		.mcnTextContent img{"+
				"			height:auto !important;"+
				"		}"+
				"		.mcnDividerBlock{"+
				"			table-layout:fixed !important;"+
				"		}"+
				"	/*"+
				"	@tab Page"+
				"	@section Heading 1"+
				"	@style heading 1"+
				"	*/"+
				"		h1{"+
				"			/*@editable*/color:#222222;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:40px;"+
				"			/*@editable*/font-style:normal;"+
				"			/*@editable*/font-weight:bold;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/letter-spacing:normal;"+
				"			/*@editable*/text-align:center;"+
				"		}"+
				"	/*"+
				"	@tab Page"+
				"	@section Heading 2"+
				"	@style heading 2"+
				"	*/"+
				"		h2{"+
				"			/*@editable*/color:#222222;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:34px;"+
				"			/*@editable*/font-style:normal;"+
				"			/*@editable*/font-weight:bold;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/letter-spacing:normal;"+
				"			/*@editable*/text-align:left;"+
				"		}"+
				"	/*"+
				"	@tab Page"+
				"	@section Heading 3"+
				"	@style heading 3"+
				"	*/"+
				"		h3{"+
				"			/*@editable*/color:#444444;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:22px;"+
				"			/*@editable*/font-style:normal;"+
				"			/*@editable*/font-weight:bold;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/letter-spacing:normal;"+
				"			/*@editable*/text-align:left;"+
				"		}"+
				"	/*"+
				"	@tab Page"+
				"	@section Heading 4"+
				"	@style heading 4"+
				"	*/"+
				"		h4{"+
				"			/*@editable*/color:#999999;"+
				"			/*@editable*/font-family:Georgia;"+
				"			/*@editable*/font-size:20px;"+
				"			/*@editable*/font-style:italic;"+
				"			/*@editable*/font-weight:normal;"+
				"			/*@editable*/line-height:125%;"+
				"			/*@editable*/letter-spacing:normal;"+
				"			/*@editable*/text-align:left;"+
				"		}"+
				"	/*"+
				"	@tab Header"+
				"	@section Header Container Style"+
				"	*/"+
				"		#templateHeader{"+
				"			/*@editable*/background-color:#F7F7F7;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:45px;"+
				"			/*@editable*/padding-bottom:45px;"+
				"		}"+
				"	/*"+
				"	@tab Header"+
				"	@section Header Interior Style"+
				"	*/"+
				"		.headerContainer{"+
				"			/*@editable*/background-color:transparent;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:0;"+
				"			/*@editable*/padding-bottom:0;"+
				"		}"+
				"	/*"+
				"	@tab Header"+
				"	@section Header Text"+
				"	*/"+
				"		.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"+
				"			/*@editable*/color:#808080;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:16px;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/text-align:left;"+
				"		}"+
				"	/*"+
				"	@tab Header"+
				"	@section Header Link"+
				"	*/"+
				"		.headerContainer .mcnTextContent a,.headerContainer .mcnTextContent p a{"+
				"			/*@editable*/color:#00ADD8;"+
				"			/*@editable*/font-weight:normal;"+
				"			/*@editable*/text-decoration:underline;"+
				"		}"+
				"	/*"+
				"	@tab Body"+
				"	@section Body Container Style"+
				"	*/"+
				"		#templateBody{"+
				"			/*@editable*/background-color:#FFFFFF;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:36px;"+
				"			/*@editable*/padding-bottom:45px;"+
				"		}"+
				"	/*"+
				"	@tab Body"+
				"	@section Body Interior Style"+
				"	*/"+
				"		.bodyContainer{"+
				"			/*@editable*/background-color:transparent;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:0;"+
				"			/*@editable*/padding-bottom:0;"+
				"		}"+
				"	/*"+
				"	@tab Body"+
				"	@section Body Text"+
				"	*/"+
				"		.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{"+
				"			/*@editable*/color:#808080;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:16px;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/text-align:left;"+
				"		}"+
				"	/*"+
				"	@tab Body"+
				"	@section Body Link"+
				"	*/"+
				"		.bodyContainer .mcnTextContent a,.bodyContainer .mcnTextContent p a{"+
				"			/*@editable*/color:#00ADD8;"+
				"			/*@editable*/font-weight:normal;"+
				"			/*@editable*/text-decoration:underline;"+
				"		}"+
				"	/*"+
				"	@tab Footer"+
				"	@section Footer Style"+
				"	*/"+
				"		#templateFooter{"+
				"			/*@editable*/background-color:#333333;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:45px;"+
				"			/*@editable*/padding-bottom:63px;"+
				"		}"+
				"	/*"+
				"	@tab Footer"+
				"	@section Footer Interior Style"+
				"	*/"+
				"		.footerContainer{"+
				"			/*@editable*/background-color:transparent;"+
				"			/*@editable*/background-image:none;"+
				"			/*@editable*/background-repeat:no-repeat;"+
				"			/*@editable*/background-position:center;"+
				"			/*@editable*/background-size:cover;"+
				"			/*@editable*/border-top:0;"+
				"			/*@editable*/border-bottom:0;"+
				"			/*@editable*/padding-top:0;"+
				"			/*@editable*/padding-bottom:0;"+
				"		}"+
				"	/*"+
				"	@tab Footer"+
				"	@section Footer Text"+
				"	*/"+
				"		.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"+
				"			/*@editable*/color:#FFFFFF;"+
				"			/*@editable*/font-family:Helvetica;"+
				"			/*@editable*/font-size:12px;"+
				"			/*@editable*/line-height:150%;"+
				"			/*@editable*/text-align:center;"+
				"		}"+
				"	/*"+
				"	@tab Footer"+
				"	@section Footer Link"+
				"	*/"+
				"		.footerContainer .mcnTextContent a,.footerContainer .mcnTextContent p a{"+
				"			/*@editable*/color:#FFFFFF;"+
				"			/*@editable*/font-weight:normal;"+
				"			/*@editable*/text-decoration:underline;"+
				"		}"+
				"	@media only screen and (min-width:768px){"+
				"		.templateContainer{"+
				"			width:600px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		body,table,td,p,a,li,blockquote{"+
				"			-webkit-text-size-adjust:none !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		body{"+
				"			width:100% !important;"+
				"			min-width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnRetinaImage{"+
				"			max-width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImage{"+
				"			width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer,.mcnImageCardLeftImageContentContainer,.mcnImageCardRightImageContentContainer{"+
				"			max-width:100% !important;"+
				"			width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnBoxedTextContentContainer{"+
				"			min-width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageGroupContent{"+
				"			padding:9px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{"+
				"			padding-top:9px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageCardTopImageContent,.mcnCaptionBottomContent:last-child .mcnCaptionBottomImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{"+
				"			padding-top:18px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageCardBottomImageContent{"+
				"			padding-bottom:9px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageGroupBlockInner{"+
				"			padding-top:0 !important;"+
				"			padding-bottom:0 !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageGroupBlockOuter{"+
				"			padding-top:9px !important;"+
				"			padding-bottom:9px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnTextContent,.mcnBoxedTextContentColumn{"+
				"			padding-right:18px !important;"+
				"			padding-left:18px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{"+
				"			padding-right:18px !important;"+
				"			padding-bottom:0 !important;"+
				"			padding-left:18px !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"		.mcpreview-image-uploader{"+
				"			display:none !important;"+
				"			width:100% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Heading 1"+
				"	@tip Make the first-level headings larger in size for better readability on small screens."+
				"	*/"+
				"		h1{"+
				"			/*@editable*/font-size:30px !important;"+
				"			/*@editable*/line-height:125% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Heading 2"+
				"	@tip Make the second-level headings larger in size for better readability on small screens."+
				"	*/"+
				"		h2{"+
				"			/*@editable*/font-size:26px !important;"+
				"			/*@editable*/line-height:125% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Heading 3"+
				"	@tip Make the third-level headings larger in size for better readability on small screens."+
				"	*/"+
				"		h3{"+
				"			/*@editable*/font-size:20px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Heading 4"+
				"	@tip Make the fourth-level headings larger in size for better readability on small screens."+
				"	*/"+
				"		h4{"+
				"			/*@editable*/font-size:18px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Boxed Text"+
				"	@tip Make the boxed text larger in size for better readability on small screens. We recommend a font size of at least 16px."+
				"	*/"+
				"		.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{"+
				"			/*@editable*/font-size:14px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Header Text"+
				"	@tip Make the header text larger in size for better readability on small screens."+
				"	*/"+
				"		.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"+
				"			/*@editable*/font-size:16px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Body Text"+
				"	@tip Make the body text larger in size for better readability on small screens. We recommend a font size of at least 16px."+
				"	*/"+
				"		.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{"+
				"			/*@editable*/font-size:16px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}	@media only screen and (max-width: 480px){"+
				"	/*"+
				"	@tab Mobile Styles"+
				"	@section Footer Text"+
				"	@tip Make the footer content text larger in size for better readability on small screens."+
				"	*/"+
				"		.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"+
				"			/*@editable*/font-size:14px !important;"+
				"			/*@editable*/line-height:150% !important;"+
				"		}"+
				""+
				"}</style></head>"+
				"    <body>"+
				"		<!--*|IF:MC_PREVIEW_TEXT|*-->"+
				"		<!--[if !gte mso 9]><!----><span class=\"mcnPreviewText\" style=\"display:none; font-size:0px; line-height:0px; max-height:0px; max-width:0px; opacity:0; overflow:hidden; visibility:hidden; mso-hide:all;\">*|MC_PREVIEW_TEXT|*</span><!--<![endif]-->"+
				"		<!--*|END:IF|*-->"+
				"        <center>"+
				"            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\">"+
				"                <tr>"+
				"                    <td align=\"center\" valign=\"top\" id=\"bodyCell\">"+
				"                        <!-- BEGIN TEMPLATE // -->"+
				"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
				"							<tr>"+
				"								<td align=\"center\" valign=\"top\" id=\"templateHeader\" data-template-container>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"+
				"									<tr>"+
				"									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"+
				"									<![endif]-->"+
				"									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"+
				"										<tr>"+
				"                                			<td valign=\"top\" class=\"headerContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnImageBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnImageBlockOuter\">"+
				"            <tr>"+
				"                <td valign=\"top\" style=\"padding:9px\" class=\"mcnImageBlockInner\">"+
				"                    <table align=\"left\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"min-width:100%;\">"+
				"                        <tbody><tr>"+
				"                            <td class=\"mcnImageContent\" valign=\"top\" style=\"padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;\">"+
				"                                "+
				"                                    "+
				"                                        <img align=\"center\" alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/aa0020f0-d4d6-49e3-baa6-4a8722745480.jpg\" width=\"564\" style=\"max-width:600px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" class=\"mcnImage\">"+
				"                                    "+
				"                                "+
				"                            </td>"+
				"                        </tr>"+
				"                    </tbody></table>"+
				"                </td>"+
				"            </tr>"+
				"    </tbody>"+
				"</table></td>"+
				"										</tr>"+
				"									</table>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									</td>"+
				"									</tr>"+
				"									</table>"+
				"									<![endif]-->"+
				"								</td>"+
				"                            </tr>"+
				"							<tr>"+
				"								<td align=\"center\" valign=\"top\" id=\"templateBody\" data-template-container>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"+
				"									<tr>"+
				"									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"+
				"									<![endif]-->"+
				"									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"+
				"										<tr>"+
				"                                			<td valign=\"top\" class=\"bodyContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnTextBlockOuter\">"+
				"        <tr>"+
				"            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"+
				"              	<!--[if mso]>"+
				"				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"+
				"				<tr>"+
				"				<![endif]-->"+
				"			    "+
				"				<!--[if mso]>"+
				"				<td valign=\"top\" width=\"600\" style=\"width:600px;\">"+
				"				<![endif]-->"+
				"                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"+
				"                    <tbody><tr>"+
				"                        "+
				"                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"+
				"                        "+
				"                            <h3><span style=\"font-size:24px\">Welcome, </span></h3>"+firstName+
				"<br>"+
				"<strong><span style=\"font-size:32px\">Your Registration is </span></strong><span style=\"font-size:32px\"><strong>Successful</strong></span>"+
				""+
				"<p><span style=\"font-size:17px\">This Message is automated reply to your registration request .<br>"+
				"<br>"+
				"Log on to your Account to Subscribe for Selling your Vehicles and offer specific services you would like to offer. use the following below User ID and Temporary Password ( used for reset your Password ).</span><br>"+
				"<br>"+
				"<span style=\"font-size:19px\"><strong>Your Login User ID: \"  "+userid+"\"<br>"+
				"Temporary Password : \"</strong></span>"+pwd+
				"\"<br>"+
				" </p>"+
				""+
				"                        </td>"+
				"                    </tr>"+
				"                </tbody></table>"+
				"				<!--[if mso]>"+
				"				</td>"+
				"				<![endif]-->"+
				"                "+
				"				<!--[if mso]>"+
				"				</tr>"+
				"				</table>"+
				"				<![endif]-->"+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnButtonBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnButtonBlockOuter\">"+
				"        <tr>"+
				"            <td style=\"padding-top:0; padding-right:18px; padding-bottom:18px; padding-left:18px;\" valign=\"top\" align=\"center\" class=\"mcnButtonBlockInner\">"+
				"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonContentContainer\" style=\"border-collapse: separate !important;border-radius: 3px;background-color: #00ADD8;\">"+
				"                    <tbody>"+
				"                        <tr>"+
				"                            <td align=\"center\" valign=\"middle\" class=\"mcnButtonContent\" style=\"font-family: Helvetica; font-size: 18px; padding: 18px;\">"+
				"                                <a class=\"mcnButton \" title=\"business.autoscoop.com.au\" href=\"https://business.autoscoop.com.au\" target=\"_blank\" style=\"font-weight: bold;letter-spacing: -0.5px;line-height: 100%;text-align: center;text-decoration: none;color: #FFFFFF;\">Click to Login and  Reset your Password</a>"+
				"                            </td>"+
				"                        </tr>"+
				"                    </tbody>"+
				"                </table>"+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnDividerBlockOuter\">"+
				"        <tr>"+
				"            <td class=\"mcnDividerBlockInner\" style=\"min-width:100%; padding:18px;\">"+
				"                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"+
				"                    <tbody><tr>"+
				"                        <td>"+
				"                            <span></span>"+
				"                        </td>"+
				"                    </tr>"+
				"                </tbody></table>"+
				"<!--            "+
				"                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"+
				"                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"+
				"-->"+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table></td>"+
				"										</tr>"+
				"									</table>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									</td>"+
				"									</tr>"+
				"									</table>"+
				"									<![endif]-->"+
				"								</td>"+
				"                            </tr>"+
				"                            <tr>"+
				"								<td align=\"center\" valign=\"top\" id=\"templateFooter\" data-template-container>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"+
				"									<tr>"+
				"									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"+
				"									<![endif]-->"+
				"									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"+
				"										<tr>"+
				"                                			<td valign=\"top\" class=\"footerContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnFollowBlockOuter\">"+
				"        <tr>"+
				"            <td align=\"center\" valign=\"top\" style=\"padding:9px\" class=\"mcnFollowBlockInner\">"+
				"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentContainer\" style=\"min-width:100%;\">"+
				"    <tbody><tr>"+
				"        <td align=\"center\" style=\"padding-left:9px;padding-right:9px;\">"+
				"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\" class=\"mcnFollowContent\">"+
				"                <tbody><tr>"+
				"                    <td align=\"center\" valign=\"top\" style=\"padding-top:9px; padding-right:9px; padding-left:9px;\">"+
				"                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"                            <tbody><tr>"+
				"                                <td align=\"center\" valign=\"top\">"+
				"                                    <!--[if mso]>"+
				"                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"+
				"                                    <tr>"+
				"                                    <![endif]-->"+
				"                                    "+
				"                                        <!--[if mso]>"+
				"                                        <td align=\"center\" valign=\"top\">"+
				"                                        <![endif]-->"+
				"                                        "+
				"                                        "+
				"                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"+
				"                                                <tbody><tr>"+
				"                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"+
				"                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"+
				"                                                            <tbody><tr>"+
				"                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"+
				"                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"+
				"                                                                        <tbody><tr>"+
				"                                                                            "+
				"                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"+
				"                                                                                    <a href=\"http://www.facebook.com/autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-facebook-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"+
				"                                                                                </td>"+
				"                                                                            "+
				"                                                                            "+
				"                                                                        </tr>"+
				"                                                                    </tbody></table>"+
				"                                                                </td>"+
				"                                                            </tr>"+
				"                                                        </tbody></table>"+
				"                                                    </td>"+
				"                                                </tr>"+
				"                                            </tbody></table>"+
				"                                        "+
				"                                        <!--[if mso]>"+
				"                                        </td>"+
				"                                        <![endif]-->"+
				"                                    "+
				"                                        <!--[if mso]>"+
				"                                        <td align=\"center\" valign=\"top\">"+
				"                                        <![endif]-->"+
				"                                        "+
				"                                        "+
				"                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"+
				"                                                <tbody><tr>"+
				"                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"+
				"                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"+
				"                                                            <tbody><tr>"+
				"                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"+
				"                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"+
				"                                                                        <tbody><tr>"+
				"                                                                            "+
				"                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"+
				"                                                                                    <a href=\"https://www.autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-link-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"+
				"                                                                                </td>"+
				"                                                                            "+
				"                                                                            "+
				"                                                                        </tr>"+
				"                                                                    </tbody></table>"+
				"                                                                </td>"+
				"                                                            </tr>"+
				"                                                        </tbody></table>"+
				"                                                    </td>"+
				"                                                </tr>"+
				"                                            </tbody></table>"+
				"                                        "+
				"                                        <!--[if mso]>"+
				"                                        </td>"+
				"                                        <![endif]-->"+
				"                                    "+
				"                                        <!--[if mso]>"+
				"                                        <td align=\"center\" valign=\"top\">"+
				"                                        <![endif]-->"+
				"                                        "+
				"                                        "+
				"                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"+
				"                                                <tbody><tr>"+
				"                                                    <td valign=\"top\" style=\"padding-right:0; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"+
				"                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"+
				"                                                            <tbody><tr>"+
				"                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"+
				"                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"+
				"                                                                        <tbody><tr>"+
				"                                                                            "+
				"                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"+
				"                                                                                    <a href=\"http://www.linkedin.com/autoscoop_AU\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-light-linkedin-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"+
				"                                                                                </td>"+
				"                                                                            "+
				"                                                                            "+
				"                                                                        </tr>"+
				"                                                                    </tbody></table>"+
				"                                                                </td>"+
				"                                                            </tr>"+
				"                                                        </tbody></table>"+
				"                                                    </td>"+
				"                                                </tr>"+
				"                                            </tbody></table>"+
				"                                        "+
				"                                        <!--[if mso]>"+
				"                                        </td>"+
				"                                        <![endif]-->"+
				"                                    "+
				"                                    <!--[if mso]>"+
				"                                    </tr>"+
				"                                    </table>"+
				"                                    <![endif]-->"+
				"                                </td>"+
				"                            </tr>"+
				"                        </tbody></table>"+
				"                    </td>"+
				"                </tr>"+
				"            </tbody></table>"+
				"        </td>"+
				"    </tr>"+
				"</tbody></table>"+
				""+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnDividerBlockOuter\">"+
				"        <tr>"+
				"            <td class=\"mcnDividerBlockInner\" style=\"min-width:100%; padding:18px;\">"+
				"                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width: 100%;border-top: 2px solid #505050;\">"+
				"                    <tbody><tr>"+
				"                        <td>"+
				"                            <span></span>"+
				"                        </td>"+
				"                    </tr>"+
				"                </tbody></table>"+
				"<!--            "+
				"                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"+
				"                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"+
				"-->"+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"+
				"    <tbody class=\"mcnTextBlockOuter\">"+
				"        <tr>"+
				"            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"+
				"              	<!--[if mso]>"+
				"				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"+
				"				<tr>"+
				"				<![endif]-->"+
				"			    "+
				"				<!--[if mso]>"+
				"				<td valign=\"top\" width=\"600\" style=\"width:600px;\">"+
				"				<![endif]-->"+
				"                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"+
				"                    <tbody><tr>"+
				"                        "+
				"                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;\">"+
				"                        "+
				"                            <em>Copyright © 2018 Partners and Solutions pvt ltd, All rights reserved.</em><br>"+
				"Autoscoop is Trademark of Partners and Solutions Pvt Ltd.<br>"+
				"<br>"+
				"<strong>Our mailing address is: </strong>sales@autoscoop.com.au<br>"+
				"<br>"+
				"Want to change how you receive these emails?<br>"+
				"You can <a href=\"*|UPDATE_PROFILE|*\">update your preferences</a> or <a href=\"*|UNSUB|*\">unsubscribe from this list</a>.<br>"+
				" "+
				"                        </td>"+
				"                    </tr>"+
				"                </tbody></table>"+
				"				<!--[if mso]>"+
				"				</td>"+
				"				<![endif]-->"+
				"                "+
				"				<!--[if mso]>"+
				"				</tr>"+
				"				</table>"+
				"				<![endif]-->"+
				"            </td>"+
				"        </tr>"+
				"    </tbody>"+
				"</table></td>"+
				"										</tr>"+
				"									</table>"+
				"									<!--[if (gte mso 9)|(IE)]>"+
				"									</td>"+
				"									</tr>"+
				"									</table>"+
				"									<![endif]-->"+
				"								</td>"+
				"                            </tr>"+
				"                        </table>"+
				"                        <!-- // END TEMPLATE -->"+
				"                    </td>"+
				"                </tr>"+
				"            </table>"+
				"        </center>"+
				"    </body>"+
				"</html>";

		// String msg="<img
		// src=\"src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png\">";
		helper.setFrom(new InternetAddress("DoNOtReply@autoscoop.com.au", "DoNOtReply@autoscoop.com.au"));
		// message.setDescription(msg,"text/html; charset=utf-8");
		// message.setContent(msg,"text/html");
		message.setContent(msg, "text/html; charset=utf-8");
		mailSender.send(message);

		/*
		 * MimeMessage message=mailSender.createMimeMessage(); MimeMessageHelper
		 * helper=new MimeMessageHelper(message,true);
		 * helper.setSubject(subject); helper.setTo(to); helper.setText(text);
		 * helper.setFrom(new InternetAddress("support@autoscoop.com.au",
		 * "support@autoscoop.com.au")); // This mail has 2 part, the BODY and
		 * the embedded image MimeMultipart multipart = new
		 * MimeMultipart("related"); // first part (the html) BodyPart
		 * messageBodyPart = new MimeBodyPart(); //String htmlText =
		 * "<H1>Hello</H1><img src=\"cid:image\">"; String htmlText =
		 * "<img src=\"cid:image\">"; messageBodyPart.setContent(htmlText,
		 * "text/html"); // add it multipart.addBodyPart(messageBodyPart); //
		 * second part (the image) messageBodyPart = new MimeBodyPart();
		 * //DataSource fds = new
		 * FileDataSource("C:\\Users\\mk\\Desktop\\AutoscoopImg.png");
		 * FileReader fs; try { fs = new
		 * FileReader("src/main/java/au/com/pnspvtltd/mcd/service/abc.txt");
		 * if(fs!=null){ System.out.println("fiel is open"); } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * DataSource fds = new FileDataSource(
		 * "src\\main\\java\\au\\com\\pnspvtltd\\mcd\\service\\abc.txt");
		 * //src/main/java/au.com.pnspvtltd.mcd.service
		 * src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png
		 * //DataSource fds = new
		 * FileDataSource("localhost:8080\\MyCarDomain\\AutoscoopImg.png"); File
		 * f= new File(null); DataSource fds1 = new FileDataSource(f);
		 * messageBodyPart.setDataHandler(new DataHandler(fds));
		 * messageBodyPart.setHeader("Content-ID", "<image>"); // add image to
		 * the multipart multipart.addBodyPart(messageBodyPart); // put
		 * everything together message.setContent(multipart);
		 * mailSender.send(message);
		 */
		// Send the actual HTML message, as big as you like
		// Transport.send(message);
		System.out.println("Mail sent successfully!!!");
	}


	public void sendMailWelcome(String firstName, String lastName, String to, String subject, String text)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(text);
		// String msg="<html><i>Dear Subscriber<br/><br/><b>Thank you for
		// subscribing to Autoscoop updates!!!</b><br/><br/>We hope to delight
		// you with our range of seamlessly integrated offerings for buying,
		// selling, financing, Insurance and your services & maintenance needs
		// and much more for your automobiles needs starting with managing your
		// Cars! Get ready to transform your experience for all your automobile
		// related needs.<br/><br/>Stay tuned for
		// <b>more!</b><br/><br/>Regards<br/>Team Autoscoop</i></html> ";
		// String msg="<html><i>Dear Subscriber<br/><br/><b>You are invited to
		// register with Autoscoop!!!</b><br/><br/>We hope to delight you with
		// our range of seamlessly integrated offerings for buying, selling,
		// financing, Insurance and your services & maintenance needs and much
		// more for your automobiles needs starting with managing your Cars! Get
		// ready to transform your experience for all your automobile related
		// needs.<br/><br/>Stay tuned for <b>more!</b><br/><br/>Regards<br/>Team
		// Autoscoop</i></html> ";
		// String msg="<table border="+"+"+"0"+"+"+" width="+"+"+"100%"+"+"+"
		// cellspacing="+"+"+"0"+"+"+"
		// cellpadding="+"+"+"0"+"+"+"><tbody><tr><td
		// id="+"m_-587128254324886174m_4516884308862247289templateHeader"+"
		// align="+"center"+" valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289headerContainer"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><div><strong>AutoScoop</strong></div></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td
		// id="+"m_-587128254324886174m_4516884308862247289templateBody"+"
		// align="+"center"+" valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289bodyContainer"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h1>Hi There!.</h1><p>Your are invited to Register
		// with&nbsp;<a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">www.AutoScoop.com.au</a>,<br
		// /><br />I "+firstName+" "+lastName+" have started using&nbsp;<a
		// href="+"http://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=http://www.autoscoop.com.au/&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNFb1HS3q0ereNtYlgTRFEtV5uBaqg"+">AutoScoop</a>&nbsp;,
		// I&nbsp;recommend&nbsp;you to Join and reap the benifits, as it is a
		// one stop&nbsp;shop for all your Vehicle Needs.<br /><br />I use
		// AutoScoop for
		// following&nbsp;</p></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci3.googleusercontent.com/proxy/VbguPrat2o_zg7V__WjBB3F8a2v2ow5NGy_3d8RfQpk08AfqqwOjj7siYrVfQYbfiYFmD6mdUZnlvUJarMLseDA83j5Avb0yB0ilY-l7KEP46K746NLDPOCxuHRY_4JCmHWK_pxFYCmr01Zpsrt0sgLYEEXnZD1iKaXkALw=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7e3b8aec-7511-4dc0-8b05-536bbbf28b3d.jpg"+"
		// alt="+""+" width="+"564"+" align="+"center"+"
		// /></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h4>Welcome to the
		// convenience!</h4></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><div>AutoScoop is the one stop solution for all your
		// Vehicle needs, starting with Car! I started using AutoScoop, when I
		// am looking to</div><ul><li><strong>Buy My Next
		// Car!</strong></li><li><strong>Lease My next
		// Car!</strong></li><li><strong>Sell My current Car!.</strong>..<a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></li></ul></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci4.googleusercontent.com/proxy/M5VhyQZpICI4Gx7OfpnChJ2ub88B0gjvm7pFXNRhQza93YE5HBsExPiToQj-gIV1gc2BhAhl8g8CJxL_h8WL5x7VlnpCODrR9s4eLgcdKJ2eZt3VJuVm9izf456IW87cTc6ls8ebKDiV8IMCb7YVl6H7vYcMAEN7h3_weoM=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/ec116d84-903f-4384-b162-517c9f133ef9.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Your vehicle Finance</h3><p>Getting Finance is
		// integrated into into the Vehicle Buy process in itself or you can
		// request and access best quote or deals which suits your
		// requirement.<br /><br /><a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci6.googleusercontent.com/proxy/ik2OXNzoW9rDe3eg2BC49Upod-TmyZfS5kMy_OrSlbaiC0ovYXhemYJzIkieAk82ew1JzK2FFiyWBT2gJm9XEKSkQeAXQHRXl7B93AXKKbcVVzVb44Kuc9NuZGn7sdRcRB8Z6kFJ3WuwAXTsxxizMFr8hjB5tf8oOy4EZZE=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/d31f670d-bc34-4c0a-aa1b-9a39d751c0e7.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Your Vehicle Insurance</h3><p>Buying a New or
		// renewing or looking out for best deals and features for your next
		// Vehicle Insurance, We have simplified and integrated with your
		// favourate Insurance provider.<br /><br /><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci6.googleusercontent.com/proxy/ndZeQs69TQnTqrdR-qg5CysCHBwM5Z-53QMuH5VKxbYysmAFlEd7OZBzqKtez_cXwoNVONvzHdnHCQbyWOJOomzEtoRHZtOUfD1OEuTt6v_nHZXlY6NzPZ0TFppbuq3uZkw_mjIisrwIckKByzuJp6Sm8bp2u45y4x6wj90=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7ad77ed1-8859-4de0-a48b-a50dda967bf3.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Service &amp; Maintenance</h3><p>You need not to
		// an expert and you need not run arround, simply give your requirement
		// and we will connect you to best Mechanics available in Australia<br
		// /><br /><a href="+"https://www.autoscoop.com.au/"+"
		// target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">Learn
		// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci5.googleusercontent.com/proxy/hekSBkA969NAUmEB8UFcyLvRsGn4IbKfBv3_ewdTGTPvUtFFHblEETD2UaMdrp_s6CyB_PSG8xpPIzYYxaknKrcSjUSGoOceOwlpTScBdzXtWFVEsAboJ4o_4TufTv5O861sXpv61GdiDW4ORQxHjxVH04RhKtuJW3NVjCQ=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6842bce9-4054-484f-bc19-8b53176ccb00.png"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Transport&nbsp;Car<br /><br />Dont worry, you
		// will best deal with Australia wide network of transporter</h3><p><a
		// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
		// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd"+"
		// src="+"https://ci5.googleusercontent.com/proxy/ALngKwneygVXkPb3UFjtakzQs4oQ0gFnF7IwbHU9mJayYbTkA3ZOQOg3SWfus0SgQuzlsYn-75k0yN7vcQDNU11qp51ha8XYvQVYkkqmupgzJ7wO--fsOUfYYLOP-66wXMORk-J5UqMU_kEHoh1iOau_3gDU1gq65Gf4hcc=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/8a57faf3-4cdd-4e70-9a08-005c91bd0942.png"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>AutoScoop Logbook</h3><p>Invite people to your
		// next event, let them know about an upcoming sale, or give them a
		// sneak peek at a new collection that&rsquo;s coming
		// soon.</p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
		// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
		// cellpadding="+"0"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
		// valign="+"top"+"><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
		// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
		// align="+"right"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
		// valign="+"top"+"><img
		// class="+"m_-587128254324886174m_4516884308862247289mcnImage CToWUd
		// a6T"+" tabindex="+"0"+"
		// src="+"https://ci3.googleusercontent.com/proxy/N4uSXFfSvHkEEFdkiKAOx5nnreY69Z1f2ODnWfYhvbgoyn20IJM5fasdf31C8nSBPQgvfhsb7wxGzS1VdJgTw6RyFBQtZS8MUu_E2Z7u3DxcqWSp7uQrNPwglyJDyvZ4UQnh0WAJWR7vtdcXn6zsvTs7IwWW3mVBYcv0aGY=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6bad69b8-59f9-4dd0-bf7e-3f7141c17208.jpg"+"
		// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
		// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
		// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
		// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
		// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
		// valign="+"top"+"><h3>Smart Garage</h3><p>You need not buy anything
		// from us, you can still use of Smart Garage for free, yes you read it
		// right its free, simplfy and keeps track of the all important due
		// date's and get you best deals when it is required.</p><p><a
		// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
		// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
		// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
		// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table>";

		String msg = "<!doctype html>"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">"
				+ "	<head>" + "		<!-- NAME: FOLLOW UP -->" + "		<!--[if gte mso 15]>" + "		<xml>"
				+ "			<o:OfficeDocumentSettings>" + "			<o:AllowPNG/>"
				+ "			<o:PixelsPerInch>96</o:PixelsPerInch>" + "			</o:OfficeDocumentSettings>"
				+ "		</xml>" + "		<![endif]-->" + "		<meta charset=\"UTF-8\">"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "		<title>*|MC:SUBJECT|*</title>" + "        " + "    <style type=\"text/css\">" + "		p{"
				+ "			margin:10px 0;" + "			padding:0;" + "		}" + "		table{"
				+ "			border-collapse:collapse;" + "		}" + "		h1,h2,h3,h4,h5,h6{"
				+ "			display:block;" + "			margin:0;" + "			padding:0;" + "		}"
				+ "		img,a img{" + "			border:0;" + "			height:auto;" + "			outline:none;"
				+ "			text-decoration:none;" + "		}" + "		body,#bodyTable,#bodyCell{"
				+ "			height:100%;" + "			margin:0;" + "			padding:0;" + "			width:100%;"
				+ "		}" + "		.mcnPreviewText{" + "			display:none !important;" + "		}"
				+ "		#outlook a{" + "			padding:0;" + "		}" + "		img{"
				+ "			-ms-interpolation-mode:bicubic;" + "		}" + "		table{"
				+ "			mso-table-lspace:0pt;" + "			mso-table-rspace:0pt;" + "		}"
				+ "		.ReadMsgBody{" + "			width:100%;" + "		}" + "		.ExternalClass{"
				+ "			width:100%;" + "		}" + "		p,a,li,td,blockquote{"
				+ "			mso-line-height-rule:exactly;" + "		}" + "		a[href^=tel],a[href^=sms]{"
				+ "			color:inherit;" + "			cursor:default;" + "			text-decoration:none;"
				+ "		}" + "		p,a,li,td,body,table,blockquote{" + "			-ms-text-size-adjust:100%;"
				+ "			-webkit-text-size-adjust:100%;" + "		}"
				+ "		.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{"
				+ "			line-height:100%;" + "		}" + "		a[x-apple-data-detectors]{"
				+ "			color:inherit !important;" + "			text-decoration:none !important;"
				+ "			font-size:inherit !important;" + "			font-family:inherit !important;"
				+ "			font-weight:inherit !important;" + "			line-height:inherit !important;"
				+ "		}" + "		.templateContainer{" + "			max-width:600px !important;" + "		}"
				+ "		a.mcnButton{" + "			display:block;" + "		}" + "		.mcnImage{"
				+ "			vertical-align:bottom;" + "		}" + "		.mcnTextContent{"
				+ "			word-break:break-word;" + "		}" + "		.mcnTextContent img{"
				+ "			height:auto !important;" + "		}" + "		.mcnDividerBlock{"
				+ "			table-layout:fixed !important;" + "		}" + "	/*" + "	@tab Page" + "	@section Heading 1"
				+ "	@style heading 1" + "	*/" + "		h1{" + "			/*@editable*/color:#222222;"
				+ "			/*@editable*/font-family:Helvetica;" + "			/*@editable*/font-size:40px;"
				+ "			/*@editable*/font-style:normal;" + "			/*@editable*/font-weight:bold;"
				+ "			/*@editable*/line-height:150%;" + "			/*@editable*/letter-spacing:normal;"
				+ "			/*@editable*/text-align:center;" + "		}" + "	/*" + "	@tab Page"
				+ "	@section Heading 2" + "	@style heading 2" + "	*/" + "		h2{"
				+ "			/*@editable*/color:#222222;" + "			/*@editable*/font-family:Helvetica;"
				+ "			/*@editable*/font-size:34px;" + "			/*@editable*/font-style:normal;"
				+ "			/*@editable*/font-weight:bold;" + "			/*@editable*/line-height:150%;"
				+ "			/*@editable*/letter-spacing:normal;" + "			/*@editable*/text-align:left;"
				+ "		}" + "	/*" + "	@tab Page" + "	@section Heading 3" + "	@style heading 3" + "	*/" + "		h3{"
				+ "			/*@editable*/color:#444444;" + "			/*@editable*/font-family:Helvetica;"
				+ "			/*@editable*/font-size:22px;" + "			/*@editable*/font-style:normal;"
				+ "			/*@editable*/font-weight:bold;" + "			/*@editable*/line-height:150%;"
				+ "			/*@editable*/letter-spacing:normal;" + "			/*@editable*/text-align:center;"
				+ "		}" + "	/*" + "	@tab Page" + "	@section Heading 4" + "	@style heading 4" + "	*/" + "		h4{"
				+ "			/*@editable*/color:#999999;" + "			/*@editable*/font-family:Georgia;"
				+ "			/*@editable*/font-size:20px;" + "			/*@editable*/font-style:italic;"
				+ "			/*@editable*/font-weight:normal;" + "			/*@editable*/line-height:125%;"
				+ "			/*@editable*/letter-spacing:normal;" + "			/*@editable*/text-align:left;"
				+ "		}" + "	/*" + "	@tab Header" + "	@section Header Container Style" + "	*/"
				+ "		#templateHeader{" + "			/*@editable*/background-color:#F7F7F7;"
				+ "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:54px;" + "			/*@editable*/padding-bottom:54px;" + "		}"
				+ "	/*" + "	@tab Header" + "	@section Header Interior Style" + "	*/" + "		.headerContainer{"
				+ "			/*@editable*/background-color:transparent;" + "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:0;" + "			/*@editable*/padding-bottom:0;" + "		}"
				+ "	/*" + "	@tab Header" + "	@section Header Text" + "	*/"
				+ "		.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"
				+ "			/*@editable*/color:#808080;" + "			/*@editable*/font-family:Helvetica;"
				+ "			/*@editable*/font-size:16px;" + "			/*@editable*/line-height:150%;"
				+ "			/*@editable*/text-align:left;" + "		}" + "	/*" + "	@tab Header"
				+ "	@section Header Link" + "	*/"
				+ "		.headerContainer .mcnTextContent a,.headerContainer .mcnTextContent p a{"
				+ "			/*@editable*/color:#00ADD8;" + "			/*@editable*/font-weight:normal;"
				+ "			/*@editable*/text-decoration:underline;" + "		}" + "	/*" + "	@tab Body"
				+ "	@section Body Container Style" + "	*/" + "		#templateBody{"
				+ "			/*@editable*/background-color:#ffffff;" + "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:27px;" + "			/*@editable*/padding-bottom:54px;" + "		}"
				+ "	/*" + "	@tab Body" + "	@section Body Interior Style" + "	*/" + "		.bodyContainer{"
				+ "			/*@editable*/background-color:#transparent;"
				+ "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:0;" + "			/*@editable*/padding-bottom:0;" + "		}"
				+ "	/*" + "	@tab Body" + "	@section Body Text" + "	*/"
				+ "		.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{"
				+ "			/*@editable*/color:#808080;" + "			/*@editable*/font-family:Helvetica;"
				+ "			/*@editable*/font-size:16px;" + "			/*@editable*/line-height:150%;"
				+ "			/*@editable*/text-align:left;" + "		}" + "	/*" + "	@tab Body" + "	@section Body Link"
				+ "	*/" + "		.bodyContainer .mcnTextContent a,.bodyContainer .mcnTextContent p a{"
				+ "			/*@editable*/color:#00ADD8;" + "			/*@editable*/font-weight:normal;"
				+ "			/*@editable*/text-decoration:underline;" + "		}" + "	/*" + "	@tab Footer"
				+ "	@section Footer Style" + "	*/" + "		#templateFooter{"
				+ "			/*@editable*/background-color:#333333;" + "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:45px;" + "			/*@editable*/padding-bottom:63px;" + "		}"
				+ "	/*" + "	@tab Footer" + "	@section Footer Interior Style" + "	*/" + "		.footerContainer{"
				+ "			/*@editable*/background-color:transparent;" + "			/*@editable*/background-image:none;"
				+ "			/*@editable*/background-repeat:no-repeat;"
				+ "			/*@editable*/background-position:center;" + "			/*@editable*/background-size:cover;"
				+ "			/*@editable*/border-top:0;" + "			/*@editable*/border-bottom:0;"
				+ "			/*@editable*/padding-top:0;" + "			/*@editable*/padding-bottom:0;" + "		}"
				+ "	/*" + "	@tab Footer" + "	@section Footer Text" + "	*/"
				+ "		.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"
				+ "			/*@editable*/color:#FFFFFF;" + "			/*@editable*/font-family:Helvetica;"
				+ "			/*@editable*/font-size:12px;" + "			/*@editable*/line-height:150%;"
				+ "			/*@editable*/text-align:center;" + "		}" + "	/*" + "	@tab Footer"
				+ "	@section Footer Link" + "	*/"
				+ "		.footerContainer .mcnTextContent a,.footerContainer .mcnTextContent p a{"
				+ "			/*@editable*/color:#FFFFFF;" + "			/*@editable*/font-weight:normal;"
				+ "			/*@editable*/text-decoration:underline;" + "		}"
				+ "	@media only screen and (min-width:768px){" + "		.templateContainer{"
				+ "			width:600px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		body,table,td,p,a,li,blockquote{"
				+ "			-webkit-text-size-adjust:none !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		body{" + "			width:100% !important;"
				+ "			min-width:100% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnImage{"
				+ "			width:100% !important;" + "		}" + "" + "}	@media only screen and (max-width: 480px){"
				+ "		.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{"
				+ "			max-width:100% !important;" + "			width:100% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnBoxedTextContentContainer{"
				+ "			min-width:100% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnImageGroupContent{"
				+ "			padding:9px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "		.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{"
				+ "			padding-top:9px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "		.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{"
				+ "			padding-top:18px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnImageCardBottomImageContent{"
				+ "			padding-bottom:9px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnImageGroupBlockInner{"
				+ "			padding-top:0 !important;" + "			padding-bottom:0 !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnImageGroupBlockOuter{"
				+ "			padding-top:9px !important;" + "			padding-bottom:9px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcnTextContent,.mcnBoxedTextContentColumn{"
				+ "			padding-right:18px !important;" + "			padding-left:18px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){"
				+ "		.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{"
				+ "			padding-right:18px !important;" + "			padding-bottom:0 !important;"
				+ "			padding-left:18px !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "		.mcpreview-image-uploader{"
				+ "			display:none !important;" + "			width:100% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 1"
				+ "	@tip Make the first-level headings larger in size for better readability on small screens." + "	*/"
				+ "		h1{" + "			/*@editable*/font-size:30px !important;"
				+ "			/*@editable*/line-height:125% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 2"
				+ "	@tip Make the second-level headings larger in size for better readability on small screens."
				+ "	*/" + "		h2{" + "			/*@editable*/font-size:26px !important;"
				+ "			/*@editable*/line-height:125% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 3"
				+ "	@tip Make the third-level headings larger in size for better readability on small screens." + "	*/"
				+ "		h3{" + "			/*@editable*/font-size:20px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Heading 4"
				+ "	@tip Make the fourth-level headings larger in size for better readability on small screens."
				+ "	*/" + "		h4{" + "			/*@editable*/font-size:18px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Boxed Text"
				+ "	@tip Make the boxed text larger in size for better readability on small screens. We recommend a font size of at least 16px."
				+ "	*/"
				+ "		.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{"
				+ "			/*@editable*/font-size:14px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Header Text"
				+ "	@tip Make the header text larger in size for better readability on small screens." + "	*/"
				+ "		.headerContainer .mcnTextContent,.headerContainer .mcnTextContent p{"
				+ "			/*@editable*/font-size:16px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Body Text"
				+ "	@tip Make the body text larger in size for better readability on small screens. We recommend a font size of at least 16px."
				+ "	*/" + "		.bodyContainer .mcnTextContent,.bodyContainer .mcnTextContent p{"
				+ "			/*@editable*/font-size:16px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + ""
				+ "}	@media only screen and (max-width: 480px){" + "	/*" + "	@tab Mobile Styles"
				+ "	@section Footer Text"
				+ "	@tip Make the footer content text larger in size for better readability on small screens." + "	*/"
				+ "		.footerContainer .mcnTextContent,.footerContainer .mcnTextContent p{"
				+ "			/*@editable*/font-size:14px !important;"
				+ "			/*@editable*/line-height:150% !important;" + "		}" + "" + "}</style></head>"
				+ "    <body>" + "		<!--*|IF:MC_PREVIEW_TEXT|*-->"
				+ "		<!--[if !gte mso 9]><!----><span class=\"mcnPreviewText\" style=\"display:none; font-size:0px; line-height:0px; max-height:0px; max-width:0px; opacity:0; overflow:hidden; visibility:hidden; mso-hide:all;\">*|MC_PREVIEW_TEXT|*</span><!--<![endif]-->"
				+ "		<!--*|END:IF|*-->" + "        <center>"
				+ "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\">"
				+ "                <tr>" + "                    <td align=\"center\" valign=\"top\" id=\"bodyCell\">"
				+ "                        <!-- BEGIN TEMPLATE // -->"
				+ "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"
				+ "							<tr>"
				+ "								<td align=\"center\" valign=\"top\" id=\"templateHeader\" data-template-container>"
				+ "									<!--[if gte mso 9]>"
				+ "									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "									<tr>"
				+ "									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "									<![endif]-->"
				+ "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "										<tr>"
				+ "                                			<td valign=\"top\" class=\"headerContainer\"></td>"
				+ "										</tr>" + "									</table>"
				+ "									<!--[if gte mso 9]>" + "									</td>"
				+ "									</tr>" + "									</table>"
				+ "									<![endif]-->" + "								</td>"
				+ "                            </tr>" + "							<tr>"
				+ "								<td align=\"center\" valign=\"top\" id=\"templateBody\" data-template-container>"
				+ "									<!--[if gte mso 9]>"
				+ "									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "									<tr>"
				+ "									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "									<![endif]-->"
				+ "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "										<tr>"
				+ "                                			<td valign=\"top\" class=\"bodyContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnTextBlockOuter\">" + "        <tr>"
				+ "            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top:9px;\">"
				+ "              	<!--[if mso]>"
				+ "				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">"
				+ "				<tr>" + "				<![endif]-->" + "			    "
				+ "				<!--[if mso]>"
				+ "				<td valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "				<![endif]-->"
				+ "                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%; min-width:100%;\" width=\"100%\" class=\"mcnTextContentContainer\">"
				+ "                    <tbody><tr>" + "                        "
				+ "                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding: 0px 18px 9px;color: #EA5B3A;font-style: normal;font-weight: bold;\">"
				+ "                        "
				+ "                            <h1 class=\"null\"><span style=\"color:#333366\"><span style=\"font-family:source sans pro,helvetica neue,helvetica,arial,sans-serif\"><span style=\"font-size:38px\">AutoScoop</span></span></span></h1>"
				+ "" + "                        </td>" + "                    </tr>"
				+ "                </tbody></table>" + "				<!--[if mso]>" + "				</td>"
				+ "				<![endif]-->" + "                " + "				<!--[if mso]>"
				+ "				</tr>" + "				</table>" + "				<![endif]-->" + "            </td>"
				+ "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnImageBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnImageBlockOuter\">" + "            <tr>"
				+ "                <td valign=\"top\" style=\"padding:9px\" class=\"mcnImageBlockInner\">"
				+ "                    <table align=\"left\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"min-width:100%;\">"
				+ "                        <tbody><tr>"
				+ "                            <td class=\"mcnImageContent\" valign=\"top\" style=\"padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;\">"
				+ "                                " + "                                    "
				+ "                                        <img align=\"center\" alt=\"\" src=\"https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/729a440d-c992-498c-b744-2caaebdfa70f.png\" width=\"564\" style=\"max-width:1200px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" class=\"mcnImage\">"
				+ "                                    " + "                                "
				+ "                            </td>" + "                        </tr>"
				+ "                    </tbody></table>" + "                </td>" + "            </tr>"
				+ "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%; padding: 9px 18px 0px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnButtonBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnButtonBlockOuter\">" + "        <tr>"
				+ "            <td style=\"padding-top:0; padding-right:18px; padding-bottom:18px; padding-left:18px;\" valign=\"top\" align=\"center\" class=\"mcnButtonBlockInner\">"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonContentContainer\" style=\"border-collapse: separate !important;border-radius: 3px;background-color: #00ADD8;\">"
				+ "                    <tbody>" + "                        <tr>"
				+ "                            <td align=\"center\" valign=\"middle\" class=\"mcnButtonContent\" style=\"font-family: Helvetica; font-size: 18px; padding: 18px;\">"
				+ "                                <a class=\"mcnButton \" title=\"Visit            Now\" href=\"https://www.autoscoop.com.au\" target=\"_self\" style=\"font-weight: bold;letter-spacing: -0.5px;line-height: 100%;text-align: center;text-decoration: none;color: #FFFFFF;\">Visit            Now</a>"
				+ "                            </td>" + "                        </tr>" + "                    </tbody>"
				+ "                </table>" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%; padding: 18px 18px 0px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>"
				+ "</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnFollowBlockOuter\">" + "        <tr>"
				+ "            <td align=\"center\" valign=\"top\" style=\"padding:9px\" class=\"mcnFollowBlockInner\">"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentContainer\" style=\"min-width:100%;\">"
				+ "    <tbody><tr>" + "        <td align=\"center\" style=\"padding-left:9px;padding-right:9px;\">"
				+ "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\" class=\"mcnFollowContent\">"
				+ "                <tbody><tr>"
				+ "                    <td align=\"center\" valign=\"top\" style=\"padding-top:9px; padding-right:9px; padding-left:9px;\">"
				+ "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"
				+ "                            <tbody><tr>"
				+ "                                <td align=\"center\" valign=\"top\">"
				+ "                                    <!--[if mso]>"
				+ "                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
				+ "                                    <tr>" + "                                    <![endif]-->"
				+ "                                    " + "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://www.facebook.com/autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://plus.google.com/AutoScoop Australia\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-googleplus-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"https://au.linkedin.com/company/autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-linkedin-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"http://www.twitter.com/AutoscoopA\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"mailto:hello@autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-forwardtofriend-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                        <!--[if mso]>"
				+ "                                        <td align=\"center\" valign=\"top\">"
				+ "                                        <![endif]-->" + "                                        "
				+ "                                        "
				+ "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:inline;\">"
				+ "                                                <tbody><tr>"
				+ "                                                    <td valign=\"top\" style=\"padding-right:0; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\">"
				+ "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\">"
				+ "                                                            <tbody><tr>"
				+ "                                                                <td align=\"left\" valign=\"middle\" style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\">"
				+ "                                                                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\">"
				+ "                                                                        <tbody><tr>"
				+ "                                                                            "
				+ "                                                                                <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\">"
				+ "                                                                                    <a href=\"https://www.autoscoop.com.au\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/color-link-48.png\" style=\"display:block;\" height=\"24\" width=\"24\" class=\"\"></a>"
				+ "                                                                                </td>"
				+ "                                                                            "
				+ "                                                                            "
				+ "                                                                        </tr>"
				+ "                                                                    </tbody></table>"
				+ "                                                                </td>"
				+ "                                                            </tr>"
				+ "                                                        </tbody></table>"
				+ "                                                    </td>"
				+ "                                                </tr>"
				+ "                                            </tbody></table>"
				+ "                                        " + "                                        <!--[if mso]>"
				+ "                                        </td>"
				+ "                                        <![endif]-->" + "                                    "
				+ "                                    <!--[if mso]>" + "                                    </tr>"
				+ "                                    </table>" + "                                    <![endif]-->"
				+ "                                </td>" + "                            </tr>"
				+ "                        </tbody></table>" + "                    </td>" + "                </tr>"
				+ "            </tbody></table>" + "        </td>" + "    </tr>" + "</tbody></table>" + ""
				+ "            </td>" + "        </tr>" + "    </tbody>" + "</table></td>"
				+ "										</tr>" + "									</table>"
				+ "									<!--[if gte mso 9]>" + "									</td>"
				+ "									</tr>" + "									</table>"
				+ "									<![endif]-->" + "								</td>"
				+ "                            </tr>" + "                            <tr>"
				+ "								<td align=\"center\" valign=\"top\" id=\"templateFooter\" data-template-container>"
				+ "									<!--[if gte mso 9]>"
				+ "									<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">"
				+ "									<tr>"
				+ "									<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">"
				+ "									<![endif]-->"
				+ "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">"
				+ "										<tr>"
				+ "                                			<td valign=\"top\" class=\"footerContainer\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width:100%;\">"
				+ "    <tbody class=\"mcnDividerBlockOuter\">" + "        <tr>"
				+ "            <td class=\"mcnDividerBlockInner\" style=\"min-width:100%; padding:18px;\">"
				+ "                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width: 100%;border-top: 2px solid #505050;\">"
				+ "                    <tbody><tr>" + "                        <td>"
				+ "                            <span></span>" + "                        </td>"
				+ "                    </tr>" + "                </tbody></table>" + "<!--            "
				+ "                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">"
				+ "                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />"
				+ "-->" + "            </td>" + "        </tr>" + "    </tbody>" + "</table></td>"
				+ "										</tr>" + "									</table>"
				+ "									<!--[if gte mso 9]>" + "									</td>"
				+ "									</tr>" + "									</table>"
				+ "									<![endif]-->" + "								</td>"
				+ "                            </tr>" + "                        </table>"
				+ "                        <!-- // END TEMPLATE -->" + "                    </td>"
				+ "                </tr>" + "            </table>" + "        </center>" + "    </body>" + "</html>";

		// String msg="<img
		// src=\"src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png\">";
		helper.setFrom(new InternetAddress("support@autoscoop.com.au", "support@autoscoop.com.au"));
		// message.setDescription(msg,"text/html; charset=utf-8");
		// message.setContent(msg,"text/html");
		message.setContent(msg, "text/html; charset=utf-8");
		mailSender.send(message);

		/*
		 * MimeMessage message=mailSender.createMimeMessage(); MimeMessageHelper
		 * helper=new MimeMessageHelper(message,true);
		 * helper.setSubject(subject); helper.setTo(to); helper.setText(text);
		 * helper.setFrom(new InternetAddress("support@autoscoop.com.au",
		 * "support@autoscoop.com.au")); // This mail has 2 part, the BODY and
		 * the embedded image MimeMultipart multipart = new
		 * MimeMultipart("related"); // first part (the html) BodyPart
		 * messageBodyPart = new MimeBodyPart(); //String htmlText =
		 * "<H1>Hello</H1><img src=\"cid:image\">"; String htmlText =
		 * "<img src=\"cid:image\">"; messageBodyPart.setContent(htmlText,
		 * "text/html"); // add it multipart.addBodyPart(messageBodyPart); //
		 * second part (the image) messageBodyPart = new MimeBodyPart();
		 * //DataSource fds = new
		 * FileDataSource("C:\\Users\\mk\\Desktop\\AutoscoopImg.png");
		 * FileReader fs; try { fs = new
		 * FileReader("src/main/java/au/com/pnspvtltd/mcd/service/abc.txt");
		 * if(fs!=null){ System.out.println("fiel is open"); } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * DataSource fds = new FileDataSource(
		 * "src\\main\\java\\au\\com\\pnspvtltd\\mcd\\service\\abc.txt");
		 * //src/main/java/au.com.pnspvtltd.mcd.service
		 * src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png
		 * //DataSource fds = new
		 * FileDataSource("localhost:8080\\MyCarDomain\\AutoscoopImg.png"); File
		 * f= new File(null); DataSource fds1 = new FileDataSource(f);
		 * messageBodyPart.setDataHandler(new DataHandler(fds));
		 * messageBodyPart.setHeader("Content-ID", "<image>"); // add image to
		 * the multipart multipart.addBodyPart(messageBodyPart); // put
		 * everything together message.setContent(multipart);
		 * mailSender.send(message);
		 */
		// Send the actual HTML message, as big as you like
		// Transport.send(message);
		System.out.println("Mail sent successfully!!!");
	}

	public void sendMailQuestion(String question, String firstName, String lastName, String to, String subject,
			String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo("support@autoscoop.com.au");
		helper.setText(text);
		String msg = "<html><i>Hi Autoscoop Support<br/><br/><b>We have a Query from !!!</b><br/><br/>" + firstName
				+ " " + lastName + " " + "The Query is :" + question
				+ "We hope to delight you with our range of seamlessly integrated offerings for buying, selling, financing, Insurance and your services & maintenance needs and much more for your automobiles needs starting with managing your Cars! Get ready to transform your experience for all your automobile related needs.<br/><br/>Stay tuned for <b>more!</b><br/><br/>Regards<br/>Team Autoscoop</i></html> ";
				// String msg="<html><i>Dear Subscriber<br/><br/><b>You are
				// invited to register with Autoscoop!!!</b><br/><br/>We hope to
				// delight you with our range of seamlessly integrated offerings
				// for buying, selling, financing, Insurance and your services &
				// maintenance needs and much more for your automobiles needs
				// starting with managing your Cars! Get ready to transform your
				// experience for all your automobile related
				// needs.<br/><br/>Stay tuned for
				// <b>more!</b><br/><br/>Regards<br/>Team Autoscoop</i></html>
				// ";
				// String msg="<table border="+"+"+"0"+"+"+"
				// width="+"+"+"100%"+"+"+" cellspacing="+"+"+"0"+"+"+"
				// cellpadding="+"+"+"0"+"+"+"><tbody><tr><td
				// id="+"m_-587128254324886174m_4516884308862247289templateHeader"+"
				// align="+"center"+" valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289headerContainer"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><div><strong>AutoScoop</strong></div></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td
				// id="+"m_-587128254324886174m_4516884308862247289templateBody"+"
				// align="+"center"+" valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289templateContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"center"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289bodyContainer"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h1>Hi There!.</h1><p>Your are invited to
				// Register with&nbsp;<a
				// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">www.AutoScoop.com.au</a>,<br
				// /><br />I "+firstName+" "+lastName+" have started
				// using&nbsp;<a href="+"http://www.autoscoop.com.au/"+"
				// target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=http://www.autoscoop.com.au/&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNFb1HS3q0ereNtYlgTRFEtV5uBaqg"+">AutoScoop</a>&nbsp;,
				// I&nbsp;recommend&nbsp;you to Join and reap the benifits, as
				// it is a one stop&nbsp;shop for all your Vehicle Needs.<br
				// /><br />I use AutoScoop for
				// following&nbsp;</p></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnImageBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnImageContentContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci3.googleusercontent.com/proxy/VbguPrat2o_zg7V__WjBB3F8a2v2ow5NGy_3d8RfQpk08AfqqwOjj7siYrVfQYbfiYFmD6mdUZnlvUJarMLseDA83j5Avb0yB0ilY-l7KEP46K746NLDPOCxuHRY_4JCmHWK_pxFYCmr01Zpsrt0sgLYEEXnZD1iKaXkALw=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7e3b8aec-7511-4dc0-8b05-536bbbf28b3d.jpg"+"
				// alt="+""+" width="+"564"+" align="+"center"+"
				// /></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h4>Welcome to the
				// convenience!</h4></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContentContainer"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><div>AutoScoop is the one stop solution for
				// all your Vehicle needs, starting with Car! I started using
				// AutoScoop, when I am looking to</div><ul><li><strong>Buy My
				// Next Car!</strong></li><li><strong>Lease My next
				// Car!</strong></li><li><strong>Sell My current
				// Car!.</strong>..<a href="+"https://www.autoscoop.com.au/"+"
				// target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
				// More!</a></li></ul></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci4.googleusercontent.com/proxy/M5VhyQZpICI4Gx7OfpnChJ2ub88B0gjvm7pFXNRhQza93YE5HBsExPiToQj-gIV1gc2BhAhl8g8CJxL_h8WL5x7VlnpCODrR9s4eLgcdKJ2eZt3VJuVm9izf456IW87cTc6ls8ebKDiV8IMCb7YVl6H7vYcMAEN7h3_weoM=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/ec116d84-903f-4384-b162-517c9f133ef9.jpg"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>Your vehicle Finance</h3><p>Getting
				// Finance is integrated into into the Vehicle Buy process in
				// itself or you can request and access best quote or deals
				// which suits your requirement.<br /><br /><a
				// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
				// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci6.googleusercontent.com/proxy/ik2OXNzoW9rDe3eg2BC49Upod-TmyZfS5kMy_OrSlbaiC0ovYXhemYJzIkieAk82ew1JzK2FFiyWBT2gJm9XEKSkQeAXQHRXl7B93AXKKbcVVzVb44Kuc9NuZGn7sdRcRB8Z6kFJ3WuwAXTsxxizMFr8hjB5tf8oOy4EZZE=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/d31f670d-bc34-4c0a-aa1b-9a39d751c0e7.jpg"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>Your Vehicle Insurance</h3><p>Buying a
				// New or renewing or looking out for best deals and features
				// for your next Vehicle Insurance, We have simplified and
				// integrated with your favourate Insurance provider.<br /><br
				// /><a href="+"https://www.autoscoop.com.au/"+"
				// target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684224000&amp;usg=AFQjCNF1vo6Qeo61jdAG3mwdOHfBWSpigg"+">Learn
				// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerBlockInner"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnDividerContent"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td>&nbsp;</td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci6.googleusercontent.com/proxy/ndZeQs69TQnTqrdR-qg5CysCHBwM5Z-53QMuH5VKxbYysmAFlEd7OZBzqKtez_cXwoNVONvzHdnHCQbyWOJOomzEtoRHZtOUfD1OEuTt6v_nHZXlY6NzPZ0TFppbuq3uZkw_mjIisrwIckKByzuJp6Sm8bp2u45y4x6wj90=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/7ad77ed1-8859-4de0-a48b-a50dda967bf3.jpg"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>Service &amp; Maintenance</h3><p>You
				// need not to an expert and you need not run arround, simply
				// give your requirement and we will connect you to best
				// Mechanics available in Australia<br /><br /><a
				// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">Learn
				// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci5.googleusercontent.com/proxy/hekSBkA969NAUmEB8UFcyLvRsGn4IbKfBv3_ewdTGTPvUtFFHblEETD2UaMdrp_s6CyB_PSG8xpPIzYYxaknKrcSjUSGoOceOwlpTScBdzXtWFVEsAboJ4o_4TufTv5O861sXpv61GdiDW4ORQxHjxVH04RhKtuJW3NVjCQ=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6842bce9-4054-484f-bc19-8b53176ccb00.png"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>Transport&nbsp;Car<br /><br />Dont
				// worry, you will best deal with Australia wide network of
				// transporter</h3><p><a
				// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
				// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
				// More</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd"+"
				// src="+"https://ci5.googleusercontent.com/proxy/ALngKwneygVXkPb3UFjtakzQs4oQ0gFnF7IwbHU9mJayYbTkA3ZOQOg3SWfus0SgQuzlsYn-75k0yN7vcQDNU11qp51ha8XYvQVYkkqmupgzJ7wO--fsOUfYYLOP-66wXMORk-J5UqMU_kEHoh1iOau_3gDU1gq65Gf4hcc=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/8a57faf3-4cdd-4e70-9a08-005c91bd0942.png"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionRightTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>AutoScoop Logbook</h3><p>Invite people
				// to your next event, let them know about an upcoming sale, or
				// give them a sneak peek at a new collection that&rsquo;s
				// coming
				// soon.</p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlock"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockOuter"+"><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionBlockInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentOuter"+"
				// border="+"0"+" width="+"100%"+" cellspacing="+"0"+"
				// cellpadding="+"0"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftContentInner"+"
				// valign="+"top"+"><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContentContainer"+"
				// border="+"0"+" cellspacing="+"0"+" cellpadding="+"0"+"
				// align="+"right"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftImageContent"+"
				// valign="+"top"+"><img
				// class="+"m_-587128254324886174m_4516884308862247289mcnImage
				// CToWUd a6T"+" tabindex="+"0"+"
				// src="+"https://ci3.googleusercontent.com/proxy/N4uSXFfSvHkEEFdkiKAOx5nnreY69Z1f2ODnWfYhvbgoyn20IJM5fasdf31C8nSBPQgvfhsb7wxGzS1VdJgTw6RyFBQtZS8MUu_E2Z7u3DxcqWSp7uQrNPwglyJDyvZ4UQnh0WAJWR7vtdcXn6zsvTs7IwWW3mVBYcv0aGY=s0-d-e1-ft#https://gallery.mailchimp.com/6ea57fb0281d735458431e0ad/images/6bad69b8-59f9-4dd0-bf7e-3f7141c17208.jpg"+"
				// alt="+""+" width="+"264"+" /></td></tr></tbody></table><table
				// class="+"m_-587128254324886174m_4516884308862247289mcnCaptionLeftTextContentContainer"+"
				// border="+"0"+" width="+"264"+" cellspacing="+"0"+"
				// cellpadding="+"0"+" align="+"left"+"><tbody><tr><td
				// class="+"m_-587128254324886174m_4516884308862247289mcnTextContent"+"
				// valign="+"top"+"><h3>Smart Garage</h3><p>You need not buy
				// anything from us, you can still use of Smart Garage for free,
				// yes you read it right its free, simplfy and keeps track of
				// the all important due date's and get you best deals when it
				// is required.</p><p><a
				// href="+"https://mail.google.com/mail/u/0/#m_-587128254324886174_m_4516884308862247289_"+">L</a><a
				// href="+"https://www.autoscoop.com.au/"+" target="+"_blank"+"
				// data-saferedirecturl="+"https://www.google.com/url?hl=en&amp;q=https://www.autoscoop.com.au&amp;source=gmail&amp;ust=1503502684225000&amp;usg=AFQjCNEBDlbopqTEWuw08hOI734UvleX4g"+">earn
				// More!</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table>";

		// String msg="<img
		// src=\"src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png\">";
		helper.setFrom(new InternetAddress("support@autoscoop.com.au", "support@autoscoop.com.au"));
		message.setDescription(msg, "text/html");
		message.setContent(msg, "text/html");
		// message.setContent(msg, "text/html; charset=utf-8" );
		mailSender.send(message);

		/*
		 * MimeMessage message=mailSender.createMimeMessage(); MimeMessageHelper
		 * helper=new MimeMessageHelper(message,true);
		 * helper.setSubject(subject); helper.setTo(to); helper.setText(text);
		 * helper.setFrom(new InternetAddress("support@autoscoop.com.au",
		 * "support@autoscoop.com.au")); // This mail has 2 part, the BODY and
		 * the embedded image MimeMultipart multipart = new
		 * MimeMultipart("related"); // first part (the html) BodyPart
		 * messageBodyPart = new MimeBodyPart(); //String htmlText =
		 * "<H1>Hello</H1><img src=\"cid:image\">"; String htmlText =
		 * "<img src=\"cid:image\">"; messageBodyPart.setContent(htmlText,
		 * "text/html"); // add it multipart.addBodyPart(messageBodyPart); //
		 * second part (the image) messageBodyPart = new MimeBodyPart();
		 * //DataSource fds = new
		 * FileDataSource("C:\\Users\\mk\\Desktop\\AutoscoopImg.png");
		 * FileReader fs; try { fs = new
		 * FileReader("src/main/java/au/com/pnspvtltd/mcd/service/abc.txt");
		 * if(fs!=null){ System.out.println("fiel is open"); } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * DataSource fds = new FileDataSource(
		 * "src\\main\\java\\au\\com\\pnspvtltd\\mcd\\service\\abc.txt");
		 * //src/main/java/au.com.pnspvtltd.mcd.service
		 * src/main/java/au/com/pnspvtltd/mcd/service/AutoscoopImg.png
		 * //DataSource fds = new
		 * FileDataSource("localhost:8080\\MyCarDomain\\AutoscoopImg.png"); File
		 * f= new File(null); DataSource fds1 = new FileDataSource(f);
		 * messageBodyPart.setDataHandler(new DataHandler(fds));
		 * messageBodyPart.setHeader("Content-ID", "<image>"); // add image to
		 * the multipart multipart.addBodyPart(messageBodyPart); // put
		 * everything together message.setContent(multipart);
		 * mailSender.send(message);
		 */
		// Send the actual HTML message, as big as you like
		// Transport.send(message);
		System.out.println("Mail sent successfully!!!");
	}

}
