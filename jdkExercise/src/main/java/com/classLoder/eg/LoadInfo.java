package com.classLoder.eg;

import lombok.Data;

@Data
public class LoadInfo {
    private long loadTime;

    private BaseManager baseManager ;

    private MyClassLoader myClassLoader;

    public LoadInfo(long loadTime, MyClassLoader myClassLoader) {
        this.loadTime = loadTime;
        this.myClassLoader = myClassLoader;
    }


}
