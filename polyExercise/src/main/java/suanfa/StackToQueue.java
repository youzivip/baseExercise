package suanfa;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> toPush = new Stack<>();
    Stack<Integer> toPop = new Stack<>();
    Object lock = new Object();

    public synchronized void push(int i){
            System.out.println(Thread.currentThread().getName()+",push:"+i);
            toPush.push(i);


    }

    public synchronized Integer pop(){
        if(toPop.size()==0 && toPush.size()==0) return null;

            if(toPop.size()>0) return toPop.pop();
            else {

                while (toPush.size()>0){
                    toPop.push(toPush.pop());
                }
                return toPop.pop();
            }


    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        Thread thread1 = new Thread(()->{
            test(stackToQueue,10);
        });
        Thread thread2 = new Thread(()->{
            test(stackToQueue,20);
        });
        thread1.start();
        thread2.start();


    }

    private static void test(StackToQueue stackToQueue,int t) {
        stackToQueue.push(t+1);
        for(int i = 0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+":"+stackToQueue.pop());
        }
        stackToQueue.push(t+2);
        stackToQueue.push(t+3);
        stackToQueue.push(t+4);
        for(int i = 0;i<2;i++){
            System.out.println(Thread.currentThread().getName()+":"+stackToQueue.pop());
        }
        stackToQueue.push(t+5);
        for(int i = 0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+":"+stackToQueue.pop());
        }
    }
}
