package com.classLoder.myExercise;

//需要一个线程，不断的将类进行加载
public class ClassLoaderTest {
    private static final String CLASS_PATH="E:/project-myTest/baseExercise/jdkExercise/target/classes/";
    //实现热加载的类的全名称,包名+类名
    public static final String MY_MANAGER="com.classLoder.myExercise.ToBeLoaded";
    public static void main(String[] args) {
        System.out.println("我开始执行呀");
        HotClassLoader hotClassLoader = new HotClassLoader(CLASS_PATH);
        new Thread(()->{
            try {
                while (true){
                    Class clz = hotClassLoader.loadClass(MY_MANAGER);
                    ToBeLoaded toBeLoaded = (ToBeLoaded) clz.newInstance();
                    toBeLoaded.p();
                    Thread.sleep(3000);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
