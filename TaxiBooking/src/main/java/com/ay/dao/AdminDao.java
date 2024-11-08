package com.ay.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ay.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

	
	  Optional<Admin> findByUsername(String username);
}
