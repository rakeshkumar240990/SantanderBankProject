package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.models.Product;
import com.example.main.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
       
	//http://localhost:8080/createProduct
    @PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
    	
    	Product create = productservice.create(product);
    	
    	return create; 

	}
    //http://localhost:8080/updateProduct
    //Based on primary key what data we are updating 
    @PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable("productId") Integer productId ,  @RequestBody Product product) {
                     return   productservice.updateProductInfo(productId , product);
	}
    
   
     @GetMapping("/retrieveAllProducts")
	public Iterable<Product> retrieveAllProducts() {

    	return productservice.getAllProducts();
	}
    @DeleteMapping("/deleteProducts/{productId}")
	public void deleteProducts(@PathVariable("productId") Integer productId) {
    	         productservice.deleteProducts(productId);

	}
	
    @GetMapping("/fetchProductInformation/{productId}")
	public Product fetchProductInformation(@PathVariable("productId") Integer productId) {
    
    	   Product product = productservice.fetchProductInformation(productId);
    	   return product;
		
	}
}