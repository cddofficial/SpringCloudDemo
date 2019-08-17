package com.cdd.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	
//	@Autowired
//	private IClientConfig config;

	@Bean
	public IRule ribbonRule() {
		return new RandomRule();  //随机策略
	}
}
