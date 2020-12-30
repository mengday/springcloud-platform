package com.example.platform.order;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = TokenInterceptor.threadLocal.get();
        requestTemplate.header("token", token);
    }
}