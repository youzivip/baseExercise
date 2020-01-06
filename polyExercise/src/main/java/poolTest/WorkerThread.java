package poolTest;

import java.util.Queue;

public class WorkerThread extends Thread {

    Runnable task;
    Queue<Runnable> queue;

    public WorkerThread(Runnable task,Queue q){
        this.task = task;
        this.queue = q;
    }

    @Override
    public void run() {
        task.run();
        while (true){
            Runnable task1;
          //  synchronized (queue){
                task1 = queue.peek();
                if (task1 != null) {
                    System.out.println(Thread.currentThread().getName() + "取了一个任务：" + queue.size());
                    queue.remove(task1);
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
