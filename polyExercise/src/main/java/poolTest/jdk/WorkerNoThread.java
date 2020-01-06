package poolTest.jdk;

import java.util.concurrent.Executors;

public class WorkerNoThread implements Runnable {

    /** Thread this worker is running in.  Null if factory fails. */
//    final Thread thread;
    /** Initial task to run.  Possibly null. */
    Runnable firstTask;

    WorkerNoThread(Runnable firstTask) {
        this.firstTask = firstTask;
       // this.thread = Executors.defaultThreadFactory().newThread(this);
    }

    @Override
    public void run() {
        System.out.println("no 开始状态---》"+Thread.currentThread().getState());
        Runnable task = this.firstTask;
        this.firstTask = null;
        task.run();

        System.out.println(Thread.currentThread().getName());

        System.out.println("no 结束状态---》"+Thread.currentThread().getState());
    }
}
