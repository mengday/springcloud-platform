package com.example.platform.api;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序，返回值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否生效，true开启过滤器，false关闭过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("TokenFilter：校验Token和签名是否合法");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        String timestamp = request.getHeader("timestamp");
        String signature = request.getHeader("signature");
        String version = request.getHeader("version");

//        if (token == null) {
//            ctx.setSendZuulResponse(false);
//            HttpServletResponse response = ctx.getResponse();
//            response.setContentType("application/json;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//
//            ApiResponse apiResponse = new ApiResponse();
//            apiResponse.setCode(403);
//            apiResponse.setMsg("Token错误");
//
//            try {
//                response.getWriter().write(JSONObject.toJSONString(apiResponse));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return null;
    }
}