package com.cdd.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cdd.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		LOGGER.info("fallback; reason was: {}", cause.getMessage());
		
		return new UserFeignClientWithFactory() {
			@Override
			public User findById(long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}
}
