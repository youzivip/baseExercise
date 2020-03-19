package com.dynamicTest.loopDynmTest;

import java.lang.reflect.Proxy;
/**
 * 两层动态代理嵌套
 * 动态代理就是为了生成一个可以动态变化的对象，做一些个性化的处理，个性化的处理写在InvocationHandler里
 * 无论何时何地，想要得到对象都可以动态代理呗
 */
public class DynamicDealTest {
    public static void main(String[] args) {
        DynamicDealTest dynamicDealTest = new DynamicDealTest();
        CarFactory carFactory = dynamicDealTest.execute();
        Car car = carFactory.newCar();
        car.run("wuwuwuw");
        car.stop("horse");
    }

    public CarFactory execute(){
        CarFactory carFactory = new CarFactoryImpl();
        CarFactory carFactoryP = (CarFactory) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                CarFactoryImpl.class.getInterfaces(),((proxy, method, args) -> {
                    if (method.getName().equals("newCar")){
                        Car car = (Car) method.invoke(carFactory,args);
                        Car carP = (Car)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                                CarImpl.class.getInterfaces(),(proxy1,method1,args1)->{
                                    if(method1.getName().equals("run")){
                                        args1[0] = args1[0]+"啦啦啦";
                                    }
                                    return method1.invoke(car,args1);
                                });
                        return carP;   //一定要return，不然new出来的不是代理的对象
                    }
                    return method.invoke(carFactory,args);
                }));
        return carFactoryP;
    }
}
