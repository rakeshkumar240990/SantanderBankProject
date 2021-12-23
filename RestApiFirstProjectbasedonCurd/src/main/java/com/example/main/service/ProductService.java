package com.example.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.models.Product;
import com.example.main.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;


	public Product create(Product product) {

		Product dbproduct = productrepository.save(product);
		return dbproduct;
          }

	public Product updateProductInfo(Integer productId, Product product) {
		// TODO Auto-generated method stub
		                   Product dbProduct = fetchProductInformation(productId);
		                   if(dbProduct!=null)
		                   {
                             dbProduct.setProductName(product.getProductName());
                             dbProduct.setProductPrice(product.getProductPrice());
		                	  dbProduct.setProductDescription(product.getProductDescription());
		                	  return  productrepository.save(dbProduct);
		                	  
		                   }
		                   else
		                	   return null;
	}
	
	

	public void deleteProducts(Integer productId) {
		// TODO Auto-generated method stub
		      Product information = fetchProductInformation(productId);
                if(information!=null)
                {
                	          productrepository.deleteById(productId);
                }
	}

	
	
	public Product fetchProductInformation(Integer productId) {
		// TODO Auto-generated method stub
		    
		Optional<Product> optional = productrepository.findById(productId);
		if(optional.isPresent())
		{
			          Product product = optional.get();
			          return product;
		}
		else
		{
			return null;
		}
	}

	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return productrepository.findAll();
	}









}
