package poolTest.jdk;

import java.util.concurrent.Executors;

public class WorkerWithThread implements Runnable {

    /** Thread this worker is running in.  Null if factory fails. */
    final Thread thread;
    /** Initial task to run.  Possibly null. */
    Runnable firstTask;

    WorkerWithThread(Runnable firstTask) {
        this.firstTask = firstTask;
        this.thread = Executors.defaultThreadFactory().newThread(this);
    }

    @Override
    public void run() {
        System.out.println("当前线程是否为thread:"+Thread.currentThread().equals(thread));
        System.out.println("开始状态---》"+thread.getState());
        Runnable task = this.firstTask;
        this.firstTask = null;
        task.run();

        System.out.println("结束状态---》"+thread.getState());
    }
}
