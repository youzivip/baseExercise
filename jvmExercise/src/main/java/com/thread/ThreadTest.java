package com.thread;

public class ThreadTest {
    static boolean flag = false;

    public static void main(String[] args) {

    }

    public static void callBack(){
        flag = true;
    }
}

class A {
    int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class C extends Thread{

    private A a;

    public C(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.setA(1);
        ThreadTest.flag = true;

    }
}
