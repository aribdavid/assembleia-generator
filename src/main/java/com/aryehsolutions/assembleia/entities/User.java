package com.aryehsolutions.assembleia.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
		private static final long serialVersionUID = 1L;
		private long id;
		private String cpf;
		private String name;
		
		
		public User() {
		}


		public User(long id, String cpf, String name) {
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
		
		
		
		
		
		
		
}