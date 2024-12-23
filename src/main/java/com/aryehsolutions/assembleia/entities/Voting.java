package com.aryehsolutions.assembleia.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Voting implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "agenda_id")
	private Agenda agenda;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Timestamp createdAt;
	
	private Duration duration;
	

	@OneToMany(mappedBy = "voting")
	private List<Vote> votes = new ArrayList<>();
	
	public Voting() {
		
	}


	public Voting(Long id, Agenda agenda, Timestamp createdAt, long duration) {
		super();
		this.id = id;
		this.agenda = agenda;
		this.createdAt = createdAt;
		this.duration =  Duration.ofMinutes(duration) ;
	}
	
	public Voting(Long id, Agenda agenda, Timestamp createdAt) {
		super();
		this.id = id;
		this.agenda = agenda;
		this.createdAt = createdAt;
		this.duration =  Duration.ofMinutes(1) ;
	}
	
    public long calculateEndDate(Timestamp currentTimestamp) {
   
        LocalDateTime createdAtDateTime = createdAt.toLocalDateTime();
        LocalDateTime endDateTime = createdAtDateTime.plus(duration);
        LocalDateTime convertedCurrentTimestamp = currentTimestamp.toLocalDateTime();

        long differenceInSeconds = ChronoUnit.SECONDS.between(endDateTime, convertedCurrentTimestamp);

        return Math.abs(differenceInSeconds); 
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Agenda getAgenda() {
		return agenda;
	}


	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Duration getDuration() {
		return duration;
	}


	public void setDuration(Duration duration) {
		this.duration = duration;
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
		Voting other = (Voting) obj;
		return Objects.equals(id, other.id);
	}
	
	
	


	

}
