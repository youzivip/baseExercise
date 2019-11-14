package com.BeatBoss.eventEg;

import com.BeatBoss.eventEg.event.Event;
import com.BeatBoss.eventEg.handler.Handler;

import java.util.ArrayList;
import java.util.List;

public class HandlerContainer {
    List<Handler> list = new ArrayList<>();

    public HandlerContainer addHandler(Handler handler){
        list.add(handler);
        return this;
    }

    public void dealEvent(Event event){
        switch (event.eventType){
            case GONE:list.forEach(handler -> handler.afterGone());
                break;
            case LATER:list.forEach(handler -> handler.ifLater());
                break;
            case COMMING:list.forEach(handler -> handler.beforeComming());
                break;
        }
    }

}
