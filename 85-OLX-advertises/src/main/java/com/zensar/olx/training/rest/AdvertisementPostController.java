package com.zensar.olx.training.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.olx.training.bean.AdvertisementPost;
import com.zensar.olx.training.bean.AdvertisementStatus;
import com.zensar.olx.training.bean.AdvertisementStatus;
import com.zensar.olx.training.bean.Category;
import com.zensar.olx.training.bean.NewAdvertisementPostRequest;
import com.zensar.olx.training.bean.NewAdvertisementPostResponse;
import com.zensar.olx.training.bean.OlxUser;
import com.zensar.olx.training.service.AdvertismentpostService;

@RestController

public class AdvertisementPostController {

	@Autowired
	AdvertismentpostService service;

	@PostMapping("/advertise/{un}")
	public NewAdvertisementPostResponse add(@RequestBody NewAdvertisementPostRequest request,
			@PathVariable(name = "un") String userName) {
		AdvertisementPost post = new AdvertisementPost();
		post.setTitle(request.getTitle());
		post.setPrice(request.getPrice());
		post.setDescription(request.getDescription());

		int categoryId = request.getCategoryId();

		RestTemplate restTemplate = new RestTemplate();
		Category category;
		String url = "http://localhost:9052/advertise/getCategory/" + categoryId;
		category = restTemplate.getForObject(url, Category.class);
		post.setCategory(category);

		url = "http://localhost:9051/user/find/" + userName;
		OlxUser olXUser = restTemplate.getForObject(url, OlxUser.class);
		post.setOlxUser(olXUser);
		System.out.println(olXUser);

		AdvertisementStatus advertismantStatus = new AdvertisementStatus(1, "OPEN");
		post.setAdvertisementStatus(advertismantStatus);

		AdvertisementPost advertisementPost = this.service.addAdvertisement(post);// entity saved to db

		NewAdvertisementPostResponse response = new NewAdvertisementPostResponse();
		response.setId(advertisementPost.getId());
		response.setTitle(advertisementPost.getTitle());
		response.setPrice(advertisementPost.getPrice());
		response.setCategory(advertisementPost.getCategory().getName());
		response.setDescription(advertisementPost.getDescription());
		response.setUserName(post.getOlxUser().getUserName());
		response.setCreatedDate(advertisementPost.getCreatedate());
		response.setModifiedDate(advertisementPost.getModifiedDate());
		response.setStatus(advertisementPost.getAdvertisementStatus().getStatus());

		return response;
	}

	@PutMapping("/advertise/{aid}/{username}")
	public NewAdvertisementPostResponse f2(@RequestBody NewAdvertisementPostRequest request,
			@PathVariable(name = "aid") int id, @PathVariable(name = "name") String name) {
		AdvertisementPost post = this.service.getadvertisementById(id);

		post.setTitle(request.getTitle());
		post.setDescription(request.getDescription());
		post.setPrice(request.getPrice());
		// post.setCategory(request.getCategory());

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://localhost:9052/advertise/getcategory/" + request.getCategoryId();
		Category category = restTemplate.getForObject(url, Category.class);
		post.setCategory(category);
		url = "http://localhost:9051/user/find/" + name;
		OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
		post.setOlxUser(olxUser);
		url = "http://localhost:9052/advertise/status/" + request.getStatusId();
		AdvertisementStatus advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
		post.setAdvertisementStatus(advertisementStatus);

		AdvertisementPost advertisementPost = this.service.addAdvertisement(post);
		NewAdvertisementPostResponse postResponse = new NewAdvertisementPostResponse();
		postResponse = new NewAdvertisementPostResponse();
		postResponse.setId(advertisementPost.getId());
		postResponse.setTitle(advertisementPost.getTitle());
		postResponse.setPrice(advertisementPost.getPrice());
		postResponse.setCategory(advertisementPost.getCategory().getName());
		postResponse.setDescription(advertisementPost.getDescription());
		postResponse.setUserName(post.getOlxUser().getUserName());
		postResponse.setCreatedDate(advertisementPost.getCreatedate());
		postResponse.setModifiedDate(advertisementPost.getModifiedDate());
		postResponse.setStatus(advertisementPost.getAdvertisementStatus().getStatus());
		return postResponse;

	}

	@GetMapping("/user/advertise/{userName}")
	public List<NewAdvertisementPostResponse> f3(@PathVariable(name = "userName") String userName) {
		List<AdvertisementPost> advPost = this.service.getAllAdvertisement();
		RestTemplate restTemplate = new RestTemplate();
		List<AdvertisementPost> filterList = new ArrayList<>();
		String url = "http://localhost:9051/user/find/" + userName;
		OlxUser olxuser = restTemplate.getForObject(url, OlxUser.class);

		for (AdvertisementPost post : advPost) {
			Category category;
			url = "http://localhost:9052/advertise/getcategory/" + post.getCategory().getId();
			category = restTemplate.getForObject(url, Category.class);
			post.setCategory(category);
			System.out.println("Category------" + post);

			url = "http//localhost:9052/advertise/status/" + post.getAdvertisementStatus().getId();
			AdvertisementStatus advertisementStatus;
			advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
			post.setAdvertisementStatus(advertisementStatus);
			System.out.println("AdvertisementStatus" + post);
			if (olxuser.getOlxUserId() == post.getOlxUser().getOlxUserId()) {
				post.setOlxUser(olxuser);
				filterList.add(post);

			}
		}
			System.out.println("List--------" + filterList);
			List<NewAdvertisementPostResponse> responseList = new ArrayList<>();
			for (AdvertisementPost advertisementPost : filterList) {
				NewAdvertisementPostResponse postResponse = new NewAdvertisementPostResponse();
				postResponse = new NewAdvertisementPostResponse();
				postResponse.setId(advertisementPost.getId());
				postResponse.setTitle(advertisementPost.getTitle());
				postResponse.setPrice(advertisementPost.getPrice());
				postResponse.setCategory(advertisementPost.getCategory().getName());
				postResponse.setDescription(advertisementPost.getDescription());
				postResponse.setUserName(advertisementPost.getOlxUser().getUserName());
				postResponse.setCreatedDate(advertisementPost.getCreatedate());
				postResponse.setModifiedDate(advertisementPost.getModifiedDate());
				postResponse.setStatus(advertisementPost.getAdvertisementStatus().getStatus());
				responseList.add(postResponse);

			}
			return responseList;
		}
	}
