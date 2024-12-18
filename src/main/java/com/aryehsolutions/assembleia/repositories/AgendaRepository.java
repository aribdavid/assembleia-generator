package com.aryehsolutions.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryehsolutions.assembleia.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
		
}
