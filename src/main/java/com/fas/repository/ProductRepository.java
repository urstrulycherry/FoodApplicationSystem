package com.fas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fas.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
		
	Product findByProductCode(int productCode);
	
	void deleteByProductCode(int productCode);
	
	List<Product> findByCategory(String category);

}