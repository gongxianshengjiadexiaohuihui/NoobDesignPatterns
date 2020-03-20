package com.ggp.z_design_patterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:17
 * @Description:
 */
public class FilterChain {
    List<Filter> chain = new ArrayList<>();
    int index=0;
    public void doFilter(Request request,Response response){
        if(index >=chain.size()){
            return;
        }
        chain.get(index++).doFilter(request,response,this);
    }
}
