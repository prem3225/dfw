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
			userRepository.save(user)
			return ["result" : "Successfully Registered"]
		}
	
	
	def getAllUsers() {
		userRepository.findAll()
	}
}
