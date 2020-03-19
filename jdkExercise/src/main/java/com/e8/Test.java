package com.e8;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test{
    public static boolean f(Function<Integer,Boolean> f,Integer t){
        return f.apply(t);
    }
    private static final String SEPARATOR = "|";
    private static final String UNION = "_";
    public static void main(String[] args) {
//        testException();
        //test2();

        String userScores = "pin_1000|pin1_2000";
        Map<String,Integer> map = new HashMap<>();
        String[] s = StringUtils.splitString(userScores,SEPARATOR);
        Stream.of(s).forEach(e->{
            String[] userAndScore =StringUtils.splitString(e,UNION);
            if (userAndScore.length != 2) return;
            map.put(userAndScore[0],Integer.parseInt(userAndScore[1]));
        });
        System.out.println(map);
    }

    private static void test2() {
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
