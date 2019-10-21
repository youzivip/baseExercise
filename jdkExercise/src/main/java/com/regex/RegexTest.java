package com.regex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class RegexTest {
    public static final String UNDER_LINE = "_";
    public static void main(String[] args) {
//        test();
//        test2("/(activity|exchange|e)/.*", "/activity/ere", "/e/ere", "/exchange/ere", "/eeee/ere", "/a/ere");

        String memberLevelInfo = "1_黄金|2_bai";
        Map memberLevelInfoMap = new LinkedHashMap();
        if(memberLevelInfo != null){
            String[] memberLevelInfos = memberLevelInfo.split("\\|");
            for (String s:memberLevelInfos){
                int index = s.indexOf("_");
                memberLevelInfoMap.put(s.substring(0,index),s.substring(index+1));
            }

        }
        System.out.println(memberLevelInfoMap);

    }

    private static void test2(String s, String s2, String s3, String s4, String s5, String s6) {
        String r = s;
        Pattern pattern = Pattern.compile(r);
        System.out.println(pattern.matcher(s2).matches());
        System.out.println(pattern.matcher(s3).matches());
        System.out.println(pattern.matcher(s4).matches());
        System.out.println(pattern.matcher(s5).matches());
        System.out.println(pattern.matcher(s6).matches());
    }

    private static void test() {
        test2("^(.*_.*)+(.*_.*/|)*", "1_2|", "1_2", "1_2;2_3", "1_2;2_;", "1111");
    }
}
