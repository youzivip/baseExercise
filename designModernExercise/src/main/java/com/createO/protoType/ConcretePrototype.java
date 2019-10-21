package com.createO.protoType;

public class ConcretePrototype implements ProtoType{

    public Object clone() {
        ProtoType protoType =  new ConcretePrototype();
        return protoType;
    }
}
