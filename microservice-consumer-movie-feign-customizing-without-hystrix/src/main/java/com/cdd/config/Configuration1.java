package com.cdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

/**
   *  自定义feign组件配置，覆盖默认配置
 * @author Administrator
 */
@Configuration
public class Configuration1 {

	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
	
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
