package com.zensar.olx.training.bean;

import java.time.LocalDate;

public class NewAdvertisementPostResponse {
int id;
String title;
double price;
String userName;
String description;
String Category;
LocalDate modifiedDate;
LocalDate createdDate;
String status;
public NewAdvertisementPostResponse(int id, String title, double price, String userName, String description,
		String category, LocalDate modifiedDate, LocalDate createdDate, String status) {
	super();
	this.id = id;
	this.title = title;
	this.price = price;
	this.userName = userName;
	this.description = description;
	Category = category;
	this.modifiedDate = modifiedDate;
	this.createdDate = createdDate;
	this.status = status;
}
public NewAdvertisementPostResponse(int id) {
	super();
	this.id = id;
}
public NewAdvertisementPostResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public LocalDate getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(LocalDate modifiedDate) {
	this.modifiedDate = modifiedDate;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "NewAdvertisementPostResponse [id=" + id + ", title=" + title + ", price=" + price + ", userName=" + userName
			+ ", description=" + description + ", Category=" + Category + ", modifiedDate=" + modifiedDate
			+ ", createdDate=" + createdDate + ", status=" + status + "]";
}


}
