package com.cdd.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cdd.cloud.UserFeignClient;
import com.cdd.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}

	@GetMapping("/test")
	public User testPost(User user) {
		return this.userFeignClient.postUser(user);
	}
	
	@GetMapping("/get-user")
	public User testGet(User user) {
		return this.userFeignClient.getUser(user);
	}
}