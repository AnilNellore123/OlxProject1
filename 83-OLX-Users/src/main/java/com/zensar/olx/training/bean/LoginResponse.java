package com.zensar.olx.training.bean;

public class LoginResponse {
	private String jwt;



	public LoginResponse() {
	super();
	}



	public LoginResponse(String jwt) {
	super();
	this.jwt = jwt;
	}



	public String getJwt() {
	return jwt;
	}



	public void setJwt(String jwt) {
	this.jwt = jwt;
	}


}
