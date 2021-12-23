package com.example.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.main.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	
}
