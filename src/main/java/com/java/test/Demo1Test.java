package com.java.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Demo1Test {

    @Test
    public void test1(){
        List<String> aList= Arrays.asList("中国","美国","日本");
        aList.forEach(temp-> System.out.println(temp));

        Map<String,Object> aMap=new HashMap<>();
        aMap.put("bookName","Mysql从删库到跑路");
        aMap.put("Java","Java从入门到放弃");

        aMap.forEach((k,v)-> System.out.println(k+","+v));

    }
}
