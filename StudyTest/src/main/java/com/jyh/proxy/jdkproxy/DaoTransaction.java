package com.jyh.proxy.jdkproxy;

public class DaoTransaction {
    public void before(){
        System.out.println("收款10元");
    }
    public void after(){
        System.out.println("结束！");
    }
}
