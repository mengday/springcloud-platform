package com.example.platform.order;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class FeignClientConfiguration {

    @Bean("feignRequestInterceptor")
    public RequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}