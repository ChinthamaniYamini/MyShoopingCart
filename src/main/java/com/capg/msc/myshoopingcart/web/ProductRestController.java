package com.capg.msc.myshoopingcart.web;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoopingcart.beans.Product;
import com.capg.msc.myshoopingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoopingcart.exception.InvalidCategoryException

import com.capg.msc.myshoopingcart.service.ProductServiceImp;

@Validated
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	 private ProductServiceImp service;
	
	
	
	@GetMapping("/home")
	public String homeRequest() {
		return "WELCOME : MY SHOPPING APP "+LocalDateTime.now();
	}
	
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product p) {
		service.SaveProduct(p);
		return p;
	}
	
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.getAllProducts();
		
	}
	
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
		
	} 
	
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProductById(@PathVariable int id) {
		service.deleteProductById(id);
	}
	
	
	@PutMapping("/updateproduct")
	public Product updateProductById(@RequestBody @Valid Product p) {
		
		service.updateProductById(p, p.getProductId());
		
		return p;
	}
	
	@GetMapping("/products/{proudctCategory}")
	public List<Product> getProductByCategory(@PathVariable String proudctCategory) {
		Matcher m = Pattern.compile("[0-9]|@|[\\+-x\\*]").matcher(proudctCategory);
		
		if(proudctCategory.length()<3 || m.find()) {
			throw new InvalidCategoryException(proudctCategory);
		}
		return service.getProductByCategory(proudctCategory);
	}
	
	@GetMapping("/products/{proudctCategory}/{range1}/{range2}")
	public List<Product> getProductByCategoryAndPrice(@PathVariable String proudctCategory,@PathVariable int range1,@PathVariable int range2) throws InvalidCostRangeException {
		if(proudctCategory.equals("Laptop") && range1<1000) {
			throw new   InvalidCostRangeException(range1 ,range2);
		}
		
		return service.getProductByCategoryAndPrice(proudctCategory, range1, range2);
	}
	
	
	
	
}
