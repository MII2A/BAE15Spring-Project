package com.bae.main.entities;

import org.junit.jupiter.api.Test;

public class DrinkTest {

	@Test
	public void testEquals() {
	//EqualsVerifier.forClass(Drink.class).usingGetClass().verify();	
	}

	@Test
	public void noIdConstructor() {
	//	Drink drink = new Drink("Velvet Cake", "Stout", 6);
		
		//assertNotNull(drink.getName());
		//assertNotNull(drink.getType());
		//assertNotNull(drink.getAlcohol());
		
		//assertEquals(drink.getName(), "Velvet Cake");
		//assertEquals(drink.getType(), "Stout");
		//assertEquals(drink.getAlcohol(), 6);
	}

	@Test
	public void settersTest() {
		Drink drink = new Drink("Quench Quake", "Sour", 4);
		
		drink.setName("Quench Quake");
		drink.setType("Sour");
		drink.setAlcohol(4);
		
		//assertEquals(drink.getName(), "Quench Quake");
		//assertEquals(drink.getType(), "Sour");
		//assertEquals(drink.getAlcohol(),4);

	}

	}