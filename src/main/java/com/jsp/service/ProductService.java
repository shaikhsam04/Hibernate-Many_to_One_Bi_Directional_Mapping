package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductService {
	ProductDao productDao = new ProductDao();

	public void testSave(Product product, ArrayList<Review> al) {
		productDao.testSave(product, al);
	}

	public void updateById(Product p) {
		productDao.updateById(p);
	}

	public void deleteById(Product product, List<Review> r1, int id) {
		productDao.deleteById(product, r1, id);
	}

	public void getById(Product product) {
		productDao.getById(product);
	}
}
