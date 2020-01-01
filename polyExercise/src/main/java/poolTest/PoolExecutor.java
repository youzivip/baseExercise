package poolTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PoolExecutor {
    private volatile List<WorkerThread> workers = new LinkedList<>();
    private final Queue<Runnable> queue;
    private final int coreSize;

    public PoolExecutor(int coreSize,Queue queue){
        this.queue = queue;
        this.coreSize = coreSize;
    }

    /**
     * 执行一个线程
     * 1 当前线程数是不是小于核心线程数 ，是的话，new一个线程执行
     * 2 否则放到队列
     * @param r
     */
    void execute(Runnable r){
        if(workers.size()<coreSize){
            WorkerThread worker = new WorkerThread(r,queue);
            worker.start();
            workers.add(worker);
        }else{
            synchronized (queue){
                System.out.println(Thread.currentThread().getName()+"加了一个任务到队列："+queue.size());
                queue.add(r);
            }
        }
    }


}
