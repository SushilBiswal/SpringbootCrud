package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.jpa.entity.Product;
import com.example.jpa.repository.ProductRepository;

//@CacheConfig(cacheNames = {"product"})
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;

	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> saveProducts(List<Product> product) {
		return productRepo.saveAll(product);
	}
	
//  @Cacheable(value="product", key="#id")
  public Product getProductsByProductId(int product_id){ 
	  return productRepo.findById(product_id); }
/*
  
//  public Product getProductsByProductName(String productName){ 
//	  return productRepo.findByProductName(productName); }


  public List<Product> getsssProductsByProduct() {
	return (List<Product>) productRepo.getProductRRR();
}  
  
  public List<Product> getProductListByLive_indAndPass_ind() {
		return (List<Product>) productRepo.getProductListByLive_indAndPass_ind();
	} 
  
  public List<Product> getProductByLive_indAndPass_ind() {
		return (List<Product>) productRepo.getProductByLive_indAndPass_ind(true,true);
	} */

public Product getProductsByProductName(String name) {
	return productRepo.findByProductNameContainingAndIndInd(name,true);
}

public Product updateProduct(int product_id, Product product) {
	Product product1 = productRepo.findById(product_id);
	
	productRepo.save(product1);
	return product1;
}
  
//	public Product getProductsByProductName(String product_name){ 
//		  return productRepo.findByProduct__name(product_name); }
	 
}
 

