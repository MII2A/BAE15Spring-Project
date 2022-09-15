package com.bae.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drink {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false)
		private String firstNAME;
		
		@Column(nullable = false)
		private String lastNAME;
		
		@Column(nullable = false)
		private int age;

		
		public Drink(String firstNAME, String lastNAME, int age) {
			super();
			this.firstNAME = firstNAME;
			this.lastNAME = lastNAME;
			this.age = age;
		}

		public Drink(long id, String firstNAME, String lastNAME, int age) {
			super();
			this.id = id;
			this.firstNAME = firstNAME;
			this.lastNAME = lastNAME;
			this.age = age;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstNAME() {
			return firstNAME;
		}

		public void setFirstNAME(String firstNAME) {
			this.firstNAME = firstNAME;
		}

		public String getLastNAME() {
			return lastNAME;
		}

		public void setLastNAME(String lastNAME) {
			this.lastNAME = lastNAME;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public int hashCode() {
			return Objects.hash(age, firstNAME, id, lastNAME);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Drink other = (Drink) obj;
			return age == other.age && Objects.equals(firstNAME, other.firstNAME) && id == other.id
					&& Objects.equals(lastNAME, other.lastNAME);
		}
		
		
	}
