package poolTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池，1 首先有一个放线程的池子，假如使用list 初始化里边的执行线程
 *       2  需要执行线程，Worker的run方法是可以执行Runable的run方法的，执行完之后从队列里边取
 *       3  可以定一个队列，队列中放等待执行的线程
 */
public class PoolTest {
    public static void main(String[] args) {
        PoolExecutor executor = new PoolExecutor(2,new LinkedBlockingQueue());
        executor.execute(()-> System.out.println("我是第1个任务"));
        executor.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是第2个任务");
        });
        executor.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是第3个任务");
        });
        executor.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是第4个任务");
        });
        executor.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是第5个任务");
        });

    }
}
