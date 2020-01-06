package poolTest.threadBaseTest;

/**
 * 可以被中断n 次呀
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("我被中断了-----无锁");
                        break;
                    }
                }
        });
        thread.start();
        thread.interrupt();


        Thread thread1 = new Thread(()->{
            synchronized ("a"){
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("我被中断了-----有锁");
                        break;
                    }
                }

            }
        });
        thread1.start();
        thread1.interrupt();
    }
}
