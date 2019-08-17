package com.cdd.cloud.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cdd.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalacerClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		//这里会有VIP(virtual ip)虚拟IP
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/test")
	public void test() {
		//自定义策略：随机
		ServiceInstance serviceInstance = this.loadBalacerClient.choose("microservice-provider-user");
		System.out.println("111:" + serviceInstance.getUri() + ":"+serviceInstance.getServiceId());
		
		//默认策略：轮询
		ServiceInstance serviceInstance1 = this.loadBalacerClient.choose("microservice-provider-user2");
		System.out.println("222:" + serviceInstance1.getUri() + ":"+serviceInstance1.getServiceId());
	}
	
	@GetMapping("/list-all")
	public List<User> listAll(){
		
		//wrong
//		List<User> list = 
//				this.restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
//		for(User user : list) {
//			System.out.println(user.getName());
//		}
		
		//right
		User[] users = this.restTemplate.getForObject("http://microservice-provider-user/list-all", User[].class);
		List<User> list2 = Arrays.asList(users);
		for(User user : list2) {
			System.out.println(user.getName());
		}
		return list2;
		
	}
}
