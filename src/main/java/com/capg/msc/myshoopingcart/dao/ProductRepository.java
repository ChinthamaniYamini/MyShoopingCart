package com.capg.msc.myshoopingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.myshoopingcart.beans.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> ,CustomProductRepository{
	
	

}
