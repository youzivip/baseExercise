package com.e8.useTest;

public class MessageHandlerTest {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandlerImpl();
        Integer i = messageHandler.handle("aaa123");
        System.out.println("i-->"+i);
    }
}
