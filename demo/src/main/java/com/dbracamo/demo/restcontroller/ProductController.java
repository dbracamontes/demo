package com.dbracamo.demo.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dbracamo.demo.entities.Product;
import com.dbracamo.demo.exception.ProductNotFoundException;
import com.dbracamo.demo.repositories.ProductRepository;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);

	}

	@GetMapping(params = "name")
	public ResponseEntity<?> getByName(@RequestParam(value="name") String name) {
		Optional<?> optionalProducts = productRepository.findByName(name);
		if (optionalProducts.isPresent()) {
			return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Optional<?> optionalProducts = productRepository.findById(id);
		if (optionalProducts.isPresent()) {
			return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(productRepository.findById(id), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
		Optional<Product> updatedProductOpt = productRepository.findById(id) //
			      .map(prod -> {
			    	  prod.setName(product.getName());
			    	  prod.setDescription(product.getDescription());
			        return Optional.of(prod);
			      }).orElse(Optional.empty());
		
		if(updatedProductOpt.isPresent()) {
			productRepository.save(updatedProductOpt.get());
		} else {
			throw new ProductNotFoundException(id);
		}
		 
		return;
	}
	
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void deleteProduct(@PathVariable Long id) {
		 productRepository.deleteById(id);
	 }	
}
