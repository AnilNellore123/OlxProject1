package com.zensar.olx.training.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Embeddable
public class AdvertisementStatus {
@Column(name="Status_id")
private int id;

@Transient
private String Status;

public AdvertisementStatus(int id, String status) {
	super();
	this.id = id;
	Status = status;
}
public AdvertisementStatus(String status) {
	super();
	this.Status=Status;
	// TODO Auto-generated constructor stub
	
}
public AdvertisementStatus() {
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
