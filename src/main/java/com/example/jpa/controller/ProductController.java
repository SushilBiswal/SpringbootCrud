package com.example.jpa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.jpa.entity.Product;
import com.example.jpa.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = {"product"})
@RestController

public class ProductController {

	@Autowired
	ProductService productservice;
	

	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productservice.saveProduct(product);
	}
	
	@Cacheable(key = "#id")
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		//log.info("@@@@@product data feteched from DB=@@@" +id);
		return productservice.getProductsByProductId(id);
	} 

	@GetMapping("/product-details/{name}")
	public Product getProduct(@PathVariable String name) {
		return productservice.getProductsByProductName(name);
	} 
	
	@CachePut(key = "#id")
	@PutMapping("/{id}")
	 public ResponseEntity<Product> updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
        return ResponseEntity.ok(productservice.updateProduct(id,product));
    }
/*	
	@GetMapping("/product/{name}")
	public Product getProduct(@PathVariable String name) {
		return productservice.getProductsByProductName(name);
	} 


	@GetMapping("/all")
	public List<Product> getttttAllProduct() {
		return productservice.getsssProductsByProduct();
	} 
	
	@GetMapping("/all-product/list")
	public List<Product> getProductListByLive_indAndPass_ind() {
		return productservice.getProductListByLive_indAndPass_ind();
	}
	
	
	@GetMapping("/all-product")
	public List<Product> getProductByLive_indAndPass_ind() {
		return productservice.getProductByLive_indAndPass_ind();
	} */
/*	
	@GetMapping("/product/{name}")
	public Product getProduct(@PathVariable String name) {
		return productservice.getProductsByProductName(name);
	} */
	
	
	@GetMapping("/api/v1/csv/export/user/contact/{userId}")
	public ResponseEntity<?> exportContactCsvReportsByUserId(@PathVariable("userId") int id,
			  HttpServletResponse response) throws IOException {
		
		
	
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
		List<Product>  contactList = (List<Product>) productservice.getProductsByProductId(id);
		response.setContentType("text/csv");
		
		String currentDate = dateFormatter.format(new Date());
		String filename = "RDM_contact" + currentDate + ".csv";
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + filename;
		
		response.setHeader(headerKey, headerValue);
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"productName", "product_quantity", "product_price","indInd","password_active_ind"
		};
		
		String[] nameMapping = {"productName", "product_quantity", "product_price","indInd","password_active_ind"
		};
		
		csvWriter.writeHeader(csvHeader);
		
		for (Product contactDetails : contactList) {
			csvWriter.write(contactDetails, nameMapping);
		}
		csvWriter.close();
	}catch(Exception e) {
		e.printStackTrace();

	}
	
	return new ResponseEntity<>("successfully export to csv " ,HttpStatus.OK);
	
	}
}
