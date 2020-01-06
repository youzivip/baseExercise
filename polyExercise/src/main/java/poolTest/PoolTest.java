package poolTest;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池，1 首先有一个放线程的池子，假如使用list 初始化里边的执行线程
 *       2  需要执行线程，Worker的run方法是可以执行Runable的run方法的，执行完之后从队列里边取
 *       3  可以定一个队列，队列中放等待执行的线程
 */
public class PoolTest {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        PoolExecutor executor = new PoolExecutor(2,new LinkedBlockingQueue());
        for (int i = 0; i < 6; i++) {
            executor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"开始执行!"+System.currentTimeMillis());
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName()+"执行了!"+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    private static void test1() throws InterruptedException {
        PoolExecutor executor = new PoolExecutor(2,new LinkedBlockingQueue());
        Thread t1 = new Thread(()->executor.execute(()-> System.out.println(Thread.currentThread().getName()+"执行第1个任务")),"T1");
        t1.start();


        Thread t2 = new Thread(()->{
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第2个任务");
            });
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第3个任务");
            });
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第4个任务");
            });
        },"T2");
        t2.start();

        Thread t3 = new Thread(()->{
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第12个任务");
            });
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第13个任务");
            });
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行第14个任务");
            });
        },"T3");
        t3.start();

        Thread.sleep(300l);
    }
}
