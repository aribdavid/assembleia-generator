package com.aryehsolutions.assembleia.config;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aryehsolutions.assembleia.entities.Agenda;
import com.aryehsolutions.assembleia.entities.User;
import com.aryehsolutions.assembleia.entities.Vote;
import com.aryehsolutions.assembleia.entities.Voting;
import com.aryehsolutions.assembleia.repositories.AgendaRepository;
import com.aryehsolutions.assembleia.repositories.UserRepository;
import com.aryehsolutions.assembleia.repositories.VoteRepository;
import com.aryehsolutions.assembleia.repositories.VotingRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private VotingRepository votingRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "988888888", "Maria Brown");
		User u2 = new User(null, "977777777", "Alex Green");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		long duration = 1;

		Agenda a1 = new Agenda(null, "Pauta 1", currentTimestamp, u1);
		Agenda a2 = new Agenda(null, "Pauta 2", currentTimestamp, u2);
		Agenda a3 = new Agenda(null, "Pauta 3", currentTimestamp, u1);

		agendaRepository.saveAll(Arrays.asList(a1, a2, a3));

		Voting v1 = new Voting(null, a1, currentTimestamp, duration);
		Voting v2 = new Voting(null, a2, currentTimestamp, duration);

		votingRepository.saveAll(Arrays.asList(v1, v2));

		Vote vo1 = new Vote(null, "sim", currentTimestamp, v1, u1);
		Vote vo2 = new Vote(null, "sim", currentTimestamp, v1, u2);
		Vote vo3 = new Vote(null, "sim", currentTimestamp, v2, u1);
		Vote vo4 = new Vote(null, "sim", currentTimestamp, v2, u2);

		voteRepository.saveAll(Arrays.asList(vo1, vo2, vo3, vo4));
	}

}
