package com.capg.msc.myshoopingcart.service;

import java.util.List;

import com.capg.msc.myshoopingcart.beans.Product;
import com.capg.msc.myshoopingcart.exception.InvalidCostRangeException;

public interface ProductService {
	
	public List<Product>  getAllProducts();
	
	public Product SaveProduct(Product p);
	
	public void  deleteProductById(int id);
	
	public void  updateProductById(Product p,int id);
	
	public Product getProductById(int id);
	
	
	public List<Product>  getProductByCategory(String proudctCategory);
	
	public List<Product>  getProductByCategoryAndPrice(String proudctCategory,int range1,int range2) throws InvalidCostRangeException;
	

}
