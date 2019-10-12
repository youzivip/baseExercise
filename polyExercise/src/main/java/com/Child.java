package com;

public class Child extends Parent {
    public static String a;
    static {
        a = "asdsd";
        System.out.println("我是子类的静态块--a:"+a);
    }

    public Child() {
        System.out.println("我是Child的Construct--a:"+a);

    }
}
