package com.classLoder.eg;

public class ClassLoaderTest {
    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }
}
