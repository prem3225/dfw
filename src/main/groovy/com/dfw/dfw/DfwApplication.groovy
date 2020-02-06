package com.dfw.dfw

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
class DfwApplication {

	static void main(String[] args) {
		SpringApplication.run(DfwApplication, args)
	}

}
