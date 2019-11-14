package com.BeatBoss.eventEg;

import com.BeatBoss.eventEg.event.Event;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EventRegistry {
    Queue<Event> queue =  new ArrayBlockingQueue<>(100);
    HandlerContainer handlerContainer;

    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();

    public EventRegistry(HandlerContainer handlerContainer) {
        this.handlerContainer = handlerContainer;
         new Thread(()->run()).start();
    }

    public void registerEvent(Event event){
        try {
            lock.lock();
            queue.add(event);
            System.out.println(Thread.currentThread().getName()+"放了一个event"+event.eventType);
            notEmpty.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void run(){
        while (true){
            try {
                lock.lock();
                Event event = queue.poll();
                System.out.println(Thread.currentThread().getName()+"取出一个event"+event);
                if (Objects.nonNull(event)) {
                    handlerContainer.dealEvent(event);
                }else {
                    notEmpty.await();
//                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


}
