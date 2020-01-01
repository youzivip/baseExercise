package com.collectionTest;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {

    static AtomicInteger c = new AtomicInteger();
    static final int  NUM = 400;
    static final CountDownLatch count = new CountDownLatch(NUM);

    public static void main(String[] args) throws InterruptedException {
        Map<Integer,String> map =new HashMap<>(16);
        Map<Integer,String> map1 =new ConcurrentHashMap<>(16);

        for (int i = 0;i<NUM;i++){
            Thread t = new optMapClass(map);
            t.start();
        }
        count.await();
        System.out.println(map.size());
    }
}


class optMapClass extends Thread{

    Map map;

    public optMapClass( Map map) {
        this.map = map;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(10);
        map.put(HashMapTest.c.addAndGet(1),"231");
        HashMapTest.count.countDown();
    }
}
