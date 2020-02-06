package com.dfw.dfw.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.dfw.dfw.entities.User
import com.dfw.dfw.service.DfwService

@RestController
class DfwController {
	
	@Autowired
	DfwService dfwService
	
	@PostMapping("/user")
	def saveUser(@RequestBody User user) {
		dfwService.saveUser(user)
	}
}
