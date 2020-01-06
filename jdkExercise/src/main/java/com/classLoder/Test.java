package com.classLoder;

import com.classLoder.myExercise.ToBeLoaded;

/**
 * 编译出新的class文件
 */
public class Test {

    public static void main(String[] args) {
       /* ToBeLoaded toBeLoaded = new ToBeLoaded();
        toBeLoaded.p();*/

       int page = 0;
       int total = 100;
       do{
           System.out.println(++page);
           System.out.println(page);
       }while(page*20<total);
    }
}
