package com.dfw.dfw.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.dfw.dfw.entities.User
import com.dfw.dfw.service.DfwService

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
class DfwController {
	
	@Autowired
	DfwService dfwService
	
	@PostMapping("/user")
	def saveUser(@RequestBody User user) {
		dfwService.saveUser(user)
	}
	
	@GetMapping("/users")
	def saveUser() {
		dfwService.getAllUsers()
	}
}
