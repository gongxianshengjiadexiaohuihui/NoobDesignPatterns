package com.ggp.z_design_patterns.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:12
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream =  new FileInputStream("");
        /**
         *   这个 inputReader就是适配FileInputStream和 BufferedReader 的 配置器
         *   也混杂了装饰器模式
         */
        InputStreamReader reader =  new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line  = bufferedReader.readLine();
        while (null != line &&!line.equals("")){
            System.out.println(line);
            line = bufferedReader.readLine();
        }

    }
}
