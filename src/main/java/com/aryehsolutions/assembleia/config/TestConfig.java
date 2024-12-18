package com.aryehsolutions.assembleia.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aryehsolutions.assembleia.entities.Agenda;
import com.aryehsolutions.assembleia.entities.User;
import com.aryehsolutions.assembleia.repositories.AgendaRepository;
import com.aryehsolutions.assembleia.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AgendaRepository agendaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "988888888", "Maria Brown");
		User u2 = new User(null,  "977777777", "Alex Green");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Agenda a1 = new Agenda(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Agenda a2 = new Agenda(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Agenda a3 = new Agenda(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		agendaRepository.saveAll(Arrays.asList(a1, a2, a3));
		
		
	}
	
	
	

}
