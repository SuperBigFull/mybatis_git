package com.java.test;

public interface A {
    int aaa();
    default String test(){
        return "aaa";
    }
}
