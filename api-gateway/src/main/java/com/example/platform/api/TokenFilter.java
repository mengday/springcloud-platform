//package com.example.platform.api;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//@Component
//public class TokenFilter implements GlobalFilter, Ordered {
//    /**
//     * 执行过滤器中的业务逻辑
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        exchange.getResponse().getHeaders().set("Content-Type","application/json;charset=UTF-8");
//        List<String> tokenList = exchange.getRequest().getHeaders().get("token");
//        if (CollectionUtils.isEmpty(tokenList)) {
//            ServerHttpResponse response = exchange.getResponse();
//
//            JSONObject responseObj = new JSONObject();
//            responseObj.put("code", 500);
//            responseObj.put("msg", "Token错误");
//
//            byte[] bytes = responseObj.toJSONString().getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
//            return response.writeWith(Flux.just(buffer));
//        }
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 过滤器执行顺序，值越小优先级越高
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}