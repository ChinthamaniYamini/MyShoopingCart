package com.capg.msc.myshoopingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.msc.myshoopingcart.beans.Product;
import com.capg.msc.myshoopingcart.dao.ProductRepository;
import com.capg.msc.myshoopingcart.exception.InvalidCostRangeException;

@Service
public class ProductServiceImp implements ProductService {
	
	
	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product SaveProduct(Product p) {
		
		repo.save(p);
		return p;
	}

	@Override
	public void deleteProductById(int id) {
		repo.deleteById(id);
		
		
	}

	@Override
	public void updateProductById(Product p, int id) {
		
		repo.save(p);
	}

	@Override
	public Product getProductById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> getProductByCategory(String proudctCategory) {
		// TODO Auto-generated method stub
		return repo.getProductByCategory(proudctCategory);
	}

	@Override
	public List<Product> getProductByCategoryAndPrice(String proudctCategory, int range1, int range2) {
		// TODO Auto-generated method stub
		return repo.getProductByCategoryAndPrice(proudctCategory, range1, range2);
	}

	
	

	
	
	
	
}
