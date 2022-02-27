package com.zensar.olx.training.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="olx_AdvertismentStatus")
public class AdvertismentStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String Status;
public AdvertismentStatus(int id, String status) {
	super();
	this.id = id;
	Status = status;
}
public AdvertismentStatus(String status) {
	super();
	this.Status=Status;
	// TODO Auto-generated constructor stub
	
}
public AdvertismentStatus() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
@Override
public String toString() {
	return "AdvertismentStatus [id=" + id + ", Status=" + Status + "]";
}

}
