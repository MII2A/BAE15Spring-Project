package com.bae.main.services;

@Service
public class DrinkService implements ServiceMethods<Drink>{

private DrinkRepo repo;

//Constructor
public DrinkService(DrinkRepo repo) {
	this.repo = repo;
}

	@Override
	public Drink create(Drink drink) {
		
		return this.repo.save(drink);
	}

	@Override
	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Drink getById(long id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) {
			return optionalDrink.get();
		}
		return null;
	}

	@Override
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

	@Override
	public boolean delete(long id) {
	this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
