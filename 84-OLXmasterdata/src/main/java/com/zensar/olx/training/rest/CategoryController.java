package com.zensar.olx.training.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.training.bean.AdvertismentStatus;
import com.zensar.olx.training.bean.Category;
import com.zensar.olx.training.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService service;

	@PostMapping("/advertise/addCategory")
	public Category addCategory(@RequestBody Category category) {
		return this.service.addCategory(category);
	}

	@GetMapping("/advertise/category")
	public List<Category> getAllCategories() {
		return this.service.getAllCategories();
	}

	@GetMapping("/advertise/getCategory/{id}")
	public Category findCategory(int id) {
		Category category;
	category=this.service.findCategory(id);
		return category;
	}

}
