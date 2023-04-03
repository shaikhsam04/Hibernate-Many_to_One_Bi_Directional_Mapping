package com.jsp.controller;

import com.jsp.dto.Review;
import com.jsp.service.ReviewService;

public class ReviewController {
	public static void main(String[] args) {
		Review review = new Review();
		ReviewService reviewService = new ReviewService();

		// to delete by id
		// review.setId(4);
		// reviewService.deleteById(review);

		// to update by id
		review.setId(5);
		review.setRating(5);
		review.setStatus("very nice");
//	     reviewService.updateById(review);

		// to get by id
		review.setId(5);
//      reviewService.getById(review);

		// to get all
		reviewService.getAll(review);
	}
}
