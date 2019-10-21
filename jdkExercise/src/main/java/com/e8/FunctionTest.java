package com.e8;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class FunctionTest {
    public static <T,R> Result<R> invokeMethod(Function<T,R> f,T param){
        System.out.println("这里是公共的需要处理的逻辑"+ JSONObject.toJSONString(param));
        R r= f.apply(param);
        System.out.println("个性化逻辑处理完，构建result"+JSONObject.toJSONString(param));
        Result<R> rResult = new Result<>();
        rResult.setDate(r);
        return rResult;
    }

    public static void main(String[] args) {
//        testFunction();

        Map<String,Integer> map = new HashMap<>();
        map.put("w",1343);
        map.put("s",123);
        map.put("f",3);
        map.put("fw",87787);
        map.put("fsw",8778444);

        if(Objects.nonNull(map) ){ //非会员，且设置了会员等级积分，需要最大积分
            Optional<Integer> score = map.values().parallelStream().max(Integer::compareTo);
            System.out.println(score.get());
        }
    }

    private static void testFunction() {
        Function<String,Integer> function1 = (s)->Integer.parseInt(s);
        Function<Integer,String> function2 = (i)->{
            if(i>0){
                return "i>0";
            }
            return "i 不大于 0";
        };

        Result<Integer> result = invokeMethod(function1,"13");
        Result<String> result1 = invokeMethod(function2,3);

        System.out.println(result);
        System.out.println(result1);
    }
}


class Result<T>{
    T t;

    public T getData() {
        return t;
    }

    public void setDate(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "data:--"+t;
    }
}