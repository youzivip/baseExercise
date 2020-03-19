package com.dynamicTest.methodHandleTest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Objects;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println("classA-->"+s);
        }
    }

    public static void main(String[] args) throws Throwable{
        Object obj = System.currentTimeMillis() % 2 == 0?
                System.out:new ClassA();

        MethodHandle methodHandle = getP(obj);
        methodHandle.invokeExact("ada");

    }

    public static MethodHandle getP(Object s) throws Throwable{
        MethodType methodType = MethodType.methodType(void.class,String.class);
        // static 使用的是findStatic
        //todo 这个bindTo非常重要，不然非static,constructor对象需要插入一个对象作为入参，即invoke的时候需要增加入参
        MethodHandle m = lookup().findVirtual(s.getClass(),"println",methodType).bindTo(s);
        return m;
    }
}
