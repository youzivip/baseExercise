package com.BeatBoss.eventEg.eventSource;

import com.BeatBoss.eventEg.EventRegistry;
import com.BeatBoss.eventEg.event.Event;
import com.BeatBoss.eventEg.event.EventType;

public class Train {

    EventRegistry eventRegistry;

    public Train(EventRegistry eventRegistry) {
        this.eventRegistry = eventRegistry;
    }

    public Event produce(EventType eventType){
        Event event = new Event(eventType);
        eventRegistry.registerEvent(event);
        return event;
    }



}
