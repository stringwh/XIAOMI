package com.scce.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther JHY
 * @data 2019/7/8 17:27
 **/
public class OrderNumGenerator {

    public static String getOrderNum(){
        Date now = new Date();
       SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
       String nowstr=f.format(now);
        int a = (int)(Math.random()*100000);
        String str=nowstr+a;
        return str;
    }
}
