package com.cdd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   
//@EnableDiscoverClient
public class MicroserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
	}

}
