package com.zensar.olx.training.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.training.bean.OlxUser;
import com.zensar.olx.training.sevice.OlxUserService;

@RestController
public class OlxUserController {
	@Autowired
    OlxUserService service;
	
	@PostMapping("/user")
	public OlxUser addOlxUser(@RequestBody  OlxUser olXUser) {
		return this.service.addOlxUser(olXUser);
	}
	
	@GetMapping("/user/{uid}")
	public OlxUser findOlxUserById(@PathVariable(name = "uid") int id) {
		return this.service.findOLXUser(id);
	}
	
	@GetMapping("/user/find/{userName}")
	public OlxUser findOlxUserByName(@PathVariable(name = "userName") String name) {
		return this.service.findOlxUserByName(name);
	}
}