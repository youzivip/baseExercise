package com.event.event;

import com.event.EventType;

public class ReadEvent implements Event {
    @Override
    public EventType getEventType() {
        return EventType.READ;
    }
}
