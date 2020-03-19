package com.dynamicTest.loopDynmTest;

public class CarImpl implements Car {
    @Override
    public void run(String sound) {
        System.out.println("跑起来："+sound);
    }

    @Override
    public void stop(String name) {
        System.out.println(name+"  stop");
    }
}
