package com.jsp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String brand;
private String type;
private int cost;

@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
private List<Review> reviews;
public List<Review> getReviews() {
	return reviews;
}
public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
} 
}
