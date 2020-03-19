package com.e8.useTest;

import java.util.function.Function;

public class UseFunctionAsParam {
    public static void main(String[] args) {
        testFunction();
    }

    private static void testFunction() {
        int j = invoke((i)->i+1,1);
        System.out.println("j-->"+j);

        String s = invoke((ss)->{
            if(ss.contains("123")) return "f";
            return "t";
        },"aa");
        System.out.println("s--->"+s);
    }

    public static <R,T> R invoke(Function<T,R> function,T t){
        System.out.println("需要公共处理的东西");
        return function.apply(t);
    }
}
