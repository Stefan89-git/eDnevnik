package com.iktpreobuka.eDnevnik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.iktpreobuka.eDnevnik.utils.EmailObject;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	public JavaMailSender emailSender;
	
	@Override
	public void sendSimpleMessage(EmailObject object) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(object.getTo());
		message.setSubject(object.getSubject());
		message.setText(object.getText());
		emailSender.send(message);
	}

}
