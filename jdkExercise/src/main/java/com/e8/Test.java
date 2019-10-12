package com.e8;

import java.util.function.Function;

public class Test{
    public static boolean f(Function<Integer,Boolean> f,Integer t){
        return f.apply(t);
    }

    public static void main(String[] args) {
        try {
            f((t)->{
                System.out.println(t);
                throw new RuntimeException("我就是想抛个异常");},9);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
