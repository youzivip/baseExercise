package com.event.listener;

import com.event.event.Event;

public class IOEventListener implements EventListener {

    public void handler(Event e){
        System.out.println("我是一个Lisenter呀");
        System.out.println(Thread.currentThread().getName()+":"+e.getEventType().name()+":"+"我是一个要干大事的事件"+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+e.getEventType().name()+":"+System.currentTimeMillis()+"end");
    }
}
