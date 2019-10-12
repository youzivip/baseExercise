package com;

public class Parent {
    public String b = "p";

    static {
        System.out.println("我是父类的static 块");
    }

    public Parent() {
        System.out.println("我是父类的初始化  construct"+b);
    }
}
