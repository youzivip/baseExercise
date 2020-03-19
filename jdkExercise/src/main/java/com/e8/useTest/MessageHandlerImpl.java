package com.e8.useTest;

import java.util.function.Function;
import java.util.function.Predicate;

public class MessageHandlerImpl implements MessageHandler {
    @Override
    public Predicate filter(String msg) {
        return (o)->  msg.contains("aaa");
    }

    @Override
    public  Function<String, Integer> fun(String msg) {
        return (s)->{
            if(s.contains("123")) return 1;
            else return 2;
        };
    }
}
