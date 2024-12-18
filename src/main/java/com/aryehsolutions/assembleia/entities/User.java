package com.aryehsolutions.assembleia.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String cpf;
		private String name;
		
		@JsonIgnore
		@OneToMany(mappedBy = "associate")
		private List<Agenda> agendas = new ArrayList<>();
		
		
		public User() {
		}


		public User(Long id, String cpf, String name) {
			super();
			this.id = id;
			this.cpf = cpf;
			this.name = name;
		}
		

		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
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
			User other = (User) obj;
			return id == other.id;
		}


		public List<Agenda> getAgendas() {
			return agendas;
		}

		
		
	
		
		
		
}
