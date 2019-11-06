package com.event;

/**
 * 事件类型
 */
public enum EventType {
    WRITE(1,"读"),
    READ(2,"写"),
    DONOTHING(3,"我什么也不干");

    private Integer code;
    private String name;

    EventType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }}
