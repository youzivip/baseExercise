package com.dynamicTest.loopDynmTest;

public class CarFactoryImpl implements CarFactory {
    @Override
    public Car newCar() {
        Car car = new CarImpl();
        return car;
    }
}
