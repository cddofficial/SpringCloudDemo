package com.cdd.cloud.feign;

public class FeignClient2Fallback implements FeignClient2{

	@Override
	public String findServiceInfoByServiceName(String ServiceName) {
		return "haha";
	}
}


