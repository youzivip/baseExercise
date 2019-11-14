package com.BeatBoss;

import com.BeatBoss.futureEg.MyFuture;
import com.BeatBoss.futureEg.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 1 future可以实现异步
 * 2 future添加Listener进行监听  参见DefaultPromise
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException {
//        testFutureAndListener();

        timeCompare();

    }

    /**
     * 时间比较出来，异步快很多哟
     * @throws InterruptedException
     */
    private static void timeCompare() throws InterruptedException {
        int c = 10;
        CountDownLatch countDownLatch =  new CountDownLatch(10);
        long s = System.currentTimeMillis();
        for (int i = 0;i<c;i++){
            Worker worker = new Worker();
            worker.syncWork();
        }
        long t = System.currentTimeMillis()-s;
        System.out.println("同步执行"+c+"次花费时间"+t );

        long s1 = System.currentTimeMillis();

        List<MyFuture> myFutures = new ArrayList<>();
        for (int i = 0;i<c;i++){
            Worker worker = new Worker();
            myFutures.add(worker.work());
        }
        myFutures.forEach(f->{
            f.get();
            countDownLatch.countDown();
        });
        countDownLatch.await();
        long t1 = System.currentTimeMillis()-s1;
        System.out.println("异步执行"+c+"次花费时间"+t1 );
    }

    private static void testFutureAndListener() {
        Worker worker = new Worker();
        MyFuture myFuture = worker.work();
        myFuture.addListener(f->{
            System.out.println("我的任务完成了的"+System.currentTimeMillis());
        });
        System.out.println("size-->"+myFuture.getListener().size());
    }
}
