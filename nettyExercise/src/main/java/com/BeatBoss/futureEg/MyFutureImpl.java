package com.BeatBoss.futureEg;

import java.util.ArrayList;
import java.util.List;

public class MyFutureImpl implements MyFuture{

    volatile boolean state = false;
    List<MyListener> listeners = new ArrayList<>();
    /**
     * 真正执行工作的逻辑,执行完，状态改为True
     * 执行工作的逻辑应该不要放在future里边吧
     *  如果在Future中添监听，那么应该是不同的事件，获取不同的future吧，每次获取的future都是一个新建的
     */
    @Override
    public void work() {
        state = true;
        System.out.println("work-->"+System.currentTimeMillis()+"   "+listeners.size());
        listeners.forEach(l->l.afterDone(this));
    }

    @Override
    public boolean isDone() {
        return state;
    }

    @Override
    public void addListener(MyListener myListener) {
        System.out.println("添加listener-->"+System.currentTimeMillis());
        listeners.add(myListener);
        if(isDone()){
            System.out.println("isDone-->"+System.currentTimeMillis());
            listeners.forEach(l->l.afterDone(this));
        }
    }

    @Override
    public List<MyListener> getListener() {
        return listeners;
    }

    @Override
    public void get() {
        while (true){
            if(isDone()) return;
        }
    }
}
