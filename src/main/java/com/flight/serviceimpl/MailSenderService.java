package com.flight.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.flight.service.IMailSenderService;

@Service
public class MailSenderService implements IMailSenderService {

	@Autowired
	@Qualifier("mailSender")
	private MailSender mailSender;

//	@Autowired
//	public SimpleMailMessage preConfiguredMessage;

	/**
	 * This method will send compose and send the message
	 */
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}

	/**
	 * This method will send a pre-configured message
	 */
//	public void sendPreConfiguredMail(String message) {
//		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
//		mailMessage.setText(message);
//		mailSender.send(mailMessage);
//	}
}
