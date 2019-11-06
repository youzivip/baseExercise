package com.event;

import com.event.event.Event;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 事件循环器，循环出要使用的事件
 */
public class EventLoop {

    ArrayBlockingQueue<Event> queue = new ArrayBlockingQueue<Event>(128);

    public boolean addEvent(Event e){
        return queue.add(e);
    }

    public Event getEvent(){
        return queue.poll();
    }
}
