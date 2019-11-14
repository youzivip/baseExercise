package com.BeatBoss.futureEg;

public interface MyListener<T extends MyFuture> {
    void afterDone(T t);
}
