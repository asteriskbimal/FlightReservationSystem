package com.flight.aop;

import javax.mail.MessagingException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.flight.service.IMailSenderService;

@Aspect
public class TicketConformationAdvice {
	@Autowired
	private IMailSenderService mailSenderService;

	@After("execution( * com.flight.controller.FlightController.payment(..))")
	public void sendEmail(JoinPoint jp) throws MessagingException {
		String subject = "Conformation Mail!";
		String body = " Congratulation! you have successfully booked your ticket.";
		mailSenderService.sendMail("nlimbu@mum.edu", subject, body);
	}
}
