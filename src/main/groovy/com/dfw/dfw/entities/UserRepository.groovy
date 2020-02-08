package com.dfw.dfw.entities

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u.emailAddress FROM User u WHERE u.emailAddress = :email")
	def findByEmail(@Param("email") String email )
	
	@Query("SELECT u.phoneNumber FROM User u WHERE u.phoneNumber = :phone")
	def findByPhoneNumber(@Param("phone") String phone )
}
