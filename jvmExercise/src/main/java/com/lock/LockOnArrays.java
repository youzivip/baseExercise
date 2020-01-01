package com.lock;

import sun.text.normalizer.UBiDiProps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class LockOnArrays {



    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[10];
        List<Integer> arrays = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i <10; i++) {
            arrays.add(0);
        }
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0;i<1000;i++){
            Thread thread = new Thread(new OptArray(nums,i%10,i,arrays));
//            countDownLatch.countDown();
//            countDownLatch.await();
            thread.start();

        }

        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            System.out.print(arrays.get(i)+",");
        }
    }


}

class OptArray implements Runnable{

    int nums[];
    int index;
    int value;
    List<Integer> list;

    public OptArray(int[] nums,int index,int value,List<Integer> list) {
        this.nums = nums;
        this.index = index;
        this.value = value;
        this.list = list;
    }




    @Override
    public void run() {
     //   System.out.println("当前线程："+Thread.currentThread().getName()+"--->"+index+"  :"+value);
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     //   nums[index] = value;
        list.add(index,value);

    }
}
