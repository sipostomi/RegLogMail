package com.gyakorlas.repository;

import org.springframework.data.repository.CrudRepository;

import com.gyakorlas.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	User findByActivation(String code);
}
