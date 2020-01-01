package com.annotionTest;


public class ToAnnotation {
    @RunTimeAnnotation(id="123")
    public void test1(String pas){
        System.out.println(pas);

    }

    public void testParamA(@ParamAnnotation(num = "${num1}") String num1,int r){
        System.out.println(num1);
    }

    @SourceAnnotation
    public void test2(){

    }

    public static void main(String[] args) {

    }
}
