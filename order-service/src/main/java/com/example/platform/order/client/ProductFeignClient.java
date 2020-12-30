package com.example.platform.order.client;

import com.example.platform.order.FeignClientConfiguration;
import com.example.platform.order.Product;
import com.example.platform.order.client.ProductFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", fallbackFactory = ProductFeignClientFallbackFactory.class, configuration = FeignClientConfiguration.class)
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product product(@PathVariable("id") Long id);
}