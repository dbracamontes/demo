package com.dbracamo.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbracamo.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<List<Product>> findByName(String name);

}
