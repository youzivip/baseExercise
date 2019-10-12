package com;

public class CtrlFalgUtils {
    final int a = 1<<32;

    /**
     * 查询该标志位的数是否为1
     * @param toGet
     * @param index
     * @return
     */
    static boolean  getOneByIndex(Integer toGet,int index){
        return (toGet & 1<<index) >0?true:false;
    }


    /**
     * 将某一位的数改为1
     * @param toGet
     * @param index
     * @return
     */
    static Integer setOneByIndex(Integer toGet,int index){
        return toGet | 1<<index;
    }

    /**
     * 将某一位的数改为0
     * @param toGet
     * @param index
     * @return
     */
    static Integer setZeroByIndex(Integer toGet,int index){
        System.out.println("改为0---》"+Integer.toBinaryString((1<<31) -1 - (1<<index)));
        return toGet & ((1<<31) -1 - (1<<index));
    }


}
