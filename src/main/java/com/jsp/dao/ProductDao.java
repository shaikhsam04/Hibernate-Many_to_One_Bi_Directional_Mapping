package com.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sameer");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Product testSave(Product product, ArrayList<Review> al) {
		entityTransaction.begin();
		entityManager.persist(product);

//		entityManager.persist(al.get(0));
//		entityManager.persist(al.get(1));
//		entityManager.persist(al.get(2));
		entityTransaction.commit();

		return product;
	}

	public Product updateById(Product p1) {
		Product p2 = entityManager.find(Product.class, p1.getId());
		if (p2 != null) {
			p2.setName(p1.getBrand());
			p2.setBrand(p1.getName());
			p2.setCost(p1.getCost());
			p2.setType(p1.getType());

			entityTransaction.begin();
			entityManager.merge(p2);
			entityTransaction.commit();	}
	return p2;
	}
	
	
	public void deleteById(Product product, List<Review> r1, int id) {
		Product p2=entityManager.find(Product.class, id);
		Review r2=entityManager.find(Review.class,id);
		if(p2!=null) {
			entityTransaction.begin();
			entityManager.remove(p2);
			entityManager.remove(r2);
			entityTransaction.commit();
		}
	}
	
	
	public Product getById(Product product) {
		Product p3=entityManager.find(Product.class, product.getId());
		if(p3!=null) {
			System.out.println(p3.getId());
			System.out.println(p3.getBrand());
			System.out.println(p3.getName());
			System.out.println(p3.getCost());
			System.out.println(p3.getType());
			
		}
		return p3;
	}
}
