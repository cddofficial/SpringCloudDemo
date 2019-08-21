package com.cdd.cloud.feign;

import org.springframework.stereotype.Component;

import com.cdd.cloud.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}
	
}