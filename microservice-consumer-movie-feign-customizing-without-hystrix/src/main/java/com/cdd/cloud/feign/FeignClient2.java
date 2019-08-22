package com.cdd.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdd.config.Configuration2;

@FeignClient(
		name="xxxx",
		url="localhost:8761",
		configuration = Configuration2.class,
		fallback=FeignClient2Fallback.class)
public interface FeignClient2 {

	@RequestMapping("/eureka/apps/{serviceName}")
	public String findServiceInfoByServiceName(@PathVariable(name = "serviceName") String ServiceName);
	
}
