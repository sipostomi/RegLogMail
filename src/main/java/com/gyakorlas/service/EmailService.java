package com.gyakorlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gyakorlas.entity.Message;

@Service
public class EmailService {
    
	@Value("${spring.mail.username}")
	private String MESSAGE_FROM;
	
	@Value("${valami.domain.url}")
	private String DOMAIN;
	
	@Value("${valami.message.to}")
	private String MESSAGE_TO;
	
	private JavaMailSender javaMailSender;

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	public void sendMessage(String email, String code) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(MESSAGE_FROM);
			message.setTo(email);
			message.setSubject("Sikeres regisztrálás");
			message.setText("Kedves " + email + "! \n \n Köszönöm, hogy regisztráltál az oldalamra! \n Kattints az alábbi linkre, hogy aktiváld a regisztrációdat! \n "
					+ "Link: " +DOMAIN+"/activation/"+code);
			javaMailSender.send(message);
			
		} catch (Exception e) {
			System.out.println("Hiba e-mail küldéskor az alábbi címre: " + email + "  " + e);
		}
		

	}
	public void sendMessageToMe(Message m) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(MESSAGE_FROM);
			message.setTo(MESSAGE_TO);
			message.setSubject(m.getSubject());
			message.setText(m.getFullName() + "\n" + m.getMessageText());
			javaMailSender.send(message);
			
		} catch (Exception e) {
			System.out.println("Nem sikerült kézbesíteni az adminnak címzett levelet");
		}
		
	}
	
	
}
