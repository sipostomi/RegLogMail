package com.gyakorlas.repository;

import org.springframework.data.repository.CrudRepository;

import com.gyakorlas.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByRole(String role);
	
}