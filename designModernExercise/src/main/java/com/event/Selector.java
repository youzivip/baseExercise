package com.event;

import com.event.event.Event;
import com.event.listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 可以注册事件，选择出事件
 */
public class Selector<T extends EventListener> {

    EventLoop eventLoop = new EventLoop();
    List<T> listeners = new ArrayList<>();

    public void handleEvent(Event e){
        eventLoop.addEvent(e);
    }

    public void addListener(T listener){
        listeners.add(listener);
    }

    public void select(){
        while (true){
            Event event =  eventLoop.getEvent();
            if(Objects.nonNull(event)){
                listeners.stream().forEach(eventListener -> eventListener.handler(event));
            }
        }

    }

}
