package com.BeatBoss.eventEg.event;


public enum EventType {
    COMMING(1,"车来了"),
    LATER(1,"晚点了"),
    GONE(1,"车开走了"),

    ;
    int code;
    String desc;

    EventType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
