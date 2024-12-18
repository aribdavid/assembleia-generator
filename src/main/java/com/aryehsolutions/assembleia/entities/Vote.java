package com.aryehsolutions.assembleia.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "vote", uniqueConstraints = @UniqueConstraint(columnNames = { "voting_id", "associate_id" }))
public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vote_value", nullable = false)
	private String voteValue;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Timestamp votedAt;

	@ManyToOne
	@JoinColumn(name = "voting_id", nullable = false)
	private Voting voting;

	@ManyToOne
	@JoinColumn(name = "associate_id", nullable = false)
	private User associate;



	public Vote() {

	}

	public Vote(Long id, String voteValue, Timestamp votedAt, Voting voting, User associate) {
		super();

		if (!"sim".equalsIgnoreCase(voteValue) && !"nao".equalsIgnoreCase(voteValue)) {
			throw new IllegalArgumentException("Invalid vote value: " + voteValue);
		}
		
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

		long timeLeft = voting.calculateEndDate(currentTimestamp);
		
		if (timeLeft == 0) {
			throw new IllegalArgumentException("Voting is over" + voting.getAgenda());
		}

	

		this.voteValue = voteValue.toLowerCase();
		this.id = id;
		this.votedAt = votedAt;
		this.voting = voting;
		this.associate = associate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getVotedAt() {
		return votedAt;
	}

	public void setVotedAt(Timestamp votedAt) {
		this.votedAt = votedAt;
	}

	public Voting getVoting() {
		return voting;
	}

	public void setVoting(Voting voting) {
		this.voting = voting;
	}

	public String getVoteValue() {
		return voteValue;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		return Objects.equals(id, other.id);
	}

}
