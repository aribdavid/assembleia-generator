package com.aryehsolutions.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryehsolutions.assembleia.entities.Voting;

public interface VotingRepository extends JpaRepository<Voting, Long> {
		
}
