package com.exceptiontest;

public class ExceptionTest {
    public static void main(String[] args) {
        //test1();

        try{
            while (true){
                try {
                    System.out.println("start");
                    throw new Exception("aaaa");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("finally 执行了");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("外层finally");
        }

    }

    private static void test1() {
        try {
            System.out.println("外层的start");
            if(0==0)
            throw new Exception("外层异常");
            try {
                System.out.println("start");
                throw new Exception("aaaa");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("finally 执行了");
            }
        }catch (Exception w){}
        finally {
            System.out.println("外层finally");
        }
    }
}
