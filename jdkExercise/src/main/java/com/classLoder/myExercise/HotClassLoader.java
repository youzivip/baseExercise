package com.classLoder.myExercise;

import java.io.*;

/**
 * 热加载，需要一个ClassLoader
 * ClassLoader要继承findClass,需要写一个流获取到class
 */
public class HotClassLoader  extends ClassLoader{
    private String classPath;

    public HotClassLoader( String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = new byte[0];
        try {
            data = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.defineClass(name,data,0,data.length);
    }

    /**
     * 将class文件读成流
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            name = name.replace(".","/");
            FileInputStream in = new FileInputStream(new File(classPath+name+".class"));
            int i = 0;
            while ((i = in.read())!=-1){
                out.write(i);
            }
            in.close();
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
