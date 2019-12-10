package com.compilerTest;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistTest {
    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("Hello World");
        CtMethod ctMethod = CtNewMethod.make("public static void test(){" +
                " System.out.println(\"hello world\");"+
                "}",ctClass);
        ctClass.addMethod(ctMethod);
        Class clz = ctClass.toClass();

        Object obj = clz.newInstance();
        Method m = clz.getMethod("test",null);
        m.invoke(obj);
    }
}
