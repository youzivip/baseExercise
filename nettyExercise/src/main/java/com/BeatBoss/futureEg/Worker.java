package com.BeatBoss.futureEg;


public class Worker {

    public void syncWork(){
        doRealWork();
    }

    public MyFuture work(){
        MyFuture myFuture = new MyFutureImpl();
        new Thread(()->{
            doRealWork();
            myFuture.work();
        }).start();
        return myFuture;
    }


    void doRealWork(){
        try {
            // 假设是在做逻辑
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
