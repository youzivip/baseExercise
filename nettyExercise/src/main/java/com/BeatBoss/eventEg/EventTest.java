package com.BeatBoss.eventEg;

import com.BeatBoss.eventEg.event.EventType;
import com.BeatBoss.eventEg.eventSource.Train;
import com.BeatBoss.eventEg.handler.CleanHandler;
import com.BeatBoss.eventEg.handler.WatingHandler;

/**
 * 1 需要产生事件----将什么东西包装成事件Event EventType everyThing can be
 * 2 事件需要派发
 * 3 有处理各事件的handler --- 多个handler可以链式处理
 * 4 事件怎么广播出去呢
 *
 * 假设一个场景，火车站，车到了--->接客，车晚点了--->通知，车开了--->送客  服务员
 *                      车到了--->开门，车晚点了--->等会儿开门，车开了--->关门   送站员
 */
public class EventTest {
    public static void main(String[] args) {
        HandlerContainer container = new HandlerContainer();
        container.addHandler(new WatingHandler()).addHandler(new CleanHandler());
        EventRegistry eventRegistry =  new EventRegistry(container);
        Train train = new Train(eventRegistry);
        train.produce(EventType.COMMING);
        train.produce(EventType.COMMING);
        train.produce(EventType.COMMING);
        train.produce(EventType.GONE);
        train.produce(EventType.LATER);
        train.produce(EventType.COMMING);






    }
}
