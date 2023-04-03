package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Review;

public class ReviewDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sameer");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Review deleteById(Review review) {
		Review r1 = entityManager.find(Review.class, review.getId());
		if (r1 != null) {
			entityTransaction.begin();
			entityManager.remove(r1);
			entityTransaction.commit();
		}
		return r1;
	}

	public void updateById(Review review) {
		Review r2 = entityManager.find(Review.class, review.getId());
		if (r2 != null) {
			r2.setRating(review.getRating());
			r2.setStatus(review.getStatus());
			entityTransaction.begin();
			entityManager.merge(r2);
			entityTransaction.commit();
		}
	}

	public void getById(Review review) {
		Review r3 = entityManager.find(Review.class, review.getId());
		if (r3 != null) {
			System.out.println(r3.getId());
			System.out.println(r3.getStatus());
			System.out.println(r3.getRating());
			System.out.println("====================================================");
		}
	}

	public void getAll(Review review) {
		String sql = "select r from Review r";
		Query query = entityManager.createQuery(sql);
		List<Review> reviews = query.getResultList();
		for (Review review2 : reviews) {
			System.out.println(review2.getId());
			System.out.println(review2.getRating());
			System.out.println(review2.getStatus());
			System.out.println("=================================================================");

		}
	}
}
