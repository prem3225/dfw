package com.dfw.dfw.service

import javax.mail.internet.MimeMessage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

import com.dfw.dfw.entities.User
import com.dfw.dfw.entities.UserRepository

@Service
class DfwService {
	
	@Autowired
	UserRepository userRepository
	
	@Autowired
	private JavaMailSender sender;
	
	def saveUser(User user) {
		String email = userRepository.findByEmail(user.emailAddress.toLowerCase())
		String phone = userRepository.findByPhoneNumber(user.phoneNumber)
		if(!email && phone) {
			return ["result" : "Phone Number Already Exist"]
		}
		
		if(email && !phone) {
				return ["result" : "Email Already Exist"]
		}
		
		if(email && phone) {
			return ["result" : "Email address and phone number already exist"]
		}
		
		if(!email && !phone)
			user.emailAddress=user.emailAddress.toLowerCase()
			User userSaved = userRepository.save(user)
			if(userSaved) {
				try {
					MimeMessage message = sender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message);
					 
					helper.setTo(user.emailAddress);
					helper.setText("Welcome to DFW");
					helper.setSubject("Your registration was successfully made. And you can login with your registered mail id and password.");
					 
					sender.send(message);
				}catch(Exception e) {
					println "Exception....."+e
				}
				
			}
			return ["result" : "Successfully Registered"]
		}
	
	
	def getAllUsers() {
		userRepository.findAll()
	}
}
