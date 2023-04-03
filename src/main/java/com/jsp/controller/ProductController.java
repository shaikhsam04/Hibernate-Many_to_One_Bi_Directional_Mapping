package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Product;
import com.jsp.dto.Review;
import com.jsp.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		ArrayList<Review> al = new ArrayList();

		Product product = new Product();
		product.setBrand("Nike");
		product.setCost(1500);
		product.setName("shoes");
		product.setType("footwear");

		Review review = new Review();
		review.setRating(2);
		review.setStatus("bad");
		review.setProduct(product);

		Review review2 = new Review();
		review2.setRating(4);
		review2.setStatus("okok");
		review2.setProduct(product);

		Review review3 = new Review();
		review3.setRating(5);
		review3.setStatus("good");
		review3.setProduct(product);

		al.add(review3);
		al.add(review2);
		al.add(review);
		product.setReviews(al);

		// to save
		ProductService productService = new ProductService();
		productService.testSave(product, al);

		// to update
		product.setId(1);
		product.setName("dress");
		product.setBrand("zara");
		product.setCost(4000);
		product.setType("top");
		// productService.updateById(product);

		// to delete
		product.setId(1);
		List<Review> r1 = product.getReviews();
		// productService.deleteById(product, r1, product.getId());

		// to get by id
		product.setId(1);
		// productService.getById(product);
	}
}
