package com.ggp.z_design_patterns.chainofresponsibility;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:15
 * @Description:
 */
public interface Filter {
    void doFilter(Request request,Response response,FilterChain chain);
}
