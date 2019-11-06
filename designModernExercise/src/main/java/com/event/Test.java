package com.event;

import com.event.event.Event;
import com.event.event.ReadEvent;
import com.event.event.WriteEvent;
import com.event.listener.IOEventListener;

import java.util.EventListener;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WriteEvent event = new WriteEvent();
        IOEventListener eventListener =  new IOEventListener();

        Selector selector =  new Selector();
        selector.addListener(eventListener);
        selector.handleEvent(event);

        new Thread(()->selector.select()).start();

        ReadEvent event2 = new ReadEvent();
         selector.handleEvent(event2);




    }
}
