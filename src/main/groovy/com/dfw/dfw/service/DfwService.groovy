package com.dfw.dfw.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.dfw.dfw.entities.User
import com.dfw.dfw.entities.UserRepository

@Service
class DfwService {
	
	@Autowired
	UserRepository userRepository
	
	def saveUser(User user) {
		int emailCount = userRepository.findByEmail(user.emailAddress)
		int phoneCount = userRepository.findByPhoneNumber(user.phoneNumber)
		if(emailCount>0 && phoneCount==0) {
			return ["result" : "Email Already Exist"]
		}
		
		if(phoneCount>0 && emailCount==0) {
			return ["result" : "Phone Number Already Exist"]
		}
		if(emailCount>0 && phoneCount>0) {
			return ["result" : "Email address and phone number already exist"]
		}
		if(emailCount==0 && phoneCount==0){
			userRepository.save(user)
			return ["result" : "Successfully REgistered"]
		}
	}
	
	def getAllUsers() {
		userRepository.findAll()
	}
}
