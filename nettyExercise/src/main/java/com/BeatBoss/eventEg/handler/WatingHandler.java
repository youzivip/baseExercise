package com.BeatBoss.eventEg.handler;

import com.BeatBoss.eventEg.handler.Handler;

public class WatingHandler implements Handler {
    @Override
    public void beforeComming() {
        System.out.println("WatingHandler 需要等待");
    }

    @Override
    public void afterGone() {
        System.out.println("WatingHandler 关门送客了");
    }

    @Override
    public void ifLater() {
        System.out.println("WatingHandler 告知晚点了");
    }
}
