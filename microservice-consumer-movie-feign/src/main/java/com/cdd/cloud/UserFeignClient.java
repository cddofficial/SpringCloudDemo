package com.cdd.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdd.cloud.entity.User;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

	/**
	 * 使用feign时这里有两个坑，1：不能使用@GetMapping；2: @PathVariable注解得设置value值
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") long id);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	//该请求不会成功，只要参数是复杂java对象，即使指定了请求方法，也不生效
	@RequestMapping(value = "/get-user",method = RequestMethod.GET)
	public User getUser(User user);
}
