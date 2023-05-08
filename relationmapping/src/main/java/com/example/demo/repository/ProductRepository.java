package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public class ProductRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Long save(Product product) {
		em.persist(product);
		return product.getId();
	}
	
	public Product findOne(Long id) {
		return em.find(Product.class, id);
	}
	
}
