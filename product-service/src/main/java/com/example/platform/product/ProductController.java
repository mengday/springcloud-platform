package com.example.platform.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/{id}")
    public Product product(@PathVariable("id") Long id, @RequestHeader(value = "token", required = false) String token) {
        try {
            Thread.sleep(id * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Product(id, "Product-" + id + "-" + "(" + ip + ":" + port + ")" + token);
    }
}