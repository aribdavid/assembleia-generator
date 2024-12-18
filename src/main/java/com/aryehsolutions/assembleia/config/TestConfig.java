package com.aryehsolutions.assembleia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aryehsolutions.assembleia.entities.User;
import com.aryehsolutions.assembleia.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "988888888", "Maria Brown");
		User u2 = new User(null,  "977777777", "Alex Green");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
