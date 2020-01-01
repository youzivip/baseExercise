package com.annotionTest;

import com.sun.xml.internal.rngom.digested.DDataPattern;
import lombok.val;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnotionProcessor {
    private volatile Annotation[] parameterAnnotations;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        List<Integer> useCases = new ArrayList<Integer>();
//        Collections.addAll(useCases, 123, 48, 49, 50);
//        trackUseCases(useCases, ToAnnotation.class);

        ToAnnotation toAnnotation = new ToAnnotation();
     //  toAnnotation.testParamA("12",2);
        trackUseParam(ToAnnotation.class,toAnnotation);

    }


    public static void trackUseParam(Class<?> cl,ToAnnotation obj) throws InvocationTargetException, IllegalAccessException {
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解的对象
            Annotation[][] uc = m.getParameterAnnotations();


            for (int i = 0; i < uc.length; i++) {
               // System.out.println(uc[i]);
                for (int j= 0;j<uc[i].length;j++){
                    if(uc[i][j].annotationType().equals(ParamAnnotation.class)){
                        ParamAnnotation p = ((ParamAnnotation)uc[i][j]);
                        System.out.println(p.num());
                        m.invoke(obj,p.num(),1);
                        System.out.println(m.getParameters()[i]);
                    }

               //     System.out.println(uc[i][j].annotationType());

                }
            }


        }
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解的对象
            RunTimeAnnotation uc = m.getAnnotation(RunTimeAnnotation.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " ");
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
}
