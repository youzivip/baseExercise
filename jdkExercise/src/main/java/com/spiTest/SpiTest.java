package com.spiTest;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<PrintService> services =  ServiceLoader.load(PrintService.class);
        for (PrintService service:services){
            service.printInfo();
        }
    }
}
