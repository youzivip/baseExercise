package com.BeatBoss.futureEg;

import java.util.List;

public interface MyFuture {

    void work();

    boolean isDone();

    void addListener(MyListener myListener);

    List<MyListener> getListener();

    void get();
}
