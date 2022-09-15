package com.bae.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.qa.SpringDrinks.domain.Drink;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// @Column(nullable=false)
	@NotNull(message ="Give the drink a name")
	private String name;
	
	@Column
	private String type;
	
	@Column
	private long alcohol;
	
	//Default constructor
	public Drink() {
	
		
	}

	//For testing
	public Drink(long id, String name, String type, long alcohol) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.alcohol = alcohol;
	}

	//For creation
	public Drink(String name, String type, long alcohol) {
		super();
		this.name = name;
		this.type = type;
		this.alcohol = alcohol;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(long alcohol) {
		this.alcohol = alcohol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alcohol, name, type);
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
		return alcohol == other.alcohol && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
		
		
	}
