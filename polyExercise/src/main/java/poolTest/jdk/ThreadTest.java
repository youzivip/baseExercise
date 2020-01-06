package poolTest.jdk;

public class ThreadTest {
    public static void main(String[] args) {
        WorkerWithThread workerWithThread =new WorkerWithThread(()->{
            System.out.println("我是一个普通的任务");
        });

        Thread t = workerWithThread.thread;
        t.start();
        t.interrupt();


        WorkerNoThread noThread =  new WorkerNoThread(()->{
            System.out.println("no thread 任务");
        });
        new Thread(noThread).start();

    }
}
