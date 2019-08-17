package com.cdd.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.cdd.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@SessionScope  //传播安全上下文
//@RequestScope  //
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback", 
			commandProperties = {
				      @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
				    }
	)
	public User findById(@PathVariable Long id) {
		return restTemplate.
				getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	/**
	 * findById接口的失败回调方法
	 * 返回，参数要和原方法一致
	 * @param id
	 * @return
	 */
	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}
	
}
