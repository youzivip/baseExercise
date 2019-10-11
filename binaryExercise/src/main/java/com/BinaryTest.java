package com;

public class BinaryTest {
    public static void main(String[] args) {
        int a = 139;
        System.out.println(Integer.toBinaryString(a));
        for (int i = 0;i<10;i++){
            System.out.println("第"+(i+1)+"位是否为1："+((a&(1<<i)) == 0?0:1));

        }

    }
}
