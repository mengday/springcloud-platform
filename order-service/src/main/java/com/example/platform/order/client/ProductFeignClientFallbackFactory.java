package com.example.platform.order.client;

import com.example.platform.order.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallbackFactory implements FallbackFactory<ProductFeignClient> {

    @Override
    public ProductFeignClient create(Throwable throwable) {

        return new ProductFeignClient() {
            @Override
            public Product product(Long id) {
                return new Product(0L, "熔断了" + throwable);
            }
        };
    }
}