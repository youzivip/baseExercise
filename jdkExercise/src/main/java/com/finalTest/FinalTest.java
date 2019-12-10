package com.finalTest;

import com.type.Person;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class FinalTest {

    private static Unsafe unsafe = null;
    private static Field getUnsafe = null;

    static {
        try {
            getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            unsafe = (Unsafe) getUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    final static Person person = new Person();
    static Person person2 = new Person();
    public static void main(String[] args) throws NoSuchFieldException {
//        testOffSet();
        person2 = person;
        person2.setName("是2呀");
        System.out.println(person);

        Person person3 = new Person();
        person3.setName("我是3，看final有没有");
        person2 = person3;
        System.out.println(person);
    }

    private static void testOffSet() throws NoSuchFieldException {
        person.setName("name");
        person2.setName("name");

//        System.out.println(person.getName());
        System.out.println("person第一次的地址："+unsafe.fieldOffset(FinalTest.class.getDeclaredField("person")));
        System.out.println("person2："+unsafe.fieldOffset(FinalTest.class.getDeclaredField("person2")));
        person.setName("asda");
        person2.setName("asda");
//        System.out.println(person.getName());
        System.out.println("person第二次的地址："+unsafe.fieldOffset(FinalTest.class.getDeclaredField("person")));
        ;
        System.out.println("person2："+unsafe.fieldOffset(FinalTest.class.getDeclaredField("person2")));
        ;
    }
}
