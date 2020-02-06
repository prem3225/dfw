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
		return userRepository.save(user)
	}
}
