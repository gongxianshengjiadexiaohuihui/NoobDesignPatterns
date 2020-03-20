package com.ggp.z_design_patterns.chainofresponsibility;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:21
 * @Description:
 */
public class SensitiveWordFilter implements  Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.print("request  SensitiveWorldFilter");
        chain.doFilter(request,response);
        response.print("request  SensitiveWorldFilter");
    }
}
