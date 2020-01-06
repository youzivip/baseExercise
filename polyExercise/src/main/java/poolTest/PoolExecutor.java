package poolTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PoolExecutor {
    private volatile List<InWorkerThread> workers = new LinkedList<>();
    private final Queue<Runnable> queue;
    private final int coreSize;
    Lock lock = new ReentrantLock();
 //   Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

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
    void execute(Runnable r) {
        lock.lock();
        try {
            if (workers.size() < coreSize) {
                InWorkerThread worker = new InWorkerThread(r, queue);
                worker.start();
                workers.add(worker);
            } else {
                //   synchronized (queue){
                queue.add(r);
                System.out.println(Thread.currentThread().getName() + "加了一个任务到队列：" + queue.size());
                notEmpty.signal();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    class InWorkerThread extends Thread {

        Runnable task;


        public InWorkerThread(Runnable task,Queue q){
            this.task = task;
        }

        @Override
        public void run() {
            task.run();
            while (true){
                Runnable task1 = null;
                //  synchronized (queue){
                lock.lock();
                try {
                    if(queue.size()==0) notEmpty.await();
                    task1 = queue.peek();

                    if (task1 != null) {

                        queue.remove(task1);
                        System.out.println(Thread.currentThread().getName() + "取了一个任务,还剩：" + queue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                //         }
                try {
                    if(task1!=null){
                        task1.run();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    //           synchronized (queue){
                    queue.add(task1);
                    //          }


                }


            }


        }
    }

}


