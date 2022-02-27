package com.zensar.olx.training.bean;

import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Columns;

@Entity
public class AdvertisementPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column
	private String title;
	@Column
	private String  description;
	@Column
	private double price;
	@Embedded
	private Category category;
	@Embedded
	private OlxUser olxUser;
	@Embedded
	private AdvertisementStatus advertisementStatus;
	
	@Column
	private LocalDate Createdate;
	@Column
	private LocalDate modifiedDate;
	@Lob
	private byte[] photo;
	
	
	
	public AdvertisementPost(int id, String title, String description, double price, Category category, OlxUser olxUser,
			AdvertisementStatus advertisementStatus, LocalDate createdate, byte[] photo) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.olxUser = olxUser;
		this.advertisementStatus = advertisementStatus;
		Createdate = createdate;
		this.photo = photo;
	}
	public AdvertisementPost(int id) {
		super();
		this.id = id;
	}
	public AdvertisementPost() {
		super();
		this.Createdate=LocalDate.now();
		this.modifiedDate=LocalDate.now();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public OlxUser getOlxUser() {
		return olxUser;
	}
	public void setOlxUser(OlxUser olxUser) {
		this.olxUser = olxUser;
	}
	public AdvertisementStatus getAdvertisementStatus() {
		return advertisementStatus;
	}
	public void setAdvertisementStatus(AdvertisementStatus advertisementStatus) {
		this.advertisementStatus = advertisementStatus;
	}
	
	public LocalDate getCreatedate() {
		return Createdate;
	}
	public void setCreatedate(LocalDate createdate) {
		Createdate = createdate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "AdvertisementPost [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", olxUser=" + olxUser + ", advertisementStatus=" + advertisementStatus
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(advertisementStatus, category, description, id, olxUser, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvertisementPost other = (AdvertisementPost) obj;
		return Objects.equals(advertisementStatus, other.advertisementStatus)
				&& Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(olxUser, other.olxUser) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}
	

}


	

