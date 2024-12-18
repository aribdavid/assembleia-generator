package com.aryehsolutions.assembleia.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Timestamp created_at;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User associate;
	


	public Agenda() {
		
	}

	public Agenda(Long id, String title, Timestamp created_at, User associate) {
		super();
		this.id = id;
		this.title = title;
		this.created_at = created_at;
		this.associate = associate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public User getAssociate() {
		return associate;
	}

	public void setAssociate(User associate) {
		this.associate = associate;
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
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}

	

}
