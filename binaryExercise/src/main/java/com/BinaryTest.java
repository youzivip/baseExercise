package com;

public class BinaryTest {
    public static void main(String[] args) {
        int a = 19;
        System.out.println(Integer.toBinaryString(a));
        System.out.println("第"+(CtlFlagEnum.CTL_F.getIndex())+"位是否为1："+CtrlFalgUtils.getOneByIndex(a,CtlFlagEnum.CTL_F.getIndex()));
        System.out.println("第"+(CtlFlagEnum.CTL_G.getIndex())+"位是否为1："+CtrlFalgUtils.getOneByIndex(a,CtlFlagEnum.CTL_G.getIndex()));

        System.out.println(Integer.toBinaryString((1<<31)-1 - (1<<2)));
        int b = CtrlFalgUtils.setZeroByIndex(a,0);
        System.out.println(Integer.toBinaryString(b));

        int b1 = CtrlFalgUtils.setZeroByIndex(a,1);
        System.out.println(Integer.toBinaryString(b1));


        int b2 = CtrlFalgUtils.setZeroByIndex(a,3);
        System.out.println(Integer.toBinaryString(b2));

        int c = CtrlFalgUtils.setOneByIndex(b,0);
        System.out.println(Integer.toBinaryString(c));

        int c1 = CtrlFalgUtils.setOneByIndex(b,11);
        System.out.println(Integer.toBinaryString(c1));

        int c2 = CtrlFalgUtils.setOneByIndex(0,2);
        System.out.println(Integer.toBinaryString(c2));
    }
}
