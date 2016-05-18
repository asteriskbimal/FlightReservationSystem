package com.flight.service;

import org.springframework.stereotype.Service;

@Service
public interface IMailSenderService {
	public void sendMail(String to, String subject, String body);
}
