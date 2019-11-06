package com.classLoder.eg;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    private String calssPath;

    public MyClassLoader( String calssPath) {
        super(ClassLoader.getSystemClassLoader());
        this.calssPath = calssPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name){
        try {
            name = name.replace(".","/");
            FileInputStream in = new FileInputStream(new File(calssPath+name+".class"));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b = 0;
            while ((b = in.read()) != -1){
                out.write(b);
            }
            in.close();
            return out.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
      return null;

    }
}
