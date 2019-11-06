package com.event.event;

import com.event.EventType;

public class WriteEvent implements Event {
    @Override
    public EventType getEventType() {
        return EventType.WRITE;
    }
}
