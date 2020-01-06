package poolTest.jdk;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        // ExecutorService executor = Executors.newFixedThreadPool(2);
        //test1(executor);
        ExecutorService executor = new ThreadPoolExecutor(2,4,10,
                TimeUnit.NANOSECONDS,new LinkedBlockingQueue<>(1));

        Field[] fields = ThreadPoolExecutor.class.getDeclaredFields();

        Field field = ThreadPoolExecutor.class.getDeclaredField("workers");
        field.setAccessible(true);


        System.out.println("初始线程数-->"+((ThreadPoolExecutor)executor).getActiveCount()+",线程："+((Set) field.get(executor)).size());
        test1(executor);
        Thread.sleep(2000);
        System.out.println("执行后线程数-->"+((ThreadPoolExecutor)executor).getActiveCount()+",线程："+((Set) field.get(executor)).size());

    }

    private static void test1(ExecutorService executor) throws NoSuchFieldException, IllegalAccessException {
        Field field = ThreadPoolExecutor.class.getDeclaredField("workers");
        field.setAccessible(true);

        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"开始执行!"+System.currentTimeMillis());
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName()+"执行了!"+System.currentTimeMillis());
                    System.out.println("执行时的线程数-->"+((ThreadPoolExecutor)executor).getActiveCount()+",线程："+((Set) field.get(executor)).size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
