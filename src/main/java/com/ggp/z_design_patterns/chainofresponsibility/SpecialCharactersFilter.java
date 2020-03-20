package com.ggp.z_design_patterns.chainofresponsibility;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:25
 * @Description:
 */
public class SpecialCharactersFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.print("request SpecialCharactersFilter");
        chain.doFilter(request,response);
        response.print("response SpecialCharactersFilter");
    }
}
