package com.type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import netscape.javascript.JSObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeReferenceTest {

    public Map<String,Integer> map = new HashMap<>();
    public List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws NoSuchFieldException {
//        testListStr();
//        testListObjetc();
        //java虽然运行时会有类型擦除，但是会保留Field的泛型信息，可以通过Field.getGenericType() 取字段的泛型。
        TypeReferenceTest kest = new TypeReferenceTest();

        Field map = kest.getClass().getField("map");
        Field list = kest.getClass().getField("list");

        System.out.println("=====map=====");
        System.out.println("map.getType=" + map.getType());
        System.out.println("map.getGenericType=" + map.getGenericType());

        System.out.println("=====list=====");
        System.out.println("list.getType=" + list.getType());
        System.out.println("list.getGenericType=" + list.getGenericType());
    }

    private static void testListObjetc() {
        List<Person> list =  new ArrayList<>();
        list.add(new Person("张三",1));
        list.add(new Person("张三1",6));
        list.add(new Person("张三2",234));

        String s = JSONObject.toJSONString(list);
        List<Person> list1 = JSONObject.parseObject(s, new TypeReference<List<Person>>(){});
        list1 = (List<Person>) JSONObject.parseObject(s);
        System.out.println();
    }

    private static void testListStr() {
        List<String> list =  new ArrayList<>();
        list.add("dada");
        list.add("da");
        list.add("fff");
        list.add("sdadsads");
        list.add("dasdasdasd");
        String s = JSONObject.toJSONString(list);
        List<String> list1 = JSONObject.parseObject(s, new TypeReference<List<String>>(){});
        list1 = (List<String>) JSONObject.parseObject(s);
    }
}
