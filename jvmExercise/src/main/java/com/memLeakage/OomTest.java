package com.memLeakage;

import java.util.ArrayList;
import java.util.List;

public class OomTest {
    List list = new ArrayList();
    public static void main(String[] args) {
        OomTest test = new OomTest();
        int i = 0;
        while(true){
            test.list.add(Integer.MAX_VALUE);
            System.out.println(i++);
        }
    }
}
