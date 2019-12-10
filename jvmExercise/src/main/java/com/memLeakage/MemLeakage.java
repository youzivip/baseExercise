package com.memLeakage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 内存泄露
 */
public class MemLeakage {

    static  byte[] a = new byte[1024*10];
    static  byte[] b = new byte[1024*10];
    static  byte[] c = new byte[1024*10*11];
    static  byte[] d = new byte[1024*10];




    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(
                50000);

        System.out.println("程序开始");


        int i=0;
        List l = new LinkedList();
        while (true){
            l.add(new MemLeakage()) ;
            System.out.println(i++);
        }
    }
}
