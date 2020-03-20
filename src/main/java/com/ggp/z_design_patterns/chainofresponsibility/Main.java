package com.ggp.z_design_patterns.chainofresponsibility;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:27
 * @Description:    servletFilter 的模拟实现
 */
public class Main {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.chain.add(new SensitiveWordFilter());
        chain.chain.add(new SpecialCharactersFilter());
        chain.doFilter(new Request(),new Response());

    }
}
