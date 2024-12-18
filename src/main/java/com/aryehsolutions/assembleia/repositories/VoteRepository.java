package com.aryehsolutions.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryehsolutions.assembleia.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
		
}
