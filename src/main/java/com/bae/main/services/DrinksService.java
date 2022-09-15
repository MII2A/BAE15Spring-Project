package com.bae.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.main.entities.Drink;
import com.bae.main.repos.DrinkRepo;


@Service
public class DrinksService {

private DrinkRepo repo;

//Constructor
public DrinksService(DrinkRepo repo) {
this.repo = repo;
}

	public Drink create(Drink drink) {
		
		return this.repo.save(drink);
	}

	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	public Drink getById(long id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) {
			return optionalDrink.get();
		}
		return null;
	}

	public Drink update(long id, Drink drink) {
		Optional<Drink> existingDrink = this.repo.findById(id);
		if(existingDrink.isPresent()) {
			Drink existing = existingDrink.get();
			existing.setAlcohol(drink.getAlcohol());
			existing.setName(drink.getName());
			existing.setType(drink.getType());
		return this.repo.saveAndFlush(existing);
			
		}
		return null;
	}

	public boolean delete(long id) {
	this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
