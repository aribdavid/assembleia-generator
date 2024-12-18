package com.aryehsolutions.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryehsolutions.assembleia.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
}
