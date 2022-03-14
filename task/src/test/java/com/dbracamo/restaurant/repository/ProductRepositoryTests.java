package com.dbracamo.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dbracamo.restaurant.entities.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void testMethods() {
		Product product = new Product();
		product.setName("test");
		product.setDescription("test");
		Product p = productRepository.save(product);
		System.out.print(p);
	}
}
