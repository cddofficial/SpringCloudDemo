package com.cdd.cloud;


import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

/**	
 * 这次搭建微服务时，用到的springCloud版本太低，没有FallbackProvider或ZuulFallbackPorovider接口，下面这个没有实战了。
 * 以后搭建微服务时尽量用高版本的springCloud
 * @author Administrator
 *
 */
//@Component
//class MyFallbackProvider implements FallbackProvider {
class MyFallbackProvider {

//    @Override
//    public String getRoute() {
//        return "microservice-provider-user";
//    }
//
//    @Override
//    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
//        if (cause instanceof HystrixTimeoutException) {
//            return response(HttpStatus.GATEWAY_TIMEOUT);
//        } else {
//            return response(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    private ClientHttpResponse response(final HttpStatus status) {
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return status;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return status.value();
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return status.getReasonPhrase();
//            }
//
//            @Override
//            public void close() {
//            }
//
//            @Override
//            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream("fallback".getBytes());
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);
//                return headers;
//            }
//        };
//    }
}

