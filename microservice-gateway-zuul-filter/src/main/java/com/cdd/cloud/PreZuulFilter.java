package com.cdd.cloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		// 要用这个过滤器吗？用-true;不用-false
		return true;  
	}

	// 实现业务逻辑
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String host = request.getRemoteHost();
		LOG.info("请求的host：{}",host);
		return null; //可能会返回一些任意工件。 当前的实现忽略它。
	}

	@Override
	public String filterType() {
		// zuul过滤器的类型
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 这个过滤器执行的顺序，数字越大越靠后
		return 1;
	}

}
