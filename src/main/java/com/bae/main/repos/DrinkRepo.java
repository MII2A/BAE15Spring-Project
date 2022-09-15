package com.bae.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.main.entities.Drink;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Long>{
	
}