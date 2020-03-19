package com.baseTest.extendTest;

public class ChildB extends SuperClass {
    @Override
    public void m1() {
//        super.m1();
    }

    @Override
    public void m2() {
        System.out.println("b m2");
//        super.m2();
    }

    public static void main(String[] args) {
        ChildB childB = new ChildB();
        childB.m2();
    }
}
