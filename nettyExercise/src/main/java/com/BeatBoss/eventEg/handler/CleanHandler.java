package com.BeatBoss.eventEg.handler;

public class CleanHandler implements Handler {
    @Override
    public void beforeComming() {
        System.out.println("CleanHandler 清扫空地，等待来临");
    }

    @Override
    public void afterGone() {
        System.out.println("CleanHandler 他们走了，快打扫吧");
    }

    @Override
    public void ifLater() {
        System.out.println("CleanHandler 继续等待");
    }
}
