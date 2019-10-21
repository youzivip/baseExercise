package com.e8;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test{
    public static boolean f(Function<Integer,Boolean> f,Integer t){
        return f.apply(t);
    }

    public static void main(String[] args) {
//        testException();
        List<String > a = new ArrayList<>();
        a.add("da");
        a.add("dad");
        String b =  JSON.toJSONString(a);
        System.out.println(b);
        System.out.println(JSON.parseObject(b,List.class));
    }

    private static void testException() {
        try {
            f((t)->{
                System.out.println(t);
                throw new RuntimeException("我就是想抛个异常");},9);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
