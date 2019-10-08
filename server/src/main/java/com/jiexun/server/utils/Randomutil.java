package com.jiexun.server.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Administrator on 2019-09-30.
 */
public class Randomutil {
    private Randomutil(){}

    private static final SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddHHmmss");

    private static final ThreadLocalRandom random=ThreadLocalRandom.current();
    /**
     * 生成订单编号
     * @return
     */
    public static String generateOrderCode(){

        return dateFormat.format(DateTime.now().toDate())+generateNumber(4);

    }

    public static String generateNumber(final int num){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <num ; i++) {
           sb.append(random.nextInt(9)) ;

        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        for (int i = 0; i <10000 ; i++) {
            System.out.println(generateOrderCode());
        }
    }*/
}
