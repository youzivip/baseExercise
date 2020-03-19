package com.e8.useTest;



import java.util.function.Function;
import java.util.function.Predicate;

public interface MessageHandler {
    default <R> R handle(String message){
        //不实用negate !test 过滤器
        if(filter(message).negate().test(message)){
            return null;
        }
        // consumer

        // function
        return (R)fun(message).apply(message);

    }

    Predicate filter(String msg);

    <R> Function<String,R> fun(String msg);
}
